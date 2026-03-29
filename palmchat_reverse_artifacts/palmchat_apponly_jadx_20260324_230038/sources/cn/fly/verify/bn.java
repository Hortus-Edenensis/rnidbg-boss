package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bn extends bh {
    public bn() {
        super(ba.a("003-hjfmhj"), 0L, ba.a("006>hjfmhjgg+fl"), 2592000L, bh.a(ba.a("003-hjfmhj"), (Long) 0L));
    }

    @Override // cn.fly.verify.bh
    public void a() {
        fq.a(ax.g()).k().a(new fq.a() { // from class: cn.fly.verify.bn.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                boolean z;
                ArrayList<HashMap<String, String>> arrayListK = bVar.k();
                if (arrayListK == null || arrayListK.isEmpty()) {
                    return;
                }
                long jB = bv.a().b(bv.d, 0L);
                long jL = bn.this.l() * 1000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z2 = jCurrentTimeMillis - jL >= jB;
                if (!z2) {
                    ArrayList<HashMap<String, String>> arrayListA = fz.a(dx.e, true);
                    Iterator<HashMap<String, String>> it = arrayListK.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str = it.next().get(ba.a("003lGfngg"));
                        if (!TextUtils.isEmpty(str)) {
                            Iterator<HashMap<String, String>> it2 = arrayListA.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = false;
                                    break;
                                } else if (str.equals(it2.next().get(ba.a("003lMfngg")))) {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                }
                if (z2) {
                    bn.this.a(0L, "SALMT", arrayListK);
                    fz.a(arrayListK, dx.e, true);
                    bv.a().a(bv.d, jCurrentTimeMillis);
                }
            }
        });
    }
}
