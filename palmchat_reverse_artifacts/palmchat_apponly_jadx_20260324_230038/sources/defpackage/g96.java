package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class g96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17689a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public g96(String str, int i) {
        this.f17689a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f17689a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
