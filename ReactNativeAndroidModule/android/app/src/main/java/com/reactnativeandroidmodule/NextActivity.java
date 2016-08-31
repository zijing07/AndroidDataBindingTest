package com.reactnativeandroidmodule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zijing on 16/8/31.
 */

public class NextActivity extends Activity {

    private TextView nextStepTextView;
    private View nextStepButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        nextStepTextView = (TextView) findViewById(R.id.next_step);

        final int number = getIntent().getIntExtra("next", 0);
        nextStepTextView.setText(number + "");

        nextStepButton = findViewById(R.id.next_button);
        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextActivity.this, NextActivity.class);
                intent.putExtra("next", number+1);
                startActivity(intent);
            }
        });
    }
}
