package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class kc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f18624a = Pattern.compile("([\t\r\n])+");

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }
}
