package com.opos.mobad.template.b;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.g.am;
import com.opos.mobad.template.g.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c implements com.opos.mobad.template.a {
    private int e;
    private TextView f;
    private LinearLayout g;
    private TextView h;
    private w i;
    private Animator j;
    private Context k;
    private a.InterfaceC0778a l;
    private int m;
    private int n;
    private com.opos.mobad.template.d.b o;
    private ImageView p;
    private com.opos.mobad.template.cmn.baseview.c q;
    private w r;
    private aa s;
    private com.opos.mobad.template.k.c t;
    private v u;
    private com.opos.mobad.template.a.c v;
    private ImageView w;
    private com.opos.mobad.d.a x;
    private volatile boolean b = false;
    private int c = 360;
    private int d = 58;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.baseview.f f9305a = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.b.c.4
        @Override // com.opos.mobad.template.cmn.baseview.f
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.a("BannerFullImage", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
            if (c.this.l != null) {
                c.this.l.a(view, i, z);
            }
        }
    };

    private c(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.k = context;
        this.n = i2;
        this.m = i;
        this.x = aVar;
        f();
        a(amVar);
        n();
        m();
    }

    private void f() {
        if (this.n == 0) {
            this.c = com.opos.cmn.an.h.f.a.a(this.k, 360.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.k, 58.0f);
        }
        this.e = this.d;
    }

    private void g() {
        this.w = new ImageView(this.k);
        Drawable drawable = ContextCompat.getDrawable(this.k, R.drawable.opos_mobad_close);
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this.k, R.color.opos_mobad_banner_close_normal_color));
        this.w.setImageDrawable(drawable);
        int iA = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.k, 4.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = iA2;
        layoutParams.rightMargin = iA2;
        this.w.setVisibility(4);
        this.q.addView(this.w, layoutParams);
        p.a(this.w, new p() { // from class: com.opos.mobad.template.b.c.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.l != null) {
                    c.this.l.e(view, iArr);
                }
            }
        });
    }

    private void h() {
        v vVarD = v.d(this.k, "");
        this.u = vVarD;
        vVarD.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.k, 28.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        this.q.addView(this.u, layoutParams);
        p pVar = new p() { // from class: com.opos.mobad.template.b.c.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.l != null) {
                    c.this.l.g(view, iArr);
                }
            }
        };
        this.u.setOnTouchListener(pVar);
        this.u.setOnClickListener(pVar);
        this.u.a(this.f9305a);
    }

    @TargetApi(21)
    private void i() {
        this.i = new w(this.k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, this.u.getId());
        layoutParams.addRule(7, this.u.getId());
        layoutParams.addRule(6, this.u.getId());
        layoutParams.addRule(8, this.u.getId());
        layoutParams.addRule(13);
        this.i.setBackgroundColor(0);
        this.i.a(com.opos.cmn.an.h.f.a.a(this.k, 60.0f));
        this.q.addView(this.i, layoutParams);
        this.j = a.a((RelativeLayout) this.i);
    }

    private void j() {
        LinearLayout linearLayout = new LinearLayout(this.k);
        this.g = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 8.0f);
        layoutParams.addRule(0, this.u.getId());
        this.q.addView(this.g, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        relativeLayout.setGravity(3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.k, 14.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.k, 0, 0, this.x);
        this.t = cVarA;
        cVarA.setId(View.generateViewId());
        relativeLayout.addView(this.t, layoutParams3);
        TextView textView = new TextView(this.k);
        this.f = textView;
        textView.setTextColor(Color.parseColor("#E6FFFFFF"));
        this.f.setTextSize(1, 14.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        TextPaint paint = this.f.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(0, this.t.getId());
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 4.0f);
        relativeLayout.addView(this.f, layoutParams4);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.k);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 4.0f);
        TextView textView2 = new TextView(this.k);
        this.h = textView2;
        textView2.setTextColor(Color.parseColor("#66FFFFFF"));
        this.h.setTextSize(1, 12.0f);
        this.h.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.h.setSingleLine(true);
        this.h.setVisibility(8);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        this.v = new com.opos.mobad.template.a.c(this.k, Color.parseColor("#66FFFFFF"), Color.parseColor("#33FFFFFF"));
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(5);
        this.v.setGravity(3);
        this.v.setVisibility(8);
        relativeLayout2.addView(this.h, layoutParams6);
        relativeLayout2.addView(this.v, layoutParams7);
        this.g.addView(relativeLayout, layoutParams2);
        this.g.addView(relativeLayout2, layoutParams5);
    }

    private void k() {
        w wVar = new w(this.k);
        this.r = wVar;
        wVar.setId(View.generateViewId());
        this.r.setBackgroundColor(this.k.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.d);
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
        l();
    }

    private void l() {
        ImageView imageView = new ImageView(this.k);
        this.p = imageView;
        imageView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c, this.d);
        View view = new View(this.k);
        view.setBackgroundColor(Color.parseColor("#33000000"));
        this.r.addView(this.p, layoutParams);
        this.r.addView(view, layoutParams);
    }

    private void m() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.k);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.b.c.5
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (c.this.o == null) {
                    return;
                }
                if (z) {
                    if (c.this.l != null) {
                        c.this.l.a((Map<String, String>) null);
                    }
                    if (c.this.j != null) {
                        c.this.j.start();
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BannerFullImage", "BannerFullImage onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.b.c.6
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (c.this.l != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    c.this.l.a(map);
                }
                aVar.a((a.c) null, (View) null);
            }
        }, c());
        this.q.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void n() {
        this.r.setVisibility(0);
        this.w.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BannerFullImage", "destroy");
        this.o = null;
        this.b = true;
        aa aaVar = this.s;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
        Animator animator = this.j;
        if (animator != null) {
            animator.end();
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.m;
    }

    public static c a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new c(context, amVar, i, 0, aVar);
    }

    private void d(com.opos.mobad.template.d.b bVar) {
        this.t.a(bVar.p, bVar.e, bVar.g, bVar.i);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        Animator animator = this.j;
        if (animator != null) {
            animator.resume();
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.s;
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.b)) {
            return;
        }
        this.f.setText(bVar.b);
    }

    private void c(com.opos.mobad.template.d.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f9413a)) {
            return;
        }
        this.h.setText(bVar.f9413a);
    }

    private void e(final com.opos.mobad.template.d.b bVar) {
        ImageView imageView;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (imageView = this.p) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.x.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.c, this.d, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.b.c.7
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, Bitmap bitmap) {
                if (c.this.b) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BannerFullImage", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (c.this.l != null) {
                        c.this.l.c(i);
                    }
                } else {
                    if (i == 1 && c.this.l != null) {
                        c.this.l.c(i);
                    }
                    c.this.a(bitmap);
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        Animator animator = this.j;
        if (animator != null) {
            animator.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.b.c.8
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (c.this.b || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                c.this.p.setImageBitmap(bitmap);
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.l = interfaceC0778a;
        this.t.a(interfaceC0778a);
        this.v.a(this.l);
    }

    private void a(com.opos.mobad.template.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.f9412a)) {
            this.v.setVisibility(8);
            this.h.setVisibility(0);
        } else {
            this.v.setVisibility(0);
            this.v.a(aVar.f9412a, aVar.b);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        e(bVar);
        d(bVar);
        a(bVar.j);
        a(bVar.u);
        b(bVar);
        c(bVar);
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
                    com.opos.cmn.an.f.a.b("BannerFullImage", "render");
                    if (this.o == null && (interfaceC0778a = this.l) != null) {
                        interfaceC0778a.f();
                    }
                    this.o = bVarA;
                    aa aaVar = this.s;
                    if (aaVar != null && aaVar.getVisibility() != 0) {
                        this.s.setVisibility(0);
                    }
                    com.opos.mobad.template.cmn.baseview.c cVar = this.q;
                    if (cVar != null && cVar.getVisibility() != 0) {
                        this.q.setVisibility(0);
                    }
                    a(bVarA);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BannerFullImage", str);
        this.l.a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.k);
        }
        Context context = this.k;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.c;
        this.s = new aa(context, new aa.a(i, i2, i3, i3 / this.e));
        this.q = new com.opos.mobad.template.cmn.baseview.c(this.k);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.c, -1);
        layoutParams.width = this.c;
        layoutParams.height = -1;
        this.q.setId(View.generateViewId());
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
        this.s.addView(this.q, layoutParams);
        this.s.setLayoutParams(layoutParams);
        k();
        h();
        j();
        p.a(this.q, new p() { // from class: com.opos.mobad.template.b.c.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.l != null) {
                    c.this.l.h(view, iArr);
                }
            }
        });
        i();
        this.q.a(this.f9305a);
        g();
    }

    private void a(String str) {
        if (this.u == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.u.a(str);
    }
}
