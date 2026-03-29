package com.opos.mobad.template.g;

import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.CarouselViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class w extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CarouselViewPager f9873a;
    private a.InterfaceC0778a b;

    public void a(final a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockListImgHorizontalView", "setListener " + interfaceC0778a);
        this.b = interfaceC0778a;
        this.f9873a.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.w.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (w.this.b != null) {
                    w.this.b.h(view, iArr);
                }
            }
        });
        this.f9873a.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.w.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("BlockListImgHorizontalView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                a.InterfaceC0778a interfaceC0778a2 = interfaceC0778a;
                if (interfaceC0778a2 != null) {
                    interfaceC0778a2.a(view, i, z);
                }
            }
        });
    }
}
