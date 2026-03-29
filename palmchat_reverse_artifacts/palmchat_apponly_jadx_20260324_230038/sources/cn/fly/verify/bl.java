package cn.fly.verify;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bl extends bh {
    private static dv c;
    private static final String d = ed.a("014DdlTf5dkdhBdciAdiddYf2dhOg6edee");

    public bl() {
        super(ed.a("002*fedi"), 0L, ed.a("0050fediee=dj"), 30L, 0L);
    }

    private void b(long j) {
        if (ba.a().b()) {
            return;
        }
        bl blVar = new bl();
        blVar.a(true).b(false).a(new Long[]{3L, Long.valueOf(j)});
        bi.a().a(blVar, l(), 0);
    }

    private void m() {
        try {
            HashMap map = (HashMap) bv.a().c(d, null);
            if (map == null || map.isEmpty()) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                long jLongValue = ((Long) entry.getKey()).longValue();
                long jLongValue2 = ((Long) entry.getValue()).longValue();
                HashMap<String, Object> map2 = new HashMap<>();
                map2.put(ed.a("005YdgDei8diZg"), Long.valueOf(jLongValue2));
                map2.put(ed.a("008Sdjdg^ei:didf8f>fh"), Long.valueOf(jLongValue2 - jLongValue));
                a("BKIOMT", map2);
            }
            bv.a().b(d);
        } catch (Throwable th) {
            en.a().b(th);
        }
    }

    private static synchronized boolean n() {
        if (c != null) {
            return false;
        }
        c = new dv() { // from class: cn.fly.verify.bl.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private volatile long f2106a = 0;

            @Override // cn.fly.verify.dv
            public void a(boolean z, boolean z2, long j) {
                if (z2) {
                    this.f2106a = System.currentTimeMillis();
                    bh blVar = new bl();
                    blVar.a(new Long[]{0L, Long.valueOf(this.f2106a), Long.valueOf(System.currentTimeMillis())}).b(false).a(true);
                    bi.a().a(blVar, 0L, 1);
                }
                if (!z) {
                    if (j > 0) {
                        bh blVar2 = new bl();
                        blVar2.a(new Long[]{2L, Long.valueOf(this.f2106a), Long.valueOf(System.currentTimeMillis())}).b(false).a(true);
                        bi.a().a(blVar2, 0L, 1);
                        return;
                    }
                    return;
                }
                if (z2) {
                    return;
                }
                this.f2106a = System.currentTimeMillis();
                bh blVar3 = new bl();
                blVar3.a(new Long[]{1L, Long.valueOf(this.f2106a), Long.valueOf(System.currentTimeMillis())}).b(false).a(true);
                bi.a().a(blVar3, 0L, 0);
            }
        };
        ba.a().a(c);
        return true;
    }

    @Override // cn.fly.verify.bh
    public void a() {
        if (g()) {
            return;
        }
        Long[] lArr = (Long[]) this.b;
        long jLongValue = lArr[0].longValue();
        long jLongValue2 = lArr[1].longValue();
        long jLongValue3 = (jLongValue != 3 || lArr.length >= 3) ? lArr[2].longValue() : System.currentTimeMillis();
        if (jLongValue == 0) {
            m();
        } else if (jLongValue != 1 && jLongValue != 3) {
            if (jLongValue == 2) {
                a(jLongValue2, jLongValue3);
                m();
                return;
            }
            return;
        }
        a(jLongValue2, jLongValue3);
        b(jLongValue2);
    }

    @Override // cn.fly.verify.bh
    public void c() {
        n();
    }

    private void a(long j, long j2) {
        try {
            bv bvVarA = bv.a();
            String str = d;
            HashMap map = (HashMap) bvVarA.c(str, null);
            if (map == null) {
                map = new HashMap();
            }
            map.put(Long.valueOf(j), Long.valueOf(j2));
            bv.a().b(str, map);
        } catch (Throwable th) {
            en.a().b(th);
        }
    }
}
