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
public class c implements com.opos.mobad.template.a {
    private int b;
    private int c;
    private int f;
    private Context g;
    private a.InterfaceC0778a h;
    private int i;
    private int j;
    private com.opos.mobad.template.d.b k;
    private ImageView l;
    private ab m;
    private TextView n;
    private w o;
    private com.opos.mobad.template.cmn.n p;
    private TextView q;
    private com.opos.mobad.template.cmn.baseview.c r;
    private com.opos.mobad.template.cmn.w s;
    private com.opos.mobad.template.cmn.aa t;
    private com.opos.mobad.d.a u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9713a = false;
    private int d = 0;
    private int e = 0;

    private c(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.g = context;
        this.j = i2;
        this.i = i;
        this.u = aVar;
        f();
        a(amVar);
        j();
        i();
    }

    private void f() {
        this.d = com.opos.cmn.an.h.f.a.a(this.g, 320.0f);
        this.b = com.opos.cmn.an.h.f.a.a(this.g, 320.0f);
        this.c = com.opos.cmn.an.h.f.a.a(this.g, 306.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.g, 180.0f);
        this.f = this.c;
    }

    private void g() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.s = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.s.setVisibility(4);
        this.r.addView(this.s, layoutParams);
        h();
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        a(relativeLayout);
        b(relativeLayout);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        a(wVar);
        b(wVar);
    }

    private void i() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.c.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (c.this.k == null) {
                    return;
                }
                if (z) {
                    if (c.this.h != null) {
                        c.this.h.a((Map<String, String>) null);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.c.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (c.this.k == null) {
                    return;
                }
                if (c.this.h != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    c.this.h.a(map);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.r.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void j() {
        this.s.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.t;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.i;
    }

    public static c a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new c(context, amVar, i, 0, aVar);
    }

    private void c(com.opos.mobad.template.cmn.w wVar) {
        this.l = new ImageView(this.g);
        wVar.addView(this.l, new RelativeLayout.LayoutParams(this.d, this.e));
        this.l.setVisibility(8);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage12", "destroy");
        this.k = null;
        this.f9713a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.t;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.g);
        this.n = textView;
        textView.setId(View.generateViewId());
        this.n.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.n.setTextSize(1, 17.0f);
        this.n.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.n.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 12.0f);
        this.s.addView(this.n, layoutParams);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        String str = bVar.f9413a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0) {
            return;
        }
        a(this.l, bVar.c.get(0));
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    private void a(final ImageView imageView, final com.opos.mobad.template.d.e eVar) {
        if (imageView == null || eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.a(eVar.f9414a, eVar.b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.c.5
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (c.this.f9713a) {
                    return;
                }
                if (eVar == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage12", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (c.this.h != null) {
                        c.this.h.c(i);
                    }
                } else {
                    if (i == 1 && c.this.h != null) {
                        c.this.h.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.c.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (c.this.f9713a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void b(com.opos.mobad.template.cmn.w wVar) {
        this.m = ab.b(this.g, this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 320.0f), -2);
        layoutParams.addRule(3, wVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 6.0f);
        this.s.addView(this.m, layoutParams);
    }

    private void a(RelativeLayout relativeLayout) {
        relativeLayout.setId(View.generateViewId());
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 36.0f);
        this.s.addView(relativeLayout, new RelativeLayout.LayoutParams(this.b, iA));
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.g, com.opos.cmn.an.h.f.a.a(r2, 33.33f));
        this.p = nVar;
        nVar.setId(View.generateViewId());
        relativeLayout.addView(this.p, new RelativeLayout.LayoutParams(iA, iA));
        TextView textView = new TextView(this.g);
        this.q = textView;
        textView.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.q.setTextSize(1, 14.0f);
        this.q.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.q.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.p.getId());
        relativeLayout.addView(this.q, layoutParams);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.d.a aVar;
        String str = bVar.b;
        if (!TextUtils.isEmpty(str)) {
            this.q.setText(str);
        }
        if (bVar.k != null && !TextUtils.isEmpty(this.k.k.f9414a) && (aVar = this.u) != null) {
            a(bVar.k, aVar, this.f9713a);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 iconUrl is null");
        this.p.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.q.setLayoutParams(layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.h = interfaceC0778a;
        this.m.a(interfaceC0778a);
        w wVar = this.o;
        if (wVar != null) {
            wVar.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.cmn.w wVar) {
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 6.0f));
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams.addRule(3, this.n.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        c(wVar);
        this.s.addView(wVar, layoutParams);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        d(bVar);
        this.m.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A, bVar.b);
        c(bVar);
        b(bVar);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar, final boolean z) {
        com.opos.mobad.template.cmn.n nVar;
        if (eVar == null || (nVar = this.p) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage12", "iconUrl is null");
            return;
        }
        nVar.setVisibility(0);
        this.p.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 36.0f);
        aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.c.6
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (c.this.h != null) {
                        c.this.h.c(i);
                    }
                } else {
                    if (i == 1 && c.this.h != null) {
                        c.this.h.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            c.this.p.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
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
                    com.opos.cmn.an.f.a.b("BlockBigImage12", "render");
                    if (this.k == null && (interfaceC0778a = this.h) != null) {
                        interfaceC0778a.f();
                    }
                    this.k = bVarA;
                    com.opos.mobad.template.cmn.aa aaVar = this.t;
                    if (aaVar != null && aaVar.getVisibility() != 0) {
                        this.t.setVisibility(0);
                    }
                    com.opos.mobad.template.cmn.baseview.c cVar = this.r;
                    if (cVar != null && cVar.getVisibility() != 0) {
                        this.r.setVisibility(0);
                    }
                    a(bVarA);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage12", str);
        this.h.a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.g);
        }
        Context context = this.g;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.t = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.f));
        this.r = new com.opos.mobad.template.cmn.baseview.c(this.g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.r.setId(View.generateViewId());
        this.r.setLayoutParams(layoutParams);
        this.r.setVisibility(8);
        this.t.addView(this.r, layoutParams);
        this.t.setLayoutParams(layoutParams);
        g();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.c.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.h != null) {
                    c.this.h.h(view, iArr);
                }
            }
        };
        this.r.setOnClickListener(pVar);
        this.r.setOnTouchListener(pVar);
        this.r.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.c.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBigImage12", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (c.this.h != null) {
                    c.this.h.a(view, i4, z);
                }
            }
        });
    }
}
