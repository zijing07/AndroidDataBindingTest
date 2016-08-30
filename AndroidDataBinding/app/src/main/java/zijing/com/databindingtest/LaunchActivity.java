package zijing.com.databindingtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zijing.com.databindingtest.databinding.ActivityLaunchBinding;
import zijing.com.databindingtest.newway.MainActivity;
import zijing.com.databindingtest.oldway.OldMainActivity;

public class LaunchActivity extends AppCompatActivity {

    ActivityLaunchBinding binding;

    public class Presenter {
        public void gotoNewMainActivity(View view) {
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
        }
        public void gotoOldMainActivity(View view) {
            startActivity(new Intent(LaunchActivity.this, OldMainActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_launch);
        binding.setPresenter(new Presenter());
    }
}
