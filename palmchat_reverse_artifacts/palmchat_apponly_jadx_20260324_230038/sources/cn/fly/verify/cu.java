package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gb f2166a;

    public cu(String str, int i) {
        gb gbVar = new gb(ax.g());
        this.f2166a = gbVar;
        gbVar.a(str, i);
    }

    public Object a(String str) {
        return this.f2166a.d(str);
    }

    public int b(String str, int i) {
        return this.f2166a.b(str, i);
    }

    public void a(String str, int i) {
        this.f2166a.a(str, Integer.valueOf(i));
    }

    public long b(String str, long j) {
        return this.f2166a.a(str, j);
    }

    public void a(String str, long j) {
        this.f2166a.a(str, Long.valueOf(j));
    }

    public String b(String str, String str2) {
        return this.f2166a.b(str, str2);
    }

    public void a(String str, Object obj) {
        this.f2166a.a(str, obj);
    }

    public boolean b(String str, boolean z) {
        return this.f2166a.a(str, z);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.f2166a.e(str);
        } else {
            this.f2166a.a(str, str2);
        }
    }

    public void a(String str, boolean z) {
        this.f2166a.a(str, Boolean.valueOf(z));
    }
}
