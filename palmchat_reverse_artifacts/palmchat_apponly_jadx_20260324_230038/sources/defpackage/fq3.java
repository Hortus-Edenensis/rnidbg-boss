package defpackage;

import android.app.Activity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fq3 {
    public static void a(Activity activity, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("?from=" + i);
        sb.append("&fromSource=" + i2);
        ve.A(activity, "personal-info", sb.toString(), Boolean.FALSE, null, false, null);
    }
}
