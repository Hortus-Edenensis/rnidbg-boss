package com.zm.fissionsdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.zm.adxsdk.WfFileProvider;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.bridge.IHostBridge;
import com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zV2WW implements IHostBridge {
    public static zV2WW d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16758a;
    public WfConfig b;
    public IWfReporter c;

    public void a(Context context) {
        if (context != null) {
            this.f16758a = context.getApplicationContext();
        }
    }

    public boolean b() {
        return TextUtils.equals(getFlavor(), "fission");
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public IActivityLifecycle getActivityLifecycle() {
        return zZZ2W.b();
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public Context getContext() {
        return this.f16758a;
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public String getFlavor() {
        return "fission";
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public IWfReporter getReporter() {
        return this.c;
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public int getSdkVersionCode() {
        return z2zz2.f;
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public String getSdkVersionName() {
        return z2zz2.g;
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public Uri getUriForFile(Context context, File file) {
        return WfFileProvider.a(context, file);
    }

    @Override // com.zm.adxsdk.protocol.bridge.IHostBridge
    public WfConfig getWfConfig() {
        return this.b;
    }

    public void a(IWfReporter iWfReporter) {
        this.c = iWfReporter;
    }

    public void a(WfConfig wfConfig) {
        this.b = wfConfig;
    }

    public static zV2WW a() {
        if (d == null) {
            synchronized (zV2WW.class) {
                if (d == null) {
                    d = new zV2WW();
                }
            }
        }
        return d;
    }
}
