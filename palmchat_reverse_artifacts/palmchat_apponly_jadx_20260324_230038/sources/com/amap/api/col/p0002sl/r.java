package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Message;
import com.amap.api.col.p0002sl.fs;
import com.amap.api.maps2d.MapsInitializer;
import com.huawei.openalliance.ad.constant.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class r extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3046a;
    private ah b;

    public r(Context context, ah ahVar) {
        this.f3046a = context;
        this.b = ahVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (MapsInitializer.getNetworkEnable()) {
                fx.a().a(this.f3046a);
                gd gdVarA = ct.a();
                fs.b bVarA = fs.a(this.f3046a, gdVarA, "11K" + x.aQ + "145");
                if (fs.f2791a != 1) {
                    Message messageObtainMessage = this.b.getMainHandler().obtainMessage();
                    messageObtainMessage.what = 2;
                    String str = bVarA.c;
                    if (str != null) {
                        messageObtainMessage.obj = str;
                    }
                    this.b.getMainHandler().sendMessage(messageObtainMessage);
                }
                if (bVarA != null) {
                    if (bVarA.g != null) {
                        ct.a().a(bVarA.g.f2794a);
                    }
                    JSONObject jSONObject = bVarA.f2793a;
                    if (jSONObject != null) {
                        int i = z.q;
                        if (jSONObject.has("t")) {
                            i = jSONObject.getInt("t");
                        }
                        bp.a();
                        bp.b("period_day", i);
                        if (jSONObject.has("able")) {
                            boolean zA = fs.a(jSONObject.getString("able"), false);
                            bp.a();
                            bp.a("UpdateDataActiveEnable", zA);
                            MapsInitializer.setUpdateDataActiveEnable(zA);
                        }
                        if (jSONObject.has("oi")) {
                            z.a(fs.a(jSONObject.getString("oi"), false));
                        }
                    }
                }
                z.p = gdVarA;
                hd.a(this.f3046a, gdVarA);
                interrupt();
            }
        } catch (Throwable th) {
            interrupt();
            hd.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }
}
