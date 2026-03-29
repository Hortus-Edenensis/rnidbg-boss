package cn.fly.verify;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fl;
import cn.fly.verify.fq;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2079a = false;
    private final byte[] b = new byte[0];

    /* JADX INFO: compiled from: SearchBox */
    public class a implements bd {
        public a() {
        }

        @Override // cn.fly.verify.bd
        public String a() {
            return bq.a("006!hlhhididhhfi");
        }

        @Override // cn.fly.verify.bd
        public int b() {
            return ax.f2078a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2083a;
        private long b;
        private String c;
        private long d;
        private String e;

        public b(String str, long j, String str2, long j2, String str3) {
            this.f2083a = str;
            this.b = j;
            this.c = str2;
            this.d = j2;
            this.e = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static b a(String str) {
            long jIntValue;
            long j;
            long jIntValue2;
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap mapA = fv.a(str);
                    String str2 = (String) mapA.get(bq.a("004Tedehejed"));
                    if (TextUtils.isEmpty(str2) || TextUtils.equals(com.igexin.push.core.b.m, str2)) {
                        str2 = null;
                    }
                    String str3 = (String) mapA.get("genType");
                    String str4 = (TextUtils.isEmpty(str3) || TextUtils.equals(com.igexin.push.core.b.m, str3)) ? null : str3;
                    String str5 = (String) mapA.get(bq.a("002DffJk"));
                    String str6 = (TextUtils.isEmpty(str5) || TextUtils.equals(com.igexin.push.core.b.m, str5)) ? null : str5;
                    Object obj = mapA.get("gt");
                    if (obj == null) {
                        jIntValue = 0;
                    } else if (obj instanceof Long) {
                        jIntValue = ((Long) obj).longValue();
                    } else if (obj instanceof Integer) {
                        jIntValue = ((Integer) obj).intValue();
                    }
                    Object obj2 = mapA.get("expTime");
                    if (obj2 == null) {
                        j = 0;
                    } else {
                        if (obj2 instanceof Long) {
                            jIntValue2 = ((Long) obj2).longValue();
                        } else {
                            if (obj2 instanceof Integer) {
                                jIntValue2 = ((Integer) obj2).intValue();
                            }
                            j = 0;
                        }
                        j = jIntValue2;
                    }
                    return new b(str2, jIntValue, str4, j, str6);
                } catch (Throwable th) {
                    en.a().a(th);
                }
            }
            return null;
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> map = new HashMap<>();
            map.put(bq.a("004%edehejed"), this.f2083a);
            map.put("gt", Long.valueOf(this.b));
            map.put("genType", this.c);
            map.put("expTime", Long.valueOf(this.d));
            map.put(bq.a("002[ffVk"), this.e);
            return map;
        }

        public String c() {
            return this.f2083a;
        }

        public long d() {
            return this.b;
        }

        public String e() {
            return this.c;
        }

        public long f() {
            return this.d;
        }

        public String g() {
            return this.e;
        }

        public String a() {
            return fv.a((HashMap) b());
        }

        public boolean a(long j) {
            long j2 = this.d;
            return j2 == 0 || j + (j2 * 1000) <= System.currentTimeMillis();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final List<String> f2084a = Arrays.asList("4c5f81a0-4728-476f-a57f-b46fa44f07d3", "f6af99e2-2b64-4eb6-aba6-4d44fb935939", "00000000-0000-0000-0000-000000000000");
        private List<String> b;

        private c() {
        }

        private void c() {
            d dVarJ = ax.f2078a + 30 >= d() ? bv.a().j() : e();
            if (dVarJ != null && dVarJ.c() != null) {
                this.b = dVarJ.c();
            }
            if (this.b == null) {
                this.b = f2084a;
            }
        }

        private int d() {
            return Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        }

        private d e() {
            try {
                fl flVar = new fl();
                fl.a aVar = new fl.a();
                aVar.b = 2000;
                aVar.f2355a = 5000;
                String strB = flVar.b(dt.a().a("dg") + "/getDuidBlacklist", null, null, aVar);
                HashMap mapA = fv.a(strB);
                if (mapA != null && !mapA.isEmpty()) {
                    if (!"200".equals(String.valueOf(mapA.get(bq.a("006$gi,jejWehgi"))))) {
                        throw new Throwable("RS is illegal: " + strB);
                    }
                    String strValueOf = String.valueOf(mapA.get(bq.a("004'edQeje")));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        d dVarA = d.a(fr.a(f(), Base64.decode(strValueOf, 0)));
                        bv.a().a(dVarA);
                        return dVarA;
                    }
                }
            } catch (Throwable th) {
                en.a().a(th);
            }
            return null;
        }

        private String f() {
            String[] strArr = {"QvxJJ", "FYsAX", "cvWe", "MqlWJL"};
            return strArr[1] + strArr[3] + new String[]{"akuRE", "wbMqR", "uBs", "CDpnc"}[3];
        }

        public b a() {
            c();
            return b();
        }

        public b b() {
            boolean z = true;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = new String[1];
            fq.a(ax.g()).l().a(new fq.a() { // from class: cn.fly.verify.ay.c.1
                @Override // cn.fly.verify.fq.a
                public void a(fq.b bVar) throws Throwable {
                    try {
                        strArr[0] = bVar.l();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            try {
                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
            try {
                String strJ = fq.d.j();
                String strTrim = strJ == null ? null : strJ.trim();
                String strAh = er.a(ax.g()).d().ah();
                if (TextUtils.isEmpty(strAh)) {
                    strAh = (TextUtils.isEmpty(strArr[0]) || this.b.contains(strArr[0])) ? null : strArr[0];
                }
                if (TextUtils.isEmpty(strAh)) {
                    strAh = a(SystemClock.elapsedRealtime());
                } else {
                    z = false;
                }
                String str = strTrim + ":" + strAh + ":" + ((Object) null) + ":" + ((Object) null);
                try {
                } catch (Throwable th) {
                    en.a().a(th);
                }
                String strB = !TextUtils.isEmpty(str) ? fr.b(fr.a(str)) : null;
                if (z) {
                    strB = "s_" + strB;
                }
                b bVar = new b(strB, System.currentTimeMillis(), "client", 0L, Base64.encodeToString(str.getBytes(), 2));
                bv.a().a(bVar);
                return bVar;
            } catch (Throwable th2) {
                en.a().a(th2);
                return null;
            }
        }

        private String a(long j) {
            String string = UUID.randomUUID().toString();
            return TextUtils.isEmpty(string) ? b(j) : string;
        }

        private String b(long j) {
            ByteArrayOutputStream byteArrayOutputStream;
            DataOutputStream dataOutputStream;
            String strB = null;
            try {
                long jNextLong = new SecureRandom().nextLong();
                long jCurrentTimeMillis = j + System.currentTimeMillis();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    try {
                        dataOutputStream.writeLong(jNextLong);
                        dataOutputStream.writeLong(jCurrentTimeMillis);
                        strB = fr.b(byteArrayOutputStream.toByteArray());
                        eg.a(dataOutputStream, byteArrayOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            en.a().a(th);
                            eg.a(dataOutputStream, byteArrayOutputStream);
                        } catch (Throwable th2) {
                            eg.a(dataOutputStream, byteArrayOutputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            }
            return strB;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f2086a;
        private List<String> b;

        public d(List<String> list, List<String> list2) {
            this.f2086a = list;
            this.b = list2;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static d a(String str) {
            List<String> listB;
            List<String> listB2;
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap mapA = fv.a(str);
                    Object obj = mapA.get("idfas");
                    if (obj == null) {
                        listB = null;
                    } else if (obj instanceof String) {
                        listB = b((String) obj);
                    } else if (obj instanceof List) {
                        listB = (List) obj;
                    }
                    Object obj2 = mapA.get("oiid");
                    if (obj2 == null) {
                        listB2 = null;
                    } else if (obj2 instanceof String) {
                        listB2 = b((String) obj2);
                    } else if (obj2 instanceof List) {
                        listB2 = (List) obj2;
                    }
                    return new d(listB, listB2);
                } catch (Throwable th) {
                    en.a().a(th);
                }
            }
            return null;
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> map = new HashMap<>();
            map.put("idfas", this.f2086a);
            map.put("oiid", this.b);
            return map;
        }

        public List<String> c() {
            return this.f2086a;
        }

        public List<String> d() {
            return this.b;
        }

        private static List<String> b(String str) {
            String[] strArrSplit;
            return (TextUtils.isEmpty(str) || (strArrSplit = str.split(",")) == null || strArrSplit.length <= 0) ? new ArrayList() : new ArrayList(Arrays.asList(strArrSplit));
        }

        public String a() {
            return fv.a((HashMap) b());
        }
    }

    private String c() {
        return bq.a("016)giedemgeOd(feegegfe(fek'gegiedem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d() {
        return fz.a(ax.g(), dx.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        bv bvVarA = bv.a();
        String str = bv.f2120a;
        long jB = bvVarA.b(str, -1L);
        if (jB != -1) {
            return System.currentTimeMillis() >= jB + (((Long) by.a(bq.a("005Iedejff^ek"), 2592000L)).longValue() * 1000);
        }
        bv.a().a(str, System.currentTimeMillis());
        return false;
    }

    public synchronized String a() {
        b bVarK = bv.a().k();
        if (bVarK == null || TextUtils.isEmpty(bVarK.c())) {
            return null;
        }
        return bVarK.c();
    }

    public synchronized String b() {
        String strA;
        Throwable th;
        try {
            strA = a();
            try {
                if (!TextUtils.isEmpty(strA) && !TextUtils.equals(com.igexin.push.core.b.m, strA)) {
                    return strA;
                }
                b bVarA = new c().a();
                if (bVarA != null) {
                    strA = bVarA.c();
                }
            } catch (Throwable th2) {
                th = th2;
                en.a().a(th);
            }
        } catch (Throwable th3) {
            strA = null;
            th = th3;
        }
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> e() {
        try {
            return a(fq.d.j(), fz.b(d()));
        } catch (Throwable th) {
            en.a().a(th);
            return new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, fq.b bVar) {
        try {
            if (!by.c()) {
                return null;
            }
            b bVarK = bv.a().k();
            if (bVarK != null && !bVarK.a(bv.a().b("key_request_duid_time", 0L)) && !ej.a().d()) {
                return null;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put(bq.a("004khej"), 1);
            map.put(bq.a("005%egfeed?gh"), fq.d.j());
            map.put(bq.a("007Yfg-edjIfeekel"), fq.d.k());
            map.put("admt", bVar.l());
            map.put("oamt", er.a(ax.g()).d().ah());
            map.put("btt", Long.valueOf(SystemClock.elapsedRealtime()));
            map.put(bq.a("0047ekedejed"), ej.a().e());
            map.put("v", ej.a().b());
            map.put(bq.a("004k=ehejed"), ej.a().g());
            map.put(bq.a("0052edekegejed"), ej.a().h());
            map.put(bq.a("008j!feXkJeiedekeggi"), ej.a().i());
            if (bVarK == null) {
                map.put(bq.a("004-edehejed"), str);
                map.put("genType", "common");
            } else {
                map.put(bq.a("004;edehejed"), bVarK.c());
                map.put("gt", Long.valueOf(bVarK.d()));
                map.put("genType", bVarK.e());
                map.put("expTime", Long.valueOf(bVarK.f()));
                map.put(bq.a("002:ffXk"), bVarK.g());
            }
            HashMap map2 = (HashMap) new fk(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd").b(true, null, map, dt.a().a("dg") + "/v4/dgen", true);
            if (map2 != null) {
                bv.a().a("key_request_duid_time", System.currentTimeMillis());
                String str2 = (String) map2.get(bq.a("004'ekedejed"));
                if (!TextUtils.isEmpty(str2)) {
                    ej.a().a(str2);
                }
                b bVarA = b.a(fv.a(map2));
                if (bVarA != null) {
                    bv.a().a(bVarA);
                    return bVarA.c();
                }
            }
        } catch (Throwable th) {
            en.a().b(th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(String str, HashMap<String, Object> map) {
        String strA = fv.a((HashMap) map);
        try {
            return fr.a(str, strA);
        } catch (Throwable th) {
            en.a().a(th);
            return strA.getBytes();
        }
    }

    private static HashMap<String, Object> a(String str, byte[] bArr) throws Throwable {
        return fv.a(fr.a(str, bArr));
    }

    public void a(final bd bdVar, final ge<Void> geVar) {
        en.a().a("di init", new Object[0]);
        fq.a(ax.g()).l().d().q().p().s().a().o().t().c().h().C().B().z().r().E().F().a(new fq.a() { // from class: cn.fly.verify.ay.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                try {
                    synchronized (ay.this.b) {
                        String strA = ay.this.a(dp.f2189a, bVar);
                        HashMap mapE = ay.this.e();
                        boolean zA = ay.this.a((HashMap<String, Object>) mapE, bVar);
                        boolean zF = ay.this.f();
                        ay.this.f2079a = zA || zF;
                        boolean zA2 = ay.this.a((HashMap<String, Object>) mapE, bdVar, bVar);
                        en.a().a("map: " + mapE + "\nisCh: " + zA + ", isG: " + zF + ", isReg: " + zA2, ", udif:" + ay.this.f2079a);
                        if (ay.this.f2079a) {
                            if (TextUtils.isEmpty(strA)) {
                                strA = dp.f2189a;
                            }
                            ay.this.a((HashMap<String, Object>) mapE, strA, bVar);
                        }
                        if (zA || zA2) {
                            ay.this.a((HashMap<String, Object>) mapE);
                        }
                    }
                } finally {
                    geVar.a(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final HashMap<String, Object> map) {
        ea.a(ea.a(ea.c), new dz() { // from class: cn.fly.verify.ay.2
            @Override // cn.fly.verify.dz
            public boolean a(fs fsVar) {
                fz.a(ay.this.d(), ay.b(fq.d.j(), map));
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> map, String str, fq.b bVar) {
        try {
            if (by.c()) {
                HashMap map2 = (HashMap) map.get(bq.a("010WedBgHeeej2dgSfjGf2fgfe"));
                HashMap map3 = new HashMap();
                map3.put(bq.a("005j,feemUgf"), bw.a().b());
                for (Map.Entry entry : map2.entrySet()) {
                    map3.put(entry.getKey(), entry.getValue());
                }
                try {
                    map3.put(bq.a("007de4ekekejHg7ek"), Integer.valueOf(Integer.parseInt(String.valueOf(map3.get(bq.a("007de5ekekejWg4ek"))))));
                } catch (Throwable unused) {
                }
                map3.put(bq.a("0048edehejed"), str);
                HashMap<String, Long> mapQ = bVar.q();
                HashMap<String, HashMap<String, Long>> mapP = bVar.p();
                if (mapQ != null) {
                    map3.put(bq.a("003Pek;e[eg"), mapQ.get(bq.a("005jPfeRjeh")));
                }
                if (mapP != null) {
                    HashMap<String, Long> map4 = mapP.get(bq.a("006Xgied8deVeked"));
                    if (map4 != null) {
                        map3.put(bq.a("013>gied:de[ekedfkVj9feek0e=ffSg"), map4.get(bq.a("005jIfe,jeh")));
                    }
                    HashMap<String, Long> map5 = mapP.get(bq.a("0042ed_eje"));
                    if (map5 != null) {
                        map3.put(bq.a("011+ed_eje!fk4j)feek@e_ff'g"), map5.get(bq.a("005j[feJjeh")));
                    }
                }
                map3.put(bq.a("006Wekfeegfjegff"), bVar.r());
                String strEncodeToString = Base64.encodeToString(fr.a(c(), fv.a(map3)), 2);
                HashMap<String, Object> map6 = new HashMap<>();
                map6.put("m", strEncodeToString);
                fl.a aVar = new fl.a();
                aVar.f2355a = 30000;
                aVar.b = 30000;
                fl flVar = new fl();
                String str2 = dt.a().a("dg") + bq.a("006mXedejHf.fgfe");
                HashMap<String, String> map7 = new HashMap<>();
                map7.put(bq.a("013Wfhgi:gFekilfjedYgfj_ej>j3el"), bu.c());
                map7.put(bq.a("004?egfeejed"), er.a(ax.g()).d().ai());
                if ("200".equals(String.valueOf(fv.a(flVar.b(str2, map6, map7, aVar)).get(bq.a("006NgiHjej_ehgi"))))) {
                    bv.a().a(bv.f2120a, System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    private boolean a(bd bdVar, HashMap<String, Object> map, fq.b bVar) throws Throwable {
        if (!by.c()) {
            return false;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(bq.a("007kCekfeedeh9dj"), bdVar.a());
        b bVarK = bv.a().k();
        String strC = bVarK != null ? bVarK.c() : null;
        String strValueOf = String.valueOf(fq.d.c());
        map2.put(bq.a("006ekkVemJgUel"), ef.a());
        map2.put(bq.a("004Iedehejed"), strC);
        map2.put(bq.a("006ekkkIemff"), strValueOf);
        map2.put(bq.a("006ekkDee:g ek"), String.valueOf(fq.d.m()));
        map2.put(bq.a("006ZgiedemeeFg=ek"), String.valueOf(bdVar.b()));
        map2.put(bq.a("007fgj*ggfeekem"), String.valueOf(bVar.h()));
        String str = dt.a().a("dg") + bq.a("006mVedgiejff0f");
        HashMap<String, String> map3 = new HashMap<>();
        map3.put(bq.a("013(fhgi,gEekilfjedMgfj$ej9jRel"), bu.c());
        map3.put(bq.a("004=egfeejed"), bVar.B());
        fl.a aVar = new fl.a();
        aVar.f2355a = 10000;
        aVar.b = 10000;
        HashMap mapA = fv.a(new fl().b(str, map2, map3, aVar));
        if (bq.a("004jEekeh?g").equals(String.valueOf(mapA.get(bq.a("004)ek%g%ehMk"))))) {
            this.f2079a = true;
        }
        if (!"200".equals(String.valueOf(mapA.get(bq.a("006?giJjej^ehgi"))))) {
            return false;
        }
        HashMap map4 = (HashMap) map.get(bq.a("007ekk%fjBf6fgfe"));
        HashMap map5 = (HashMap) map4.get(strValueOf);
        if (map5 == null) {
            map5 = new HashMap();
        }
        map5.put(bdVar.a(), ef.a());
        map4.put(strValueOf, map5);
        map.put(bq.a("007ekkOfj:f3fgfe"), map4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map, bd bdVar, fq.b bVar) {
        if (bdVar == null) {
            bdVar = new a();
        }
        boolean z = false;
        try {
            HashMap map2 = (HashMap) map.get(bq.a("007ekk2fj4f!fgfe"));
            if (map2 == null) {
                map2 = new HashMap();
                map.put(bq.a("007ekk>fjBf2fgfe"), map2);
                z = true;
            }
            HashMap map3 = (HashMap) map2.get(fq.d.c());
            String str = map3 != null ? (String) map3.get(bdVar.a()) : null;
            String strA = ef.a();
            if (str == null || !str.equals(strA)) {
                if (a(bdVar, map, bVar)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map, fq.b bVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int i = 0;
        if (map == null) {
            map = new HashMap<>();
            z = true;
        } else {
            z = false;
        }
        HashMap map2 = (HashMap) map.get(bq.a("010=ed g?eeejOdgAfjEf0fgfe"));
        if (map2 == null) {
            map2 = new HashMap();
            map.put(bq.a("010:edQg]eeejFdg@fjPf]fgfe"), map2);
            z = true;
        }
        Object obj = map2.get("admt");
        String strL = bVar.l();
        if (strL == null || strL.equals(obj)) {
            z2 = false;
        } else {
            map2.put("admt", strL);
            z2 = true;
        }
        Object obj2 = map2.get(bq.a("004^feXeOejed"));
        String strAh = er.a(ax.g()).d().ah();
        if ((obj2 == null && !TextUtils.isEmpty(strAh)) || (obj2 != null && !String.valueOf(obj2).equals(strAh))) {
            map2.put(bq.a("004Jfe6e.ejed"), strAh);
            z2 = true;
            i = 1;
        }
        Object obj3 = map2.get(bq.a("004$ekedejed"));
        String strC = ej.a().c();
        if ((obj3 == null && !TextUtils.isEmpty(strC)) || (obj3 != null && !String.valueOf(obj3).equals(strC))) {
            map2.put(bq.a("004Mekedejed"), strC);
            i |= 2;
            z2 = true;
        }
        Object obj4 = map2.get(bq.a("005Eedekegejed"));
        String strH = ej.a().h();
        if ((obj4 == null && !TextUtils.isEmpty(strH)) || (obj4 != null && !String.valueOf(obj4).equals(strH))) {
            map2.put(bq.a("005Ledekegejed"), strH);
            i |= 4;
            z2 = true;
        }
        Object obj5 = map2.get(bq.a("004kOehejed"));
        String strG = ej.a().g();
        if ((obj5 == null && !TextUtils.isEmpty(strG)) || (obj5 != null && !String.valueOf(obj5).equals(strG))) {
            map2.put(bq.a("004k)ehejed"), strG);
            i |= 8;
            z2 = true;
        }
        Object obj6 = map2.get("v");
        String strB = ej.a().b();
        if ((obj6 == null && !TextUtils.isEmpty(strB)) || (obj6 != null && !String.valueOf(obj6).equals(strB))) {
            map2.put("v", strB);
            z2 = true;
        }
        map2.put("cid_modify", Integer.valueOf(i));
        if (z2) {
            z = true;
        }
        Object obj7 = map2.get(bq.a("005)egfeedSgh"));
        String strJ = fq.d.j();
        if (strJ != null && !strJ.equals(obj7)) {
            map2.put(bq.a("005[egfeedDgh"), strJ);
            z = true;
        }
        Object obj8 = map2.get(bq.a("007Jfg3edj.feekel"));
        String strK = fq.d.k();
        if (strK != null && !strK.equals(obj8)) {
            map2.put(bq.a("007 fg^edj5feekel"), strK);
            z = true;
        }
        Object obj9 = map2.get(bq.a("007de^ekekej(g8ek"));
        String strD = bVar.d();
        if (strD != null && !strD.equals(obj9)) {
            map2.put(bq.a("007deGekekejUgJek"), strD);
            z = true;
        }
        Object obj10 = map2.get(bq.a("006.gielgiee g[ek"));
        String strH2 = fq.d.h();
        if (strH2 != null && !strH2.equals(obj10)) {
            map2.put(bq.a("0066gielgiee)gMek"), strH2);
            z = true;
        }
        Object obj11 = map2.get(bq.a("002Yfd0k"));
        boolean zS = bVar.s();
        if (obj11 == null || !String.valueOf(zS ? 1 : 0).equals(String.valueOf(obj11))) {
            map2.put(bq.a("002IfdSk"), Integer.valueOf(zS ? 1 : 0));
            z = true;
        }
        Object obj12 = map2.get(bq.a("007HgfekBge6emUgPed"));
        boolean zA = bVar.a();
        map2.put(bq.a("007TgfekXgeOemPg-ed"), Boolean.valueOf(zA));
        if ((obj12 == null && zA) || (obj12 != null && !String.valueOf(obj12).equals(String.valueOf(zA)))) {
            z = true;
        }
        String strValueOf = String.valueOf(map2.get("prelangmt"));
        String strValueOf2 = String.valueOf(bVar.D());
        if (!TextUtils.equals(strValueOf, strValueOf2)) {
            map2.put("prelangmt", strValueOf2);
            z = true;
        }
        Object obj13 = map2.get("gramgendt");
        int iE = bVar.E();
        if (obj13 == null || !TextUtils.equals(String.valueOf(obj13), String.valueOf(iE))) {
            map2.put("gramgendt", Integer.valueOf(iE));
        } else {
            z3 = z;
        }
        map2.put(bq.a("004khej"), Integer.valueOf(fq.d.e()));
        map2.put(bq.a("010Sed$g5eeejGdg>flel%kg"), bVar.o());
        map2.put(bq.a("003keXed"), Integer.valueOf(bVar.t() ? 1 : 0));
        map2.put(bq.a("010.giNd)ekBggf^giejhdTg"), bVar.c());
        HashMap<String, Object> mapA = ca.a(ax.g());
        if (mapA != null && mapA.size() > 0) {
            map2.putAll(mapA);
        }
        return z3;
    }
}
