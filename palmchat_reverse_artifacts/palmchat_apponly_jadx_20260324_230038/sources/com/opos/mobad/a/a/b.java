package com.opos.mobad.a.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.template.a;
import com.opos.mobad.template.d.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.d.e.a f8455a;
    private com.opos.mobad.template.a b;
    private a.InterfaceC0778a c;

    public b(Context context) {
        this.f8455a = new com.opos.mobad.d.e.a(context);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f8455a;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.mobad.template.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        this.c = null;
        aVar.d();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        com.opos.mobad.template.a aVar = this.b;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public void a(int i) {
        a.InterfaceC0778a interfaceC0778a = this.c;
        if (interfaceC0778a != null) {
            interfaceC0778a.a(i);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.a(interfaceC0778a);
        this.c = interfaceC0778a;
    }

    public void a(com.opos.mobad.template.a aVar) {
        this.b = aVar;
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.cmn.an.f.a.b("banner_ad", "show :" + fVar + "," + this.b);
        com.opos.mobad.template.a aVar = this.b;
        if (aVar == null) {
            a(1);
            return;
        }
        aVar.a(fVar);
        View viewC = this.b.c();
        com.opos.cmn.an.f.a.b("banner_ad", "show view:" + viewC);
        if (viewC == null) {
            a(1);
        } else if (this.f8455a.indexOfChild(viewC) < 0) {
            this.f8455a.removeAllViews();
            this.f8455a.addView(viewC, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }
}
