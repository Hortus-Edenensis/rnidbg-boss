package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ek;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSSplashProView extends RelativeLayout {
    private View B;
    private ScanningRelativeLayout C;
    private ImageView D;
    private TextView F;
    private boolean L;
    private int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6976a;
    private RoundLinearLayout b;
    private AnimatorSet c;
    private AnimatorSet d;
    private AnimatorSet e;
    private AnimatorSet f;
    private AnimatorSet g;
    private AnimatorSet h;

    public PPSSplashProView(Context context) {
        super(context);
        this.S = 1;
        this.f6976a = 1;
        Code(context);
    }

    public void Code() {
        ScanningRelativeLayout scanningRelativeLayout = this.C;
        if (scanningRelativeLayout != null) {
            scanningRelativeLayout.I();
        }
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.d = null;
        }
        AnimatorSet animatorSet2 = this.c;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.c = null;
        }
        AnimatorSet animatorSet3 = this.e;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
            this.e = null;
        }
        AnimatorSet animatorSet4 = this.f;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
            this.f = null;
        }
        AnimatorSet animatorSet5 = this.g;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
            this.g = null;
        }
        AnimatorSet animatorSet6 = this.h;
        if (animatorSet6 != null) {
            animatorSet6.cancel();
            this.h = null;
        }
    }

    public int getMode() {
        return this.S;
    }

    public void setDesc(String str) {
        if (this.F != null) {
            if (TextUtils.isEmpty(str)) {
                this.F.setText(R.string.hiad_splash_pro_desc);
            } else {
                this.F.setText(str);
            }
        }
    }

    public void setMode(int i) {
        this.S = i;
    }

    public void setOrientation(int i) {
        this.f6976a = i;
    }

    public PPSSplashProView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = 1;
        this.f6976a = 1;
        Code(context);
    }

    private void B() {
        this.e = new AnimatorSet();
        this.f = new AnimatorSet();
        this.g = new AnimatorSet();
        this.h = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.D, "scaleX", 1.0f, 1.225f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.0f, 1.225f);
        objectAnimatorOfFloat.setDuration(350L);
        objectAnimatorOfFloat2.setDuration(350L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.D, "scaleX", 1.225f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.225f, 1.0f);
        objectAnimatorOfFloat3.setDuration(500L);
        objectAnimatorOfFloat4.setDuration(500L);
        this.g.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat3);
        this.h.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat4);
        this.g.setInterpolator(new ek(0.2f, 0.0f, 0.2f, 1.0f));
        this.h.setInterpolator(new ek(0.2f, 0.0f, 0.2f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.D, "scaleX", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.0f, 0.0f);
        objectAnimatorOfFloat5.setDuration(0L);
        objectAnimatorOfFloat6.setDuration(0L);
        objectAnimatorOfFloat5.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    PPSSplashProView.this.D.setVisibility(0);
                } catch (Throwable th) {
                    fh.I("PPSSplashProView", "arrowImage set visible err: %s", th.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.D, "scaleX", 0.0f, 1.225f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.D, "scaleY", 0.0f, 1.225f);
        objectAnimatorOfFloat7.setDuration(400L);
        objectAnimatorOfFloat8.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.D, "scaleX", 1.225f, 0.989f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.225f, 0.989f);
        objectAnimatorOfFloat9.setDuration(500L);
        objectAnimatorOfFloat10.setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(this.D, "scaleX", 0.989f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(this.D, "scaleY", 0.989f, 1.0f);
        objectAnimatorOfFloat11.setDuration(350L);
        objectAnimatorOfFloat12.setDuration(350L);
        this.e.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat7, objectAnimatorOfFloat9, objectAnimatorOfFloat11);
        this.f.playSequentially(objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat10, objectAnimatorOfFloat12);
        this.e.setInterpolator(new ek(0.2f, 0.0f, 0.2f, 1.0f));
        this.f.setInterpolator(new ek(0.2f, 0.0f, 0.2f, 1.0f));
        this.e.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashProView.this.g == null || PPSSplashProView.this.h == null) {
                            return;
                        }
                        PPSSplashProView.this.g.start();
                        PPSSplashProView.this.h.start();
                    }
                }, 450L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void Code(Context context) {
        String str;
        try {
            View viewInflate = View.inflate(context, R.layout.hiad_layout_splash_pro, this);
            this.B = viewInflate;
            this.C = (ScanningRelativeLayout) viewInflate.findViewById(R.id.hiad_pro_layout);
            this.b = (RoundLinearLayout) this.B.findViewById(R.id.hiad_pro_desc_layout);
            this.C.setBackground(getResources().getDrawable(R.drawable.hiad_splash_pro_bg));
            this.F = (TextView) this.B.findViewById(R.id.hiad_pro_desc);
            this.D = (ImageView) this.B.findViewById(R.id.hiad_pro_arrow);
            V();
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            fh.I("PPSSplashProView", str);
        } catch (Exception unused2) {
            str = "init error";
            fh.I("PPSSplashProView", str);
        }
    }

    private void I() {
        fh.V("PPSSplashProView", "showLogo:" + this.L + ",orientation:" + this.f6976a);
        if (this.L || this.f6976a != 1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin += bg.I(getContext());
            setLayoutParams(layoutParams2);
        }
    }

    private void V() {
        TextView textView;
        float fN;
        Context applicationContext = getContext().getApplicationContext();
        eh ehVarCode = eh.Code(applicationContext);
        int iV = z.V(applicationContext, ehVarCode.M());
        int iO = ehVarCode.O();
        int iV2 = z.V(applicationContext, ehVarCode.N());
        final int iV3 = z.V(applicationContext, ehVarCode.V(applicationContext));
        this.C.setRadius(iO);
        this.b.setRectCornerRadius(z.V(applicationContext, iO));
        this.C.setMinimumHeight(iV);
        int i = 2;
        if (z.e(getContext())) {
            textView = this.F;
            fN = ehVarCode.N() * 2;
            i = 1;
        } else {
            textView = this.F;
            fN = ehVarCode.N();
        }
        textView.setTextSize(i, fN);
        this.F.setMinimumHeight(iV);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.height = iV2;
        layoutParams.width = iV2;
        this.D.setLayoutParams(layoutParams);
        this.B.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams2 = PPSSplashProView.this.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.bottomMargin = iV3;
                    PPSSplashProView.this.setLayoutParams(layoutParams3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        fh.V("PPSSplashProView", "startAnimators");
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.C, "scaleX", 0.85f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.C, "scaleY", 0.85f, 1.0f);
            objectAnimatorOfFloat2.setDuration(300L);
            objectAnimatorOfFloat3.setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.c = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat);
            this.c.setInterpolator(new ek(0.2f, 0.0f, 0.2f, 1.0f));
            this.c.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    fh.V("PPSSplashProView", "upAndAlphaSet onAnimationEnd");
                    try {
                        PPSSplashProView.this.C.V();
                        if (PPSSplashProView.this.e == null || PPSSplashProView.this.f == null) {
                            return;
                        }
                        PPSSplashProView.this.e.start();
                        PPSSplashProView.this.f.start();
                    } catch (Throwable th) {
                        fh.I("PPSSplashProView", "scale err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    try {
                        PPSSplashProView.this.C.Code();
                    } catch (Throwable th) {
                        fh.I("PPSSplashProView", "prepare err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.C, "scaleX", 1.0f, 0.85f);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.C, "scaleY", 1.0f, 0.85f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.d = animatorSet2;
            animatorSet2.setDuration(0L);
            this.d.setInterpolator(new ek(0.2f, 0.0f, 0.2f, 1.0f));
            this.d.playTogether(objectAnimatorOfFloat4, objectAnimatorOfFloat5);
            this.d.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    fh.V("PPSSplashProView", "scaleAnimationDown onAnimationEnd");
                    try {
                        PPSSplashProView.this.setVisibility(0);
                        if (PPSSplashProView.this.c != null) {
                            PPSSplashProView.this.c.start();
                        }
                    } catch (Throwable th) {
                        fh.I("PPSSplashProView", "up and alpha err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.D.setVisibility(4);
            B();
            this.d.start();
        } catch (Throwable th) {
            fh.I("PPSSplashProView", "anim error: %s", th.getClass().getSimpleName());
            RoundLinearLayout roundLinearLayout = this.b;
            if (roundLinearLayout != null) {
                roundLinearLayout.setBackground(getResources().getDrawable(R.drawable.hiad_splash_pro_bg_scan));
            }
            setVisibility(0);
        }
    }

    public PPSSplashProView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.S = 1;
        this.f6976a = 1;
        Code(context);
    }

    public void Code(boolean z, int i) {
        this.L = z;
        if (this.C != null && i == 0) {
            RoundLinearLayout roundLinearLayout = this.b;
            if (roundLinearLayout != null) {
                roundLinearLayout.setBackground(getResources().getDrawable(R.drawable.hiad_splash_pro_bg_scan));
                this.b.setAlpha(0.0f);
            }
            this.C.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (i4 - i2 <= 0 || i5 - i3 <= 0 || i6 != 0 || i8 != 0) {
                        return;
                    }
                    PPSSplashProView.this.Z();
                }
            });
        }
        I();
    }
}
