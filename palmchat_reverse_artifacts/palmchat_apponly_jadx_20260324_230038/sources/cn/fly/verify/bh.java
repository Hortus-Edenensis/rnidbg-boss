package cn.fly.verify;

import android.os.Handler;
import android.os.Message;
import cn.fly.verify.ex;
import cn.fly.verify.fq;
import com.cdo.oaps.ad.OapsKey;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class bh implements Runnable {
    private static final WeakHashMap<String, Object> k = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f2096a;
    protected Object b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private volatile long g;
    private final int h;
    private int i;
    private boolean j;
    private long l;

    public bh(String str, long j, String str2, long j2, long j3) {
        this.f2096a = 0;
        this.i = 0;
        this.j = false;
        this.c = str;
        this.d = str2;
        this.e = j;
        this.f = j2;
        this.h = getClass().hashCode();
        this.l = j3;
        this.g = System.currentTimeMillis();
    }

    public static long a(String str, Long l) {
        Map map = (Map) by.a(bq.a("005)gi]hAej3j1gi"), (Object) null);
        if (map == null) {
            return 0L;
        }
        return ((Long) fz.a(map.get(str), l)).longValue();
    }

    private void m() {
        int i;
        if (this.j || (i = this.f2096a) < 0) {
            return;
        }
        this.f2096a = i + 1;
    }

    public abstract void a() throws Throwable;

    public bh b(boolean z) {
        this.f2096a = z ? 0 : -1;
        return this;
    }

    public HashMap<String, Object> c(Object obj) {
        Object th;
        HashMap<String, Object> map;
        if (obj == null) {
            return null;
        }
        ex.a aVar = new ex.a(obj);
        try {
            map = new HashMap<>();
            try {
                map.put("accmt", Float.valueOf(aVar.a()));
                if (aVar.i()) {
                    map.put("vacmt", Float.valueOf(aVar.j()));
                }
                map.put("ltdmt", Double.valueOf(aVar.b()));
                map.put("lndmt", Double.valueOf(aVar.c()));
                map.put(dq.f2192a, Long.valueOf(aVar.d()));
                map.put("prvmt", aVar.e());
                map.put("atdmt", Double.valueOf(aVar.f()));
                map.put("brmt", Float.valueOf(aVar.g()));
                map.put("spmt", Float.valueOf(aVar.h()));
            } catch (Throwable th2) {
                th = th2;
                en.a().a("[cl] glfe " + th, new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
        }
        return map;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return ((Long) by.a(this.c, Long.valueOf(this.e))).longValue() != 0 && f();
    }

    public final boolean f() {
        if ("bs,l,ol,wi,wl,ext,aa,".contains(this.c + ",")) {
            return du.a().b();
        }
        return true;
    }

    public boolean g() {
        return this.f2096a == 0;
    }

    public boolean h() {
        if (!e()) {
            return false;
        }
        ek.c.execute(this);
        return true;
    }

    public boolean i() {
        boolean zA = by.a();
        boolean zB = by.b();
        if (!zA || !zB) {
            en.a().a("slt: " + d() + ", to: " + zA + ", conn: " + zB, new Object[0]);
            return false;
        }
        boolean zE = e();
        en.a().a("slt : " + getClass().getSimpleName() + ", to: " + zA + ", conn: " + zB + ", " + this.c + ": " + zE + ", key: " + a(this.c, 0) + ", gp: " + l() + " , oce " + this.j + " , tt " + this.f2096a, new Object[0]);
        return zE;
    }

    public long j() {
        return this.g;
    }

    public int k() {
        return this.h;
    }

    public long l() {
        try {
            String str = this.d;
            if (str != null) {
                return Long.parseLong(String.valueOf(by.a(str, Long.valueOf(this.f))));
            }
            return 0L;
        } catch (Throwable th) {
            en.a().a(th);
            return 0L;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.l > 0) {
            bq.a().a(this.l, this, this.i);
            this.l = 0L;
            return;
        }
        try {
            if (g()) {
                c();
            }
            if (i()) {
                a();
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public bh(String str, String str2, long j) {
        this(str, 0L, str2, 0L, j);
    }

    public bh a(long j) {
        if (j > 0) {
            this.g = System.currentTimeMillis() + (j * 1000);
        } else {
            this.g = -1L;
        }
        return this;
    }

    public TreeMap<String, Object> b(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            TreeMap<String, Object> treeMap = new TreeMap<>();
            ex.a aVar = new ex.a(obj);
            treeMap.put("ltdmt", Double.valueOf(aVar.b()));
            treeMap.put("lndmt", Double.valueOf(aVar.c()));
            return treeMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void c() {
    }

    public bh a(Object obj) {
        this.b = obj;
        return this;
    }

    public void b() {
        long jL = l();
        if (jL > 0) {
            a(jL);
        } else {
            this.j = true;
        }
    }

    public bh a(boolean z) {
        this.j = z;
        if (z) {
            this.l = 0L;
        }
        return this;
    }

    public <T> T a(String str, T t) {
        return (T) by.a(str, t);
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(long j, String str, Object obj) {
        a(j, str, obj, false);
    }

    public void a(long j, String str, Object obj, HashMap<String, Object> map, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        final long j2 = j > 0 ? (j * 1000) + jCurrentTimeMillis : jCurrentTimeMillis;
        final HashMap<String, Object> map2 = new HashMap<>();
        map2.put(bq.a("004jRel;kg"), str);
        map2.put(bq.a("004h3ejgi1j"), obj);
        map2.put(bq.a("0084ed,ejgj-ejegKg"), Long.valueOf(jCurrentTimeMillis));
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        if (z) {
            a(new ge<HashMap<String, Object>>() { // from class: cn.fly.verify.bh.2
                @Override // cn.fly.verify.ge
                public void a(HashMap<String, Object> map3) {
                    map2.put(bq.a("002dh"), map3);
                    bh.this.a(map3, map2);
                    cn.a().a(j2, map2);
                }
            });
        } else {
            cn.a().a(j2, map2);
        }
    }

    public void a(long j, String str, Object obj, boolean z) {
        a(j, str, obj, null, z);
    }

    public void a(final ge<HashMap<String, Object>> geVar) {
        if (((Integer) a(bq.a("002%feQh"), 0)).intValue() == 1) {
            fq.a(ax.g()).a(0, 0, true, false).a(new fq.a() { // from class: cn.fly.verify.bh.1
                @Override // cn.fly.verify.fq.a
                public void a(fq.b bVar) {
                    geVar.a(bh.this.c(bVar.j(new int[0])));
                }
            });
        } else {
            geVar.a(null);
        }
    }

    public static void a(String str, File file, String str2, String str3) throws Throwable {
        Object objA;
        Object objA2 = fy.a((Object) ax.g(), bq.a("014Fff.gj]hl7heSgigigdfeMeNed,g,ek"), new Object[0]);
        fy.b(bq.a("028=edAehSeeejemgegielgiCjgOeggeglYgPfdhlLhe$gigigdfe:eSed=g.ek"), bq.a("028=edAehSeeejemgegielgiCjgOeggeglYgPfdhlLhe$gigigdfe:eSed=g.ek"));
        file.setReadOnly();
        File parentFile = file.getParentFile();
        WeakHashMap<String, Object> weakHashMap = k;
        synchronized (weakHashMap) {
            objA = weakHashMap.get(str);
            if (objA == null) {
                objA = fy.a(bq.a("028JedZehFeeejemgegielgi>jg,eggegl7g(fdhlPhe)gigigdfeHe7edSg8ek"), file.getAbsolutePath(), parentFile.getAbsolutePath(), parentFile.getAbsolutePath(), objA2);
                weakHashMap.put(str, objA);
            }
        }
        fz.a(parentFile);
        String strA = dp.a((bd) null);
        final Object objA3 = fy.a(fy.a(objA, bq.a("009h_fe>e$edhl<he$gigi"), str2), bq.a("009_ffIgj>id4gji6feed"), str3, String.class);
        HashMap map = new HashMap();
        map.put(bq.a("004<edehejed"), strA);
        map.put(bq.a("004 egfeejed"), er.a(ax.g()).d().ah());
        map.put(bq.a("010QgiedemhkMg+ekgiejfe_f"), Integer.valueOf(ax.f2078a));
        map.put(bq.a("006ekk^jd$g,el"), ef.a());
        map.put(bq.a("009ekk)fkVgd9ekSgj"), ax.e());
        map.put(bq.a("006Uedfeeg@eFej-f"), ax.a().a());
        map.put(bq.a("010)fgfeekJdg-gk-jjk.gi"), Boolean.valueOf(ax.b()));
        map.put(bq.a("009Rfgfeek8dg2fj1k.eeii"), Boolean.valueOf(ax.c()));
        map.put(bq.a("004gdg?fd"), Long.valueOf(((Long) by.a(bq.a("004gdgRfd"), 5L)).longValue()));
        map.put(bq.a("002dHed"), (String) by.a(bq.a("002d$ed"), bq.a("006=ififigigigig")));
        map.put("usridt", bu.d());
        map.put("mdp", el.class.getName());
        final String strA2 = fv.a(map);
        fy.a(objA3, bq.a("0130giIgjEfmDddg5gigiejgfLhg"), Boolean.TRUE);
        ds.a().a(15);
        gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.bh.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    ds.a().a(16);
                    fy.a(objA3, bq.a("006LejSfIeefeemOg"), null, new Object[]{strA2});
                    ds.a().a(17);
                } catch (Throwable th) {
                    ds.a().a(7, th);
                }
                return false;
            }
        });
    }

    public void a(String str, HashMap<String, Object> map) {
        a(str, map, false);
    }

    public void a(String str, HashMap<String, Object> map, boolean z) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final HashMap<String, Object> map2 = new HashMap<>();
        map2.put(bq.a("004jIelQkg"), str);
        if (map != null) {
            map2.put(bq.a("004_edQeje"), map);
        }
        map2.put(bq.a("0087edNejgjUejeg8g"), Long.valueOf(jCurrentTimeMillis));
        if (z) {
            a(new ge<HashMap<String, Object>>() { // from class: cn.fly.verify.bh.4
                @Override // cn.fly.verify.ge
                public void a(HashMap<String, Object> map3) {
                    map2.put(bq.a("002dh"), map3);
                    bh.this.a(map3, map2);
                    cn.a().a(jCurrentTimeMillis, map2);
                }
            });
        } else {
            cn.a().a(jCurrentTimeMillis, map2);
        }
    }

    public void a(HashMap<String, Object> map, final HashMap<String, Object> map2) {
        if (map == null || eg.a(((Long) fz.a(map.get(dq.f2192a), Long.valueOf(System.currentTimeMillis()))).longValue(), System.currentTimeMillis())) {
            return;
        }
        fq.a(ax.g()).a(0, 15, false, true).a(new fq.a() { // from class: cn.fly.verify.bh.3
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) throws Throwable {
                if (bVar.j(new int[0]) != null) {
                    HashMap<String, Object> mapC = bh.this.c(bVar.j(new int[0]));
                    mapC.put(OapsKey.KEY_PAGE_TYPE, 2);
                    map2.put("nl", mapC);
                }
            }
        });
    }
}
