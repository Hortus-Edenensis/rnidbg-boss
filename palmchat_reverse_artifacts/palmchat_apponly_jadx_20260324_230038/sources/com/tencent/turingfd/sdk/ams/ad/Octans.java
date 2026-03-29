package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.turingfd.sdk.ams.ad.Cstrictfp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Octans {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Date<String> f10728a = new Date<>();

    public static String a() {
        for (Cthrows cthrows : (ArrayList) Chamaeleon.a()) {
            if (cthrows.f10778a.contains(Foxnut.c)) {
                return cthrows.b;
            }
        }
        return "";
    }

    public static int b(Context context) {
        Intent intentRegisterReceiver = null;
        try {
            intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (intentRegisterReceiver == null) {
            return 0;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        if (!(intExtra == 2 || intExtra == 5)) {
            return 1;
        }
        int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
        if (intExtra2 == 2) {
            return 3;
        }
        return intExtra2 == 1 ? 2 : 0;
    }

    public static String c(Context context) {
        String string;
        Date<String> date;
        Date<String> date2 = f10728a;
        synchronized (date2) {
            String strA = date2.a();
            if (strA != null) {
                return strA;
            }
            StringBuilder sb = new StringBuilder();
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                sb.append(telephonyManager.getSimState());
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    int phoneCount = telephonyManager.getPhoneCount();
                    sb.append(",");
                    sb.append(phoneCount);
                    if (phoneCount > 1 && i >= 26) {
                        sb.append(",");
                        for (int i2 = 0; i2 < phoneCount; i2++) {
                            if (i2 > 0) {
                                sb.append(x.aQ);
                            }
                            sb.append(telephonyManager.getSimState(i2));
                        }
                    }
                }
                string = sb.toString();
                date = f10728a;
            } catch (Throwable unused) {
                string = sb.toString();
                date = f10728a;
            }
            date.a(string, 0L);
            return string;
        }
    }

    public static int d(Context context) {
        BufferedReader bufferedReader;
        String line;
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            return 0;
        }
        File file = new File(Cfinally.a(Cfinally.n0));
        HashMap<String, Cstrictfp.Cdo> map = Cstrictfp.f10772a;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                line = bufferedReader.readLine();
                Cstrictfp.a(bufferedReader);
            } catch (Throwable unused) {
                if (bufferedReader != null) {
                    Cstrictfp.a(bufferedReader);
                }
                line = "";
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        if (TextUtils.isEmpty(line)) {
            return 0;
        }
        if ("CONFIGURED".equals(line)) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                    z = true;
                }
            } catch (Throwable unused3) {
            }
            return z ? 1 : 3;
        }
        if ("DISCONNECTED".equals(line)) {
            return 2;
        }
        return "CONNECTED".equals(line) ? 3 : 0;
    }

    public static boolean e(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static String f(Context context) {
        Map<String, Set<String>> map = Avocado.f10658a;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            String strA = UrsaMinor.a(context, packageName);
            Cthrows cthrows = new Cthrows();
            cthrows.f10778a = Foxnut.f10696a + Foxnut.b;
            cthrows.b = packageName + "_" + strA;
            arrayList.add(cthrows);
        }
        return arrayList.size() != 0 ? ((Cthrows) arrayList.get(0)).b : "";
    }

    public static int a(Context context) {
        boolean z = false;
        int iA = Cthis.a(Cthis.a(0, e(context), 0), Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return Cthis.a(Cthis.a(iA, z, 2), Debug.isDebuggerConnected(), 3);
    }

    public static String b() {
        for (Cthrows cthrows : (ArrayList) Chamaeleon.a()) {
            if (cthrows.f10778a.contains(Foxnut.d)) {
                return cthrows.b;
            }
        }
        return "";
    }

    public static String c() {
        Context context;
        StringBuilder sb = new StringBuilder();
        try {
            synchronized (Ccase.class) {
                context = Ccase.f10751a;
            }
            Hydra hydraA = Lynx.a(context);
            for (int i = 0; i < hydraA.f10709a.a(); i++) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                Locale localeA = hydraA.f10709a.a(i);
                if (localeA != null) {
                    sb.append(localeA.getLanguage());
                    sb.append("-");
                    sb.append(localeA.getCountry());
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
