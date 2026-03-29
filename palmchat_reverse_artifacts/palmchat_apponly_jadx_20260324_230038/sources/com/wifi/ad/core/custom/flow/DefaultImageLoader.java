package com.wifi.ad.core.custom.flow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.wifi.ad.core.utils.Async;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, d2 = {"Lcom/wifi/ad/core/custom/flow/DefaultImageLoader;", "Lcom/wifi/ad/core/custom/flow/AdImageLoader;", "()V", "loadImage", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "glideTransform", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "imgUrl", "", "core_release"}, k = 1, mv = {1, 1, 16})
public final class DefaultImageLoader implements AdImageLoader {
    @Override // com.wifi.ad.core.custom.flow.AdImageLoader
    public void loadImage(Context context, final ImageView imageView, final String imgUrl) {
        try {
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.custom.flow.DefaultImageLoader.loadImage.1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    URLConnection uRLConnectionOpenConnection = new URL(imgUrl).openConnection();
                    if (uRLConnectionOpenConnection == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    Async.INSTANCE.getMain$core_release().execute(new Runnable() { // from class: com.wifi.ad.core.custom.flow.DefaultImageLoader.loadImage.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            imageView.setImageBitmap(bitmapDecodeStream);
                        }
                    });
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.wifi.ad.core.custom.flow.AdImageLoader
    public void loadImage(Context context, ImageView imageView, String imgUrl, BitmapTransformation glideTransform) {
        loadImage(context, imageView, imgUrl);
    }

    @Override // com.wifi.ad.core.custom.flow.AdImageLoader
    public void loadImage(Context context, final ImageView imageView, final Bitmap bitmap, BitmapTransformation glideTransform) {
        try {
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.custom.flow.DefaultImageLoader.loadImage.2
                @Override // java.lang.Runnable
                public final void run() {
                    Async.INSTANCE.getMain$core_release().execute(new Runnable() { // from class: com.wifi.ad.core.custom.flow.DefaultImageLoader.loadImage.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
