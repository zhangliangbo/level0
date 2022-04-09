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
        //初始化加载器
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File("D:\\Program Files\\Weka-3-8-5\\data\\weather.nominal.arff"));
        //全量加载
        Instances data = loader.getDataSet();
        //设置类别属性
        data.setClassIndex(data.numAttributes() - 1);
        //设置选项
        String[] options = new String[1];
        options[0] = "-U";
        J48 classifier = new J48();
        classifier.setOptions(options);
        //构建分类器
        classifier.buildClassifier(data);
        log.info("j48\n{}", classifier);
    }
}
