package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.e.a.b;
import com.kwad.sdk.core.e.a.d;
import com.kwad.sdk.core.e.a.e;
import com.kwad.sdk.core.e.a.f;
import com.kwad.sdk.core.e.a.g;
import com.kwad.sdk.core.e.a.j;
import com.kwad.sdk.core.e.a.k;
import com.kwad.sdk.core.e.a.l;
import com.kwad.sdk.core.e.a.m;
import com.kwad.sdk.core.e.a.n;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import com.umeng.analytics.pro.dn;
import com.wifi.adsdk.utils.LxAdOSUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public static String JY() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String strH = ag.h("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = strH;
        return strH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eH(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ag.g("ksadsdk_pref", "kasd_oaid_key", str);
    }

    public static String getAppOAID(Context context) {
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            return bc.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (!bc.useOaidDisable() && s.RJ()) {
            initAsync(context);
            return sOAID;
        }
        String strJY = JY();
        sOAID = strJY;
        return strJY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void getOAIDNormal(Context context) {
        byte b;
        if (!TextUtils.isEmpty(sOAID) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase.hashCode()) {
                case -2053026509:
                    b = !upperCase.equals("LENOVO") ? (byte) -1 : (byte) 7;
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        b = 11;
                        break;
                    }
                    break;
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        b = 2;
                        break;
                    }
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        b = 3;
                        break;
                    }
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        b = 5;
                        break;
                    }
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        b = dn.k;
                        break;
                    }
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        b = 12;
                        break;
                    }
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        b = 4;
                        break;
                    }
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        b = 15;
                        break;
                    }
                    break;
                case 2634924:
                    if (upperCase.equals(LxAdOSUtils.ROM_VIVO)) {
                        b = 6;
                        break;
                    }
                    break;
                case 68924490:
                    if (upperCase.equals("HONOR")) {
                        b = 1;
                        break;
                    }
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        b = 9;
                        break;
                    }
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        b = 10;
                        break;
                    }
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        b = 8;
                        break;
                    }
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        b = dn.l;
                        break;
                    }
                    break;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        b = 0;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (b) {
                case 0:
                    sOAID = new d(applicationContext).getOAID();
                    break;
                case 1:
                    sOAID = new b(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    sOAID = new m(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    sOAID = new j(applicationContext).getOAID();
                    break;
                case 6:
                    sOAID = new l(applicationContext).getOAID();
                    break;
                case 7:
                case 8:
                    sOAID = new e(applicationContext).getOAID();
                    break;
                case 9:
                    sOAID = new f(applicationContext).getOAID();
                    break;
                case 10:
                    sOAID = new g(applicationContext).getOAID();
                    break;
                case 11:
                    sOAID = new k(applicationContext).getOAID();
                    break;
                case 12:
                    sOAID = new com.kwad.sdk.core.e.a.a(applicationContext).getOAID();
                    break;
                case 13:
                case 14:
                case 15:
                    sOAID = new n(applicationContext).getOAID();
                    break;
            }
            c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
            eH(sOAID);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String unused = a.sOAID = a.JY();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eH(str);
                                a.FF();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eH(str);
                                a.FF();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }

    public static /* synthetic */ void FF() {
    }
}
