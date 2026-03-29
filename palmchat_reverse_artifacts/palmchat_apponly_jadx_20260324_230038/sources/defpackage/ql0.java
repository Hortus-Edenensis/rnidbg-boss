package defpackage;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ql0 {
    public static String a(Context context) {
        return context.getApplicationContext().getPackageName() + ".cxpt.config.provider";
    }

    public static Uri b(Context context) {
        return Uri.parse("content://" + a(context) + "/config");
    }
}
