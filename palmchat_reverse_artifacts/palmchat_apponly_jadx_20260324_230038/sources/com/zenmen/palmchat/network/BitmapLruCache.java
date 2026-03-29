package com.zenmen.palmchat.network;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.android.volley.toolbox.ImageLoader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BitmapLruCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    @Override // androidx.collection.LruCache
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.android.volley.toolbox.ImageLoader.ImageCache
    public Bitmap getBitmap(String str) {
        return get(str);
    }

    @Override // com.android.volley.toolbox.ImageLoader.ImageCache
    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }
}
