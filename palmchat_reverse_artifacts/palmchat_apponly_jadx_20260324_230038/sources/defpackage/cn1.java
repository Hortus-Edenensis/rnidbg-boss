package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class cn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2490a = "mda_process";

    public static String a(Context context) {
        return f2490a;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f2490a = str;
    }
}
