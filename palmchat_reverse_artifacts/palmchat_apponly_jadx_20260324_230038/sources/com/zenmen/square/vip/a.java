package com.zenmen.square.vip;

import com.zenmen.square.vip.VipEnterConfig;
import defpackage.az2;
import defpackage.nl0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static final String b = nl0.z + "/lxmbr.promotionInfo.v1";
    public static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VipEnterConfig f16593a;

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public VipEnterConfig.BaseVipConfig b() {
        VipEnterConfig vipEnterConfig = this.f16593a;
        if (vipEnterConfig == null) {
            return null;
        }
        return vipEnterConfig.discover;
    }

    public VipEnterConfig.VipCenter d() {
        VipEnterConfig vipEnterConfig = this.f16593a;
        if (vipEnterConfig == null) {
            return null;
        }
        return vipEnterConfig.vipCenter;
    }

    public VipEnterConfig e() {
        return this.f16593a;
    }

    public void f() {
        zw4.f(b, 1, null, new C1162a());
    }

    /* JADX INFO: renamed from: com.zenmen.square.vip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1162a extends yw4 {
        public C1162a() {
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            if (jSONObject != null) {
                try {
                    int iOptInt = jSONObject.optInt("resultCode", -1);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (iOptInt != 0 || jSONObjectOptJSONObject == null) {
                        return;
                    }
                    a.this.f16593a = (VipEnterConfig) az2.a(jSONObjectOptJSONObject.toString(), VipEnterConfig.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }
}
