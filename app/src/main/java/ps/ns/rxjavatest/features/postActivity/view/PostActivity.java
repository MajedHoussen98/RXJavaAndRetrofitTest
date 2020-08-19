package ps.ns.rxjavatest.features.postActivity.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ps.ns.rxjavatest.databinding.ActivityPostBinding;
import ps.ns.rxjavatest.features.postActivity.presenter.PostActivityPresenter;
import ps.ns.rxjavatest.network.asp.model.RestaurantModel;

public class PostActivity extends AppCompatActivity implements PostActivityView {
    PostActivityPresenter presenter;
    private ActivityPostBinding binding;
    private ArrayList<RestaurantModel> list;
    private View view;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        getRestaurantData();
    }

    private void initView() {
        list = new ArrayList<>();
        presenter = new PostActivityPresenter(this, this);
    }

    private void getRestaurantData(){
        presenter.getRestaurantData(binding.rvPost);
    }

    @Override
    public void showMessage(String msg) {

    }
}