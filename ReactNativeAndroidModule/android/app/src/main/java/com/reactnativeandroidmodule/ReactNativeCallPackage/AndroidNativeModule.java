package com.reactnativeandroidmodule.ReactNativeCallPackage;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

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
}
