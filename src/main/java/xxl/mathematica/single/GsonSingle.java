package xxl.mathematica.single;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class GsonSingle {

    public static Gson instance() {
        return Holder.gson;
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

}
