package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.CarouselVerticalViewPager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9876a;
    private int b;
    private CarouselVerticalViewPager c;
    private a.InterfaceC0778a d;
    private boolean e;

    public x(Context context, int i, int i2, boolean z, boolean z2) {
        super(context);
        this.f9876a = i == 0 ? 256 : i;
        this.b = i2 == 0 ? 168 : i2;
        a(z, z2);
    }

    public static x a(Context context, int i, int i2, boolean z) {
        return new x(context, i, i2, z, false);
    }

    public static x b(Context context, int i, int i2, boolean z) {
        return new x(context, i, i2, z, true);
    }

    public void a() {
        this.e = true;
        CarouselVerticalViewPager carouselVerticalViewPager = this.c;
        if (carouselVerticalViewPager != null) {
            carouselVerticalViewPager.a();
        }
    }

    public void a(final a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockListImgView", "setListener " + interfaceC0778a);
        this.d = interfaceC0778a;
        this.c.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.x.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (x.this.d != null) {
                    x.this.d.h(view, iArr);
                }
            }
        });
        this.c.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.x.3
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("BlockListImgView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                a.InterfaceC0778a interfaceC0778a2 = interfaceC0778a;
                if (interfaceC0778a2 != null) {
                    interfaceC0778a2.a(view, i, z);
                }
            }
        });
    }

    public void a(com.opos.mobad.template.d.b bVar, com.opos.mobad.d.a aVar, boolean z, int i) {
        List<com.opos.mobad.template.d.e> list;
        if (bVar == null || (list = bVar.c) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < Math.min(bVar.c.size(), 3); i2++) {
            com.opos.mobad.template.d.e eVar = bVar.c.get(i2);
            if (eVar != null) {
                a(eVar, aVar, z, arrayList);
            }
        }
        this.c.a(i);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar, boolean z, final List<Bitmap> list) {
        aVar.a(eVar.f9414a, eVar.b, this.f9876a, this.b, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.x.1
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (x.this.e) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (x.this.d != null) {
                        x.this.d.c(i);
                    }
                } else {
                    if (i == 1 && x.this.d != null) {
                        x.this.d.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.x.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (x.this.e || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            list.add(bitmap);
                            x.this.c.a(list);
                        }
                    });
                }
            }
        });
    }

    private void a(boolean z, boolean z2) {
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), this.f9876a);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), this.b);
        setLayoutParams(new ViewGroup.LayoutParams(iA, iA2));
        this.c = z2 ? CarouselVerticalViewPager.b(getContext(), 3, z) : CarouselVerticalViewPager.a(getContext(), 3, z);
        addView(this.c, new RelativeLayout.LayoutParams(iA, iA2));
    }
}
