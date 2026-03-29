package com.bytedance.sdk.component.iz;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface s {
    s cache(nr nrVar);

    s cacheDir(String str);

    s config(Bitmap.Config config);

    s converter(jk jkVar);

    s from(String str);

    s headers(boolean z);

    s height(int i);

    s key(String str);

    s loadSetp(bq bqVar);

    s maxHeight(int i);

    s maxWidth(int i);

    s requestTime(boolean z);

    s runIn(ExecutorService executorService);

    s scaleType(ImageView.ScaleType scaleType);

    s sync(boolean z);

    l to(ImageView imageView);

    l to(qq qqVar);

    l to(qq qqVar, int i);

    s track(h hVar);

    s type(int i);

    s width(int i);
}
