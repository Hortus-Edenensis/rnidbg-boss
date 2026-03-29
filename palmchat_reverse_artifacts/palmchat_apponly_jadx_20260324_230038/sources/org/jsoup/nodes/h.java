package org.jsoup.nodes;

import defpackage.jl5;
import java.io.IOException;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class h extends g {
    public String g;

    public h(String str, String str2) {
        this.d = str2;
        this.g = str;
    }

    public static boolean W(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    public static String X(String str) {
        return jl5.i(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    @Override // org.jsoup.nodes.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.h()) {
            if (O() == 0) {
                g gVar = this.f19832a;
                if (!(gVar instanceof f) || !((f) gVar).J0().a() || V()) {
                    if (outputSettings.g() && P().size() > 0 && !V()) {
                        v(appendable, i, outputSettings);
                    }
                }
            }
        }
        Entities.e(appendable, U(), outputSettings, false, outputSettings.h() && (D() instanceof f) && !f.E0(D()), false);
    }

    public final void T() {
        if (this.c == null) {
            b bVar = new b();
            this.c = bVar;
            bVar.k("text", this.g);
        }
    }

    public String U() {
        b bVar = this.c;
        return bVar == null ? this.g : bVar.e("text");
    }

    public boolean V() {
        return jl5.d(U());
    }

    public String Y() {
        return X(U());
    }

    @Override // org.jsoup.nodes.g
    public String a(String str) {
        T();
        return super.a(str);
    }

    @Override // org.jsoup.nodes.g
    public String f(String str) {
        T();
        return super.f(str);
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return y();
    }

    @Override // org.jsoup.nodes.g
    public boolean u(String str) {
        T();
        return super.u(str);
    }

    @Override // org.jsoup.nodes.g
    public String x() {
        return "#text";
    }

    @Override // org.jsoup.nodes.g
    public void B(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }
}
