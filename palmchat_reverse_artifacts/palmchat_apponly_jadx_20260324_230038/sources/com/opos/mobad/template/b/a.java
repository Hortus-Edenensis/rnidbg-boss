package com.opos.mobad.template.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static Animator a(View view) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.96f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.96f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1200L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.3f, 0.0f, 0.67f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static Animator a(RelativeLayout relativeLayout) {
        relativeLayout.removeAllViews();
        Context context = relativeLayout.getContext();
        int iA = com.opos.cmn.an.h.f.a.a(context, 72.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.opos_mobad_btn_splash_2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAlpha(0.0f);
        relativeLayout.addView(imageView, layoutParams);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("x", iA * (-1), iA), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1217L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolatorCreate);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(217L);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
