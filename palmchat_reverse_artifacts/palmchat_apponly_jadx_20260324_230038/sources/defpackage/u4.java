package defpackage;

import com.zenmen.palmchat.AppContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u4 {
    public static boolean a(String str, long j) {
        if (!dt1.c(AppContext.getContext().getApplication())) {
            return false;
        }
        long jE = go.e("wk_account_delete", "del_" + str, 0L);
        long jE2 = go.e("wk_account_delete", "add_" + str, 0L);
        if (jE > j || jE2 > jE) {
            go.m("wk_account_delete", "del_" + str, j);
            jE = j;
        }
        return jE2 != 0 && Math.abs(j - jE) < dt1.a();
    }

    public static void b(String str, long j) {
        if (dt1.c(AppContext.getContext().getApplication())) {
            go.m("wk_account_delete", "add_" + str, j);
        }
    }
}
