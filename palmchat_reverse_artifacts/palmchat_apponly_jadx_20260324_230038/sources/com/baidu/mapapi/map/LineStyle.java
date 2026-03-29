package com.baidu.mapapi.map;

import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LineStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BmLineStyle f3636a;
    int b;
    int c;
    TextureOption d;

    public LineStyle() {
        if (!OverlayUtil.isOverlayUpgrade()) {
            throw new NullPointerException("BDMapSDKException: LineStyle must be used in Overlay2.0");
        }
        this.f3636a = new BmLineStyle();
    }

    public void setBitmapResource(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null && OverlayUtil.isOverlayUpgrade()) {
            this.f3636a.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
        }
    }

    public void setColor(int i) {
        this.b = i;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f3636a.a(i);
        }
    }

    public void setTextureOption(TextureOption textureOption) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.d = textureOption;
            this.f3636a.c(textureOption.ordinal());
        }
    }

    public void setWidth(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.c = i / 2;
            this.f3636a.d(i);
        }
    }
}
