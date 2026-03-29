package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.log.MspLog;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6409a;
    public final Method b;
    public final Object[] c;
    public final com.heytap.mspsdk.core.b d;
    public final com.heytap.mspsdk.event.a e;
    public Bundle f;

    public e(Object obj, Method method, Object[] objArr, com.heytap.mspsdk.core.b bVar, Bundle bundle, com.heytap.mspsdk.event.a aVar) {
        this.f6409a = obj;
        this.b = method;
        this.c = objArr;
        this.d = bVar;
        this.e = aVar;
        this.f = com.heytap.mspsdk.util.c.a(obj, bundle);
    }

    private Bundle b() {
        Bundle bundle = this.f;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE);
        if (bundle2 == null) {
            MspLog.e("InvokeRequest", "commBundle is null");
            return null;
        }
        Bundle bundle3 = bundle2.getBundle(Constants.BUNDLE_KEY_MSP_SDK_IPC_TIME_RECORDER);
        if (bundle3 == null) {
            MspLog.e("InvokeRequest", "timeRecorderBundle is null");
        }
        return bundle3;
    }

    public Bundle a() {
        return this.f;
    }

    public void a(String str) {
        try {
            Bundle bundleB = b();
            if (bundleB != null) {
                bundleB.putLong(str, System.currentTimeMillis());
            } else {
                MspLog.e("InvokeRequest", "timeRecorderBundle is null");
            }
        } catch (Throwable th) {
            MspLog.e(th);
        }
    }
}
