package cn.fly.verify;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fl;
import cn.fly.verify.fq;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class by {
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static volatile HashMap<String, Object> e = null;
    private static ConcurrentHashMap<String, Object> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    private static CountDownLatch h = new CountDownLatch(1);
    private static CountDownLatch i = new CountDownLatch(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f2125a = false;
    private static volatile boolean j = false;
    private static final AtomicBoolean k = new AtomicBoolean(false);
    private static volatile boolean l = false;

    private static gh a(final String str, final int i2) {
        return new gh() { // from class: cn.fly.verify.by.4
            @Override // cn.fly.verify.gh
            public void a() {
                fb.b.set(Boolean.TRUE);
                if (!TextUtils.isEmpty("M-")) {
                    Thread.currentThread().setName("M-" + str);
                }
                by.b(new ge<HashMap<String, Object>>() { // from class: cn.fly.verify.by.4.1
                    @Override // cn.fly.verify.ge
                    public void a(HashMap<String, Object> map) {
                        try {
                            by.b(map, i2);
                        } finally {
                            by.d.set(false);
                        }
                    }
                });
                fb.b.set(Boolean.FALSE);
            }
        };
    }

    public static <T> T b(String str, T t) {
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        return (T) a(e != null ? e : fv.a(bv.a().d()), str, t);
    }

    private static CountDownLatch c(HashMap<String, Object> map) {
        CountDownLatch countDownLatch;
        String str = (String) fz.a(map.get(ba.a("0020hjhj")), (Object) null);
        CountDownLatch countDownLatchA = es.a(ax.g()).a(str);
        try {
            HashMap<String, Object> map2 = (HashMap) map.get(ba.a("002h(fh"));
            String str2 = (String) fz.a(map.get(ba.a("002eBfe")), ba.a("006)jgjgjhjhjhjh"));
            long jLongValue = ((Long) fz.a(map.get(ba.a("004heh ge")), 5L)).longValue();
            HashMap<String, Object> map3 = (HashMap) map.get(ba.a("002SggUl"));
            countDownLatch = countDownLatchA;
            try {
                HashMap map4 = (HashMap) map.get(ba.a("004OggAle@fe"));
                Integer num = (Integer) map.get(ba.a("004*gg7hWgf^k"));
                HashMap map5 = new HashMap();
                map5.put(ba.a("002(gf9j"), map.get(ba.a("002(gf9j")));
                map5.put(ba.a("0025hjhj"), str);
                map5.put(ba.a("002hGfh"), map2);
                map5.put(ba.a("002eAfe"), str2);
                map5.put(ba.a("004heh:ge"), Long.valueOf(jLongValue));
                map5.put(ba.a("0042gg%h5gfJk"), num);
                map5.put(ba.a("003Aflfkfe"), fz.a(map.get(ba.a("003Aflfkfe")), (Object) null));
                map5.put(ba.a("0034hjgfHe"), map.get(ba.a("0034hjgfHe")));
                map5.put(ba.a("003LhjfkSk"), map.get(ba.a("003LhjfkSk")));
                map5.put(com.kuaishou.weapon.p0.t.p, map.get(com.kuaishou.weapon.p0.t.p));
                map5.put(ba.a("005(hj$i[fk3kEhj"), map.get(ba.a("005(hj$i[fk3kEhj")));
                map5.put(ba.a("003%fl%lk"), map.get(ba.a("003%fl%lk")));
                map5.put("sti", map.get("sti"));
                if ((map2 != null && map2.size() > 0 && !TextUtils.isEmpty(str2)) || (map3 != null && map3.size() > 0 && map4 != null && map4.size() > 0)) {
                    a(map5, map, map2, map3, map4, num, countDownLatch);
                    du.a().a(map, map2, map3);
                }
                map.put(ba.a("010Vfe.h_fffkLeh;gmfkfh(h"), Long.valueOf(SystemClock.elapsedRealtime()));
                bv.a().c(fv.a((HashMap) map));
            } catch (Throwable th) {
                th = th;
                en.a().a(th);
            }
        } catch (Throwable th2) {
            th = th2;
            countDownLatch = countDownLatchA;
        }
        return countDownLatch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        File file = null;
        Closeable closeable = null;
        Closeable closeable2 = null;
        try {
            ds.a().a(0);
            String strB = eg.b(str);
            File file2 = new File(ax.g().getFilesDir(), ba.a("0033hjCee"));
            try {
                if (!du.a().b()) {
                    ds.a().a(18);
                    n();
                    return;
                }
                if (TextUtils.isEmpty(strB)) {
                    ds.a().a(1);
                    return;
                }
                try {
                    if (c()) {
                        ds.a().a(2);
                        HashMap map = (HashMap) new fk(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").a(ef.d(), strB, false);
                        ds.a().a(3);
                        String str2 = (String) map.get(ba.a("002Ngh;i"));
                        String str3 = (String) map.get("m");
                        Boolean bool = (Boolean) map.get(ba.a("002f8hj"));
                        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                        String str4 = (String) map.get(ba.a("002f fn"));
                        String str5 = (String) map.get(ba.a("002eg"));
                        String str6 = (String) map.get(ba.a("002VghGg"));
                        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
                            ds.a().a(4);
                            fz.a(file2);
                        } else {
                            synchronized (ea.i) {
                                f.clear();
                                f.put("h", str3);
                                f.put(com.kuaishou.weapon.p0.t.f7496a, str4);
                                f.put(ba.a("002eg"), str5);
                                f.put(ba.a("002Ugh$g"), str6);
                                String strA = fk.a(str2);
                                if (zBooleanValue) {
                                    ds.a().a(5);
                                    File file3 = new File(file2, ba.a("008e,gfYgLghhfhj:ee"));
                                    if (!file3.exists() || !str3.equals(fr.a(file3))) {
                                        ds.a().a(6);
                                        fz.a(file2);
                                        file2.mkdirs();
                                        try {
                                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                            try {
                                                new fl().a(strA, fileOutputStream, (fl.a) null);
                                                ds.a().a(7);
                                                eg.a(fileOutputStream);
                                            } catch (Throwable th) {
                                                th = th;
                                                closeable = fileOutputStream;
                                                eg.a(closeable);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                } else {
                                    ds.a().a(8);
                                    fz.a(file2);
                                    final byte[][] bArr = new byte[1][];
                                    final int[] iArr = new int[1];
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream() { // from class: cn.fly.verify.by.6
                                            @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                                            public void close() throws IOException {
                                                super.close();
                                                bArr[0] = ((ByteArrayOutputStream) this).buf;
                                                iArr[0] = ((ByteArrayOutputStream) this).count;
                                            }
                                        };
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    try {
                                        new fl().a(strA, byteArrayOutputStream, (fl.a) null);
                                        ds.a().a(9);
                                        eg.a(byteArrayOutputStream);
                                        f.put(ba.a("001Vhg"), bArr[0]);
                                        f.put("s", Integer.valueOf(iArr[0]));
                                    } catch (Throwable th4) {
                                        th = th4;
                                        closeable2 = byteArrayOutputStream;
                                        eg.a(closeable2);
                                        throw th;
                                    }
                                }
                            }
                        }
                        o();
                    }
                } finally {
                    o();
                }
            } catch (Throwable th5) {
                th = th5;
                file = file2;
                fz.a(file);
                ds.a().a(2, th);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static ConcurrentHashMap<String, Object> e() {
        return f;
    }

    public static ConcurrentHashMap<String, Object> f() {
        return g;
    }

    public static ArrayList<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ba.a("0040glglgkhm"));
        arrayList.add(ba.a("005<hkglglgkhm"));
        arrayList.add(ba.a("005ih:ff6hi"));
        arrayList.add(ba.a("009 ghfl$h0fgfi6hge3fm"));
        arrayList.add(ba.a("010Rfjfjfj9eUfiflimgf:gg"));
        return (ArrayList) a(ba.a("004XhhfkhjIe"), arrayList);
    }

    public static void h() {
        if (a()) {
            c(3);
        }
    }

    private static void m() {
        a(ba.a("003?hjhg_i"), ba.a("007Ohfflhj6i7hgfl^e"));
    }

    private static void n() {
        a(ba.a("003OhjUee"), ba.a("009Ujegfhg0nRhffhfhEee"), ba.a("016]jegfhg8neYgffhfhKnTfehghjNnQfhfeWe"), ba.a("0051jefihm*iFff"), ba.a("012Nhffn4kZjhjjjfkljgjkklhijf"));
    }

    private static void o() {
        Object obj = ea.i;
        synchronized (obj) {
            ds.a().a(10);
            obj.notifyAll();
        }
    }

    private static void p() {
        Object obj = ea.j;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    private static void q() {
        if (ei.h()) {
            k.compareAndSet(false, true);
        }
    }

    public static <T> T a(String str, T t) {
        if (TextUtils.isEmpty(str) || e == null) {
            return t;
        }
        if (b(e)) {
            e.clear();
            e = new HashMap<>();
            c(2);
        }
        return (T) fz.a(e.get(str), t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> b(fq.b bVar) {
        try {
            String strC = fq.d.c();
            String strA = ef.a();
            HashMap<String, String> map = new HashMap<>();
            map.put(ba.a("003KfnDh-fm"), strA);
            map.put(ba.a("013@gihj9h]fljmgkfeZhgk9fk%kTfm"), bu.f());
            map.put(ba.a("0044fhgffkfe"), bVar.B());
            HashMap<String, Object> mapA = ef.a(bVar.h());
            mapA.put(ba.a("002k5hj"), String.valueOf(System.currentTimeMillis()));
            int i2 = 1;
            mapA.put("nbs", 1);
            int i3 = ax.i();
            if (i3 != -1) {
                mapA.put(ba.a("009(fkhjgnggfl+hh-in1l"), String.valueOf(i3 == 1));
            }
            String strA2 = ba.a("002,ffjj");
            if (!ax.c()) {
                i2 = -1;
            }
            mapA.put(strA2, String.valueOf(i2));
            mapA.put("ait", Long.valueOf(bv.a().r()));
            String strB = dp.b();
            if (!TextUtils.isEmpty(strB)) {
                mapA.put("psid", strB + strC);
            }
            String strA3 = new fl().a(dt.a().a("gcfg") + "/v6/gcf", mapA, map);
            HashMap mapA2 = fv.a(strA3);
            if (mapA2.isEmpty()) {
                return null;
            }
            if (!"200".equals(String.valueOf(mapA2.get(ba.a("006,hj,kfk+fihj"))))) {
                throw new Throwable("RS is illegal: " + strA3);
            }
            byte[] bArrE = fr.e((strA + ":" + strC + ":" + mapA2.get(ba.a("009kHfkfh:h.hj,kf2fhJl"))).getBytes("utf-8"));
            String str = (String) fz.a(mapA2.get(ba.a("002Dhj[e")));
            if (str == null) {
                throw new Throwable("RS is illegal: " + strA3);
            }
            String str2 = new String(fr.b(bArrE, Base64.decode(str, 2)), "utf-8");
            en.a().a("sw: " + str2, new Object[0]);
            HashMap<String, Object> mapA3 = fv.a(str2);
            if (!mapA3.isEmpty()) {
                mapA3.put(ba.a("010@feOhFfffk.ehTgmfkfh^h"), Long.valueOf(SystemClock.elapsedRealtime()));
                bv.a().d(fv.a((HashMap) mapA3));
                return mapA3;
            }
            throw new Throwable("RS is illegal: " + strA3);
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    private static void c(int i2) {
        if (d.compareAndSet(false, true)) {
            String str = String.format(ba.a("005Nimhnjmlmhj"), Integer.valueOf(i2));
            if (i2 == 2) {
                ek.c.execute(a(str, i2));
            } else {
                a(str, i2).run();
            }
        }
    }

    public static boolean d() {
        return c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        Throwable th;
        File file;
        try {
            String strB = eg.b(str);
            file = new File(ax.g().getFilesDir(), ba.a("003Phjhg1i"));
            try {
                File file2 = new File(ax.g().getFilesDir(), ba.a("007_hfflhj(iOhgfl*e"));
                if (!du.a().b()) {
                    fz.a(file);
                    fz.a(file2);
                } else {
                    if (!TextUtils.isEmpty(strB)) {
                        if (c()) {
                            HashMap<String, Object> mapD = ef.d();
                            mapD.put(ba.a("007Uff'h!flhjfkgf<g"), String.valueOf(co.a()));
                            ArrayList arrayList = (ArrayList) ((HashMap) new fk(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").b(false, fk.a(), mapD, strB, true)).get(ba.a("004iHfkhj^k"));
                            if (arrayList != null && !arrayList.isEmpty()) {
                                synchronized (ea.j) {
                                    g.clear();
                                    g.put(ba.a("002ik"), arrayList);
                                }
                            }
                            fz.a(file);
                            fz.a(file2);
                            return;
                        }
                        return;
                    }
                    fz.a(file);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    dr.a().a(9, -1, th, "-1");
                    fz.a(file);
                } finally {
                    p();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
    }

    private static <T> T a(HashMap<String, Object> map, String str, T t) {
        return (TextUtils.isEmpty(str) || b(map) || !a(map)) ? t : (T) fz.a(map.get(str), t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2) {
        en.a().a("b ob st", new Object[0]);
        if (!a() || !b()) {
            if (i2 == 3 || ei.b()) {
                o();
            }
            n();
            return;
        }
        final String str = (String) a(ba.a("003QghPge"), (Object) null);
        if (TextUtils.isEmpty(str)) {
            if (i2 == 3 || ei.b()) {
                o();
            }
            n();
        } else if (i2 == 3 || b.compareAndSet(false, true)) {
            new gi(ba.a("003,hmkmjm") + i2) { // from class: cn.fly.verify.by.1
                @Override // cn.fly.verify.gi
                public void a() {
                    ea.a(ea.a(ea.d), false, new dz() { // from class: cn.fly.verify.by.1.1
                        @Override // cn.fly.verify.dz
                        public boolean a(fs fsVar) {
                            synchronized (by.f) {
                                by.d(str);
                            }
                            return false;
                        }
                    });
                }
            }.start();
        }
        if (!a() || !b()) {
            p();
            m();
            return;
        }
        final String str2 = (String) a("sbr", (Object) null);
        if (TextUtils.isEmpty(str2)) {
            m();
            p();
        } else if (i2 == 3 || c.compareAndSet(false, true)) {
            new gi("DS-" + i2) { // from class: cn.fly.verify.by.2
                @Override // cn.fly.verify.gi
                public void a() {
                    ea.a(ea.a(ea.e), false, new dz() { // from class: cn.fly.verify.by.2.1
                        @Override // cn.fly.verify.dz
                        public boolean a(fs fsVar) {
                            synchronized (by.g) {
                                by.e(str2);
                            }
                            return false;
                        }
                    });
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final ge<HashMap<String, Object>> geVar) {
        fb.b.set(Boolean.TRUE);
        fq.a(ax.g()).h().C().a(new fq.a() { // from class: cn.fly.verify.by.5
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                fb.b.set(Boolean.TRUE);
                try {
                    HashMap mapB = by.b(bVar);
                    long j2 = 2;
                    long j3 = 1;
                    while (true) {
                        if (mapB != null && !mapB.isEmpty()) {
                            break;
                        }
                        try {
                            Thread.sleep(1000 * j3);
                        } catch (Throwable th) {
                            en.a().a(th);
                        }
                        mapB = by.b(bVar);
                        if (mapB == null || mapB.isEmpty()) {
                            if (j2 <= 0) {
                                break;
                            }
                            j2--;
                            j3 *= 2;
                            if (j3 > 300) {
                                j3 = 8;
                            }
                        }
                    }
                    geVar.a(mapB);
                } catch (Throwable th2) {
                    en.a().a(th2);
                    geVar.a(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z) {
        if (b()) {
            en.a().a("b db st", new Object[0]);
            dp.a((bd) null);
            if (z) {
                bi.a().b();
            }
        }
    }

    public static boolean c() {
        return (((Integer) a(ba.a("002gCfl"), 0)).intValue() == 1) || ei.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(HashMap<String, Object> map, int i2) {
        if (map == null) {
            HashMap<String, Object> mapA = fv.a(bv.a().e());
            if (!b(mapA)) {
                map = mapA;
            }
            bv.a().f();
        }
        CountDownLatch countDownLatchC = (map == null || map.isEmpty()) ? null : c(map);
        a(map, true);
        fb.b.set(Boolean.FALSE);
        if (!l) {
            q();
        }
        if (countDownLatchC == null) {
            countDownLatchC = es.a(ax.g()).a();
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            en.a().a("ge dhs_w cdl: " + countDownLatchC, new Object[0]);
            countDownLatchC.await(3500L, TimeUnit.MILLISECONDS);
            en.a().a("ge dhs_w end, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        } catch (Throwable th) {
            en.a().a(th);
        }
        a(false, true, true, i2);
    }

    private static void b(CountDownLatch countDownLatch) {
        HashMap mapA = fv.a(bv.a().d());
        if (b((HashMap<String, Object>) mapA)) {
            bv.a().c((String) null);
            mapA = null;
        }
        if (a()) {
            a((HashMap<String, Object>) mapA, false);
            if (mapA == null || mapA.isEmpty()) {
                en.a().a("g ch: n", new Object[0]);
                c(1);
                return;
            }
            en.a().a("g ch: y", new Object[0]);
            boolean z = System.currentTimeMillis() - bv.a().b(bv.m, 0L) < 2000;
            en.a().a("g ch fre: " + z, new Object[0]);
            if (!z) {
                c(2);
            }
            if (countDownLatch != null) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    en.a().a("g dhs_w cdl: " + countDownLatch, new Object[0]);
                    countDownLatch.await(3500L, TimeUnit.MILLISECONDS);
                    en.a().a("g dhs_w end, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                } catch (Throwable th) {
                    en.a().a(th);
                }
            }
            a(true, false, z, 2);
        }
    }

    private static void a(HashMap<String, Object> map, HashMap<String, Object> map2, HashMap<String, Object> map3, HashMap<String, Object> map4, HashMap<String, Object> map5, Integer num, CountDownLatch countDownLatch) {
        if (num != null && num.intValue() == 2) {
            fb.b.set(Boolean.FALSE);
            try {
                countDownLatch.await(3500L, TimeUnit.MILLISECONDS);
                en.a().a("dhs wt geot.2 ovr", new Object[0]);
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        boolean zA = du.a().a(true);
        du.a().c().put(ba.a("006hOfhfjfl,hHhj"), Boolean.valueOf(zA));
        if (map3 != null && map3.size() > 0 && !zA) {
            en.a().a("dhs em dg", new Object[0]);
            map2.clear();
            map2.putAll(map);
            map2.putAll(map3);
            return;
        }
        if (map4 == null || map4.size() <= 0 || du.a().a(map5)) {
            map2.remove(ba.a("002Qgg%l"));
            map2.remove(ba.a("002h>fh"));
        } else {
            en.a().a("dhs gpe dg", new Object[0]);
            map2.clear();
            map2.putAll(map);
            map2.putAll(map4);
        }
    }

    private static void a(HashMap<String, Object> map, boolean z) {
        CountDownLatch countDownLatch;
        e = new HashMap<>();
        if (map != null) {
            e.putAll(map);
        }
        try {
            if (z) {
                h.countDown();
                countDownLatch = i;
            } else {
                countDownLatch = h;
            }
            countDownLatch.countDown();
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        return ((Integer) a(ba.a("004eVgfIgg"), 0)).intValue() == 1;
    }

    public static void a(CountDownLatch countDownLatch) {
        b(countDownLatch);
    }

    private static boolean b(HashMap<String, Object> map) {
        if (map == null) {
            return false;
        }
        long jLongValue = ((Long) fz.a(map.get(ba.a("0105fe h.fffkLeh=gmfkfh,h")), 0L)).longValue();
        return jLongValue != 0 && SystemClock.elapsedRealtime() - jLongValue >= 86400000;
    }

    private static void a(final boolean z, final boolean z2, final boolean z3, final int i2) {
        new gi("PY-B" + i2) { // from class: cn.fly.verify.by.3
            @Override // cn.fly.verify.gi
            public void a() {
                en.a().a("b enter:" + Process.myPid() + ", lbms: " + by.j + ", fc" + z + ", ol: " + z2 + ", gf: " + z3 + ", in: " + i2, new Object[0]);
                if (!by.j) {
                    en.a().a("b lk st: " + Process.myPid(), new Object[0]);
                    ea.a(ea.a(ea.f), new dz() { // from class: cn.fly.verify.by.3.1
                        @Override // cn.fly.verify.dz
                        public boolean a(fs fsVar) {
                            boolean unused = by.j = true;
                            en.a().a("b lk: " + Process.myPid() + ", proc st", new Object[0]);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            by.c(z2);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            if (!z || z3) {
                                by.b(i2);
                            }
                            en.a().a("b lk: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", release: n", new Object[0]);
                            Looper.prepare();
                            Looper.loop();
                            return true;
                        }
                    });
                    return;
                }
                en.a().a("b lked already: " + Process.myPid(), new Object[0]);
                by.c(z2);
                if (!z || z3) {
                    by.b(i2);
                }
            }
        }.start();
    }

    private static void a(String... strArr) {
        File filesDir = ax.g().getFilesDir();
        for (String str : strArr) {
            try {
                eg.a(new File(filesDir, str));
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
    }

    public static boolean a() {
        return ((Integer) a(ba.a("002kSgf"), 0)).intValue() == 0;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && a() && b() && ((Integer) a(str, 0)).intValue() != 0;
    }

    private static boolean a(HashMap<String, Object> map) {
        return map == null || ((Integer) fz.a(map.get(ba.a("002kZgf")), 0)).intValue() == 0;
    }
}
