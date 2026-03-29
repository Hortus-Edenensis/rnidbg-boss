package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dt {
    private static dt d;
    private ArrayList<String> g;
    private volatile HashMap<String, Long> h;
    private ReentrantReadWriteLock i;
    private ReentrantReadWriteLock j;
    private static final CountDownLatch c = new CountDownLatch(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f2201a = new HashMap<>();
    private static final ArrayList<String> b = new ArrayList<>(Arrays.asList("cfgc.zztfly.com"));
    private volatile CountDownLatch k = c;
    private volatile HashMap<String, HashMap<String, ArrayList<String>>> e = bv.a().n();
    private volatile HashMap<String, String> f = bv.a().o();

    static {
        f2201a.put("gcfg", "cfgc.zztfly.com");
        f2201a.put("gclg", "upc.zztfly.com");
        f2201a.put(com.kuaishou.weapon.p0.t.n, "errc.zztfly.com");
        f2201a.put("dg", "devc.zztfly.com");
        f2201a.put("dtc", "fdl.zztfly.com");
    }

    private dt() {
        ArrayList<String> arrayListP = bv.a().p();
        this.g = arrayListP;
        if (arrayListP == null || arrayListP.isEmpty()) {
            this.g = b;
        }
        this.h = bv.a().q();
        this.i = new ReentrantReadWriteLock();
        this.j = new ReentrantReadWriteLock();
    }

    public static dt a() {
        if (d == null) {
            synchronized (dt.class) {
                if (d == null) {
                    d = new dt();
                }
            }
        }
        return d;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.equals("127.0.0.1") || str.startsWith("10.") || str.startsWith("192.168")) {
            return false;
        }
        if (str.startsWith("172.")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 1) {
                try {
                    int i = Integer.parseInt(strArrSplit[1]);
                    return i < 16 || i > 31;
                } catch (Throwable th) {
                    en.a().a(th, "DM " + th.getMessage(), new Object[0]);
                }
            }
        }
        return true;
    }

    public void b() {
        if (this.k != c && this.k.getCount() != 0) {
            en.a().a("DM obt abort", new Object[0]);
            return;
        }
        en.a().a("DM obt start", new Object[0]);
        this.k = new CountDownLatch(1);
        ek.c.execute(new Runnable() { // from class: cn.fly.verify.dt.1
            @Override // java.lang.Runnable
            public void run() {
                dt dtVar = dt.this;
                dtVar.a(dtVar.k, 0);
            }
        });
    }

    private boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null) {
                    for (InetAddress inetAddress : allByName) {
                        if (!c(inetAddress.getHostAddress())) {
                            en.a().a("DM ck ht: " + str + ", fai", new Object[0]);
                            return false;
                        }
                    }
                }
                en.a().a("DM ck ht: " + str + ", suc", new Object[0]);
                return true;
            } catch (Throwable th) {
                en.a().a(th, "DM " + th.getMessage(), new Object[0]);
            }
        }
        en.a().a("DM ck ht: " + str + ", fai_emp|exp", new Object[0]);
        return false;
    }

    public String a(String str) {
        return eg.a(a().a("FCOMMON", str, f2201a.get(str), false));
    }

    public String a(String str, String str2, String str3, boolean z) {
        HashMap<String, ArrayList<String>> map;
        ArrayList<String> arrayList;
        en.a().a("DM get: " + str + "-" + str2 + "-" + str3 + "-" + z, new Object[0]);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            en.a().a("DM Params 'sName' or 'aName' is null", new Object[0]);
            return str3;
        }
        boolean z2 = this.k.getCount() == 0;
        try {
            if (this.i.readLock().tryLock(3000L, TimeUnit.MILLISECONDS) && this.e != null && this.e.containsKey(str) && (map = this.e.get(str)) != null && map.containsKey(str2) && (arrayList = map.get(str2)) != null && !arrayList.isEmpty()) {
                for (String str4 : arrayList) {
                    if (z && a(str, str2)) {
                        if (a(str, str2, str4)) {
                            en.a().a("DM rtn [cac|chk]: " + str + "-" + str2 + ": " + str4, new Object[0]);
                            HashMap<String, String> map2 = this.f;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append("-");
                            sb.append(str2);
                            map2.put(sb.toString(), str4);
                            bv.a().d(this.f);
                            try {
                                this.i.readLock().unlock();
                            } catch (Throwable th) {
                                en.a().a(th, "DM " + th.getMessage(), new Object[0]);
                            }
                            return str4;
                        }
                    } else {
                        if (this.f.containsKey(str + "-" + str2)) {
                            String str5 = this.f.get(str + "-" + str2);
                            en.a().a("DM rtn [cac|chk_abt]: " + str + "-" + str2 + ": " + str5, new Object[0]);
                            try {
                                this.i.readLock().unlock();
                            } catch (Throwable th2) {
                                en.a().a(th2, "DM " + th2.getMessage(), new Object[0]);
                            }
                            return str5;
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            en.a().a("DM rtn [cac]: " + str + "-" + str2 + ": " + str4, new Object[0]);
                            try {
                                this.i.readLock().unlock();
                            } catch (Throwable th3) {
                                en.a().a(th3, "DM " + th3.getMessage(), new Object[0]);
                            }
                            return str4;
                        }
                    }
                }
            }
            try {
                this.i.readLock().unlock();
            } catch (Throwable th4) {
                en.a().a(th4, "DM " + th4.getMessage(), new Object[0]);
            }
        } catch (Throwable th5) {
            try {
                en.a().a(th5, "DM " + th5.getMessage(), new Object[0]);
                try {
                    this.i.readLock().unlock();
                } catch (Throwable th6) {
                    en.a().a(th6, "DM " + th6.getMessage(), new Object[0]);
                }
            } catch (Throwable th7) {
                try {
                    this.i.readLock().unlock();
                } catch (Throwable th8) {
                    en.a().a(th8, "DM " + th8.getMessage(), new Object[0]);
                }
                throw th7;
            }
        }
        try {
            this.f.remove(str + "-" + str2);
            bv.a().d(this.f);
            if (!z || !a(str, str2)) {
                if (!this.f.containsKey(str + "-" + str2)) {
                    en.a().a("DM rtn [def]" + str + "-" + str2 + ": " + str3, new Object[0]);
                    return str3;
                }
                String str6 = this.f.get(str + "-" + str2);
                en.a().a("DM rtn [def|chk_abt]: " + str + "-" + str2 + ": " + str6, new Object[0]);
                return str6;
            }
            if (a(str, str2, str3)) {
                en.a().a("DM rtn [def|chk_true]: " + str + "-" + str2 + ": " + str3, new Object[0]);
                HashMap<String, String> map3 = this.f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("-");
                sb2.append(str2);
                map3.put(sb2.toString(), str3);
                bv.a().d(this.f);
                return str3;
            }
            if (z2) {
                en.a().a("DM rtn [def|chk_false]" + str + "-" + str2 + ": " + str3, new Object[0]);
                return str3;
            }
            if (this.k.await(5000L, TimeUnit.MILLISECONDS)) {
                en.a().a("DM awt next", new Object[0]);
                return a(str, str2, str3, z);
            }
            en.a().a("DM rtn [def|awt_to]" + str + "-" + str2 + ": " + str3, new Object[0]);
            return str3;
        } catch (Throwable th9) {
            en.a().a(th9, "DM " + th9.getMessage(), new Object[0]);
            en.a().a("DM rtn [def|exp]" + str + "-" + str2 + ": " + str3, new Object[0]);
            return str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CountDownLatch countDownLatch, int i) {
        Object obj;
        try {
            ArrayList<String> arrayList = this.g;
            if (arrayList == null || i >= arrayList.size()) {
                en.a().b("DM No pdm");
            } else {
                String strA = eg.a(this.g.get(i) + "/dm");
                HashMap<String, Object> map = new HashMap<>();
                map.put(ed.a("006djj>dlVf1dk"), ef.a());
                fl.a aVar = new fl.a();
                aVar.b = 3000;
                aVar.f2355a = 5000;
                String strA2 = new fl().a(strA, map, (HashMap<String, String>) null, aVar);
                en.a().a("DM resp: " + strA2, new Object[0]);
                HashMap mapA = fv.a(strA2);
                if (mapA == null || mapA.isEmpty() || (obj = mapA.get(ed.a("004c eddc=f"))) == null || ((Integer) obj).intValue() != 200) {
                    a(countDownLatch, i + 1);
                } else {
                    HashMap map2 = (HashMap) mapA.get(ed.a("004+dc'did"));
                    if (map2 != null && !map2.isEmpty()) {
                        try {
                            HashMap map3 = (HashMap) map2.get(ed.a("004Xdc^did"));
                            if (map3 != null && !map3.isEmpty()) {
                                HashMap map4 = new HashMap();
                                for (Map.Entry entry : map3.entrySet()) {
                                    String str = (String) entry.getKey();
                                    HashMap map5 = (HashMap) entry.getValue();
                                    HashMap map6 = new HashMap();
                                    if (map5 != null && !map5.isEmpty()) {
                                        for (Map.Entry entry2 : map5.entrySet()) {
                                            String str2 = (String) entry2.getKey();
                                            ArrayList<String> arrayList2 = (ArrayList) entry2.getValue();
                                            ArrayList arrayList3 = new ArrayList();
                                            if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                for (String str3 : arrayList2) {
                                                    if (b(str3)) {
                                                        arrayList3.add(str3);
                                                    }
                                                }
                                            }
                                            if (!arrayList3.isEmpty()) {
                                                map6.put(str2, arrayList3);
                                            }
                                        }
                                    }
                                    if (!map6.isEmpty()) {
                                        map4.put(str, map6);
                                    }
                                }
                                if (map4.isEmpty()) {
                                    en.a().a("DM busi no avai dm", new Object[0]);
                                } else {
                                    try {
                                        en.a().a("DM busi w 2 cac: " + map4, new Object[0]);
                                        if (this.i.writeLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                                            this.e.clear();
                                            this.e.putAll(map4);
                                            bv.a().c(this.e);
                                        }
                                        try {
                                            this.i.writeLock().unlock();
                                        } catch (Throwable th) {
                                            en.a().a(th, "DM " + th.getMessage(), new Object[0]);
                                        }
                                    } catch (Throwable th2) {
                                        try {
                                            en.a().a(th2, "DM " + th2.getMessage(), new Object[0]);
                                            try {
                                                this.i.writeLock().unlock();
                                            } catch (Throwable th3) {
                                                en.a().a(th3, "DM " + th3.getMessage(), new Object[0]);
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            ArrayList<String> arrayList4 = (ArrayList) map2.get("p");
                            if (arrayList4 != null && !arrayList4.isEmpty()) {
                                ArrayList arrayList5 = new ArrayList();
                                for (String str4 : arrayList4) {
                                    if (b(str4)) {
                                        arrayList5.add(str4);
                                    }
                                }
                                if (arrayList5.isEmpty()) {
                                    en.a().a("DM prx no avai dm", new Object[0]);
                                } else {
                                    en.a().a("DM prx w 2 cac: " + arrayList5, new Object[0]);
                                    this.g.clear();
                                    this.g.addAll(arrayList5);
                                    bv.a().a(this.g);
                                }
                            }
                        } catch (Throwable th4) {
                            en.a().a(th4, "DM " + th4.getMessage(), new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                en.a().a(th5, "DM " + th5.getMessage(), new Object[0]);
                a(countDownLatch, i + 1);
                if (countDownLatch.getCount() <= 0) {
                }
            } finally {
                if (countDownLatch.getCount() > 0) {
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        Long l;
        boolean z = true;
        try {
            if (this.j.readLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                String str3 = str + "_" + str2;
                if (this.h != null && this.h.containsKey(str3) && (l = this.h.get(str3)) != null) {
                    if (System.currentTimeMillis() - l.longValue() < 1800000) {
                        z = false;
                    }
                }
            }
            try {
                this.j.readLock().unlock();
            } catch (Throwable th) {
                en.a().a(th, "DM " + th.getMessage(), new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                en.a().a(th2, "DM " + th2.getMessage(), new Object[0]);
                try {
                    this.j.readLock().unlock();
                } catch (Throwable th3) {
                    en.a().a(th3, "DM " + th3.getMessage(), new Object[0]);
                }
            } catch (Throwable th4) {
                try {
                    this.j.readLock().unlock();
                } catch (Throwable th5) {
                    en.a().a(th5, "DM " + th5.getMessage(), new Object[0]);
                }
                throw th4;
            }
        }
        en.a().a("DM ck dur: " + str + "-" + str2 + ", pass: " + z, new Object[0]);
        return z;
    }

    private boolean a(String str, String str2, String str3) {
        boolean zB = b(str3);
        if (zB) {
            try {
                if (this.j.writeLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                    this.h.put(str + "_" + str2, Long.valueOf(System.currentTimeMillis()));
                    bv.a().e(this.h);
                }
                try {
                    this.j.writeLock().unlock();
                } catch (Throwable th) {
                    en.a().a(th, "DM " + th.getMessage(), new Object[0]);
                }
            } catch (Throwable th2) {
                try {
                    en.a().a(th2, "DM " + th2.getMessage(), new Object[0]);
                    try {
                        this.j.writeLock().unlock();
                    } catch (Throwable th3) {
                        en.a().a(th3, "DM " + th3.getMessage(), new Object[0]);
                    }
                } catch (Throwable th4) {
                    try {
                        this.j.writeLock().unlock();
                    } catch (Throwable th5) {
                        en.a().a(th5, "DM " + th5.getMessage(), new Object[0]);
                    }
                    throw th4;
                }
            }
        }
        return zB;
    }
}
