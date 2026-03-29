package com.bytedance.sdk.openadsdk.core.y;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bq {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        String fx;
        String nr;
        String u;

        public u(String str, String str2, String str3) {
            this.u = str;
            this.nr = str2;
            this.fx = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof u)) {
                return super.equals(obj);
            }
            u uVar = (u) obj;
            String str2 = this.u;
            return str2 != null && str2.equals(uVar.u) && (str = this.fx) != null && str.equals(uVar.fx);
        }

        public String toString() {
            try {
                return "<" + this.u + " name=\"" + this.nr + "\" path=\"" + this.fx + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }

    private static List<u> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u("external-path", "tt_external_root", "."));
        return arrayList;
    }

    private static List<u> fx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u("external-path", "tt_external_download", "Download"));
        arrayList.add(new u("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new u("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new u("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<String> nr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(g.f7481a);
        arrayList.add(g.b);
        arrayList.add(g.d);
        arrayList.add(g.c);
        arrayList.add(g.j);
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add(g.h);
        arrayList.add(g.g);
        return arrayList;
    }

    public static void u() {
        Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        if (context != null && com.bytedance.sdk.component.utils.k.fx()) {
            u(context);
            String packageName = context.getPackageName();
            int i = context.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            boolean z2 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072)) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                        com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                        com.bytedance.sdk.openadsdk.tools.nr.fx(3, "0");
                    } else {
                        com.bytedance.sdk.openadsdk.tools.nr.fx(3, "1");
                    }
                    z = true;
                } else {
                    if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                        if (Build.VERSION.SDK_INT < 24 || i < 24) {
                            com.bytedance.sdk.openadsdk.tools.nr.fx(3, "1");
                        } else {
                            if (providerInfo.exported) {
                                com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                                com.bytedance.sdk.openadsdk.tools.nr.fx(3, "0");
                            }
                            if (!providerInfo.grantUriPermissions) {
                                com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                                com.bytedance.sdk.openadsdk.tools.nr.fx(3, "0");
                            }
                            try {
                                List<u> listU = u(context, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                                if (listU == null || listU.isEmpty()) {
                                    com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                                    com.bytedance.sdk.openadsdk.tools.nr.fx(3, "0");
                                } else {
                                    List<u> listFx = fx();
                                    List<u> listB = b();
                                    for (u uVar : listU) {
                                        if (uVar != null) {
                                            listFx.remove(uVar);
                                            listB.remove(uVar);
                                        }
                                    }
                                    if (listFx.isEmpty() && listB.isEmpty()) {
                                        com.bytedance.sdk.openadsdk.tools.nr.fx(3, "1");
                                    } else {
                                        Iterator<u> it = listFx.iterator();
                                        while (it.hasNext()) {
                                            com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                        }
                                        Iterator<u> it2 = listB.iterator();
                                        while (it2.hasNext()) {
                                            com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                        }
                                        com.bytedance.sdk.openadsdk.tools.nr.fx(3, "0");
                                    }
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.k.u("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                                com.bytedance.sdk.openadsdk.tools.nr.fx(3, "0");
                            }
                        }
                        z2 = true;
                    }
                }
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr == null || strArr.length <= 0) {
                    com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                } else {
                    List<String> listNr = nr();
                    for (String str2 : strArr) {
                        if (str2 != null) {
                            listNr.remove(str2);
                        }
                    }
                    if (!listNr.isEmpty()) {
                        Iterator<String> it3 = listNr.iterator();
                        while (it3.hasNext()) {
                            com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                        }
                    }
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.k.u("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && i >= 23) {
                    boolean zU = com.bytedance.sdk.openadsdk.core.h.pn.u().u(context, g.c);
                    boolean zU2 = com.bytedance.sdk.openadsdk.core.h.pn.u().u(context, g.h);
                    boolean zU3 = com.bytedance.sdk.openadsdk.core.h.pn.u().u(context, g.g);
                    boolean zU4 = com.bytedance.sdk.openadsdk.core.h.pn.u().u(context, g.j);
                    if (!zU) {
                        com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                    }
                    if (!zU2) {
                        com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (!zU3) {
                        com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                    }
                    if (!zU4) {
                        com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.k.u("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
            }
            if (!z) {
                com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
            }
            if (z2) {
                return;
            }
            com.bytedance.sdk.component.utils.k.nr("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
        }
    }

    private static String u(Context context) {
        try {
            return com.bytedance.sdk.component.utils.bq.nr(context);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<u> u(Context context, int i) {
        XmlResourceParser xml;
        try {
            ArrayList arrayList = new ArrayList();
            xml = context.getResources().getXml(i);
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        int attributeCount = xml.getAttributeCount();
                        String attributeValue = null;
                        String attributeValue2 = null;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            String attributeName = xml.getAttributeName(i2);
                            if (attributeName.equals("name")) {
                                attributeValue = xml.getAttributeValue(i2);
                            } else if (attributeName.equals(OapsWrapper.KEY_PATH)) {
                                attributeValue2 = xml.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(attributeValue2)) {
                            arrayList.add(new u(name, attributeValue, attributeValue2));
                        }
                    }
                }
                xml.close();
                return arrayList;
            } catch (Throwable unused) {
                if (xml != null) {
                    xml.close();
                }
                return null;
            }
        } catch (Throwable unused2) {
            xml = null;
        }
    }
}
