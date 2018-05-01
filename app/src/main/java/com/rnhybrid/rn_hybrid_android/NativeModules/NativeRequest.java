package com.rnhybrid.rn_hybrid_android.NativeModules;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;


public class NativeRequest extends ReactContextBaseJavaModule {

    private final ReactActionCallback callback;

    public NativeRequest(ReactApplicationContext reactContext, ReactActionCallback callback) {
        super(reactContext);
        this.callback = callback;
    }

    @Override
    public String getName() {
        return "NativeRequest";
    }

    @ReactMethod
    public void send(String action, @Nullable ReadableMap data) {
        callback.onActionSent(action, data);
    }

}
