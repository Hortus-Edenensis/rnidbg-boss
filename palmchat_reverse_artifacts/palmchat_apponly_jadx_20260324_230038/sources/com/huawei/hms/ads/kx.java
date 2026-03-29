package com.huawei.hms.ads;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kx {
    public static int Code(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static boolean V(View view, MotionEvent motionEvent) {
        int[] iArrCode;
        if (view == null || motionEvent == null) {
            return true;
        }
        if ((view instanceof ImageView) && (iArrCode = Code(view)) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int width = view.getWidth();
            int height = view.getHeight();
            int i = iArrCode[0];
            int i2 = iArrCode[1];
            float fAbs = Math.abs((width / 2) - x) - (i / 2);
            float fAbs2 = Math.abs((height / 2) - y) - (i2 / 2);
            if (fAbs > 0.0f || fAbs2 > 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static MaterialClickInfo Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return new MaterialClickInfo();
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        sb.append(width);
        sb.append("*");
        sb.append(height);
        return new MaterialClickInfo.a().Code(Integer.valueOf((int) x)).V(Integer.valueOf((int) y)).V(sb.toString()).V(Long.valueOf(System.currentTimeMillis())).Code();
    }

    public static void Code(View view, MotionEvent motionEvent, Integer num, MaterialClickInfo materialClickInfo) {
        if (materialClickInfo == null || view == null || motionEvent == null) {
            return;
        }
        materialClickInfo.Code(Long.valueOf(System.currentTimeMillis()));
        materialClickInfo.Code(Float.valueOf(d.a(view.getContext())));
        if (num != null) {
            materialClickInfo.V(num);
        }
        if (materialClickInfo.Z() == null) {
            materialClickInfo.V((Integer) 0);
        }
        MaterialClickInfo materialClickInfoCode = Code(view, motionEvent);
        if (materialClickInfoCode != null) {
            materialClickInfo.I(materialClickInfoCode.Code());
            materialClickInfo.Z(materialClickInfoCode.V());
        }
    }

    private static int[] Code(View view) {
        if (!(view instanceof ImageView)) {
            return null;
        }
        ImageView imageView = (ImageView) view;
        if (imageView.getDrawable() == null) {
            return null;
        }
        int iWidth = imageView.getDrawable().getBounds().width();
        int iHeight = imageView.getDrawable().getBounds().height();
        float[] fArr = new float[10];
        imageView.getImageMatrix().getValues(fArr);
        return new int[]{(int) (iWidth * fArr[0]), (int) (iHeight * fArr[4])};
    }
}
