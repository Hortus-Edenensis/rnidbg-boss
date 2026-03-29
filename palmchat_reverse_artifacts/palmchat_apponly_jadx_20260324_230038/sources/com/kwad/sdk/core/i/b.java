package com.kwad.sdk.core.i;

import android.app.ActivityManager;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.LocaleList;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import com.zm.fda.Z200O.ZZ00Z;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements c {
    private static Locale aOU;
    private String aJW;
    private boolean aOS = true;
    private Map<String, String> aOT = new LinkedHashMap();

    private StringBuilder LL() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.aOT.entrySet()) {
            sb.append(" ");
            sb.append(entry.getKey());
            sb.append("/");
            sb.append(entry.getValue());
        }
        return sb;
    }

    private static String LM() {
        if (Build.VERSION.SDK_INT >= 24) {
            aOU = LocaleList.getDefault().get(0);
        } else {
            aOU = Locale.getDefault();
        }
        if (aOU == null) {
            aOU = Locale.CHINESE;
        }
        return aOU.getLanguage();
    }

    private static long aH(long j) {
        if (j > 524288000) {
            return 524288000L;
        }
        return j;
    }

    private static long aI(long j) {
        long j2 = j / ZZ00Z.y;
        if (j2 == 0) {
            return 524288000L;
        }
        return (j2 == 1 ? j / 2 : j / 3) * 1024;
    }

    private void bT(Context context) {
        this.aOT.put("Yoda", "3.2.11-rc1");
        this.aOT.put("Kwai", "11.8.10");
        this.aOT.put("OS_PRO_BIT", String.valueOf(AbiUtil.isArm64(context) ? 1 : 0));
        this.aOT.put("MAX_PHY_MEM", String.valueOf(br.ee(context) >> 20));
        this.aOT.put("KDT", "PHONE");
        this.aOT.put("AZPREFIX", "az4");
        this.aOT.put("ICFO", "0");
        this.aOT.put("StatusHT", String.valueOf(com.kwad.sdk.c.a.a.bq(context)));
        this.aOT.put("TitleHT", BaseWrapper.ENTER_ID_OAPS_SECUREPAY);
        this.aOT.put("NetType", bV(context));
        this.aOT.put("ISLP", String.valueOf(bW(context)));
        this.aOT.put("ISDM", String.valueOf(bX(context)));
        int iEd = br.ed(context);
        this.aOT.put("ISLB", String.valueOf((iEd <= 0 || iEd >= 15) ? 0 : 1));
        this.aOT.put("locale", LM());
        this.aOT.put("SHP", String.valueOf(m.getScreenHeight(context)));
        this.aOT.put("SWP", String.valueOf(m.getScreenWidth(context)));
        this.aOT.put("SD", String.valueOf(m.cT(context)));
        this.aOT.put("CD", "0");
        this.aOT.put("ISLM", String.valueOf(bY(context)));
    }

    private String bU(Context context) {
        if (!TextUtils.isEmpty(this.aJW)) {
            return this.aJW;
        }
        if (context == null) {
            return "";
        }
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(this.aJW)) {
            return this.aJW;
        }
        this.aJW = WebSettings.getDefaultUserAgent(context);
        return this.aJW;
    }

    private static String bV(Context context) {
        NetworkInfo networkInfoDn;
        if (context == null || (networkInfoDn = ao.dn(context)) == null) {
            return "DISABLE";
        }
        int type = networkInfoDn.getType();
        if (type != 0) {
            return type != 1 ? "unknown" : "WIFI";
        }
        String subtypeName = networkInfoDn.getSubtypeName();
        return TextUtils.isEmpty(subtypeName) ? networkInfoDn.getTypeName() : subtypeName;
    }

    private static int bW(Context context) {
        return !AbiUtil.isArm64(context) || ((br.ee(context) >> 20) > 4096L ? 1 : ((br.ee(context) >> 20) == 4096L ? 0 : -1)) <= 0 ? 1 : 0;
    }

    private static int bX(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return 0;
        }
    }

    private static int bY(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return !memoryInfo.lowMemory && (memoryInfo.availMem > (aH(memoryInfo.threshold) + aI(Debug.getPss())) ? 1 : (memoryInfo.availMem == (aH(memoryInfo.threshold) + aI(Debug.getPss())) ? 0 : -1)) > 0 ? 0 : 1;
    }

    @Override // com.kwad.sdk.core.i.c
    public final String LK() {
        return this.aOS ? "kwai-android aegon/4.6.3.1" : "kwai-android aegon/4.6.3";
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bR(Context context) {
        return bU(context);
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bS(Context context) {
        try {
            if (this.aOT.isEmpty()) {
                bT(context);
            }
            StringBuilder sbLL = LL();
            if (this.aOS) {
                sbLL.insert(0, " KRN/3.6.6");
            }
            return sbLL.toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.w("KwaiUAGetter", "getWebViewUASuffix: " + th.getMessage());
            return "";
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public final void bx(boolean z) {
        this.aOS = z;
    }
}
