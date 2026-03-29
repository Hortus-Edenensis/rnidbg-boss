package defpackage;

import android.os.Build;
import com.oplus.tblplayer.Constants;
import defpackage.gt4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class dr5 implements gt4.b {
    @Override // gt4.b
    public String a(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // gt4.b
    public String[] b() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !iv5.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // gt4.b
    public void c(String str) {
        System.load(str);
    }

    @Override // gt4.b
    public String d(String str) {
        return (str.startsWith(Constants.LIBRARY_PREFIX) && str.endsWith(Constants.LIBRARY_SUFFIX)) ? str : System.mapLibraryName(str);
    }

    @Override // gt4.b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
