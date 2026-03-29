package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class jc2 extends RequestOptions {
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public jc2 optionalCircleCrop() {
        return (jc2) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public jc2 optionalFitCenter() {
        return (jc2) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public jc2 optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (jc2) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public <Y> jc2 optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (jc2) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public jc2 override(int i) {
        return (jc2) super.override(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public jc2 override(int i, int i2) {
        return (jc2) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public jc2 placeholder(@DrawableRes int i) {
        return (jc2) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public jc2 placeholder(@Nullable Drawable drawable) {
        return (jc2) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public jc2 priority(@NonNull Priority priority) {
        return (jc2) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public <Y> jc2 set(@NonNull Option<Y> option, @NonNull Y y) {
        return (jc2) super.set(option, y);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public jc2 signature(@NonNull Key key) {
        return (jc2) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public jc2 sizeMultiplier(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        return (jc2) super.sizeMultiplier(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public jc2 skipMemoryCache(boolean z) {
        return (jc2) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public jc2 theme(@Nullable Resources.Theme theme) {
        return (jc2) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public jc2 timeout(@IntRange(from = 0) int i) {
        return (jc2) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public jc2 transform(@NonNull Transformation<Bitmap> transformation) {
        return (jc2) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public <Y> jc2 transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (jc2) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final jc2 transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (jc2) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final jc2 transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (jc2) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public jc2 useAnimationPool(boolean z) {
        return (jc2) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public jc2 useUnlimitedSourceGeneratorsPool(boolean z) {
        return (jc2) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public jc2 apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (jc2) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public jc2 autoClone() {
        return (jc2) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public jc2 centerCrop() {
        return (jc2) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public jc2 centerInside() {
        return (jc2) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public jc2 circleCrop() {
        return (jc2) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public jc2 mo45clone() {
        return (jc2) super.mo45clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public jc2 decode(@NonNull Class<?> cls) {
        return (jc2) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public jc2 disallowHardwareConfig() {
        return (jc2) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public jc2 diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (jc2) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public jc2 dontAnimate() {
        return (jc2) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public jc2 dontTransform() {
        return (jc2) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public jc2 downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (jc2) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public jc2 encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (jc2) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public jc2 encodeQuality(@IntRange(from = 0, to = 100) int i) {
        return (jc2) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public jc2 error(@DrawableRes int i) {
        return (jc2) super.error(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public jc2 error(@Nullable Drawable drawable) {
        return (jc2) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public jc2 fallback(@DrawableRes int i) {
        return (jc2) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public jc2 fallback(@Nullable Drawable drawable) {
        return (jc2) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public jc2 fitCenter() {
        return (jc2) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public jc2 format(@NonNull DecodeFormat decodeFormat) {
        return (jc2) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public jc2 frame(@IntRange(from = 0) long j) {
        return (jc2) super.frame(j);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public jc2 lock() {
        return (jc2) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public jc2 onlyRetrieveFromCache(boolean z) {
        return (jc2) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public jc2 optionalCenterCrop() {
        return (jc2) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public jc2 optionalCenterInside() {
        return (jc2) super.optionalCenterInside();
    }
}
