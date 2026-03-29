package com.wifi.ad.core.custom.flow;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\rH&J.\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/wifi/ad/core/custom/flow/AdImageLoader;", "", "loadImage", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "glideTransform", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "imgUrl", "", "core_release"}, k = 1, mv = {1, 1, 16})
public interface AdImageLoader {
    void loadImage(Context context, @NonNull ImageView imageView, @NonNull Bitmap bitmap, BitmapTransformation glideTransform);

    void loadImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull String imgUrl);

    void loadImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull String imgUrl, BitmapTransformation glideTransform);
}
