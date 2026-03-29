package com.opos.exoplayer.core.text.webvtt;

import android.text.TextUtils;
import com.opos.exoplayer.core.text.webvtt.b;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f8360a;
    private final p b;
    private final b.a c;
    private final f d;
    private final List<WebvttCssStyle> e;

    public d() {
        super("WebvttDecoder");
        this.f8360a = new c();
        this.b = new p();
        this.c = new b.a();
        this.d = new f();
        this.e = new ArrayList();
    }

    private static int a(p pVar) {
        int i = -1;
        int iD = 0;
        while (i == -1) {
            iD = pVar.d();
            String strZ = pVar.z();
            i = strZ == null ? 0 : "STYLE".equals(strZ) ? 2 : "NOTE".startsWith(strZ) ? 1 : 3;
        }
        pVar.c(iD);
        return i;
    }

    @Override // com.opos.exoplayer.core.text.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h a(byte[] bArr, int i, boolean z) throws com.opos.exoplayer.core.text.d {
        this.b.a(bArr, i);
        this.c.a();
        this.e.clear();
        e.a(this.b);
        while (!TextUtils.isEmpty(this.b.z())) {
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iA = a(this.b);
            if (iA == 0) {
                return new h(arrayList);
            }
            if (iA == 1) {
                b(this.b);
            } else if (iA == 2) {
                if (!arrayList.isEmpty()) {
                    throw new com.opos.exoplayer.core.text.d("A style block was found after the first cue.");
                }
                this.b.z();
                WebvttCssStyle webvttCssStyleC = this.d.c(this.b);
                if (webvttCssStyleC != null) {
                    this.e.add(webvttCssStyleC);
                }
            } else if (iA == 3 && this.f8360a.a(this.b, this.c, this.e)) {
                arrayList.add(this.c.b());
                this.c.a();
            }
        }
    }

    private static void b(p pVar) {
        while (!TextUtils.isEmpty(pVar.z())) {
        }
    }
}
