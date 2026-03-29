package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.wifi.adsdk.utils.LxAdOppoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class j94 extends q0 {
    public static final int b = sb1.e(LxAdOppoDevice.PROP_VERSION, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    public static final String c = Build.MANUFACTURER.toLowerCase();

    public j94(Context context) {
        super(context);
    }

    public static boolean d() {
        int i = b;
        return (i == -1 || i == 0 || !c.equals("oppo")) ? false : true;
    }

    public final Intent b() {
        Intent intent = new Intent();
        intent.setClassName("com.oppo.purebackground", "com.oppo.purebackground.Purebackground_AddTrust_Activity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.purebackground.PureBackgroundSettingActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.purebackground", "com.oppo.purebackground.PurebackgroundTopActivity");
        if (a(intent)) {
            return intent;
        }
        return null;
    }

    public final Intent c() {
        Intent intent = new Intent();
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionSettingsActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (a(intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (a(intent)) {
            return intent;
        }
        return null;
    }

    @Override // defpackage.ol2
    public int getDeviceType() {
        return 3;
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
