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
import com.opos.mobad.template.g.ab;
import com.opos.mobad.template.g.ae;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l implements com.opos.mobad.template.a {
    private int b;
    private int c;
    private int d;
    private Context f;
    private a.InterfaceC0778a g;
    private int h;
    private ab i;
    private TextView j;
    private com.opos.mobad.template.d.c k;
    private com.opos.mobad.template.cmn.baseview.c l;
    private com.opos.mobad.template.cmn.w m;
    private com.opos.mobad.template.cmn.aa n;
    private ae o;
    private af p;
    private com.opos.mobad.d.a r;
    private boolean t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9796a = false;
    private int e = 0;
    private boolean s = false;
    private Runnable u = new Runnable() { // from class: com.opos.mobad.template.g.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f9796a) {
                return;
            }
            int iG = l.this.o.g();
            int iH = l.this.o.h();
            if (l.this.g != null) {
                l.this.g.d(iG, iH);
            }
            l.this.o.f();
            l.this.q.postDelayed(this, 500L);
        }
    };
    private Handler q = new Handler(Looper.getMainLooper());

    private l(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.f = context;
        this.h = i;
        this.r = aVar2;
        f();
        a(amVar, aVar);
        i();
        h();
    }

    public static l a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new l(context, amVar, i, aVar, aVar2);
    }

    private void g() {
        TextView textView = new TextView(this.f);
        this.j = textView;
        textView.setId(View.generateViewId());
        this.j.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.j.setTextSize(1, 17.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.j.setMaxLines(2);
        this.m.addView(this.j, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void h() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.l.6
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (l.this.k == null) {
                    return;
                }
                if (z && !l.this.s) {
                    l.this.s = true;
                    if (l.this.g != null) {
                        l.this.g.a((Map<String, String>) null);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "BlockBigImageVideo10 onWindowVisibilityChanged：" + z);
                if (l.this.t) {
                    if (z) {
                        l.this.o.d();
                    } else {
                        l.this.o.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.l.7
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (l.this.k == null) {
                    return;
                }
                if (l.this.g != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    l.this.g.a(map);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "BlockBigImageVideo10 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.l.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void i() {
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.h;
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
        this.c = com.opos.cmn.an.h.f.a.a(this.f, 258.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.f, 180.0f);
        this.d = this.c;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (!this.f9796a) {
            this.o.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "current state has stop mDestroy =" + this.f9796a);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "start countdown...");
        if (!this.f9796a) {
            this.o.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "error state mDestroy " + this.f9796a);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "destroy");
        this.f9796a = true;
        ae aeVar = this.o;
        if (aeVar != null) {
            aeVar.c();
        }
        this.k = null;
        this.q.removeCallbacks(this.u);
        com.opos.mobad.template.cmn.aa aaVar = this.n;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.m = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.m.setVisibility(4);
        this.l.addView(this.m, layoutParams);
        g();
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.f);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.f, 6.0f));
        wVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams2.addRule(3, this.j.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.m.addView(wVar2, layoutParams2);
        a(aVar, wVar2);
        b(wVar2);
        a(wVar2);
    }

    private void b(com.opos.mobad.template.cmn.w wVar) {
        this.p = af.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 10.0f);
        wVar.addView(this.p, layoutParams);
    }

    private void a(com.opos.mobad.d.d.a aVar, com.opos.mobad.template.cmn.w wVar) {
        this.o = ae.a(this.f, this.b, this.e, aVar);
        wVar.addView(this.o, new RelativeLayout.LayoutParams(this.b, this.e));
        this.o.a(new ae.a() { // from class: com.opos.mobad.template.g.l.5
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                l.this.q.removeCallbacks(l.this.u);
                l.this.q.postDelayed(l.this.u, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                l.this.q.removeCallbacks(l.this.u);
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.g = interfaceC0778a;
        this.o.a(interfaceC0778a);
        this.i.a(interfaceC0778a);
        this.p.a(interfaceC0778a);
        this.p.a(new ab.a() { // from class: com.opos.mobad.template.g.l.2
            @Override // com.opos.mobad.template.g.ab.a
            public void a(int i) {
                l.this.o.a(i);
            }
        });
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        this.i = ab.a(this.f, this.r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(3, wVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 6.0f);
        this.m.addView(this.i, layoutParams);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        String str = bVar.f9413a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.j.setText(str);
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        this.i.a(cVar.p, cVar.q, cVar.e, cVar.f, cVar.i, cVar.A, cVar.b);
        a((com.opos.mobad.template.d.b) cVar);
        this.p.a(cVar.A);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "data is null");
            this.g.a(1);
            return;
        }
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.g;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "render");
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.k == null) {
            this.o.a(cVarB);
        }
        if (this.k == null && (interfaceC0778a = this.g) != null) {
            interfaceC0778a.f();
        }
        this.k = cVarB;
        this.t = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.n;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.l;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.l.setVisibility(0);
        }
        a(cVarB);
    }

    private void a(am amVar, com.opos.mobad.d.d.a aVar) {
        if (amVar == null) {
            amVar = am.a(this.f);
        }
        Context context = this.f;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.n = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        this.l = new com.opos.mobad.template.cmn.baseview.c(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.n.addView(this.l, layoutParams);
        this.n.setLayoutParams(layoutParams);
        a(aVar);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.l.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (l.this.g != null) {
                    l.this.g.h(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(pVar);
        this.l.setOnTouchListener(pVar);
        this.l.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.l.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo10", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (l.this.g != null) {
                    l.this.g.a(view, i4, z);
                }
            }
        });
    }
}
