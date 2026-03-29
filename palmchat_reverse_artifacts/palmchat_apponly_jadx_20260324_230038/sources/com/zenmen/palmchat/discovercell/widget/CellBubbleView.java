package com.zenmen.palmchat.discovercell.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.cg4;
import defpackage.je1;
import defpackage.k86;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CellBubbleView extends ConstraintLayout {
    private String curUrl;
    private je1 imageOptions;
    private EffectiveShapeView imageView;
    private ValueAnimator imageZoomAnim;
    private EffectiveShapeView transitionView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CellBubbleView.this.transitionView.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CellBubbleView.this.transitionView.setScaleX(CellBubbleView.this.imageView.getScaleX());
            CellBubbleView.this.transitionView.setScaleY(CellBubbleView.this.imageView.getScaleY());
        }
    }

    public CellBubbleView(Context context) {
        this(context, null);
    }

    public void setImage(String str) {
        String str2 = this.curUrl;
        if (str2 == null) {
            this.transitionView.setVisibility(8);
            cg4.a(k86.p(str), this.imageView, this.imageOptions);
        } else {
            cg4.a(k86.p(str2), this.transitionView, this.imageOptions);
            cg4.a(k86.p(str), this.imageView, this.imageOptions);
            this.transitionView.setVisibility(0);
            this.transitionView.setAlpha(1.0f);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.transitionView, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(400L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfPropertyValuesHolder.addListener(new a());
            objectAnimatorOfPropertyValuesHolder.start();
        }
        this.curUrl = str;
    }

    public void startAutoPlay() {
        if (this.imageZoomAnim != null) {
            return;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.imageView, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
        this.imageZoomAnim = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(700L);
        this.imageZoomAnim.setRepeatMode(2);
        this.imageZoomAnim.setRepeatCount(-1);
        this.imageZoomAnim.setInterpolator(new AccelerateInterpolator());
        this.imageZoomAnim.addUpdateListener(new b());
        this.imageZoomAnim.start();
    }

    public void stopAutoPlay() {
        ValueAnimator valueAnimator = this.imageZoomAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.imageZoomAnim = null;
        }
    }

    public CellBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CellBubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.layout_people_match_entry_bubble, (ViewGroup) this, true);
        this.imageView = (EffectiveShapeView) findViewById(R.id.zoom_image);
        this.transitionView = (EffectiveShapeView) findViewById(R.id.zoom_image_transition);
        this.imageOptions = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.shape_people_match_photo_placeholder).A(R.drawable.shape_people_match_photo_placeholder).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.shape_people_match_photo_placeholder).r();
        int iB = me1.b(context, 100);
        this.imageView.changeShapeType(3);
        this.imageView.setDegreeForRoundRectangle(iB, iB);
        this.imageView.setBorderWidth(me1.b(context, 1));
        this.imageView.setBorderColor(Color.parseColor("#C5D0D8"));
        this.transitionView.changeShapeType(3);
        this.transitionView.setDegreeForRoundRectangle(iB, iB);
        this.transitionView.setBorderWidth(me1.b(context, 1));
        this.transitionView.setBorderColor(Color.parseColor("#C5D0D8"));
    }
}
