package com.bytedance.sdk.openadsdk.core.component.reward.business.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nr.nr;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f5228a;
    private ViewGroup b;
    private ImageView fx;
    private LinearLayout iz;
    private final nr jk;
    private ObjectAnimator n;
    private final bc nr;
    private View pn;
    private final TTBaseVideoActivity u;
    private TextView x;

    public u(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, nr nrVar) {
        this.u = tTBaseVideoActivity;
        this.nr = bcVar;
        this.jk = nrVar;
    }

    public void b() {
        ObjectAnimator objectAnimator = this.n;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.n.cancel();
            this.n = null;
        }
        ObjectAnimator objectAnimator2 = this.f5228a;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f5228a.cancel();
            this.f5228a = null;
        }
        LinearLayout linearLayout = this.iz;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.pn;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.fx;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.jk.n();
    }

    public void fx() {
        b();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pn, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.u.u.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                u.this.pn.setAlpha(1.0f);
                u.this.jk.a();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public int nr() {
        int identifier = this.u.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.u.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void u(ViewGroup viewGroup, View view) {
        this.b = viewGroup;
        this.pn = view;
        this.fx = new ImageView(this.u);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, y.fx(this.u, 76.0f));
        layoutParams.gravity = 80;
        this.fx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.addView(this.fx, layoutParams);
    }

    public void u() {
        int iSx;
        LinearLayout linearLayout = new LinearLayout(this.u);
        this.iz = linearLayout;
        linearLayout.setGravity(1);
        this.iz.setPadding(0, y.fx(this.u, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, y.fx(this.u, 76.0f));
        TextView textView = new TextView(this.u);
        this.x = textView;
        textView.setTextSize(12.0f);
        this.x.setTextColor(-1);
        this.x.setSingleLine();
        this.x.setEllipsize(TextUtils.TruncateAt.START);
        this.x.setGravity(5);
        this.x.setMaxWidth(y.fx(this.u, 260.0f));
        this.iz.addView(this.x);
        TextView textView2 = new TextView(this.u);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.u.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.b();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = y.fx(this.u, 10.0f);
        this.iz.addView(textView2, layoutParams2);
        u(25, zx.nr(this.nr));
        int iFx = y.fx(this.u, 76.0f);
        this.b.addView(this.iz, layoutParams);
        try {
            int iNr = n.nr(this.u);
            if (y.b((Activity) this.u)) {
                iSx = (n.fx(this.u) - iNr) - nr();
            } else {
                iSx = y.sx(this.u);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.iz, "translationY", iNr, (iNr - iFx) + iSx);
            this.n = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.n.start();
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pn, "translationY", 0.0f, -iFx);
            this.f5228a = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.f5228a.start();
        } catch (Throwable th) {
            k.nr("layout", th.getMessage());
        }
    }

    public void u(final int i, String str) {
        com.bytedance.sdk.openadsdk.n.nr.u(str).type(2).config(Bitmap.Config.ARGB_8888).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.u.u.2
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my<Bitmap> myVar) {
                try {
                    Bitmap result = myVar.getResult();
                    if (result == null) {
                        return;
                    }
                    if (result.getConfig() == Bitmap.Config.RGB_565) {
                        result = result.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(u.this.u, result, i);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(u.this.u.getResources(), bitmapU);
                    x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.u.u.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (u.this.iz != null) {
                                u.this.iz.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (u.this.fx != null) {
                                u.this.fx.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    k.nr("layout", th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i2, String str2, Throwable th) {
            }
        }, 4);
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        jk jkVar = new jk();
        jkVar.fx(true);
        if (nrVar != null) {
            nrVar.u(jkVar);
            nrVar.u(null, jkVar);
        }
    }

    public void u(long j) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
