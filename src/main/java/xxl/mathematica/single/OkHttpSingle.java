package xxl.mathematica.single;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttpSingle {

    public static OkHttpClient instance() {
        return Holder.client;
    }

    private static class Holder {
        private static final OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();
    }
}
