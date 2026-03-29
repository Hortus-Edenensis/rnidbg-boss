package com.opos.mobad.video.player.d;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.a;
import com.opos.mobad.template.d.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdItemData f10304a;
    private MaterialData b;
    private a.InterfaceC0778a c;
    private com.opos.mobad.template.a d;
    private FrameLayout e;

    public b(Activity activity, AdItemData adItemData, com.opos.mobad.template.a aVar) {
        this.e = new FrameLayout(activity);
        this.f10304a = adItemData;
        this.b = adItemData.i().get(0);
        this.d = aVar;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.e;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        try {
            com.opos.mobad.template.a aVar = this.d;
            if (aVar != null) {
                aVar.d();
                this.d = null;
            }
            FrameLayout frameLayout = this.e;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                this.e = null;
            }
            this.c = null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InterstitialWidgetImpl", "destroy() fail", e);
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        com.opos.mobad.template.a aVar = this.d;
        if (aVar == null) {
            return 0;
        }
        return aVar.e();
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
        com.opos.mobad.template.a aVar = this.d;
        if (aVar != null) {
            aVar.a(interfaceC0778a);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.cmn.an.f.a.b("InterstitialWidgetImpl", "getRenderView ");
        if (this.f10304a == null || this.b == null) {
            return;
        }
        com.opos.mobad.template.a aVar = this.d;
        if (aVar == null) {
            com.opos.cmn.an.f.a.d("InterstitialWidgetImpl", "unknow creativeType, please check if your creativeType is video or template");
            a.InterfaceC0778a interfaceC0778a = this.c;
            if (interfaceC0778a != null) {
                interfaceC0778a.a(1);
                return;
            }
            return;
        }
        aVar.a(fVar);
        View viewC = this.d.c();
        FrameLayout frameLayout = this.e;
        if (frameLayout == null || frameLayout.indexOfChild(viewC) >= 0) {
            return;
        }
        this.e.removeAllViews();
        this.e.addView(viewC, new FrameLayout.LayoutParams(-1, -1));
    }
}
