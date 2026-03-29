package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.mapapi.map.WeightedLatLng;
import defpackage.b03;
import defpackage.c93;
import defpackage.d83;
import defpackage.d93;
import defpackage.dd5;
import defpackage.e93;
import defpackage.g93;
import defpackage.i93;
import defpackage.id5;
import defpackage.lg4;
import defpackage.m03;
import defpackage.m63;
import defpackage.ou5;
import defpackage.r02;
import defpackage.r86;
import defpackage.rq2;
import defpackage.u73;
import defpackage.u83;
import defpackage.w83;
import defpackage.y83;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final y83<Throwable> DEFAULT_FAILURE_LISTENER = new y83() { // from class: s73
        @Override // defpackage.y83
        public final void onResult(Object obj) {
            LottieAnimationView.lambda$static$0((Throwable) obj);
        }
    };
    private static final String TAG = "LottieAnimationView";
    private String animationName;

    @RawRes
    private int animationResId;
    private boolean autoPlay;
    private boolean cacheComposition;

    @Nullable
    private u73 composition;

    @Nullable
    private g93<u73> compositionTask;

    @Nullable
    private y83<Throwable> failureListener;

    @DrawableRes
    private int fallbackResource;
    private boolean ignoreUnschedule;
    private final y83<u73> loadedListener;
    private final u83 lottieDrawable;
    private final Set<c93> lottieOnCompositionLoadedListeners;
    private final Set<c> userActionsTaken;
    private final y83<Throwable> wrappedFailureListener;

    /* JADX INFO: compiled from: SearchBox */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2514a;
        public int b;
        public float c;
        public boolean d;
        public String e;
        public int f;
        public int g;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2514a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2514a = parcel.readString();
            this.c = parcel.readFloat();
            this.d = parcel.readInt() == 1;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements y83<Throwable> {
        public a() {
        }

        @Override // defpackage.y83
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public class b<T> extends i93<T> {
        public b(id5 id5Var) {
        }

        @Override // defpackage.i93
        public T a(w83<T> w83Var) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new y83() { // from class: r73
            @Override // defpackage.y83
            public final void onResult(Object obj) {
                this.f20407a.setComposition((u73) obj);
            }
        };
        this.wrappedFailureListener = new a();
        this.fallbackResource = 0;
        this.lottieDrawable = new u83();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null, R$attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        g93<u73> g93Var = this.compositionTask;
        if (g93Var != null) {
            g93Var.j(this.loadedListener);
            this.compositionTask.i(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.y();
    }

    private g93<u73> fromAssets(final String str) {
        return isInEditMode() ? new g93<>(new Callable() { // from class: t73
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f20917a.lambda$fromAssets$2(str);
            }
        }, true) : this.cacheComposition ? d83.j(getContext(), str) : d83.k(getContext(), str, null);
    }

    private g93<u73> fromRawRes(@RawRes final int i) {
        return isInEditMode() ? new g93<>(new Callable() { // from class: q73
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f20194a.lambda$fromRawRes$1(i);
            }
        }, true) : this.cacheComposition ? d83.s(getContext(), i) : d83.t(getContext(), i, null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i, 0);
        this.cacheComposition = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = R$styleable.LottieAnimationView_lottie_rawRes;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
        int i3 = R$styleable.LottieAnimationView_lottie_fileName;
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i3);
        int i4 = R$styleable.LottieAnimationView_lottie_url;
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i4);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(i3);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i4)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.autoPlay = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.i1(-1);
        }
        int i5 = R$styleable.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = R$styleable.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = R$styleable.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i7, 1.0f));
        }
        int i8 = R$styleable.LottieAnimationView_lottie_clipToCompositionBounds;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(i8, true));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i9 = R$styleable.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            addValueCallback(new b03("**"), d93.K, (i93<ColorFilter>) new i93(new dd5(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(i9, -1)).getDefaultColor())));
        }
        int i10 = R$styleable.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i10, renderMode.ordinal());
            if (iOrdinal >= RenderMode.values().length) {
                iOrdinal = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[iOrdinal]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        typedArrayObtainStyledAttributes.recycle();
        this.lottieDrawable.m1(Boolean.valueOf(r86.f(getContext()) != 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e93 lambda$fromAssets$2(String str) throws Exception {
        return this.cacheComposition ? d83.l(getContext(), str) : d83.m(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e93 lambda$fromRawRes$1(int i) throws Exception {
        return this.cacheComposition ? d83.u(getContext(), i) : d83.v(getContext(), i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Throwable th) {
        if (!r86.k(th)) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
        m63.d("Unable to load composition.", th);
    }

    private void setCompositionTask(g93<u73> g93Var) {
        this.userActionsTaken.add(c.SET_ANIMATION);
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = g93Var.d(this.loadedListener).c(this.wrappedFailureListener);
    }

    private void setLottieDrawable() {
        boolean zIsAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        if (zIsAnimating) {
            this.lottieDrawable.I0();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.r(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.s(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.t(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull c93 c93Var) {
        u73 u73Var = this.composition;
        if (u73Var != null) {
            c93Var.a(u73Var);
        }
        return this.lottieOnCompositionLoadedListeners.add(c93Var);
    }

    public <T> void addValueCallback(b03 b03Var, T t, i93<T> i93Var) {
        this.lottieDrawable.u(b03Var, t, i93Var);
    }

    @MainThread
    public void cancelAnimation() {
        this.userActionsTaken.add(c.PLAY_OPTION);
        this.lottieDrawable.x();
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.C();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.E(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.lottieDrawable.K();
    }

    @Nullable
    public u73 getComposition() {
        return this.composition;
    }

    public long getDuration() {
        u73 u73Var = this.composition;
        if (u73Var != null) {
            return (long) u73Var.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.O();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.Q();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.lottieDrawable.S();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.T();
    }

    public float getMinFrame() {
        return this.lottieDrawable.U();
    }

    @Nullable
    public lg4 getPerformanceTracker() {
        return this.lottieDrawable.V();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.lottieDrawable.W();
    }

    public RenderMode getRenderMode() {
        return this.lottieDrawable.X();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.Y();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.Z();
    }

    public float getSpeed() {
        return this.lottieDrawable.a0();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.d0();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.e0();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof u83) && ((u83) drawable).X() == RenderMode.SOFTWARE) {
            this.lottieDrawable.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        u83 u83Var = this.lottieDrawable;
        if (drawable2 == u83Var) {
            super.invalidateDrawable(u83Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.g0();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.j0();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.i1(z ? -1 : 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.autoPlay) {
            return;
        }
        this.lottieDrawable.A0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.f2514a;
        Set<c> set = this.userActionsTaken;
        c cVar = c.SET_ANIMATION;
        if (!set.contains(cVar) && !TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.b;
        if (!this.userActionsTaken.contains(cVar) && (i = this.animationResId) != 0) {
            setAnimation(i);
        }
        if (!this.userActionsTaken.contains(c.SET_PROGRESS)) {
            setProgress(savedState.c);
        }
        if (!this.userActionsTaken.contains(c.PLAY_OPTION) && savedState.d) {
            playAnimation();
        }
        if (!this.userActionsTaken.contains(c.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.e);
        }
        if (!this.userActionsTaken.contains(c.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f);
        }
        if (this.userActionsTaken.contains(c.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.g);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2514a = this.animationName;
        savedState.b = this.animationResId;
        savedState.c = this.lottieDrawable.W();
        savedState.d = this.lottieDrawable.h0();
        savedState.e = this.lottieDrawable.Q();
        savedState.f = this.lottieDrawable.Z();
        savedState.g = this.lottieDrawable.Y();
        return savedState;
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.lottieDrawable.z0();
    }

    @MainThread
    public void playAnimation() {
        this.userActionsTaken.add(c.PLAY_OPTION);
        this.lottieDrawable.A0();
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.B0();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.C0();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.D0(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.E0(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull c93 c93Var) {
        return this.lottieOnCompositionLoadedListeners.remove(c93Var);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.F0(animatorUpdateListener);
    }

    public List<b03> resolveKeyPath(b03 b03Var) {
        return this.lottieDrawable.H0(b03Var);
    }

    @MainThread
    public void resumeAnimation() {
        this.userActionsTaken.add(c.PLAY_OPTION);
        this.lottieDrawable.I0();
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.J0();
    }

    public void setAnimation(@RawRes int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(fromRawRes(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? d83.w(getContext(), str) : d83.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.L0(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setClipToCompositionBounds(boolean z) {
        this.lottieDrawable.M0(z);
    }

    public void setComposition(@NonNull u73 u73Var) {
        if (m03.f19114a) {
            Log.v(TAG, "Set Composition \n" + u73Var);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = u73Var;
        this.ignoreUnschedule = true;
        boolean zN0 = this.lottieDrawable.N0(u73Var);
        this.ignoreUnschedule = false;
        if (getDrawable() != this.lottieDrawable || zN0) {
            if (!zN0) {
                setLottieDrawable();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<c93> it = this.lottieOnCompositionLoadedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(u73Var);
            }
        }
    }

    public void setFailureListener(@Nullable y83<Throwable> y83Var) {
        this.failureListener = y83Var;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(r02 r02Var) {
        this.lottieDrawable.O0(r02Var);
    }

    public void setFrame(int i) {
        this.lottieDrawable.P0(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.lottieDrawable.Q0(z);
    }

    public void setImageAssetDelegate(rq2 rq2Var) {
        this.lottieDrawable.R0(rq2Var);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.S0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.lottieDrawable.T0(z);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.U0(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        this.lottieDrawable.W0(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.Y0(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f2) {
        this.lottieDrawable.a1(f, f2);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.b1(i);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.d1(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.lottieDrawable.e1(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.f1(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        this.userActionsTaken.add(c.SET_PROGRESS);
        this.lottieDrawable.g1(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.lottieDrawable.h1(renderMode);
    }

    public void setRepeatCount(int i) {
        this.userActionsTaken.add(c.SET_REPEAT_COUNT);
        this.lottieDrawable.i1(i);
    }

    public void setRepeatMode(int i) {
        this.userActionsTaken.add(c.SET_REPEAT_MODE);
        this.lottieDrawable.j1(i);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.k1(z);
    }

    public void setSpeed(float f) {
        this.lottieDrawable.l1(f);
    }

    public void setTextDelegate(ou5 ou5Var) {
        this.lottieDrawable.n1(ou5Var);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        u83 u83Var;
        if (!this.ignoreUnschedule && drawable == (u83Var = this.lottieDrawable) && u83Var.g0()) {
            pauseAnimation();
        } else if (!this.ignoreUnschedule && (drawable instanceof u83)) {
            u83 u83Var2 = (u83) drawable;
            if (u83Var2.g0()) {
                u83Var2.z0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.o1(str, bitmap);
    }

    public <T> void addValueCallback(b03 b03Var, T t, id5<T> id5Var) {
        this.lottieDrawable.u(b03Var, t, new b(id5Var));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.V0(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.Z0(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.c1(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.X0(i, i2);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(d83.x(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(d83.n(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new y83() { // from class: r73
            @Override // defpackage.y83
            public final void onResult(Object obj) {
                this.f20407a.setComposition((u73) obj);
            }
        };
        this.wrappedFailureListener = new a();
        this.fallbackResource = 0;
        this.lottieDrawable = new u83();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new y83() { // from class: r73
            @Override // defpackage.y83
            public final void onResult(Object obj) {
                this.f20407a.setComposition((u73) obj);
            }
        };
        this.wrappedFailureListener = new a();
        this.fallbackResource = 0;
        this.lottieDrawable = new u83();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet, i);
    }
}
