package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ip0 {
    public static long a(lp0 lp0Var) {
        return lp0Var.get("exo_len", -1L);
    }

    @Nullable
    public static Uri b(lp0 lp0Var) {
        String str = lp0Var.get("exo_redir", (String) null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }
}
