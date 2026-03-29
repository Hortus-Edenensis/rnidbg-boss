package com.opos.mobad.template.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.g.ad;
import com.opos.mobad.template.g.ae;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class r implements com.opos.mobad.template.a {
    private int d;
    private int e;
    private boolean f;
    private Context g;
    private a.InterfaceC0778a h;
    private int i;
    private ad j;
    private com.opos.mobad.template.cmn.w k;
    private RelativeLayout l;
    private RelativeLayout m;
    private ae n;
    private TextView o;
    private com.opos.mobad.template.cmn.aa p;
    private com.opos.mobad.d.a q;
    private com.opos.mobad.template.d.c s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9850a = false;
    private int b = 256;
    private int c = 144;
    private boolean t = false;
    private Runnable u = new Runnable() { // from class: com.opos.mobad.template.g.r.1
        @Override // java.lang.Runnable
        public void run() {
            if (r.this.f9850a) {
                return;
            }
            int iG = r.this.n.g();
            int iH = r.this.n.h();
            if (r.this.h != null) {
                r.this.h.d(iG, iH);
            }
            r.this.n.f();
            r.this.r.postDelayed(this, 500L);
        }
    };
    private Handler r = new Handler(Looper.getMainLooper());

    private r(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.g = context;
        this.i = i;
        this.q = aVar2;
        f();
        a(amVar, aVar);
        j();
        i();
    }

    public static r a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new r(context, amVar, i, aVar, aVar2);
    }

    private void g() {
        this.j = ad.a(this.g, true, this.q);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.j.setVisibility(4);
        this.l.addView(this.j, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.m = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.g, 44.0f));
        this.m.setVisibility(4);
        RelativeLayout relativeLayout2 = this.l;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        TextView textView = new TextView(this.g);
        this.o = textView;
        textView.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_title_color));
        this.o.setTextSize(1, 12.0f);
        this.o.setGravity(17);
        this.o.setMaxLines(1);
        this.o.setEllipsize(TextUtils.TruncateAt.END);
        this.o.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.rightMargin = iA;
        this.m.addView(this.o, layoutParams2);
        this.k.addView(this.m, layoutParams);
    }

    private void i() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.r.6
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (r.this.s == null) {
                    return;
                }
                if (z && !r.this.t) {
                    r.this.t = true;
                    if (r.this.h != null) {
                        r.this.h.a((Map<String, String>) null);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "BlockBigImageVideo6 onWindowVisibilityChanged：" + z);
                if (r.this.f) {
                    if (z) {
                        r.this.n.d();
                    } else {
                        r.this.n.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.r.7
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (r.this.s == null) {
                    return;
                }
                if (r.this.h != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    r.this.h.a(map);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "BlockBigImageVideo6 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.k.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void j() {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.j.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.p;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.i;
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
        this.c = com.opos.cmn.an.h.f.a.a(this.g, 144.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.g, 188.0f);
        this.e = this.b;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (!this.f9850a) {
            this.n.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "current state has stop mDestroy =" + this.f9850a);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "start countdown...");
        if (!this.f9850a) {
            this.n.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "error state mDestroy " + this.f9850a);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "destroy");
        this.f9850a = true;
        this.n.c();
        this.s = null;
        this.r.removeCallbacks(this.u);
        com.opos.mobad.template.cmn.aa aaVar = this.p;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.l = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.l.setVisibility(4);
        this.k.addView(this.l, layoutParams);
        b(aVar);
        g();
    }

    private void b(com.opos.mobad.d.d.a aVar) {
        this.n = ae.a(this.g, this.b, this.c, aVar);
        this.l.addView(this.n, new RelativeLayout.LayoutParams(this.b, this.c));
        this.n.a(new ae.a() { // from class: com.opos.mobad.template.g.r.5
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                r.this.r.removeCallbacks(r.this.u);
                r.this.r.postDelayed(r.this.u, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                r.this.r.removeCallbacks(r.this.u);
            }
        });
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        this.j.a(cVar.p, cVar.q, cVar.e, cVar.f, cVar.i, cVar.A);
    }

    private void d(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.d.a aVar = cVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a)) {
            return;
        }
        TextUtils.isEmpty(aVar.b);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        String str = cVar.b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.setText(str);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.h = interfaceC0778a;
        this.j.a(interfaceC0778a);
        this.n.a(interfaceC0778a);
        this.j.a(new ad.a() { // from class: com.opos.mobad.template.g.r.2
            @Override // com.opos.mobad.template.g.ad.a
            public void a(int i) {
                r.this.n.a(i);
            }
        });
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        b(cVar);
        c(cVar);
        d(cVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.h;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.s == null) {
            this.n.a(cVarB);
        }
        if (this.s == null && (interfaceC0778a = this.h) != null) {
            interfaceC0778a.f();
        }
        this.s = cVarB;
        this.f = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.p;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        com.opos.mobad.template.cmn.w wVar = this.k;
        if (wVar != null && wVar.getVisibility() != 0) {
            this.k.setVisibility(0);
        }
        a(cVarB);
    }

    private void a(am amVar, com.opos.mobad.d.d.a aVar) {
        if (amVar == null) {
            amVar = am.a(this.g);
        }
        Context context = this.g;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.p = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.k = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.k.setId(View.generateViewId());
        this.k.setBackgroundColor(this.g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.k.setLayoutParams(layoutParams);
        this.k.setVisibility(8);
        this.p.addView(this.k, layoutParams);
        this.p.setLayoutParams(layoutParams);
        a(aVar);
        h();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.r.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (r.this.h != null) {
                    r.this.h.h(view, iArr);
                }
            }
        };
        this.k.setOnClickListener(pVar);
        this.k.setOnTouchListener(pVar);
        this.k.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.r.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo6", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (r.this.h != null) {
                    r.this.h.a(view, i4, z);
                }
            }
        });
    }
}
