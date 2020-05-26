package xxl.mathematica.single;

import com.google.gson.*;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GsonSingle {

    public static Gson instance() {
        return Holder.gson;
    }

    public static Gson oneLevelInstance() {
        return OneLevelHolder.gson;
    }

    static class Holder {
        static Gson gson = new GsonBuilder().registerTypeAdapterFactory(new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                return null;
            }
        }).create();

        static {
            //解决GSON默认数字类型默认转成Double
            try {
                Field factories = Gson.class.getDeclaredField("factories");
                factories.setAccessible(true);
                Object o = factories.get(gson);
                Class<?>[] declaredClasses = Collections.class.getDeclaredClasses();
                for (Class<?> c : declaredClasses) {
                    if ("java.util.Collections$UnmodifiableList".equals(c.getName())) {
                        Field listField = c.getDeclaredField("list");
                        listField.setAccessible(true);
                        List<TypeAdapterFactory> list = (List<TypeAdapterFactory>) listField.get(o);
                        int i = list.indexOf(ObjectTypeAdapter.FACTORY);
                        list.set(i, MapTypeAdapter.FACTORY);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class OneLevelHolder {
        static ExclusionStrategy serialEs = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return !f.getDeclaredClass().isPrimitive() &&
                        !f.getDeclaredClass().equals(String.class) &&
                        !f.getDeclaredClass().isAssignableFrom(Date.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        static ExclusionStrategy deSerialEs = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return !f.getDeclaredClass().isPrimitive() &&
                        !f.getDeclaredClass().equals(String.class) &&
                        !f.getDeclaredClass().isAssignableFrom(Date.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        static Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(serialEs)
                .addDeserializationExclusionStrategy(deSerialEs)
                .create();
    }

}
