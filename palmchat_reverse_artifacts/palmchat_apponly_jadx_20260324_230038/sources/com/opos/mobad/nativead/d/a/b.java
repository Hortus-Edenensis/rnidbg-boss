package com.opos.mobad.nativead.d.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.ui.a.a;
import com.opos.mobad.ui.a.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f9152a;
    private com.opos.mobad.nativead.c.a.a b;
    private AdItemData c;

    public b(Context context, com.opos.mobad.nativead.c.a.a aVar, FrameLayout frameLayout) {
        this.f9152a = new j(context, this, frameLayout);
        this.b = aVar;
    }

    public static a.C0803a c(AdItemData adItemData, String str) {
        MaterialData materialData;
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return null;
        }
        List<MaterialFileData> listE = materialData.e();
        String strA = "";
        String strA2 = (listE == null || listE.size() <= 0 || listE.get(0) == null) ? "" : listE.get(0).a();
        List<MaterialFileData> listD = materialData.D();
        if (listD != null && listD.size() > 0) {
            strA = listD.get(0).a();
        }
        return new a.C0803a(strA2, strA, str, adItemData.W());
    }

    @Override // com.opos.mobad.ui.a.d
    public void a() {
    }

    @Override // com.opos.mobad.nativead.d.a.a
    public void b() {
        this.f9152a.b();
    }

    @Override // com.opos.mobad.ui.a.d
    public void a(long j) {
    }

    @Override // com.opos.mobad.ui.a.d
    public void b(View view) {
        com.opos.mobad.nativead.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, this.c);
        }
    }

    @Override // com.opos.mobad.nativead.d.a.a
    public void c() {
        this.f9152a.Q();
    }

    @Override // com.opos.mobad.ui.a.d
    public void a(View view) {
        com.opos.mobad.nativead.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(view, this.c);
        }
    }

    @Override // com.opos.mobad.ui.a.d
    public void b(View view, long j) {
        com.opos.mobad.nativead.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, this.c, j);
        }
    }

    @Override // com.opos.mobad.ui.a.d
    public void c(View view, long j) {
        com.opos.mobad.nativead.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.c(view, this.c, j);
        }
    }

    @Override // com.opos.mobad.ui.a.d
    public void a(View view, long j) {
        com.opos.mobad.nativead.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(view, this.c, j);
        }
    }

    @Override // com.opos.mobad.nativead.d.a.a
    public void b(AdItemData adItemData, String str) {
        this.c = adItemData;
        this.f9152a.d(c(adItemData, str));
    }

    @Override // com.opos.mobad.ui.a.d
    public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.func.b.a aVar) {
        com.opos.mobad.nativead.c.a.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(view, iArr, j, aVar);
        }
    }

    @Override // com.opos.mobad.nativead.d.a.a
    public void a(AdItemData adItemData) {
        this.f9152a.b(c(adItemData, ""));
    }

    @Override // com.opos.mobad.nativead.d.a.a
    public void a(AdItemData adItemData, String str) {
        this.c = adItemData;
        this.f9152a.c(c(adItemData, str));
    }

    @Override // com.opos.mobad.ui.a.d
    public void a(Map<String, String> map) {
        com.opos.mobad.nativead.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(map);
        }
    }
}
