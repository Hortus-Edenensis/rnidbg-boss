package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.zenmen.palmchat.AppContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b54 extends jr {
    public static final String c = "b54";

    public b54() {
        this.f18483a.add("com.coloros.safecenter/.startupapp.StartupAppListActivity");
        this.f18483a.add("com.coloros.safecenter/.permission.startup.StartupAppListActivity");
        this.f18483a.add("com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity");
        this.b.add("com.coloros.safecenter/.sysfloatwindow.FloatWindowListActivity");
        this.b.add("com.coloros.safecenter/.permission.floatwindow.FloatWindowListActivity");
        this.b.add("com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity");
    }

    public static b54 e() {
        if (bc1.d().equals("5.1") || bc1.d().equals("5.1.1") || bc1.d().equals("6.0.1") || bc1.d().equals("7.1.1") || bc1.d().equals("8.1.0")) {
            return new b54();
        }
        Log.i(c, "no supported version: " + bc1.d());
        return null;
    }

    @Override // defpackage.jr
    public boolean b() {
        if (bc1.d().equals("8.1.0")) {
            g();
            return true;
        }
        if (this.f18483a == null) {
            return false;
        }
        for (int i = 0; i < this.f18483a.size(); i++) {
            if (f(this.f18483a.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.jr
    public boolean c() {
        if (bc1.d().equals("8.1.0")) {
            g();
            return true;
        }
        if (this.b == null) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (f(this.b.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.jr
    public /* bridge */ /* synthetic */ void d(String str) {
        super.d(str);
    }

    public boolean f(String str) {
        if (str == null) {
            return false;
        }
        try {
            Log.i(c, "openPermissionActivity: " + str);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", "com.zenmen.palmchat");
            intent.setComponent(ComponentName.unflattenFromString(str));
            AppContext.getContext().startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void g() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", AppContext.getContext().getPackageName(), null));
        AppContext.getContext().startActivity(intent);
    }
}
