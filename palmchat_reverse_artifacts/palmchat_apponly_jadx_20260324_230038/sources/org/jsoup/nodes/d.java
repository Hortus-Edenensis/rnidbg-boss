package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class d extends g {
    public d(String str, String str2) {
        super(str2);
        this.c.k("data", str);
    }

    @Override // org.jsoup.nodes.g
    public void A(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(T());
    }

    public String T() {
        return this.c.e("data");
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return y();
    }

    @Override // org.jsoup.nodes.g
    public String x() {
        return "#data";
    }

    @Override // org.jsoup.nodes.g
    public void B(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }
}
