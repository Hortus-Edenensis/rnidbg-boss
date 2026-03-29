package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import com.cdo.oaps.ad.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class hd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f17935a = new ConcurrentHashMap(16);
    public static final String b = a("T1BQTw==");
    public static final String c = a(a.c);
    public static final String d = a("T3Bwbw==");
    public static final String e = a("UmVhbG1l");
    public static final String f = a("cmVhbG1l");
    public static final String g = a("T25lUGx1cw==");
    public static final String h = a("b25lcGx1cw==");
    public static final String i = a("Q29sb3JPUw==");
    public static final String j = a("Q09MT1JPUw==");
    public static final String k = a("Y29sb3Jvcw==");
    public static final String l = a("Y29sb3JPUw==");
    public static final String m = a("Y29sb3I=");
    public static final String n = a("Q29sb3JCdWlsZA==");
    public static final String o = a("T3BsdXNPUw==");
    public static final String p = a("SHlkcm9nZW4gT1Mg");
    public static final String q = a("T3h5Z2VuIE9TIA==");

    public static String a(String str) {
        String str2 = f17935a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = new String(Base64.decode(str.getBytes(), 0));
        f17935a.put(str, str3);
        return str3;
    }
}
