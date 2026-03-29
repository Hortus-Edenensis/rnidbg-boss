package com.opos.mobad.template.h.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.e;
import com.opos.mobad.template.cmn.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends a {
    private n f;
    private TextView g;
    private TextView h;
    private com.opos.mobad.template.cmn.a i;

    private void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f9897a, 58.0f), com.opos.cmn.an.h.f.a.a(this.f9897a, 58.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f9897a, com.opos.cmn.an.h.f.a.d(this.f9897a) ? 17 : 35);
        this.f.setLayoutParams(layoutParams);
    }

    private void c() {
        this.i.setVisibility(0);
    }

    public void b(com.opos.mobad.template.d.b bVar) {
        if (bVar == null) {
            com.opos.cmn.an.f.a.a("GraphicMixTipBar", "err data");
            return;
        }
        b();
        a(this.i, bVar.j);
        a((View) this.c);
        a((e) this.c);
        b(this.i);
        a((e) this.i);
        c();
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            this.d.a(eVar.f9414a, eVar.b, com.opos.cmn.an.h.f.a.a(this.f9897a, 58.0f), com.opos.cmn.an.h.f.a.a(this.f9897a, 58.0f), new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.a.b.1
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    a.InterfaceC0778a interfaceC0778a;
                    b bVar2 = b.this;
                    if (bVar2.e) {
                        return;
                    }
                    if (i == 0 || i == 1) {
                        if (i == 1 && (interfaceC0778a = bVar2.b) != null) {
                            interfaceC0778a.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.h.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (b.this.e || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                b.this.f.setImageBitmap(bitmap);
                            }
                        });
                        return;
                    }
                    a.InterfaceC0778a interfaceC0778a2 = bVar2.b;
                    if (interfaceC0778a2 != null) {
                        interfaceC0778a2.c(i);
                    }
                }
            });
        }
        a(this.g, bVar.b);
        a(this.h, bVar.f9413a);
    }
}
