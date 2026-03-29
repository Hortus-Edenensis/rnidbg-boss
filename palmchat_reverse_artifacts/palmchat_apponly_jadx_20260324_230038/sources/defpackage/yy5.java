package defpackage;

import com.huawei.openalliance.ad.constant.x;
import defpackage.vy5;
import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.nodes.Entities;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class yy5 {
    public static final char[] s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b10 f22302a;
    public final jc4 b;
    public vy5 d;
    public vy5.h i;
    public String o;
    public zy5 c = zy5.Data;
    public boolean e = false;
    public String f = null;
    public StringBuilder g = new StringBuilder(1024);
    public StringBuilder h = new StringBuilder(1024);
    public vy5.g j = new vy5.g();
    public vy5.f k = new vy5.f();
    public vy5.b l = new vy5.b();
    public vy5.d m = new vy5.d();
    public vy5.c n = new vy5.c();
    public boolean p = true;
    public final int[] q = new int[1];
    public final int[] r = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        s = cArr;
        Arrays.sort(cArr);
    }

    public yy5(b10 b10Var, jc4 jc4Var) {
        this.f22302a = b10Var;
        this.b = jc4Var;
    }

    public void a() {
        this.p = true;
    }

    public void b(zy5 zy5Var) {
        this.f22302a.a();
        this.c = zy5Var;
    }

    public String c() {
        String str = this.o;
        if (str == null) {
            return null;
        }
        return str;
    }

    public final void d(String str) {
        if (this.b.o()) {
            this.b.add(new ic4(this.f22302a.D(), "Invalid character reference: %s", str));
        }
    }

    public int[] e(Character ch, boolean z) {
        int iIntValue;
        if (this.f22302a.q()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.f22302a.p()) || this.f22302a.x(s)) {
            return null;
        }
        int[] iArr = this.q;
        this.f22302a.r();
        if (this.f22302a.s("#")) {
            boolean zT = this.f22302a.t("X");
            b10 b10Var = this.f22302a;
            String strF = zT ? b10Var.f() : b10Var.e();
            if (strF.length() == 0) {
                d("numeric reference with no numerals");
                this.f22302a.F();
                return null;
            }
            if (!this.f22302a.s(x.aQ)) {
                d("missing semicolon");
            }
            try {
                iIntValue = Integer.valueOf(strF, zT ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue != -1 && ((iIntValue < 55296 || iIntValue > 57343) && iIntValue <= 1114111)) {
                iArr[0] = iIntValue;
                return iArr;
            }
            d("character outside of valid range");
            iArr[0] = 65533;
            return iArr;
        }
        String strH = this.f22302a.h();
        boolean zU = this.f22302a.u(';');
        if (!(Entities.f(strH) || (Entities.g(strH) && zU))) {
            this.f22302a.F();
            if (zU) {
                d(String.format("invalid named referenece '%s'", strH));
            }
            return null;
        }
        if (z && (this.f22302a.A() || this.f22302a.y() || this.f22302a.w('=', '-', '_'))) {
            this.f22302a.F();
            return null;
        }
        if (!this.f22302a.s(x.aQ)) {
            d("missing semicolon");
        }
        int iD = Entities.d(strH, this.r);
        if (iD == 1) {
            iArr[0] = this.r[0];
            return iArr;
        }
        if (iD == 2) {
            return this.r;
        }
        e96.a("Unexpected characters returned for " + strH);
        return this.r;
    }

    public void f() {
        this.n.l();
    }

    public void g() {
        this.m.l();
    }

    public vy5.h h(boolean z) {
        vy5.h hVarL = z ? this.j.l() : this.k.l();
        this.i = hVarL;
        return hVarL;
    }

    public void i() {
        vy5.m(this.h);
    }

    public void j(char c) {
        l(String.valueOf(c));
    }

    public void k(vy5 vy5Var) {
        e96.c(this.e, "There is an unread token pending!");
        this.d = vy5Var;
        this.e = true;
        vy5.i iVar = vy5Var.f21560a;
        if (iVar != vy5.i.StartTag) {
            if (iVar != vy5.i.EndTag || ((vy5.f) vy5Var).j == null) {
                return;
            }
            s("Attributes incorrectly present on end tag");
            return;
        }
        vy5.g gVar = (vy5.g) vy5Var;
        this.o = gVar.b;
        if (gVar.i) {
            this.p = false;
        }
    }

    public void l(String str) {
        if (this.f == null) {
            this.f = str;
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append(str);
    }

    public void m(int[] iArr) {
        l(new String(iArr, 0, iArr.length));
    }

    public void n() {
        k(this.n);
    }

    public void o() {
        k(this.m);
    }

    public void p() {
        this.i.w();
        k(this.i);
    }

    public void q(zy5 zy5Var) {
        if (this.b.o()) {
            this.b.add(new ic4(this.f22302a.D(), "Unexpectedly reached end of file (EOF) in input state [%s]", zy5Var));
        }
    }

    public void r(zy5 zy5Var) {
        if (this.b.o()) {
            this.b.add(new ic4(this.f22302a.D(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f22302a.p()), zy5Var));
        }
    }

    public final void s(String str) {
        if (this.b.o()) {
            this.b.add(new ic4(this.f22302a.D(), str));
        }
    }

    public boolean t() {
        return this.o != null && this.i.A().equalsIgnoreCase(this.o);
    }

    public vy5 u() {
        if (!this.p) {
            s("Self closing flag not acknowledged");
            this.p = true;
        }
        while (!this.e) {
            this.c.read(this, this.f22302a);
        }
        if (this.g.length() > 0) {
            String string = this.g.toString();
            StringBuilder sb = this.g;
            sb.delete(0, sb.length());
            this.f = null;
            return this.l.o(string);
        }
        String str = this.f;
        if (str == null) {
            this.e = false;
            return this.d;
        }
        vy5.b bVarO = this.l.o(str);
        this.f = null;
        return bVarO;
    }

    public void v(zy5 zy5Var) {
        this.c = zy5Var;
    }
}
