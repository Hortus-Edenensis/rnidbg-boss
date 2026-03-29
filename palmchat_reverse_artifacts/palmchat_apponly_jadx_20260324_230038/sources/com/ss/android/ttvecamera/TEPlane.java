package com.ss.android.ttvecamera;

import android.annotation.TargetApi;
import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(19)
public class TEPlane {
    Image.Plane[] planes;

    public TEPlane() {
    }

    public ByteBuffer getPlaneBuffer(int i) {
        Image.Plane[] planeArr = this.planes;
        if (planeArr == null || planeArr.length <= i) {
            return null;
        }
        return planeArr[i].getBuffer();
    }

    public Image.Plane[] getPlanes() {
        return this.planes;
    }

    public TEPlane(Image.Plane[] planeArr) {
        this.planes = planeArr;
    }
}
