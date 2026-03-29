package com.opos.mobad.template.f;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.template.a;
import com.opos.mobad.template.f.a.a;
import com.opos.mobad.template.f.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    w f9568a;
    ImageView b;
    private int c;
    private a.InterfaceC0778a d;

    public n(Context context, int i) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        this.c = i;
        b();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.n.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (n.this.d != null) {
                    n.this.d.i(view, iArr);
                }
            }
        };
        setOnClickListener(pVar);
        setOnTouchListener(pVar);
        a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.n.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("InterstitialEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (n.this.d != null) {
                    n.this.d.a(view, i2, z);
                }
            }
        });
    }

    public static n b(Context context) {
        return new n(context, 3);
    }

    public static n c(Context context) {
        return new n(context, 0);
    }

    public static n d(Context context) {
        return new n(context, 1);
    }

    public static n e(Context context) {
        return new n(context, 4);
    }

    public static n f(Context context) {
        return new n(context, 5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public static n a(Context context) {
        return new n(context, 2);
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        this.b = imageView;
        imageView.setId(View.generateViewId());
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        c();
        d();
    }

    private void c() {
        w wVar;
        int i = this.c;
        if (i == 0) {
            w.a aVar = new w.a(60, 14, 12, 1, w.a.l, true);
            aVar.a(a.EnumC0783a.FINGER);
            wVar = new w(getContext(), aVar);
        } else if (i == 1) {
            w.a aVar2 = new w.a(60, 14, 12, 1, w.a.m, true);
            aVar2.a(a.EnumC0783a.FINGER);
            wVar = new w(getContext(), aVar2);
        } else if (i == 2) {
            w.a aVar3 = new w.a(60, 14, 12, 1, w.a.l, false);
            aVar3.a(a.EnumC0783a.FINGER);
            wVar = new w(getContext(), aVar3);
        } else if (i != 3) {
            w.a aVar4 = new w.a(64, 18, 14, 1, w.a.l, true);
            aVar4.a(a.EnumC0783a.FINGER);
            wVar = new w(getContext(), aVar4);
        } else {
            w.a aVar5 = new w.a(60, 14, 12, 1, w.a.m, false);
            aVar5.a(a.EnumC0783a.FINGER);
            wVar = new w(getContext(), aVar5);
        }
        this.f9568a = wVar;
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.n.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (n.this.d != null) {
                    n.this.d.j(view, iArr);
                }
            }
        };
        this.f9568a.f().setOnClickListener(pVar);
        this.f9568a.f().setOnTouchListener(pVar);
        this.f9568a.f().a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.n.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("InterstitialEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (n.this.d != null) {
                    n.this.d.a(view, i2, z);
                }
            }
        });
    }

    private void d() {
        int i = this.c;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 && i != 5) {
                            return;
                        }
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 145.0f));
            layoutParams.addRule(10);
            addView(this.b, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, this.b.getId());
            addView(this.f9568a, layoutParams2);
            return;
        }
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f9568a, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void e() {
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(180L);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.n.5
            @Override // java.lang.Runnable
            public void run() {
                n.this.setVisibility(0);
                objectAnimatorOfFloat.start();
            }
        });
    }

    public void a() {
        w wVar = this.f9568a;
        if (wVar != null) {
            wVar.e();
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f9568a.e();
        } else {
            this.f9568a.a(bitmap);
        }
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.d = interfaceC0778a;
    }

    public void a(String str, String str2, String str3) {
        this.f9568a.a(str, str2, str3, 0);
    }
}
