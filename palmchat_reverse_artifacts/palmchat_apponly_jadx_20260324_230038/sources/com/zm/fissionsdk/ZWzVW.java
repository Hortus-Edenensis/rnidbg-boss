package com.zm.fissionsdk;

import com.zm.adxsdk.TideSdkImpl;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.variant.IWfSdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZWzVW {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ZWzVW f16755a;

    public static ZWzVW a() {
        if (f16755a == null) {
            synchronized (ZWzVW.class) {
                if (f16755a == null) {
                    f16755a = new ZWzVW();
                }
            }
        }
        return f16755a;
    }

    public IWfSdk a(int i, String str, IWfReporter iWfReporter) {
        try {
            TideSdkImpl.getInstance().setSdkVersionCode(i);
            TideSdkImpl.getInstance().setSdkVersionName(str);
            TideSdkImpl.getInstance().setWfReporter(iWfReporter);
            return TideSdkImpl.getInstance();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
