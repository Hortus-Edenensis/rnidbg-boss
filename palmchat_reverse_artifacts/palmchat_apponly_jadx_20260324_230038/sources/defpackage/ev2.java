package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ev2 extends iv2 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile ev2 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17366a;
    public String[] b;

    public static ev2 s() {
        if (c == null) {
            synchronized (ev2.class) {
                if (c == null) {
                    c = new ev2();
                }
            }
        }
        return c;
    }

    @Override // defpackage.iv2
    public void e(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            this.b = strArr;
            if (strArr == null || strArr.length <= 0) {
                p63.a("JAppPermission", "collect failed");
            } else {
                p63.a("JAppPermission", "collect success:" + Arrays.toString(this.b));
            }
        } catch (Throwable th) {
            this.b = null;
            p63.f("JAppPermission", "collect throwable:" + th.getMessage());
        }
    }

    @Override // defpackage.iv2
    public String i(Context context) {
        this.f17366a = context;
        return "JAppPermission";
    }

    @Override // defpackage.iv2
    public boolean n() {
        p63.a("JAppPermission", "for googlePlay:false");
        return true;
    }

    @Override // defpackage.iv2
    public void r(Context context, String str) {
        String[] strArr = this.b;
        if (strArr == null || strArr.length == 0) {
            p63.f("JAppPermission", "there are no data to report");
            return;
        }
        int length = strArr.length;
        StringBuilder sb = new StringBuilder("[");
        String strE = rv2.e(context);
        long jU = rv2.u(context);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            String str2 = this.b[i];
            if (i2 == 0) {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            } else {
                sb.append(",\"");
                sb.append(str2);
                sb.append("\"");
            }
            i++;
            i2++;
            if (i2 >= 50 || sb.length() > 1000 || i == length) {
                sb.append("]");
                String str3 = String.format(Locale.ENGLISH, "{\"total\":%d,\"page\":%d,\"senderid\":\"%s\",\"uid\":%s,\"permission_list\":%s}", Integer.valueOf(length), Integer.valueOf(i3), strE, Long.valueOf(jU), sb.toString());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", str3);
                } catch (JSONException e) {
                    p63.f("JAppPermission", "package json exception:" + e.getMessage());
                }
                rv2.b(context, jSONObject, "android_permissions");
                rv2.C(context, jSONObject);
                super.r(context, str);
                i3++;
                sb = new StringBuilder("[");
                i2 = 0;
            }
        }
        this.b = null;
    }
}
