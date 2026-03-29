package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.dn;
import java.lang.reflect.Method;
import java.util.HashSet;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class h0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        String[] strArr = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6e22c", new byte[]{120, 36, 6, 73}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "de9dbd", new byte[]{120, 110, 95, 25}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c5d419", new byte[]{100, 62, 1, 79}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d27189", new byte[]{120, 53, 77, 95, 18}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81d3f4", new byte[]{59, 54, 19, 74, 80}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2f1e35", new byte[]{59, 109, 67, 30, 1, 43}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b6d015", new byte[]{123, 33, 22, 83, 11, 43}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e54b85", new byte[]{123, 57, 66, 6, 11, 55, 117}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f09caf", new byte[]{123, 59, 68, 18, 95, 118, 96}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cbbd98", new byte[]{97, 97, 28, 3, 19, 33, 103}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9bb091", new byte[]{48, 112, 30, 87, 3, 34}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b349fa", new byte[]{Base64.padSymbol, Base64.padSymbol, 66, 88, 80, 56}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "54acad", new byte[]{54, 51, 19, 27, 83, 118}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "190d7d", new byte[]{33, 40, 86, 3}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e28666", new byte[]{118, 60, 74, 65, 2, 50, 110, 18, 123, 109}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ac0bdd", new byte[]{125, 100, 74, 2, 78}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "400941", new byte[]{41, 59, 65, 94, 30}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8d24de", new byte[]{38, 118, 77, 85, 72}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4b456a", new byte[]{45, 111, 73, 78, 27})};
        HashSet hashSet = new HashSet();
        try {
            Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "774835", new byte[]{39, 59, 67, 94, 3, 43, 48, 88, 106, 123, 104, 6, 66, 94, 26, 43, 55, 19, 72, 105, 40, 52, 64, 73, 30})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "393299", new byte[]{46, 50, 83, 82, 53, 43, 34, dn.l, 107, 97, 39, 40}), new Class[0]);
            declaredMethod.setAccessible(true);
            String[] strArr2 = (String[]) declaredMethod.invoke(null, new Object[0]);
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    for (int i = 0; i < 19; i++) {
                        String str3 = strArr[i];
                        if (str2.toLowerCase().contains(str3)) {
                            hashSet.add(str3);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hashSet.toString();
    }
}
