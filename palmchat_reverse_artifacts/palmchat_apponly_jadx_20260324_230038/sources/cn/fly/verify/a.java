package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2058a;
    public String b;
    public boolean c;
    public long d;
    public String e;
    public int f;

    @Override // cn.fly.verify.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b(String str) {
        try {
            super.b(str);
            this.f2058a = String.valueOf(this.h.get("opToken"));
            this.b = String.valueOf(this.h.get("phone"));
            this.c = ((Boolean) this.h.get("use")).booleanValue();
            this.d = System.currentTimeMillis() + 3600000;
        } catch (Throwable th) {
            f.a().a(th, "[FlyVerify] ==>%s", "Entity analyse exception.");
        }
        return this;
    }

    public String toString() {
        return "Cache{opToken='" + this.f2058a + "', phone='" + this.b + "', use=" + this.c + ", expireTime=" + this.d + '}';
    }
}
