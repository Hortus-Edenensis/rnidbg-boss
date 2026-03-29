package com.opos.cmn.module.ui.c.c;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f extends b implements e {
    public f(Context context, com.opos.cmn.module.ui.c.a aVar) {
        super(context, aVar);
        if (com.opos.cmn.module.ui.d.a.a()) {
            this.c = new com.opos.cmn.module.ui.c.d.d(this.f8075a, this);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a() {
        com.opos.cmn.module.ui.c.d.c cVar;
        if (!com.opos.cmn.module.ui.d.a.a() || (cVar = this.c) == null) {
            return;
        }
        cVar.a();
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void b() {
        com.opos.cmn.module.ui.c.d.c cVar;
        if (!com.opos.cmn.module.ui.d.a.a() || (cVar = this.c) == null) {
            return;
        }
        cVar.b();
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a(View view, String str, Object... objArr) {
        com.opos.cmn.module.ui.c.a aVar = this.b;
        if (aVar != null) {
            aVar.a(view, str, objArr);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void b(View view, int[] iArr, String str, Object... objArr) {
        com.opos.cmn.module.ui.c.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, iArr, str, objArr);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a(View view, int[] iArr, String str, Object... objArr) {
        com.opos.cmn.module.ui.c.a aVar = this.b;
        if (aVar != null) {
            aVar.a(view, iArr, str, objArr);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a(String str, boolean z, Object... objArr) {
        com.opos.cmn.module.ui.c.d.c cVar;
        if (!com.opos.cmn.module.ui.d.a.a() || (cVar = this.c) == null) {
            return;
        }
        cVar.a(str, z, objArr);
    }
}
