package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.umeng.analytics.pro.dn;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class t extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        Context contextA = pblw.b().a();
        if (contextA != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextA.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ee6d73", new byte[]{119, 104, 75, 30, dn.k, 39, 114, 77, 113, Base64.padSymbol, 96, 126}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b61116", new byte[]{116, 49, 86, 100, dn.k, 53, 104, 1, 101, 79, 118, 32, 85, 74, 28, 42, 72, 25, 102, 110}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "50d47d", new byte[]{45, 33, 54, 86, 9, 122, 58, 16, 55, 104, 33}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
