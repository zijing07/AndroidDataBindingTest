package zijing.com.databindingtest.newway;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zijing.com.databindingtest.R;
import zijing.com.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    public class Presenter {
        public void gotoDisplayModelActivity(View view) {
            startActivity(new Intent(MainActivity.this, DisplayModelActivity.class));
        }

        public void gotoListViewActivity(View view) {
            startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
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
