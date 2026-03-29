package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import defpackage.a15;
import defpackage.c15;
import defpackage.h15;
import defpackage.h63;
import defpackage.m15;
import defpackage.v05;
import defpackage.x05;
import defpackage.y05;
import defpackage.z05;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0003ijkB'\b\u0007\u0012\u0006\u0010e\u001a\u00020d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010f\u001a\u00020&¢\u0006\u0004\bg\u0010hJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0012J\u0010\u0010#\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u001a\u0010#\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010$J\u0016\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0012J\u0016\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,J\u0012\u00101\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010/H\u0017J\b\u00102\u001a\u00020\u0004H\u0014R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R$\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b6\u00108R\"\u00109\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010?\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b?\u00107\u0012\u0004\bC\u0010D\u001a\u0004\b@\u00108\"\u0004\bA\u0010BR\"\u0010E\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u00107\u001a\u0004\bF\u00108\"\u0004\bG\u0010BR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u00107R\u0016\u0010[\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u00107R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010:R\u0016\u0010c\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010:¨\u0006l"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/widget/ImageView;", "Landroid/util/AttributeSet;", "attrs", "", "loadAttrs", "", az.at, "parserSource", "Ljava/lang/ref/WeakReference;", OapsKey.KEY_REF, "Lc15$d;", "createParseCompletion", "Lm15;", "videoItem", "startAnimation", "Lh15;", "range", "", "reverse", "play", "setupDrawable", "Ly05;", "getSVGADrawable", "", "generateScale", "Landroid/animation/ValueAnimator;", "animator", "onAnimatorUpdate", "Landroid/animation/Animator;", "animation", "onAnimationEnd", "clear", "pauseAnimation", "stopAnimation", "setVideoItem", "Lz05;", "dynamicItem", "", "frame", "andPlay", "stepToFrame", "percentage", "stepToPercentage", "Lx05;", "clickListener", "setOnAnimKeyClickListener", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "onDetachedFromWindow", "TAG", "Ljava/lang/String;", "<set-?>", "isAnimating", "Z", "()Z", "loops", "I", "getLoops", "()I", "setLoops", "(I)V", "clearsAfterStop", "getClearsAfterStop", "setClearsAfterStop", "(Z)V", "clearsAfterStop$annotations", "()V", "clearsAfterDetached", "getClearsAfterDetached", "setClearsAfterDetached", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "fillMode", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "getFillMode", "()Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "setFillMode", "(Lcom/opensource/svgaplayer/SVGAImageView$FillMode;)V", "Lv05;", bq.f.L, "Lv05;", "getCallback", "()Lv05;", "setCallback", "(Lv05;)V", "mAnimator", "Landroid/animation/ValueAnimator;", "mItemClickAreaListener", "Lx05;", "mAntiAlias", "mAutoPlay", "Lcom/opensource/svgaplayer/SVGAImageView$a;", "mAnimatorListener", "Lcom/opensource/svgaplayer/SVGAImageView$a;", "Lcom/opensource/svgaplayer/SVGAImageView$b;", "mAnimatorUpdateListener", "Lcom/opensource/svgaplayer/SVGAImageView$b;", "mStartFrame", "mEndFrame", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", t.l, "FillMode", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public class SVGAImageView extends ImageView {
    private final String TAG;
    private HashMap _$_findViewCache;
    private v05 callback;
    private boolean clearsAfterDetached;
    private boolean clearsAfterStop;
    private FillMode fillMode;
    private boolean isAnimating;
    private int loops;
    private ValueAnimator mAnimator;
    private final a mAnimatorListener;
    private final b mAnimatorUpdateListener;
    private boolean mAntiAlias;
    private boolean mAutoPlay;
    private int mEndFrame;
    private x05 mItemClickAreaListener;
    private int mStartFrame;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "", "(Ljava/lang/String;I)V", "Backward", "Forward", "Clear", "com.opensource.svgaplayer"}, k = 1, mv = {1, 1, 15})
    public enum FillMode {
        Backward,
        Forward,
        Clear
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$a;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "Ljava/lang/ref/WeakReference;", "Lcom/opensource/svgaplayer/SVGAImageView;", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "view", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final WeakReference<SVGAImageView> weakReference;

        public a(SVGAImageView sVGAImageView) {
            this.weakReference = new WeakReference<>(sVGAImageView);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.isAnimating = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.onAnimationEnd(animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            v05 callback;
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView == null || (callback = sVGAImageView.getCallback()) == null) {
                return;
            }
            callback.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.isAnimating = true;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$b;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "Ljava/lang/ref/WeakReference;", "Lcom/opensource/svgaplayer/SVGAImageView;", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "view", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final WeakReference<SVGAImageView> weakReference;

        public b(SVGAImageView sVGAImageView) {
            this.weakReference = new WeakReference<>(sVGAImageView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.onAnimatorUpdate(animation);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class d implements Runnable {
        public final /* synthetic */ m15 b;

        public d(m15 m15Var) {
            this.b = m15Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.x(SVGAImageView.this.mAntiAlias);
            SVGAImageView.this.setVideoItem(this.b);
            y05 sVGADrawable = SVGAImageView.this.getSVGADrawable();
            if (sVGADrawable != null) {
                ImageView.ScaleType scaleType = SVGAImageView.this.getScaleType();
                Intrinsics.checkExpressionValueIsNotNull(scaleType, "scaleType");
                sVGADrawable.g(scaleType);
            }
            if (SVGAImageView.this.mAutoPlay) {
                SVGAImageView.this.startAnimation();
            }
        }
    }

    @JvmOverloads
    public SVGAImageView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final c15.d createParseCompletion(WeakReference<SVGAImageView> ref) {
        return new c(ref);
    }

    private final double generateScale() {
        double d2 = 1.0d;
        try {
            Class<?> cls = Class.forName("android.animation.ValueAnimator");
            Method declaredMethod = cls.getDeclaredMethod("getDurationScale", new Class[0]);
            if (declaredMethod == null) {
                return 1.0d;
            }
            Object objInvoke = declaredMethod.invoke(cls, new Object[0]);
            if (objInvoke == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
            double dFloatValue = ((Float) objInvoke).floatValue();
            if (dFloatValue != 0.0d) {
                return dFloatValue;
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("setDurationScale", Float.TYPE);
                if (declaredMethod2 == null) {
                    return dFloatValue;
                }
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(cls, Float.valueOf(1.0f));
                h63.f17877a.e(this.TAG, "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                return 1.0d;
            } catch (Exception e) {
                e = e;
                d2 = dFloatValue;
                e.printStackTrace();
                return d2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y05 getSVGADrawable() {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof y05)) {
            drawable = null;
        }
        return (y05) drawable;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void loadAttrs(AttributeSet attrs) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R$styleable.SVGAImageView, 0, 0);
        this.loops = typedArrayObtainStyledAttributes.getInt(R$styleable.SVGAImageView_loopCount, 0);
        this.clearsAfterStop = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterStop, false);
        this.clearsAfterDetached = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterDetached, false);
        this.mAntiAlias = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_antiAlias, true);
        this.mAutoPlay = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_autoPlay, true);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.SVGAImageView_fillMode);
        if (string != null) {
            switch (string.hashCode()) {
                case 48:
                    if (string.equals("0")) {
                        this.fillMode = FillMode.Backward;
                    }
                    break;
                case 49:
                    if (string.equals("1")) {
                        this.fillMode = FillMode.Forward;
                    }
                    break;
                case 50:
                    if (string.equals("2")) {
                        this.fillMode = FillMode.Clear;
                    }
                    break;
            }
        }
        String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.SVGAImageView_source);
        if (string2 != null) {
            parserSource(string2);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimationEnd(Animator animation) {
        this.isAnimating = false;
        stopAnimation();
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            int i = a15.$EnumSwitchMapping$0[this.fillMode.ordinal()];
            if (i == 1) {
                sVGADrawable.f(this.mStartFrame);
            } else if (i == 2) {
                sVGADrawable.f(this.mEndFrame);
            } else if (i == 3) {
                sVGADrawable.e(true);
            }
        }
        v05 v05Var = this.callback;
        if (v05Var != null) {
            v05Var.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimatorUpdate(ValueAnimator animator) {
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            Object animatedValue = animator != null ? animator.getAnimatedValue() : null;
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            sVGADrawable.f(((Integer) animatedValue).intValue());
            double dB = ((double) (sVGADrawable.getCurrentFrame() + 1)) / ((double) sVGADrawable.getVideoItem().getFrames());
            v05 v05Var = this.callback;
            if (v05Var != null) {
                v05Var.b(sVGADrawable.getCurrentFrame(), dB);
            }
        }
    }

    private final void parserSource(String source) {
        WeakReference<SVGAImageView> weakReference = new WeakReference<>(this);
        c15 c15Var = new c15(getContext());
        if (StringsKt__StringsJVMKt.startsWith$default(source, "http://", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(source, "https://", false, 2, null)) {
            c15.t(c15Var, new URL(source), createParseCompletion(weakReference), null, 4, null);
        } else {
            c15.o(c15Var, source, createParseCompletion(weakReference), null, 4, null);
        }
    }

    private final void play(h15 range, boolean reverse) {
        h63.f17877a.e(this.TAG, "================ start animation ================");
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            setupDrawable();
            this.mStartFrame = Math.max(0, 0);
            m15 m15VarD = sVGADrawable.getVideoItem();
            int iMin = Math.min(m15VarD.getFrames() - 1, (0 + Integer.MAX_VALUE) - 1);
            this.mEndFrame = iMin;
            ValueAnimator animator = ValueAnimator.ofInt(this.mStartFrame, iMin);
            Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
            animator.setInterpolator(new LinearInterpolator());
            animator.setDuration((long) (((double) (((this.mEndFrame - this.mStartFrame) + 1) * (1000 / m15VarD.getFPS()))) / generateScale()));
            int i = this.loops;
            animator.setRepeatCount(i <= 0 ? 99999 : i - 1);
            animator.addUpdateListener(this.mAnimatorUpdateListener);
            animator.addListener(this.mAnimatorListener);
            if (reverse) {
                animator.reverse();
            } else {
                animator.start();
            }
            this.mAnimator = animator;
        }
    }

    private final void setupDrawable() {
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.e(false);
            ImageView.ScaleType scaleType = getScaleType();
            Intrinsics.checkExpressionValueIsNotNull(scaleType, "scaleType");
            sVGADrawable.g(scaleType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimation(m15 videoItem) {
        post(new d(videoItem));
    }

    public static /* synthetic */ void startAnimation$default(SVGAImageView sVGAImageView, h15 h15Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimation");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sVGAImageView.startAnimation(h15Var, z);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void clear() {
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.e(true);
        }
        y05 sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.a();
        }
        setImageDrawable(null);
    }

    public final v05 getCallback() {
        return this.callback;
    }

    public final boolean getClearsAfterDetached() {
        return this.clearsAfterDetached;
    }

    public final boolean getClearsAfterStop() {
        return this.clearsAfterStop;
    }

    public final FillMode getFillMode() {
        return this.fillMode;
    }

    public final int getLoops() {
        return this.loops;
    }

    /* JADX INFO: renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation(this.clearsAfterDetached);
        if (this.clearsAfterDetached) {
            clear();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null || event.getAction() != 0) {
            return super.onTouchEvent(event);
        }
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return super.onTouchEvent(event);
        }
        for (Map.Entry<String, int[]> entry : sVGADrawable.getDynamicItem().j().entrySet()) {
            entry.getKey();
            int[] value = entry.getValue();
            if (event.getX() >= value[0] && event.getX() <= value[2] && event.getY() >= value[1]) {
                int i = (event.getY() > value[3] ? 1 : (event.getY() == value[3] ? 0 : -1));
            }
        }
        return super.onTouchEvent(event);
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        v05 v05Var = this.callback;
        if (v05Var != null) {
            v05Var.onPause();
        }
    }

    public final void setCallback(v05 v05Var) {
        this.callback = v05Var;
    }

    public final void setClearsAfterDetached(boolean z) {
        this.clearsAfterDetached = z;
    }

    public final void setClearsAfterStop(boolean z) {
        this.clearsAfterStop = z;
    }

    public final void setFillMode(FillMode fillMode) {
        this.fillMode = fillMode;
    }

    public final void setLoops(int i) {
        this.loops = i;
    }

    public final void setVideoItem(m15 videoItem) {
        setVideoItem(videoItem, new z05());
    }

    public final void stepToFrame(int frame, boolean andPlay) {
        pauseAnimation();
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.f(frame);
            if (andPlay) {
                startAnimation();
                ValueAnimator valueAnimator = this.mAnimator;
                if (valueAnimator != null) {
                    valueAnimator.setCurrentPlayTime((long) (Math.max(0.0f, Math.min(1.0f, frame / sVGADrawable.getVideoItem().getFrames())) * valueAnimator.getDuration()));
                }
            }
        }
    }

    public final void stepToPercentage(double percentage, boolean andPlay) {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof y05)) {
            drawable = null;
        }
        y05 y05Var = (y05) drawable;
        if (y05Var != null) {
            int iN = (int) (((double) y05Var.getVideoItem().getFrames()) * percentage);
            if (iN >= y05Var.getVideoItem().getFrames() && iN > 0) {
                iN = y05Var.getVideoItem().getFrames() - 1;
            }
            stepToFrame(iN, andPlay);
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.clearsAfterStop);
    }

    @JvmOverloads
    public SVGAImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void setVideoItem(m15 videoItem, z05 dynamicItem) {
        if (videoItem == null) {
            setImageDrawable(null);
            return;
        }
        if (dynamicItem == null) {
            dynamicItem = new z05();
        }
        y05 y05Var = new y05(videoItem, dynamicItem);
        y05Var.e(true);
        setImageDrawable(y05Var);
    }

    public final void startAnimation() {
        startAnimation(null, false);
    }

    public final void stopAnimation(boolean clear) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        y05 sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.h();
        }
        y05 sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.e(clear);
        }
    }

    public /* synthetic */ SVGAImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void startAnimation(h15 range, boolean reverse) {
        stopAnimation(false);
        play(range, reverse);
    }

    @JvmOverloads
    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "SVGAImageView";
        this.fillMode = FillMode.Forward;
        this.mAntiAlias = true;
        this.mAutoPlay = true;
        this.mAnimatorListener = new a(this);
        this.mAnimatorUpdateListener = new b(this);
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/opensource/svgaplayer/SVGAImageView$c", "Lc15$d;", "Lm15;", "videoItem", "", "onComplete", "onError", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class c implements c15.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f7557a;

        public c(WeakReference weakReference) {
            this.f7557a = weakReference;
        }

        @Override // c15.d
        public void onComplete(m15 videoItem) {
            SVGAImageView sVGAImageView = (SVGAImageView) this.f7557a.get();
            if (sVGAImageView != null) {
                sVGAImageView.startAnimation(videoItem);
            }
        }

        @Override // c15.d
        public void onError() {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "It is recommended to use clearAfterDetached, or manually call to SVGAVideoEntity#clear.If you just consider cleaning up the canvas after playing, you can use FillMode#Clear.")
    public static /* synthetic */ void clearsAfterStop$annotations() {
    }

    public final void setOnAnimKeyClickListener(x05 clickListener) {
    }
}
