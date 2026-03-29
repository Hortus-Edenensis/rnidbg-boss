package com.huawei.hms.ads.nativead;

import android.graphics.drawable.Drawable;
import com.huawei.hms.ads.annotation.GlobalApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public interface MediaContent {
    float getAspectRatio();

    Drawable getImage();

    void setImage(Drawable drawable);
}
