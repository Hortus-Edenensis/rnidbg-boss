package defpackage;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.igexin.sdk.PushConsts;
import com.kuaishou.weapon.p0.g;
import com.oplus.tblplayer.misc.MediaInfo;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wm4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21751a;
    public String b;
    public String c;
    public String d;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Integer k;
    public Boolean l;
    public String m;
    public String n;
    public PackageInfo o;
    public ArrayList<String> p;
    public String q;
    public String e = "unknown";
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public long u = 0;
    public long v = 0;
    public BroadcastReceiver w = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfo;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.equals(action, "android.intent.action.SIM_STATE_CHANGED")) {
                if (wm4.this.u == 0 || System.currentTimeMillis() - wm4.this.u < 5000) {
                    wm4.this.u = System.currentTimeMillis();
                    return;
                } else {
                    wm4.this.r = true;
                    return;
                }
            }
            if (TextUtils.equals(action, PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null && networkInfo.isConnected()) {
                if (wm4.this.v == 0 || System.currentTimeMillis() - wm4.this.v < 5000) {
                    wm4.this.v = System.currentTimeMillis();
                } else {
                    wm4.this.s = true;
                }
            }
        }
    }

    public wm4(Context context) {
        this.f21751a = context;
        G();
    }

    public static String I(String str) {
        int length;
        if (TextUtils.isEmpty(str) || (length = str.length()) <= 1 || str.charAt(0) != '\"') {
            return str;
        }
        int i = length - 1;
        return str.charAt(i) == '\"' ? str.substring(1, i) : str;
    }

    public static String g(String str) {
        String strI = I(str);
        return z(strI) ? "" : strI.replaceAll("\u0000|\u0001|\u0002|\u0003|\u0004|\u0005|\u0006|\u0007", "*");
    }

    public static TelephonyManager x(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static boolean z(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("0x") || str.startsWith("0X") || str.equalsIgnoreCase("<unknown ssid>") || str.equalsIgnoreCase(b.m);
    }

    public final boolean A() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f21751a.getSystemService("connectivity");
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean B() {
        if (this.t) {
            E();
        }
        Boolean bool = this.l;
        if (bool != null) {
            return bool.booleanValue();
        }
        this.l = Boolean.FALSE;
        try {
            WifiManager wifiManager = (WifiManager) this.f21751a.getSystemService("wifi");
            if (wifiManager != null) {
                this.l = Boolean.valueOf(wifiManager.isWifiEnabled());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.l.booleanValue();
    }

    public void C() {
        this.t = true;
    }

    public final void D() {
        if (this.s) {
            this.s = false;
            try {
                WifiInfo connectionInfo = ((WifiManager) this.f21751a.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f = g(connectionInfo.getSSID());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f == null) {
                this.f = "";
            }
        }
    }

    public final void E() {
        if (this.t) {
            this.t = false;
            this.l = Boolean.FALSE;
            try {
                WifiManager wifiManager = (WifiManager) this.f21751a.getSystemService("wifi");
                if (wifiManager != null) {
                    this.l = Boolean.valueOf(wifiManager.isWifiEnabled());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void F() {
        if (this.r) {
            this.r = false;
            if (y(g.c)) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) this.f21751a.getSystemService("phone");
                    if (telephonyManager != null) {
                        this.i = telephonyManager.getSubscriberId();
                        this.j = telephonyManager.getSimSerialNumber();
                        this.k = Integer.valueOf(telephonyManager.getSimState());
                        this.b = telephonyManager.getNetworkOperator();
                        this.c = telephonyManager.getNetworkOperatorName();
                        this.d = (String) wy3.e(telephonyManager, "getNetworkOperator", Integer.valueOf(((Integer) wy3.e(wy3.e(wy3.f("android.telephony.SubscriptionManager", "from", this.f21751a), "getDefaultDataSubscriptionInfo", new Object[0]), "getSubscriptionId", new Object[0])).intValue()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.i == null) {
                    this.i = "";
                }
                if (this.j == null) {
                    this.j = "";
                }
                Integer num = this.k;
                if (num == null || num.intValue() == -1) {
                    this.k = 0;
                }
                if (this.b == null) {
                    this.b = "";
                }
                if (this.c == null) {
                    this.c = "";
                }
                if (this.d == null) {
                    this.d = "";
                }
            }
        }
    }

    public final void G() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        this.f21751a.registerReceiver(this.w, intentFilter);
    }

    public void H() {
        J();
    }

    public final void J() {
        try {
            this.f21751a.unregisterReceiver(this.w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String h() {
        String string;
        if (TextUtils.isEmpty(this.n)) {
            try {
                string = Settings.Secure.getString(this.f21751a.getContentResolver(), "android_id");
            } catch (Exception e) {
                e.printStackTrace();
                string = null;
            }
            if (TextUtils.isEmpty(string)) {
                string = MediaInfo.RENDERER_TYPE_UNKNOWN;
            }
            this.n = string;
        }
        return this.n;
    }

    public String i() {
        return this.e;
    }

    public String j() {
        F();
        if (!y(g.c)) {
            String str = this.d;
            return str == null ? "" : str;
        }
        String str2 = this.d;
        if (str2 != null) {
            return str2;
        }
        TelephonyManager telephonyManagerX = x(this.f21751a);
        if (telephonyManagerX != null) {
            try {
                this.d = (String) wy3.e(telephonyManagerX, "getNetworkOperator", Integer.valueOf(((Integer) wy3.e(wy3.e(wy3.f("android.telephony.SubscriptionManager", "from", this.f21751a), "getDefaultDataSubscriptionInfo", new Object[0]), "getSubscriptionId", new Object[0])).intValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.d == null) {
            this.d = o();
        }
        return this.d;
    }

    public String k() {
        if (!y(g.c)) {
            String str = this.h;
            return str == null ? "" : str;
        }
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f21751a.getSystemService("phone");
            if (telephonyManager != null) {
                this.h = telephonyManager.getDeviceId();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if (this.h == null) {
            this.h = "";
        }
        return this.h;
    }

    public String l() {
        if (this.r) {
            F();
        }
        if (!y(g.c)) {
            String str = this.i;
            return str == null ? "" : str;
        }
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f21751a.getSystemService("phone");
            if (telephonyManager != null) {
                this.i = telephonyManager.getSubscriberId();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if (this.i == null) {
            this.i = "";
        }
        return this.i;
    }

    public ArrayList<String> m(Context context) {
        if (!y("android.permission.QUERY_ALL_PACKAGES")) {
            return this.p;
        }
        ArrayList<String> arrayList = this.p;
        if (arrayList != null && !arrayList.isEmpty()) {
            return this.p;
        }
        this.p = new ArrayList<>();
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(128)) {
                int i = packageInfo.applicationInfo.flags;
                if ((i & 128) != 0 || (i & 1) == 0) {
                    this.p.add(packageInfo.packageName);
                }
            }
            return this.p;
        } catch (Exception unused) {
            return this.p;
        }
    }

    @SuppressLint({"MissingPermission"})
    public String n() {
        if (!y(g.d)) {
            String str = this.m;
            return str == null ? "" : str;
        }
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) this.f21751a.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.m = connectionInfo.getMacAddress();
            }
        } catch (Exception unused) {
        }
        if (this.m == null) {
            this.m = "";
        }
        return this.m;
    }

    public String o() {
        F();
        if (!y(g.c)) {
            String str = this.b;
            return str == null ? "" : str;
        }
        String str2 = this.b;
        if (str2 != null) {
            return str2;
        }
        try {
            this.b = x(this.f21751a).getNetworkOperator();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.b == null) {
            this.b = "";
        }
        return this.b;
    }

    public String p() {
        F();
        if (!y(g.c)) {
            String str = this.c;
            return str == null ? "" : str;
        }
        String str2 = this.c;
        if (str2 != null) {
            return str2;
        }
        try {
            this.c = x(this.f21751a).getNetworkOperatorName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.c == null) {
            this.c = "";
        }
        return this.c;
    }

    public String q() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f21751a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 0) {
                this.g = "g";
            } else if (activeNetworkInfo.getType() == 1) {
                this.g = RXScreenCaptureService.KEY_WIDTH;
            }
        }
        if (this.g == null) {
            this.g = "";
        }
        return this.g;
    }

    public String r(Context context) {
        if (this.q == null) {
            String strA = wy3.a(context);
            this.q = strA;
            if (strA == null) {
                this.q = "";
            }
        }
        return this.q;
    }

    public String s() {
        String strQ = q();
        return (!TextUtils.isEmpty(strQ) && RXScreenCaptureService.KEY_WIDTH.equals(strQ) && A()) ? "wg" : strQ;
    }

    public PackageInfo t() {
        PackageInfo packageInfo = this.o;
        if (packageInfo != null) {
            return packageInfo;
        }
        try {
            this.o = this.f21751a.getPackageManager().getPackageInfo(this.f21751a.getPackageName(), 0);
        } catch (Exception unused) {
        }
        return this.o;
    }

    public String u() {
        if (this.r) {
            F();
        }
        if (!y(g.c)) {
            String str = this.j;
            return str == null ? "" : str;
        }
        if (!TextUtils.isEmpty(this.j)) {
            return this.j;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f21751a.getSystemService("phone");
            if (telephonyManager != null) {
                this.j = telephonyManager.getSimSerialNumber();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if (this.j == null) {
            this.j = "";
        }
        return this.j;
    }

    public int v() {
        if (this.r) {
            F();
        }
        if (!y(g.c)) {
            return 0;
        }
        if (this.k.intValue() != -1) {
            return this.k.intValue();
        }
        this.k = 0;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f21751a.getSystemService("phone");
            if (telephonyManager != null) {
                this.k = Integer.valueOf(telephonyManager.getSimState());
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return this.k.intValue();
    }

    public String w() {
        D();
        if (!TextUtils.equals(RXScreenCaptureService.KEY_WIDTH, q())) {
            return "";
        }
        String str = this.f;
        if (str != null) {
            return str;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) this.f21751a.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.f = g(connectionInfo.getSSID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f == null) {
            this.f = "";
        }
        return this.f;
    }

    public final boolean y(String str) {
        return Build.VERSION.SDK_INT < 23 || this.f21751a.checkSelfPermission(str) == 0;
    }
}
