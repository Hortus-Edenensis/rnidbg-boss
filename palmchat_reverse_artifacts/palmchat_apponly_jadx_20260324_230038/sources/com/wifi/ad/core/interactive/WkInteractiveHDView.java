package com.wifi.ad.core.interactive;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.UIUtils;
import com.wifi.ad.core.utils.WifiLog;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkInteractiveHDView extends View {
    private long downTime;
    private int interactiveType;
    private double lastX;
    private double lastY;
    private WeakReference<NestAdData> mWeakAdData;
    private int minDuration;
    private double startX;
    private double startY;

    public WkInteractiveHDView(Context context, NestAdData nestAdData, int i, int i2) {
        super(context);
        this.minDuration = 0;
        this.downTime = 0L;
        if (nestAdData != null) {
            this.mWeakAdData = new WeakReference<>(nestAdData);
        }
        this.interactiveType = i;
        this.minDuration = UIUtils.dip2px(context, 55.0f);
        setBackgroundColor(Color.parseColor("#33000000"));
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void calculateDownUp() {
        double d;
        double d2;
        int i;
        boolean z;
        int i2 = (int) (this.lastX - this.startX);
        int i3 = (int) (this.lastY - this.startY);
        if (((int) Math.sqrt((i2 * i2) + (i3 * i3))) < this.minDuration) {
            return;
        }
        double degrees = Math.toDegrees(Math.atan2(i3, i2));
        if (degrees >= -90.0d && degrees <= 180.0d) {
            d2 = 90.0d;
        } else {
            if (degrees >= -90.0d || degrees <= -179.0d) {
                d = 0.0d;
                i = this.interactiveType;
                z = true;
                if (i == 101 ? i != 104 ? i != 103 || ((d < 0.0d || d > 30.0d) && ((d < 150.0d || d > 210.0d) && (d < 330.0d || d > 359.0d))) : d < 60.0d || d > 120.0d : (d < 0.0d || d > 30.0d) && (d < 330.0d || d > 359.0d)) {
                }
                WifiLog.d("interactive WkInteractiveHDView result " + z + " interactiveType " + this.interactiveType + " angleDeg " + d);
                if (z) {
                    return;
                }
                itemClick("1");
                return;
            }
            d2 = 450.0d;
        }
        d = degrees + d2;
        i = this.interactiveType;
        z = true;
        z = i == 101 ? false : false;
        WifiLog.d("interactive WkInteractiveHDView result " + z + " interactiveType " + this.interactiveType + " angleDeg " + d);
        if (z) {
        }
    }

    private boolean isClickDistance() {
        return Math.abs(this.startX - this.lastX) < 5.0d && Math.abs(this.startY - this.lastY) < 5.0d;
    }

    private void itemClick(String str) {
        WeakReference<NestAdData> weakReference = this.mWeakAdData;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        WkInteractiveManager.nestAdClick(this.mWeakAdData.get(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downTime = System.currentTimeMillis();
            double d = x;
            this.lastX = d;
            double d2 = y;
            this.lastY = d2;
            this.startX = d;
            this.startY = d2;
            WifiLog.d("interactive WkInteractiveHDViewonTouchEvent ACTION_DOWN ");
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            WifiLog.d("interactive WkInteractiveHDViewonTouchEvent ACTION_UP " + motionEvent.getAction());
            getParent().requestDisallowInterceptTouchEvent(false);
            if (System.currentTimeMillis() - this.downTime >= 500 || !isClickDistance()) {
                WifiLog.d("interactive WkInteractiveHDViewonTouchEvent ACTION_UP calculateDownUp ");
                calculateDownUp();
            } else {
                WifiLog.d("interactive WkInteractiveHDViewonTouchEvent ACTION_UP click ");
                itemClick("0");
            }
        } else if (action == 2) {
            this.lastX = x;
            this.lastY = y;
            WifiLog.d("interactive WkInteractiveHDViewonTouchEvent ACTION_MOVE ");
        } else if (action == 3) {
        }
        return true;
    }
}
