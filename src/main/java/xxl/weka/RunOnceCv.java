package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
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
        //打乱数据
        Instances randomData = new Instances(data);
        randomData.randomize(rand);

        if (randomData.classAttribute().isNominal()) {
            randomData.stratify(folds);
        }

        //执行十次交叉验证
        Evaluation eval = new Evaluation(randomData);
        for (int i = 0; i < folds; i++) {
            //分出训练集
            Instances train = randomData.trainCV(folds, i);
            //分出测试集
            Instances test = randomData.testCV(folds, i);
            //复制分类器
            Classifier clsCopy = AbstractClassifier.makeCopy(classifier);
            //通过训练构建分类器
            clsCopy.buildClassifier(train);
            //评估分类器
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
