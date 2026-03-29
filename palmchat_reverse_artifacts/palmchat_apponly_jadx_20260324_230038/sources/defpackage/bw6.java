package defpackage;

import android.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class bw6 {
    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
