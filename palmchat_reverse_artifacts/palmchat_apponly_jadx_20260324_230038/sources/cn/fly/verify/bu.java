package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f2118a = {ba.a("0086glhlgnikijglhmke"), ba.a("0067gljeglglhmke"), ba.a("007^jeiihkhegkgjke"), ba.a("007_jeiihkingiglhl"), ba.a("009$glijimilijikgkhnkm"), ba.a("008Njeiihkgnhmglhmke"), ba.a("0089jeiihkkfgignikhm")};
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static final HashMap<String, bd> d = new HashMap<>();

    private static synchronized String a(final ArrayList<bd> arrayList, final int i) {
        final String[] strArr;
        strArr = new String[]{""};
        fq.c cVarD = fq.a(ax.g()).r().h().d();
        if (!ei.b() || i == 3) {
            cVarD.c(true);
        } else {
            cVarD.i();
        }
        cVarD.a(new fq.a() { // from class: cn.fly.verify.bu.2
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) throws Throwable {
                String str;
                String str2;
                String str3 = "";
                String strEncode = TextUtils.isEmpty(fq.d.c()) ? "" : URLEncoder.encode(fq.d.c(), "utf-8");
                String strEncode2 = TextUtils.isEmpty(fq.d.f()) ? "" : URLEncoder.encode(fq.d.f(), "utf-8");
                String strEncode3 = TextUtils.isEmpty(fq.d.k()) ? "" : URLEncoder.encode(fq.d.k(), "utf-8");
                String strEncode4 = TextUtils.isEmpty(fq.d.j()) ? "" : URLEncoder.encode(fq.d.j(), "utf-8");
                String strEncode5 = TextUtils.isEmpty(bVar.r()) ? "" : URLEncoder.encode(bVar.r(), "utf-8");
                String strEncode6 = TextUtils.isEmpty(fq.d.h()) ? "" : URLEncoder.encode(fq.d.h(), "utf-8");
                HashMap<String, Object> mapB = ed.a().b();
                String str4 = ba.a("004_gnininCn") + strEncode + com.huawei.openalliance.ad.constant.x.aQ + strEncode2;
                String str5 = ba.a("012VglkmglDn0gnFgIfeflgffkfeli") + fq.d.g() + com.huawei.openalliance.ad.constant.x.aQ + strEncode6;
                String str6 = ba.a("004Rglhmgk%n") + ((!ei.b() || i == 3) ? bVar.d(new int[0]) : bVar.i());
                String str7 = ba.a("0037hnje1n") + strEncode3 + com.huawei.openalliance.ad.constant.x.aQ + strEncode4;
                if (!TextUtils.isEmpty(strEncode5)) {
                    str7 = str7 + com.huawei.openalliance.ad.constant.x.aQ + strEncode5;
                }
                String str8 = ba.a("003EgjijCn") + bVar.h() + com.huawei.openalliance.ad.constant.x.aQ + bVar.d();
                String str9 = ba.a("0052heJfgVggWn") + Locale.getDefault().toString().replace(ba.a("002Pjmfl"), "-");
                String str10 = ba.a("004]imheil4n") + ax.f2078a;
                String strA = ba.a("004_glhmke-n");
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        try {
                            bd bdVar = (bd) arrayList.get(i2);
                            if (i2 != 0) {
                                str2 = str3;
                                try {
                                    strA = strA + ",";
                                } catch (Throwable unused) {
                                }
                            } else {
                                str2 = str3;
                            }
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append(strA);
                                String str11 = strA;
                                try {
                                    sb.append(bdVar.a());
                                    sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                                    sb.append(bdVar.b());
                                    sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                                    sb.append(mapB.get(bdVar.a()));
                                    strA = sb.toString();
                                } catch (Throwable unused2) {
                                    strA = str11;
                                }
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable unused4) {
                            str2 = str3;
                        }
                        i2++;
                        str3 = str2;
                    }
                }
                String str12 = str3;
                int i3 = i;
                String str13 = i3 == 1 ? "DC/[DC]" : i3 == 2 ? "DC/[DC2]" : "DC/9";
                String strI = fq.d.i();
                if (TextUtils.isEmpty(strI)) {
                    str = str12;
                } else {
                    str = ba.a("0032gmknfj") + strI;
                }
                String strC = bw.a().c();
                String str14 = "TID/";
                if (!TextUtils.isEmpty(strC)) {
                    str14 = "TID/" + strC;
                }
                int iA = co.a();
                String str15 = "SVM/" + iA;
                if (es.c()) {
                    if (!ba.a("004VglhmkeVn").equals(strA)) {
                        strA = strA + ",";
                    }
                    strA = strA + "CS;" + iA;
                }
                String strF = ej.a().f();
                String str16 = "RD/";
                if (!TextUtils.isEmpty(strF)) {
                    str16 = "RD/" + strF;
                }
                strArr[0] = str4 + " " + str5 + " " + str6 + " " + str7 + " " + str8 + " " + str9 + " " + str10 + " " + strA + " " + str13 + " " + str + " " + str14 + " " + str15 + " " + str16;
            }
        });
        return strArr[0];
    }

    public static ArrayList<bd> b() {
        ArrayList<bd> arrayList;
        HashMap<String, bd> map = d;
        synchronized (map) {
            if (ei.h() && b.compareAndSet(false, true)) {
                map.putAll(h());
            }
            arrayList = new ArrayList<>();
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    public static synchronized String c() {
        return a(b(), 0);
    }

    public static synchronized String d() {
        return a(b(), 1);
    }

    public static synchronized String e() {
        return a(b(), 2);
    }

    public static synchronized String f() {
        return a(b(), 3);
    }

    private static HashMap<String, bd> h() {
        Class<?> cls;
        HashMap<String, bd> map = new HashMap<>();
        for (Object obj : ee.f2224a) {
            try {
                cls = obj instanceof String ? Class.forName(String.valueOf(obj).trim()) : (Class) obj;
            } catch (Throwable unused) {
            }
            if (!bd.class.isAssignableFrom(cls) || bd.class.equals(cls)) {
                cls.newInstance();
            } else {
                bd bdVar = (bd) cls.newInstance();
                String strA = bdVar.a();
                String[] strArr = f2118a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str = strArr[i];
                        if (str.equals(strA)) {
                            map.put(str, bdVar);
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return map;
    }

    public static void a() {
        g();
        ek.c.execute(new gh() { // from class: cn.fly.verify.bu.1
            @Override // cn.fly.verify.gh
            public void a() {
                en.a().a("init sks start", new Object[0]);
                bu.b();
                en.a().a("init sks over", new Object[0]);
            }
        });
    }

    public static void a(bd bdVar) {
        HashMap<String, bd> map = d;
        synchronized (map) {
            if (bdVar != null) {
                if (!map.containsKey(bdVar.a())) {
                    map.put(bdVar.a(), bdVar);
                }
            }
        }
    }

    private static void g() {
    }
}
