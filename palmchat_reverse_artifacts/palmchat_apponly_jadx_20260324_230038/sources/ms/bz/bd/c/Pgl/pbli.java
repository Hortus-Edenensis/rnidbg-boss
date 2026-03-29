package ms.bz.bd.c.Pgl;

import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pbli {
    public static boolean a() {
        return b((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4bcff", new byte[]{115, 57, 28, 89, 91, 104, 118, 16, 55, 50, 126, 53, 20, 89, 95, 99, 99, 24, 36, 60, 98, Base64.padSymbol, 95, 20, 86, 99, 103, 91, 32, 55, 123, 59, 30, 25, 80, 101, 109, 7, 125, 3, 119, 58, 34, 51, 114, 92, 109, 27, 58, 39, ByteCompanionObject.MAX_VALUE, 36, 36, 3, 80, 125, 113}));
    }

    public static boolean b(String... strArr) {
        boolean z;
        boolean z2 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            z2 &= z;
            if (!z2) {
                break;
            }
        }
        return z2;
    }
}
