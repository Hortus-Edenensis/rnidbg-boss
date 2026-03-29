package com.umeng.powersdk;

import android.app.Activity;
import android.os.BatteryManager;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11135a;
    int b;
    int c;
    WeakReference<Activity> d;
    boolean e;
    int f;
    boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f11139a = new c(0);
    }

    private c() {
        this.f11135a = 1;
        this.b = 0;
        this.c = 0;
        this.e = true;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            BatteryManager batteryManager = (BatteryManager) PowerManager.getApplicationContext().getSystemService("batterymanager");
            if (batteryManager != null) {
                float longProperty = batteryManager.getLongProperty(2);
                if (longProperty >= 10000.0f || longProperty <= -10000.0f) {
                    longProperty /= 1000.0f;
                }
                jSONObject.put("ci", Math.abs(longProperty));
            }
        } catch (Throwable unused) {
        }
        try {
            com.umeng.powersdk.a aVarA = b.a(PowerManager.getApplicationContext()).a();
            jSONObject.put("le", aVarA.f11132a);
            jSONObject.put("vo", aVarA.b);
            jSONObject.put("te", aVarA.c);
            jSONObject.put("st", aVarA.d);
            jSONObject.put(RedirectReqWrapper.KEY_CHANNEL, aVarA.e);
            jSONObject.put("ts", aVarA.f);
            try {
                long jLongValue = ((Long) GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap().get("stime")).longValue();
                if (jLongValue > 0) {
                    jSONObject.put("ptime", System.currentTimeMillis() - jLongValue);
                }
            } catch (Throwable unused2) {
            }
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null) {
                jSONObject.put("c_act", weakReference.get().getClass().getName());
            }
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    public /* synthetic */ c(byte b) {
        this();
    }
}
