package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f21744a;

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (f21744a == null) {
                f21744a = context.getSharedPreferences("config_sp", 0);
            }
            return f21744a.getInt("version", 0);
        } catch (Throwable th) {
            Log.e("CX_EVENT", "th:" + th.getMessage());
            return 0;
        }
    }

    public static void b(Context context, int i) {
        if (context == null) {
            return;
        }
        try {
            if (f21744a == null) {
                f21744a = context.getSharedPreferences("config_sp", 0);
            }
            SharedPreferences.Editor editorEdit = f21744a.edit();
            editorEdit.putInt("version", i);
            editorEdit.commit();
        } catch (Throwable th) {
            Log.e("CX_EVENT", "th:" + th.getMessage());
        }
    }
}
