package com.tencent.turingfd.sdk.ams.ad;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.try, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Ctry {
    public static boolean a(AccessibilityServiceInfo accessibilityServiceInfo) {
        ServiceInfo serviceInfo;
        ApplicationInfo applicationInfo;
        ResolveInfo resolveInfo = accessibilityServiceInfo.getResolveInfo();
        if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && (applicationInfo = serviceInfo.applicationInfo) != null) {
            if (applicationInfo.uid < 10000) {
                return true;
            }
            if (!TextUtils.isEmpty(applicationInfo.sourceDir) && !applicationInfo.sourceDir.startsWith("/data/")) {
                return true;
            }
            Object objA = Almond.a(ApplicationInfo.class, "seInfo", applicationInfo);
            if (objA instanceof String) {
                String str = (String) objA;
                if (str.contains("partition=product") || str.contains("partition=system_ext")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(StringBuilder sb, AccessibilityServiceInfo accessibilityServiceInfo) {
        sb.append(Integer.toHexString(accessibilityServiceInfo.eventTypes));
        sb.append(":");
        sb.append(Integer.toHexString(accessibilityServiceInfo.feedbackType));
        sb.append(":");
        sb.append(Integer.toHexString(accessibilityServiceInfo.flags));
        sb.append(":");
        sb.append(Integer.toHexString(accessibilityServiceInfo.getCapabilities()));
        sb.append(":");
        sb.append(accessibilityServiceInfo.getId());
    }
}
