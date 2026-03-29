package cn.fly.verify;

import android.content.pm.ApplicationInfo;
import android.util.Base64;
import cn.fly.verify.fq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class br extends bh {
    private static final String c = ec.b("016Sebdkdidjcgdffkebffdkejcgdjdhgbfg");
    private static final String d = ec.b("016Oebdkdidjcgekdkdhebfgejcgejdkdjdk");

    public br() {
        super(ec.b("002if"), 0L, ec.b("005if8ddGci"), 86400L, bh.a(ec.b("002if"), (Long) 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b(HashMap<String, Object> map) {
        try {
            map.put(ec.b("005bif1dk4h"), Long.valueOf(System.currentTimeMillis()));
            return b(map, dt.a().a("gclg") + ec.b("004kbif"));
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    private void n() {
        fq.a(ax.g()).h().a(new fq.a() { // from class: cn.fly.verify.br.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) throws Throwable {
                final List list;
                HashMap<String, Object> map = new HashMap<>();
                String strA = ef.a();
                String strA2 = dp.a((bd) null);
                map.put(ec.b("006ciiIckDeTcj"), strA);
                map.put(ec.b("006ciiiJckdd"), fq.d.c());
                map.put(ec.b("006ciiZccQeDci"), Integer.valueOf(fq.d.m()));
                map.put(ec.b("0047cbcfchcb"), strA2);
                map.put(ec.b("004ifch"), Integer.valueOf(fq.d.e()));
                map.put(ec.b("011dehQeedccick[h^cjEie"), bVar.h());
                map.put(ec.b("009fcLeg9h2fiTifIdk[h"), Long.valueOf(bv.a().b(br.c, 0L)));
                String strEncodeToString = Base64.encodeToString((strA + ":" + strA2).getBytes("utf-8"), 2);
                map.put(ec.b("009fcFeg h!fi=if1dhcb"), strEncodeToString);
                HashMap map2 = (HashMap) br.b(map, dt.a().a("gclg") + ec.b("004kYcc.if"));
                if (map2 == null || map2.size() == 0 || (list = (List) map2.get(ec.b("004i]ckddeg"))) == null || list.size() <= 0) {
                    return;
                }
                bv.a().a(br.c, System.currentTimeMillis());
                final ArrayList arrayList = new ArrayList();
                en.a().a("[dhss] vpl", new Object[0]);
                fq.c cVarA = fq.a(ax.g());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    cVarA.a(180000, (String) it.next(), 0);
                }
                cVarA.a(new fq.a() { // from class: cn.fly.verify.br.1.1
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar2) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            try {
                                Object objN = bVar2.n(i);
                                if (objN != null) {
                                    String str = (String) list.get(i);
                                    ApplicationInfo applicationInfoA = fd.a(objN, str);
                                    HashMap map3 = new HashMap();
                                    map3.put(ec.b("006ciii7ckdd"), str);
                                    map3.put(ec.b("006cii:cc3e4ci"), fd.c(objN, str));
                                    if (applicationInfoA != null) {
                                        int i2 = applicationInfoA.flags;
                                        boolean z = true;
                                        boolean z2 = (i2 & 1) == 1;
                                        boolean z3 = (i2 & 128) != 0;
                                        String strB = ec.b("0056chegegcjeg");
                                        if (!z2 && !z3) {
                                            z = false;
                                        }
                                        map3.put(strB, Boolean.valueOf(z));
                                    }
                                    arrayList.add(map3);
                                }
                            } catch (Throwable th) {
                                en.a().a(th);
                            }
                        }
                    }
                });
                map.remove(ec.b("011dehYeedccick9h9cj3ie"));
                map.remove(ec.b("009fc(egMh4fiAif8dkJh"));
                map.remove(ec.b("009fcXeg>hYfiOif;dhcb"));
                map.put(ec.b("0057cedccb2ef"), fq.d.j());
                map.put(ec.b("008,cb;cheh<chce<e"), Long.valueOf(System.currentTimeMillis()));
                map.put(ec.b("002Achcb"), strEncodeToString);
                map.put(ec.b("004iNckddeg"), arrayList);
                Object objB = br.this.b(map);
                if (objB == null) {
                    objB = br.this.b(map);
                }
                if (objB == null) {
                    br.this.a(map);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(HashMap<String, Object> map, String str) throws Throwable {
        if (!by.c()) {
            return null;
        }
        return new fk(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b67" + ec.b("023Oge8cQgcWbc[ghcbhigc@e'de3ePcb4e9gkgcLe@gdgige:cUiede"), "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1").a(map, str, false);
    }

    @Override // cn.fly.verify.bh
    public void a() {
        if (az.a().g()) {
            try {
                Thread.sleep(((Long) a(d(), 0L)).longValue() * 1000);
                HashMap<String, Object> map = (HashMap) bv.a().c(d, null);
                if (map != null && !map.isEmpty() && b(map) != null) {
                    a((HashMap<String, Object>) null);
                }
            } catch (Throwable unused) {
            }
            n();
        }
    }

    public synchronized void a(HashMap<String, Object> map) {
        if (map == null) {
            bv.a().b(d);
        } else {
            bv.a().b(d, map);
        }
    }
}
