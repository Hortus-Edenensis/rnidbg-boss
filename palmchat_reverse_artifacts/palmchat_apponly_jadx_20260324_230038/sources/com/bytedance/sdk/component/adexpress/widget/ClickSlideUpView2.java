package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private ImageView b;
    private ImageView fx;
    private AnimatorSet iz;
    private ImageView nr;
    private int pn;
    private TextView u;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.iz = new AnimatorSet();
        nr(context);
    }

    private void b() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    private void nr(Context context) {
        addView(com.bytedance.sdk.component.adexpress.fx.u.nr(context));
        this.nr = (ImageView) findViewById(2097610751);
        this.fx = (ImageView) findViewById(2097610750);
        this.b = (ImageView) findViewById(2097610749);
        this.u = (TextView) findViewById(2097610748);
    }

    public float getAlphaColor() {
        return this.pn;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.b.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.fx.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.nr.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    public void setButtonText(String str) {
        if (this.u == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.u.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void u(Context context) {
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void u() {
        b();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void nr() {
        this.iz.cancel();
    }
}
