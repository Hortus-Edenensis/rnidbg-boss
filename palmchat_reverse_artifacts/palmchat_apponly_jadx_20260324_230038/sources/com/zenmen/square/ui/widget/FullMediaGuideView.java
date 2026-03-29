package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FullMediaGuideView extends LxRelativeLayout implements View.OnClickListener {
    private View guideArea;
    private TextView guideBtn;
    private ImageView guideHorizontalArrow;
    private ImageView guideHorizontalHand;
    private TextView guideTip;
    private ImageView guideVerticalArrow;
    private ImageView guideVerticalHand;
    int step;

    public FullMediaGuideView(Context context) {
        super(context);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.layout_square_full_media_guide, this);
        this.guideArea = findViewById(R$id.guide_eara);
        this.guideVerticalArrow = (ImageView) findViewById(R$id.guide_vertical_arrow);
        this.guideVerticalHand = (ImageView) findViewById(R$id.guide_vertical_hand);
        this.guideHorizontalArrow = (ImageView) findViewById(R$id.guide_horizontal_arrow);
        this.guideHorizontalHand = (ImageView) findViewById(R$id.guide_horizontal_hand);
        this.guideTip = (TextView) findViewById(R$id.guide_tip);
        TextView textView = (TextView) findViewById(R$id.guide_btn);
        this.guideBtn = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        setVisibility(8);
    }

    public void startAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(30.0f, -25.0f, 1, 1.0f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(600L);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setStartOffset(0L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-25.0f, 30.0f, 1, 1.0f, 1, 0.5f);
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        rotateAnimation2.setDuration(600L);
        rotateAnimation2.setRepeatCount(0);
        rotateAnimation2.setStartOffset(0L);
        RotateAnimation rotateAnimation3 = new RotateAnimation(30.0f, -25.0f, 1, 0.5f, 1, 1.0f);
        rotateAnimation3.setInterpolator(new LinearInterpolator());
        rotateAnimation3.setDuration(600L);
        rotateAnimation3.setRepeatCount(0);
        rotateAnimation3.setStartOffset(0L);
        rotateAnimation3.setFillAfter(true);
        RotateAnimation rotateAnimation4 = new RotateAnimation(-25.0f, 30.0f, 1, 0.5f, 1, 1.0f);
        rotateAnimation4.setInterpolator(new LinearInterpolator());
        rotateAnimation4.setDuration(600L);
        rotateAnimation4.setRepeatCount(0);
        rotateAnimation4.setStartOffset(0L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(0);
        a aVar = new a(rotateAnimation2, rotateAnimation, alphaAnimation, rotateAnimation3, rotateAnimation4);
        rotateAnimation.setAnimationListener(aVar);
        rotateAnimation2.setAnimationListener(aVar);
        rotateAnimation3.setAnimationListener(aVar);
        rotateAnimation4.setAnimationListener(aVar);
        alphaAnimation.setAnimationListener(aVar);
        this.guideVerticalHand.startAnimation(rotateAnimation);
        this.step = 1;
    }

    public FullMediaGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullMediaGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FullMediaGuideView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RotateAnimation f16522a;
        public final /* synthetic */ RotateAnimation b;
        public final /* synthetic */ AlphaAnimation c;
        public final /* synthetic */ RotateAnimation d;
        public final /* synthetic */ RotateAnimation e;

        public a(RotateAnimation rotateAnimation, RotateAnimation rotateAnimation2, AlphaAnimation alphaAnimation, RotateAnimation rotateAnimation3, RotateAnimation rotateAnimation4) {
            this.f16522a = rotateAnimation;
            this.b = rotateAnimation2;
            this.c = alphaAnimation;
            this.d = rotateAnimation3;
            this.e = rotateAnimation4;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (FullMediaGuideView.this.getVisibility() != 0) {
                return;
            }
            FullMediaGuideView fullMediaGuideView = FullMediaGuideView.this;
            int i = fullMediaGuideView.step;
            if (i == 1) {
                fullMediaGuideView.step = 2;
                fullMediaGuideView.guideVerticalHand.startAnimation(this.f16522a);
                return;
            }
            if (i == 2) {
                fullMediaGuideView.step = 3;
                fullMediaGuideView.guideVerticalHand.startAnimation(this.b);
                return;
            }
            if (i == 3) {
                fullMediaGuideView.step = 4;
                fullMediaGuideView.guideArea.startAnimation(this.c);
                return;
            }
            if (i == 4) {
                fullMediaGuideView.step = 5;
                fullMediaGuideView.guideVerticalHand.clearAnimation();
                FullMediaGuideView.this.guideVerticalArrow.setVisibility(8);
                FullMediaGuideView.this.guideVerticalHand.setVisibility(8);
                FullMediaGuideView.this.guideHorizontalArrow.setVisibility(0);
                FullMediaGuideView.this.guideHorizontalHand.setVisibility(0);
                FullMediaGuideView.this.guideTip.setText("左滑查看Ta的主页");
                FullMediaGuideView.this.guideHorizontalHand.startAnimation(this.d);
                return;
            }
            if (i == 5) {
                fullMediaGuideView.step = 6;
                fullMediaGuideView.guideHorizontalHand.startAnimation(this.e);
                return;
            }
            if (i == 6) {
                fullMediaGuideView.step = 7;
                fullMediaGuideView.guideHorizontalHand.startAnimation(this.d);
                return;
            }
            if (i == 7) {
                fullMediaGuideView.step = 8;
                fullMediaGuideView.guideArea.startAnimation(this.c);
            } else if (i == 8) {
                fullMediaGuideView.step = 1;
                fullMediaGuideView.guideHorizontalHand.clearAnimation();
                FullMediaGuideView.this.guideHorizontalArrow.setVisibility(8);
                FullMediaGuideView.this.guideHorizontalHand.setVisibility(8);
                FullMediaGuideView.this.guideVerticalArrow.setVisibility(0);
                FullMediaGuideView.this.guideVerticalHand.setVisibility(0);
                FullMediaGuideView.this.guideTip.setText("上滑查看下个动态");
                FullMediaGuideView.this.guideVerticalHand.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
