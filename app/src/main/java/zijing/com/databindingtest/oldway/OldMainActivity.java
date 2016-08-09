package zijing.com.databindingtest.oldway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zijing.com.databindingtest.R;

public class OldMainActivity extends AppCompatActivity {

    private Button buttonDisplayModelActivity;
    private Button buttonSeekBarAcitivty;
    private Button buttonRecyclerViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_main);

        buttonDisplayModelActivity = (Button) findViewById(R.id.old_activity_main_btn_display_model);
        buttonSeekBarAcitivty = (Button) findViewById(R.id.old_activity_main_btn_seekbar);
        buttonRecyclerViewActivity = (Button) findViewById(R.id.old_activity_main_btn_recycler_view);

        buttonDisplayModelActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OldMainActivity.this, OldDisplayModelActivity.class));
            }
        });

        buttonRecyclerViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OldMainActivity.this, OldRecyclerViewActivity.class));
            }
        });

        buttonSeekBarAcitivty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OldMainActivity.this, OldSeekBarActivity.class));
            }
        });
    }
}
