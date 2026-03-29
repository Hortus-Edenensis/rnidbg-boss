package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.hihonor.android.app.ActivityManagerEx;
import com.hihonor.android.app.HwMultiWindowEx;
import com.hihonor.android.content.pm.ApplicationInfoEx;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.hihonor.android.view.DisplaySideRegionEx;
import com.hihonor.android.view.WindowManagerEx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cu extends cr {
    private static final String Code = "HnSysApiImpl";
    private static final byte[] I = new byte[0];
    private static cz V;

    private cu(Context context) {
    }

    private static cz V(Context context) {
        cz czVar;
        synchronized (I) {
            if (V == null) {
                V = new cu(context);
            }
            czVar = V;
        }
        return czVar;
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String B() {
        return "com.hihonor.android.os.Build";
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String C() {
        return "com.hihonor.android.os.SystemPropertiesEx";
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public int Code(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String I() {
        return "com.hihonor.android.net.wifi.WifiManagerCommonEx";
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public int S() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.cz
    public String Z() {
        return "com.hihonor.android.os.Build$VERSION";
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
