package com.opos.cmn.module.ui.b;

import android.R;
import android.app.Activity;
import com.opos.cmn.module.ui.b.c.c;
import com.opos.cmn.module.ui.b.e.a;
import com.opos.cmn.module.ui.b.f.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f8051a;
    private com.opos.cmn.module.ui.b.f.c b;

    public a(Activity activity) {
        this.f8051a = new c(activity);
        b bVar = new b(activity, new a.C0676a().a(com.opos.cmn.an.h.f.a.a(activity) ? R.style.Theme.Translucent.NoTitleBar.Fullscreen : R.style.Theme.Translucent.NoTitleBar).a(false).b(false).a());
        this.b = bVar;
        bVar.a(this.f8051a.b());
    }

    public void a() {
        if (this.b.a()) {
            this.b.c();
        }
    }

    public void a(String str, String str2, String str3, com.opos.cmn.module.ui.b.d.a aVar) {
        this.f8051a.a((CharSequence) str);
        this.f8051a.b(str2);
        this.f8051a.a(str3);
        this.f8051a.a(aVar);
        this.b.b();
    }
}
