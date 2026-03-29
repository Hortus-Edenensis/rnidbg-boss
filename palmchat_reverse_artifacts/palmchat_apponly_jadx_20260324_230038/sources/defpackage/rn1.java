package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rn1 {
    public static int a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 0;
            }
            return activeNetworkInfo.getType() == 1 ? 1 : -1;
        } catch (Throwable th) {
            Log.e("CX_EVENT", "th:" + th.getMessage());
            return -1;
        }
    }
}
