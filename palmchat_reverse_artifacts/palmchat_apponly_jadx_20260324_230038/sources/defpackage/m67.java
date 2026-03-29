package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19147a;
    public String b;
    public int c;
    public Exception d;

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.c);
        objArr[1] = this.f19147a;
        objArr[2] = this.b;
        Exception exc = this.d;
        objArr[3] = exc == null ? "" : exc.getMessage();
        return String.format(locale, "code:%d\nresult:%s\nerrorMsg:%s\nexception:%s", objArr);
    }
}
