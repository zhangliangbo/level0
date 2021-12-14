package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class BatchClassifier {
    public static void main(String[] args) throws Exception {
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File("D:\\Program Files\\Weka-3-8-5\\data\\weather.nominal.arff"));
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        String[] options = new String[1];
        options[0] = "-U";
        J48 tree = new J48();
        tree.setOptions(options);
        tree.buildClassifier(data);
        log.info("tree\n{}", tree);
    }
}
