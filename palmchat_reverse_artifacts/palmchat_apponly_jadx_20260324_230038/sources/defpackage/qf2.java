package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qf2 {
    public static String a(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("\n", "<br>") : str;
    }
}
