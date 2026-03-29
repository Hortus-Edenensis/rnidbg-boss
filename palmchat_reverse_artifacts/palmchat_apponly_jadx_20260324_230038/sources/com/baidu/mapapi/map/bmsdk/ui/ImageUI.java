package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmImageUI;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ImageUI extends BaseUI {
    private BmImageUI c;

    public ImageUI() {
        BmImageUI bmImageUI = new BmImageUI();
        this.c = bmImageUI;
        bmImageUI.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.c;
    }

    public void setClickable(boolean z) {
        this.c.a(z);
    }

    public void setColor(int i) {
        this.c.j(i);
    }

    public void setDrawableResource(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.c.b(new BmBitmapResource(bitmapDescriptor.getBitmap()));
    }

    public void setHeight(int i) {
        this.c.f(i);
    }

    public void setMargin(int i, int i2, int i3, int i4) {
        this.c.a(i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.c.b(i, i2, i3, i4);
    }

    public void setWidth(int i) {
        this.c.i(i);
    }
}
