package zijing.com.databindingtest.oldway;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import zijing.com.databindingtest.R;

/**
 * Created by zijing on 8/4/16.
 */
public class OldSeekBarActivity extends AppCompatActivity {

    SeekBar seekBar1;
    SeekBar seekBar2;
    int commonProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_seekbar);

        seekBar1 = (SeekBar) findViewById(R.id.old_activity_seekbar_progress1);
        seekBar2 = (SeekBar) findViewById(R.id.old_activity_seekbar_progress2);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress != commonProgress) {
                    seekBar2.setProgress(progress);
                }
                commonProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress != commonProgress) {
                    seekBar1.setProgress(progress);
                }
                commonProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
