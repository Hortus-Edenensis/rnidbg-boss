package com.wifi.ad.core.custom.flow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class GlideImageLoader implements AdImageLoader {
    @Override // com.wifi.ad.core.custom.flow.AdImageLoader
    public void loadImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull String str) {
        if (context == null) {
            return;
        }
        Glide.with(context.getApplicationContext()).load2(str).into(imageView);
    }

    @Override // com.wifi.ad.core.custom.flow.AdImageLoader
    public void loadImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull String str, BitmapTransformation bitmapTransformation) {
        if (context == null) {
            return;
        }
        Glide.with(context.getApplicationContext()).load2(str).transform(bitmapTransformation).into(imageView);
    }

    @Override // com.wifi.ad.core.custom.flow.AdImageLoader
    public void loadImage(Context context, ImageView imageView, Bitmap bitmap, BitmapTransformation bitmapTransformation) {
        if (context == null) {
            return;
        }
        Glide.with(context.getApplicationContext()).load2((Drawable) new BitmapDrawable(bitmap)).transform(bitmapTransformation).into(imageView);
    }
}
