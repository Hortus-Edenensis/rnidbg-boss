package com.baidu.platform.comapi.bmsdk.style;

import android.graphics.Bitmap;
import android.graphics.NinePatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmBitmapResource extends BmDrawableResource {
    private BmBitmapResource() {
        super(56, nativeCreate());
    }

    private void a(Bitmap bitmap, boolean z) {
        b bVarA;
        if (bitmap != null) {
            nativeSetBitmap(this.nativeInstance, bitmap, hashCode(), bitmap.hashCode(), z);
            if (bitmap.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk()) || (bVarA = b.a(bitmap.getNinePatchChunk())) == null) {
                return;
            }
            int i = bVarA.f4126a[0];
            int width = bitmap.getWidth();
            int[] iArr = bVarA.f4126a;
            a(bVarA.b, bVarA.c, new int[]{i, width - iArr[1], iArr[2], bitmap.getHeight() - bVarA.f4126a[3]});
        }
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmap(long j, Bitmap bitmap, int i, int i2, boolean z);

    private static native boolean nativeSetFillArea(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetScaleX(long j, int[] iArr, int i);

    private static native boolean nativeSetScaleY(long j, int[] iArr, int i);

    public BmBitmapResource(Bitmap bitmap) {
        super(56, nativeCreate());
        a(bitmap, false);
    }

    private void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (iArr != null && iArr.length > 0) {
            nativeSetScaleX(this.nativeInstance, iArr, iArr.length);
        }
        if (iArr2 != null && iArr2.length > 0) {
            nativeSetScaleY(this.nativeInstance, iArr2, iArr2.length);
        }
        if (iArr3 == null || iArr3.length != 4) {
            return;
        }
        nativeSetFillArea(this.nativeInstance, iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
    }
}
