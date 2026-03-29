package com.opos.cmn.module.ui.b.f;

import android.app.Activity;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends a {
    private com.opos.cmn.module.ui.b.g.a c;

    public b(Activity activity, com.opos.cmn.module.ui.b.e.a aVar) {
        super(activity, aVar);
        this.f8068a = activity;
        this.b = aVar;
        this.c = (aVar == null || aVar.f8066a == 0) ? new com.opos.cmn.module.ui.b.g.a(activity, aVar) : new com.opos.cmn.module.ui.b.g.a(activity, aVar.f8066a, aVar);
        com.opos.cmn.module.ui.d.a.a(activity, this.c);
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public void a(View view) {
        if (view != null) {
            this.c.setContentView(view);
        }
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public void b() {
        this.c.show();
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public void c() {
        this.c.dismiss();
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public boolean a() {
        return this.c.isShowing();
    }
}
