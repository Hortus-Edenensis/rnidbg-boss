package defpackage;

import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class au2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1571a = File.separator;
    public static final Charset b;
    public static final Charset c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        b = charsetForName;
        c = charsetForName;
    }
}
