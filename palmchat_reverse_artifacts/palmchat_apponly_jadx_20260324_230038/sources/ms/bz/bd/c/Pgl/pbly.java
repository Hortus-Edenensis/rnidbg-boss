package ms.bz.bd.c.Pgl;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pbly extends pblz.pgla {
    public static void d(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "96217f", new byte[]{37, 55, 126, 70, 1});
            }
        }
    }

    public static void e(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e46646", new byte[]{121, 53, 122, 65, 4});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object a(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!g1.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c69818", new byte[]{115, 58, 78, 94, 1, 38, 100, 89, 120, 109, 96, 57, 67, 95, 29, 38, 111, 25, 38, 65, 92, 0, 111, 126, 32, 10, 84}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return g(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return f(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return c(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.a(i, i2, j, str, obj);
        }
    }

    public abstract Object[] c(String str, String str2, String str3);

    public abstract Object[] f(String str, String str2, String str3);

    public abstract Object[] g(String str, byte[] bArr, String str2, String str3);
}
