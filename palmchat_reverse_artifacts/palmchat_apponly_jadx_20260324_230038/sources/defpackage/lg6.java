package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.wifi.adsdk.utils.LxAdVivoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lg6 extends q0 {
    public static final int b = sb1.e(LxAdVivoDevice.PROP_VERSION, "Funtouch OS");

    public lg6(Context context) {
        super(context);
    }

    public static boolean c() {
        return Build.MANUFACTURER.equalsIgnoreCase("vivo") || Build.MODEL.contains("vivo");
    }

    @Override // defpackage.q0
    public boolean a(Intent intent) {
        return super.a(intent);
    }

    public final Intent b() {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.PurviewTabActivity");
        if (a(intent)) {
            return intent;
        }
        return null;
    }

    @Override // defpackage.ol2
    public int getDeviceType() {
        return 4;
    }

    @Override // defpackage.ol2
    public Intent getPermissionActivity(int i) {
        Intent intentB = i != 6 ? null : b();
        if (intentB == null || !a(intentB)) {
            return null;
        }
        return intentB;
    }

    @Override // defpackage.ol2
    public int getVersion() {
        return b;
    }

    @Override // defpackage.ol2
    public boolean hasBackGround() {
        return false;
    }
}
