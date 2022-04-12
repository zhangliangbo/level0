package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AddClassification;

import java.util.Random;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class RunOnceCv {
    public static void main(String[] args) throws Exception {
        //加载数据集
        Instances data = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\ionosphere.arff");
        //设置类别属性
        data.setClassIndex(data.numAttributes() - 1);
        //设置选项
        String[] options = new String[2];
        options[0] = "-C";
        options[1] = "0.25";
        //初始化分类器
        J48 classifier = new J48();
        classifier.setOptions(options);
        //随机种子和随机器
        int seed = 5555;
        Random rand = new Random(seed);
        //折数
        int folds = 10;
        //进行十折交叉验证
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(classifier, data, folds, rand);
        log.info("评估结果\n{}", evaluation.toSummaryString());
        //假设结果满意，用全量数据训练分类器
        classifier.buildClassifier(data);
        //设置预测过滤器，使用过滤器预测
        AddClassification filter = new AddClassification();
        filter.setClassifier(classifier);
        filter.setOutputClassification(true);
        filter.setOutputDistribution(true);
        filter.setOutputErrorFlag(true);
        filter.setInputFormat(data);
        //开始预测
        Instances predicatedData = Filter.useFilter(data, filter);
        //保存预测结果
        ConverterUtils.DataSink.write("D:\\predications.arff", predicatedData);
    }
}