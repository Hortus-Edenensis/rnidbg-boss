package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblz;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class f0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        JSONObject jSONObjectB;
        try {
            q1 q1VarI = q1.i();
            return (!q1VarI.a() || (jSONObjectB = q1VarI.b()) == null) ? "" : jSONObjectB.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
