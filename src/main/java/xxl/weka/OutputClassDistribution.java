package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class OutputClassDistribution {
    public static void main(String[] args) throws Exception {
        //加载训练集和测试集
        Instances train = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-challenge.arff");
        Instances test = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-test.arff");
        //设置类别属性
        train.setClassIndex(train.numAttributes() - 1);
        test.setClassIndex(test.numAttributes() - 1);
        if (!train.equalHeaders(test)) {
            throw new Exception("训练集与测试集不兼容" + train.equalHeadersMsg(test));
        }
        //训练分类器
        J48 classifier = new J48();
        classifier.buildClassifier(train);
        //预测测试集
        log.info("{}", String.format("%s %s %s %s %s",
                StringUtils.center("编号", 3),
                StringUtils.center("实际", 12),
                StringUtils.center("预测", 15),
                StringUtils.center("错误", 2),
                StringUtils.center("分布", 40))
        );
        for (int i = 0; i < test.numInstances() - 1; i++) {
            double predicate = classifier.classifyInstance(test.instance(i));
            double[] dist = classifier.distributionForInstance(test.instance(i));
            log.info("{}", String.format("%s %s %s %s %s",
                    StringUtils.center(String.valueOf(i + 1), 3),
                    StringUtils.center(test.instance(i).toString(test.classIndex()), 15),
                    StringUtils.center(test.classAttribute().value((int) predicate), 15),
                    StringUtils.center(predicate != test.instance(i).classValue() ? "是" : "否", 3),
                    StringUtils.center(Arrays.stream(dist).mapToObj(t -> String.format("%.4f", t)).collect(Collectors.joining(",")), 50))
            );
        }
    }
}
