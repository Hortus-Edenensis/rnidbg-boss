package com.beizi.ad.v2.f;

import android.content.Context;
import com.beizi.ad.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.ad.v2.a.a {
    public a(Context context) {
        this.f4517a = new b(context);
    }

    public void a(f fVar) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(fVar);
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
