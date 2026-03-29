package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.nr;
import java.io.File;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class a extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        File file = new File(nr.u(pblw.b().a()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bc387c", new byte[]{Base64.padSymbol, 108, 83, 72, 9, 96, 96}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
