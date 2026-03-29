package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ru {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20573a;
    public String b;
    public String c;
    public Drawable d;
    public boolean e;

    public static List<ru> c(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.baidu.com"));
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        if (listQueryIntentActivities == null) {
            return arrayList;
        }
        ApplicationInfo applicationInfo = null;
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                ru ruVar = new ru();
                ruVar.j(resolveInfo.activityInfo.packageName);
                try {
                    applicationInfo = packageManager.getApplicationInfo(resolveInfo.activityInfo.packageName, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                ruVar.i(resolveInfo.activityInfo.name);
                ruVar.h(packageManager.getApplicationLabel(applicationInfo).toString());
                ruVar.g(packageManager.getApplicationIcon(applicationInfo));
                arrayList.add(ruVar);
            }
        }
        return arrayList;
    }

    public Drawable a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.f20573a;
    }

    public boolean f() {
        return this.e;
    }

    public void g(Drawable drawable) {
        this.d = drawable;
    }

    public void h(String str) {
        this.b = str;
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(String str) {
        this.f20573a = str;
    }

    public void k(boolean z) {
        this.e = z;
    }
}
