package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.lantern.auth.server.WkParams;
import com.qq.gdt.action.ActionUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.umcrash.custommapping.UAPMCustomMapping;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class gi extends gn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2829a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    protected byte[] j;

    public gi(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final byte[] h() {
        byte[] bArr = this.j;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ActionUtils.METHOD, "create");
            jSONObject.put("package_name", fr.c(this.k));
            jSONObject.put(WkParams.MODEL, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", AnalyticsConstants.SDK_TYPE);
            jSONObject.put("sdk_version", "4.3.13");
            String strA = gj.a();
            this.f2829a = strA;
            jSONObject.put("t1", strA);
            String strB = gj.b();
            this.b = strB;
            jSONObject.put("t2", strB);
            String strC = gj.c();
            this.c = strC;
            jSONObject.put("t3", strC);
            String strD = gj.d();
            this.d = strD;
            jSONObject.put(UAPMCustomMapping.STRING_PARAM_1, strD);
            String strE = gj.e();
            this.e = strE;
            jSONObject.put(UAPMCustomMapping.STRING_PARAM_2, strE);
            String strF = gj.f();
            this.f = strF;
            jSONObject.put(UAPMCustomMapping.STRING_PARAM_3, strF);
            String strG = gj.g();
            this.g = strG;
            jSONObject.put(UAPMCustomMapping.STRING_PARAM_4, strG);
            jSONObject.put(Constant.MAP_KEY_UUID, gj.a(this.k));
            jSONObject.put("android_id", fv.g());
            jSONObject.put("hostname", gj.h());
            String strT = fv.t(this.k);
            this.h = strT;
            jSONObject.put("gaid", strT);
            String strE2 = fv.e(this.k);
            this.i = strE2;
            jSONObject.put("oaid", strE2);
            this.j = gj.a(ge.d(jSONObject.toString().getBytes("utf-8")), ge.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.j;
    }
}
