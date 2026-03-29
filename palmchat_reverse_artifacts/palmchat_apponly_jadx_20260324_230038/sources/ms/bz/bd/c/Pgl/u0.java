package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class u0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        boolean zA;
        try {
            zA = y0.a(pblw.b().a(), str, obj.toString());
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b8e572", new byte[]{116, 59, 16});
            zA = false;
        }
        if (zA) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28bc11", new byte[]{12, 17});
        }
        return null;
    }
}
