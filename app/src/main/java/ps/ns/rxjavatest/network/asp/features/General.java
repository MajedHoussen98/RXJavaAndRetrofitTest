package ps.ns.rxjavatest.network.asp.features;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ps.ns.rxjavatest.network.asp.model.PaginationBean;
import ps.ns.rxjavatest.network.asp.model.RestaurantModel;
import ps.ns.rxjavatest.network.utils.RequestListener;
import ps.ns.rxjavatest.network.utils.RetrofitModel;

public class General {

    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";
    public General() {
    }
    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();

    @SuppressLint("CheckResult")
    public void restaurantResponse(RequestListener<ArrayList<RestaurantModel>> listener) {

        retrofitModel.getRestaurant().subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        PaginationBean bean = gson.fromJson(appResponse.getResult(), PaginationBean.class);
                        Type listType = new TypeToken<ArrayList<RestaurantModel>>() {
                        }.getType();
                        ArrayList<RestaurantModel> list = gson.fromJson(bean.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }
}
