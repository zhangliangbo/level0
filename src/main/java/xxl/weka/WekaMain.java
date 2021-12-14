package xxl.weka;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 * @author zhangliangbo
 * @since 2021/12/4
 **/


public class WekaMain {
    public static void main(String[] args) throws Exception {
        Instances instances = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\cpu.arff");
        System.err.println(instances);
    }
}
