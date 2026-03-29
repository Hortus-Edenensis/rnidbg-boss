package com.opos.cmn.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.compatible.base.launcher.LauncherHelper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.opos.cmn.an.d.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static void a(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper((Map<String, Object>) map2);
        oapsWrapperWrapper.setScheme("oaps").setHost(Launcher.Host.MK).setPath(Launcher.Path.DETAIL_DOWN);
        if (!TextUtils.isEmpty(str5)) {
            oapsWrapperWrapper.set("tk_con", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            oapsWrapperWrapper.set("tk_ref", str6);
        }
        if (!TextUtils.isEmpty(str8)) {
            oapsWrapperWrapper.set("sub_caller", str8);
        }
        if (map != null && map.size() > 0) {
            com.opos.cmn.an.f.a.b("OApsTool", "extWrapperMap=" + map);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry != null && !TextUtils.isEmpty(entry.getKey())) {
                    oapsWrapperWrapper.set(entry.getKey(), entry.getValue());
                }
            }
        }
        ResourceWrapper resourceWrapperWrapper = ResourceWrapper.wrapper((Map<String, Object>) map2);
        resourceWrapperWrapper.setAutoDown(z);
        resourceWrapperWrapper.setGoBack("1");
        resourceWrapperWrapper.setPkgName(str);
        resourceWrapperWrapper.setEnterId(str7);
        resourceWrapperWrapper.setEnterModule(str2);
        if (!TextUtils.isEmpty(str4)) {
            resourceWrapperWrapper.setTraceId(str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            resourceWrapperWrapper.setChannelPkg(str3);
        }
        com.opos.cmn.an.f.a.a("OApsTool", "jumpDetail:" + map2);
        LauncherHelper.launchActivity(context, map2);
    }

    private static boolean a(Context context) {
        return LauncherHelper.support(context, Launcher.Host.MK, Launcher.Path.DETAIL_DOWN);
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Map<String, Object> map, boolean z) {
        if (context == null || b.a(str) || b.a(str7)) {
            com.opos.cmn.an.f.a.c("OApsTool", "context or pkgName or enterId cannot be null");
        } else {
            try {
                if (a(context)) {
                    a(context, str, z, str2, str3, str4, str5, str6, str7, str8, map);
                    return true;
                }
                com.opos.cmn.an.f.a.a("OApsTool", "launchMarketDownloadPage not supportDetail!");
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("OApsTool", "", e);
            }
        }
        return false;
    }
}
