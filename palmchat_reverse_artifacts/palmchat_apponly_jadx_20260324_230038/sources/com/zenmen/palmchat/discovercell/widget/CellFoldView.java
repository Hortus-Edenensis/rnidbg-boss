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
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.cg4;
import defpackage.je1;
import defpackage.k86;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CellFoldView extends ConstraintLayout {
    private ValueAnimator bgFoldAnim;
    private View bgView;
    private String curUrl;
    private long foldDuration;
    private long foldInterval;
    private Runnable foldRunnable;
    private ValueAnimator iconAnim;
    private View iconView;
    private ValueAnimator imageFoldAnim;
    private je1 imageOptions;
    private EffectiveShapeView imageView;
    private long scaleDuration;
    private EffectiveShapeView transitionView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CellFoldView.this.startFoldAnimation();
            CellFoldView cellFoldView = CellFoldView.this;
            cellFoldView.postDelayed(cellFoldView.foldRunnable, CellFoldView.this.foldInterval);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CellFoldView.this.transitionView.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CellFoldView.this.transitionView.setRotation(CellFoldView.this.imageView.getRotation());
        }
    }

    public CellFoldView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFoldAnimation() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.bgView, PropertyValuesHolder.ofFloat(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 10.0f, 0.0f, 10.0f));
        this.bgFoldAnim = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(this.foldDuration);
        this.bgFoldAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bgFoldAnim.start();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.imageView, PropertyValuesHolder.ofFloat(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, -10.0f, 0.0f, -10.0f));
        this.imageFoldAnim = objectAnimatorOfPropertyValuesHolder2;
        objectAnimatorOfPropertyValuesHolder2.setDuration(this.foldDuration);
        this.imageFoldAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.imageFoldAnim.addUpdateListener(new c());
        this.imageFoldAnim.start();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.bgView.setPivotX((r2.getWidth() * 3.0f) / 4.0f);
        this.bgView.setPivotY(r2.getHeight());
        this.imageView.setPivotX(r2.getWidth() / 4);
        this.imageView.setPivotY(r2.getHeight());
        this.transitionView.setPivotX(r2.getWidth() / 4);
        this.transitionView.setPivotY(r2.getHeight());
    }

    public void setFoldDuration(long j) {
        this.foldDuration = j;
    }

    public void setFoldInterval(long j) {
        this.foldInterval = j;
    }

    public void setImage(String str) {
        String str2 = this.curUrl;
        if (str2 == null) {
            this.transitionView.setVisibility(8);
            cg4.a(k86.p(str), this.imageView, this.imageOptions);
        } else if (!str2.equals(str)) {
            cg4.a(k86.p(this.curUrl), this.transitionView, this.imageOptions);
            cg4.a(k86.p(str), this.imageView, this.imageOptions);
            this.transitionView.setVisibility(0);
            this.transitionView.setAlpha(1.0f);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.transitionView, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(400L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfPropertyValuesHolder.addListener(new b());
            objectAnimatorOfPropertyValuesHolder.start();
        }
        this.curUrl = str;
    }

    public void setScaleDuration(long j) {
        this.scaleDuration = j;
    }

    public void startAutoPlay() {
        removeCallbacks(this.foldRunnable);
        postDelayed(this.foldRunnable, this.foldInterval);
        if (this.iconAnim != null) {
            return;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iconView, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.8f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.8f));
        this.iconAnim = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setDuration(this.scaleDuration);
        this.iconAnim.setRepeatMode(2);
        this.iconAnim.setRepeatCount(-1);
        this.iconAnim.setInterpolator(new AccelerateInterpolator());
        this.iconAnim.start();
    }

    public void stopAutoPlay() {
        removeCallbacks(this.foldRunnable);
        ValueAnimator valueAnimator = this.iconAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.iconAnim = null;
        }
    }

    public CellFoldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CellFoldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foldDuration = 1000L;
        this.scaleDuration = 500L;
        this.foldInterval = 2000L;
        this.foldRunnable = new a();
        LayoutInflater.from(context).inflate(R.layout.layout_people_match_entry_fold, (ViewGroup) this, true);
        this.bgView = findViewById(R.id.fold_bg);
        this.imageView = (EffectiveShapeView) findViewById(R.id.fold_image);
        this.transitionView = (EffectiveShapeView) findViewById(R.id.fold_image_transition);
        this.iconView = findViewById(R.id.fold_icon);
        this.imageOptions = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.shape_people_match_photo_placeholder).A(R.drawable.shape_people_match_photo_placeholder).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.shape_people_match_photo_placeholder).r();
        int iB = me1.b(context, 2);
        this.imageView.changeShapeType(3);
        this.imageView.setDegreeForRoundRectangle(iB, iB);
        this.imageView.setBorderWidth(me1.b(context, 2));
        this.imageView.setBorderColor(Color.parseColor("#ffffff"));
        this.transitionView.changeShapeType(3);
        this.transitionView.setDegreeForRoundRectangle(iB, iB);
        this.transitionView.setBorderWidth(me1.b(context, 2));
        this.transitionView.setBorderColor(Color.parseColor("#ffffff"));
        setPadding(me1.b(context, 4), me1.b(context, 4), me1.b(context, 4), 0);
        setClipToPadding(false);
        this.bgView.setRotation(10.0f);
        this.imageView.setRotation(-10.0f);
        this.transitionView.setRotation(-10.0f);
    }
}
