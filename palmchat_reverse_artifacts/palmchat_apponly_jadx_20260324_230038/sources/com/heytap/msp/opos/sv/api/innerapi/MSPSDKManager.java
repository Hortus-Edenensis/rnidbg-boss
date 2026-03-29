package com.heytap.msp.opos.sv.api.innerapi;

import android.content.Context;
import com.heytap.mspsdk.MspSdk;
import com.opos.cmn.an.f.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MSPSDKManager {
    private static final String TAG = "MSPSDKManager";
    private static volatile MSPSDKManager sInstance;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);

    private MSPSDKManager() {
    }

    public static MSPSDKManager getInstance() {
        if (sInstance == null) {
            synchronized (MSPSDKManager.class) {
                if (sInstance == null) {
                    sInstance = new MSPSDKManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized void initIfNeed(Context context) {
        if (this.mInitialized.compareAndSet(false, true)) {
            try {
                MspSdk.init(context.getApplicationContext());
            } catch (Throwable th) {
                a.c(TAG, "initIfNeed", th);
            }
        }
    }
}
