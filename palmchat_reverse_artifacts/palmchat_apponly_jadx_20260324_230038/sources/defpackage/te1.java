package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class te1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20971a;
    public String b = "";

    public te1(String str) {
        this.f20971a = str;
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith("http://" + this.f20971a + this.b)) {
            if (!str.startsWith("https://" + this.f20971a + this.b) && !str.equals(this.f20971a)) {
                return false;
            }
        }
        return true;
    }
}
