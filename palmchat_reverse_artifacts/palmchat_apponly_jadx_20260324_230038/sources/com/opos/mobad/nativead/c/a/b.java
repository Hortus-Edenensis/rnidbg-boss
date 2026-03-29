package com.opos.mobad.nativead.c.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.nativead.d.a.a f9150a;
    private com.opos.mobad.nativead.a.a b;

    public b(Context context, com.opos.mobad.nativead.a.a aVar, FrameLayout frameLayout) {
        this.f9150a = new com.opos.mobad.nativead.d.a.b(context, this, frameLayout);
        this.b = aVar;
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a() {
        this.f9150a.b();
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void b() {
        this.f9150a.c();
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void c(View view, AdItemData adItemData, long j) {
        this.b.c(view, adItemData, j);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a(View view, AdItemData adItemData) {
        this.b.a(view, adItemData);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void b(View view, AdItemData adItemData) {
        this.b.b(view, adItemData);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a(View view, AdItemData adItemData, long j) {
        this.b.a(view, adItemData, j);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void b(View view, AdItemData adItemData, long j) {
        com.opos.mobad.nativead.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, adItemData, j);
        }
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.func.b.a aVar) {
        this.b.a(view, iArr, j, aVar);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void b(AdItemData adItemData, String str) {
        this.f9150a.b(adItemData, str);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a(AdItemData adItemData) {
        this.f9150a.a(adItemData);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a(AdItemData adItemData, String str) {
        this.f9150a.a(adItemData, str);
    }

    @Override // com.opos.mobad.nativead.c.a.a
    public void a(Map<String, String> map) {
        this.b.a(map);
    }
}
