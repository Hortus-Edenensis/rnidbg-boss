package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bj extends bh {
    public bj() {
        super("l", 0L, dx.a("004e=cc1bh"), 86400L, bh.a("l", (Long) 0L));
    }

    @Override // cn.fly.verify.bh
    public void a() throws Throwable {
        long jB = bv.a().b("key_lgwst", 0L);
        if (fq.d.b(dx.a("036bc_babhcbbgbadbDhdTbhbdbgdfdfbgcb4c(dbeidhcjcfgbefbfeccgdjcgbfchcicjcief")) && fq.d.b(dx.a("036bc$babhcbbgbadb1hdXbhbdbgdfdfbgcb[c;dbcjeieiefchchbfeccgdjcgbfchcicjcief")) && System.currentTimeMillis() - jB >= 1800000) {
            eg.a(new ge<ArrayList<HashMap<String, Object>>>() { // from class: cn.fly.verify.bj.1
                @Override // cn.fly.verify.ge
                public void a(ArrayList<HashMap<String, Object>> arrayList) {
                    bv.a().a("key_lgwst", System.currentTimeMillis());
                    bj.this.a(arrayList);
                }
            });
        } else {
            a((ArrayList<HashMap<String, Object>>) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, Object>> arrayList) {
        try {
            a(arrayList, 2);
            a(arrayList, 1);
        } catch (Throwable th) {
            en.a().b(th);
        }
    }

    private void a(final ArrayList<HashMap<String, Object>> arrayList, final int i) {
        fq.c cVarJ = fq.a(ax.g()).I().J();
        if (i == 1) {
            cVarJ.a(30, 0, true, false);
        } else {
            cVarJ.a(0, 15, true, false);
        }
        cVarJ.a(new fq.a() { // from class: cn.fly.verify.bj.2
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                HashMap<String, Object> mapC;
                if (bVar.j(new int[0]) == null || (mapC = bj.this.c(bVar.j(new int[0]))) == null || mapC.isEmpty()) {
                    return;
                }
                bj.this.a(mapC, mapC);
                String strH = bVar.H();
                String strI = bVar.I();
                if (!TextUtils.isEmpty(strI)) {
                    mapC.put("cbsmt", strI);
                }
                if (!TextUtils.isEmpty(strH)) {
                    mapC.put("cssmt", strH);
                }
                mapC.put(OapsKey.KEY_PAGE_TYPE, Integer.valueOf(bj.this.g() ? 1 : 2));
                mapC.put("lctpmt", Integer.valueOf(i));
                ArrayList arrayList2 = arrayList;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    mapC.put("wilmt", arrayList);
                }
                bj.this.a("LCMT", mapC);
            }
        });
    }
}
