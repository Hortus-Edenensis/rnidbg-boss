package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ef {
    public static String a() {
        if (TextUtils.isEmpty(ec.f2222a) && ax.g() != null) {
            ec.a(ax.g());
        }
        return TextUtils.isEmpty(ec.f2222a) ? ec.c : ec.f2222a;
    }

    public static int b() {
        int iD = ei.d();
        if (iD == 1) {
            return 1;
        }
        return iD == 0 ? -1 : 0;
    }

    public static boolean c() {
        int iB = b();
        if (iB != 2 && iB != 1) {
            return true;
        }
        ei.g();
        return true ^ by.a();
    }

    public static HashMap<String, Object> d() {
        final HashMap<String, Object>[] mapArr = {new HashMap<>()};
        fq.a(ax.g()).d().h().r().g().C().a(new fq.a() { // from class: cn.fly.verify.ef.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                mapArr[0] = ef.a(bVar.h());
                mapArr[0].put(bq.a("006'giedemeeYgJek"), Integer.valueOf(ax.f2078a));
                mapArr[0].put(bq.a("004 edehejed"), dp.a((bd) null));
                mapArr[0].put(bq.a("006ekk$ee5gNek"), Integer.valueOf(fq.d.m()));
                mapArr[0].put(bq.a("007de4ekekejWg@ek"), bVar.d());
                mapArr[0].put(bq.a("005Pegfeed^gh"), fq.d.j());
                mapArr[0].put(bq.a("007@fg:edjTfeekel"), fq.d.k());
                mapArr[0].put(bq.a("006Cgielgiee_g2ek"), fq.d.h());
                mapArr[0].put(bq.a("005Wehejee=g2ek"), bVar.r());
                mapArr[0].put(bq.a("009[gielgieeMgPekej>fj"), Integer.valueOf(fq.d.g()));
                mapArr[0].put(bq.a("010dh@ejTgfj_flejegMg"), Long.valueOf(System.currentTimeMillis()));
                mapArr[0].put(bq.a("006ekk>egedij"), bVar.g());
                mapArr[0].put(bq.a("005AgfekTefAed"), fq.d.l());
                mapArr[0].put("usridt", bu.c());
                mapArr[0].put(bq.a("004.egfeejed"), bVar.B());
            }
        });
        return mapArr[0];
    }

    public static String a(String str, String str2, String str3, boolean z) {
        if (!c()) {
            return dt.a().a(str, str2, str3, z);
        }
        en.a().a("isForb: true", new Object[0]);
        return null;
    }

    public static HashMap<String, Object> a(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(bq.a("006ekkKemQg%el"), a());
        map.put(bq.a("006ekkkJemff"), fq.d.c());
        map.put(bq.a("006ekk9ee6g!ek"), fq.d.f());
        map.put(bq.a("004khej"), String.valueOf(fq.d.e()));
        map.put(bq.a("011fgj:ggfeekemYj(elYkg"), str);
        String strB = dp.b();
        if (!TextUtils.isEmpty(strB)) {
            map.put(bq.a("004Qedehejed"), strB);
        }
        return map;
    }

    public static void a(boolean z) {
        try {
            ei.a(z);
        } catch (Throwable th) {
            en.a().b(th);
        }
    }
}
