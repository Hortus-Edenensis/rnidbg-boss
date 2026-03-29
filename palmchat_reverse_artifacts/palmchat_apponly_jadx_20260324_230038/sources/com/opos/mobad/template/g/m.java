package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
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
import com.opos.mobad.template.g.ab;
import com.opos.mobad.template.g.ae;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class m implements com.opos.mobad.template.a {
    private int b;
    private int c;
    private int d;
    private Context f;
    private a.InterfaceC0778a g;
    private int h;
    private ab i;
    private TextView j;
    private com.opos.mobad.template.d.c k;
    private com.opos.mobad.template.cmn.n l;
    private TextView m;
    private com.opos.mobad.template.cmn.baseview.c n;
    private com.opos.mobad.template.cmn.w o;
    private com.opos.mobad.template.cmn.aa p;
    private ae q;
    private af r;
    private com.opos.mobad.d.a t;
    private boolean v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9804a = false;
    private int e = 0;
    private boolean u = false;
    private Runnable w = new Runnable() { // from class: com.opos.mobad.template.g.m.1
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f9804a) {
                return;
            }
            int iG = m.this.q.g();
            int iH = m.this.q.h();
            if (m.this.g != null) {
                m.this.g.d(iG, iH);
            }
            m.this.q.f();
            m.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    private m(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.f = context;
        this.h = i;
        this.t = aVar2;
        f();
        a(amVar, aVar);
        h();
        g();
    }

    public static m a(Context context, am amVar, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new m(context, amVar, i, aVar, aVar2);
    }

    private void g() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.m.6
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (m.this.k == null) {
                    return;
                }
                if (z && !m.this.u) {
                    m.this.u = true;
                    if (m.this.g != null) {
                        m.this.g.a((Map<String, String>) null);
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 onWindowVisibilityChanged：" + z);
                if (m.this.v) {
                    if (z) {
                        m.this.q.d();
                    } else {
                        m.this.q.e();
                    }
                }
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.m.7
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (m.this.k == null) {
                    return;
                }
                if (m.this.g != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    m.this.g.a(map);
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 onWindowVisibilityChanged：" + z + ", " + z2);
            }
        }, c());
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void h() {
        this.o.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.p;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.h;
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
        this.c = com.opos.cmn.an.h.f.a.a(this.f, 306.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.f, 180.0f);
        this.d = this.c;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (!this.f9804a) {
            this.q.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "current state has stop mDestroy =" + this.f9804a);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "start countdown...");
        if (!this.f9804a) {
            this.q.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "error state mDestroy " + this.f9804a);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "destroy");
        this.f9804a = true;
        ae aeVar = this.q;
        if (aeVar != null) {
            aeVar.c();
        }
        this.k = null;
        this.s.removeCallbacks(this.w);
        com.opos.mobad.template.cmn.aa aaVar = this.p;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void a(RelativeLayout relativeLayout) {
        relativeLayout.setId(View.generateViewId());
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 36.0f);
        this.o.addView(relativeLayout, new RelativeLayout.LayoutParams(this.b, iA));
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.f, com.opos.cmn.an.h.f.a.a(r2, 33.33f));
        this.l = nVar;
        nVar.setId(View.generateViewId());
        relativeLayout.addView(this.l, new RelativeLayout.LayoutParams(iA, iA));
        TextView textView = new TextView(this.f);
        this.m = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.m.setTextSize(1, 14.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.m.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.l.getId());
        relativeLayout.addView(this.m, layoutParams);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f);
        this.j = textView;
        textView.setId(View.generateViewId());
        this.j.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.j.setTextSize(1, 17.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.j.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.o.addView(this.j, layoutParams);
    }

    private void c(com.opos.mobad.template.cmn.w wVar) {
        this.r = af.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 10.0f);
        wVar.addView(this.r, layoutParams);
    }

    private void a(com.opos.mobad.d.d.a aVar) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.o = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        a(relativeLayout);
        b(relativeLayout);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.f);
        a(wVar2);
        a(aVar, wVar2);
        c(wVar2);
        b(wVar2);
    }

    private void b(com.opos.mobad.template.cmn.w wVar) {
        this.i = ab.a(this.f, this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(3, wVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 6.0f);
        this.o.addView(this.i, layoutParams);
    }

    private void a(com.opos.mobad.d.d.a aVar, com.opos.mobad.template.cmn.w wVar) {
        this.q = ae.a(this.f, this.b, this.e, aVar);
        wVar.addView(this.q, new RelativeLayout.LayoutParams(this.b, this.e));
        this.q.a(new ae.a() { // from class: com.opos.mobad.template.g.m.5
            @Override // com.opos.mobad.template.g.ae.a
            public void a() {
                m.this.s.removeCallbacks(m.this.w);
                m.this.s.postDelayed(m.this.w, 500L);
            }

            @Override // com.opos.mobad.template.g.ae.a
            public void b() {
                m.this.s.removeCallbacks(m.this.w);
            }
        });
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.d.a aVar;
        String str = bVar.b;
        if (!TextUtils.isEmpty(str)) {
            this.m.setText(str);
        }
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a) && (aVar = this.t) != null) {
            a(bVar.k, aVar, this.f9804a);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 iconUrl is null");
        this.l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.m.setLayoutParams(layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.g = interfaceC0778a;
        this.q.a(interfaceC0778a);
        this.i.a(interfaceC0778a);
        this.r.a(interfaceC0778a);
        this.r.a(new ab.a() { // from class: com.opos.mobad.template.g.m.2
            @Override // com.opos.mobad.template.g.ab.a
            public void a(int i) {
                m.this.q.a(i);
            }
        });
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        wVar.a(com.opos.cmn.an.h.f.a.a(this.f, 6.0f));
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams.addRule(3, this.j.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.o.addView(wVar, layoutParams);
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
        b(cVar);
        this.r.a(cVar.A);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar, final boolean z) {
        com.opos.mobad.template.cmn.n nVar;
        if (eVar == null || (nVar = this.l) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "iconUrl is null");
            return;
        }
        nVar.setVisibility(0);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 36.0f);
        aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.m.8
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (m.this.g != null) {
                        m.this.g.c(i);
                    }
                } else {
                    if (i == 1 && m.this.g != null) {
                        m.this.g.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.m.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            m.this.l.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "data is null");
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
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "render");
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.k == null) {
            this.q.a(cVarB);
        }
        if (this.k == null && (interfaceC0778a = this.g) != null) {
            interfaceC0778a.f();
        }
        this.k = cVarB;
        this.v = ak.a(cVarB);
        com.opos.mobad.template.cmn.aa aaVar = this.p;
        if (aaVar != null && aaVar.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        com.opos.mobad.template.cmn.baseview.c cVar = this.n;
        if (cVar != null && cVar.getVisibility() != 0) {
            this.n.setVisibility(0);
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
        this.p = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.d));
        this.n = new com.opos.mobad.template.cmn.baseview.c(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.n.setId(View.generateViewId());
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.p.addView(this.n, layoutParams);
        this.p.setLayoutParams(layoutParams);
        a(aVar);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.m.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (m.this.g != null) {
                    m.this.g.h(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(pVar);
        this.n.setOnTouchListener(pVar);
        this.n.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.m.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImageVideo12", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (m.this.g != null) {
                    m.this.g.a(view, i4, z);
                }
            }
        });
    }
}
