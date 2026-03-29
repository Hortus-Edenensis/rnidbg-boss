package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
interface ModelTypes<T> {
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable Drawable drawable);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable Uri uri);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable File file);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable @DrawableRes @RawRes Integer num);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable Object obj);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable String str);

    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: load */
    T load2(@Nullable URL url);

    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    T load2(@Nullable byte[] bArr);
}
