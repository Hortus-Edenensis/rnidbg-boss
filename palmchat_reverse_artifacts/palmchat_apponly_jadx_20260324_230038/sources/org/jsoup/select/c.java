package org.jsoup.select;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.e96;
import defpackage.jl5;
import defpackage.xy5;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.select.Selector;
import org.jsoup.select.a;
import org.jsoup.select.b;
import org.jsoup.select.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    public static final String[] d = {",", ">", "+", Constants.WAVE_SEPARATOR, " "};
    public static final String[] e = {ContainerUtils.KEY_VALUE_DELIMITER, "!=", "^=", "$=", "*=", "~="};
    public static final Pattern f = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
    public static final Pattern g = Pattern.compile("(\\+|-)?(\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xy5 f19851a;
    public String b;
    public List<b> c = new ArrayList();

    public c(String str) {
        this.b = str;
        this.f19851a = new xy5(str);
    }

    public static b s(String str) {
        return new c(str).r();
    }

    public final void a() {
        this.c.add(new b.a());
    }

    public final void b() {
        xy5 xy5Var = new xy5(this.f19851a.a('[', ']'));
        String strH = xy5Var.h(e);
        e96.h(strH);
        xy5Var.i();
        if (xy5Var.j()) {
            if (strH.startsWith("^")) {
                this.c.add(new b.d(strH.substring(1)));
                return;
            } else {
                this.c.add(new b.C1259b(strH));
                return;
            }
        }
        if (xy5Var.k(ContainerUtils.KEY_VALUE_DELIMITER)) {
            this.c.add(new b.e(strH, xy5Var.q()));
            return;
        }
        if (xy5Var.k("!=")) {
            this.c.add(new b.i(strH, xy5Var.q()));
            return;
        }
        if (xy5Var.k("^=")) {
            this.c.add(new b.j(strH, xy5Var.q()));
            return;
        }
        if (xy5Var.k("$=")) {
            this.c.add(new b.g(strH, xy5Var.q()));
        } else if (xy5Var.k("*=")) {
            this.c.add(new b.f(strH, xy5Var.q()));
        } else {
            if (!xy5Var.k("~=")) {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.b, xy5Var.q());
            }
            this.c.add(new b.h(strH, Pattern.compile(xy5Var.q())));
        }
    }

    public final void c() {
        String strE = this.f19851a.e();
        e96.h(strE);
        this.c.add(new b.k(strE.trim()));
    }

    public final void d() {
        String strE = this.f19851a.e();
        e96.h(strE);
        this.c.add(new b.o(strE));
    }

    public final void e() {
        String strF = this.f19851a.f();
        e96.h(strF);
        if (strF.startsWith("*|")) {
            this.c.add(new a.b(new b.h0(strF.trim().toLowerCase()), new b.i0(strF.replace("*|", ":").trim().toLowerCase())));
            return;
        }
        if (strF.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
            strF = strF.replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, ":");
        }
        this.c.add(new b.h0(strF.trim()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(char c) {
        b c1258a;
        b bVar;
        boolean z;
        b c1258a2;
        b bVar2;
        this.f19851a.i();
        b bVarS = s(h());
        if (this.c.size() == 1) {
            c1258a = this.c.get(0);
            if ((c1258a instanceof a.b) && c != ',') {
                z = true;
                bVar = c1258a;
                c1258a = ((a.b) c1258a).c();
            }
            this.c.clear();
            if (c != '>') {
                c1258a2 = new a.C1258a(bVarS, new d.b(c1258a));
            } else if (c == ' ') {
                c1258a2 = new a.C1258a(bVarS, new d.e(c1258a));
            } else if (c == '+') {
                c1258a2 = new a.C1258a(bVarS, new d.c(c1258a));
            } else if (c == '~') {
                c1258a2 = new a.C1258a(bVarS, new d.f(c1258a));
            } else {
                if (c != ',') {
                    throw new Selector.SelectorParseException("Unknown combinator: " + c, new Object[0]);
                }
                if (c1258a instanceof a.b) {
                    a.b bVar3 = (a.b) c1258a;
                    bVar3.e(bVarS);
                    c1258a2 = bVar3;
                } else {
                    a.b bVar4 = new a.b();
                    bVar4.e(c1258a);
                    bVar4.e(bVarS);
                    c1258a2 = bVar4;
                }
            }
            if (z) {
                bVar2 = c1258a2;
            } else {
                ((a.b) bVar).b(c1258a2);
                bVar2 = bVar;
            }
            this.c.add(bVar2);
        }
        c1258a = new a.C1258a(this.c);
        bVar = c1258a;
        z = false;
        this.c.clear();
        if (c != '>') {
        }
        if (z) {
        }
        this.c.add(bVar2);
    }

    public final int g() {
        String strTrim = this.f19851a.b(")").trim();
        e96.e(jl5.e(strTrim), "Index must be numeric");
        return Integer.parseInt(strTrim);
    }

    public final String h() {
        StringBuilder sb = new StringBuilder();
        while (!this.f19851a.j()) {
            if (this.f19851a.l("(")) {
                sb.append("(");
                sb.append(this.f19851a.a('(', ')'));
                sb.append(")");
            } else if (this.f19851a.l("[")) {
                sb.append("[");
                sb.append(this.f19851a.a('[', ']'));
                sb.append("]");
            } else {
                if (this.f19851a.n(d)) {
                    break;
                }
                sb.append(this.f19851a.c());
            }
        }
        return sb.toString();
    }

    public final void i(boolean z) {
        this.f19851a.d(z ? ":containsOwn" : ":contains");
        String strS = xy5.s(this.f19851a.a('(', ')'));
        e96.i(strS, ":contains(text) query must not be empty");
        if (z) {
            this.c.add(new b.l(strS));
        } else {
            this.c.add(new b.m(strS));
        }
    }

    public final void j(boolean z, boolean z2) {
        String lowerCase = this.f19851a.b(")").trim().toLowerCase();
        Matcher matcher = f.matcher(lowerCase);
        Matcher matcher2 = g.matcher(lowerCase);
        int i = 2;
        int i2 = 1;
        if (!"odd".equals(lowerCase)) {
            if ("even".equals(lowerCase)) {
                i2 = 0;
            } else if (matcher.matches()) {
                int i3 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                i2 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i = i3;
            } else {
                if (!matcher2.matches()) {
                    throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", lowerCase);
                }
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            }
        }
        if (z2) {
            if (z) {
                this.c.add(new b.a0(i, i2));
                return;
            } else {
                this.c.add(new b.b0(i, i2));
                return;
            }
        }
        if (z) {
            this.c.add(new b.z(i, i2));
        } else {
            this.c.add(new b.y(i, i2));
        }
    }

    public final void k() {
        if (this.f19851a.k("#")) {
            d();
            return;
        }
        if (this.f19851a.k(".")) {
            c();
            return;
        }
        if (this.f19851a.p() || this.f19851a.l("*|")) {
            e();
            return;
        }
        if (this.f19851a.l("[")) {
            b();
            return;
        }
        if (this.f19851a.k("*")) {
            a();
            return;
        }
        if (this.f19851a.k(":lt(")) {
            o();
            return;
        }
        if (this.f19851a.k(":gt(")) {
            n();
            return;
        }
        if (this.f19851a.k(":eq(")) {
            m();
            return;
        }
        if (this.f19851a.l(":has(")) {
            l();
            return;
        }
        if (this.f19851a.l(":contains(")) {
            i(false);
            return;
        }
        if (this.f19851a.l(":containsOwn(")) {
            i(true);
            return;
        }
        if (this.f19851a.l(":matches(")) {
            p(false);
            return;
        }
        if (this.f19851a.l(":matchesOwn(")) {
            p(true);
            return;
        }
        if (this.f19851a.l(":not(")) {
            q();
            return;
        }
        if (this.f19851a.k(":nth-child(")) {
            j(false, false);
            return;
        }
        if (this.f19851a.k(":nth-last-child(")) {
            j(true, false);
            return;
        }
        if (this.f19851a.k(":nth-of-type(")) {
            j(false, true);
            return;
        }
        if (this.f19851a.k(":nth-last-of-type(")) {
            j(true, true);
            return;
        }
        if (this.f19851a.k(":first-child")) {
            this.c.add(new b.u());
            return;
        }
        if (this.f19851a.k(":last-child")) {
            this.c.add(new b.w());
            return;
        }
        if (this.f19851a.k(":first-of-type")) {
            this.c.add(new b.v());
            return;
        }
        if (this.f19851a.k(":last-of-type")) {
            this.c.add(new b.x());
            return;
        }
        if (this.f19851a.k(":only-child")) {
            this.c.add(new b.c0());
            return;
        }
        if (this.f19851a.k(":only-of-type")) {
            this.c.add(new b.d0());
        } else if (this.f19851a.k(":empty")) {
            this.c.add(new b.t());
        } else {
            if (!this.f19851a.k(":root")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.b, this.f19851a.q());
            }
            this.c.add(new b.e0());
        }
    }

    public final void l() {
        this.f19851a.d(":has");
        String strA = this.f19851a.a('(', ')');
        e96.i(strA, ":has(el) subselect must not be empty");
        this.c.add(new d.a(s(strA)));
    }

    public final void m() {
        this.c.add(new b.p(g()));
    }

    public final void n() {
        this.c.add(new b.r(g()));
    }

    public final void o() {
        this.c.add(new b.s(g()));
    }

    public final void p(boolean z) {
        this.f19851a.d(z ? ":matchesOwn" : ":matches");
        String strA = this.f19851a.a('(', ')');
        e96.i(strA, ":matches(regex) query must not be empty");
        if (z) {
            this.c.add(new b.g0(Pattern.compile(strA)));
        } else {
            this.c.add(new b.f0(Pattern.compile(strA)));
        }
    }

    public final void q() {
        this.f19851a.d(":not");
        String strA = this.f19851a.a('(', ')');
        e96.i(strA, ":not(selector) subselect must not be empty");
        this.c.add(new d.C1260d(s(strA)));
    }

    public b r() {
        this.f19851a.i();
        if (this.f19851a.n(d)) {
            this.c.add(new d.g());
            f(this.f19851a.c());
        } else {
            k();
        }
        while (!this.f19851a.j()) {
            boolean zI = this.f19851a.i();
            if (this.f19851a.n(d)) {
                f(this.f19851a.c());
            } else if (zI) {
                f(' ');
            } else {
                k();
            }
        }
        return this.c.size() == 1 ? this.c.get(0) : new a.C1258a(this.c);
    }
}
