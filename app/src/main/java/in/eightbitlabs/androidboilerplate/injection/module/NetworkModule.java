package in.eightbitlabs.androidboilerplate.injection.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.eightbitlabs.androidboilerplate.data.LoggingInterceptor;
import in.eightbitlabs.androidboilerplate.data.model.MyGsonTypeAdapterFactory;
import in.eightbitlabs.androidboilerplate.data.remote.RibotsService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides network related dependencies
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    @Provides
    @Singleton
    RibotsService provideTodoServiceService(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(RibotsService.ENDPOINT)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RibotsService.class);
    }
}
