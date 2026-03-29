package cn.fly.verify;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bo extends bh {
    private static dv c;

    public bo() {
        super("p", 0L, null, 0L, 0L);
        a(0);
    }

    private static synchronized boolean m() {
        if (c != null) {
            return false;
        }
        c = new dv() { // from class: cn.fly.verify.bo.1
            @Override // cn.fly.verify.dv
            public void a(boolean z, boolean z2, long j) {
                if (z) {
                    bo boVar = new bo();
                    boVar.b(false).a(Long.valueOf(System.currentTimeMillis())).a(true);
                    bi.a().a(boVar, 0L, 0);
                }
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
        HashMap<String, Object> map = new HashMap<>();
        map.put(ed.a("004iLdk!jf"), "PVMT");
        map.put(ed.a("0081dcWdifiLdidfKf"), this.b);
        if (!du.a().f2203a.get()) {
            map.putAll(du.a().c());
            du.a().f2203a.compareAndSet(false, true);
        }
        cn.a().a(System.currentTimeMillis(), map);
    }

    @Override // cn.fly.verify.bh
    public void c() {
        m();
    }
}
