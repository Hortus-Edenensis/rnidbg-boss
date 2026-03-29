package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.zenmen.media.roomchat.RTCParameters;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c54 extends kr {
    public static final String c = "c54";

    public c54() {
        this.f18812a.add("com.coloros.safecenter/.startupapp.StartupAppListActivity");
        this.f18812a.add("com.coloros.safecenter/.permission.startup.StartupAppListActivity");
        this.f18812a.add("com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity");
        this.b.add("com.coloros.safecenter/.sysfloatwindow.FloatWindowListActivity");
        this.b.add("com.coloros.safecenter/.permission.floatwindow.FloatWindowListActivity");
        this.b.add("com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity");
    }

    public static c54 b() {
        if (cc1.c().equals("5.1") || cc1.c().equals("5.1.1") || cc1.c().equals("6.0.1") || cc1.c().equals("7.1.1") || cc1.c().equals("8.1.0")) {
            return new c54();
        }
        Log.i(c, "no supported version: " + cc1.c());
        return null;
    }

    @Override // defpackage.kr
    public boolean a() {
        if (cc1.c().equals("8.1.0")) {
            d();
            return true;
        }
        if (this.b == null) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (c(this.b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str) {
        if (str == null) {
            return false;
        }
        try {
            Log.i(c, "openPermissionActivity: " + str);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", RTCParameters.c().getPackageName());
            intent.setComponent(ComponentName.unflattenFromString(str));
            RTCParameters.c().startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", RTCParameters.c().getPackageName(), null));
        RTCParameters.c().startActivity(intent);
    }
}
