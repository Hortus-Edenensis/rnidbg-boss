package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jw {
    private static final String Z = "SafeDetectorFactory";
    public static final int[] Code = {1, 3, 2, 4};
    public static final int[] V = {0, 3, 2, 4};
    public static final int[] I = {3, 2, 4};

    public static jv Code(Context context, AdContentData adContentData, StackTraceElement[] stackTraceElementArr, View view, int[] iArr) {
        if (context == null || adContentData == null) {
            return new ju();
        }
        List<jv> listV = V(context, adContentData, stackTraceElementArr, view, iArr);
        if (com.huawei.openalliance.ad.utils.ag.Code(listV)) {
            return new ju();
        }
        jv jvVar = null;
        for (jv jvVar2 : listV) {
            if (jvVar != null) {
                jvVar.Code(jvVar2);
            }
            jvVar = jvVar2;
        }
        return listV.get(0);
    }

    private static List<jv> V(Context context, AdContentData adContentData, StackTraceElement[] stackTraceElementArr, View view, int[] iArr) {
        Object jsVar;
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            if (i == 0) {
                jsVar = new js(context, adContentData, stackTraceElementArr, view);
            } else if (i == 1) {
                jsVar = new jz(context, adContentData, stackTraceElementArr, view);
            } else if (i == 2) {
                jsVar = new jr(context, adContentData, view);
            } else if (i == 3) {
                jsVar = new jy(context, adContentData, view);
            } else if (i != 4) {
                fh.I(Z, "create safe detector, fall to default");
                jsVar = null;
            } else {
                jsVar = new jx(context, adContentData, view);
            }
            if (jsVar != null) {
                arrayList.add(jsVar);
            }
        }
        return arrayList;
    }
}
