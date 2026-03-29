package org.jsoup.nodes;

import defpackage.bt5;
import defpackage.jl5;
import defpackage.kc4;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import org.jsoup.nodes.Entities;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class Document extends f {
    public OutputSettings i;
    public QuirksMode j;
    public String k;
    public boolean l;

    /* JADX INFO: compiled from: SearchBox */
    public static class OutputSettings implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Entities.EscapeMode f19826a = Entities.EscapeMode.base;
        public Charset b = Charset.forName("UTF-8");
        public boolean c = true;
        public boolean d = false;
        public int e = 1;
        public Syntax f = Syntax.html;

        /* JADX INFO: compiled from: SearchBox */
        public enum Syntax {
            html,
            xml
        }

        public OutputSettings a(String str) {
            b(Charset.forName(str));
            return this;
        }

        public OutputSettings b(Charset charset) {
            this.b = charset;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.a(this.b.name());
                outputSettings.f19826a = Entities.EscapeMode.valueOf(this.f19826a.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public CharsetEncoder d() {
            return this.b.newEncoder();
        }

        public Entities.EscapeMode e() {
            return this.f19826a;
        }

        public int f() {
            return this.e;
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.c;
        }

        public Syntax i() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(bt5.k("#root", kc4.c), str);
        this.i = new OutputSettings();
        this.j = QuirksMode.noQuirks;
        this.l = false;
        this.k = str;
    }

    @Override // org.jsoup.nodes.f
    public f N0(String str) {
        S0().N0(str);
        return this;
    }

    public f S0() {
        return U0("body", this);
    }

    @Override // org.jsoup.nodes.f, org.jsoup.nodes.g
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Document p() {
        Document document = (Document) super.k0();
        document.i = this.i.clone();
        return document;
    }

    public final f U0(String str, g gVar) {
        if (gVar.x().equals(str)) {
            return (f) gVar;
        }
        Iterator<g> it = gVar.b.iterator();
        while (it.hasNext()) {
            f fVarU0 = U0(str, it.next());
            if (fVarU0 != null) {
                return fVarU0;
            }
        }
        return null;
    }

    public OutputSettings V0() {
        return this.i;
    }

    public QuirksMode W0() {
        return this.j;
    }

    public Document X0(QuirksMode quirksMode) {
        this.j = quirksMode;
        return this;
    }

    public String Y0() {
        f fVarFirst = q0("title").first();
        return fVarFirst != null ? jl5.i(fVarFirst.M0()).trim() : "";
    }

    @Override // org.jsoup.nodes.f, org.jsoup.nodes.g
    public String x() {
        return "#document";
    }

    @Override // org.jsoup.nodes.g
    public String y() {
        return super.t0();
    }
}
