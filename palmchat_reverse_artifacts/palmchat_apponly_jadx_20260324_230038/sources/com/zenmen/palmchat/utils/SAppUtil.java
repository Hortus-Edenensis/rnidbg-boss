package com.zenmen.palmchat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.ss.android.ttvecamera.BuildConfig;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import defpackage.az2;
import defpackage.nl0;
import defpackage.q05;
import defpackage.rl0;
import defpackage.t66;
import defpackage.tj6;
import defpackage.ve;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SAppUtil extends q05 {

    /* JADX INFO: compiled from: SearchBox */
    public static class CustomClassicsFooter extends ClassicsFooter {
        public CustomClassicsFooter(Context context) {
            super(context);
        }

        @Override // com.scwang.smartrefresh.layout.footer.ClassicsFooter, com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.tu4
        public boolean setNoMoreData(boolean z) {
            if (z) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            return super.setNoMoreData(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a {
        public static String a() {
            return t66.h().e("LX-66831", "A");
        }

        public static boolean b() {
            return !"A".contains(a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {
        public static String a() {
            return t66.h().e("LX-69352", "A");
        }

        public static boolean b() {
            return !"A".contains(a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {
        public static SetpageNotificationConfig a() {
            SetpageNotificationConfig setpageNotificationConfig;
            try {
                setpageNotificationConfig = (SetpageNotificationConfig) az2.a(q05.f("setpage_notification").toString(), SetpageNotificationConfig.class);
            } catch (Exception e) {
                e.printStackTrace();
                setpageNotificationConfig = null;
            }
            return setpageNotificationConfig == null ? new SetpageNotificationConfig() : setpageNotificationConfig;
        }

        public static String b() {
            return t66.h().e("LX-70561", "A");
        }

        public static boolean c() {
            SetpageNotificationConfig setpageNotificationConfigA = a();
            if (BuildConfig.USE_CLOUD_CONFIG.equalsIgnoreCase(setpageNotificationConfigA.getSwitch()) && setpageNotificationConfigA.getManufacturer() != null && setpageNotificationConfigA.getManufacturer().size() != 0) {
                String str = Build.MANUFACTURER;
                for (String str2 : setpageNotificationConfigA.getManufacturer()) {
                    if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean d() {
            return !"A".contains(b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d {
        public static String a() {
            return t66.h().e("LX-70687", "A");
        }

        public static boolean b() {
            return !"A".contains(a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {
        public static String a() {
            return t66.h().e("LX-73561", "A");
        }

        public static boolean b() {
            return !"A".contains(a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f {
        public static String a() {
            return t66.h().e("LX-57667", "A");
        }

        public static boolean b() {
            return !"A".contains(a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g {
        public static String a() {
            return t66.h().e("LX-65161", "A");
        }

        public static boolean b() {
            return !"A".contains(a());
        }
    }

    public static String F(String str) {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(str);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return null;
        }
        return dynamicConfig.getExtra();
    }

    public static String G() {
        return nl0.q + "/energy/";
    }

    public static void H(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("extra_key_full_window", z);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void I(Context context, String str, boolean z, boolean z2) {
        context.startActivity(tj6.a(context, str, z, z2));
    }

    public static void J(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("extra_key_full_window", z);
        bundle.putBoolean("web_show_right_menu", false);
        intent.putExtra("needCheckAccount", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void K(Activity activity, String str) {
        ve.o(activity, str, false);
    }

    public static void L(Context context) {
    }
}
