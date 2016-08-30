package zijing.com.databindingtest.oldway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import zijing.com.databindingtest.R;
import zijing.com.databindingtest.newway.RecyclerViewActivity;

public class OldDisplayModelActivity extends AppCompatActivity {

    TextView firstName;
    TextView lastName;
    View footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_display_model);

        RecyclerViewActivity.UserModel userModel = new RecyclerViewActivity.UserModel("老张", "逸帅");

        firstName = (TextView) findViewById(R.id.old_activity_display_model_tv_firstname);
        lastName = (TextView) findViewById(R.id.old_activity_display_model_tv_lastname);
        footerView = findViewById(R.id.old_activity_display_model_view_footer);

        firstName.setText(userModel.getFirstName());
        lastName.setText(userModel.getLastName());
        ((TextView) footerView.findViewById(R.id.layout_footer_tv_firstname)).setText(userModel.getFirstName());
        ((TextView) footerView.findViewById(R.id.layout_footer_tv_lastname)).setText(userModel.getLastName());
    }
}
