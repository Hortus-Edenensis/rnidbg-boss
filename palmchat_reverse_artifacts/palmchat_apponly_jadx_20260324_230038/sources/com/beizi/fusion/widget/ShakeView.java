package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ShakeView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f4788a;
    TextView b;
    private boolean c;
    private String d;
    private AnimationDrawable e;
    private boolean f;

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        init(context);
    }

    private void a() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f4788a = imageView;
        imageView.setBackgroundResource(R.drawable.anim_shake_download);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f4788a, layoutParams);
        this.e = (AnimationDrawable) this.f4788a.getBackground();
    }

    public void init(Context context) {
        if (this.c) {
            return;
        }
        this.c = true;
        ImageView imageView = new ImageView(context);
        this.f4788a = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_anim_shake);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f4788a, layoutParams);
        this.e = (AnimationDrawable) this.f4788a.getBackground();
    }

    public void setDownloadApp(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        this.f = zBooleanValue;
        if (zBooleanValue) {
            a();
        }
    }

    public void setTitleText(String str) {
        this.d = str;
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void startShake() {
        AnimationDrawable animationDrawable = this.e;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopShake() {
        AnimationDrawable animationDrawable = this.e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void updateTwistRollAnim() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f4788a = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_twist_roll);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f4788a, layoutParams);
        this.e = (AnimationDrawable) this.f4788a.getBackground();
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        init(context);
    }

    public ShakeView(Context context) {
        super(context);
        this.c = false;
        init(context);
    }
}
