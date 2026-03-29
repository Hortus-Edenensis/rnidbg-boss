package defpackage;

import android.graphics.Bitmap;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class op4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19804a = "op4";

    public static String a(Bitmap bitmap) {
        aq6 aq6Var = new aq6(true);
        long jB = ir5.b();
        String strA = aq6Var.a(bitmap);
        LogUtil.i(f19804a, "scanImageForQR=" + strA + ",time = " + ir5.e(jB));
        return strA;
    }
}
