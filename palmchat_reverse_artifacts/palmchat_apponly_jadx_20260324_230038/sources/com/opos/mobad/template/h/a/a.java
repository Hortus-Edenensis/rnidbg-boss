package com.opos.mobad.template.h.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.e;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f9897a;
    protected a.InterfaceC0778a b;
    protected com.opos.mobad.template.cmn.baseview.c c;
    protected com.opos.mobad.d.a d;
    protected boolean e;

    public RelativeLayout a() {
        return this.c;
    }

    public void b(View view) {
        if (view != null) {
            p pVar = new p() { // from class: com.opos.mobad.template.h.a.a.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    a.InterfaceC0778a interfaceC0778a = a.this.b;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.g(view2, iArr);
                    }
                }
            };
            view.setOnTouchListener(pVar);
            view.setOnClickListener(pVar);
        }
    }

    public void a(View view) {
        if (view != null) {
            p pVar = new p() { // from class: com.opos.mobad.template.h.a.a.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    a.InterfaceC0778a interfaceC0778a = a.this.b;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.h(view2, iArr);
                    }
                }
            };
            view.setOnTouchListener(pVar);
            view.setOnClickListener(pVar);
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.b = interfaceC0778a;
    }

    public void a(e eVar) {
        if (eVar != null) {
            eVar.a(new f() { // from class: com.opos.mobad.template.h.a.a.3
                @Override // com.opos.mobad.template.cmn.baseview.f
                public void a(View view, int i, boolean z) {
                    com.opos.cmn.an.f.a.a("BaseTipBarView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                    a.InterfaceC0778a interfaceC0778a = a.this.b;
                    if (interfaceC0778a != null) {
                        interfaceC0778a.a(view, i, z);
                    }
                }
            });
        }
    }

    public static final boolean a(com.opos.mobad.template.d.b bVar) {
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            z = true;
        }
        com.opos.cmn.an.f.a.b("BaseTipBarView", "hasTipBarMaterial=" + z);
        return z;
    }
}
