package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.widget.DecorAvatarView;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.a46;
import defpackage.c15;
import defpackage.m15;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DecorAvatarView extends ConstraintLayout {
    private int avatarSize;
    private int decorSize;
    private CircleImageView mAvatarView;
    private String mDecorUrl;
    private SVGAImageView mDynamicDecor;
    private AppCompatImageView mStaticDecor;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends DrawableImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f15964a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, c cVar) {
            super(imageView);
            this.f15964a = cVar;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
            c cVar = this.f15964a;
            if (cVar != null) {
                cVar.onLoaded();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            super.onLoadFailed(drawable);
            c cVar = this.f15964a;
            if (cVar != null) {
                cVar.onFailed();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
            super.onStart();
            c cVar = this.f15964a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void onFailed();

        void onLoaded();
    }

    public DecorAvatarView(@NonNull Context context) {
        this(context, null);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        this.decorSize = a46.b(context, 76.0f);
        this.avatarSize = a46.b(context, 54.0f);
        if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.decor_avatar)) == null) {
            return;
        }
        int i = R$styleable.decor_avatar_decor_radius;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            this.decorSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i, 0) * 2;
        }
        int i2 = R$styleable.decor_avatar_avatar_radius;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.avatarSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i2, 0) * 2;
        }
    }

    private void initView(Context context) {
        this.mAvatarView = new CircleImageView(context);
        int i = this.avatarSize;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i, i);
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        addView(this.mAvatarView, layoutParams);
        this.mStaticDecor = new AppCompatImageView(context);
        int i2 = this.decorSize;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(i2, i2);
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToRight = 0;
        addView(this.mStaticDecor, layoutParams2);
    }

    private void loadSVGA(String str) throws MalformedURLException {
        new c15(getContext()).s(new URL(str), new b(), new c15.e() { // from class: qw0
            @Override // c15.e
            public final void onPlay(List list) {
                DecorAvatarView.lambda$loadSVGA$0(list);
            }
        });
    }

    private void showDynamicDecor(boolean z) {
        SVGAImageView sVGAImageView = this.mDynamicDecor;
        if (sVGAImageView == null) {
            this.mDecorUrl = null;
            return;
        }
        sVGAImageView.clear();
        if (z) {
            this.mDynamicDecor.setVisibility(0);
        } else {
            this.mDecorUrl = null;
            this.mDynamicDecor.setVisibility(4);
        }
    }

    private void showStaticDecor(boolean z) {
        this.mStaticDecor.setImageDrawable(null);
        if (z) {
            this.mStaticDecor.setVisibility(0);
        } else {
            this.mStaticDecor.setVisibility(4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mDecorUrl;
        if (str != null) {
            try {
                loadSVGA(str);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setAvatarRadius(int i) {
        this.avatarSize = i * 2;
        CircleImageView circleImageView = this.mAvatarView;
        if (circleImageView != null) {
            ViewGroup.LayoutParams layoutParams = circleImageView.getLayoutParams();
            int i2 = this.avatarSize;
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.mAvatarView.setLayoutParams(layoutParams);
        }
    }

    public void setAvatarView(String str, String str2) {
        setAvatarView(str, 0, R$drawable.default_portrait_new, null, str2);
    }

    public void setDecorRadius(int i) {
        this.decorSize = i * 2;
        AppCompatImageView appCompatImageView = this.mStaticDecor;
        if (appCompatImageView != null) {
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            int i2 = this.decorSize;
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.mStaticDecor.setLayoutParams(layoutParams);
        }
        SVGAImageView sVGAImageView = this.mDynamicDecor;
        if (sVGAImageView != null) {
            ViewGroup.LayoutParams layoutParams2 = sVGAImageView.getLayoutParams();
            int i3 = this.decorSize;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.mDynamicDecor.setLayoutParams(layoutParams2);
        }
    }

    public DecorAvatarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setAvatarView(String str, int i, int i2, c cVar, String str2) {
        if (i > 0) {
            this.mAvatarView.setBackgroundResource(i);
        }
        if (TextUtils.isEmpty(str)) {
            if (i2 > 0) {
                this.mAvatarView.setImageResource(i2);
            } else {
                this.mAvatarView.setImageDrawable(null);
            }
            if (cVar != null) {
                cVar.onFailed();
            }
        } else {
            if (i2 == 0) {
                i2 = R$drawable.ic_default_portrait;
            }
            a46.t(str, i2, new a(this.mAvatarView, cVar), Priority.NORMAL);
        }
        if (TextUtils.isEmpty(str2)) {
            showStaticDecor(false);
            showDynamicDecor(false);
            return;
        }
        if (!str2.toLowerCase().endsWith(".svga")) {
            showDynamicDecor(false);
            showStaticDecor(true);
            a46.u(str2, this.mStaticDecor, 0);
            return;
        }
        if (this.mDynamicDecor == null) {
            this.mDynamicDecor = new SVGAImageView(getContext());
            int i3 = this.decorSize;
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i3, i3);
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            addView(this.mDynamicDecor, layoutParams);
        }
        if (TextUtils.equals(this.mDecorUrl, str2)) {
            return;
        }
        try {
            showDynamicDecor(true);
            showStaticDecor(false);
            loadSVGA(str2);
            this.mDecorUrl = str2;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public DecorAvatarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
        initView(context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c15.d {
        public b() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            DecorAvatarView.this.mDynamicDecor.setVideoItem(m15Var);
            DecorAvatarView.this.mDynamicDecor.startAnimation();
            DecorAvatarView.this.mDynamicDecor.setClearsAfterDetached(false);
        }

        @Override // c15.d
        public void onError() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadSVGA$0(List list) {
    }
}
