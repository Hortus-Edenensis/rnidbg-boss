package defpackage;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rb1 {
    public static boolean a(Context context) {
        return lg6.c() && Build.MODEL.equals("vivo X7") && new lg6(context).getVersion() == 300;
    }
}
