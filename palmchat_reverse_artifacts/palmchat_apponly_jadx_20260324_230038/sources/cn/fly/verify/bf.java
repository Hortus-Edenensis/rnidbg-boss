package cn.fly.verify;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bf extends bh {
    private static volatile long c;
    private static volatile HashMap<Long, Long> d;

    public bf() {
        super(bq.a("002ej"), 0L, bq.a("005ej;ff'ek"), 900L, 0L);
        if (d == null) {
            c = System.currentTimeMillis();
            d = bv.a().g();
        }
    }

    private void m() {
        try {
            HashMap<String, Object> map = new HashMap<>();
            for (Map.Entry<Long, Long> entry : d.entrySet()) {
                if (entry != null) {
                    map.put(bq.a("008heTeh.fdiHfm;j"), entry.getKey());
                    map.put(bq.a("008:edehekFej4ejfe]f"), entry.getValue());
                }
            }
            a("ARSTAMT", map);
            bv.a().a(bv.f, System.currentTimeMillis());
            if (d != null) {
                d.clear();
            }
            bv.a().b((HashMap<Long, Long>) null);
        } catch (Throwable th) {
            en.a().b(th);
        }
    }

    @Override // cn.fly.verify.bh
    public void a() {
        if (d == null) {
            d = new HashMap<>();
        }
        for (Map.Entry<Long, Long> entry : d.entrySet()) {
            if (entry != null && entry.getKey().longValue() != c) {
                m();
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - c;
        d.put(Long.valueOf(c), Long.valueOf(jCurrentTimeMillis));
        bv.a().b(d);
        long jB = bv.a().b(bv.f, 0L);
        long jL = l() * 1000;
        if (jCurrentTimeMillis < jL || System.currentTimeMillis() - jB <= jL) {
            return;
        }
        m();
    }

    @Override // cn.fly.verify.bh
    public void b() {
        long jLongValue = ((Long) a(d(), 0L)).longValue();
        if (jLongValue <= 0 || jLongValue >= 604800) {
            return;
        }
        a(jLongValue);
    }
}
