package ms.bz.bd.c.Pgl;

import android.os.Build;
import ms.bz.bd.c.Pgl.h1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class x1 implements h1.pblb {
    public final String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !(str == null || str.length() == 0) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
