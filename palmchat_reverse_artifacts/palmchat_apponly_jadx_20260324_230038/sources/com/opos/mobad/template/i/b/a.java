package com.opos.mobad.template.i.b;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.baseview.c;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.cmn.x;
import com.opos.mobad.template.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends c implements com.opos.mobad.template.e.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10103a;
    private boolean b;
    private x c;
    private BaseTextView d;
    private int e;
    private int f;
    private int g;
    private String h;
    private Animator i;
    private Animator j;
    private w l;
    private Animator m;

    public a(@NonNull Context context, int i) {
        super(context);
        this.b = false;
        this.e = 312;
        this.f = 60;
        this.g = 18;
        this.h = "";
        this.f10103a = i;
        d();
    }

    private void d() {
        setId(View.generateViewId());
        setMinimumHeight(com.opos.cmn.an.h.f.a.a(getContext(), 22.0f));
        x xVar = new x(getContext());
        this.c = xVar;
        xVar.setId(View.generateViewId());
        this.c.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.e), com.opos.cmn.an.h.f.a.a(getContext(), this.f));
        layoutParams.addRule(13);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        this.c.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_splash_click));
        this.c.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 13.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f), 0);
        this.c.setGravity(17);
        addView(this.c, layoutParams);
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.d = baseTextView;
        baseTextView.setText(this.h);
        this.d.setTextSize(0, com.opos.cmn.an.h.f.a.a(getContext(), this.g));
        this.d.setTextColor(-1);
        this.d.setGravity(17);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setSingleLine();
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.opos_mobad_splash_right_side_arrow);
        drawable.setBounds(com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 15.0f), com.opos.cmn.an.h.f.a.a(getContext(), 17.0f));
        this.d.setCompoundDrawables(null, null, drawable, null);
        this.d.setPadding(0, 0, com.opos.cmn.an.h.f.a.a(getContext(), 9.0f), 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.c.addView(this.d, layoutParams2);
        w wVar = new w(getContext());
        this.l = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.c.getId());
        layoutParams3.addRule(7, this.c.getId());
        layoutParams3.addRule(6, this.c.getId());
        layoutParams3.addRule(8, this.c.getId());
        layoutParams3.addRule(13);
        this.l.setBackgroundColor(0);
        this.l.a(com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        addView(this.l, layoutParams3);
    }

    private void e() {
        if (com.opos.mobad.template.i.a.a.g(this.f10103a) && this.m == null) {
            this.m = ae.a((RelativeLayout) this.l);
        }
    }

    public View a() {
        return this.c;
    }

    public void b() {
        if (h.a()) {
            Animator animator = this.i;
            if (animator == null || !animator.isRunning()) {
                Animator animator2 = this.j;
                if (animator2 == null || !animator2.isRunning()) {
                    if (this.j == null) {
                        this.j = ae.c((View) this);
                    }
                    this.j.start();
                }
            }
        }
    }

    public void c() {
        Animator animator;
        e();
        Animator animator2 = this.m;
        if ((animator2 == null || !animator2.isRunning()) && (animator = this.m) != null) {
            animator.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (h.a() && !this.b) {
            this.b = true;
            Animator animatorB = ae.b((View) this);
            this.i = animatorB;
            animatorB.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
        Animator animator = this.m;
        if (animator != null) {
            animator.resume();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
        Animator animator = this.m;
        if (animator != null) {
            animator.pause();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
        h.a(this.i);
        h.a(this.j);
        h.a(this.m);
    }

    public void a(com.opos.mobad.template.e.c.a aVar) {
        View viewC;
        if (aVar == null || this.d == null || (viewC = aVar.c()) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
        }
        this.c.removeView(this.d);
        if (viewC.getParent() != null) {
            ((ViewGroup) viewC.getParent()).removeView(viewC);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 26.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams2.gravity = 16;
        this.c.addView(viewC, layoutParams2);
        this.c.addView(this.d, layoutParams);
        this.c.setClipChildren(false);
    }

    public void a(String str) {
        this.h = str;
        this.d.setText(str);
    }
}
