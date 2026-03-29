package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kc2<TranscodeType> extends RequestBuilder<TranscodeType> {
    public kc2(@NonNull Class<TranscodeType> cls, @NonNull RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable Bitmap bitmap) {
        return (kc2) super.load2(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable Drawable drawable) {
        return (kc2) super.load2(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable Uri uri) {
        return (kc2) super.load2(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable File file) {
        return (kc2) super.load2(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable @DrawableRes @RawRes Integer num) {
        return (kc2) super.load2(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable Object obj) {
        return (kc2) super.load2(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable String str) {
        return (kc2) super.load2(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable URL url) {
        return (kc2) super.load2(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> load2(@Nullable byte[] bArr) {
        return (kc2) super.load2(bArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> lock() {
        return (kc2) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> onlyRetrieveFromCache(boolean z) {
        return (kc2) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> optionalCenterCrop() {
        return (kc2) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> optionalCenterInside() {
        return (kc2) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> optionalCircleCrop() {
        return (kc2) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> optionalFitCenter() {
        return (kc2) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (kc2) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public <Y> kc2<TranscodeType> optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (kc2) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> override(int i) {
        return (kc2) super.override(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> override(int i, int i2) {
        return (kc2) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> placeholder(@DrawableRes int i) {
        return (kc2) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> placeholder(@Nullable Drawable drawable) {
        return (kc2) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> priority(@NonNull Priority priority) {
        return (kc2) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public <Y> kc2<TranscodeType> set(@NonNull Option<Y> option, @NonNull Y y) {
        return (kc2) super.set(option, y);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> signature(@NonNull Key key) {
        return (kc2) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> sizeMultiplier(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        return (kc2) super.sizeMultiplier(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> skipMemoryCache(boolean z) {
        return (kc2) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (kc2) super.addListener(requestListener);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> theme(@Nullable Resources.Theme theme) {
        return (kc2) super.theme(theme);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (kc2) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> thumbnail(float f) {
        return (kc2) super.thumbnail(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> autoClone() {
        return (kc2) super.autoClone();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (kc2) super.thumbnail(requestBuilder);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> centerCrop() {
        return (kc2) super.centerCrop();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> thumbnail(@Nullable List<RequestBuilder<TranscodeType>> list) {
        return (kc2) super.thumbnail(list);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> centerInside() {
        return (kc2) super.centerInside();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @SafeVarargs
    @CheckResult
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final kc2<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (kc2) super.thumbnail(requestBuilderArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> circleCrop() {
        return (kc2) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> timeout(@IntRange(from = 0) int i) {
        return (kc2) super.timeout(i);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> mo45clone() {
        return (kc2) super.mo45clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> transform(@NonNull Transformation<Bitmap> transformation) {
        return (kc2) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> decode(@NonNull Class<?> cls) {
        return (kc2) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public <Y> kc2<TranscodeType> transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (kc2) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> disallowHardwareConfig() {
        return (kc2) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (kc2) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (kc2) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (kc2) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> dontAnimate() {
        return (kc2) super.dontAnimate();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (kc2) super.transition(transitionOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> dontTransform() {
        return (kc2) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> useAnimationPool(boolean z) {
        return (kc2) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (kc2) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        return (kc2) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (kc2) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> encodeQuality(@IntRange(from = 0, to = 100) int i) {
        return (kc2) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> error(@DrawableRes int i) {
        return (kc2) super.error(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> error(@Nullable Drawable drawable) {
        return (kc2) super.error(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (kc2) super.error((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> error(Object obj) {
        return (kc2) super.error(obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> fallback(@DrawableRes int i) {
        return (kc2) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> fallback(@Nullable Drawable drawable) {
        return (kc2) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> fitCenter() {
        return (kc2) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        return (kc2) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> frame(@IntRange(from = 0) long j) {
        return (kc2) super.frame(j);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public kc2<File> getDownloadOnlyRequest() {
        return new kc2(File.class, this).apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public kc2<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (kc2) super.listener(requestListener);
    }

    public kc2(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }
}
