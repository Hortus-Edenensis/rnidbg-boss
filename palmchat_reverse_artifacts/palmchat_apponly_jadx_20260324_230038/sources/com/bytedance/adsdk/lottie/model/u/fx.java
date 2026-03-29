package com.bytedance.adsdk.lottie.model.u;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends s<com.bytedance.adsdk.lottie.model.nr.b, com.bytedance.adsdk.lottie.model.nr.b> {
    public fx(List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b>> list) {
        super(u(list));
    }

    private static List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b>> u(List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, u(list.get(i)));
        }
        return list;
    }

    @Override // com.bytedance.adsdk.lottie.model.u.s, com.bytedance.adsdk.lottie.model.u.mv
    public /* bridge */ /* synthetic */ List fx() {
        return super.fx();
    }

    @Override // com.bytedance.adsdk.lottie.model.u.s, com.bytedance.adsdk.lottie.model.u.mv
    public /* bridge */ /* synthetic */ boolean nr() {
        return super.nr();
    }

    @Override // com.bytedance.adsdk.lottie.model.u.s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private static com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b> u(com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.b> uVar) {
        com.bytedance.adsdk.lottie.model.nr.b bVar = uVar.u;
        com.bytedance.adsdk.lottie.model.nr.b bVar2 = uVar.nr;
        if (bVar == null || bVar2 == null || bVar.u().length == bVar2.u().length) {
            return uVar;
        }
        float[] fArrU = u(bVar.u(), bVar2.u());
        return uVar.u(bVar.u(fArrU), bVar2.u(fArrU));
    }

    public static float[] u(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.u.mv
    public com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.b, com.bytedance.adsdk.lottie.model.nr.b> u() {
        return new com.bytedance.adsdk.lottie.u.nr.pn(this.u);
    }
}
