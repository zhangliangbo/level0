package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AddClassification;

/**
 * @author zhangliangbo
 * @since 2022/4/10
 */
@Slf4j
public class RunWithTest {
    public static void main(String[] args) throws Exception {
        //加载训练集和测试集
        Instances train = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-challenge.arff");
        Instances test = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-test.arff");
        //设置类别属性
        train.setClassIndex(train.numAttributes() - 1);
        test.setClassIndex(test.numAttributes() - 1);
        //设置选项
        String[] options = new String[2];
        options[0] = "-C";
        options[1] = "0.25";
        //初始化分类器
        J48 classifier = new J48();
        classifier.setOptions(options);
        //构建分类器
        classifier.buildClassifier(train);
        //开始评估
        Evaluation evaluation = new Evaluation(train);
        evaluation.evaluateModel(classifier, test);
        log.info("评估结果\n{}", evaluation.toSummaryString());
        //设置预测过滤器，使用过滤器预测
        AddClassification filter = new AddClassification();
        filter.setClassifier(classifier);
        filter.setOutputClassification(true);
        filter.setOutputDistribution(true);
        filter.setOutputErrorFlag(true);
        filter.setInputFormat(train);
        //开始预测
        Instances predicatedData = Filter.useFilter(test, filter);
        //保存预测结果
        ConverterUtils.DataSink.write("D:\\withTest.arff", predicatedData);
    }
}
