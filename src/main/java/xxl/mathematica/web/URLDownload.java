package xxl.mathematica.web;

import io.vavr.control.Try;
import okhttp3.Request;
import okhttp3.Response;
import xxl.mathematica.single.OkHttpSingle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * 下载网站内容
 */
public class URLDownload {
    /**
     * 下载网站内容
     *
     * @param url  文件路径
     * @param file 存放目录或文件名
     * @return
     */
    public static String urlDownload(String url, String file, Consumer<Float> progress) {
        return Try.ofCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String dir = System.getProperty("user.home");
                String name = url.substring(url.lastIndexOf("/") + 1);
                if (file != null) {
                    File f = new File(file);
                    if (f.isDirectory()) {
                        if (!f.exists() && !f.mkdirs()) {
                            return null;
                        }
                        dir = f.getAbsolutePath();
                    } else {
                        dir = f.getParent();
                        name = f.getName();
                    }
                }
                Request request = new Request.Builder().url(url).get().build();
                Response response = OkHttpSingle.instance().newCall(request).execute();
                if (!response.isSuccessful()) return null;
                if (response.body() == null) return null;
                InputStream is = response.body().byteStream();
                long total = response.body().contentLength();
                File output = new File(dir, name);
                FileOutputStream fos = new FileOutputStream(output);
                long sum = 0;
                int len;
                byte[] buf = new byte[1024];//1KB的读取
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                    sum += len;
                    if (progress != null) {
                        if (total > 0) {
                            progress.accept(sum * 100f / total);
                        } else {
                            progress.accept(0f);
                        }
                    }
                }
                if (progress != null) {
                    progress.accept(100f);
                }
                fos.flush();
                fos.close();
                is.close();
                return output.getAbsolutePath();
            }
        }).getOrNull();
    }

    /**
     * 默认不显示进度
     *
     * @param url
     * @param file
     * @return
     */
    public static String urlDownload(String url, String file) {
        return urlDownload(url, file, null);
    }

    /**
     * 默认路径，使用路径的文件名
     *
     * @param url
     * @return
     */
    public static String urlDownload(String url) {
        return urlDownload(url, null, null);
    }

    /**
     * 默认路径，使用路径的文件名
     *
     * @param url
     * @param f
     * @return
     */
    public static String urlDownload(String url, Consumer<Float> f) {
        return urlDownload(url, null, f);
    }
}
