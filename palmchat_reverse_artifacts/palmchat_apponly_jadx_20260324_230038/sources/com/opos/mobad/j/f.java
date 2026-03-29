package com.opos.mobad.j;

import android.view.View;
import com.opos.mobad.ad.k;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.j.a;
import com.opos.mobad.j.d;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.opos.mobad.j.a f8949a;
    protected d b;
    protected e c;
    protected long d = -1;
    public String e;
    private AdItemData f;
    private MaterialData g;

    /* JADX INFO: compiled from: SearchBox */
    public interface a extends k, a.InterfaceC0748a, d.a {
    }

    public f(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, c.b bVar2, final a aVar2) {
        this.f8949a = new com.opos.mobad.j.a(bVar, str, aVar, bVar2, aVar2);
        this.b = new d(bVar, str, aVar2);
        this.c = new e(bVar, new k() { // from class: com.opos.mobad.j.f.1
            @Override // com.opos.mobad.ad.k
            public void onReward(Object... objArr) {
                f.this.a(aVar2, objArr);
            }
        });
    }

    public static int b(int i, String str) {
        int iA = com.opos.mobad.mediaplayer.a.a.a(i, str);
        if (iA == 1) {
            return 10601;
        }
        if (iA == 2) {
            return 10602;
        }
        if (iA == 3) {
            return 10603;
        }
        if (iA != 4) {
            return iA;
        }
        return 10604;
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(int i) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onRenderFail()", "code=", Integer.valueOf(i));
        this.f8949a.a(b(i, ""), this.e);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void c(int i) {
        this.f8949a.c(i);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void d(long j, long j2) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onProcess()", "position=", Long.valueOf(j), "duration=", Long.valueOf(j2));
        this.d = j;
        this.b.a(j, j2);
        this.c.a(j, j2);
    }

    public void e() {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onBackClick");
        this.f8949a.a(true, (int[]) null, this.d);
        this.b.a((View) null, (int[]) null, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void f() {
        this.f8949a.a();
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void g(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.CLICK_BT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void h(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.NON_CLICK_BT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void i(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void j(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT);
    }

    public void k(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onClose");
        this.f8949a.b();
        this.b.a(view, iArr, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(int i, int[] iArr) {
        a((View) null, iArr, i == 0 ? com.opos.mobad.cmn.func.b.a.FORWARD : com.opos.mobad.cmn.func.b.a.TILT);
    }

    public void b() {
        com.opos.mobad.j.a aVar = this.f8949a;
        if (aVar != null) {
            aVar.c();
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.a();
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.i();
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void c(long j, long j2) {
    }

    public boolean d() {
        return true;
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void e(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onCloseClick");
        this.f8949a.a(false, iArr, this.d);
        this.b.a(view, iArr, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void f(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.func.b.a.VIDEO);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(long j, long j2) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onComplete()", "position=", Long.valueOf(j), "duration=", Long.valueOf(j2));
        this.d = j2;
        this.b.a(j2);
        this.c.a(j);
    }

    public void b(int i) {
        this.f8949a.a(i);
    }

    public void a(View view) {
        a(view, (int[]) null, com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void b(long j, long j2) {
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int i, boolean z) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onMockEventIntercepted");
        this.f8949a.a(view, i, z);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void b(Map<String, String> map) {
        int iA = com.opos.mobad.mediaplayer.a.c.a(map);
        this.b.a(b(iA, com.opos.mobad.mediaplayer.a.c.c(map)), com.opos.mobad.mediaplayer.a.c.b(map), map);
    }

    public void a(View view, Map<String, String> map) {
        Object[] objArr = new Object[2];
        objArr[0] = "onShow()";
        objArr[1] = map != null ? map.toString() : null;
        com.opos.cmn.an.f.a.b("UniversalPresenter", objArr);
        if (g.a(map)) {
            this.f8949a.b(view, map);
        } else {
            this.f8949a.a(view, map);
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void b(int[] iArr) {
        a((View) null, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int[] iArr, boolean z) {
    }

    public void a(k kVar, Object... objArr) {
        if (kVar == null) {
            return;
        }
        kVar.onReward(objArr);
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i, String str) {
        a(adItemData, materialData, -1L, i, materialData.aa(), str);
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i, int i2, String str) {
        this.f = adItemData;
        this.g = materialData;
        this.d = -1L;
        this.e = str;
        this.f8949a.a(adItemData, materialData, i, i2);
        this.b.a(adItemData, materialData, j, i);
        this.c.a(adItemData, materialData);
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i, String str) {
        a(adItemData, materialData, j, i, materialData.aa(), str);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(a.b bVar, Map<String, String> map) {
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(int[] iArr) {
        a((View) null, iArr, com.opos.mobad.cmn.func.b.a.SHAKE);
    }

    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        e eVar;
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onClick()", "adClickArea=", aVar, "coordinate=", iArr, "view=", view);
        if (!h.a(this.f, aVar)) {
            return false;
        }
        this.f8949a.a(view, iArr, aVar, this.d);
        if (d() && (eVar = this.c) != null) {
            eVar.a();
        }
        return true;
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void l(View view, int[] iArr) {
    }
}
