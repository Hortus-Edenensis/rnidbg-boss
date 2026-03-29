package org.jsoup.nodes;

import defpackage.jl5;
import java.io.IOException;
import kotlin.text.Typography;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class e extends g {
    public e(String str, String str2, String str3, String str4) {
        super(str4);
        g("name", str);
        g("publicId", str2);
        g("systemId", str3);
    }

    @Override // org.jsoup.nodes.g
    public void A(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.i() != Document.OutputSettings.Syntax.html || T("publicId") || T("systemId")) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (T("name")) {
            appendable.append(" ").append(f("name"));
        }
        if (T("publicId")) {
            appendable.append(" PUBLIC \"").append(f("publicId")).append(Typography.quote);
        }
        if (T("systemId")) {
            appendable.append(" \"").append(f("systemId")).append(Typography.quote);
        }
        appendable.append(Typography.greater);
    }

    public final boolean T(String str) {
        return !jl5.d(f(str));
    }

    @Override // org.jsoup.nodes.g
    public String x() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.g
    public void B(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }
}
