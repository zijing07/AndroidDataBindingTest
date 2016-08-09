package zijing.com.databindingtest.newway;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import zijing.com.databindingtest.R;
import zijing.com.databindingtest.databinding.ActivityDisplayModelBinding;

public class DisplayModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDisplayModelBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_display_model);

        RecyclerViewActivity.UserModel userModel = new RecyclerViewActivity.UserModel("老张", "逸帅");

        binding.setUser(userModel);
    }
}
