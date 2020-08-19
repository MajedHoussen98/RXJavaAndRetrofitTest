package ps.ns.rxjavatest.features.postActivity.presenter;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.rxjavatest.features.postActivity.adapter.PostAdapter;
import ps.ns.rxjavatest.features.postActivity.view.PostActivityView;
import ps.ns.rxjavatest.network.asp.features.General;
import ps.ns.rxjavatest.network.asp.features.NetworkShared;
import ps.ns.rxjavatest.network.asp.model.RestaurantModel;
import ps.ns.rxjavatest.network.utils.RequestListener;
import ps.ns.rxjavatest.utils.BaseActivity;

public class PostActivityPresenter {
    private PostActivityView mView;
    private Activity mActivity;
    private BaseActivity activity = new BaseActivity();
    private General general = new General();
    private NetworkShared.ASP asp = new NetworkShared.ASP();

    public PostActivityPresenter(PostActivityView mView, Activity mActivity, BaseActivity activity) {
        this.mView = mView;
        this.mActivity = mActivity;
        this.activity = activity;
    }

    public PostActivityPresenter(PostActivityView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

//    public void getRestaurantData(RecyclerView recyclerView) {
//        general.restaurantResponse(new RequestListener<ArrayList<RestaurantModel>>() {
//            @Override
//            public void onSuccess(ArrayList<RestaurantModel> data) {
//                PostAdapter adapter = new PostAdapter(mActivity, data);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFail(String message, int code) {
//
//            }
//        });
//
//    }

    public void getRestaurantData(RecyclerView recyclerView) {
        asp.getRestaurant().restaurantResponse(new RequestListener<ArrayList<RestaurantModel>>() {
            @Override
            public void onSuccess(ArrayList<RestaurantModel> data) {
                PostAdapter adapter = new PostAdapter(mActivity, data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                mView.showMessage(message + code);
            }
        });
    }

}
