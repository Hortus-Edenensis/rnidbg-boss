package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.wifi.ad.core.config.DeviceInfoUtil;
import defpackage.hv1;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18064a;
    public static String b;
    public static ConcurrentHashMap<File, Boolean> c = new ConcurrentHashMap<>();
    public static final AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return (file.getName().length() == 24 || file.getName().equals("0")) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends xw2 {
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Context context) {
            super(str);
            this.c = context;
        }

        @Override // defpackage.xw2
        public void a() {
            hw4.m(this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends xw2 {
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Context context) {
            super(str);
            this.c = context;
        }

        @Override // defpackage.xw2
        public void a() {
            hw4.m(this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified < 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified < 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    public static void b(Context context, String... strArr) {
        FileFilter[] fileFilterArr;
        if (strArr == null || strArr.length == 0) {
            fileFilterArr = new FileFilter[1];
        } else {
            fileFilterArr = new FileFilter[strArr.length + 1];
            int i = 0;
            while (i < strArr.length) {
                int i2 = i + 1;
                fileFilterArr[i2] = hv1.a.a(strArr[i]);
                i = i2;
            }
        }
        fileFilterArr[0] = new hv1.a(false, true, "jpush_stat_history", 1);
        File[] fileArrF = hv1.f(context.getFilesDir(), fileFilterArr);
        if (fileArrF != null) {
            for (File file : fileArrF) {
                hv1.b(file);
            }
        }
    }

    public static String c(Context context) {
        String strE = fv2.e(context);
        if (TextUtils.isEmpty(strE)) {
            strE = "0";
        }
        return f(context) + File.separator + strE;
    }

    public static String d(File file) {
        try {
            File parentFile = file.getParentFile();
            StringBuilder sb = new StringBuilder();
            sb.append(parentFile.getParentFile().getName());
            String str = File.separator;
            sb.append(str);
            sb.append(parentFile.getName());
            sb.append(str);
            sb.append(file.getName());
            return sb.toString();
        } catch (Throwable unused) {
            return file.getAbsolutePath();
        }
    }

    public static FileFilter e() {
        return new a();
    }

    public static synchronized String f(Context context) {
        String str;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (f18064a == null) {
            String strI = ad.i(context);
            if (!TextUtils.isEmpty(strI)) {
                if (strI.equals(context.getPackageName())) {
                    f18064a = "";
                } else {
                    f18064a = strI.replaceFirst(context.getPackageName() + ":", "_");
                }
            }
        }
        if (f18064a != null) {
            str = "jpush_stat_history" + f18064a;
        } else {
            str = "jpush_stat_history";
        }
        File fileE = hv1.e(context, str);
        if (fileE != null) {
            String absolutePath = fileE.getAbsolutePath();
            b = absolutePath;
            return absolutePath;
        }
        return "jpush_stat_history" + f18064a;
    }

    public static void g(File file) {
        if (file != null) {
            c.put(file, Boolean.TRUE);
        }
    }

    public static File h(Context context, String str) {
        return new File(c(context) + str + File.separator + UUID.randomUUID().toString());
    }

    public static void i(Context context, File file) {
        if (((Long) lg5.c(context, zz2.K())).longValue() == 0) {
            k63.a("ReportHistory", "can't get uid, skip upload history");
            return;
        }
        File[] fileArrF = hv1.f(file, hv1.a.e);
        if (fileArrF == null || fileArrF.length == 0) {
            return;
        }
        LinkedList<File> linkedList = new LinkedList();
        for (File file2 : fileArrF) {
            if (!Boolean.TRUE.equals(c.get(file2))) {
                linkedList.add(file2);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        k63.a("ReportHistory", "process space=" + d(file) + " history[" + linkedList.size() + "]");
        Collections.sort(linkedList, new d());
        for (File file3 : linkedList) {
            try {
                JSONObject jSONObjectD = fw4.d(file3);
                if (jSONObjectD == null) {
                    hv1.c(file3);
                } else {
                    g(file3);
                    Set<String> setM = nw4.m(jSONObjectD);
                    k63.a("ReportHistory", "report history types=" + setM);
                    if (nw4.x(context, setM, jSONObjectD, file3, null) == -2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                k63.l("ReportHistory", "upload e:" + th);
            }
        }
    }

    public static void j(Context context, File file) {
        try {
            JSONObject jSONObjectI = nw4.i(context);
            if (zw2.c(jSONObjectI)) {
                return;
            }
            File[] fileArrF = hv1.f(new File(file, "nowrap"), hv1.a.e);
            if (fileArrF != null && fileArrF.length != 0) {
                k63.a("ReportHistory", "process space=" + d(file) + " nowrap[" + fileArrF.length + "]");
                File file2 = new File(file, "tmp");
                fw4 fw4VarB = fw4.b(fileArrF[0], jSONObjectI);
                for (int i = 1; i < fileArrF.length; i++) {
                    fw4 fw4VarB2 = fw4.b(fileArrF[i], jSONObjectI);
                    if (fw4VarB2 != null && (fw4VarB == null || !fw4VarB.c(fw4VarB2, file2))) {
                        fw4VarB = fw4VarB2;
                    }
                }
                if (fw4VarB != null) {
                    fw4VarB.c(null, file2);
                }
            }
        } catch (Throwable th) {
            k63.l("ReportHistory", "processNowrap e:" + th);
        }
    }

    public static void k(File file) {
        try {
            File[] fileArrF = hv1.f(new File(file, "tmp"), hv1.a.e);
            if (fileArrF != null && fileArrF.length != 0) {
                LinkedList linkedList = new LinkedList();
                for (File file2 : fileArrF) {
                    if (!Boolean.TRUE.equals(c.get(file2))) {
                        linkedList.add(file2);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                k63.a("ReportHistory", "process space=" + d(file) + " tmp[" + linkedList.size() + "]");
                Set<String> setS = s();
                HashMap map = new HashMap();
                fw4 fw4VarA = fw4.a(hv1.d(hv1.f(file, hv1.a.e)), setS);
                if (fw4VarA != null) {
                    map.put(String.valueOf(fw4VarA.d), fw4VarA);
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    fw4 fw4VarA2 = fw4.a((File) it.next(), setS);
                    if (fw4VarA2 != null) {
                        String strValueOf = String.valueOf(fw4VarA2.d);
                        fw4 fw4Var = (fw4) map.get(strValueOf);
                        if (fw4Var == null) {
                            map.put(strValueOf, fw4VarA2);
                        } else if (!fw4Var.c(fw4VarA2, file)) {
                            map.put(strValueOf, fw4VarA2);
                        }
                    }
                }
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    ((fw4) it2.next()).c(null, file);
                }
            }
        } catch (Throwable th) {
            k63.l("ReportHistory", "processTmp e:" + th);
        }
    }

    public static void l(File file) {
        if (file != null) {
            c.remove(file);
        }
    }

    public static void m(Context context) {
        try {
            d.set(true);
            File[] fileArrG = hv1.g(c(context), hv1.a.f);
            if (fileArrG != null) {
                for (File file : fileArrG) {
                    r(context, file);
                }
            } else {
                k63.a("ReportHistory", "no history, no report");
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static File n(Context context, String str, JSONObject jSONObject, boolean z) {
        File fileH = h(context, str);
        if (z) {
            g(fileH);
        }
        hv1.j(fileH, jSONObject.toString());
        return fileH;
    }

    public static void o(Context context) {
        if (d.get()) {
            k63.a("ReportHistory", "isRunning, no need report");
        } else if (TextUtils.isEmpty(sv2.b(context)) || !context.getPackageName().equals(ad.i(context))) {
            wz4.a("NORMAL_TASK", new c("ReportHistory#submitReportAll", context));
        } else {
            wz4.a("MAJOR_TASK", new b("ReportHistory#submitReportAll", context));
        }
    }

    public static void p(File file) {
        int length = 0;
        File[] fileArrF = hv1.f(file, hv1.a.e);
        if (fileArrF == null || fileArrF.length <= 1) {
            return;
        }
        List<File> listAsList = Arrays.asList(fileArrF);
        Collections.sort(listAsList, new e());
        for (File file2 : listAsList) {
            length = (int) (((long) length) + file2.length());
            if (length > 1048576) {
                hv1.c(file2);
            }
        }
        if (listAsList.size() < fileArrF.length) {
            k63.a("ReportHistory", "trim space history=" + d(file) + "," + fileArrF.length + " to " + listAsList.size());
        }
    }

    public static void q(Context context) {
        hv1.a aVar = new hv1.a(false, true, "jpush_stat_history", 1);
        String strE = fv2.e(context);
        File[] fileArrF = hv1.f(context.getFilesDir(), aVar, e());
        if (fileArrF != null) {
            for (File file : fileArrF) {
                try {
                    hv1.b(new File(file, "nowrap"));
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getParent());
                    String str = File.separator;
                    sb.append(str);
                    sb.append(strE);
                    sb.append(str);
                    sb.append(file.getName());
                    File file2 = new File(sb.toString());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                } catch (Throwable th) {
                    k63.a("updateByAppKey", "e=" + th);
                }
            }
        }
    }

    public static void r(Context context, File file) {
        k63.a("ReportHistory", "upload space=" + d(file));
        j(context, file);
        k(file);
        i(context, file);
        p(file);
    }

    public static Set<String> s() {
        HashSet hashSet = new HashSet();
        hashSet.add(DeviceInfoUtil.UID_TAG);
        hashSet.add("app_key");
        hashSet.add(HiAnalyticsConstant.BI_KEY_SDK_VER);
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject jSONObject = new JSONObject();
        f5.c().e(jSONObject);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            hashSet.add(itKeys.next());
        }
        return hashSet;
    }
}
