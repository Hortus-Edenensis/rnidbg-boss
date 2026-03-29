package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class vy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f21560a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends vy5 {
        public String b;

        public b() {
            super();
            this.f21560a = i.Character;
        }

        @Override // defpackage.vy5
        public vy5 l() {
            this.b = null;
            return this;
        }

        public b o(String str) {
            this.b = str;
            return this;
        }

        public String p() {
            return this.b;
        }

        public String toString() {
            return p();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends vy5 {
        public final StringBuilder b;
        public boolean c;

        public c() {
            super();
            this.b = new StringBuilder();
            this.c = false;
            this.f21560a = i.Comment;
        }

        @Override // defpackage.vy5
        public vy5 l() {
            vy5.m(this.b);
            this.c = false;
            return this;
        }

        public String o() {
            return this.b.toString();
        }

        public String toString() {
            return "<!--" + o() + "-->";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends vy5 {
        public final StringBuilder b;
        public final StringBuilder c;
        public final StringBuilder d;
        public boolean e;

        public d() {
            super();
            this.b = new StringBuilder();
            this.c = new StringBuilder();
            this.d = new StringBuilder();
            this.e = false;
            this.f21560a = i.Doctype;
        }

        @Override // defpackage.vy5
        public vy5 l() {
            vy5.m(this.b);
            vy5.m(this.c);
            vy5.m(this.d);
            this.e = false;
            return this;
        }

        public String o() {
            return this.b.toString();
        }

        public String p() {
            return this.c.toString();
        }

        public String q() {
            return this.d.toString();
        }

        public boolean r() {
            return this.e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f extends h {
        public f() {
            this.f21560a = i.EndTag;
        }

        public String toString() {
            return "</" + A() + ">";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g extends h {
        public g() {
            this.j = new org.jsoup.nodes.b();
            this.f21560a = i.StartTag;
        }

        @Override // vy5.h, defpackage.vy5
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public h l() {
            super.l();
            this.j = new org.jsoup.nodes.b();
            return this;
        }

        public g F(String str, org.jsoup.nodes.b bVar) {
            this.b = str;
            this.j = bVar;
            this.c = str.toLowerCase();
            return this;
        }

        public String toString() {
            org.jsoup.nodes.b bVar = this.j;
            if (bVar == null || bVar.size() <= 0) {
                return "<" + A() + ">";
            }
            return "<" + A() + " " + this.j.toString() + ">";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class h extends vy5 {
        public String b;
        public String c;
        public String d;
        public StringBuilder e;
        public String f;
        public boolean g;
        public boolean h;
        public boolean i;
        public org.jsoup.nodes.b j;

        public h() {
            super();
            this.e = new StringBuilder();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public final String A() {
            String str = this.b;
            e96.b(str == null || str.length() == 0);
            return this.b;
        }

        public final void B() {
            org.jsoup.nodes.a aVar;
            if (this.j == null) {
                this.j = new org.jsoup.nodes.b();
            }
            if (this.d != null) {
                if (this.h) {
                    aVar = new org.jsoup.nodes.a(this.d, this.e.length() > 0 ? this.e.toString() : this.f);
                } else {
                    aVar = this.g ? new org.jsoup.nodes.a(this.d, "") : new iu(this.d);
                }
                this.j.l(aVar);
            }
            this.d = null;
            this.g = false;
            this.h = false;
            vy5.m(this.e);
            this.f = null;
        }

        public final String C() {
            return this.c;
        }

        @Override // defpackage.vy5
        /* JADX INFO: renamed from: D */
        public h l() {
            this.b = null;
            this.c = null;
            this.d = null;
            vy5.m(this.e);
            this.f = null;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = null;
            return this;
        }

        public final void E() {
            this.g = true;
        }

        public final void o(char c) {
            p(String.valueOf(c));
        }

        public final void p(String str) {
            String str2 = this.d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.d = str;
        }

        public final void q(char c) {
            v();
            this.e.append(c);
        }

        public final void r(String str) {
            v();
            if (this.e.length() == 0) {
                this.f = str;
            } else {
                this.e.append(str);
            }
        }

        public final void s(int[] iArr) {
            v();
            for (int i : iArr) {
                this.e.appendCodePoint(i);
            }
        }

        public final void t(char c) {
            u(String.valueOf(c));
        }

        public final void u(String str) {
            String str2 = this.b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.b = str;
            this.c = str.toLowerCase();
        }

        public final void v() {
            this.h = true;
            String str = this.f;
            if (str != null) {
                this.e.append(str);
                this.f = null;
            }
        }

        public final void w() {
            if (this.d != null) {
                B();
            }
        }

        public final org.jsoup.nodes.b x() {
            return this.j;
        }

        public final boolean y() {
            return this.i;
        }

        public final h z(String str) {
            this.b = str;
            this.c = str.toLowerCase();
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum i {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public static void m(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public final b a() {
        return (b) this;
    }

    public final c b() {
        return (c) this;
    }

    public final d c() {
        return (d) this;
    }

    public final f d() {
        return (f) this;
    }

    public final g e() {
        return (g) this;
    }

    public final boolean f() {
        return this.f21560a == i.Character;
    }

    public final boolean g() {
        return this.f21560a == i.Comment;
    }

    public final boolean h() {
        return this.f21560a == i.Doctype;
    }

    public final boolean i() {
        return this.f21560a == i.EOF;
    }

    public final boolean j() {
        return this.f21560a == i.EndTag;
    }

    public final boolean k() {
        return this.f21560a == i.StartTag;
    }

    public abstract vy5 l();

    public String n() {
        return getClass().getSimpleName();
    }

    public vy5() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e extends vy5 {
        public e() {
            super();
            this.f21560a = i.EOF;
        }

        @Override // defpackage.vy5
        public vy5 l() {
            return this;
        }
    }
}
