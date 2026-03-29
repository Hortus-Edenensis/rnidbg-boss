package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class zf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8 f22405a;

    public zf7(Context context, String str) {
        this.f22405a = (TextUtils.isEmpty(a(context, str)) || Build.VERSION.SDK_INT < 26) ? new pd7(context, str) : new he7(context, str);
    }

    public final String a(Context context, String str) {
        String strB = ig7.b(context, str, "agc_plugin_", "crypto");
        if (strB == null) {
            return null;
        }
        try {
            return new String(nh2.b(strB), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e.getMessage());
            return null;
        }
    }

    public String b(String str, String str2) {
        return this.f22405a.a(str, str2);
    }
}
