package com.zenmen.palmchat.activity.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tide.protocol.util.TdFileUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.r75;
import defpackage.rl0;
import defpackage.sy5;
import defpackage.zy4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12423a = "b";

    public static boolean a(String str) {
        List<String> listD = zy4.d(str);
        if (listD == null || listD.size() <= 0) {
            return false;
        }
        return listD.get(listD.size() - 1).toLowerCase().endsWith(com.huawei.hms.ads.dynamicloader.b.b);
    }

    public static boolean b(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        return context.getPackageManager().queryIntentActivities(intent, 0).size() != 0;
    }

    public static boolean c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(".zip");
        arrayList.add(".xps");
        arrayList.add(".xltx");
        arrayList.add(".xlsb");
        arrayList.add(".wpx");
        arrayList.add(".vsdx");
        arrayList.add(".tif");
        arrayList.add(".sql");
        arrayList.add(".rtf");
        arrayList.add(".rar");
        arrayList.add(".potx");
        arrayList.add(".msi");
        arrayList.add(".msg");
        arrayList.add(".mht");
        arrayList.add(".jfif");
        arrayList.add(".java");
        arrayList.add(TdFileUtils.PLUGIN_FILE_TAIL);
        arrayList.add(".ini");
        arrayList.add(".exe");
        arrayList.add(".eml");
        arrayList.add(".bz2");
        arrayList.add(com.huawei.hms.ads.dynamicloader.b.b);
        arrayList.add(".md");
        arrayList.add(".7z");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("http://dl.lianwifi.com/");
        arrayList2.add("http://readfile.wifi.com");
        arrayList2.add("https://dl.lianwifi.com");
        arrayList2.add("https://cdnpalmchat.youni.im");
        arrayList2.add("https://mk.51y5.net");
        arrayList2.add("https://statics.jixiangjili.com");
        arrayList2.add("http://res.jili365.com");
        arrayList2.add("https://o1.wkanx.com");
        arrayList2.add("https://cdnpalmchat.youni.im");
        arrayList2.add("https://palmchat.cdn.lianxinapp.com");
        arrayList2.add("https://img.51hyclub.com");
        arrayList2.add("http://apk-internal.y5en.com:8080");
        arrayList2.add("http://images.zhulang.com");
        arrayList2.add("https://o1.wkanx.com");
        arrayList2.add("http://static.ergeyy.com");
        arrayList2.add("https://assets.zhimawenda.com");
        arrayList2.add("https://api.zhangyuku.com/");
        if (str.startsWith("https://m.zenmen.com")) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.endsWith((String) it.next())) {
                    return true;
                }
            }
            return false;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (str.startsWith((String) it2.next()) && str.endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str) {
        LogUtil.d(f12423a, "url:" + str);
        boolean z = false;
        for (String str2 : rl0.h().k().a()) {
            if (Pattern.matches(str2, str)) {
                LogUtil.d(f12423a, str2 + " [OK]");
                z = true;
            } else {
                LogUtil.d(f12423a, str2);
            }
        }
        return z;
    }

    public static void e(Context context, String str, String str2, String str3) {
        f(context, str2, str3);
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setClassName(str2, str3);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            sy5.f(context, context.getResources().getString(R.string.string_invalid_browser), 1).g();
            r75.o(AppContext.getContext(), "sp_browser_ones", true);
        }
    }

    public static void f(Context context, String str, String str2) {
        r75.r(context, "sp_browser_pkg", str);
        r75.r(context, "sp_browser_class", str2);
    }

    public static a g(Context context, String str, a.d dVar) {
        a aVar = new a(context, str);
        aVar.g(dVar).show();
        return aVar;
    }
}
