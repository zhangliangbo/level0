package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils;

import java.util.Random;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class RunOnceCv {
    public static void main(String[] args) throws Exception {
        Instances data = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\ionosphere.arff");
        data.setClassIndex(data.numAttributes() - 1);
        String[] options = new String[2];
        String classname = "weka.classifiers.trees.J48";
        options[0] = "-C";
        options[1] = "0.25";
        Classifier classifier = (Classifier) Utils.forName(Classifier.class, classname, options);

        int seed = 1234;
        int folds = 10;

        Random rand = new Random(seed);
        Instances newData = new Instances(data);
        newData.randomize(rand);

        if (newData.classAttribute().isNominal()) {
            newData.stratify(folds);
        }

        Evaluation eval = new Evaluation(newData);
        for (int i = 0; i < folds; i++) {
            Instances train = newData.trainCV(folds, i);
            Instances test = newData.testCV(folds, i);

            Classifier clsCopy = AbstractClassifier.makeCopy(classifier);
            clsCopy.buildClassifier(train);
            eval.evaluateModel(clsCopy, test);
        }

        log.info("分类器设置\n分类器：{}\n数据集：{}\n折数：{}\n随机种子：{}",
                Utils.toCommandLine(classifier),
                data.relationName(),
                folds,
                seed
        );
        log.info("执行结果{}", eval.toSummaryString(folds + "折交叉验证", false));
    }
}
