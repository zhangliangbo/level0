package xxl.mathematica.single;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

public class GsonSingle {

    public static Gson instance() {
        return Holder.gson;
    }

    static class Holder {
        static Gson gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();
    }

}
