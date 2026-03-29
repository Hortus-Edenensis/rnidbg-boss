package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.wifi.adsdk.utils.LxAdEmuiDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dm1 extends q0 {
    public static final int b = sb1.e(LxAdEmuiDevice.PROP_VERSION, "EmotionUI");

    public dm1(Context context) {
        super(context);
    }

    public static boolean d() {
        if (b < 150) {
            String str = Build.MANUFACTURER;
            if (!"huawei".equalsIgnoreCase(str) && !"honor".equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    public final Intent b() {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity");
        if (a(intent)) {
            return intent;
        }
        if (Build.VERSION.SDK_INT > 23) {
            intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
            if (a(intent)) {
                return intent;
            }
            intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
            if (a(intent)) {
                return intent;
            }
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.android.hwpowermanager", "com.huawei.android.hwpowermanager.BootApplicationActivity");
        if (a(intent)) {
            return intent;
        }
        return null;
    }

    public final Intent c() {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (a(intent)) {
            return intent;
        }
        return null;
    }

    @Override // defpackage.ol2
    public int getDeviceType() {
        return 2;
    }

    @Override // defpackage.ol2
    public Intent getPermissionActivity(int i) {
        Intent intentC = i != 3 ? i != 6 ? null : c() : b();
        if (intentC == null || !a(intentC)) {
            return null;
        }
        return intentC;
    }

    @Override // defpackage.ol2
    public int getVersion() {
        return b;
    }

    @Override // defpackage.ol2
    public boolean hasBackGround() {
        return true;
    }
}
