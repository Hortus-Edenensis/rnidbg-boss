package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static Set<String> aTT;

    static {
        HashSet hashSet = new HashSet();
        aTT = hashSet;
        hashSet.add("commonHT");
        aTT.add("reportHT");
        aTT.add("IpDirectHelper");
        aTT.add("filedownloader serial thread");
        aTT.add("RemitHandoverToDB");
        aTT.add("source-status-callback");
        aTT.add("ObiwanMMAPTracer");
        aTT.add("FrameSequence decoding thread");
    }

    private static boolean I(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] strArrNk = e.Nj().Nk();
        if (strArrNk == null || strArrNk.length == 0) {
            return true;
        }
        boolean zA = false;
        for (String str : strArrNk) {
            zA = a(stackTraceElementArr, str);
            if (zA) {
                break;
            }
        }
        if (zA) {
            for (String str2 : e.Nj().Nl()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return zA;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean fQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return fR(str) || str.startsWith("ksad-") || str.startsWith("filedownloader serial thread");
    }

    private static boolean fR(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("kwad.kwadsdk")) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadStr:" + str);
        return true;
    }

    public static boolean fS(String str) {
        if (fQ(str) || i.cd(str)) {
            return true;
        }
        Set<String> set = aTT;
        if (set == null || !set.contains(str)) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadName:" + str);
        return true;
    }

    public static boolean fT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArrNk = e.Nj().Nk();
        if (strArrNk == null || strArrNk.length == 0) {
            return true;
        }
        boolean zContains = false;
        for (String str2 : strArrNk) {
            zContains = str.contains(str2);
            if (zContains) {
                break;
            }
        }
        if (zContains) {
            for (String str3 : e.Nj().Nl()) {
                if (str.contains(str3)) {
                    return false;
                }
            }
        }
        return zContains;
    }

    public static boolean o(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return I(arrayList);
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
