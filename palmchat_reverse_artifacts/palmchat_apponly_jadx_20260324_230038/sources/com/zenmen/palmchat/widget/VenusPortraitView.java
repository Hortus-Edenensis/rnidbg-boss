package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.widget.DecorAvatarView;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VenusPortraitView extends RelativeLayout {
    private boolean hideText;
    private DecorAvatarView mAvatar;
    private TextView mText;
    private WaveView waveView;

    public VenusPortraitView(Context context) {
        this(context, null);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.venus_portrait);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        this.waveView.setInitialRadius(typedArrayObtainStyledAttributes.getDimension(R$styleable.venus_portrait_venus_init_radius, me1.b(context, 30)));
        this.waveView.setMaxRadius(typedArrayObtainStyledAttributes.getDimension(R$styleable.venus_portrait_venus_max_radius, me1.b(context, 30)));
        this.mText.setTextSize(0, typedArrayObtainStyledAttributes.getDimension(R$styleable.venus_portrait_venus_text_size, me1.b(context, 8)));
        typedArrayObtainStyledAttributes.recycle();
    }

    public TextView getBottomTextView() {
        return this.mText;
    }

    public WaveView getWaveView() {
        return this.waveView;
    }

    public void hideText() {
        this.hideText = true;
        this.mText.setVisibility(8);
    }

    public void setAvatarRadius(int i) {
        this.mAvatar.setAvatarRadius(i);
    }

    public void setBottomText(String str) {
        TextView textView;
        if (str == null || (textView = this.mText) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setDecorRadius(int i) {
        this.mAvatar.setDecorRadius(i);
    }

    public void setGender(int i) {
        if (i == 0) {
            this.waveView.setStartColor(Color.parseColor("#00B0FF"));
            this.waveView.setEndColor(Color.parseColor("#00B0FF"));
            this.mText.setBackgroundResource(R$drawable.bg_venus_portrait_text_male);
        } else if (i == 1) {
            this.waveView.setStartColor(Color.parseColor("#FF1F9A"));
            this.waveView.setEndColor(Color.parseColor("#FF1F9A"));
            this.mText.setBackgroundResource(R$drawable.bg_venus_portrait_text_female);
        }
    }

    public void setUrl(String str, String str2) {
        this.mAvatar.setAvatarView(str, str2);
    }

    public void start() {
        this.waveView.start();
        if (this.hideText) {
            return;
        }
        this.mText.setVisibility(0);
    }

    public void stop() {
        this.waveView.stop();
        if (this.hideText) {
            return;
        }
        this.mText.setVisibility(8);
    }

    public VenusPortraitView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUrl(String str, String str2, DecorAvatarView.c cVar) {
        this.mAvatar.setAvatarView(str, 0, R$drawable.default_portrait_new, cVar, str2);
    }

    public VenusPortraitView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public VenusPortraitView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.hideText = false;
        LayoutInflater.from(context).inflate(R$layout.layout_venus_portrait, (ViewGroup) this, true);
        this.waveView = (WaveView) findViewById(R$id.wv);
        this.mAvatar = (DecorAvatarView) findViewById(R$id.decor_avatar);
        this.mText = (TextView) findViewById(R$id.text);
        initAttrs(context, attributeSet);
    }
}
