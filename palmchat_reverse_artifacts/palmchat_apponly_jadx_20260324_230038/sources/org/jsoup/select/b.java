package org.jsoup.select;

import defpackage.e96;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a0 extends n {
        public a0(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.b.n
        public int b(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            Elements elementsG0 = fVar2.D().g0();
            int i = 0;
            for (int iIntValue = fVar2.l0().intValue(); iIntValue < elementsG0.size(); iIntValue++) {
                if (elementsG0.get(iIntValue).J0().equals(fVar2.J0())) {
                    i++;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.b.n
        public String c() {
            return "nth-last-of-type";
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C1259b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19837a;

        public C1259b(String str) {
            this.f19837a = str;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.u(this.f19837a);
        }

        public String toString() {
            return String.format("[%s]", this.f19837a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b0 extends n {
        public b0(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.b.n
        public int b(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            int i = 0;
            for (org.jsoup.nodes.f fVar3 : fVar2.D().g0()) {
                if (fVar3.J0().equals(fVar2.J0())) {
                    i++;
                }
                if (fVar3 == fVar2) {
                    break;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.b.n
        public String c() {
            return "nth-of-type";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19838a;
        public String b;

        public c(String str, String str2) {
            e96.h(str);
            e96.h(str2);
            this.f19838a = str.trim().toLowerCase();
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.b = str2.trim().toLowerCase();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c0 extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarD = fVar2.D();
            return (fVarD == null || (fVarD instanceof Document) || fVar2.I0().size() != 0) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19839a;

        public d(String str) {
            e96.h(str);
            this.f19839a = str.toLowerCase();
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            Iterator<org.jsoup.nodes.a> it = fVar2.h().c().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().toLowerCase().startsWith(this.f19839a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.f19839a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d0 extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarD = fVar2.D();
            if (fVarD == null || (fVarD instanceof Document)) {
                return false;
            }
            Iterator<org.jsoup.nodes.f> it = fVarD.g0().iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().J0().equals(fVar2.J0())) {
                    i++;
                }
            }
            return i == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e extends c {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.u(this.f19838a) && this.b.equalsIgnoreCase(fVar2.f(this.f19838a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.f19838a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e0 extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            if (fVar instanceof Document) {
                fVar = fVar.f0(0);
            }
            return fVar2 == fVar;
        }

        public String toString() {
            return ":root";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f extends c {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.u(this.f19838a) && fVar2.f(this.f19838a).toLowerCase().contains(this.b);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.f19838a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f19840a;

        public f0(Pattern pattern) {
            this.f19840a = pattern;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return this.f19840a.matcher(fVar2.M0()).find();
        }

        public String toString() {
            return String.format(":matches(%s", this.f19840a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g extends c {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.u(this.f19838a) && fVar2.f(this.f19838a).toLowerCase().endsWith(this.b);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.f19838a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f19841a;

        public g0(Pattern pattern) {
            this.f19841a = pattern;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return this.f19841a.matcher(fVar2.z0()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s", this.f19841a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19842a;
        public Pattern b;

        public h(String str, Pattern pattern) {
            this.f19842a = str.trim().toLowerCase();
            this.b = pattern;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.u(this.f19842a) && this.b.matcher(fVar2.f(this.f19842a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.f19842a, this.b.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19843a;

        public h0(String str) {
            this.f19843a = str;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.K0().equalsIgnoreCase(this.f19843a);
        }

        public String toString() {
            return String.format("%s", this.f19843a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i extends c {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return !this.b.equalsIgnoreCase(fVar2.f(this.f19838a));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.f19838a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19844a;

        public i0(String str) {
            this.f19844a = str;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.K0().endsWith(this.f19844a);
        }

        public String toString() {
            return String.format("%s", this.f19844a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j extends c {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.u(this.f19838a) && fVar2.f(this.f19838a).toLowerCase().startsWith(this.b);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.f19838a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19845a;

        public k(String str) {
            this.f19845a = str;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.r0(this.f19845a);
        }

        public String toString() {
            return String.format(".%s", this.f19845a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class l extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19846a;

        public l(String str) {
            this.f19846a = str.toLowerCase();
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.z0().toLowerCase().contains(this.f19846a);
        }

        public String toString() {
            return String.format(":containsOwn(%s", this.f19846a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class m extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19847a;

        public m(String str) {
            this.f19847a = str.toLowerCase();
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.M0().toLowerCase().contains(this.f19847a);
        }

        public String toString() {
            return String.format(":contains(%s", this.f19847a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class n extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19848a;
        public final int b;

        public n(int i, int i2) {
            this.f19848a = i;
            this.b = i2;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarD = fVar2.D();
            if (fVarD == null || (fVarD instanceof Document)) {
                return false;
            }
            int iB = b(fVar, fVar2);
            int i = this.f19848a;
            if (i == 0) {
                return iB == this.b;
            }
            int i2 = this.b;
            return (iB - i2) * i >= 0 && (iB - i2) % i == 0;
        }

        public abstract int b(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2);

        public abstract String c();

        public String toString() {
            return this.f19848a == 0 ? String.format(":%s(%d)", c(), Integer.valueOf(this.b)) : this.b == 0 ? String.format(":%s(%dn)", c(), Integer.valueOf(this.f19848a)) : String.format(":%s(%dn%+d)", c(), Integer.valueOf(this.f19848a), Integer.valueOf(this.b));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class o extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19849a;

        public o(String str) {
            this.f19849a = str;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return this.f19849a.equals(fVar2.w0());
        }

        public String toString() {
            return String.format("#%s", this.f19849a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class p extends q {
        public p(int i) {
            super(i);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.l0().intValue() == this.f19850a;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.f19850a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class q extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19850a;

        public q(int i) {
            this.f19850a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class r extends q {
        public r(int i) {
            super(i);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.l0().intValue() > this.f19850a;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.f19850a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class s extends q {
        public s(int i) {
            super(i);
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.l0().intValue() < this.f19850a;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.f19850a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class t extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            for (org.jsoup.nodes.g gVar : fVar2.n()) {
                if (!(gVar instanceof org.jsoup.nodes.c) && !(gVar instanceof org.jsoup.nodes.e)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarD = fVar2.D();
            return (fVarD == null || (fVarD instanceof Document) || fVar2.l0().intValue() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class v extends b0 {
        public v() {
            super(0, 1);
        }

        @Override // org.jsoup.select.b.n
        public String toString() {
            return ":first-of-type";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class w extends b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarD = fVar2.D();
            return (fVarD == null || (fVarD instanceof Document) || fVar2.l0().intValue() != fVarD.g0().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class x extends a0 {
        public x() {
            super(0, 1);
        }

        @Override // org.jsoup.select.b.n
        public String toString() {
            return ":last-of-type";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class y extends n {
        public y(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.b.n
        public int b(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.l0().intValue() + 1;
        }

        @Override // org.jsoup.select.b.n
        public String c() {
            return "nth-child";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class z extends n {
        public z(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.b.n
        public int b(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar2.D().g0().size() - fVar2.l0().intValue();
        }

        @Override // org.jsoup.select.b.n
        public String c() {
            return "nth-last-child";
        }
    }

    public abstract boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2);
}
