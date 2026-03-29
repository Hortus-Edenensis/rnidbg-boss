package com.wifi.ad.core.imageloader;

import android.widget.ImageView;
import com.bumptech.glide.Glide;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultImageLoader implements IImageLoader {
    @Override // com.wifi.ad.core.imageloader.IImageLoader
    public void display(ImageView imageView, String str) {
        display(imageView, str, null);
    }

    @Override // com.wifi.ad.core.imageloader.IImageLoader
    public void display(ImageView imageView, String str, AbstractDisplay abstractDisplay) {
        int errorImage;
        int loadingImage;
        if (abstractDisplay != null) {
            errorImage = abstractDisplay.getErrorImage();
            loadingImage = abstractDisplay.getLoadingImage();
        } else {
            errorImage = 0;
            loadingImage = 0;
        }
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        Glide.with(imageView.getContext().getApplicationContext()).load2(str).placeholder(loadingImage).error(errorImage).into(imageView);
    }
}
