package com.opos.cmn.func.a.a;

import android.content.Context;
import com.opos.cmn.func.a.b.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements com.opos.cmn.func.a.b.d, com.opos.cmn.func.a.b.e {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f f7931a = com.opos.cmn.func.a.b.a.b.a();

    private b() {
    }

    public static b a() {
        b bVar;
        b bVar2 = b;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    @Override // com.opos.cmn.func.a.b.e
    public e a(Context context, d dVar) {
        f fVar = this.f7931a;
        if (fVar != null) {
            return fVar.a(context, dVar);
        }
        return null;
    }

    @Override // com.opos.cmn.func.a.b.d
    public void a(Context context) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        f fVar = this.f7931a;
        if (fVar != null) {
            fVar.a(context);
        }
    }
}
