package com.opos.mobad.template.e.c.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.c;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.e.c.b;
import com.opos.mobad.template.h;
import com.opos.mobad.template.k.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.template.e.c.a implements d.a {
    private LinearLayout c;
    private ImageView d;
    private c e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private d j;

    public a(Context context, com.opos.mobad.template.e.a aVar) {
        super(context, aVar);
        this.g = false;
        this.h = false;
        this.i = false;
        a();
        b();
    }

    @Override // com.opos.mobad.template.e.c.a
    public void b() {
        if (this.f) {
            LinearLayout linearLayout = new LinearLayout(this.b);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.c.setVisibility(4);
            this.d = new ImageView(this.b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 20.0f), com.opos.cmn.an.h.f.a.a(this.b, 20.0f));
            this.d.setImageResource(R.drawable.opos_mobad_icon_hand);
            this.c.addView(this.d, layoutParams);
            TextView textView = new TextView(this.b);
            textView.setText("摇一摇或");
            textView.setTextSize(1, 12.0f);
            textView.setTextColor(-436207617);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
            layoutParams2.gravity = 16;
            this.c.addView(textView, layoutParams2);
            this.j = new d(this.b, false, this);
            a(this.b);
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public View c() {
        return this.c;
    }

    @Override // com.opos.mobad.template.e.c.a
    public boolean e() {
        return this.f;
    }

    @Override // com.opos.mobad.template.e.c.a
    public void f() {
        i();
        this.i = true;
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (this.f && !this.g) {
            this.g = true;
            LinearLayout linearLayout = this.c;
            if (linearLayout == null || linearLayout.getVisibility() == 0) {
                return;
            }
            this.c.setVisibility(0);
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        com.opos.cmn.an.f.a.b("RewardInteractiveShakeView", "isEnd:" + this.i + " mIsViewVisible:" + this.h);
        if (!this.i && this.h && this.f) {
            this.j.b();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        if (this.f) {
            this.j.c();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        this.i = true;
        d dVar = this.j;
        if (dVar != null) {
            dVar.d();
        }
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a() {
        this.f = h.a(this.b);
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.e.c.c.a.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                a.this.h = z;
                if (!z) {
                    a.this.i();
                } else {
                    a.this.g();
                    a.this.h();
                }
            }
        });
        this.c.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(f fVar) {
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(com.opos.mobad.template.e.b.a aVar) {
        d dVar;
        if (!this.f || aVar == null || (dVar = this.j) == null) {
            return;
        }
        dVar.a(aVar);
    }

    @Override // com.opos.mobad.template.e.c.a
    public void a(b bVar) {
        this.e = bVar;
    }

    @Override // com.opos.mobad.template.k.d.a
    public void a(int[] iArr) {
        c cVar;
        if (this.i || !this.h || !this.f || (cVar = this.e) == null) {
            return;
        }
        cVar.a(iArr);
        i();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.e.c.c.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.j != null) {
                    a.this.j.a();
                    a.this.h();
                }
            }
        }, com.igexin.push.config.c.j);
    }
}
