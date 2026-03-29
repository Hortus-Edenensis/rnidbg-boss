package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dd3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17027a;
    public final float b;
    public final float c;

    public dd3(String str, float f, float f2) {
        this.f17027a = str;
        this.c = f2;
        this.b = f;
    }

    public boolean a(String str) {
        if (this.f17027a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f17027a.endsWith("\r")) {
            String str2 = this.f17027a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
