package xxl.mathematica.external;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import xxl.mathematica.Rule;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class External {

  private static final ProcessBuilder pb = new ProcessBuilder();

  /**
   * 执行命令，并返回执行状态码
   *
   * @param command
   * @return
   * @throws IOException
   */
  public static int run(String command) throws IOException, InterruptedException {
    return run(null, command);
  }

  /**
   * 执行命令，并得到状态码
   *
   * @param dir
   * @param command
   * @return
   * @throws IOException
   */
  public static int run(File dir, String command) throws IOException, InterruptedException {
    if (ObjectUtils.isEmpty(command)) throw new IllegalArgumentException("command is empty");
    String[] commands = command.split(" ");
    pb.directory(dir);
    pb.command(commands);
    Process sub = pb.start();
    return sub.waitFor();
  }

  /**
   * 执行命令，并得到应答
   *
   * @param command
   * @return
   * @throws IOException
   */
  public static Rule<Integer, byte[]> runProcess(String command) throws Exception {
    return runProcess(null, command);
  }

  /**
   * 在指定目录执行命令，并得到应答
   *
   * @param dir
   * @param command
   * @return
   * @throws IOException
   */
  public static Rule<Integer, byte[]> runProcess(String dir, String command) throws Exception {
    if (ObjectUtils.isEmpty(command)) throw new IllegalArgumentException("command is empty");
    String[] commands = command.split(" ");
    if (dir != null) {
      pb.directory(new File(dir));
    }
    pb.command(commands);
    Process sub = pb.start();
    int code = sub.waitFor();
    byte[] in = IOUtils.toByteArray(sub.getInputStream());
    byte[] error = IOUtils.toByteArray(sub.getErrorStream());
    if (ArrayUtils.isEmpty(in)) {
      return Rule.valueOf(code, error);
    } else {
      return Rule.valueOf(code, in);
    }
  }

  /**
   * 发送邮件
   *
   * @param from        发件人地址
   * @param subject     主题
   * @param content     内容
   * @param attachments 附件
   * @param tos         收件人
   * @param ccs         抄送人
   * @param bccs        密送人
   * @param host        邮件服务器地址 smtp.***.com
   * @param username    邮件服务器用户名
   * @param password    邮件服务器密码
   * @return 邮件ID
   * @throws EmailException 发送异常
   */
  public static String sendMail(String from, String subject, String content, List<File> attachments, List<String> tos, List<String> ccs, List<String> bccs, String host, String username, String password) throws EmailException {
    HtmlEmail email = new HtmlEmail();
    // 配置信息
    email.setHostName(host);
    email.setFrom(from, from);
    email.setAuthentication(username, password);
    email.setCharset("UTF-8");
    email.setSubject(subject);
    email.setHtmlMsg(content);

    // 添加附件
    if (null != attachments && attachments.size() > 0) {
      for (File attachment : attachments) {
        EmailAttachment ea = new EmailAttachment();
        ea.setPath(attachment.getAbsolutePath());
        ea.setName(attachment.getName());
        email.attach(attachment);
      }
    }

    // 收件人
    if (null != tos && tos.size() > 0) {
      for (String to : tos) {
        email.addTo(to);
      }
    }
    // 抄送人
    if (null != ccs && ccs.size() > 0) {
      for (String cc : ccs) {
        email.addCc(cc);
      }
    }
    //邮件模板 密送人
    if (null != bccs && bccs.size() > 0) {
      for (String bcc : bccs) {
        email.addBcc(bcc);
      }
    }
    return email.send();
  }

  /**
   * 发送邮件
   *
   * @param from
   * @param subject
   * @param content
   * @param tos
   * @param host
   * @param username
   * @param password
   * @return
   * @throws EmailException
   */
  public static String sendMail(String from, String subject, String content, List<String> tos, String host, String username, String password) throws EmailException {
    return sendMail(from, subject, content, null, tos, null, null, host, username, password);
  }

  /**
   * 发送邮件
   *
   * @param from
   * @param subject
   * @param content
   * @param to
   * @param host
   * @param username
   * @param password
   * @return
   * @throws EmailException
   */
  public static String sendMail(String from, String subject, String content, String to, String host, String username, String password) throws EmailException {
    return sendMail(from, subject, content, null, Arrays.asList(to), null, null, host, username, password);
  }

  /**
   * 发送邮件
   *
   * @param from
   * @param subject
   * @param content
   * @param attachments
   * @param to
   * @param host
   * @param username
   * @param password
   * @return
   * @throws EmailException
   */
  public static String sendMail(String from, String subject, String content, List<File> attachments, String to, String host, String username, String password) throws EmailException {
    return sendMail(from, subject, content, attachments, Arrays.asList(to), null, null, host, username, password);
  }
}
