package defpackage;

import com.zenmen.palmchat.ad.model.WifiAdRespBean;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17668a;
    public int b;
    public int c;
    public int d = 0;
    public int e = 0;
    public long f;
    public double g;
    public double h;
    public WifiAdRespBean.LXExtra i;
    public int j;

    public g6(s7 s7Var, int i, int i2, long j) {
        this.g = 0.1d;
        this.h = 0.5d;
        this.j = 3;
        this.b = i;
        this.c = i2;
        this.f = j;
        if (s7Var == null || s7Var.k() == null) {
            return;
        }
        WifiAdRespBean.LXExtra lXExtra = s7Var.k().e;
        this.i = lXExtra;
        if (lXExtra == null) {
            LogUtil.d("AdDoubleCheckHelper", "lxExtra is null, test is default");
            return;
        }
        this.j = lXExtra.getId();
        this.g = (((double) this.i.getLr()) * 1.0d) / 100.0d;
        this.h = (((double) this.i.getRr()) * 1.0d) / 100.0d;
        this.f17668a = this.i.getT() * 1000;
        LogUtil.d("AdDoubleCheckHelper", "mLxExtra t = " + this.i.getT() + ", rr = " + this.i.getRr() + ", id = " + this.i.getId() + ",lr = " + this.i.getLr());
    }

    public final boolean a() {
        boolean z = false;
        if ((this.d <= ((double) this.b) * 0.65d || this.e >= ((double) this.c) * 0.15d) && this.e <= ((double) this.c) * 0.85d) {
            z = true;
        }
        LogUtil.d("AdDoubleCheckHelper", "isInClickArea = " + z);
        return z;
    }

    public final boolean b() {
        int i = this.d;
        double d = i;
        int i2 = this.b;
        boolean z = d < ((double) i2) * this.g || ((double) i) > ((double) i2) * this.h;
        LogUtil.d("AdDoubleCheckHelper", "isInDoubleCheckArea " + z + ", clickPointX = " + this.d + ", width = " + this.b + ", leftLine= " + this.g + ", rightLine = " + this.h);
        return z;
    }

    public void c(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public boolean d() {
        int i = this.j;
        boolean z = true;
        if ((i == 1 || i == 2) && !a()) {
            z = false;
        }
        LogUtil.d("AdDoubleCheckHelper", "shouldClick = " + z);
        return z;
    }

    public boolean e() {
        int i = this.j;
        boolean z = false;
        if (i != 1 ? i == 2 || i == 3 : ir5.b() - this.f < this.f17668a || b()) {
            z = true;
        }
        LogUtil.d("AdDoubleCheckHelper", "shouldDoubleCheck = " + z);
        return z;
    }
}
