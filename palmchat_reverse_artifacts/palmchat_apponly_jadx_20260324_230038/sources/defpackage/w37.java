package defpackage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashFilter;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.ads.ex;
import com.zm.fda.Z200O.ZZ00Z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class w37 {
    public static Boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21601a;
    public JSONObject b = null;
    public b c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static String b(File file) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        wf7.a(bufferedReader2);
                        return "";
                    }
                    if (line.startsWith("[FATAL:jni_android.cc") && line.contains("Please include Java exception stack in crash report ttwebview:")) {
                        StringBuilder sb = new StringBuilder();
                        int iIndexOf = line.indexOf(" ttwebview:");
                        sb.append("Caused by: ");
                        sb.append("Please include Java exception stack in crash report");
                        sb.append("\n");
                        sb.append(line.substring(iIndexOf + 11));
                        while (true) {
                            sb.append("\n");
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null) {
                                String string = sb.toString();
                                wf7.a(bufferedReader2);
                                return string;
                            }
                            sb.append(line2);
                        }
                    } else {
                        wf7.a(bufferedReader2);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        n37.a();
                        n37.b("NPTH_CATCH", th);
                    } finally {
                        wf7.a(bufferedReader);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ba7 f21602a;
        public final lv6 b;
        public final File c;
        public final File d;

        public b(File file) {
            this.c = file;
            this.d = wi7.c(x97.m(), file.getName());
            lv6 lv6Var = new lv6(file);
            this.b = lv6Var;
            ba7 ba7Var = new ba7(file);
            this.f21602a = ba7Var;
            if (lv6Var.a() && ba7Var.a() == null) {
                ba7Var.b(file);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long a() {
            Map<String, String> mapC = this.b.c();
            if (mapC != null) {
                try {
                    String str = !mapC.isEmpty() ? mapC.get(com.umeng.analytics.pro.f.p) : null;
                    if (str != null) {
                        return Long.parseLong(str);
                    }
                } catch (Throwable th) {
                    n37.a();
                    n37.b("NPTH_CATCH", th);
                }
            }
            return System.currentTimeMillis();
        }

        public File d() {
            return this.c;
        }

        public boolean f() {
            return this.b.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends e {
        public c() {
            super();
            this.b = "Total FD Count:";
            this.f21603a = wi7.C(w37.this.c.d());
            this.c = ":";
            this.d = -2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends e {
        public d() {
            super();
            this.b = "VmSize:";
            this.f21603a = wi7.G(w37.this.c.d());
            this.c = "\\s+";
            this.d = -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f21603a;
        public String b;
        public String c;
        public int d;

        public e() {
        }

        public int a() {
            Throwable th;
            int i;
            if (!this.f21603a.exists() || !this.f21603a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f21603a));
                int iB = -1;
                do {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        iB = b(line);
                    } catch (Throwable th2) {
                        th = th2;
                        i = iB;
                        bufferedReader = bufferedReader2;
                        try {
                            n37.a();
                            n37.b("NPTH_CATCH", th);
                            return i;
                        } finally {
                            if (bufferedReader != null) {
                                wf7.a(bufferedReader);
                            }
                        }
                    }
                } while (iB == -1);
                wf7.a(bufferedReader2);
                return iB;
            } catch (Throwable th3) {
                th = th3;
                i = -1;
            }
        }

        public int b(String str) {
            int i = this.d;
            if (!str.startsWith(this.b)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.c)[1].trim());
            } catch (NumberFormatException e) {
                n37.a();
                n37.b("NPTH_CATCH", e);
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends e {
        public f() {
            super();
            this.b = "Total Threads Count:";
            this.f21603a = wi7.D(w37.this.c.d());
            this.c = ":";
            this.d = -2;
        }
    }

    public w37(Context context) {
        this.f21601a = context;
    }

    public static long u() {
        if (NativeImpl.is64BitRuntime()) {
            return Long.MAX_VALUE;
        }
        return q37.f() ? 3891200L : 2867200L;
    }

    public static boolean y() {
        Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i = 0; i < 11; i++) {
            try {
                if (new File(strArr[i]).exists()) {
                    d = Boolean.TRUE;
                    return true;
                }
                continue;
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
        d = Boolean.FALSE;
        return false;
    }

    public final int A() {
        return new c().a();
    }

    public final int B() {
        return new f().a();
    }

    public final int C() {
        return new d().a();
    }

    public final String b(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append((CharSequence) str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
        return sb.toString().toUpperCase();
    }

    public Map<String, String> c() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.b.c();
        }
        return null;
    }

    public final void d(ev6 ev6Var) {
        ev6Var.d(z());
        ev6Var.j("is_native_crash", 1);
        ev6Var.j("repack_time", Long.valueOf(System.currentTimeMillis()));
        ev6Var.j("crash_uuid", this.c.d().getName());
        ev6Var.j("jiffy", Long.valueOf(ph7.a()));
    }

    public void e(File file) {
        this.c = new b(file);
    }

    public final void f(Map<String, String> map) {
        boolean zExists = wi7.C(this.c.d()).exists();
        String str = ex.Code;
        map.put("has_fds_file", zExists ? ex.Code : ex.V);
        File fileA = wi7.A(this.c.d());
        map.put("has_logcat_file", (!fileA.exists() || fileA.length() <= 128) ? ex.V : ex.Code);
        map.put("has_maps_file", wi7.p(this.c.d()).exists() ? ex.Code : ex.V);
        map.put("has_tombstone_file", wi7.i(this.c.d()).exists() ? ex.Code : ex.V);
        map.put("has_meminfo_file", wi7.G(this.c.d()).exists() ? ex.Code : ex.V);
        if (!wi7.D(this.c.d()).exists()) {
            str = ex.V;
        }
        map.put("has_threads_file", str);
    }

    public String g() {
        b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        String strE = bVar.f21602a.e();
        return (strE == null || strE.isEmpty()) ? this.c.b.b() : strE;
    }

    public final void h(ev6 ev6Var) {
        HashMap map = new HashMap();
        if (y()) {
            map.put("is_root", ex.Code);
            ev6Var.j("is_root", ex.Code);
        } else {
            map.put("is_root", ex.V);
            ev6Var.j("is_root", ex.V);
        }
        f(map);
        int iA = A();
        if (iA > 0) {
            if (iA > 960) {
                map.put("fd_leak", ex.Code);
            } else {
                map.put("fd_leak", ex.V);
            }
            ev6Var.j("fd_count", Integer.valueOf(iA));
        }
        int iB = B();
        if (iB > 0) {
            if (iB > 350) {
                map.put("threads_leak", ex.Code);
            } else {
                map.put("threads_leak", ex.V);
            }
            ev6Var.j("threads_count", Integer.valueOf(iB));
        }
        int iC = C();
        if (iC > 0) {
            if (iC > u()) {
                map.put("memory_leak", ex.Code);
            } else {
                map.put("memory_leak", ex.V);
            }
            ev6Var.j("memory_size", Integer.valueOf(iC));
        }
        map.put("sdk_version", "0.0.1-rc.3");
        map.put("has_java_stack", String.valueOf(ev6Var.G().opt("java_data") != null));
        JSONArray jSONArrayB = z77.b(wi7.I(this.c.c), wi7.J(this.c.c));
        map.put("leak_threads_count", String.valueOf(jSONArrayB.length()));
        if (jSONArrayB.length() > 0) {
            try {
                re7.l(wi7.K(this.c.c), jSONArrayB, false);
            } catch (Throwable unused) {
            }
        }
        ev6Var.t();
        ev6Var.x();
        ev6Var.w(map);
    }

    public final void i(ev6 ev6Var) {
        Map<String, String> mapC = this.c.f21602a.c();
        if (mapC.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : mapC.keySet()) {
            String strB = b(mapC.get(str));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lib_name", str);
                jSONObject.put("lib_uuid", strB);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                n37.a();
                n37.b("NPTH_CATCH", e2);
            }
        }
        ev6Var.j("crash_lib_uuid", jSONArray);
    }

    public boolean j() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.f();
        }
        return false;
    }

    public JSONObject k() {
        File fileV = wi7.v(this.c.d());
        if (!fileV.exists()) {
            return null;
        }
        try {
            String strZ = re7.z(fileV.getAbsolutePath());
            if (strZ != null && !strZ.isEmpty()) {
                return new JSONObject(strZ);
            }
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
        return null;
    }

    public final void l(ev6 ev6Var) {
        File fileS = wi7.s(this.c.d());
        if (!fileS.exists() && this.b == null) {
            ev6Var.s(am7.b(x97.m()));
            ev6Var.e("has_callback", ex.V);
            return;
        }
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                jSONObject = new JSONObject(re7.z(fileS.getAbsolutePath()));
            }
            ev6Var.y(jSONObject);
            ev6Var.e("has_callback", ex.Code);
            if (ev6Var.G().opt("storage") == null) {
                ev6Var.s(am7.b(x97.m()));
            }
            uj7.a(ev6Var, ev6Var.H(), CrashType.NATIVE);
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
        long j = -1;
        long jOptLong = ev6Var.G().optLong("crash_time", -1L);
        long jOptLong2 = ev6Var.G().optLong("java_end", -1L);
        if (jOptLong2 != -1 && jOptLong != -1) {
            j = jOptLong2 - jOptLong;
        }
        try {
            ev6Var.q("total_cost", String.valueOf(j));
            ev6Var.e("total_cost", String.valueOf(j / 1000));
        } catch (Throwable unused) {
        }
    }

    public void m() {
        try {
            File fileS = wi7.s(this.c.d());
            File file = new File(fileS.getAbsolutePath() + ".tmp'");
            if (file.exists()) {
                file.delete();
            }
            int i = 0;
            if (fileS.exists()) {
                while (i < mz6.a()) {
                    File file2 = new File(fileS.getAbsolutePath() + '.' + i);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    i++;
                }
                return;
            }
            ev6 ev6Var = new ev6();
            for (int i2 = 0; i2 < mz6.a(); i2++) {
                File file3 = new File(fileS.getAbsolutePath() + '.' + i2);
                if (file3.exists()) {
                    try {
                        String strZ = re7.z(file3.getAbsolutePath());
                        if (!TextUtils.isEmpty(strZ)) {
                            JSONObject jSONObject = new JSONObject(strZ);
                            if (jSONObject.length() > 0) {
                                ev6Var.y(jSONObject);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            JSONObject jSONObjectG = ev6Var.G();
            try {
                if (jSONObjectG.length() != 0 && jSONObjectG.opt("storage") == null) {
                    ev6.n(jSONObjectG, am7.b(x97.m()));
                }
            } catch (Throwable unused2) {
            }
            if (jSONObjectG.length() != 0) {
                this.b = jSONObjectG;
                re7.w(file, jSONObjectG, false);
                if (file.renameTo(fileS)) {
                    while (i < mz6.a()) {
                        File file4 = new File(fileS.getAbsolutePath() + '.' + i);
                        if (file4.exists()) {
                            file4.delete();
                        }
                        i++;
                    }
                }
            }
        } catch (IOException e2) {
            n37.a();
            n37.b("NPTH_CATCH", e2);
        }
    }

    public final void n(ev6 ev6Var) {
        String strA;
        File fileY = wi7.y(this.c.d());
        if (fileY.exists()) {
            try {
                strA = yl7.a(fileY.getAbsolutePath());
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
                strA = "";
            }
        } else {
            strA = "";
        }
        File fileL = wi7.L(this.c.d());
        if (fileL.exists()) {
            String strB = a.b(fileL);
            if (strA.isEmpty()) {
                strA = strB;
            } else {
                strA = strA + "\n" + strB;
            }
        }
        try {
            if (strA.isEmpty()) {
                return;
            }
            ev6Var.j("java_data", strA);
        } catch (Throwable th2) {
            n37.a();
            n37.b("NPTH_CATCH", th2);
        }
    }

    public final void o(ev6 ev6Var) {
        File fileD = wi7.d(this.c.d());
        if (fileD.exists()) {
            try {
                ev6Var.j("native_log", re7.v(re7.g(fileD.getAbsolutePath(), "\n"), "\n"));
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
    }

    public boolean p() {
        ICrashFilter iCrashFilterC = x97.f().c();
        if (iCrashFilterC == null) {
            return true;
        }
        try {
            return iCrashFilterC.onNativeCrashFilter(g(), "");
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
            return true;
        }
    }

    public final void q(ev6 ev6Var) {
        File fileA = wi7.A(this.c.d());
        if (!fileA.exists()) {
            NativeImpl.dumpLogcat(fileA.getAbsolutePath(), String.valueOf(x97.o().getLogcatDumpCount()), String.valueOf(x97.o().getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String str = " " + this.c.b.c().get("pid") + " ";
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileA));
            try {
                if (fileA.length() > ZZ00Z.y) {
                    bufferedReader2.skip(fileA.length() - ZZ00Z.y);
                }
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    if ((line.length() > 32 ? line.substring(0, 31) : line).contains(str)) {
                        jSONArray.put(line);
                    }
                }
                wf7.a(bufferedReader2);
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                wf7.a(bufferedReader);
            }
        } catch (Throwable unused2) {
        }
        ev6Var.j("logcat", jSONArray);
    }

    public boolean r() {
        return av6.a().d(wi7.v(this.c.d()).getAbsolutePath());
    }

    public void s() {
        av6.a().b(bv6.a(wi7.v(this.c.d()).getAbsolutePath()));
    }

    public final void t(ev6 ev6Var) {
        Map<String, String> mapC = c();
        if (mapC == null || ev6Var == null) {
            return;
        }
        String str = mapC.get(ContentProviderManager.PLUGIN_PROCESS_NAME);
        if (str != null) {
            ev6Var.j(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
        }
        String str2 = mapC.get(com.umeng.analytics.pro.f.p);
        if (str2 != null) {
            try {
                ev6Var.b(Long.decode(str2).longValue());
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
        String str3 = mapC.get("pid");
        if (str3 != null) {
            try {
                ev6Var.j("pid", Long.decode(str3));
            } catch (Throwable th2) {
                n37.a();
                n37.b("NPTH_CATCH", th2);
            }
        }
        String str4 = mapC.get("crash_thread_name");
        if (str4 != null) {
            ev6Var.j("crash_thread_name", str4);
        }
        String str5 = mapC.get("crash_time");
        if (str5 != null) {
            try {
                ev6Var.j("crash_time", Long.decode(str5));
            } catch (Throwable th3) {
                n37.a();
                n37.b("NPTH_CATCH", th3);
            }
        }
        ev6Var.j("data", g());
    }

    public JSONObject v() {
        try {
            ev6 ev6Var = new ev6();
            d(ev6Var);
            t(ev6Var);
            i(ev6Var);
            l(ev6Var);
            n(ev6Var);
            q(ev6Var);
            o(ev6Var);
            h(ev6Var);
            File fileV = wi7.v(this.c.d());
            JSONObject jSONObjectG = ev6Var.G();
            re7.m(fileV, jSONObjectG, false);
            return jSONObjectG;
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
            return null;
        }
    }

    public boolean w() {
        return re7.r(this.c.d());
    }

    public void x() {
        try {
            re7.A(this.c.d().getAbsolutePath(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/localDebug/" + x97.m().getPackageName() + "/" + this.c.d().getName() + ".zip");
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public final q37 z() {
        q37 q37Var = new q37(this.f21601a);
        JSONObject jSONObjectC = xi7.d().c(this.c.a());
        if (jSONObjectC != null) {
            q37Var.l(jSONObjectC);
            q37Var.o();
            q37Var.q();
        }
        q37.h(q37Var);
        return q37Var;
    }
}
