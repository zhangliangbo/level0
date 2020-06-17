package xxl;

import xxl.mathematica.map.Association;

import java.util.Arrays;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        PO po = new PO();
        Map<String, Object> association = Association.association(po, Arrays.asList("name", "age"));
        System.err.println(association);
    }
}
