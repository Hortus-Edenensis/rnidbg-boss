package com.opos.mobad.video.player.h.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.template.a;
import com.opos.mobad.ui.c.e;
import com.opos.mobad.video.player.h.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f10366a;
    protected RelativeLayout b;
    protected TextView d;
    protected TextView e;
    protected com.opos.cmn.module.ui.a.c f;
    protected TextView g;
    protected TextView h;
    protected RelativeLayout i;
    protected com.opos.mobad.template.a.c j;
    protected View k;
    protected a.InterfaceC0778a l;
    protected com.opos.mobad.video.player.h.a m;
    protected e n;
    protected int o;
    protected int p;
    protected int q;
    protected int r;
    protected com.opos.mobad.template.d.d s;
    protected com.opos.mobad.d.a t;
    private int x;
    protected int[] c = new int[4];
    protected volatile boolean u = false;
    protected a.InterfaceC0819a v = new a.InterfaceC0819a() { // from class: com.opos.mobad.video.player.h.a.a.3
        @Override // com.opos.mobad.video.player.h.a.InterfaceC0819a
        public void a() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "end to scale");
            e eVar = a.this.n;
            if (eVar != null) {
                eVar.b();
            }
            com.opos.mobad.video.player.h.a aVar = a.this.m;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.video.player.h.a.InterfaceC0819a
        public void b() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "start to scale");
            e eVar = a.this.n;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // com.opos.mobad.video.player.h.a.InterfaceC0819a
        public void a(boolean z) {
        }
    };
    protected e.a w = new e.a() { // from class: com.opos.mobad.video.player.h.a.a.4
        @Override // com.opos.mobad.ui.c.e.a
        public boolean a() {
            return a.this.u;
        }
    };

    public a(Context context, int i, a.InterfaceC0778a interfaceC0778a, com.opos.mobad.d.a aVar) {
        this.f10366a = context.getApplicationContext();
        this.l = interfaceC0778a;
        this.x = i;
        this.t = aVar;
        f();
        g();
        k();
    }

    private void k() {
        com.opos.mobad.video.player.h.a aVar = new com.opos.mobad.video.player.h.a(this.f10366a);
        this.m = aVar;
        aVar.a(this.v);
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.addView(this.m);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.u = true;
        try {
            RelativeLayout relativeLayout = this.b;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.b = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("BaseFloatLayerView", "destroy() fail", e);
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.x;
    }

    public void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f10366a);
        this.b = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#c0000000"));
        this.b.setClickable(true);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.i = new RelativeLayout(this.f10366a);
        this.o = h.a();
        this.p = h.a();
        this.q = h.a();
        this.r = h.a();
    }

    public abstract void g();

    public void h() {
        if (this.s != null) {
            return;
        }
        TextView textView = new TextView(this.f10366a);
        this.e = textView;
        textView.setGravity(17);
        h.a(this.e, com.opos.cmn.an.e.a.a.c(this.f10366a, "opos_module_biz_ui_reward_video_float_layer_close_bn.png"));
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            relativeLayout.addView(this.e, i());
        }
    }

    public abstract RelativeLayout.LayoutParams i();

    public void j() {
        this.e.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.c));
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.video.player.h.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                a.InterfaceC0778a interfaceC0778a = aVar.l;
                if (interfaceC0778a != null) {
                    interfaceC0778a.e(view, aVar.c);
                }
            }
        });
    }

    public void a(View view) {
        if (view != null) {
            try {
                view.setOnTouchListener(null);
                view.setOnClickListener(null);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("BaseFloatLayerView", "", (Throwable) e);
            }
        }
    }

    public void a(View view, final com.opos.mobad.cmn.func.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.c));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.video.player.h.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a aVar2 = a.this;
                    a.InterfaceC0778a interfaceC0778a = aVar2.l;
                    if (interfaceC0778a != null) {
                        com.opos.mobad.cmn.func.b.a aVar3 = aVar;
                        com.opos.mobad.cmn.func.b.a aVar4 = com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT;
                        int[] iArr = aVar2.c;
                        if (aVar3 == aVar4) {
                            interfaceC0778a.j(view2, iArr);
                        } else {
                            interfaceC0778a.i(view2, iArr);
                        }
                    }
                }
            });
        }
    }

    public void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    public void a(TextView textView, String str) {
        if (textView != null) {
            if (com.opos.cmn.an.d.b.a(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.l = interfaceC0778a;
    }

    public void a(String str) {
        a(this.d, str);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }
}
