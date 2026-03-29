package com.huawei.hms.ads;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class dx {
    int Code;
    int I;
    Bitmap V;

    public dx() {
    }

    public dx(int i, Bitmap bitmap, int i2) {
        this.Code = i;
        this.V = bitmap;
        this.I = i2;
    }

    public dx Code() {
        dx dxVar = new dx();
        dxVar.Code = this.Code;
        dxVar.I = this.I;
        return dxVar;
    }

    public String toString() {
        return "GifFrame{frameIndex=" + this.Code + ", delay=" + this.I + '}';
    }
}
