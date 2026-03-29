package com.opos.cmn.an.h.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import com.opos.cmn.an.d.b;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PackageManager f7791a;
    private static final String b = "com." + com.opos.cmn.an.b.a.c + ".feature.screen.heteromorphism";

    public static PackageManager a(Context context) {
        if (f7791a == null && context != null) {
            f7791a = context.getApplicationContext().getPackageManager();
        }
        return f7791a;
    }

    public static int b(Context context, String str) {
        int i = -1;
        try {
            PackageManager packageManagerA = a(context);
            if (packageManagerA != null && !b.a(str)) {
                try {
                    i = packageManagerA.getPackageInfo(str, 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    com.opos.cmn.an.f.a.c("PkgMgrTool", "getAppVerCode", e);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
        }
        return i;
    }

    public static String c(Context context, String str) {
        String str2;
        PackageManager packageManagerA;
        try {
            packageManagerA = a(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
        }
        if (packageManagerA == null || b.a(str)) {
            str2 = "";
        } else {
            try {
                str2 = packageManagerA.getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", "getAppVerCode", e2);
                str2 = "";
            }
        }
        return str2 != null ? str2 : "";
    }

    public static boolean d(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (b.a(str)) {
                return false;
            }
            PackageManager packageManagerA = a(context);
            if (packageManagerA == null) {
                return false;
            }
            try {
                return packageManagerA.getApplicationInfo(str, 128) != null;
            } catch (Exception unused) {
                return false;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return false;
        }
    }

    public static Drawable e(Context context, String str) throws PackageManager.NameNotFoundException {
        Drawable applicationIcon = null;
        try {
            PackageManager packageManagerA = a(context);
            if (packageManagerA != null && !b.a(str)) {
                try {
                    applicationIcon = packageManagerA.getApplicationIcon(str);
                } catch (PackageManager.NameNotFoundException e) {
                    com.opos.cmn.an.f.a.c("PkgMgrTool", "getAppVerCode", e);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
        }
        return applicationIcon;
    }

    public static String f(Context context, String str) {
        PackageManager packageManagerA;
        String string = "";
        if (context != null) {
            try {
                if (!b.a(str) && (packageManagerA = a(context)) != null) {
                    try {
                        ApplicationInfo applicationInfo = packageManagerA.getApplicationInfo(str, 128);
                        if (applicationInfo != null) {
                            string = applicationInfo.loadLabel(packageManagerA).toString();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", string, e2);
            }
        }
        return string;
    }

    public static ApplicationInfo g(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            if (b.a(str)) {
                return null;
            }
            PackageManager packageManagerA = a(context);
            if (packageManagerA == null) {
                return null;
            }
            try {
                return packageManagerA.getApplicationInfo(str, 128);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return null;
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            return a(context).resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
            return false;
        }
    }

    @Deprecated
    public static List<String> b(Context context) {
        return null;
    }

    public static boolean a(Context context, View view) {
        WindowInsets rootWindowInsets;
        boolean zHasSystemFeature = false;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (view != null && (rootWindowInsets = view.getRootWindowInsets()) != null && rootWindowInsets.getDisplayCutout() != null) {
                    zHasSystemFeature = true;
                }
            } else if (context != null) {
                zHasSystemFeature = a(context).hasSystemFeature(b);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
        }
        return zHasSystemFeature;
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (b.a(str)) {
                    return false;
                }
                return context.checkCallingOrSelfPermission(str) == 0;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
                return false;
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, com.opos.cmn.an.d.a aVar) {
        PackageManager packageManagerA;
        Bundle bundleB;
        if (context == null) {
            return false;
        }
        try {
            if (b.a(str) || (packageManagerA = a(context)) == null) {
                return false;
            }
            try {
                Intent launchIntentForPackage = packageManagerA.getLaunchIntentForPackage(str);
                if (launchIntentForPackage == null) {
                    return false;
                }
                launchIntentForPackage.addFlags(268435456);
                if (aVar != null) {
                    Bundle bundleB2 = com.opos.cmn.an.d.a.b(aVar.a());
                    com.opos.cmn.an.f.a.a("PkgMgrTool", "launchAppHomePage intentBundle:", bundleB2);
                    if (bundleB2 != null) {
                        launchIntentForPackage.putExtras(bundleB2);
                    }
                }
                if (aVar != null) {
                    bundleB = com.opos.cmn.an.d.a.b(aVar.b());
                    com.opos.cmn.an.f.a.a("PkgMgrTool", "launchAppHomePage optionsBundle:", bundleB);
                } else {
                    bundleB = null;
                }
                if (bundleB != null) {
                    context.startActivity(launchIntentForPackage, bundleB);
                } else {
                    context.startActivity(launchIntentForPackage);
                }
                return true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", "", e);
                return false;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
            return false;
        }
    }
}
