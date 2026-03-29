package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.wifi.adsdk.utils.LxAdMiuiDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vp3 extends q0 {
    public static final int b;

    static {
        int i;
        try {
            i = Integer.parseInt(sb1.c(LxAdMiuiDevice.PROP_VERSION).trim());
        } catch (NumberFormatException unused) {
            i = -1;
        }
        b = i;
    }

    public vp3(Context context) {
        super(context);
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        return "xiaomi".equalsIgnoreCase(str) || "redmi".equalsIgnoreCase(str);
    }

    public static boolean f() {
        int i = b;
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7;
    }

    public static boolean g() {
        return sb1.c("ro.build.version.incremental").substring(1, 8).equals(LxAdMiuiDevice.XIAOMI_MIX_3_VERSION);
    }

    public final Intent b() {
        Intent intent = new Intent();
        intent.setClassName("com.miui.powerkeeper", "com.miui.poweroptimize.hidemode.PowerHideModeActivity");
        if (a(intent)) {
            return intent;
        }
        return null;
    }

    public final Intent c() {
        PackageInfo packageInfo;
        Intent intent = new Intent();
        if (b >= 4) {
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", this.f20145a.getPackageName());
            return intent;
        }
        intent.setClassName("com.android.settings", "com.miui.securitycenter.permission.AppPermissionsEditor");
        try {
            packageInfo = this.f20145a.getPackageManager().getPackageInfo(this.f20145a.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        intent.putExtra("extra_package_uid", packageInfo.applicationInfo.uid);
        return intent;
    }

    public final boolean d() {
        return Float.parseFloat(sb1.c("ro.build.version.incremental").substring(1, 4)) >= 6.7f;
    }

    @Override // defpackage.ol2
    public int getDeviceType() {
        return 1;
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
        int i = b;
        if (i > 4) {
            return true;
        }
        if (i == 4) {
            return d();
        }
        return false;
    }
}
