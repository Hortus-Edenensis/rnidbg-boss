package com.baidu.mapapi.map;

import android.os.Bundle;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Tile {
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i, int i2, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.data = bArr;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(WfConstant.EXTRA_KEY_IMAGE_WIDTH, this.width);
        bundle.putInt(WfConstant.EXTRA_KEY_IMAGE_HEIGHT, this.height);
        bundle.putByteArray("image_data", this.data);
        return bundle;
    }
}
