package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.nr;
import java.io.File;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class t0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        File file = new File(nr.u(pblw.b().a()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "58092c", new byte[]{106, 55, 80, 73, 12, 96, 55}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
