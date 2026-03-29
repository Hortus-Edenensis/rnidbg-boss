package com.huawei.openalliance.ad.views.dialog;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static final int B = 0;
    private static final String C = "PPSDialogUtil";
    public static final float Code = 16.0f;
    public static final int I = 16;
    public static final float V = 6.0f;
    protected static final int Z = 36;

    public static void Code(Context context, int i, ImageView imageView, PPSBaseDialogContentView pPSBaseDialogContentView, int i2) {
        Code(context, i, imageView, pPSBaseDialogContentView, i2, 0);
    }

    public static void Code(Context context, int i, ImageView imageView, PPSBaseDialogContentView pPSBaseDialogContentView, int i2, int i3) {
        int i4;
        int iV;
        int viewWith;
        fh.V(C, "getRealOrientation orientation %s", Integer.valueOf(i));
        if (context == null || pPSBaseDialogContentView == null || imageView == null) {
            fh.I(C, "param is invalid, return");
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pPSBaseDialogContentView.getLayoutParams();
        int iAbs = Math.abs((int) imageView.getX());
        int iV2 = z.V(context, 36.0f);
        int i5 = (iV2 >> 1) + iAbs;
        double d = ((double) iV2) * 0.5d;
        int viewWidthPercent = (int) ((((double) (i2 * (1.0f - pPSBaseDialogContentView.getViewWidthPercent()))) * 0.5d) + ((double) z.V(context, 16.0f)) + d);
        int viewWidthPercent2 = (int) (((((double) i2) * ((((double) pPSBaseDialogContentView.getViewWidthPercent()) * 0.5d) + 0.5d)) - ((double) z.V(context, 16.0f))) - d);
        fh.Code(C, "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        fh.Code(C, "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(iAbs), Integer.valueOf(iV2), Integer.valueOf(i5));
        if (1 == i || 9 == i) {
            i4 = i3;
            if (i5 < viewWidthPercent) {
                fh.Code(C, "curImgCenter < locationX");
                layoutParams.removeRule(14);
                pPSBaseDialogContentView.setLayoutParams(layoutParams);
                iV = iAbs - z.V(context, 16.0f);
            } else if (i5 <= viewWidthPercent2) {
                fh.Code(C, "locationX =< curImgCenter =< locationX2");
                layoutParams.addRule(14);
                pPSBaseDialogContentView.setLayoutParams(layoutParams);
                return;
            } else {
                fh.Code(C, "curImgCenter > locationX2");
                layoutParams.removeRule(14);
                pPSBaseDialogContentView.setLayoutParams(layoutParams);
                iV = ((iAbs + iV2) + z.V(context, 16.0f)) - pPSBaseDialogContentView.getViewWith();
                fh.Code(C, "paddingStart: %s", Integer.valueOf(iV));
            }
        } else {
            layoutParams.removeRule(14);
            pPSBaseDialogContentView.setLayoutParams(layoutParams);
            if (i5 < i2 / 3) {
                viewWith = z.V(context, 16.0f);
            } else if (i5 < (i2 * 2) / 3) {
                iV = i5 - (pPSBaseDialogContentView.getViewWith() >> 1);
                i4 = i3;
            } else {
                iAbs = iAbs + iV2 + z.V(context, 16.0f);
                viewWith = pPSBaseDialogContentView.getViewWith();
            }
            iV = iAbs - viewWith;
            i4 = i3;
        }
        pPSBaseDialogContentView.setPaddingStart(iV - z.V(context, i4));
    }
}
