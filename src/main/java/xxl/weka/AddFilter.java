package xxl.weka;

import lombok.extern.slf4j.Slf4j;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;

import java.util.Random;

/**
 * @author zhangliangbo
 * @since 2021/12/5
 **/


@Slf4j
public class AddFilter {
    public static void main(String[] args) throws Exception {
        Instances data = ConverterUtils.DataSource.read("D:\\Program Files\\Weka-3-8-5\\data\\weather.numeric.arff");
        Instances result = new Instances(data);
        log.info("raw\n{}", result);

        Add filter = new Add();
        filter.setAttributeIndex("last");
        filter.setAttributeName("NumericAttribute");
        filter.setInputFormat(result);
        result = Filter.useFilter(result, filter);

        filter = new Add();
        filter.setAttributeIndex("last");
        filter.setNominalLabels("A,B,C");
        filter.setAttributeName("NominalAttribute");
        filter.setInputFormat(result);
        result = Filter.useFilter(result, filter);

        Random random = new Random(1234);
        for (int i = 0; i < result.numInstances(); i++) {
            result.instance(i).setValue(result.numAttributes() - 2, random.nextDouble());
            result.instance(i).setValue(result.numAttributes() - 1, random.nextInt(3));
        }
        log.info("过滤后的数据集\n{}", result);
    }
}
