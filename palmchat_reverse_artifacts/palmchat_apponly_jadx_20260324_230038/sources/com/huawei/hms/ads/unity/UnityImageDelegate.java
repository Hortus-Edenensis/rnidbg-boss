package com.huawei.hms.ads.unity;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.annotation.AllApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public class UnityImageDelegate {
    private Image Code;
    private Drawable V;

    @AllApi
    public UnityImageDelegate(Image image) {
        this.Code = image;
    }

    @AllApi
    public Drawable getDrawable() {
        return this.V;
    }

    @AllApi
    public Uri getUri() {
        Image image = this.Code;
        if (image != null) {
            return image.getUri();
        }
        return null;
    }

    @AllApi
    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.V = drawable;
        }
    }
}
