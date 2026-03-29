package defpackage;

import android.text.TextUtils;
import androidx.media3.datasource.HttpDataSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gj2 {
    static {
        em4<String> em4Var = HttpDataSource.REJECT_PAYWALL_TYPES;
    }

    public static /* synthetic */ boolean a(String str) {
        if (str == null) {
            return false;
        }
        String strE = th.e(str);
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        return ((strE.contains("text") && !strE.contains("text/vtt")) || strE.contains("html") || strE.contains("xml")) ? false : true;
    }
}
