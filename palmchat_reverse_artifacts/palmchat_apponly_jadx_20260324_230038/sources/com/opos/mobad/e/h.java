package com.opos.mobad.e;

import com.opos.mobad.r;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class h implements r {
    @Override // com.opos.mobad.r
    public void a(int i, String str, int i2) {
        com.opos.mobad.c.b.e().c().a(i, str, i2);
    }

    @Override // com.opos.mobad.r
    public void b(String str) {
        com.opos.mobad.c.b.e().c().f(str);
    }

    @Override // com.opos.mobad.r
    public void a(int i, String str, String str2) {
        com.opos.mobad.c.b.e().c().a(i, str, str2);
    }

    @Override // com.opos.mobad.r
    public void b(Map<String, String> map) {
        try {
            com.opos.mobad.c.b.e().a(map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("MobStatisticManager", "reportAdShow()", e);
        }
    }

    @Override // com.opos.mobad.r
    public void a(String str) {
        com.opos.mobad.c.b.e().c().d(str);
    }

    @Override // com.opos.mobad.r
    public void a(String str, String str2, long j, long j2) {
        com.opos.mobad.c.b.e().c().a(str, str2, j, j2);
    }

    @Override // com.opos.mobad.r
    public void a(Map<String, String> map) {
        com.opos.mobad.c.b.e().c().a(map);
    }
}
