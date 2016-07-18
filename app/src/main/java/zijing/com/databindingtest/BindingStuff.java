package zijing.com.databindingtest;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by zijing on 16/7/18.
 */
public class BindingStuff {

    public void changeUserName(View view, User user) {
        user.firstName.set("fn " + (int) (Math.random() * 100));
        user.lastName.set("ln " + (int) (Math.random() * 100));
    }

    public static class User {
        public ObservableField<String> firstName = new ObservableField<>();
        public ObservableField<String> lastName = new ObservableField<>();

        public User(String fn, String ln) {
            firstName.set(fn);
            lastName.set(ln);
        }
    }
}
