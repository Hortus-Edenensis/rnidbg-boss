package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lc2 extends RequestManager {
    public lc2(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public lc2 addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (lc2) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized lc2 applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (lc2) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public <ResourceType> kc2<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new kc2<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public kc2<Bitmap> asBitmap() {
        return (kc2) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public kc2<Drawable> asDrawable() {
        return (kc2) super.asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public kc2<File> asFile() {
        return (kc2) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public kc2<GifDrawable> asGif() {
        return (kc2) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized lc2 clearOnStop() {
        return (lc2) super.clearOnStop();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public kc2<File> download(@Nullable Object obj) {
        return (kc2) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public kc2<File> downloadOnly() {
        return (kc2) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable Bitmap bitmap) {
        return (kc2) super.load2(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable Drawable drawable) {
        return (kc2) super.load2(drawable);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable Uri uri) {
        return (kc2) super.load2(uri);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable File file) {
        return (kc2) super.load2(file);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable @DrawableRes @RawRes Integer num) {
        return (kc2) super.load2(num);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable Object obj) {
        return (kc2) super.load2(obj);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable String str) {
        return (kc2) super.load2(str);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable URL url) {
        return (kc2) super.load2(url);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public kc2<Drawable> load2(@Nullable byte[] bArr) {
        return (kc2) super.load2(bArr);
    }

    @Override // com.bumptech.glide.RequestManager
    public void setRequestOptions(@NonNull RequestOptions requestOptions) {
        if (requestOptions instanceof jc2) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new jc2().apply(requestOptions));
        }
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public synchronized lc2 setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (lc2) super.setDefaultRequestOptions(requestOptions);
    }
}
