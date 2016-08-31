package com.reactnativeandroidmodule.ReactNativeCallPackage;

import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativeandroidmodule.NextActivity;

/**
 * Created by zijing on 16/8/30.
 */

public class AndroidNativeModule extends ReactContextBaseJavaModule {
    public AndroidNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "AndroidNativeModule";
    }

    @ReactMethod
    public void makeToast(String message) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void addOne(Integer num, Callback callback) {
        callback.invoke(num + 1);
    }

    @ReactMethod
    public void startActivity() {
        Intent intent = new Intent(getReactApplicationContext(), NextActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getReactApplicationContext().startActivity(intent);
    }
}
