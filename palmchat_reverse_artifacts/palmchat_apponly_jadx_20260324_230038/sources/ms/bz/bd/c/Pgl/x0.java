package ms.bz.bd.c.Pgl;

import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblz;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class x0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aba439", new byte[]{115, 111, TELogUtils.DEBUG_LEVEL_V, dn.l, TELogUtils.DEBUG_LEVEL_V, Base64.padSymbol, 44, 66, 62, 96, 98, 111, 27, 68, 66, 59, 101, 64, 126, 117, 101, 111, 6, 65, 66, 12, 70, 109, 53, 112, 103, 111, 0, 75, 56, 47, 101, 96, Utf8.REPLACEMENT_BYTE, 106, 100, 101, 10, 84, 60, 60, 109, 85, 57, 96, 117, 114, 51, 68, dn.k, 62, 118, 70, 34}));
            Method declaredMethod = cls.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a2644a", new byte[]{125, 49, 87, 75, 42, 101, 76, 22, 112, 81, 99, 53, 87}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objNewInstance = cls.newInstance();
            if (objNewInstance != null ? ((Boolean) declaredMethod.invoke(objNewInstance, new Object[0])).booleanValue() : false) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3bbcd2", new byte[]{44, 101, 6, 34, 72, 32, 34});
            }
            return null;
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "afe141", new byte[]{119, 101, 16});
            return null;
        }
    }
}
