package com.beizi.ad.v2.c;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends com.beizi.ad.v2.a.a {
    public a(Context context, boolean z) {
        this.f4517a = new b(context);
    }

    public void a(com.beizi.ad.a aVar) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(aVar);
        }
    }

    @Override // com.beizi.ad.v2.a.a
    public void c() {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar == null) {
            return;
        }
        bVar.b();
    }

    public void a(Context context) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(context);
        }
    }
}
