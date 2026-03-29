package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class af {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    public static int a(Context context, float f) {
        if (context == null) {
            com.opos.cmn.an.f.a.a("Utils", "compareToScreenRatio but null context");
            return -1;
        }
        float fC = com.opos.cmn.an.h.f.a.c(context) / com.opos.cmn.an.h.f.a.b(context);
        com.opos.cmn.an.f.a.b("Utils", "ratio = " + fC + ", targetRatio =" + f);
        if (f > fC) {
            return 1;
        }
        return fC == f ? 0 : -1;
    }

    public static boolean b(Context context) {
        return context != null && Build.VERSION.SDK_INT >= 24 && context.getResources().getConfiguration().densityDpi > DisplayMetrics.DENSITY_DEVICE_STABLE;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        byte b;
        String strH = com.opos.cmn.an.h.c.a.h(context);
        int iHashCode = strH.hashCode();
        if (iHashCode != -1068855134) {
            if (iHashCode != 1653) {
                if (iHashCode != 1684) {
                    if (iHashCode != 1715) {
                        if (iHashCode != 1746) {
                            if (iHashCode != 3387192) {
                                b = (iHashCode == 3649301 && strH.equals("wifi")) ? (byte) 3 : (byte) -1;
                            } else if (strH.equals("none")) {
                                b = 6;
                            }
                        } else if (strH.equals(NetworkUtil.NETWORK_CLASS_5G)) {
                            b = 2;
                        }
                    } else if (strH.equals("4g")) {
                        b = 5;
                    }
                } else if (strH.equals("3g")) {
                    b = 1;
                }
            } else if (strH.equals("2g")) {
                b = 0;
            }
        } else if (strH.equals("mobile")) {
            b = 4;
        }
        return b != 0 ? b != 1 ? b != 2 ? b != 3 ? "4G" : "WLAN" : "5G" : "3G" : "2G";
    }

    public static void a(final com.opos.mobad.d.d.a aVar, final String str, final a aVar2) {
        if (aVar2 == null) {
            return;
        }
        if (aVar == null) {
            aVar2.a();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            aVar2.a();
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.template.cmn.af.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapB = aVar.b(str);
                if (bitmapB == null) {
                    aVar2.a();
                } else {
                    aVar2.a(bitmapB);
                }
            }
        });
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }
}
