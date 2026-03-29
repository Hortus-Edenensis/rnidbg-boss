package com.opos.cmn.module.ui.c.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.cmn.module.ui.c.d.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f8070a;
    protected c b;
    protected RelativeLayout c;
    protected ImageView d;
    protected int[] e = new int[4];

    public a(Context context, c cVar) {
        this.f8070a = context.getApplicationContext();
        this.b = cVar;
        c();
        b();
    }

    private void c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f8070a);
        this.c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f8070a), com.opos.cmn.an.h.f.a.a(this.f8070a, 90.0f)));
        com.opos.cmn.module.ui.d.a.a(this.c, com.opos.cmn.an.e.a.a.c(this.f8070a, "opos_module_biz_ui_cmn_reminder_toast_bg_img.png"));
        d();
    }

    private void d() {
        ImageView imageView = new ImageView(this.f8070a);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8070a, 16.0f), com.opos.cmn.an.h.f.a.a(this.f8070a, 16.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        this.c.addView(this.d, layoutParams);
    }

    public View a() {
        return this.c;
    }

    public abstract void a(String str, boolean z, Object... objArr);

    public abstract void b();

    public void a(View view) {
        view.setOnClickListener(null);
    }

    public void a(final View view, final String str) {
        view.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.e));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.module.ui.c.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a aVar = a.this;
                aVar.b.a(view, aVar.e, str, new Object[0]);
            }
        });
    }

    public void a(final String str) {
        this.d.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.e));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.module.ui.c.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                aVar.b.b(aVar.d, aVar.e, str, new Object[0]);
            }
        });
    }
}
