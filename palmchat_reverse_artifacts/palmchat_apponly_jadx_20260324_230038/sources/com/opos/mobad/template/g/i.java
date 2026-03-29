package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9771a = false;
    private int b = 256;
    private int c = 144;
    private int d;
    private int e;
    private Context f;
    private a.InterfaceC0778a g;
    private int h;
    private int i;
    private com.opos.mobad.template.d.b j;
    private ImageView k;
    private ad l;
    private com.opos.mobad.template.cmn.w m;
    private RelativeLayout n;
    private RelativeLayout o;
    private s p;
    private TextView q;
    private x r;
    private TextView s;
    private com.opos.mobad.template.cmn.aa t;
    private com.opos.mobad.d.a u;

    private i(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.u = aVar;
        f();
        a(amVar);
        p();
        o();
    }

    private void f() {
        Context context;
        float f;
        int i = this.i;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 328.0f);
            this.c = com.opos.cmn.an.h.f.a.a(this.f, 184.0f);
            context = this.f;
            f = 258.0f;
        } else {
            if (i != 1) {
                return;
            }
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
            this.c = com.opos.cmn.an.h.f.a.a(this.f, 168.0f);
            context = this.f;
            f = 212.0f;
        }
        this.d = com.opos.cmn.an.h.f.a.a(context, f);
        this.e = this.b;
    }

    private boolean g() {
        return this.i == 0;
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.n = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        j();
        if (!g()) {
            l();
        } else {
            k();
            i();
        }
    }

    private void i() {
        this.l = ad.a(this.f, 8, this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.l.setId(View.generateViewId());
        this.l.setVisibility(4);
        this.n.addView(this.l, layoutParams);
    }

    private void j() {
        this.k = new ImageView(this.f);
        this.n.addView(this.k, new RelativeLayout.LayoutParams(this.b, this.c));
    }

    private void k() {
        TextView textView = new TextView(this.f);
        this.q = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_description_color));
        this.q.setTextSize(1, 12.0f);
        this.q.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.q.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.q.setGravity(3);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        layoutParams.addRule(12);
        this.q.setVisibility(4);
        this.n.addView(this.q, layoutParams);
    }

    private void l() {
        this.l = ad.a(this.f, false, this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        this.l.setVisibility(4);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        this.n.addView(this.l, layoutParams);
    }

    private void m() {
        s sVarA = s.a(this.f, 2, false, this.u, true);
        this.p = sVarA;
        sVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.f, 74.0f));
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.p.setVisibility(4);
        this.m.addView(this.p, layoutParams);
    }

    private void n() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.f, 44.0f));
        this.o.setVisibility(4);
        RelativeLayout relativeLayout2 = this.n;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        TextView textView = new TextView(this.f);
        this.s = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_title_color));
        this.s.setTextSize(1, 12.0f);
        this.s.setGravity(17);
        this.s.setMaxLines(1);
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        this.s.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.rightMargin = iA;
        this.o.addView(this.s, layoutParams2);
        this.m.addView(this.o, layoutParams);
    }

    private void o() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.i.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (i.this.j == null) {
                    return;
                }
                if (z) {
                    if (i.this.g != null) {
                        i.this.g.a((Map<String, String>) null);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage6", "blockBigImage6 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.i.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (i.this.j == null) {
                    return;
                }
                if (i.this.g != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    i.this.g.a(map);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage6", "blockBigImage6 onWindowVisibilityChanged：" + z + ", " + z2);
            }
        }, c());
        this.m.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void p() {
        this.n.setVisibility(0);
        TextView textView = this.q;
        if (textView != null) {
            textView.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        s sVar = this.p;
        if (sVar != null) {
            sVar.setVisibility(0);
        }
        ad adVar = this.l;
        if (adVar != null) {
            adVar.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.t;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.h;
    }

    public static i a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new i(context, amVar, i, 0, aVar);
    }

    public static i b(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new i(context, amVar, i, 1, aVar);
    }

    private void c(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.i.5
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (i.this.f9771a) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage6", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (i.this.g != null) {
                        i.this.g.c(i);
                    }
                } else {
                    if (i == 1 && i.this.g != null) {
                        i.this.g.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.i.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (i.this.f9771a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            i.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage6", "destroy");
        this.j = null;
        this.f9771a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.t;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        x xVar = this.r;
        if (xVar != null) {
            xVar.a();
        }
        s sVar = this.p;
        if (sVar != null) {
            sVar.removeAllViews();
        }
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.l.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        TextView textView;
        String str = bVar.b;
        if (!TextUtils.isEmpty(str) && (textView = this.s) != null) {
            textView.setText(str);
        }
        s sVar = this.p;
        if (sVar != null) {
            sVar.a(bVar, this.u, this.f9771a);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.g = interfaceC0778a;
        ad adVar = this.l;
        if (adVar != null) {
            adVar.a(interfaceC0778a);
        }
        x xVar = this.r;
        if (xVar != null) {
            xVar.a(interfaceC0778a);
        }
        s sVar = this.p;
        if (sVar != null) {
            sVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        b(bVar);
        c(bVar);
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(bVar.f9413a);
        }
        if (g()) {
            return;
        }
        d(bVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA == null) {
                str = "adShowData is null";
            } else {
                List<com.opos.mobad.template.d.e> list = bVarA.c;
                if (list != null && list.size() > 0) {
                    com.opos.cmn.an.f.a.b("BlockBigImage6", "render");
                    if (this.j == null && (interfaceC0778a = this.g) != null) {
                        interfaceC0778a.f();
                    }
                    this.j = bVarA;
                    com.opos.mobad.template.cmn.aa aaVar = this.t;
                    if (aaVar != null && aaVar.getVisibility() != 0) {
                        this.t.setVisibility(0);
                    }
                    com.opos.mobad.template.cmn.w wVar = this.m;
                    if (wVar != null && wVar.getVisibility() != 0) {
                        this.m.setVisibility(0);
                    }
                    a(bVarA);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage6", str);
        this.g.a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.f);
        }
        Context context = this.f;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.t = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.m = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.f, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.t.addView(this.m, layoutParams);
        this.t.setLayoutParams(layoutParams);
        h();
        if (g()) {
            m();
        } else {
            n();
        }
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.i.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (i.this.g != null) {
                    i.this.g.h(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(pVar);
        this.m.setOnTouchListener(pVar);
        this.m.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.i.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage6", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (i.this.g != null) {
                    i.this.g.a(view, i4, z);
                }
            }
        });
    }
}
