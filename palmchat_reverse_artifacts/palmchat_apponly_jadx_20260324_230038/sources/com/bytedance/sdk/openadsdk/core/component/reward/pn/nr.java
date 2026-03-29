package com.bytedance.sdk.openadsdk.core.component.reward.pn;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr {
    public static float[] u(Context context, float f, int i) {
        float fMin;
        float fMax;
        float[] fArr = new float[2];
        float fB = y.b(context, y.a(context));
        float fB2 = y.b(context, y.jk(context));
        if (i == 2) {
            fMin = Math.max(fB, fB2);
            fMax = Math.min(fB, fB2);
        } else {
            fMin = Math.min(fB, fB2);
            fMax = Math.max(fB, fB2);
        }
        int iB = y.b(context, y.t(context));
        if (y.nr() || f != 100.0f) {
            if (i != 2) {
                fMax -= iB;
            } else {
                if ("SM-A207F".equals(jk.nr())) {
                    iB *= 2;
                }
                fMin -= iB;
            }
        }
        fArr[0] = fMin;
        fArr[1] = fMax;
        return fArr;
    }

    public static int[] u(Context context, float f, float f2, int i) {
        int iMax;
        float[] fArrU = u(context, f, i);
        float f3 = fArrU[0];
        float f4 = fArrU[1];
        int[] iArr = new int[4];
        int iMin = (int) (Math.min(f3, f4) * f2);
        if (i != 2) {
            float f5 = iMin;
            iMax = (int) Math.max((f4 - (((f3 - f5) - f5) / f)) / 2.0f, 0.0f);
        } else {
            float f6 = iMin;
            iMin = (int) Math.max((f3 - (((f4 - f6) - f6) * f)) / 2.0f, 0.0f);
            iMax = iMin;
        }
        iArr[0] = iMin;
        iArr[1] = iMax;
        iArr[2] = iMin;
        iArr[3] = iMax;
        return iArr;
    }
}
