package com.zenmen.palmchat.lxvoip.vertc.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutUserRenderCustomViewBinding;
import defpackage.eg5;
import defpackage.hc2;
import defpackage.k86;
import defpackage.kc2;
import defpackage.ra6;
import defpackage.v86;
import defpackage.va6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CustomUserRenderView extends FrameLayout {
    private va6 mUserInfo;
    private LayoutUserRenderCustomViewBinding mViewBinding;

    public CustomUserRenderView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.mViewBinding = LayoutUserRenderCustomViewBinding.a(View.inflate(getContext(), R$layout.layout_user_render_custom_view, this));
    }

    public void bindInfo(va6 va6Var) {
        String str;
        this.mUserInfo = va6Var;
        if (va6Var == null || TextUtils.isEmpty(va6Var.b)) {
            this.mViewBinding.e.removeAllViews();
            str = null;
        } else {
            updateAudioStatus(va6Var.b, va6Var.e);
            updateVideoStatus(va6Var.b, va6Var.g, va6Var.f);
            str = va6Var.c;
        }
        kc2<Drawable> kc2VarLoad = hc2.a(c.b()).load(k86.p(str));
        int i = R$drawable.default_portrait;
        kc2VarLoad.placeholder(i).error(i).into(this.mViewBinding.b);
        if (va6Var == null || !va6Var.f) {
            this.mViewBinding.b.setVisibility(0);
        } else {
            this.mViewBinding.b.setVisibility(8);
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mViewBinding.g.getDrawable();
        if (this.mUserInfo.d) {
            if (!animationDrawable.isRunning()) {
                animationDrawable.start();
            }
            this.mViewBinding.g.setVisibility(0);
        } else {
            animationDrawable.stop();
            this.mViewBinding.g.setVisibility(8);
        }
        this.mViewBinding.c.setVisibility(8);
    }

    public void updateAudioStatus(String str, boolean z) {
        if (this.mUserInfo == null || TextUtils.isEmpty(str) || !TextUtils.equals(str, this.mUserInfo.b)) {
            return;
        }
        this.mUserInfo.e = z;
        this.mViewBinding.f.setImageResource(z ? com.zenmen.palmchat.lxvoip.vertc.R$drawable.microphone_enable_icon : com.zenmen.palmchat.lxvoip.vertc.R$drawable.microphone_disable_icon);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mViewBinding.c.getDrawable();
        if (z) {
            return;
        }
        animationDrawable.stop();
        this.mViewBinding.c.setVisibility(8);
    }

    public void updateSpeakingStatus(String str, boolean z) {
        if (this.mUserInfo == null || TextUtils.isEmpty(str) || !TextUtils.equals(str, this.mUserInfo.b)) {
            return;
        }
        this.mViewBinding.f.setImageResource(this.mUserInfo.e ? z ? com.zenmen.palmchat.lxvoip.vertc.R$drawable.microphone_active_icon : com.zenmen.palmchat.lxvoip.vertc.R$drawable.microphone_enable_icon : com.zenmen.palmchat.lxvoip.vertc.R$drawable.microphone_disable_icon);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mViewBinding.c.getDrawable();
        if (!z) {
            animationDrawable.stop();
            this.mViewBinding.c.setVisibility(8);
        } else {
            if (!animationDrawable.isRunning()) {
                animationDrawable.start();
            }
            this.mViewBinding.c.setVisibility(0);
        }
    }

    public void updateVideoStatus(String str, boolean z, boolean z2) {
        va6 va6Var;
        boolean z3;
        if (this.mUserInfo == null || TextUtils.isEmpty(str) || !TextUtils.equals(str, this.mUserInfo.b) || z != (z3 = (va6Var = this.mUserInfo).g)) {
            return;
        }
        va6Var.f = z2;
        if (z2 || z3) {
            TextureView textureViewC = ra6.e().c(str);
            v86.a(this.mViewBinding.e, textureViewC, new FrameLayout.LayoutParams(-1, -1));
            if (TextUtils.equals(this.mUserInfo.b, eg5.c().a())) {
                ra6.e().f(this.mUserInfo.g, textureViewC);
            } else {
                ra6 ra6VarE = ra6.e();
                va6 va6Var2 = this.mUserInfo;
                ra6VarE.g(va6Var2.b, va6Var2.g, textureViewC);
            }
        } else {
            this.mViewBinding.e.removeAllViews();
        }
        if (z2) {
            this.mViewBinding.b.setVisibility(8);
        } else {
            this.mViewBinding.b.setVisibility(0);
        }
    }

    public CustomUserRenderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public CustomUserRenderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
