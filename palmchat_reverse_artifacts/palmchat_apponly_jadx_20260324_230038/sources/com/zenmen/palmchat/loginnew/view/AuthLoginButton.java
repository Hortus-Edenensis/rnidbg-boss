package com.zenmen.palmchat.loginnew.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AuthLoginButton extends RelativeLayout {
    private View customView;
    private Animation mAnimation;
    private ImageView progressView;
    private TextView textView;

    public AuthLoginButton(Context context) {
        super(context);
        onCreateView(context);
    }

    private void onCreateView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_auth_login_button, (ViewGroup) this, true);
        this.customView = viewInflate;
        this.progressView = (ImageView) viewInflate.findViewById(R.id.progress);
        this.textView = (TextView) this.customView.findViewById(R.id.text);
        this.mAnimation = AnimationUtils.loadAnimation(context, R.anim.auth_login_loading_progress);
    }

    public boolean hasProgress() {
        return this.progressView.getVisibility() == 0;
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void startAnimation() {
        this.textView.setVisibility(8);
        this.progressView.setVisibility(0);
        this.progressView.startAnimation(this.mAnimation);
    }

    public void stopAnimation() {
        this.textView.setVisibility(0);
        this.progressView.clearAnimation();
        this.progressView.setVisibility(8);
    }

    public AuthLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        onCreateView(context);
    }

    public AuthLoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        onCreateView(context);
    }

    @RequiresApi(api = 21)
    public AuthLoginButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        onCreateView(context);
    }
}
