package defpackage;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class nx2 {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        boolean z;
        boolean z2;
        String strM = kv2.m(context);
        boolean zS = kv2.s(context);
        int i = 1;
        boolean z3 = false;
        if (!TextUtils.isEmpty(strM)) {
            if (TextUtils.equals("ON", strM)) {
                z = false;
            } else if (TextUtils.equals("OFF", strM)) {
                z = false;
                z2 = false;
                if (!z) {
                    p63.a("JWakeLocalState", "local wake state do not changed");
                    z3 = z;
                } else if (z2 != zS) {
                }
            } else {
                z = true;
            }
            z2 = true;
            if (!z) {
            }
        } else if (!zS) {
            z3 = true;
        }
        p63.a("JWakeLocalState", "lastCacheWakeState:" + strM + ",userWakeupEnable:" + zS + ",isNeedReport:" + z3);
        if (!z3) {
            p63.a("JWakeLocalState", "do not need report local wake state");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!zS) {
                i = 2;
            }
            jSONObject.put("status", i);
            rv2.b(context, jSONObject, "aals");
            rv2.C(context, jSONObject);
            kv2.G(context, zS ? "ON" : "OFF");
        } catch (Throwable th) {
            p63.f("JWakeLocalState", "report local wake state failed, error:" + th.getMessage());
        }
    }
}
