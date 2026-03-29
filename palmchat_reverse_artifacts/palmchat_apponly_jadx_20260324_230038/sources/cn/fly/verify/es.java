package cn.fly.verify;

import android.content.Context;
import android.text.TextUtils;
import cn.fly.verify.fl;
import cn.fly.verify.fq;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static es f2255a = null;
    private static volatile boolean d = false;
    private Context b;
    private HashMap<String, Object> c;
    private volatile File g;
    private long k;
    private long l;
    private long m;
    private final byte[] e = new byte[0];
    private AtomicBoolean f = new AtomicBoolean(false);
    private ConcurrentLinkedQueue<CountDownLatch> h = new ConcurrentLinkedQueue<>();
    private volatile String i = null;
    private volatile int j = -1;

    private es(Context context) {
        this.b = context;
    }

    private String e() {
        try {
            String str = (String) by.b(ed.a("002Ffhfh"), (Object) null);
            return str == null ? (String) by.b(ed.a("009)fhfedjejffdi8ich"), (Object) null) : str;
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    public int b() {
        return this.j;
    }

    public static es a(Context context) {
        if (f2255a == null) {
            synchronized (es.class) {
                if (f2255a == null) {
                    f2255a = new es(context);
                }
            }
        }
        return f2255a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File b(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d(str);
        return new File(file, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("#")) == null || strArrSplit.length != 2) {
            return null;
        }
        return strArrSplit[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return (TextUtils.isEmpty(b(str)) || TextUtils.isEmpty(c(str))) ? false : true;
    }

    public CountDownLatch d() {
        ConcurrentLinkedQueue<CountDownLatch> concurrentLinkedQueue = this.h;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        return this.h.peek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("#")) == null || strArrSplit.length != 2) {
            return null;
        }
        return strArrSplit[0];
    }

    public static boolean c() {
        return d;
    }

    private void d(String str) {
        File fileB = fz.b(this.b, str);
        if (!fileB.exists() || fileB.length() <= 0) {
            return;
        }
        fileB.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, File file, String str2) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str) && file != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str3 = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    en.a().a("dhs d...", new Object[0]);
                    new fl().a(str, fileOutputStream, (fl.a) null);
                    String strA = fr.a(file);
                    if (TextUtils.equals(str2, strA)) {
                        eg.a(fileOutputStream);
                        if (TextUtils.isEmpty(null)) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                            this.l = jCurrentTimeMillis2;
                            str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis2));
                        }
                        en.a().a(str3, new Object[0]);
                        return strA;
                    }
                    dr.a().a(-1, 20, "", str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    eg.a(fileOutputStream);
                    if (TextUtils.isEmpty(null)) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        this.l = jCurrentTimeMillis3;
                        str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis3));
                    }
                    en.a().a(str3, new Object[0]);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        str3 = "dhs d e: " + th.getMessage();
                        en.a().a(th);
                        dr.a().a(2, b(), th, "" + str2);
                        eg.a(fileOutputStream);
                        if (TextUtils.isEmpty(str3)) {
                            long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                            this.l = jCurrentTimeMillis4;
                            str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis4));
                        }
                        en.a().a(str3, new Object[0]);
                        return "";
                    } catch (Throwable th2) {
                        eg.a(fileOutputStream);
                        if (TextUtils.isEmpty(str3)) {
                            long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis;
                            this.l = jCurrentTimeMillis5;
                            str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis5));
                        }
                        en.a().a(str3, new Object[0]);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(File file, String str) {
        HashMap map = new HashMap();
        String strD = bv.a().d();
        if (TextUtils.isEmpty(strD)) {
            strD = fv.a(map);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        if (this.c == null) {
            HashMap<String, Object> map3 = new HashMap<>();
            this.c = map3;
            map3.put("cacheMap", new ConcurrentHashMap());
            this.c.put("invokeTimesMap", new ConcurrentHashMap());
            this.c.put("expireTimeMap", new ConcurrentHashMap());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            co.a(ax.g(), file.getAbsolutePath(), strD, map2, this.c);
            this.k = System.currentTimeMillis() - jCurrentTimeMillis;
            en.a().a(TextUtils.isEmpty(null) ? String.format("dhs l %d", Long.valueOf(this.k)) : null, new Object[0]);
        } catch (Throwable th) {
            try {
                str = "dhs l e: " + th.getMessage();
                map2.clear();
                dr.a().a(5, b(), th, "" + str);
                en.a().a(th);
            } catch (Throwable unused) {
            }
            this.k = System.currentTimeMillis() - jCurrentTimeMillis;
            if (TextUtils.isEmpty(str)) {
                str = String.format("dhs l %d", Long.valueOf(this.k));
            }
            en.a().a(str, new Object[0]);
        }
        return map2;
    }

    public final CountDownLatch a() {
        return a(e());
    }

    public final CountDownLatch a(final String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        en.a().a("dhs ofr: " + countDownLatch, new Object[0]);
        this.h.offer(countDownLatch);
        ek.f.execute(new Runnable() { // from class: cn.fly.verify.es.1
            /* JADX WARN: Removed duplicated region for block: B:107:0x03c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:66:0x03c6 A[Catch: all -> 0x03c9, TRY_LEAVE, TryCatch #4 {all -> 0x03c9, blocks: (B:64:0x03c0, B:66:0x03c6), top: B:107:0x03c0 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                dr drVarA;
                Throwable th;
                String string;
                int i;
                int i2;
                File file;
                String str2;
                es esVar;
                String strC;
                HashMap mapA;
                synchronized (es.this.e) {
                    fb.c.set(Boolean.TRUE);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        en.a().a("dhs stch: " + es.this.e(str), new Object[0]);
                        file = new File(ax.g().getFilesDir(), ed.a("003CdcdcIh"));
                    } catch (Throwable th2) {
                        try {
                            en.a().a("dhs oops: " + th2.getMessage(), new Object[0]);
                            en.a().a(th2);
                            es.this.m = System.currentTimeMillis() - jCurrentTimeMillis;
                            en.a().a("dhs ctd: " + countDownLatch, new Object[0]);
                            countDownLatch.countDown();
                            es.this.h.remove(countDownLatch);
                            en.a().a("dhs tt " + es.this.m, new Object[0]);
                            if (es.this.m > 3500 && es.this.b() == 16) {
                                drVarA = dr.a();
                                th = new Throwable(("-t-" + es.this.m) + "-d-" + es.this.l + "-l-" + es.this.k + " ");
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                sb.append(es.this.i);
                                string = sb.toString();
                                i = 11;
                                i2 = 3;
                            }
                        } finally {
                        }
                    }
                    if (!es.this.e(str)) {
                        boolean unused = es.d = false;
                        fz.a(file);
                        es.this.m = System.currentTimeMillis() - jCurrentTimeMillis;
                        en.a().a("dhs ctd: " + countDownLatch, new Object[0]);
                        countDownLatch.countDown();
                        es.this.h.remove(countDownLatch);
                        en.a().a("dhs tt " + es.this.m, new Object[0]);
                        if (es.this.m > 3500 && es.this.b() == 16) {
                            dr drVarA2 = dr.a();
                            Throwable th3 = new Throwable(("-t-" + es.this.m) + "-d-" + es.this.l + "-l-" + es.this.k + " ");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("");
                            sb2.append(es.this.i);
                            drVarA2.a(3, 11, th3, sb2.toString());
                        }
                        return;
                    }
                    es.this.a(0);
                    String strB = es.this.b(str);
                    if (TextUtils.isEmpty(strB)) {
                        boolean unused2 = es.d = false;
                        dr.a().a(-1, 4, "", "");
                        es.this.m = System.currentTimeMillis() - jCurrentTimeMillis;
                        en.a().a("dhs ctd: " + countDownLatch, new Object[0]);
                        countDownLatch.countDown();
                        es.this.h.remove(countDownLatch);
                        en.a().a("dhs tt " + es.this.m, new Object[0]);
                        if (es.this.m > 3500 && es.this.b() == 16) {
                            dr drVarA3 = dr.a();
                            Throwable th4 = new Throwable(("-t-" + es.this.m) + "-d-" + es.this.l + "-l-" + es.this.k + " ");
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("");
                            sb3.append(es.this.i);
                            drVarA3.a(3, 11, th4, sb3.toString());
                        }
                        return;
                    }
                    if (fq.d.b()) {
                        str2 = strB;
                    } else {
                        String strReplace = fq.d.d() + "";
                        String strC2 = fq.d.c();
                        if (strReplace.contains(strC2)) {
                            strReplace = strReplace.replace(strC2, "");
                        }
                        str2 = strB + "_" + strReplace.replace(":", "");
                        try {
                            en.a().a("dhs cld nm " + str2, new Object[0]);
                        } catch (Throwable unused3) {
                        }
                    }
                    File fileB = es.this.b(file, str2);
                    boolean z = fileB != null && fileB.exists() && fileB.isFile();
                    en.a().a("dhs cac: " + z, new Object[0]);
                    String strA = fr.a(fileB);
                    if (z) {
                        es.this.a(5);
                        boolean zEquals = strB.equals(strA);
                        en.a().a("dhs m5: " + zEquals, new Object[0]);
                        if (zEquals) {
                            en.a().a("dhs tbm: " + es.this.f.get(), new Object[0]);
                            if (!es.this.f.compareAndSet(false, true)) {
                                strA = "";
                            }
                            en.a().a("dhs cl:  tm5: " + strA + ", cm5: " + es.this.i, new Object[0]);
                            if (!TextUtils.isEmpty(strA) && !strA.equals(es.this.i)) {
                                es.this.a(fileB);
                                mapA = es.this.a(fileB, strA);
                                if (mapA != null || mapA.isEmpty()) {
                                    try {
                                        if (fileB.exists()) {
                                            fileB.delete();
                                        }
                                    } catch (Throwable unused4) {
                                    }
                                    en.a().a("dhs l fail", new Object[0]);
                                } else {
                                    en.a().a("dhs l succ", new Object[0]);
                                    eu euVar = new eu(mapA);
                                    es.this.i = fr.a(fileB);
                                    boolean unused5 = es.d = er.a(es.this.b).a(euVar);
                                    es.this.a(16);
                                    en.a().a("dhs fin", new Object[0]);
                                }
                            }
                            es.this.m = System.currentTimeMillis() - jCurrentTimeMillis;
                            en.a().a("dhs ctd: " + countDownLatch, new Object[0]);
                            countDownLatch.countDown();
                            es.this.h.remove(countDownLatch);
                            en.a().a("dhs tt " + es.this.m, new Object[0]);
                            if (es.this.m > 3500 && es.this.b() == 16) {
                                drVarA = dr.a();
                                th = new Throwable(("-t-" + es.this.m) + "-d-" + es.this.l + "-l-" + es.this.k + " ");
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("");
                                sb4.append(es.this.i);
                                string = sb4.toString();
                                i = 11;
                                i2 = 3;
                                drVarA.a(i2, i, th, string);
                            }
                            fb.c.set(Boolean.FALSE);
                        }
                        es.this.a(6);
                        esVar = es.this;
                        strC = esVar.c(str);
                    } else {
                        es.this.a(8);
                        esVar = es.this;
                        strC = esVar.c(str);
                    }
                    strA = esVar.a(strC, fileB, strB);
                    en.a().a("dhs cl:  tm5: " + strA + ", cm5: " + es.this.i, new Object[0]);
                    if (!TextUtils.isEmpty(strA)) {
                        es.this.a(fileB);
                        mapA = es.this.a(fileB, strA);
                        if (mapA != null) {
                            if (fileB.exists()) {
                            }
                            en.a().a("dhs l fail", new Object[0]);
                        }
                        fb.c.set(Boolean.FALSE);
                    }
                    es.this.m = System.currentTimeMillis() - jCurrentTimeMillis;
                    en.a().a("dhs ctd: " + countDownLatch, new Object[0]);
                    countDownLatch.countDown();
                    es.this.h.remove(countDownLatch);
                    en.a().a("dhs tt " + es.this.m, new Object[0]);
                    if (es.this.m > 3500) {
                        drVarA = dr.a();
                        th = new Throwable(("-t-" + es.this.m) + "-d-" + es.this.l + "-l-" + es.this.k + " ");
                        StringBuilder sb42 = new StringBuilder();
                        sb42.append("");
                        sb42.append(es.this.i);
                        string = sb42.toString();
                        i = 11;
                        i2 = 3;
                        drVarA.a(i2, i, th, string);
                    }
                    fb.c.set(Boolean.FALSE);
                }
            }
        });
        return countDownLatch;
    }

    public void a(int i) {
        this.j = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (this.g != null && this.g.exists()) {
            if (this.g.delete()) {
                en.a().a("dhs dof succ", new Object[0]);
            } else {
                en.a().a("dhs dof fail", new Object[0]);
            }
        }
        this.g = file;
    }
}
