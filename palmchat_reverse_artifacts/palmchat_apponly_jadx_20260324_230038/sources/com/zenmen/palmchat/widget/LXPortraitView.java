package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.a46;
import defpackage.c15;
import defpackage.m15;
import defpackage.me1;
import defpackage.v05;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LXPortraitView extends ConstraintLayout {
    private static final float DEFAULT_PORTRAIT_SIZE_RATIO = 0.767f;
    public static final String TAG = "LXPortraitView";
    private int colorBegin;
    private int colorEnd;
    private Amulet mAmulet;
    private FrameLayout mDecorLayout;
    private SVGAImageView mDynamicDecor;
    private SocialPortraitView mPortraitView;
    private AppCompatImageView mStaticDecor;
    private TextView mText;
    private int portraitPadding;
    private float portraitSizeRatio;
    boolean showWave;
    private float textSize;
    private WaveViewNew waveView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends DrawableImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f15975a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, c cVar) {
            super(imageView);
            this.f15975a = cVar;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
            c cVar = this.f15975a;
            if (cVar != null) {
                cVar.onLoaded();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            super.onLoadFailed(drawable);
            c cVar = this.f15975a;
            if (cVar != null) {
                cVar.onFailed();
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
            super.onStart();
            c cVar = this.f15975a;
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

    public LXPortraitView(@NonNull Context context) {
        this(context, null);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.lx_portrait_view)) == null) {
            return;
        }
        this.portraitSizeRatio = typedArrayObtainStyledAttributes.getFloat(R$styleable.lx_portrait_view_portrait_size_ratio, DEFAULT_PORTRAIT_SIZE_RATIO);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(R$styleable.lx_portrait_view_text_size, me1.b(context, 8));
        int i = R$styleable.lx_portrait_view_wave_begin_color;
        Resources resources = getResources();
        int i2 = R$color.btn_main;
        this.colorBegin = typedArrayObtainStyledAttributes.getColor(i, resources.getColor(i2));
        this.colorEnd = typedArrayObtainStyledAttributes.getColor(R$styleable.lx_portrait_view_wave_end_color, getResources().getColor(i2));
        this.showWave = typedArrayObtainStyledAttributes.getBoolean(R$styleable.lx_portrait_view_show_wave, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initView(Context context) {
        if (this.showWave) {
            this.waveView = new WaveViewNew(context);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            addView(this.waveView, layoutParams);
        }
        SocialPortraitView socialPortraitView = new SocialPortraitView(context);
        this.mPortraitView = socialPortraitView;
        socialPortraitView.changeShapeType(1);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToRight = 0;
        layoutParams2.matchConstraintPercentHeight = DEFAULT_PORTRAIT_SIZE_RATIO;
        layoutParams2.matchConstraintPercentWidth = DEFAULT_PORTRAIT_SIZE_RATIO;
        addView(this.mPortraitView, layoutParams2);
        this.mDecorLayout = new FrameLayout(context);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, -1);
        layoutParams3.topToTop = 0;
        layoutParams3.bottomToBottom = 0;
        layoutParams3.leftToLeft = 0;
        layoutParams3.rightToRight = 0;
        addView(this.mDecorLayout, layoutParams3);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.mStaticDecor = appCompatImageView;
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mDecorLayout.addView(this.mStaticDecor, new ConstraintLayout.LayoutParams(-1, -1));
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.mText = appCompatTextView;
        appCompatTextView.setTextSize(0, this.textSize);
        this.mText.setGravity(17);
        this.mText.setText("新人");
        int iB = me1.b(context, 6);
        int iB2 = me1.b(context, 2);
        this.mText.setPadding(iB, iB2, iB, iB2);
        this.mText.setTextColor(-1);
        this.mText.setVisibility(8);
        this.mText.setBackgroundResource(R$drawable.bg_venus_portrait_text_male);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams4.bottomToBottom = 0;
        layoutParams4.leftToLeft = 0;
        layoutParams4.rightToRight = 0;
        addView(this.mText, layoutParams4);
    }

    private void loadSVGA(String str) throws MalformedURLException {
        LogUtil.i(TAG, "loadSVGA " + str);
        c15.INSTANCE.b().s(new URL(str), new b(), new c15.e() { // from class: a13
            @Override // c15.e
            public final void onPlay(List list) {
                LXPortraitView.lambda$loadSVGA$0(list);
            }
        });
    }

    private void showDynamicDecor(boolean z) {
        SVGAImageView sVGAImageView = this.mDynamicDecor;
        if (sVGAImageView == null) {
            this.mAmulet = null;
            return;
        }
        sVGAImageView.clear();
        if (z) {
            this.mDynamicDecor.setVisibility(0);
        } else {
            this.mAmulet = null;
            this.mDynamicDecor.setVisibility(4);
        }
    }

    private void showLabel(boolean z) {
        TextView textView = this.mText;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
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

    public SocialPortraitView getPortraitView() {
        return this.mPortraitView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.i(TAG, "onAttachedToWindow" + this);
        Amulet amulet = this.mAmulet;
        if (amulet == null || amulet.type != 2) {
            return;
        }
        this.mDynamicDecor.startAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.i(TAG, "onDetachedFromWindow" + this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.showWave) {
            this.waveView.setInitialRadius((i * DEFAULT_PORTRAIT_SIZE_RATIO) / 2.0f);
            this.waveView.setMaxRadius(i / 2);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Amulet amulet;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        super.onWindowVisibilityChanged(i);
        if (i == 8) {
            Amulet amulet2 = this.mAmulet;
            if (amulet2 != null && amulet2.type == 2 && (sVGAImageView2 = this.mDynamicDecor) != null) {
                sVGAImageView2.stopAnimation();
            }
        } else if (i == 0 && (amulet = this.mAmulet) != null && amulet.type == 2 && (sVGAImageView = this.mDynamicDecor) != null) {
            sVGAImageView.startAnimation();
        }
        LogUtil.i(TAG, "onWindowVisibilityChanged" + this + " visibility=" + i);
    }

    public void setAvatarView(String str, Amulet amulet) {
        setAvatarView(str, 0, R$drawable.default_portrait_new, null, amulet);
    }

    public void setDecor(Amulet amulet) {
        if (amulet == null || amulet.url == null || !amulet.isOk()) {
            showStaticDecor(false);
            showDynamicDecor(false);
        } else {
            showLabel(false);
            if (amulet.type == 2) {
                if (this.mDynamicDecor == null) {
                    SVGAImageView sVGAImageView = new SVGAImageView(getContext());
                    this.mDynamicDecor = sVGAImageView;
                    sVGAImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.mDynamicDecor.setFillMode(SVGAImageView.FillMode.Clear);
                    this.mDynamicDecor.setClearsAfterDetached(false);
                    this.mDecorLayout.addView(this.mDynamicDecor, new ViewGroup.LayoutParams(-1, -1));
                }
                if (!amulet.equals(this.mAmulet)) {
                    try {
                        showDynamicDecor(true);
                        showStaticDecor(false);
                        loadSVGA(amulet.url);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                showDynamicDecor(false);
                showStaticDecor(true);
                a46.u(amulet.url, this.mStaticDecor, 0);
            }
        }
        this.mAmulet = amulet;
    }

    public void setLabelText(String str, int i, int i2) {
        Amulet amulet = this.mAmulet;
        if (amulet != null && amulet.url != null && amulet.isOk()) {
            this.mText.setVisibility(8);
            return;
        }
        TextView textView = this.mText;
        if (textView != null) {
            if (str == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
            this.mText.setTextColor(i);
            if (i2 != 0) {
                this.mText.setBackgroundResource(i2);
            }
            this.mText.setVisibility(0);
        }
    }

    public void setPortraitBorder(int i, int i2) {
        this.mPortraitView.setBorderColor(i);
        this.mPortraitView.setBorderWidth(i2);
    }

    public void setWaveColor(int i) {
        WaveViewNew waveViewNew = this.waveView;
        if (waveViewNew != null) {
            waveViewNew.setStartColor(i);
            this.waveView.setEndColor(i);
        }
    }

    public void start() {
        this.waveView.start();
    }

    public void stop() {
        this.waveView.stop();
    }

    public LXPortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setAvatarView(String str, int i, int i2, c cVar, Amulet amulet) {
        setAvatarView(str, i, i2, cVar, amulet, false);
    }

    public LXPortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.portraitSizeRatio = DEFAULT_PORTRAIT_SIZE_RATIO;
        initAttrs(context, attributeSet);
        initView(context);
    }

    public void setAvatarView(String str, int i, int i2, c cVar, Amulet amulet, boolean z) {
        if (i > 0) {
            this.mPortraitView.setBackgroundResource(i);
        }
        if (TextUtils.isEmpty(str)) {
            if (i2 > 0) {
                this.mPortraitView.setImageResource(i2);
            } else {
                this.mPortraitView.setImageDrawable(null);
            }
            if (cVar != null) {
                cVar.onFailed();
            }
        } else {
            if (i2 == 0) {
                i2 = R$drawable.ic_default_portrait;
            }
            a46.x(str, i2, new a(this.mPortraitView, cVar), Priority.NORMAL, z);
        }
        setDecor(amulet);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c15.d {
        public b() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            LXPortraitView.this.mDynamicDecor.setVideoItem(m15Var);
            LXPortraitView.this.mDynamicDecor.startAnimation();
            LXPortraitView.this.mDynamicDecor.setCallback(new a());
            LXPortraitView.this.mDynamicDecor.setClearsAfterDetached(false);
            LogUtil.i(LXPortraitView.TAG, "onComplete");
        }

        @Override // c15.d
        public void onError() {
            LogUtil.i(LXPortraitView.TAG, "onError");
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements v05 {
            public a() {
            }

            @Override // defpackage.v05
            public void a() {
                LogUtil.i(LXPortraitView.TAG, "onFinished");
            }

            @Override // defpackage.v05
            public void c() {
                LogUtil.e(LXPortraitView.TAG, "onRepeat " + LXPortraitView.this);
            }

            @Override // defpackage.v05
            public void onPause() {
            }

            @Override // defpackage.v05
            public void b(int i, double d) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadSVGA$0(List list) {
    }
}
