package com.opos.mobad.cmn.func.b;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.cmn.func.adhandler.a;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.service.c.a;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.umeng.analytics.pro.dn;
import com.wifi.WkInitManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.opos.cmn.an.e.d.a f8719a;
    private static WeakReference<c.b> d;
    private static final byte[] b = new byte[0];
    private static final byte[] c = new byte[0];
    private static final String e = com.opos.cmn.an.b.b.a("aGV5dGFwX3VuaW9uX3Rva2Vu");

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.b.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass1 implements a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8720a;
        final /* synthetic */ View b;
        private com.opos.cmn.module.ui.b.a c;

        public AnonymousClass1(Context context, View view) {
            this.f8720a = context;
            this.b = view;
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.c
        public void a() {
            com.opos.cmn.module.ui.b.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.c
        public void a(final a.b bVar) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.g.1.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.c = g.c(anonymousClass1.f8720a, anonymousClass1.b);
                    if (AnonymousClass1.this.c == null) {
                        bVar.a();
                    } else {
                        AnonymousClass1.this.c.a("当前为非Wi-Fi环境，\n是否继续下载？", "下载", "取消", new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.mobad.cmn.func.b.g.1.1.1
                            @Override // com.opos.cmn.module.ui.b.d.a
                            public void a(View view, int[] iArr) {
                                bVar.a();
                                AnonymousClass1.this.c.a();
                            }

                            @Override // com.opos.cmn.module.ui.b.d.a
                            public void b(View view, int[] iArr) {
                                bVar.b();
                                AnonymousClass1.this.c.a();
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.b.g$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8723a;

        static {
            int[] iArr = new int[a.values().length];
            f8723a = iArr;
            try {
                iArr[a.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8723a[a.E_COMMERCE_DIALOG_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8723a[a.OUT_COUPONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8723a[a.FLOAT_LAYER_INTERSTITIAL_RETAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8723a[a.SHAKE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8723a[a.LIGHT_INTERACTIVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8723a[a.CLICK_BT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8723a[a.NON_CLICK_BT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8723a[a.FLOAT_LAYER_CLICK_BT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8723a[a.FLOAT_LAYER_NON_CLICK_BT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        String strE = com.opos.cmn.an.h.e.a.e(context);
        strE.hashCode();
        switch (strE) {
        }
        return 0;
    }

    public static int b(String str) {
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                return 0;
            }
            return a(new File(str));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            return 0;
        }
    }

    public static final int c(String str) {
        int iLastIndexOf = -1;
        try {
            if (!com.opos.cmn.an.d.b.a(str)) {
                iLastIndexOf = str.lastIndexOf(e);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "getJsSignParamIndex=" + iLastIndexOf);
        return iLastIndexOf;
    }

    private static int d(Context context) {
        com.opos.cmn.an.h.f.a.k(context);
        if (g(context) || f(context)) {
            return 1872;
        }
        return h(context) ? 1752 : 1512;
    }

    public static int e() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE;
    }

    public static String f() {
        return "opos_mobad_v910004_2025_08_29_release";
    }

    public static int g() {
        return 910004;
    }

    public static String h() {
        String property;
        try {
            property = System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            property = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getUserAgent=");
        sb.append(property != null ? property : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return property;
    }

    private static com.opos.cmn.an.e.d.a i(Context context) {
        com.opos.cmn.an.e.d.a aVar = f8719a;
        if (aVar == null) {
            synchronized (b) {
                aVar = f8719a;
                if (aVar == null) {
                    aVar = new com.opos.cmn.an.e.d.a(context, "mobad.reward.prefs", 0);
                    f8719a = aVar;
                }
            }
        }
        return aVar;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT <= 29;
    }

    private static boolean k() {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "CheckProxy error", (Throwable) e2);
            return false;
        }
    }

    public static int a(File file) {
        File[] fileArrListFiles;
        int length = 0;
        if (file != null) {
            try {
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    length = fileArrListFiles.length;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderFilesCount folderFile=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.m);
        sb.append(",count=");
        sb.append(length);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return length;
    }

    public static long b(Context context, String str) {
        long jA = 0;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    jA = i(context).a(str, 0L);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRewardTime pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",timestamp=");
        sb.append(jA);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return jA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.opos.cmn.module.ui.b.a c(Context context, View view) {
        Activity activityA = context instanceof Activity ? (Activity) context : view != null ? a(view.getRootView().findViewById(R.id.content)) : null;
        if (activityA == null) {
            return null;
        }
        return new com.opos.cmn.module.ui.b.a(activityA);
    }

    public static String d(String str) {
        return str + "-" + System.currentTimeMillis();
    }

    private static String e(Context context) {
        String className;
        try {
            className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            className = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getCurrentActivityName=");
        sb.append(className != null ? className : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return className;
    }

    private static boolean f(Context context) {
        boolean z = 2.1666667f <= com.opos.cmn.an.h.f.a.k(context);
        com.opos.cmn.an.f.a.b("Utils", "isCurvedScreenAspectRatio=" + z);
        return z;
    }

    private static boolean g(Context context) {
        boolean z = 2.1111112f == com.opos.cmn.an.h.f.a.k(context);
        com.opos.cmn.an.f.a.b("Utils", "isShapedScreenAspectRatio=" + z);
        return z;
    }

    private static boolean h(Context context) {
        float fK = com.opos.cmn.an.h.f.a.k(context);
        boolean z = 2.0f == fK || 2.0370371f == fK;
        com.opos.cmn.an.f.a.b("Utils", "isFullScreenAspectRatio=" + z);
        return z;
    }

    public static c.b i() {
        c.b bVar = null;
        try {
            WeakReference<c.b> weakReference = d;
            if (weakReference != null && weakReference.get() != null) {
                bVar = d.get();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getCacheInterBaseAd=");
        sb.append(bVar != null ? bVar : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return bVar;
    }

    private static boolean j(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                    return networkCapabilities.hasTransport(4);
                }
            } else {
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                    if (networkInfo != null && networkInfo.getType() == 17) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "CheckVpn error", (Throwable) e2);
        }
        return false;
    }

    private static Activity a(View view) {
        if (view != null) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                com.opos.cmn.an.f.a.b("Utils", "context instanceof ContextWrapper");
                if (context instanceof Activity) {
                    com.opos.cmn.an.f.a.b("Utils", "context instanceof Activity");
                    return (Activity) context;
                }
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivity = null");
        return null;
    }

    private static String c(Activity activity) {
        String name;
        try {
            name = activity.getClass().getName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            name = "";
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivityClassName=" + name);
        return name;
    }

    public static boolean d() {
        String str;
        if (!c()) {
            str = "sdk not support android sdk version <19";
        } else {
            if (b()) {
                return true;
            }
            str = "init sdk failed!do nothing.";
        }
        com.opos.cmn.an.f.a.d("Utils", str);
        return false;
    }

    private static final String e(String str) {
        try {
            int iC = c(str);
            if (-1 != iC) {
                str = str.substring(0, iC - 1);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "result=" + str);
        return str;
    }

    public static final ActivityInfo a(Context context, Class cls) {
        if (context == null || cls == null) {
            return null;
        }
        try {
            return context.getPackageManager().getActivityInfo(new ComponentName(context, (Class<?>) cls), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            com.opos.cmn.an.f.a.c("Utils", "", e2);
            return null;
        }
    }

    public static a.c b(Activity activity) {
        return a(activity, (View) null);
    }

    public static void c(Context context, String str) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.d.b.a(str)) {
                    return;
                }
                i(context).a(str);
                com.opos.cmn.an.f.a.b("Utils", "removeRewardTime pkgName=" + str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    private static boolean d(Context context, String str) {
        boolean z = false;
        if (context != null) {
            try {
                if (com.opos.cmn.an.h.d.a.d(context, str)) {
                    if (e(context, str)) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "supportMarket=" + z);
        return z;
    }

    private static boolean e(Context context, String str) {
        boolean z = false;
        try {
            if (com.opos.cmn.an.h.d.a.g(context, str) != null) {
                if (com.opos.cmn.an.h.d.a.g(context, str).enabled) {
                    z = true;
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "isPkgEnabled=" + z);
        return z;
    }

    public static com.opos.cmn.an.d.a a(String str, String str2) {
        com.opos.cmn.an.d.a aVar = new com.opos.cmn.an.d.a();
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("launch_source_type", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("launch_source_traceid", str2);
        }
        if (!map.isEmpty()) {
            aVar.a(map);
        }
        return aVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context, String str, int[] iArr, long j) {
        byte b2;
        String strC;
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = null;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    switch (str.hashCode()) {
                        case -1001078227:
                            b2 = !str.equals("progress") ? (byte) -1 : dn.k;
                            break;
                        case 99:
                            if (str.equals("c")) {
                                b2 = 4;
                                break;
                            }
                            break;
                        case 104:
                            if (str.equals("h")) {
                                b2 = 6;
                                break;
                            }
                            break;
                        case 109:
                            if (str.equals("m")) {
                                b2 = 2;
                                break;
                            }
                            break;
                        case 119:
                            if (str.equals(RXScreenCaptureService.KEY_WIDTH)) {
                                b2 = 5;
                                break;
                            }
                            break;
                        case 3125:
                            if (str.equals(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO)) {
                                b2 = 8;
                                break;
                            }
                            break;
                        case 3138:
                            if (str.equals(WkInitManager.sdk_bd)) {
                                b2 = 19;
                                break;
                            }
                            break;
                        case 3166:
                            if (str.equals(com.igexin.push.core.b.ac)) {
                                b2 = 10;
                                break;
                            }
                            break;
                        case 3185:
                            if (str.equals("ct")) {
                                b2 = dn.l;
                                break;
                            }
                            break;
                        case 3220:
                            if (str.equals("dx")) {
                                b2 = 15;
                                break;
                            }
                            break;
                        case 3221:
                            if (str.equals("dy")) {
                                b2 = 16;
                                break;
                            }
                            break;
                        case 3526:
                            if (str.equals("nt")) {
                                b2 = 9;
                                break;
                            }
                            break;
                        case 3556:
                            if (str.equals("os")) {
                                b2 = 0;
                                break;
                            }
                            break;
                        case 3559:
                            if (str.equals("ov")) {
                                b2 = 1;
                                break;
                            }
                            break;
                        case 3636:
                            if (str.equals(RedirectReqWrapper.KEY_REFER)) {
                                b2 = 12;
                                break;
                            }
                            break;
                        case 3724:
                            if (str.equals("ua")) {
                                b2 = 11;
                                break;
                            }
                            break;
                        case 3747:
                            if (str.equals("ux")) {
                                b2 = 17;
                                break;
                            }
                            break;
                        case 3748:
                            if (str.equals("uy")) {
                                b2 = 18;
                                break;
                            }
                            break;
                        case 106905:
                            if (str.equals("lan")) {
                                b2 = 3;
                                break;
                            }
                            break;
                        case 111052:
                            if (str.equals("pkg")) {
                                b2 = 7;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                    switch (b2) {
                        case 0:
                            strC = "android";
                            str2 = strC;
                            break;
                        case 1:
                            strC = com.opos.cmn.an.c.c.c();
                            str2 = strC;
                            break;
                        case 2:
                            strC = com.opos.cmn.an.c.c.a();
                            str2 = strC;
                            break;
                        case 3:
                            strC = com.opos.cmn.an.c.b.a();
                            str2 = strC;
                            break;
                        case 4:
                            strC = com.opos.cmn.an.c.b.b();
                            str2 = strC;
                            break;
                        case 5:
                            sb = new StringBuilder();
                            sb.append(com.opos.cmn.an.h.f.a.b(context));
                            sb.append("");
                            strC = sb.toString();
                            str2 = strC;
                            break;
                        case 6:
                            sb = new StringBuilder();
                            sb.append(com.opos.cmn.an.h.f.a.c(context));
                            sb.append("");
                            strC = sb.toString();
                            str2 = strC;
                            break;
                        case 7:
                            strC = context.getPackageName();
                            str2 = strC;
                            break;
                        case 8:
                            strC = com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
                            str2 = strC;
                            break;
                        case 9:
                            strC = com.opos.cmn.an.h.c.a.h(context);
                            str2 = strC;
                            break;
                        case 10:
                            sb = new StringBuilder();
                            sb.append(a(context));
                            sb.append("");
                            strC = sb.toString();
                            str2 = strC;
                            break;
                        case 11:
                            strC = h();
                            str2 = strC;
                            break;
                        case 12:
                        case 14:
                            str2 = "";
                            break;
                        case 13:
                            sb2 = new StringBuilder();
                            sb2.append(j);
                            sb2.append("");
                            strC = sb2.toString();
                            str2 = strC;
                            break;
                        case 15:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[0]);
                                sb2.append("");
                                strC = sb2.toString();
                                str2 = strC;
                            }
                            str2 = "-999";
                            break;
                        case 16:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[1]);
                                sb2.append("");
                                strC = sb2.toString();
                                str2 = strC;
                            }
                            str2 = "-999";
                            break;
                        case 17:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[2]);
                                sb2.append("");
                                strC = sb2.toString();
                                str2 = strC;
                            }
                            str2 = "-999";
                            break;
                        case 18:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[3]);
                                sb2.append("");
                                strC = sb2.toString();
                                str2 = strC;
                            }
                            str2 = "-999";
                            break;
                        case 19:
                            strC = com.opos.cmn.an.c.a.a(context);
                            str2 = strC;
                            break;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("key=");
        String str3 = com.igexin.push.core.b.m;
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb3.append(str);
        sb3.append(",value=");
        if (str2 != null) {
            str3 = str2;
        }
        sb3.append(str3);
        com.opos.cmn.an.f.a.b("Utils", sb3.toString());
        return str2 != null ? str2 : "";
    }

    public static boolean c() {
        return com.opos.cmn.an.c.c.b() >= 19;
    }

    public static a.c a(Context context, View view) {
        return new AnonymousClass1(context, view);
    }

    public static Map<String, Long> b(Context context) {
        Map mapA = null;
        mapA = null;
        if (context != null) {
            try {
                mapA = i(context).a();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAllRewardTime size=");
        sb.append(mapA != null ? Integer.valueOf(mapA.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return mapA;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return k() || j(context);
    }

    public static com.opos.mobad.model.c.c a(com.opos.mobad.b bVar, String str, int i, String str2, List<String> list) {
        return a(bVar, str, i, str2, list, false);
    }

    public static boolean b() {
        return b.b;
    }

    public static boolean c(Context context, String str, com.opos.cmn.an.d.a aVar) {
        Bundle bundleB;
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                String strA = com.opos.cmn.biz.a.c.a(context);
                com.opos.cmn.an.f.a.b("Utils", "getMarketName=" + strA);
                if (!d(context, strA)) {
                    com.opos.cmn.an.f.a.a("Utils", " unsupport Market");
                    return false;
                }
                intent.setPackage(strA);
                if (aVar != null) {
                    Bundle bundleB2 = com.opos.cmn.an.d.a.b(aVar.a());
                    com.opos.cmn.an.f.a.a("Utils", "executeDeeplinkDownloadApp intentBundle:", bundleB2);
                    if (bundleB2 != null) {
                        intent.putExtras(bundleB2);
                    }
                }
                if (aVar != null) {
                    bundleB = com.opos.cmn.an.d.a.b(aVar.b());
                    com.opos.cmn.an.f.a.a("Utils", "executeDeeplinkDownloadApp optionsBundle:", bundleB);
                } else {
                    bundleB = null;
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                    if (bundleB != null) {
                        context.startActivity(intent, bundleB);
                    } else {
                        context.startActivity(intent);
                    }
                } else if (bundleB != null) {
                    ((Activity) context).startActivity(intent, bundleB);
                } else {
                    ((Activity) context).startActivity(intent);
                }
                z = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.a("Utils", "executeDeeplinkDownloadApp result = " + z);
        return z;
    }

    public static com.opos.mobad.model.c.c a(com.opos.mobad.b bVar, String str, int i, String str2, List<String> list, boolean z) {
        if (bVar == null || com.opos.cmn.an.d.b.a(str)) {
            return null;
        }
        com.opos.mobad.model.c.c cVar = new com.opos.mobad.model.c.c();
        cVar.b(str);
        cVar.c(i);
        int[] iArrA = a(bVar.b(), i);
        cVar.d(iArrA[1]);
        cVar.e(iArrA[0]);
        cVar.a(str2);
        cVar.b(e());
        cVar.c(bVar.g().c());
        cVar.e(bVar.g().b());
        cVar.d(bVar.g().a());
        cVar.a(list);
        cVar.a(z);
        cVar.g(bVar.g().d());
        cVar.h(bVar.g().e());
        cVar.i(bVar.g().f());
        return cVar;
    }

    public static boolean b(Context context, Class cls) {
        ActivityInfo activityInfoA = a(context, cls);
        if (activityInfoA == null) {
            return false;
        }
        com.opos.cmn.an.f.a.b("Utils", "is standard launch mode" + activityInfoA.launchMode);
        return activityInfoA.launchMode == 0;
    }

    public static MaterialFileData a(AdItemData adItemData) {
        List<MaterialData> listI;
        MaterialData materialData;
        List<MaterialFileData> listD;
        if (adItemData == null || (listI = adItemData.i()) == null || listI.size() <= 0 || (materialData = listI.get(0)) == null || (listD = materialData.D()) == null || listD.size() <= 0) {
            return null;
        }
        return listD.get(0);
    }

    public static boolean b(Context context, String str, com.opos.cmn.an.d.a aVar) {
        boolean z = false;
        if (context != null && !com.opos.cmn.an.d.b.a(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                Bundle bundleB = null;
                intent.setComponent(null);
                intent.addFlags(268435456);
                if (com.opos.cmn.an.h.d.a.a(context, intent)) {
                    if (aVar != null) {
                        Bundle bundleB2 = com.opos.cmn.an.d.a.b(aVar.a());
                        com.opos.cmn.an.f.a.a("Utils", "launchAppDetailPage intentBundle:", bundleB2);
                        if (bundleB2 != null) {
                            intent.putExtras(bundleB2);
                        }
                    }
                    if (aVar != null) {
                        bundleB = com.opos.cmn.an.d.a.b(aVar.b());
                        com.opos.cmn.an.f.a.a("Utils", "launchAppDetailPage optionsBundle:", bundleB);
                    }
                    if (bundleB != null) {
                        context.startActivity(intent, bundleB);
                    } else {
                        context.startActivity(intent);
                    }
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchAppDetailPage url=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append("result=");
        sb.append(z);
        com.opos.cmn.an.f.a.a("Utils", sb.toString());
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2 A[PHI: r6
      0x00d2: PHI (r6v5 java.lang.String) = (r6v3 java.lang.String), (r6v3 java.lang.String), (r6v6 java.lang.String) binds: [B:8:0x0014, B:10:0x001a, B:23:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        String strF;
        String strSubstring = "";
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    strF = com.opos.cmn.an.h.d.a.f(context, str);
                    try {
                        if (com.opos.cmn.an.d.b.a(strF) || strF.length() <= 0) {
                            strSubstring = strF;
                        } else {
                            int iIndexOf = strF.indexOf("(");
                            int iIndexOf2 = strF.indexOf(")");
                            com.opos.cmn.an.f.a.b("Utils", "english first=" + iIndexOf + ",english last=" + iIndexOf2);
                            if (-1 == iIndexOf || -1 == iIndexOf2) {
                                iIndexOf = strF.indexOf("（");
                                iIndexOf2 = strF.indexOf("）");
                                com.opos.cmn.an.f.a.b("Utils", "chinese first=" + iIndexOf + ",chinese last=" + iIndexOf2);
                            }
                            if (-1 != iIndexOf && -1 != iIndexOf2 && iIndexOf2 > iIndexOf) {
                                strF = strF.substring(0, iIndexOf) + strF.substring(iIndexOf2 + 1, strF.length());
                            }
                            int iIndexOf3 = strF.indexOf("-");
                            com.opos.cmn.an.f.a.b("Utils", "english - =" + iIndexOf3);
                            if (-1 == iIndexOf3) {
                                iIndexOf3 = strF.indexOf("—");
                                com.opos.cmn.an.f.a.b("Utils", "chinese — =" + iIndexOf3);
                            }
                            if (-1 != iIndexOf3) {
                                strSubstring = strF.substring(0, iIndexOf3);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
                    }
                }
                strF = strSubstring;
            } catch (Exception e3) {
                e = e3;
                strF = "";
            }
        } else {
            strF = strSubstring;
        }
        com.opos.cmn.an.f.a.b("Utils", "getAppDefaultTitle=" + strF);
        return strF;
    }

    public static String a(Context context, String str, int[] iArr, long j) {
        int iIndexOf;
        StringBuilder sb = new StringBuilder();
        sb.append("handleMacroInMonitorLinkUrl before=");
        sb.append(str != null ? str : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        if (context != null && !com.opos.cmn.an.d.b.a(str) && str.length() > 0) {
            int iIndexOf2 = str.indexOf("$");
            StringBuilder sb2 = new StringBuilder();
            if (-1 != iIndexOf2) {
                int iIndexOf3 = 0;
                sb2.append(str.substring(0, iIndexOf2));
                String strSubstring = str.substring(iIndexOf2);
                do {
                    int i = iIndexOf3 + 1;
                    iIndexOf = strSubstring.indexOf("$", i);
                    if (-1 != iIndexOf) {
                        String strB = b(context, strSubstring.substring(i, iIndexOf), iArr, j);
                        if (com.opos.cmn.an.d.b.a(strB)) {
                            strB = strSubstring.substring(iIndexOf3, iIndexOf + 1);
                        }
                        sb2.append(strB);
                        int i2 = iIndexOf + 1;
                        iIndexOf3 = strSubstring.indexOf("$", i2);
                        sb2.append((-1 == iIndexOf3 || iIndexOf3 < iIndexOf) ? strSubstring.substring(i2) : strSubstring.substring(i2, iIndexOf3));
                    } else {
                        sb2.append(strSubstring);
                    }
                    if (-1 == iIndexOf3) {
                        break;
                    }
                } while (-1 != iIndexOf);
                str = sb2.toString();
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "handleMacroInMonitorLinkUrl after=" + str);
        return str;
    }

    public static final String a(String str, String str2, String str3, String str4) {
        String strA = "";
        if (!com.opos.cmn.an.d.b.a(str3)) {
            try {
                String strE = e(str3);
                a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
                String str5 = c0768aM != null ? c0768aM.f9210a : "";
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(com.opos.cmn.an.b.d.a(strE));
                sb.append(str4);
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                strA = com.opos.cmn.an.b.c.a(sb.toString());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "jsSign=" + strA);
        return strA;
    }

    public static void a() {
        b.b = true;
        com.opos.cmn.an.f.a.b("Utils", "setSdkInitSuccess");
    }

    public static void a(Context context, String str, long j) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.d.b.a(str)) {
                    return;
                }
                i(context).a(str, Long.valueOf(j));
                com.opos.cmn.an.f.a.b("Utils", "putRewardTime pkgName=" + str + ",timestamp=" + j);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, Callback callback, String str4) {
        try {
            c.a(context, str, str2, str3, callback, "10001", str4);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        c.a(context, str, str2, str3, "10001", str4);
    }

    public static void a(c.b bVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("setCacheInterBaseAd=");
            sb.append(bVar != null ? bVar : com.igexin.push.core.b.m);
            com.opos.cmn.an.f.a.b("Utils", sb.toString());
            if (bVar != null) {
                d = new WeakReference<>(bVar);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(String str) {
        b.f8684a = str;
        StringBuilder sb = new StringBuilder();
        sb.append("setAppId=");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
    }

    public static void a(boolean z) {
        b.e = z;
    }

    private static boolean a(int i) {
        if (i == 1 || i == 5 || i == 7 || i == 8) {
            return true;
        }
        com.opos.cmn.an.f.a.b("Utils", "isLinkType result:false");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Activity activity) {
        boolean z = false;
        if (activity != null) {
            try {
                if (!"".equals(e(activity))) {
                    if (c(activity).equals(e(activity))) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isCurrentActivity=" + z);
        return z;
    }

    public static boolean a(Context context, String str, com.opos.cmn.an.d.a aVar) {
        boolean zA = false;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str) && com.opos.cmn.an.h.d.a.d(context, str)) {
                    zA = com.opos.cmn.an.h.d.a.a(context, str, aVar);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchAppHomePage pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(zA);
        com.opos.cmn.an.f.a.a("Utils", sb.toString());
        return zA;
    }

    public static boolean a(com.opos.mobad.b bVar) {
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular before=" + b.e);
        boolean z = true;
        try {
            if (!b.e) {
                z = false;
            } else if (!bVar.n().e()) {
                b.e = false;
                z = false;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular=" + z);
        return z;
    }

    public static boolean a(com.opos.mobad.b bVar, AdItemData adItemData, a aVar) {
        return a(adItemData, aVar) && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(bVar != null ? bVar.b() : null)) && a(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, int[] iArr) {
        HashMap map;
        com.opos.cmn.an.d.a aVarA;
        boolean z = false;
        if (bVar != null && adItemData != null && materialData != null) {
            String strQ = materialData.q();
            String strI = materialData.i();
            try {
                String strD = d(adItemData.al());
                map = new HashMap();
                com.opos.mobad.cmn.func.b.a.a.b(map, strD);
                aVarA = a(bVar.e(), strD);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
            if (TextUtils.isEmpty(strQ) || !b(bVar.b(), strQ, aVarA)) {
                if (a(bVar.b(), strI, aVarA)) {
                    e.a(bVar, adItemData, adItemData.i().get(0), true, iArr, (Map<String, String>) map);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("launchAppPage url=");
                if (strQ == null) {
                    strQ = com.igexin.push.core.b.m;
                }
                sb.append(strQ);
                sb.append(",pkgName=");
                if (strI == null) {
                    strI = com.igexin.push.core.b.m;
                }
                sb.append(strI);
                sb.append(",result=");
                sb.append(z);
                com.opos.cmn.an.f.a.a("Utils", sb.toString());
            } else {
                e.c(bVar, adItemData.g(), adItemData, adItemData.i().get(0), true, iArr, map);
            }
            z = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("launchAppPage url=");
            if (strQ == null) {
            }
            sb2.append(strQ);
            sb2.append(",pkgName=");
            if (strI == null) {
            }
            sb2.append(strI);
            sb2.append(",result=");
            sb2.append(z);
            com.opos.cmn.an.f.a.a("Utils", sb2.toString());
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(AdItemData adItemData, a aVar) {
        boolean z = false;
        if (adItemData != null && adItemData.i() != null && adItemData.i().size() > 0) {
            switch (AnonymousClass2.f8723a[aVar.ordinal()]) {
                case 1:
                    if (2 == adItemData.i().get(0).H() && 2 == adItemData.i().get(0).I()) {
                        z = true;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (2 == adItemData.i().get(0).d() && 2 == adItemData.i().get(0).I()) {
                    }
                    break;
                case 8:
                    if (2 == adItemData.i().get(0).G() && 2 == adItemData.i().get(0).I()) {
                    }
                    break;
                case 9:
                    if (2 == adItemData.i().get(0).S() && 2 == adItemData.i().get(0).I()) {
                    }
                    break;
                case 10:
                    if (2 == adItemData.i().get(0).T() && 2 == adItemData.i().get(0).I()) {
                    }
                    break;
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isDownloaderTypeAd=" + z);
        return z;
    }

    public static boolean a(AdItemData adItemData, MaterialData materialData) {
        if (adItemData != null && adItemData.F() == 1) {
            return true;
        }
        if (materialData == null) {
            return false;
        }
        String strP = materialData.p();
        if (!TextUtils.isEmpty(strP)) {
            try {
                String strOptString = new JSONObject(strP).optString("adCat");
                if (!TextUtils.isEmpty(strOptString)) {
                    if ("3".equals(strOptString)) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("Utils", "isLinkType:", e2);
            }
        }
        return a(materialData.d()) || a(materialData.H()) || a(materialData.G());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(MaterialData materialData) {
        boolean z = false;
        if (materialData != null) {
            try {
                if ((3 != materialData.G() || 2 != materialData.I()) && (3 != materialData.H() || 2 != materialData.I())) {
                    if (3 == materialData.d()) {
                        if (2 == materialData.I()) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isMiddleDownloader result:" + z);
        return z;
    }

    public static boolean a(Map<String, String> map) {
        return map != null && map.containsKey("isVisibleRect") && map.containsKey("isAttached");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[] a(Context context, int i) {
        int[] iArr = {0, 0};
        if (i == 1) {
            iArr[0] = 1080;
            iArr[1] = 171;
        } else if (i == 2) {
            iArr[0] = 720;
            iArr[1] = 600;
        } else if (i == 3) {
            iArr[0] = 1080;
            iArr[1] = d(context);
        } else if (i == 5) {
            iArr[0] = com.opos.cmn.an.h.f.a.b(context);
            iArr[1] = com.opos.cmn.an.h.f.a.c(context);
        } else if (i == 6) {
        }
        return iArr;
    }
}
