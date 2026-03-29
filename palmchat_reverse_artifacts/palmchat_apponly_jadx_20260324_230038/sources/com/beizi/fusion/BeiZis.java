package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.tool.ae;
import com.beizi.fusion.tool.x;
import com.kuaishou.weapon.p0.g;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BeiZis {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BeiZiCustomController f4598a = null;
    private static boolean b = false;
    private static String c = "1.0.25";
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = false;

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str) {
        d = false;
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInitWithDomain(Context context, String str, String str2) {
        d = false;
        if (TextUtils.isEmpty(str2)) {
            com.beizi.fusion.c.b.a().a(context, str, null, null);
        } else {
            com.beizi.fusion.c.b.a().a(str2).a(context, str, null, null);
        }
    }

    public static void closeShakeAd() {
        f = true;
    }

    public static String getBidToken(String str) {
        return com.beizi.fusion.c.b.a().b(str);
    }

    public static BeiZiCustomController getCustomController() {
        return f4598a;
    }

    public static String getOaidVersion() {
        return c;
    }

    public static String getSdkVersion() {
        return "5.2.2.0";
    }

    public static boolean getTransferProtocol() {
        return e;
    }

    @RequiresPermission(g.f7481a)
    public static void init(Context context, String str) {
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f7481a)
    public static void initWithDomain(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            com.beizi.fusion.c.b.a().a(context, str, null, null);
        } else {
            com.beizi.fusion.c.b.a().a(str2).a(context, str, null, null);
        }
    }

    public static boolean isCloseShakeAd() {
        return f;
    }

    public static boolean isIsSyncInit() {
        return d;
    }

    public static boolean isLimitPersonalAds() {
        return b;
    }

    public static void setAnyCustomExt(Map<String, Object> map) {
        com.beizi.fusion.c.b.a().a(map);
    }

    public static void setLimitPersonalAds(boolean z) {
        b = z;
    }

    public static void setOaidVersion(String str) {
        c = str;
    }

    public static void setSupportPersonalized(boolean z) {
        ae.a(z);
    }

    public static void setTransferProtocol(boolean z) {
        e = z;
    }

    public static void setUserAgent(String str) {
        x.a().a(str);
    }

    @RequiresPermission(g.f7481a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f4598a = beiZiCustomController;
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiInitCallBack beiZiInitCallBack) {
        d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f7481a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f4598a = beiZiCustomController;
        com.beizi.fusion.c.b.a().a(context, str, str2, null);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInitWithDomain(Context context, String str, String str2, BeiZiInitCallBack beiZiInitCallBack) {
        d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        if (!TextUtils.isEmpty(str2)) {
            com.beizi.fusion.c.b.a().a(str2).a(context, str, null, null);
        } else {
            com.beizi.fusion.c.b.a().a(context, str, null, null);
        }
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f4598a = beiZiCustomController;
        d = false;
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f7481a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f4598a = beiZiCustomController;
        com.beizi.fusion.c.b.a().a(context, str, str2, str3);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, BeiZiInitCallBack beiZiInitCallBack) {
        f4598a = beiZiCustomController;
        d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, null, null);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f4598a = beiZiCustomController;
        d = false;
        com.beizi.fusion.c.b.a().a(context, str, str2, null);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, BeiZiInitCallBack beiZiInitCallBack) {
        f4598a = beiZiCustomController;
        d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, str2, null);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f4598a = beiZiCustomController;
        d = false;
        com.beizi.fusion.c.b.a().a(context, str, str2, str3);
    }

    @RequiresPermission(g.f7481a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3, BeiZiInitCallBack beiZiInitCallBack) {
        f4598a = beiZiCustomController;
        d = false;
        com.beizi.fusion.c.b.a().a(beiZiInitCallBack);
        com.beizi.fusion.c.b.a().a(context, str, str2, str3);
    }
}
