package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.NativeImpl;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.hms.ads.ex;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zm.fda.Z200O.ZZ00Z;
import defpackage.s07;
import defpackage.u37;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class qz6 {
    public static volatile qz6 h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20361a;
    public f c;
    public HashMap<String, f> d;
    public int b = -1;
    public volatile boolean e = false;
    public Runnable f = new c();
    public Runnable g = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements s07.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v77 f20362a;
        public final /* synthetic */ File b;
        public final /* synthetic */ f c;

        public a(v77 v77Var, File file, f fVar) {
            this.f20362a = v77Var;
            this.b = file;
            this.c = fVar;
        }

        @Override // s07.a
        public void a(JSONObject jSONObject) {
            com.apm.lite.j.e.g(this.f20362a.a(), jSONObject.toString(), new File(this.b, "logZip"), wi7.c(qz6.this.f20361a, this.c.f20367a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements s07.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f20363a;
        public final /* synthetic */ f b;

        public b(File file, f fVar) {
            this.f20363a = file;
            this.b = fVar;
        }

        @Override // s07.a
        public void a(JSONObject jSONObject) {
            y77.a().c(jSONObject, this.f20363a, wi7.c(qz6.this.f20361a, this.b.f20367a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            qz6.this.w();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            qz6.this.u();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f20366a;
        public long b;
        public long c;
        public CrashType d;
        public String e;

        public e(File file, long j, CrashType crashType) {
            this.c = -1L;
            this.f20366a = file;
            this.b = j;
            this.d = crashType;
            this.e = file.getName();
        }

        public e(File file, CrashType crashType) {
            this.b = -1L;
            this.c = -1L;
            this.f20366a = file;
            this.d = crashType;
            this.e = file.getName();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20367a;
        public e d;
        public e e;
        public List<e> b = new ArrayList();
        public List<e> c = new ArrayList();
        public boolean f = false;
        public int g = 0;

        public f(String str) {
            this.f20367a = str;
        }
    }

    public qz6(Context context) {
        this.f20361a = context;
    }

    public static qz6 a() {
        if (h == null) {
            synchronized (qz6.class) {
                if (h == null) {
                    h = new qz6(x97.m());
                }
            }
        }
        return h;
    }

    public final v77 b(File file, CrashType crashType, String str, long j, long j2) {
        v77 v77Var;
        try {
            try {
                if (file.isFile()) {
                    re7.r(file);
                    return null;
                }
                boolean z = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return re7.C(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        v77Var = null;
                        re7.r(file);
                        n37.a();
                        n37.b("NPTH_CATCH", th);
                        return v77Var;
                    }
                }
                v77 v77VarB = re7.b(file, crashType);
                try {
                    JSONObject jSONObjectF = v77VarB.f();
                    if (v77VarB.f() == null) {
                        re7.r(file);
                    } else {
                        if (crashType == CrashType.ANR) {
                            return v77VarB;
                        }
                        jSONObjectF.put("crash_time", j);
                        jSONObjectF.put("app_start_time", j2);
                        JSONObject jSONObjectOptJSONObject = jSONObjectF.optJSONObject("header");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = q37.b(this.f20361a, j).s();
                        } else if (z) {
                            jSONObjectF.remove("header");
                        }
                        String strOptString = jSONObjectOptJSONObject.optString("sdk_version_name", null);
                        if (strOptString == null) {
                            strOptString = "0.0.1-rc.3";
                        }
                        ev6.k(jSONObjectF, "filters", "sdk_version", strOptString);
                        if (re7.t(jSONObjectF.optJSONArray("logcat"))) {
                            jSONObjectF.put("logcat", hf7.b(str));
                        }
                        ev6.k(jSONObjectF, "filters", "has_dump", ex.Code);
                        ev6.k(jSONObjectF, "filters", "has_logcat", String.valueOf(!gg7.h(jSONObjectF, "logcat")));
                        ev6.k(jSONObjectF, "filters", "memory_leak", String.valueOf(ev6.v(str)));
                        ev6.k(jSONObjectF, "filters", "fd_leak", String.valueOf(ev6.z(str)));
                        ev6.k(jSONObjectF, "filters", "threads_leak", String.valueOf(ev6.B(str)));
                        ev6.k(jSONObjectF, "filters", "is_64_devices", String.valueOf(q37.f()));
                        ev6.k(jSONObjectF, "filters", "is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));
                        ev6.k(jSONObjectF, "filters", "is_x86_devices", String.valueOf(q37.j()));
                        ev6.k(jSONObjectF, "filters", "has_meminfo_file", String.valueOf(ev6.p(str)));
                        ev6.k(jSONObjectF, "filters", "is_root", String.valueOf(w37.y()));
                        jSONObjectF.put("launch_did", gv6.a(this.f20361a));
                        jSONObjectF.put("crash_uuid", file.getName());
                        jSONObjectF.put("jiffy", ph7.a());
                        try {
                            long j3 = Long.parseLong(x07.a(j, str));
                            ev6.k(jSONObjectF, "filters", "lastAliveTime", Math.abs(j3 - j) < 60000 ? "< 60s" : "> 60s");
                            jSONObjectF.put("lastAliveTime", String.valueOf(j3));
                        } catch (Throwable unused) {
                            jSONObjectF.put("lastAliveTime", "unknown");
                            ev6.k(jSONObjectF, "filters", "lastAliveTime", "unknown");
                        }
                        jSONObjectF.put("has_dump", ex.Code);
                        if (jSONObjectF.opt("storage") == null) {
                            ev6.n(jSONObjectF, am7.b(x97.m()));
                        }
                        if (q37.n(jSONObjectOptJSONObject)) {
                            ev6.k(jSONObjectF, "filters", "unauthentic_version", "unauthentic_version");
                        }
                        v77VarB.f().put("upload_scene", "launch_scan");
                        if (z) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObjectF.put("event_type", "start_crash");
                            jSONObjectF.put(SharePluginInfo.ISSUE_TRACE_STACK, jSONObjectF.remove("data"));
                            jSONObject.put("data", new JSONArray().put(jSONObjectF));
                            jSONObject.put("header", jSONObjectOptJSONObject);
                            v77VarB.d(jSONObject);
                        } else {
                            jSONObjectF.put("isJava", 1);
                        }
                    }
                    return v77VarB;
                } catch (Throwable th2) {
                    th = th2;
                    v77Var = v77VarB;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            v77Var = null;
        }
        re7.r(file);
        n37.a();
        n37.b("NPTH_CATCH", th);
        return v77Var;
    }

    public final JSONObject c(w37 w37Var) {
        JSONObject jSONObjectK = w37Var.k();
        if (jSONObjectK != null && jSONObjectK.length() != 0) {
            return jSONObjectK;
        }
        if (x97.j()) {
            w37Var.x();
        }
        if (!w37Var.j()) {
            w37Var.w();
            return null;
        }
        if (!w37Var.p()) {
            w37Var.w();
            return null;
        }
        if (w37Var.r()) {
            w37Var.w();
            return null;
        }
        w37Var.m();
        return w37Var.v();
    }

    public final void d(f fVar) {
        re7.r(wi7.c(this.f20361a, fVar.f20367a));
        re7.r(wi7.h(this.f20361a, fVar.f20367a));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[Catch: all -> 0x0161, PHI: r13
      0x0094: PHI (r13v1 java.io.File) = (r13v2 java.io.File), (r13v3 java.io.File) binds: [B:34:0x00a3, B:30:0x0092] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0161, blocks: (B:14:0x0045, B:16:0x004b, B:17:0x0050, B:20:0x0057, B:25:0x0063, B:27:0x0074, B:33:0x009b, B:37:0x00af, B:39:0x00b3, B:44:0x00c7, B:56:0x010c, B:51:0x00ef, B:46:0x00cb, B:53:0x00f8, B:55:0x0106, B:31:0x0094, B:29:0x0082, B:48:0x00d3), top: B:74:0x0045, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(f fVar, boolean z, fe7 fe7Var) {
        Iterator<e> it;
        JSONObject jSONObjectF;
        JSONObject jSONObjectOptJSONObject;
        File file;
        if (fVar.b.isEmpty()) {
            return;
        }
        if (fVar.e == null) {
            fVar.e = fVar.d;
        }
        Iterator<e> it2 = fVar.b.iterator();
        while (it2.hasNext()) {
            e next = it2.next();
            try {
                File file2 = next.f20366a;
                CrashType crashType = next.d;
                it = it2;
                try {
                    v77 v77VarB = b(file2, crashType, fVar.f20367a, next.b, next.c);
                    if (v77VarB == null || (jSONObjectF = v77VarB.f()) == null || (jSONObjectOptJSONObject = jSONObjectF.optJSONObject("header")) == null) {
                        re7.r(file2);
                    } else {
                        if (crashType == null) {
                            file = file2;
                            if (new File(file, file2.getName()).exists() || file.getName().split("_").length < 5) {
                                if (com.apm.lite.j.e.e(v77VarB.a(), jSONObjectF.toString(), false).a()) {
                                    re7.r(file);
                                }
                            }
                        } else {
                            file = file2;
                        }
                        File fileA = s07.a(file);
                        if (fileA.exists()) {
                            try {
                                JSONArray jSONArray = new JSONArray(re7.y(fileA));
                                JSONObject jSONObjectOptJSONObject2 = crashType == CrashType.LAUNCH ? ((JSONArray) jSONObjectF.opt("data")).optJSONObject(0) : jSONObjectF;
                                if ((!z && fVar.e != next) || next.e.contains("ignore")) {
                                    try {
                                        ev6.k(jSONObjectOptJSONObject2, "filters", "aid", String.valueOf(jSONObjectOptJSONObject.opt("aid")));
                                        ev6.k(jSONObjectOptJSONObject2, "filters", "has_ignore", String.valueOf(next.e.contains("ignore")));
                                    } catch (Throwable th) {
                                        n37.a();
                                        n37.b("NPTH_CATCH", th);
                                    }
                                } else if (fe7Var != null && !fe7Var.c(jSONObjectOptJSONObject2.optString(ZZ00Z.s, MapController.DEFAULT_LAYER_TAG))) {
                                    re7.r(next.f20366a);
                                }
                                ev6.k(jSONObjectOptJSONObject2, "filters", "start_uuid", fVar.f20367a);
                                ev6.k(jSONObjectOptJSONObject2, "filters", "leak_threads_count", String.valueOf(fVar.g));
                                ev6.k(jSONObjectOptJSONObject2, "filters", "crash_thread_name", jSONObjectOptJSONObject2.optString("crash_thread_name", "unknown"));
                                try {
                                    s07.i(jSONObjectF, jSONArray, new a(v77VarB, file, fVar));
                                    if (!re7.r(file)) {
                                        av6.a().b(bv6.a(file.getAbsolutePath()));
                                    }
                                    nd7.b(wi7.h(x97.m(), fVar.f20367a), file.getName());
                                    u37.b(crashType, jSONObjectF);
                                } catch (Throwable th2) {
                                    th = th2;
                                    n37.a();
                                    n37.b("NPTH_CATCH", th);
                                    re7.r(next.f20366a);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                it = it2;
            }
            it2 = it;
        }
    }

    public final void h(HashMap<String, f> map) {
        File[] fileArrListFiles = wi7.u(this.f20361a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (file.isDirectory() && file.getName().endsWith(WkAdxAdConfigMg.DSP_NAME_GDT)) {
                    String name = file.getName();
                    f fVar = map.get(name);
                    if (fVar == null) {
                        fVar = new f(name);
                        map.put(name, fVar);
                    }
                    JSONArray jSONArrayB = z77.b(wi7.I(file), wi7.J(file));
                    int length = jSONArrayB.length();
                    fVar.g = length;
                    if (length > 0) {
                        try {
                            re7.l(wi7.K(file), jSONArrayB, false);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    re7.r(file);
                }
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
                re7.r(file);
            }
        }
    }

    public final void i(HashMap<String, f> map, f fVar) {
        File[] fileArrListFiles = wi7.o(this.f20361a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (file.isDirectory() && file.getName().endsWith(WkAdxAdConfigMg.DSP_NAME_GDT)) {
                    String name = file.getName();
                    f fVar2 = map.get(name);
                    if (fVar2 == null) {
                        fVar2 = new f(name);
                        map.put(name, fVar2);
                    }
                    fVar2.c.add(new e(file, CrashType.NATIVE));
                } else {
                    re7.r(file);
                }
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
                re7.r(file);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(HashMap<String, f> map, f fVar, File file, String str) {
        if (!str.endsWith(WkAdxAdConfigMg.DSP_NAME_GDT)) {
            re7.r(file);
            return;
        }
        String[] strArrSplit = str.split("_");
        CrashType crashType = null;
        if (strArrSplit.length < 5) {
            fVar.b.add(new e(file, null));
            return;
        }
        try {
            long j = Long.parseLong(strArrSplit[0]);
            long j2 = Long.parseLong(strArrSplit[4]);
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[1];
            str3.hashCode();
            switch (str3) {
                case "launch":
                    crashType = CrashType.LAUNCH;
                    break;
                case "anr":
                    crashType = CrashType.ANR;
                    break;
                case "java":
                    crashType = CrashType.JAVA;
                    break;
            }
            f fVar2 = map.get(str2);
            if (fVar2 == null) {
                fVar2 = new f(str2);
                map.put(str2, fVar2);
            }
            e eVar = new e(file, j, crashType);
            eVar.c = j2;
            e eVar2 = fVar2.d;
            if ((eVar2 == null || eVar2.b > eVar.b) && crashType != null && crashType != CrashType.ANR && !str.contains("ignore")) {
                fVar2.d = eVar;
            }
            fVar2.b.add(eVar);
        } catch (Throwable unused) {
            fVar.b.add(new e(file, null));
            n37.a();
            n37.b("NPTH_CATCH", new RuntimeException("err format crashTime:" + str));
        }
    }

    public void k(boolean z) throws Throwable {
        if (!Npth.isStopUpload() && z) {
            t();
            y();
        }
    }

    public final boolean l(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        try {
            if (!this.e && kv6.k(x97.m())) {
                ih7.b().e(this.g);
            }
        } catch (Throwable unused) {
        }
    }

    public final void n(f fVar, boolean z, fe7 fe7Var) {
        Iterator<e> it;
        boolean z2;
        JSONObject jSONObjectC;
        if (fVar.c.size() <= 1 && fVar.c.isEmpty()) {
            fVar.e = fVar.d;
            return;
        }
        boolean zC = yi7.c(this.f20361a);
        fVar.e = fVar.d;
        w37 w37Var = new w37(this.f20361a);
        Iterator<e> it2 = fVar.c.iterator();
        while (it2.hasNext()) {
            e next = it2.next();
            File file = next.f20366a;
            try {
                w37Var.e(file);
                jSONObjectC = c(w37Var);
            } catch (Throwable th) {
                th = th;
                it = it2;
            }
            if (jSONObjectC == null || jSONObjectC.length() == 0) {
                it = it2;
                z2 = zC;
            } else {
                if (jSONObjectC.length() != 0) {
                    if (z) {
                        it = it2;
                        z2 = zC;
                        if (fe7Var != null && !fe7Var.c(MapController.DEFAULT_LAYER_TAG)) {
                        }
                    } else {
                        long jOptLong = jSONObjectC.optLong("crash_time");
                        try {
                            e eVar = fVar.e;
                            if (eVar == null) {
                                fVar.e = next;
                                fVar.f = true;
                                if (fe7Var == null || fe7Var.c(MapController.DEFAULT_LAYER_TAG)) {
                                    it = it2;
                                    z2 = zC;
                                } else {
                                    w37Var.w();
                                }
                            } else {
                                it = it2;
                                try {
                                    if (fVar.f) {
                                        z2 = zC;
                                    } else {
                                        z2 = zC;
                                        try {
                                            if (jOptLong < eVar.b) {
                                                fVar.e = next;
                                                if (fe7Var == null || fe7Var.c(MapController.DEFAULT_LAYER_TAG)) {
                                                    if (!l(file)) {
                                                        g(file, fVar);
                                                    }
                                                    fVar.f = true;
                                                } else {
                                                    w37Var.w();
                                                    zC = z2;
                                                    it2 = it;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            n37.a();
                                            n37.b("NPTH_CATCH", th);
                                            re7.r(file);
                                            zC = z2;
                                            it2 = it;
                                        }
                                    }
                                    ev6.k(jSONObjectC, "filters", "aid", String.valueOf(jSONObjectC.optJSONObject("header").opt("aid")));
                                } catch (Throwable th3) {
                                    th = th3;
                                    z2 = zC;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            it = it2;
                            z2 = zC;
                            n37.a();
                            n37.b("NPTH_CATCH", th);
                            re7.r(file);
                            zC = z2;
                            it2 = it;
                        }
                    }
                    ev6.k(jSONObjectC, "filters", "start_uuid", fVar.f20367a);
                    ev6.k(jSONObjectC, "filters", "crash_thread_name", jSONObjectC.optString("crash_thread_name", "unknown"));
                    if (z2) {
                        try {
                            u37.b bVar = new u37.b(jSONObjectC, CrashType.NATIVE);
                            File fileA = s07.a(file);
                            JSONArray jSONArrayH = null;
                            try {
                                if (fileA.exists()) {
                                    jSONArrayH = new JSONArray(re7.y(fileA));
                                }
                            } catch (Throwable unused) {
                            }
                            if (jSONArrayH == null) {
                                jSONArrayH = xi7.d().h(bVar.b() == -1 ? System.currentTimeMillis() : bVar.b());
                            }
                            s07.i(jSONObjectC, s07.e(bVar.c(), bVar.a(), jSONArrayH), new b(file, fVar));
                            if (!w37Var.w()) {
                                w37Var.s();
                            }
                            nd7.b(wi7.h(x97.m(), fVar.f20367a), file.getName());
                        } catch (Throwable th5) {
                            th = th5;
                            n37.a();
                            n37.b("NPTH_CATCH", th);
                            re7.r(file);
                        }
                    }
                    u37.b(CrashType.NATIVE, jSONObjectC);
                } else {
                    it = it2;
                    z2 = zC;
                }
                zC = z2;
                it2 = it;
            }
            w37Var.w();
            zC = z2;
            it2 = it;
        }
    }

    public final void p(HashMap<String, f> map, f fVar) {
        File[] fileArrListFiles = wi7.b(this.f20361a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.sort(fileArrListFiles, Collections.reverseOrder());
        for (File file : fileArrListFiles) {
            try {
                if (av6.a().d(file.getAbsolutePath())) {
                    re7.r(file);
                } else if (!re7.G(file) && !st6.c().p(file.getName())) {
                    if (file.isFile()) {
                        re7.r(file);
                    } else {
                        j(map, fVar, file, file.getName());
                    }
                }
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
    }

    public final void r(HashMap<String, f> map, f fVar) {
        re7.r(wi7.g(this.f20361a));
    }

    public boolean s() {
        return this.e;
    }

    public final void t() throws Throwable {
        if (this.c != null) {
            return;
        }
        this.c = new f("old_uuid");
        HashMap<String, f> map = new HashMap<>();
        this.d = map;
        h(map);
        p(this.d, this.c);
        r(this.d, this.c);
        i(this.d, this.c);
        n(this.c, true, null);
        e(this.c, true, null);
        this.c = null;
        if (this.d.isEmpty()) {
            v();
        } else {
            w();
        }
    }

    public final void u() throws Throwable {
        if (this.e || this.d == null) {
            return;
        }
        if (!yi7.c(this.f20361a)) {
            v();
        }
        boolean zX = x();
        fe7 fe7Var = new fe7(this.f20361a);
        Iterator<f> it = this.d.values().iterator();
        while (it.hasNext()) {
            n(it.next(), zX, fe7Var);
        }
        Iterator<f> it2 = this.d.values().iterator();
        while (it2.hasNext()) {
            e(it2.next(), zX, fe7Var);
        }
        Iterator<f> it3 = this.d.values().iterator();
        while (it3.hasNext()) {
            d(it3.next());
        }
        re7.r(wi7.H(this.f20361a));
        fe7Var.a();
        x07.b();
        v();
    }

    public final void v() {
        this.e = true;
        this.d = null;
        NativeImpl.setUploadEnd();
    }

    public final void w() throws Throwable {
        if (this.e) {
            return;
        }
        if (!yi7.c(this.f20361a) || (System.currentTimeMillis() - x97.p() <= 5000 && !Npth.hasCrash())) {
            ih7.b().f(this.f, 5000L);
        } else {
            u();
        }
    }

    public final boolean x() {
        if (this.b == -1) {
            if (nv6.h() && nv6.o()) {
                this.b = 1;
            } else {
                this.b = 0;
            }
        }
        return this.b == 1;
    }

    public final void y() {
        File[] fileArrListFiles = wi7.B(this.f20361a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            if (file.getName().endsWith(".atmp")) {
                zu6.a().c(file.getAbsolutePath());
            } else {
                try {
                    v77 v77VarD = re7.D(file.getAbsolutePath());
                    if (v77VarD != null) {
                        if (v77VarD.f() != null) {
                            v77VarD.f().put("upload_scene", "launch_scan");
                        }
                        if (com.apm.lite.j.e.j(com.apm.lite.j.e.u(), v77VarD.l(), v77VarD.j(), v77VarD.n(), v77VarD.o())) {
                            re7.r(file);
                            re7.s(v77VarD.h());
                        }
                    } else {
                        re7.r(file);
                    }
                } catch (Throwable th) {
                    n37.a();
                    n37.b("NPTH_CATCH", th);
                }
            }
        }
    }

    public final void g(File file, f fVar) {
    }
}
