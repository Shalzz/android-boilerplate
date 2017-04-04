package in.eightbitlabs.androidboilerplate.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import in.eightbitlabs.androidboilerplate.data.model.Ribot;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import in.eightbitlabs.androidboilerplate.data.model.Ribot;
import in.eightbitlabs.androidboilerplate.util.MyGsonTypeAdapterFactory;
import io.reactivex.Observable;

public interface RibotsService {

    String ENDPOINT = "https://api.ribot.io/";

    @GET("ribots")
    Observable<List<Ribot>> getRibots();

}
