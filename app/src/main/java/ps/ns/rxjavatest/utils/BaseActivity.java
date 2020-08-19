package ps.ns.rxjavatest.utils;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements BaseView {


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, "MESSAGE: " + msg, Toast.LENGTH_SHORT).show();
    }
}
