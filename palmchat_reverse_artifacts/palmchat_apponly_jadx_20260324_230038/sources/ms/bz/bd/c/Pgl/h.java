package ms.bz.bd.c.Pgl;

import com.ss.android.ttvecamera.TELogUtils;
import java.util.Locale;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class h extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblw.b().a().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "111b9a", new byte[]{TELogUtils.DEBUG_LEVEL_V})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return v1.a(str2);
    }
}
