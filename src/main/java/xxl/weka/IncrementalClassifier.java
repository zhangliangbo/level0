package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class IncrementalClassifier {
    public static void main(String[] args) throws Exception {
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File("D:\\Program Files\\Weka-3-8-5\\data\\weather.nominal.arff"));
        Instances structure = loader.getStructure();
        structure.setClassIndex(structure.numAttributes() - 1);

        NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
        nb.buildClassifier(structure);
        Instance instance;
        while ((instance = loader.getNextInstance(structure)) != null) {
            nb.updateClassifier(instance);
        }
        log.info("贝叶斯模型\n{}", nb);
    }
}
