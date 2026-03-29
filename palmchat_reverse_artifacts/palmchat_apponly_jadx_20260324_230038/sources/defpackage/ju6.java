package defpackage;

import android.content.Context;
import com.kuaishou.weapon.p0.bq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ju6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ju6 f18509a = new ju6();

    public static ju6 a() {
        return f18509a;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return bq.e;
        }
    }
}
