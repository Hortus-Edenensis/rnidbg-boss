package com.opos.mobad.template.i;

import android.view.View;
import com.opos.mobad.template.e;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements com.opos.mobad.template.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e.a f10101a;

    public b(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.b.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (b.this.f10101a != null) {
                        b.this.f10101a.a(view2, iArr);
                    }
                }
            };
            view.setOnClickListener(pVar);
            view.setOnTouchListener(pVar);
        }
    }

    @Override // com.opos.mobad.template.e
    public void a(e.a aVar) {
        this.f10101a = aVar;
    }
}
