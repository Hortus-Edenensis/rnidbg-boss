package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.lantern.auth.server.WkParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.xu6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TMNTokenClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TMNTokenClient f2571a;
    public Context b;

    /* JADX INFO: compiled from: SearchBox */
    public interface InitResultListener {
        void onResult(String str, int i);
    }

    public TMNTokenClient(Context context) {
        this.b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f2571a == null) {
            synchronized (TMNTokenClient.class) {
                if (f2571a == null) {
                    f2571a = new TMNTokenClient(context);
                }
            }
        }
        return f2571a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (xu6.c(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (xu6.c(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap map = new HashMap();
        map.put("utdid", UtdidWrapper.getUtdid(this.b));
        map.put("tid", "");
        map.put("userId", "");
        map.put(WfConstant.EVENT_KEY_APP_NAME, str);
        map.put("appKeyClient", str2);
        map.put("appchannel", "openapi");
        map.put(WkParams.SESSIONID, str3);
        map.put("rpcVersion", "8");
        b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int iA = new a(TMNTokenClient.this.b).a(map);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (iA != 0) {
                    initResultListener2.onResult("", iA);
                } else {
                    initResultListener.onResult(a.a(TMNTokenClient.this.b, str), 0);
                }
            }
        });
    }
}
