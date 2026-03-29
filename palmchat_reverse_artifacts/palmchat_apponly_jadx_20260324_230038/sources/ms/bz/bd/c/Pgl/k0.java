package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblz;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class k0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        double dDoubleValue;
        Context contextA = pblw.b().a();
        try {
            Class<?> cls = Class.forName(new String(pblr.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "38a94c", new byte[]{116, 105, 68, 75, 93, 112, 98, 28, 102, 56, 116, Utf8.REPLACEMENT_BYTE, 68, 25, 92, 38, 102, TELogUtils.DEBUG_LEVEL_V, 102, 48, 116, 110, 64, 72, 93, 45, 102, 28, 103, Base64.padSymbol, 116, 111, 69, TELogUtils.DEBUG_LEVEL_V, 93, 113, 102, 72, 102, 106, 112, Utf8.REPLACEMENT_BYTE, 68, 75, 92, 39, 98, 28, 101, 57, 116, 60, 69, 26, 93, 33, 103, 75, 101, 57, 117, 104, 68, 75, 93, 34, 102, 64, 102, 106, 116, 111}))));
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(contextA);
            Method declaredMethod = cls.getDeclaredMethod(new String(pblr.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "38a3be", new byte[]{116, 109, 68, 18, 10, 38, 100, 72, 103, 53, 116, 111, 69, 21, 11, 35, 102, 78, 102, 54, 119, 106, 68, 65, 10, 37, 102, 76, 103, 49}))), String.class);
            declaredMethod.setAccessible(true);
            dDoubleValue = ((Double) declaredMethod.invoke(objNewInstance, new String(pblr.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa20c2", new byte[]{38, 49, 23, 21, 11, 113, 53, 20, 53, 53, 39, 49, 22, 29, dn.l, 32, 52, 19, 53, 49, 39, 51, 23, 21, 10, 118, 52, 25, 52, 52, 39, 58}))))).doubleValue();
        } catch (Throwable unused) {
            dDoubleValue = 0.0d;
        }
        return Integer.toString((int) dDoubleValue);
    }
}
