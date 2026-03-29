package com.opos.mobad.template.h.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f9903a;
    protected b b;
    protected com.opos.mobad.template.cmn.a c;
    private Context d;
    private a.InterfaceC0778a e;
    private FrameLayout f;

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.e = interfaceC0778a;
        this.b.a(interfaceC0778a);
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        FrameLayout.LayoutParams layoutParams;
        View viewA;
        if (bVar == null) {
            return;
        }
        try {
            if (a.a(bVar)) {
                layoutParams = new FrameLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.d, 85.0f));
                this.f9903a = 0;
                this.b.b(bVar);
                viewA = this.b.a();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                this.f9903a = 1;
                this.c.setText(bVar.j);
                p pVar = new p() { // from class: com.opos.mobad.template.h.a.c.1
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (c.this.e != null) {
                            c.this.e.g(view, iArr);
                        }
                    }
                };
                this.c.setOnTouchListener(pVar);
                this.c.setOnClickListener(pVar);
                this.c.a(new f() { // from class: com.opos.mobad.template.h.a.c.2
                    @Override // com.opos.mobad.template.cmn.baseview.f
                    public void a(View view, int i, boolean z) {
                        com.opos.cmn.an.f.a.a("TipBarTemplate", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                        if (c.this.e != null) {
                            c.this.e.a(view, i, z);
                        }
                    }
                });
                viewA = this.c;
            }
            if (viewA == null || this.f.indexOfChild(viewA) >= 0) {
                return;
            }
            this.f.removeAllViews();
            viewA.setVisibility(0);
            this.f.addView(viewA, layoutParams);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("TipBarTemplate", "", (Throwable) e);
        }
    }
}
