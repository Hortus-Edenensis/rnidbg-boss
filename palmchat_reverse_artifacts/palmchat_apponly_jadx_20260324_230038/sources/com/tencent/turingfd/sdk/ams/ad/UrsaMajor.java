package com.tencent.turingfd.sdk.ams.ad;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UrsaMajor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f10747a = new ArrayList();

    public static synchronized List<String> a(ITuringPkgProvider iTuringPkgProvider) {
        List<String> list;
        List<String> pkgs;
        list = f10747a;
        if (((ArrayList) list).isEmpty() && iTuringPkgProvider != null && (pkgs = iTuringPkgProvider.getPkgs()) != null && !pkgs.isEmpty()) {
            ((ArrayList) list).addAll(pkgs);
        }
        return list;
    }

    public static String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        try {
            for (String str : set) {
                if (sb.length() > 0) {
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                sb.append(str);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
