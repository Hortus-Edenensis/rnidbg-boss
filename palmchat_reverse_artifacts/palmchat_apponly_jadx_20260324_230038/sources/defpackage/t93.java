package defpackage;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class t93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ComponentName f20931a;

    public static ComponentName a(Context context) {
        if (f20931a == null) {
            try {
                f20931a = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
            } catch (Exception unused) {
            }
        }
        return f20931a;
    }
}
