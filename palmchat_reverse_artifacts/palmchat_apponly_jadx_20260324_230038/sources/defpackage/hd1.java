package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class hd1 {
    public static final hd1 c;
    public static final hd1 d;
    public static final hd1 e;
    public static final hd1 f;
    public static final hd1 g;
    public static final hd1 h;
    public static final hd1 i;
    public static final hd1 j;
    public static final hd1 k;
    public static final hd1 l;
    public static final hd1 m;
    public static final hd1 n;
    public static final hd1[] o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17932a;
    public final boolean b;

    static {
        hd1 hd1Var = new hd1(0, false);
        c = hd1Var;
        hd1 hd1Var2 = new hd1(1, true);
        d = hd1Var2;
        hd1 hd1Var3 = new hd1(2, false);
        e = hd1Var3;
        hd1 hd1Var4 = new hd1(3, true);
        f = hd1Var4;
        hd1 hd1Var5 = new hd1(4, false);
        g = hd1Var5;
        hd1 hd1Var6 = new hd1(5, true);
        h = hd1Var6;
        hd1 hd1Var7 = new hd1(6, false);
        i = hd1Var7;
        hd1 hd1Var8 = new hd1(7, true);
        j = hd1Var8;
        hd1 hd1Var9 = new hd1(8, false);
        k = hd1Var9;
        hd1 hd1Var10 = new hd1(9, true);
        l = hd1Var10;
        hd1 hd1Var11 = new hd1(10, false);
        m = hd1Var11;
        hd1 hd1Var12 = new hd1(10, true);
        n = hd1Var12;
        o = new hd1[]{hd1Var, hd1Var2, hd1Var3, hd1Var4, hd1Var5, hd1Var6, hd1Var7, hd1Var8, hd1Var9, hd1Var10, hd1Var11, hd1Var12};
    }

    public hd1(int i2, boolean z) {
        this.f17932a = i2;
        this.b = z;
    }

    public boolean a(hd1 hd1Var) {
        int i2 = this.f17932a;
        int i3 = hd1Var.f17932a;
        return i2 < i3 || ((!this.b || l == this) && i2 == i3);
    }

    public hd1 b() {
        return !this.b ? o[this.f17932a + 1] : this;
    }

    public hd1 c() {
        if (!this.b) {
            return this;
        }
        hd1 hd1Var = o[this.f17932a - 1];
        return !hd1Var.b ? hd1Var : c;
    }
}
