package zijing.com.databindingtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import zijing.com.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(new BindingStuff.User("zijing", "zhao"));
        binding.setHandler(new BindingStuff());
        binding.setActivity(this);
    }

    public void gotoListView(View view) {
        startActivity(new Intent(MainActivity.this, ListViewActiivity.class));
    }
}
