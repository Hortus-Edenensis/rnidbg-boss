package com.zenmen.square.ui.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.square.R$drawable;
import defpackage.tn;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VideoLikeBigStar extends AppCompatImageView {
    private static final float[] NUM = {-30.0f, -20.0f, 0.0f, 20.0f, 30.0f};

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16510a;

        public a(ViewGroup viewGroup) {
            this.f16510a = viewGroup;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f16510a.removeViewInLayout(VideoLikeBigStar.this);
        }
    }

    public VideoLikeBigStar(Context context) {
        super(context);
    }

    private ObjectAnimator alpha(View view, float f, float f2, long j, long j2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setStartDelay(j2);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator rotation(View view, long j, long j2, float... fArr) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, fArr);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setStartDelay(j2);
        objectAnimatorOfFloat.setInterpolator(new b());
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator scale(View view, String str, float f, float f2, long j, long j2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, str, f, f2);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setStartDelay(j2);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator translationX(View view, float f, float f2, long j, long j2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f, f2);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setStartDelay(j2);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator translationY(View view, float f, float f2, long j, long j2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", f, f2);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setStartDelay(j2);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }

    public void animBigStart(ViewGroup viewGroup, MotionEvent motionEvent) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(tn.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), tn.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        layoutParams.leftMargin = ((int) motionEvent.getX()) - tn.b(getContext(), 50);
        layoutParams.topMargin = ((int) motionEvent.getY()) - tn.b(getContext(), 150);
        setImageDrawable(getContext().getResources().getDrawable(R$drawable.icon_square_like_double_click));
        setLayoutParams(layoutParams);
        viewGroup.addView(this);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scale(this, "scaleX", 2.0f, 0.9f, 100L, 0L)).with(scale(this, "scaleY", 2.0f, 0.9f, 100L, 0L)).with(rotation(this, 0L, 0L, NUM[new Random().nextInt(4)])).with(alpha(this, 0.0f, 1.0f, 100L, 0L)).with(scale(this, "scaleX", 0.9f, 1.0f, 50L, 150L)).with(scale(this, "scaleY", 0.9f, 1.0f, 50L, 150L)).with(translationY(this, 0.0f, -600.0f, 800L, 400L)).with(alpha(this, 1.0f, 0.0f, 300L, 400L)).with(scale(this, "scaleX", 1.0f, 3.0f, 700L, 400L)).with(scale(this, "scaleY", 1.0f, 3.0f, 700L, 400L));
        animatorSet.start();
        animatorSet.addListener(new a(viewGroup));
    }

    public VideoLikeBigStar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoLikeBigStar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TimeInterpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }
    }
}
