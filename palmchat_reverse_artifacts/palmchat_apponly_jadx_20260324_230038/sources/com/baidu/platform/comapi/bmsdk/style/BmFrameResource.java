package com.baidu.platform.comapi.bmsdk.style;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmFrameResource extends BmDrawableResource {
    private BmFrameResource() {
        super(57, nativeCreate());
    }

    private void a(List<BmBitmapResource> list, int[] iArr, int i) {
        if (list == null || list.size() == 0) {
            return;
        }
        long[] jArr = new long[list.size()];
        Iterator<BmBitmapResource> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().getNativeInstance();
            i2++;
        }
        nativeSetBitmapResources(this.nativeInstance, jArr, i2, iArr, iArr.length, i);
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResources(long j, long[] jArr, int i, int[] iArr, int i2, int i3);

    private static native long nativeSetInterval(long j, int i, int i2);

    private static native boolean nativeSetResIds(long j, int[] iArr, int i, int[] iArr2, int i2, int i3);

    public BmFrameResource(List<BmBitmapResource> list, int i, int i2) {
        super(57, nativeCreate());
        a(list, i, i2);
    }

    public BmFrameResource(List<BmBitmapResource> list, int[] iArr, int i) {
        super(57, nativeCreate());
        a(list, iArr, i);
    }

    private void a(List<BmBitmapResource> list, int i, int i2) {
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = i;
        }
        a(list, iArr, i2);
    }

    public void a(int i, int i2) {
        if (i2 < 20 || i <= 0) {
            return;
        }
        nativeSetInterval(this.nativeInstance, i, i2);
    }
}
