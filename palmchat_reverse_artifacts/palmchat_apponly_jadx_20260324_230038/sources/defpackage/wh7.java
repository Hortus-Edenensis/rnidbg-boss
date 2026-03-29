package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class wh7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f21710a;

    public wh7(Context context) {
        this.f21710a = nr.nr(context, "npth", 0);
    }

    public String a() {
        String strD = uh7.j().d();
        return (TextUtils.isEmpty(strD) || "0".equals(strD)) ? this.f21710a.getString("device_id", "0") : strD;
    }

    public void b(String str) {
        this.f21710a.edit().putString("device_id", str).apply();
    }
}
