package com.shaleenjain.androidboilerplate.data.remote;

import java.util.List;

import com.shaleenjain.androidboilerplate.data.model.Ribot;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RibotsService {

    String ENDPOINT = "https://api.ribot.io/";

    @GET("ribots")
    Observable<List<Ribot>> getRibots();

}
