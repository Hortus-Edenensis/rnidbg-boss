package cn.fly.verify;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.eo;
import cn.fly.verify.fl;
import cn.fly.verify.fq;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f2214a = false;
    private static eb b;
    private File c;
    private BigInteger d = new BigInteger("f53c224aefb38daa0825c1b8ea691b16d2e16db10880548afddd780c6670a091a11dafa954ea4a9483797fda1045d2693a08daa48cf9cedce1e8733b857304cb", 16);
    private BigInteger e = new BigInteger("27749621e6ca022469645faed16e8261acf6af822467382d55c24bb9bc02356ab16e76ddc799dc8ba6b4f110411996eeb63505c9dcf969d3fc085d712f0f1a9713b67aa1128d7cc41bda363afb0ec7ade60e542a4e22869395331cc0096de412034551e98bb2629ae1b7168b8bc82006d064ab335d8567283e70beb6a49e9423", 16);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2216a;
        private int b;
        private String c;
        private String d;

        private a() {
        }

        private void b(final int i, final int i2, final String str, final String str2) {
            en.a().a("[LGSM] SLR: onL", new Object[0]);
            if (eb.a().a(new gh() { // from class: cn.fly.verify.eb.a.1
                @Override // cn.fly.verify.gh
                public void a() throws Throwable {
                    en.a().a("[LGSM] SLR: Ins", new Object[0]);
                    HashMap map = new HashMap();
                    map.put(ec.b("010.egcbckfi;e*ciegchdcXd"), Integer.valueOf(i));
                    map.put(ec.b("006]egcbckdj$cIdd"), str);
                    map.put(ec.b("004hPcj7ie"), Integer.valueOf(i2));
                    map.put(ec.b("005e$cici1ch"), Long.valueOf(System.currentTimeMillis()));
                    String strEncode = URLEncoder.encode(str2);
                    if (TextUtils.isEmpty(strEncode)) {
                        strEncode = str2;
                    }
                    map.put(ec.b("003Uceegdd"), Base64.encodeToString(strEncode.getBytes("utf-8"), 2));
                    map.put(ec.b("005hOchce4eHeg"), 1);
                    en.a().a("[LGSM] W l " + map, new Object[0]);
                    eb.b(i2).a(fv.a(map));
                }
            }) && ei.b()) {
                en.a().a("[LGSM] SLR: U", new Object[0]);
                ek.c.execute(new c());
            }
        }

        public a a(int i, int i2, String str, String str2) {
            this.f2216a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b(this.f2216a, this.b, this.c, this.d);
            } catch (Throwable th) {
                en.a().b(th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements eo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<HashMap<String, Object>> f2218a;
        int b;
        String c;

        private b() {
            this.f2218a = new ArrayList<>();
            this.b = -1;
        }

        private HashMap<String, Object> a(fq.b bVar, int i, String str) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(ec.b("003$ck1e8cj"), ef.a());
            map.put(ec.b("004(cbcfchcb"), dp.a((bd) null));
            map.put(ec.b("004ifch"), Integer.valueOf(fq.d.e()));
            map.put(ec.b("003.egcbck"), str);
            map.put(ec.b("006^egcbckccUeAci"), Integer.valueOf(i));
            map.put(ec.b("007ciidc^ce9e"), bVar.j());
            map.put(ec.b("006ciiiLckdd"), fq.d.c());
            map.put(ec.b("006cii0cc<eUci"), String.valueOf(fq.d.m()));
            map.put(ec.b("005*cedccb_ef"), fq.d.j());
            if (by.b()) {
                map.put(ec.b("008_cb[ePccch8be7chcb"), bVar.i());
            }
            map.put(ec.b("006Yegcjegcc,e<ci"), String.valueOf(fq.d.g()));
            map.put(ec.b("011dehBeedccickCh:cjIie"), bVar.h());
            return map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private String b(String str) throws Throwable {
            ByteArrayInputStream byteArrayInputStream;
            Throwable th;
            byte[] bytes;
            GZIPOutputStream gZIPOutputStream;
            Throwable th2;
            try {
                bytes = str.getBytes();
                byteArrayInputStream = new ByteArrayInputStream(bytes);
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = byteArrayInputStream.read(bArr, 0, 1024);
                                    if (i == -1) {
                                        gZIPOutputStream.flush();
                                        eg.a(gZIPOutputStream);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.flush();
                                        String strEncodeToString = Base64.encodeToString(byteArray, 2);
                                        eg.a(byteArrayOutputStream, byteArrayInputStream);
                                        return strEncodeToString;
                                    }
                                    gZIPOutputStream.write(bArr, 0, i);
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                                eg.a(gZIPOutputStream);
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            gZIPOutputStream = null;
                            th2 = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        eg.a(bytes, byteArrayInputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bytes = null;
                    eg.a(bytes, byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th7) {
                byteArrayInputStream = null;
                th = th7;
                bytes = null;
            }
        }

        @Override // cn.fly.verify.eo.a
        public void a(String str) {
            en.a().a("[LGSM] ULL onRd " + str, new Object[0]);
            HashMap<String, Object> mapA = fv.a(str);
            try {
                this.b = Integer.parseInt(String.valueOf(mapA.get(ec.b("010Cegcbckfi*eYciegchdc'd"))));
            } catch (Throwable unused) {
            }
            this.c = (String) mapA.get(ec.b("006@egcbckdjRcQdd"));
            this.f2218a.add(mapA);
        }

        @Override // cn.fly.verify.eo.a
        public boolean a(fq.b bVar) {
            String strB;
            en.a().a("[LGSM] ULL onUd", new Object[0]);
            HashMap<String, Object> mapA = a(bVar, this.b, this.c);
            mapA.put(ec.b("006e3ciciceegdd"), this.f2218a);
            try {
                String strA = fv.a((HashMap) mapA);
                this.f2218a.clear();
                strB = b(strA);
            } catch (Throwable th) {
                en.a().a("[LGSM] ULL onUd: E", new Object[0]);
                en.a().a(th);
            }
            if (ec.b("004dGdcNde").equals(bVar.h())) {
                throw new IllegalStateException("network is disconnected!");
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("m", strB);
            fl.a aVar = new fl.a();
            aVar.f2355a = 10000;
            aVar.b = 10000;
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(ec.b("013^dfeg:e9cigjdhcbBedh5chNhTcj"), bu.c());
            map2.put(ec.b("004Ccedcchcb"), bVar.B());
            String str = dt.a().a(com.kuaishou.weapon.p0.t.n) + "/errlog";
            en.a().a("[LGSM] ULL onUd: Req", new Object[0]);
            String strB2 = new fl().b(str, map, map2, aVar);
            en.a().a("[LGSM] ULL onUd: " + String.format("Resp(%s): %s", str, strB2), new Object[0]);
            Object obj = fv.a(strB2).get(ec.b("006!egEhch<cfeg"));
            return (obj != null ? ((Integer) obj).intValue() : 0) == 200;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Runnable f2219a;

        private c() {
            this.f2219a = new gh() { // from class: cn.fly.verify.eb.c.1
                @Override // cn.fly.verify.gh
                public void a() {
                    en.a().a("[LGSM] UCLR", new Object[0]);
                    eb.b(1).a(new b());
                }
            };
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (by.c()) {
                    fq.a(ax.g()).h().a(new fq.a() { // from class: cn.fly.verify.eb.c.2
                        @Override // cn.fly.verify.fq.a
                        public void a(fq.b bVar) {
                            if (ec.b("004d?dc$de").equals(bVar.h())) {
                                return;
                            }
                            int iIntValue = ((Integer) by.a(ec.b("004be-cici"), 1)).intValue();
                            en.a().a("[LGSM] ULR Ck cerr: " + iIntValue, new Object[0]);
                            if (iIntValue == 1) {
                                eb.a().a(c.this.f2219a);
                            } else {
                                eb.b(1).a(((Long) by.a("cerr_max", 104857600L)).longValue());
                            }
                        }
                    });
                } else {
                    en.a().a("[LGSM] ULR Ck nt: FBDN", new Object[0]);
                }
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
    }

    private eb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static eo b(int i) {
        return new eo(ec.b("005GecceGbfQdd"), ec.b("005GecceGbfQdd") + "-" + i, 50);
    }

    public int a(int i, String str) {
        if (ax.f() != null && f2214a) {
            Intent intent = new Intent();
            intent.setPackage(ec.b("015bdIeceg5gcHci:eLegcbckec!f<dcdd"));
            intent.putExtra(ec.b("007icbQckBcGdd(e"), ax.g().getPackageName());
            intent.putExtra(ec.b("008iScichdccich>hIcj"), i);
            intent.putExtra("ver", ax.f2078a);
            intent.putExtra(ec.b("0037ceegdd"), a(str));
            fy.a(ax.f(), ec.b("013:eg2edJcbehcidc(c,cb2bcSeg<h"), new Object[]{intent}, (Class<?>[]) new Class[]{Intent.class}, 0);
        }
        return 0;
    }

    public static synchronized eb a() {
        if (b == null) {
            b = new eb();
        }
        return b;
    }

    public void b() {
        en.a().a("[LGSM] Sd last", new Object[0]);
        ek.c.execute(new c());
    }

    private String a(String str) {
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrC = eg.c();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    byte[] bArrA = new fw(1024).a(bArrC, this.d, this.e);
                    dataOutputStream.writeInt(bArrA.length);
                    dataOutputStream.write(bArrA);
                    byte[] bArrA2 = fr.a(bArrC, str.getBytes("utf-8"));
                    dataOutputStream.writeInt(bArrA2.length);
                    dataOutputStream.write(bArrA2);
                    dataOutputStream.flush();
                    eg.a(dataOutputStream, byteArrayOutputStream);
                    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                } catch (Throwable th) {
                    th = th;
                    eg.a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
        } catch (Throwable th3) {
            en.a().a(th3);
            return null;
        }
    }

    public void a(int i, String str, int i2, String str2) {
        en.a().a("[LGSM] Sd curr", new Object[0]);
        if (i == 1) {
            new a().a(i2, i, str, str2).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final Runnable runnable) {
        if (this.c == null) {
            File file = new File(ax.g().getFilesDir(), ec.b("005;ecWfCdc3bZck"));
            this.c = file;
            if (!file.exists()) {
                try {
                    this.c.createNewFile();
                } catch (Throwable unused) {
                }
            }
        }
        return ea.a(this.c, new dz() { // from class: cn.fly.verify.eb.1
            @Override // cn.fly.verify.dz
            public boolean a(fs fsVar) {
                runnable.run();
                return false;
            }
        });
    }
}
