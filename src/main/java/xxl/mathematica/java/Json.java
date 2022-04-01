package xxl.mathematica.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhangliangbo
 * @since 2022/4/1
 */
@Slf4j
public class Json {

    public static List<String> flat(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
            return build(map);
        } catch (JsonProcessingException e) {
            log.info("转换报错", e);
            return new LinkedList<>();
        }
    }

    public static List<String> flatFile(String file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> map = objectMapper.readValue(new File(file), new TypeReference<Map<String, Object>>() {
            });
            return build(map);
        } catch (IOException e) {
            log.info("转换报错", e);
            return new LinkedList<>();
        }
    }

    private static List<String> build(Map<String, Object> map) {
        List<String> res = new LinkedList<>();
        buildOne(map, null, res);
        return res;
    }

    private static void buildOne(Object object, String path, List<String> res) {
        if (object instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) object;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String currentPath = entry.getKey();
                String nextPath = Objects.isNull(path) ? currentPath : String.join(".", path, currentPath);
                buildOne(entry.getValue(), nextPath, res);
            }
        } else {
            String value = String.valueOf(object);
            String leaf = Objects.isNull(path) ? value : String.join("=", path, value);
            res.add(leaf);
        }
    }

}
