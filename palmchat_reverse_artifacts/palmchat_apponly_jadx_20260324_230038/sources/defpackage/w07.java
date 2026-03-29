package defpackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class w07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DateFormat f21580a;

    public static DateFormat a() {
        if (f21580a == null) {
            f21580a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return f21580a;
    }
}
