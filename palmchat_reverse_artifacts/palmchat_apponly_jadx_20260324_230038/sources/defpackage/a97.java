package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a97 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1182a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public a97(String str, int i) {
        this.f1182a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f1182a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
