package ms.bz.bd.c.Pgl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class y0 {
    public static boolean a(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                throw null;
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                a(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f774c2", new byte[]{56})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "085d06", new byte[]{110})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "daea7f", new byte[]{118, 98, 16});
            return false;
        }
    }

    public static void b() {
        pblz.b(65537, new r0());
        pblz.b(65538, new s0());
        pblz.b(65539, new t0());
        pblz.b(InputDeviceCompat.SOURCE_TRACKBALL, new u0());
        pblz.b(65541, new v0());
        pblz.b(com.igexin.push.b.c.c, new w0());
        pblz.b(65543, new x0());
        w1 w1Var = new w1();
        pblz.b(196609, w1Var);
        pblz.b(196610, w1Var);
        pblz.b(196611, w1Var);
        pblx t1Var = pbli.a() ? new t1() : new pblj();
        pblx.g(t1Var);
        pblz.b(131073, t1Var);
        pblz.b(131074, t1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "97f1de", new byte[]{45, 35, 16, 75, 79, 94, 53, 17, 26, 96, 38, 52, 18, 64, 73, 50, 57, 26, 54, 114, 59, 117, 28, 86, 27});
    }
}
