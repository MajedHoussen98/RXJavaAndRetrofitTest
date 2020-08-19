package ps.ns.rxjavatest.network.utils;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApis {


    @GET("restaurants")
    Observable<AppResponse> getRestaurant();
}
