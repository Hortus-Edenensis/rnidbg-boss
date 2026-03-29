package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.gj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bt extends bh {
    private volatile long c;
    private volatile AtomicInteger d;

    public bt() {
        super(dx.a("002Bdd-e"), 0L, dx.a("0044dd%e$dfbh"), 300L, bh.a(dx.a("002Bdd-e"), (Long) 0L));
        this.c = 0L;
        this.d = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.c = System.currentTimeMillis();
        eg.a(new ge<ArrayList<HashMap<String, Object>>>() { // from class: cn.fly.verify.bt.2
            @Override // cn.fly.verify.ge
            public void a(ArrayList<HashMap<String, Object>> arrayList) {
                if (arrayList != null) {
                    try {
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<HashMap<String, Object>> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Object obj = it.next().get(dx.a("005!dgchchcgdi"));
                            if (obj != null) {
                                arrayList2.add(String.valueOf(obj));
                            }
                        }
                        Collections.sort(arrayList2);
                        String strB = fr.b(TextUtils.join("", arrayList2));
                        bv bvVarA = bv.a();
                        String str = bv.j;
                        String strB2 = bvVarA.b(str, (String) null);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        bv bvVarA2 = bv.a();
                        String str2 = bv.k;
                        long jB = bvVarA2.b(str2, 0L);
                        long jIntValue = ((Integer) bt.this.a(dx.a("005Vdd$eMcc.bh"), Integer.valueOf(com.cdo.oaps.ad.p.j))).intValue() * 1000;
                        if (strB2 == null || !strB2.equals(strB) || jCurrentTimeMillis - jIntValue >= jB) {
                            bt.this.a(0L, "WLMT", (Object) arrayList, true);
                            bv.a().a(str, strB);
                            bv.a().a(str2, jCurrentTimeMillis);
                        }
                    } catch (Throwable th) {
                        en.a().b(th);
                    }
                }
            }
        });
    }

    @Override // cn.fly.verify.bh
    public void a() {
        Object obj = this.b;
        if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            this.d.set(0);
        }
        m();
    }

    @Override // cn.fly.verify.bh
    public void c() {
        gj.a().a(getClass().getName(), new gj.a() { // from class: cn.fly.verify.bt.1
            @Override // cn.fly.verify.gj.a
            public void a() {
                if (bt.this.e()) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis() - bt.this.c;
                        long jIntValue = ((Integer) by.a("wsct", 300)).intValue() * 1000;
                        if (jCurrentTimeMillis >= jIntValue) {
                            bt.this.m();
                        } else if (bt.this.d.get() == 0) {
                            bt.this.d.getAndSet(1);
                            bt btVar = new bt();
                            btVar.a(Boolean.TRUE).a(true);
                            bi.a().a(btVar, (jIntValue - jCurrentTimeMillis) / 1000, 0);
                        }
                    } catch (Throwable th) {
                        en.a().a(th);
                    }
                }
            }
        });
    }
}
