package cn.fly.verify;

import cn.fly.verify.fq;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bm extends bh {
    public bm() {
        super(null, null, bh.a(ba.a("003fii"), (Long) 0L));
    }

    private boolean m() {
        return by.a(ba.a("003fii"));
    }

    private boolean n() {
        return by.a(ba.a("002Gfk g"));
    }

    private boolean o() {
        return by.a(ba.a("002CfiHg"));
    }

    @Override // cn.fly.verify.bh
    public void a() {
        if (m()) {
            final boolean z = true;
            final boolean z2 = n() || o();
            c(z2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = ((Long) a(ba.a("004fQhjYlf"), 2592000L)).longValue() * 1000;
            long jB = bv.a().b(bv.c, 0L);
            boolean zA = eg.a(jCurrentTimeMillis, jB);
            Object obj = this.b;
            boolean z3 = obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
            if (jCurrentTimeMillis - jLongValue < jB && zA) {
                z = false;
            }
            if (z || z3) {
                fq.a(ax.g()).a(false, z3).a(new fq.a() { // from class: cn.fly.verify.bm.1
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar) {
                        ArrayList<HashMap<String, String>> arrayListE = bVar.e(new int[0]);
                        if (arrayListE == null || arrayListE.isEmpty()) {
                            return;
                        }
                        if (z) {
                            bm.this.a(arrayListE);
                        }
                        bm.this.a(arrayListE, z2);
                    }
                });
            }
        }
    }

    @Override // cn.fly.verify.bh
    public boolean e() {
        return m() && f();
    }

    @Override // cn.fly.verify.bh
    public long l() {
        try {
            Calendar calendar = Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            calendar.add(5, 1);
            long timeInMillis2 = (calendar.getTimeInMillis() - timeInMillis) + ((long) new SecureRandom().nextInt(240000));
            return (timeInMillis2 / 1000) + ((long) (timeInMillis2 % 1000 == 0 ? 0 : 1));
        } catch (Throwable th) {
            en.a().a(th);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, String>> arrayList) {
        a(((Long) a(ba.a("004fGfeZih"), 0L)).longValue(), "ALSAMT", arrayList);
        bv.a().a(bv.c, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, String>> arrayList, boolean z) {
    }

    private void c(boolean z) {
    }
}
