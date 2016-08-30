package zijing.com.databindingtest.newway;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import zijing.com.databindingtest.R;
import zijing.com.databindingtest.databinding.ActivityLoginActivityBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login_activity);
        binding.setModel(new LoginModel());
    }

    public static class LoginModel extends BaseObservable {
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        @Bindable
        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(zijing.com.databindingtest.BR.name);
        }

        @Bindable
        public void setPassword(String password) {
            this.password = password;
            notifyPropertyChanged(zijing.com.databindingtest.BR.password);
        }
    }

    public static class Validators {
        public static boolean validate(LoginModel model) {
            return model.name != null && model.password != null &&
                    model.name.length() > 0  && model.password.length() > 0;
        }
    }
}
