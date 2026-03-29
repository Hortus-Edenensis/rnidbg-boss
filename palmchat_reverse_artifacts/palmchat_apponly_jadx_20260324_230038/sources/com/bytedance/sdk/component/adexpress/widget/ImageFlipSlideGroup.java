package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.utils.ja;
import com.bytedance.sdk.component.utils.q;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ImageFlipSlideGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5109a;
    float b;
    ImageView fx;
    boolean iz;
    private String jk;
    private String l;
    private List<String> mv;
    private ImageFlipSlide n;
    BookPageView nr;
    ObjectAnimator pn;
    private String t;
    FrameLayout u;
    boolean x;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.b = 0.0f;
        this.x = z;
        b();
        setVisibility(4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    private void b() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.x);
        this.n = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.u = frameLayout;
        addView(frameLayout);
        if (!this.x) {
            BookPageView bookPageView = new BookPageView(getContext());
            this.nr = bookPageView;
            this.u.addView(bookPageView);
            return;
        }
        View view = new View(getContext());
        view.setBackgroundColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ja.u(getContext(), 2.0f), -1);
        layoutParams.gravity = 17;
        this.u.addView(view, layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(q.pn(getContext(), "tt_im_fs_handle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ja.u(getContext(), 44.0f), ja.u(getContext(), 44.0f));
        layoutParams2.gravity = 17;
        this.u.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        this.fx = imageView2;
        imageView2.setImageResource(q.pn(getContext(), "tt_im_fs_tip"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(ja.u(getContext(), 196.0f), ja.u(getContext(), 300.0f));
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = ja.u(getContext(), 6.0f);
        this.u.addView(this.fx, layoutParams3);
    }

    public void fx() {
        if (TextUtils.isEmpty(this.jk)) {
            this.n.u(this.f5109a, this.t, this.mv);
        } else {
            this.n.u(this.jk, this.l, (List<String>) null);
        }
    }

    public float getRatio() {
        return this.b;
    }

    public void nr() {
        ObjectAnimator objectAnimator = this.pn;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void setFilterColors(List<String> list) {
        this.mv = list;
    }

    public void setRatio(float f) {
        this.b = f;
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup imageFlipSlideGroup = ImageFlipSlideGroup.this;
                if (imageFlipSlideGroup.x) {
                    imageFlipSlideGroup.n.u(ImageFlipSlideGroup.this.b);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.u.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.b) - 0.5f) * r1.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.u.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                float width = ImageFlipSlideGroup.this.getWidth();
                float width2 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup2 = ImageFlipSlideGroup.this;
                point.x = ((int) (width - (width2 * imageFlipSlideGroup2.b))) - 100;
                float height = imageFlipSlideGroup2.getHeight();
                float width3 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup3 = ImageFlipSlideGroup.this;
                float f2 = imageFlipSlideGroup3.b;
                point.y = ((int) (height - (width3 * f2))) - 100;
                if (f2 > 0.3f) {
                    double d = point.x;
                    double width4 = imageFlipSlideGroup3.getWidth() * 2;
                    ImageFlipSlideGroup imageFlipSlideGroup4 = ImageFlipSlideGroup.this;
                    point.x = (int) (d - (width4 * (((double) imageFlipSlideGroup4.b) - 0.3d)));
                    point.y = (int) (((double) point.y) + (((double) (imageFlipSlideGroup4.getHeight() / 2)) * (((double) ImageFlipSlideGroup.this.b) - 0.3d)));
                }
                ImageFlipSlideGroup.this.nr.u(point);
                ImageFlipSlideGroup imageFlipSlideGroup5 = ImageFlipSlideGroup.this;
                imageFlipSlideGroup5.nr.setAlpha(1.0f - (imageFlipSlideGroup5.b - 0.3f));
                ImageFlipSlideGroup.this.n.u(ImageFlipSlideGroup.this.nr.getFilterAreaPath());
            }
        });
    }

    public void u(final DynamicImageFlipSlide.u uVar) {
        if (this.iz) {
            if (uVar != null) {
                uVar.u();
                return;
            }
            return;
        }
        this.iz = true;
        this.pn.cancel();
        if (this.fx != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.fx.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        float[] fArr = new float[2];
        fArr[0] = this.b;
        fArr[1] = this.x ? 1.1f : 1.3f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", fArr);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageFlipSlideGroup.this.u.setVisibility(8);
                DynamicImageFlipSlide.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u();
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
        objectAnimatorOfFloat.start();
    }

    public void nr(String str, String str2) {
        this.jk = str;
        this.l = str2;
    }

    public void u() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.pn = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.pn.setInterpolator(new LinearInterpolator());
        this.pn.setRepeatCount(-1);
        this.pn.setRepeatMode(2);
        this.pn.start();
    }

    public void u(String str, String str2) {
        this.f5109a = str;
        this.t = str2;
    }
}
