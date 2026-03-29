package com.opos.mobad.ui.c;

import android.content.Context;
import android.view.View;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f10249a = {SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};

    public static int[] a(Context context, View view, View view2, int[] iArr) {
        com.opos.cmn.an.f.a.b("CoordinationTools", "translate coordinate, " + Arrays.toString(iArr));
        if (context == null || view == null || view2 == null || iArr == null || iArr.length != 4 || Arrays.equals(iArr, f10249a)) {
            return iArr;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int[] iArr3 = new int[2];
        view2.getLocationOnScreen(iArr3);
        int i = iArr3[0] - iArr2[0];
        int i2 = iArr3[1] - iArr2[1];
        int[] iArr4 = {com.opos.cmn.an.h.f.a.b(context, iArr[0] + i), com.opos.cmn.an.h.f.a.b(context, iArr[1] + i2), com.opos.cmn.an.h.f.a.b(context, iArr[2] + i), com.opos.cmn.an.h.f.a.b(context, iArr[3] + i2)};
        com.opos.cmn.an.f.a.b("CoordinationTools", "translate coordinate, ", Arrays.toString(iArr2), Arrays.toString(iArr3));
        com.opos.cmn.an.f.a.b("CoordinationTools", "translate coordinate, " + Arrays.toString(iArr4) + "[0][2]need minus -: " + i + "[1][3] need minus -" + i2);
        return iArr4;
    }
}
