package vishal.benotest.api;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vishal Gaur
 */
@Singleton
public class NetworkClient {

    private Retrofit retrofit;

    @Inject
    public NetworkClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.readTimeout(3, TimeUnit.MINUTES);
        httpClient.writeTimeout(1, TimeUnit.MINUTES);
        httpClient.addInterceptor(logging);

        OkHttpClient client = httpClient.build();
        defaultRetrofit(client);
    }

    private void defaultRetrofit(OkHttpClient client) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public BenoApis createService() {
        return retrofit.create(BenoApis.class);
    }

}
