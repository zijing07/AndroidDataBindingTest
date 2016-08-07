package zijing.com.databindingtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zijing.com.databindingtest.databinding.ActivitySeekbarBinding;

/**
 * Created by zijing on 8/4/16.
 */
public class SeekBarActivity extends AppCompatActivity {

    public class SeekBarModel extends BaseObservable {
        private int progress;

        @Bindable
        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
            notifyPropertyChanged(zijing.com.databindingtest.BR.progress);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySeekbarBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_seekbar);
        binding.setSeekBarModel(new SeekBarModel());
    }
}
