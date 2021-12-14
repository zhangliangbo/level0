package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class OutputClassDistribution {
    public static void main(String[] args) throws Exception {
        Instances train = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-challenge.arff");
        Instances test = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-test.arff");
        train.setClassIndex(train.numAttributes() - 1);
        test.setClassIndex(test.numAttributes() - 1);
        if (!train.equalHeaders(test)) {
            throw new Exception("训练集与测试集不兼容" + train.equalHeadersMsg(test));
        }
        //训练分类器
        J48 classifier = new J48();
        classifier.buildClassifier(train);
        //输出预测
        log.info("编号\t-\t实际\t-\t预测\t-\t错误\t-\t分布");
        for (int i = 0; i < test.numInstances() - 1; i++) {
            double predicate = classifier.classifyInstance(test.instance(i));
            double[] dist = classifier.distributionForInstance(test.instance(i));
            log.info("{}\t-\t{}\t-\t{}\t-\t{}\t-\t{}",
                    (i + 1),
                    test.instance(i).toString(test.classIndex()),
                    test.classAttribute().value((int) predicate),
                    predicate != test.instance(i).classValue() ? "是" : "否",
                    Utils.arrayToString(dist)
            );
        }
    }
}
