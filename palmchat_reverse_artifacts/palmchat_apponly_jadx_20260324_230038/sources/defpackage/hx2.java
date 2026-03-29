package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hx2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends yw2 {
        public Context c;
        public JSONObject d;

        public a(Context context, JSONObject jSONObject) {
            this.c = context;
            this.d = jSONObject;
            this.f22293a = "JWakeCmd#WakeAction";
        }

        @Override // defpackage.yw2
        public void a() {
            try {
                long jK = kv2.k(this.c, "JWakeCmdcmd");
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = this.d;
                if (jSONObject != null || jCurrentTimeMillis - jK >= 3600000) {
                    hx2.c(this.c, jSONObject);
                } else {
                    p63.f("JWakeCmd", "is not cmd wake time");
                }
            } catch (Throwable th) {
                p63.f("JWakeCmd", "WakeAction failed:" + th.getMessage());
            }
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                p63.a("JWakeCmd", "executeWakeAction: [JWakeCmd] from heartBeat");
            } else {
                p63.a("JWakeCmd", "executeWakeAction: [JWakeCmd] from cmd");
            }
            boolean zBooleanValue = ((Boolean) gx2.k(context)).booleanValue();
            p63.a("JWakeCmd", "JWakeCmd isActionUserEnable:" + zBooleanValue);
            if (zBooleanValue) {
                rv2.F(new a(context, jSONObject));
            }
        } catch (Throwable th) {
            p63.g("JWakeCmd", "[executeWakeAction] failed:" + th.getMessage());
        }
    }

    public static void c(Context context, JSONObject jSONObject) {
        List<rx2> arrayList;
        ApplicationInfo applicationInfo;
        try {
            if (!mx2.c()) {
                LogUtil.d("JWakeCmd", "LX forbidden launcher other app b");
                return;
            }
            kv2.E(context, "JWakeCmdcmd");
            String strB = mv2.b(context, "bwct.catch.v2");
            p63.a("JWakeCmd", "read cmd wakeTarget:" + strB);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    int iOptInt = jSONObject2.optInt("type", 1);
                    String strOptString = jSONObject2.optString("pkgName", "");
                    String strOptString2 = jSONObject2.optString("serviceName", "");
                    int iOptInt2 = jSONObject2.optInt("delay_time");
                    arrayList = null;
                    if (iOptInt == 1) {
                        try {
                            applicationInfo = context.getPackageManager().getApplicationInfo(strOptString, 128);
                        } catch (Throwable unused) {
                            p63.g("JWakeCmd", "not found application:" + strOptString);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            arrayList = new ArrayList<>();
                            rx2 rx2Var = new rx2();
                            rx2Var.f20619a = strOptString;
                            rx2Var.b = strOptString2;
                            rx2Var.c = applicationInfo.targetSdkVersion;
                            rx2Var.h = 1;
                            rx2Var.i = iOptInt2;
                            rx2Var.f = 4;
                            arrayList.add(rx2Var);
                        }
                    }
                    String strG = mx2.g(ox2.a(strB, strOptString, strOptString2, iOptInt));
                    p63.a("JWakeCmd", "write cmd wakeTarget:" + strG);
                    mv2.d(context, "bwct.catch.v2", strG);
                } catch (Throwable th) {
                    p63.f("JWakeCmd", "stop wake,the json form cmd is illegal:" + th.getMessage());
                    return;
                }
            } else {
                if (strB == null || TextUtils.isEmpty(strB)) {
                    p63.f("JWakeCmd", "there are no cache cmd wakeTarget");
                    return;
                }
                arrayList = mx2.e(context, mx2.f(strB));
            }
            if (arrayList != null) {
                sx2.d().a(context, new kx2(), arrayList);
            }
        } catch (Throwable th2) {
            p63.f("JWakeCmd", "parse throwable:" + th2.getMessage());
        }
    }
}
