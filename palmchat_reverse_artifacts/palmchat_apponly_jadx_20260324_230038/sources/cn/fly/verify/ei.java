package cn.fly.verify;

import android.os.Process;
import android.text.TextUtils;
import androidx.media3.common.C;
import cn.fly.verify.bv;
import cn.fly.verify.fq;
import java.io.File;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2231a = true;
    private static volatile String f;
    private static AtomicInteger b = new AtomicInteger(-1);
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static AtomicBoolean g = new AtomicBoolean(false);
    private static eh e = new eh();

    public static void a(final CountDownLatch countDownLatch) {
        if (c.compareAndSet(false, true)) {
            if (bv.a().r() == 0) {
                bv.a().a(System.currentTimeMillis());
            }
            ec.a(ax.g());
            l();
            m();
            bu.a();
            try {
                Thread.sleep(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            } catch (Throwable unused) {
            }
            dt.a().b();
            eb.a().b();
            new gi("PY-C") { // from class: cn.fly.verify.ei.2
                @Override // cn.fly.verify.gi
                public void a() {
                    fb.b.set(Boolean.TRUE);
                    en.a().a("g lk st: " + Process.myPid(), new Object[0]);
                    boolean zA = ea.a(ea.a(ea.g), new dz() { // from class: cn.fly.verify.ei.2.1
                        @Override // cn.fly.verify.dz
                        public boolean a(fs fsVar) {
                            en.a().a("g lk pd: " + Process.myPid() + ", proc st", new Object[0]);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            bv.s();
                            by.a(countDownLatch);
                            en.a().a("g lk pd: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", release: y", new Object[0]);
                            return false;
                        }
                    });
                    en.a().a("g lk res: " + zA + Process.myPid(), new Object[0]);
                    fb.b.set(Boolean.FALSE);
                }
            }.start();
        }
    }

    public static void b(final boolean z) {
        b.set(z ? 1 : 0);
        en.a().a("submit py: " + z, new Object[0]);
        new gi(ba.a("004,inkmjmjg")) { // from class: cn.fly.verify.ei.4
            @Override // cn.fly.verify.gi
            public void a() {
                int iE = ei.e();
                bv.a().a(bv.e, z ? 1 : 0);
                if (!z || iE == 1) {
                    return;
                }
                CountDownLatch countDownLatchG = ei.g();
                en.a().a(fq.d.b() ? "main" : "sub", new Object[0]);
                ei.a(countDownLatchG);
                fq.a(ax.g()).h().a(new fq.a() { // from class: cn.fly.verify.ei.4.1
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar) {
                        try {
                            ei.b(z, bVar.h());
                        } catch (Throwable th) {
                            en.a().a(th);
                            try {
                                ei.b(z, bVar.h());
                            } catch (Throwable th2) {
                                en.a().a(th2);
                            }
                        }
                    }
                });
            }
        }.start();
    }

    public static int c() {
        en.a().a("get py grtd status mem: " + b.get(), new Object[0]);
        return b.get();
    }

    public static int d() {
        int iC = c();
        return iC != -1 ? iC : e();
    }

    public static int e() {
        int iB = bv.b() ? bv.a().b(bv.e, -1) : -1;
        en.a().a("get py grtd status cac: " + iB, new Object[0]);
        return iB;
    }

    public static String f() {
        return "ecpgnjvr<1fxsowakt{mzqihWPKUVCN0dy2uDJFH|LYZQGTXERO:43l87;/6MI>\"@A?9[\\)_]5=.(S'~盺朼-";
    }

    public static CountDownLatch g() {
        return !d.getAndSet(true) ? er.a(ax.g()).a() : new CountDownLatch(0);
    }

    public static boolean h() {
        String strA = ef.a();
        return (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA.trim()) || TextUtils.equals(strA, i())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i() {
        if (f == null) {
            try {
                String absolutePath = ax.g().getFilesDir().getAbsolutePath();
                if (!TextUtils.isEmpty(absolutePath)) {
                    String strSubstring = absolutePath.substring(0, absolutePath.lastIndexOf(ba.a("001n")));
                    String strSubstring2 = !TextUtils.isEmpty(strSubstring) ? strSubstring.substring(strSubstring.lastIndexOf(ba.a("001n")) + 1) : null;
                    if (!TextUtils.isEmpty(strSubstring2)) {
                        String strF = fr.f(strSubstring2.getBytes("utf-8"));
                        if (!TextUtils.isEmpty(strF)) {
                            String strB = fr.b(strF.getBytes());
                            if (!TextUtils.isEmpty(strB)) {
                                f = "s" + strB;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return f;
    }

    public static void j() {
        if (g.compareAndSet(false, true)) {
            boolean zB = bv.b();
            boolean zB2 = bv.a.b();
            en.a().a("[CPT] cpt, nest: " + zB + ", oest: " + zB2, new Object[0]);
            if (zB || !zB2) {
                return;
            }
            try {
                File parentFile = bv.c().getParentFile();
                if (parentFile != null) {
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (parentFile.exists()) {
                        bv.a().a(bv.a.a().d());
                        en.a().a("[CPT] cpt over: ", new Object[0]);
                        bv.a().a((ArrayList<String>) null);
                    }
                }
            } catch (Throwable th) {
                en.a().c(th);
            }
        }
    }

    private static void l() {
        try {
            ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
            serverSocketChannelOpen.configureBlocking(false);
            try {
                serverSocketChannelOpen.socket().bind(new InetSocketAddress(37926));
                eb.f2214a = false;
                serverSocketChannelOpen.close();
            } catch (Throwable unused) {
                eb.f2214a = true;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void m() {
        ba.a().a(new dv() { // from class: cn.fly.verify.ei.3
            @Override // cn.fly.verify.dv
            public void a(boolean z, boolean z2, long j) {
                if (z) {
                    en.a().a("fg.", new Object[0]);
                    boolean unused = ei.f2231a = true;
                } else {
                    en.a().a("bg.", new Object[0]);
                    boolean unused2 = ei.f2231a = false;
                }
            }
        });
    }

    public static void a(final boolean z) {
        ek.c.execute(new gh() { // from class: cn.fly.verify.ei.1
            @Override // cn.fly.verify.gh
            public void a() {
                fb.b.set(Boolean.TRUE);
                fa.a();
                if (!TextUtils.isEmpty("M-")) {
                    Thread.currentThread().setName("M-" + ba.a("004Binkmjmjh"));
                }
                boolean zB = bv.b();
                en.a().a("[CPT] ck-sp: " + zB, new Object[0]);
                int iB = zB ? bv.a().b(bv.e, -1) : -1;
                if (!zB) {
                    boolean zB2 = bv.a.b();
                    en.a().a("[CPT] ck-spc: " + zB2, new Object[0]);
                    if (zB2) {
                        iB = bv.a.a().a(bv.e, -1);
                    }
                }
                if (ei.b.get() == -1) {
                    ei.b.set(iB);
                }
                if (ei.b.get() == 1) {
                    ei.b(true, z);
                } else {
                    ei.b(false, z);
                }
                fe feVarA = en.a();
                StringBuilder sb = new StringBuilder();
                sb.append(z ? ba.a("002?fl'h") : "");
                sb.append("init cfg over. py ");
                sb.append(ei.b.get());
                feVarA.a(sb.toString(), new Object[0]);
                fb.b.set(Boolean.FALSE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, String str) throws Throwable {
        HashMap<String, Object> mapA = ef.a(str);
        mapA.put(ba.a("009LfkhjgnggflJhhIinAl"), String.valueOf(z));
        String str2 = dt.a().a("gclg") + ba.a("036nl flfkff:fe^fmUnl@gf6i=fkHePfmMnf@fiTkj.gfflfkie5fkLfkgf(gnLhj6kfk-fihj");
        HashMap<String, String> map = new HashMap<>();
        map.put(ba.a("003Cfn'h3fm"), ef.a());
        map.put(ba.a("013[gihj4hSfljmgkfe;hgkYfk[k9fm"), bu.f());
        String strA = new fl().a(str2, mapA, map);
        en.a().a("RS sp: " + strA, new Object[0]);
        HashMap mapA2 = fv.a(strA);
        if (mapA2 == null) {
            throw new Throwable("RS is illegal: " + strA);
        }
        if ("200".equals(String.valueOf(mapA2.get(ba.a("004eNgffe%h"))))) {
            return;
        }
        throw new Throwable("RS code is not 200: " + strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, boolean z2) {
        if (!z2) {
            e.a();
        }
        if (TextUtils.isEmpty(ec.f2222a)) {
            String strL = bv.a().l();
            if (TextUtils.isEmpty(strL)) {
                strL = i();
            }
            if (!TextUtils.isEmpty(strL)) {
                ec.c = strL;
                bv.a().e(strL);
            }
        } else {
            ec.c = ec.f2222a;
            bv.a().e(ec.f2222a);
        }
        if (TextUtils.isEmpty(ec.b)) {
            String strM = bv.a().m();
            if (!TextUtils.isEmpty(strM)) {
                ec.d = strM;
            }
        } else {
            ec.d = ec.b;
            bv.a().f(ec.b);
        }
        if (!z) {
            if (z2) {
                return;
            }
            e.b();
            return;
        }
        j();
        CountDownLatch countDownLatchG = g();
        en.a().a(fq.d.b() ? "main" : "sub", new Object[0]);
        if (!z2) {
            a(countDownLatchG);
        } else {
            bu.a();
            by.h();
        }
    }

    public static boolean b() {
        return b.get() == 1;
    }

    public static boolean a() {
        return f2231a;
    }
}
