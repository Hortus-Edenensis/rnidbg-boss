package com.opos.exoplayer.core.text.webvtt;

import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.text.webvtt.b;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8354a = y.f("payl");
    private static final int b = y.f("sttg");
    private static final int c = y.f("vttc");
    private final p d;
    private final b.a e;

    public a() {
        super("Mp4WebvttDecoder");
        this.d = new p();
        this.e = new b.a();
    }

    private static Cue a(p pVar, b.a aVar, int i) throws com.opos.exoplayer.core.text.d {
        aVar.a();
        while (i > 0) {
            if (i < 8) {
                throw new com.opos.exoplayer.core.text.d("Incomplete vtt cue box header found.");
            }
            int iO = pVar.o();
            int iO2 = pVar.o();
            int i2 = iO - 8;
            String str = new String(pVar.f8400a, pVar.d(), i2);
            pVar.d(i2);
            i = (i - 8) - i2;
            if (iO2 == b) {
                c.a(str, aVar);
            } else if (iO2 == f8354a) {
                c.a((String) null, str.trim(), aVar, (List<WebvttCssStyle>) Collections.emptyList());
            }
        }
        return aVar.b();
    }

    @Override // com.opos.exoplayer.core.text.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g a(byte[] bArr, int i, boolean z) throws com.opos.exoplayer.core.text.d {
        this.d.a(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.d.b() > 0) {
            if (this.d.b() < 8) {
                throw new com.opos.exoplayer.core.text.d("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iO = this.d.o();
            if (this.d.o() == c) {
                arrayList.add(a(this.d, this.e, iO - 8));
            } else {
                this.d.d(iO - 8);
            }
        }
        return new g(arrayList);
    }
}
