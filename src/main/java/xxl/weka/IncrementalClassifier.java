package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class IncrementalClassifier {
    public static void main(String[] args) throws Exception {
        //加载训练集
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File("D:\\Program Files\\Weka-3-8-5\\data\\segment-challenge.arff"));
        Instances train = loader.getStructure();
        train.setClassIndex(train.numAttributes() - 1);
        //增量构建分类器
        NaiveBayesUpdateable classifier = new NaiveBayesUpdateable();
        classifier.buildClassifier(train);
        Instance instance;
        while (true) {
            instance = loader.getNextInstance(train);
            if (instance == null) {
                break;
            }
            classifier.updateClassifier(instance);
        }

        //加载测试集
        Instances test = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\segment-test.arff");
        test.setClassIndex(test.numAttributes() - 1);
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
