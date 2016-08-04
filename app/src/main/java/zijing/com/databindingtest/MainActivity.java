package zijing.com.databindingtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zijing.com.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    public class Presenter {
        public void gotoListViewActivity(View view) {
            startActivity(new Intent(MainActivity.this, RecyclerViewActiivity.class));
        }
        public void gotoSeekBarActivity(View view) {
            startActivity(new Intent(MainActivity.this, SeekBarActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(new Presenter());
    }
}
