package xxl.mathematica.external


import org.apache.commons.cli.*
import org.apache.commons.io.IOUtils

class ProcessUtilTest extends GroovyTestCase {
    void testName() {
        def pb = new ProcessBuilder()
        pb.command('java', '-version')
        def p1 = pb.start()
        def result1 = IOUtils.toString(p1.getInputStream(), 'UTF-8')
        println(result1)
        println(p1.exitValue())
    }

    void testCli() {
        Options options = new Options()
        options.addOption(
                Option.builder('i')
                        .longOpt('insert')
                        .desc('insert something')
                        .hasArgs()
                        .argName('p1,p2,p3')
                        .valueSeparator(',' as char)
                        .build()
        )
        options.addOption(Option.builder('u')
                .longOpt('update')
                .desc('update something')
                .hasArg()
                .build())
        options.addOption('d', 'delete', false, 'delete something')
        options.addOption('s', 'select', false, 'select something')
        println(options)
        CommandLineParser parser = new DefaultParser()
        CommandLine commandLine = parser.parse(options, ['-i=a,b,c', '-u=1,2,3'] as String[])
        if (commandLine.hasOption('i')) {
            def values = commandLine.getOptionValues('i')
            println(values)
        }
        if (commandLine.hasOption('u')) {
            def value = commandLine.getOptionValues('u')
            println(value)
        }
        println('end')
    }
}
