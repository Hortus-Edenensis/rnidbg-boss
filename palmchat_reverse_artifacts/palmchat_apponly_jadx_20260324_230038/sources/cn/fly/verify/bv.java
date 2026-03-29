package cn.fly.verify;

import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.ay;
import cn.fly.verify.fq;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2120a = ed.a("009@dl.fYdkdhdcdiee+dj");
    public static final String b = ed.a("010Mdl*f9dkdh@e+dgXj4dj9c)dc");
    public static final String c = ed.a("009:dl4f^dkdh@eDdg gdg");
    public static final String d = ed.a("0104dlOf4dkdhfh1eRdg[gdg");
    public static final String e = ed.a("011Adl-f+dkdhFjj(dheedj0iNdc");
    public static final String f = ed.a("031)dl9fLdkdh-ef3ecViPdhdgZjg3ed:d dcdhUdjjPdh*dciTdidd6fGdh0iMdidf%f");
    public static final String g = ed.a("025FdlSfPdkdhfedgefefMfBdj;f;dcdh,gDedIcdi1died>e;dhdfdchi");
    public static final String h = ed.a("038>dl:f?dkdh;ef-ec_iQdhdgRjg8ed<d!dcdhfedgefef-f)djLf!dcdhFg(ed3cdi'died6e-dh*i%didfOf");
    public static final String i = ed.a("014>ffdiefdidh+gdNfhZiVdhdi@eCefed");
    public static final String j = ed.a("018!dlHf>dkdhffdiefdidh7g0difh+iPdhKhdYfh*h");
    public static final String k = ed.a("030%dlUfYdkdh+efXec.i9dhdg4jgMedId=dcdhffdiefdidhDg=difhZi.dhJiDdidf-f");
    public static final String l = ed.a("012]dlSf1dkdhfhffdiTichf>fh");
    public static final String m = ed.a("022TdlKf^dkdhfhffdiXichf fhdh iUdidfQf=fhKid9dfXj");
    private static final String n = ed.a("019+dlLf?dkdh0djjAdh!dci^didd f$dh'iYdidf?f");
    private static final String o = ed.a("012?dl,fCdkdh chdeefgPfh");
    private static AtomicBoolean p = new AtomicBoolean(false);
    private static AtomicBoolean q = new AtomicBoolean(false);
    private static bv r;
    private gb s;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f2122a = ed.a("003=hcedfe");
        public static final String b = ed.a("011)dfedfedh:c;eddfdfedAe.fh");
        private static a c;
        private gb d;

        private a() {
            if (this.d == null) {
                gb gbVar = new gb(ax.g());
                this.d = gbVar;
                gbVar.a(f2122a, b, 1);
            }
        }

        public static boolean b() {
            try {
                File fileC = c();
                if (fileC == null || !fileC.exists()) {
                    return false;
                }
                return fileC.length() > 0;
            } catch (Throwable unused) {
                return false;
            }
        }

        public static File c() {
            if (ax.g() == null) {
                return null;
            }
            try {
                return new File(new File(ax.g().getFilesDir(), f2122a), b + "_1");
            } catch (Throwable th) {
                en.a().c(th);
                return null;
            }
        }

        public int a(String str, int i) {
            return this.d.b(str, i);
        }

        public HashMap<String, Object> d() {
            return this.d.a();
        }

        public static synchronized a a() {
            if (c == null) {
                c = new a();
            }
            return c;
        }
    }

    private bv() {
        if (this.s == null) {
            gb gbVar = new gb(ax.g());
            this.s = gbVar;
            gbVar.a("fvv_cms", 1);
        }
    }

    public static synchronized bv a() {
        if (r == null) {
            r = new bv();
        }
        return r;
    }

    public static File c() {
        if (ax.g() == null) {
            return null;
        }
        try {
            return new File(new File(ax.g().getFilesDir(), gb.f2382a), "fvv_cms_1");
        } catch (Throwable th) {
            en.a().c(th);
            return null;
        }
    }

    public static void s() {
        if (p.compareAndSet(false, true)) {
            new gi(ed.a("004Zfkikhkge")) { // from class: cn.fly.verify.bv.1
                @Override // cn.fly.verify.gi
                public void a() {
                    ConcurrentHashMap<String, Object> concurrentHashMapE;
                    Object obj = ea.i;
                    synchronized (obj) {
                        try {
                            obj.wait(600000L);
                            ds.a().a(11);
                            concurrentHashMapE = by.e();
                        } finally {
                        }
                        if (concurrentHashMapE != null && concurrentHashMapE.size() > 0) {
                            ds.a().a(12);
                            Object obj2 = concurrentHashMapE.get("h");
                            Object obj3 = concurrentHashMapE.get(com.kuaishou.weapon.p0.t.f7496a);
                            Object obj4 = concurrentHashMapE.get(ed.a("0010fe"));
                            Object obj5 = concurrentHashMapE.get("s");
                            Object obj6 = concurrentHashMapE.get(ed.a("002ce"));
                            Object obj7 = concurrentHashMapE.get(ed.a("002;ef*e"));
                            concurrentHashMapE.clear();
                            cn.a(obj2, obj3, obj4, obj5, obj6, obj7);
                        }
                    }
                }
            }.start();
        }
        u();
    }

    private static String t() {
        return fr.b(fq.d.j());
    }

    private static void u() {
        if (q.compareAndSet(false, true)) {
            new gi("DS-W") { // from class: cn.fly.verify.bv.2
                @Override // cn.fly.verify.gi
                public void a() {
                    Object obj = ea.j;
                    synchronized (obj) {
                        try {
                            obj.wait();
                            ConcurrentHashMap<String, Object> concurrentHashMapF = by.f();
                            ArrayList arrayList = (ArrayList) concurrentHashMapF.get(ed.a("002gi"));
                            concurrentHashMapF.clear();
                            cn.a((ArrayList<HashMap<String, Object>>) arrayList, new ge<Void>() { // from class: cn.fly.verify.bv.2.1
                                @Override // cn.fly.verify.ge
                                public void a(Void r1) {
                                }
                            });
                        } finally {
                        }
                    }
                }
            }.start();
        }
    }

    public int b(String str, int i2) {
        return this.s.b(str, i2);
    }

    public String d() {
        String strB = b(l, (String) null);
        if (TextUtils.isEmpty(strB)) {
            return strB;
        }
        try {
            String strT = t();
            return fr.c(strT.getBytes("UTF-8"), Base64.decode(strB, 0));
        } catch (Throwable th) {
            en.a().a(th);
            return strB;
        }
    }

    public String e() {
        String strB = b("key_gfrt", (String) null);
        if (TextUtils.isEmpty(strB)) {
            return strB;
        }
        try {
            String strT = t();
            return fr.c(strT.getBytes("UTF-8"), Base64.decode(strB, 0));
        } catch (Throwable th) {
            en.a().a(th);
            return strB;
        }
    }

    public void f() {
        c((String) null);
        d((String) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashMap<Long, Long> g() {
        HashMap mapA;
        String strA = this.s.a(n);
        HashMap<Long, Long> map = new HashMap<>();
        if (!TextUtils.isEmpty(strA) && (mapA = fv.a(strA)) != null && !mapA.isEmpty()) {
            for (Map.Entry entry : mapA.entrySet()) {
                if (entry != null) {
                    map.put(Long.valueOf(Long.parseLong((String) entry.getKey())), entry.getValue());
                }
            }
        }
        return map;
    }

    public HashMap<String, Object> h() {
        String strB = b(o, (String) null);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return fv.a(strB);
    }

    public int i() {
        return b("key_mstrgy", 0);
    }

    public ay.d j() {
        return ay.d.a(b("key_duid_param_blacklist", (String) null));
    }

    public ay.b k() {
        try {
            String strB = b("key_duid_entity", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                return ay.b.a(fr.a(fq.d.j(), Base64.decode(strB, 0)));
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
        return null;
    }

    public String l() {
        return b("key_chd_ak", (String) null);
    }

    public String m() {
        return b("key_chd_as", (String) null);
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> n() {
        return fv.a(b("key_chd_busi_dm", (String) null));
    }

    public HashMap<String, String> o() {
        return fv.a(b("key_ckd_busi_dm", (String) null));
    }

    public ArrayList<String> p() {
        HashMap mapA = fv.a(b("key_chd_prx_dm", (String) null));
        return (mapA == null || mapA.isEmpty()) ? new ArrayList<>() : (ArrayList) mapA.get(ed.a("008FefBdQdl*fg difh,i"));
    }

    public HashMap<String, Long> q() {
        return fv.a(b("key_dm_ck_tm", (String) null));
    }

    public long r() {
        return b("key_fst_lnch_tm", 0L);
    }

    public Object a(String str) {
        return this.s.d(str);
    }

    public long b(String str, long j2) {
        return this.s.a(str, j2);
    }

    public Object c(String str, Object obj) {
        Object objD = this.s.d(str);
        return objD == null ? obj : objD;
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(fr.a(t(), str), 0);
                a(m, System.currentTimeMillis());
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        a("key_gfrt", str);
    }

    public void e(String str) {
        a("key_chd_ak", str);
    }

    public void f(String str) {
        a("key_chd_as", str);
    }

    public void a(long j2) {
        a("key_fst_lnch_tm", j2);
    }

    public String b(String str, String str2) {
        return this.s.b(str, str2);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(fr.a(t(), str), 0);
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        a(l, str);
    }

    public void d(HashMap<String, String> map) {
        a("key_ckd_busi_dm", fv.a((HashMap) map));
    }

    public void e(HashMap<String, Long> map) {
        a("key_dm_ck_tm", fv.a((HashMap) map));
    }

    public void a(ay.b bVar) {
        String strA;
        if (bVar != null) {
            try {
                strA = bVar.a();
            } catch (Throwable th) {
                en.a().a(th);
                return;
            }
        } else {
            strA = null;
        }
        a("key_duid_entity", Base64.encodeToString(fr.a(fq.d.j(), strA), 0));
    }

    public void b(String str) {
        this.s.e(str);
    }

    public void c(HashMap<String, HashMap<String, ArrayList<String>>> map) {
        a("key_chd_busi_dm", fv.a((HashMap) map));
    }

    public void a(ay.d dVar) {
        a("key_duid_param_blacklist", dVar != null ? dVar.a() : null);
    }

    public void b(String str, Object obj) {
        this.s.a(str, obj);
    }

    public void a(String str, int i2) {
        this.s.a(str, Integer.valueOf(i2));
    }

    public void b(HashMap<Long, Long> map) {
        if (map == null || map.isEmpty()) {
            this.s.e(n);
            return;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (entry != null) {
                map2.put(String.valueOf(entry.getKey()), entry.getValue());
            }
        }
        this.s.a(n, fv.a(map2));
    }

    public static boolean b() {
        try {
            File fileC = c();
            if (fileC == null || !fileC.exists()) {
                return false;
            }
            return fileC.length() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(String str, long j2) {
        this.s.a(str, Long.valueOf(j2));
    }

    public void a(String str, Object obj) {
        this.s.a(str, obj);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.s.e(str);
        } else {
            this.s.a(str, str2);
        }
    }

    public void a(ArrayList<String> arrayList) {
        a("key_chd_prx_dm", (arrayList == null || arrayList.isEmpty()) ? null : fv.a((Object) arrayList));
    }

    public void a(HashMap<String, Object> map) {
        if (map != null) {
            this.s.a(map);
        }
    }
}
