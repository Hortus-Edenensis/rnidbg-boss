package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bk extends bh {
    public bk() {
        super(bq.a("002Mfe:h"), 0L, bq.a("006,feHhUffJeki"), 60L, bh.a(bq.a("002Mfe:h"), (Long) 0L));
    }

    private void m() {
        fq.a(ax.g()).a(0, 0, true, false).J().I().a(new fq.a() { // from class: cn.fly.verify.bk.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                HashMap<String, Object> mapC;
                JSONObject jSONObject;
                if (bVar.j(new int[0]) == null || (mapC = bk.this.c(bVar.j(new int[0]))) == null || mapC.isEmpty()) {
                    return;
                }
                bk.this.a(mapC, mapC);
                HashMap map = mapC.get("nl") != null ? (HashMap) mapC.get("nl") : null;
                String strH = bVar.H();
                String strI = bVar.I();
                if (!TextUtils.isEmpty(strI)) {
                    mapC.put("cbsmt", strI);
                }
                if (!TextUtils.isEmpty(strH)) {
                    mapC.put("cssmt", strH);
                }
                if (map == null || map.isEmpty()) {
                    jSONObject = new JSONObject(bk.this.b(bVar.j(new int[0])));
                } else {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("ltdmt", map.get("ltdmt"));
                    treeMap.put("lndmt", map.get("lndmt"));
                    jSONObject = new JSONObject(treeMap);
                }
                String strB = fr.b(jSONObject.toString());
                bv bvVarA = bv.a();
                String str = bv.g;
                String strB2 = bvVarA.b(str, (String) null);
                bv bvVarA2 = bv.a();
                String str2 = bv.h;
                long jB = bvVarA2.b(str2, 0L);
                long jLongValue = ((Long) bk.this.a(bq.a("006'fe(h8ffFekh"), 3600L)).longValue() * 1000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strB2) || !strB2.equals(strB) || jCurrentTimeMillis - jB >= jLongValue) {
                    int i = bk.this.g() ? 1 : jCurrentTimeMillis - jB >= jLongValue ? 2 : 3;
                    mapC.put(OapsKey.KEY_PAGE_TYPE, Integer.valueOf(i));
                    if (map != null && !map.isEmpty()) {
                        map.put(OapsKey.KEY_PAGE_TYPE, Integer.valueOf(i));
                    }
                    bk.this.a("O_LCMT", mapC);
                    bv.a().a(str, strB);
                    bv.a().a(str2, jCurrentTimeMillis);
                }
            }
        });
    }

    @Override // cn.fly.verify.bh
    public void a() {
        if (this.b == null) {
            m();
            return;
        }
        en.a().a("[cl] paramObj not null", new Object[0]);
        HashMap<String, Object> mapC = c(this.b);
        if (mapC == null || mapC.isEmpty()) {
            return;
        }
        mapC.put(OapsKey.KEY_PAGE_TYPE, 4);
        a("O_LCMT", mapC);
    }

    @Override // cn.fly.verify.bh
    public void c() {
    }
}
