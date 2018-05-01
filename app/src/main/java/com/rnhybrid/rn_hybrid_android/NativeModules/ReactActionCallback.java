package com.rnhybrid.rn_hybrid_android.NativeModules;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReadableMap;

public interface ReactActionCallback {

    void onActionSent(String action, @Nullable ReadableMap data);

}
