package ms.bz.bd.c.Pgl;

import java.util.TimeZone;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class n0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        String id;
        int rawOffset;
        TimeZone timeZone;
        try {
            timeZone = TimeZone.getDefault();
            id = timeZone.getID();
        } catch (Throwable unused) {
            id = null;
        }
        try {
            rawOffset = ((timeZone.getRawOffset() / 60) / 60) / 1000;
        } catch (Throwable unused2) {
            rawOffset = 0;
        }
        return id + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d13b4c", new byte[]{57})) + rawOffset;
    }
}
