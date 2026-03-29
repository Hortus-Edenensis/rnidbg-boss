package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblz;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pblx extends pblz.pgla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static pblx f19341a;

    /* JADX INFO: compiled from: SearchBox */
    public static class pgla {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19342a;
        public String b;

        public final void a(String str, int i) {
            pblx pblxVarD = pblx.d();
            if (pblxVarD == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f19342a;
            pblxVarD.c(jCurrentTimeMillis - j, j, this.b, str, i);
        }

        public final void b(String str) {
            this.b = str;
            this.f19342a = System.currentTimeMillis();
        }

        public final void c(String str, int i) {
            pblx pblxVarD = pblx.d();
            if (pblxVarD == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f19342a;
            pblxVarD.e(jCurrentTimeMillis - j, j, this.b, str, i);
        }
    }

    public static synchronized pblx d() {
        return f19341a;
    }

    public static synchronized void g(pblx pblxVar) {
        f19341a = pblxVar;
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object a(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !h(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4a7081", new byte[]{10, 72});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                f(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void c(long j, long j2, String str, String str2, int i);

    public abstract void e(long j, long j2, String str, String str2, int i);

    public abstract void f(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean h(String str);
}
