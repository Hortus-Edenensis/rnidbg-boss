package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.android.app.HwMultiWindowEx;
import com.huawei.android.content.pm.ApplicationInfoEx;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.view.DisplaySideRegionEx;
import com.huawei.android.view.WindowManagerEx;
import com.huawei.hms.framework.common.EmuiUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cw extends cr {
    private static final String Code = "HwSysApiImpl";
    private static final byte[] I = new byte[0];
    private static cz V;

    private cw(Context context) {
    }

    private static cz V(Context context) {
        cz czVar;
        synchronized (I) {
            if (V == null) {
                V = new cw(context);
            }
            czVar = V;
        }
        return czVar;
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String B() {
        return "com.huawei.android.os.BuildEx";
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String C() {
        return "com.huawei.android.os.SystemPropertiesEx";
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public int Code(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String I() {
        return "com.huawei.android.net.wifi.WifiManagerCommonEx";
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public int S() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String Z() {
        return EmuiUtil.BUILDEX_VERSION;
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public Rect Code(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public boolean V() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    public static cz Code(Context context) {
        return V(context);
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public void Code(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public boolean Code() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public boolean Code(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable unused) {
            fh.I(Code, "isFreedomWindowMode error");
            return false;
        }
    }
}
