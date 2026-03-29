package com.bytedance.pangle.iz;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.iz.iz;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements iz.u {
    private static boolean nr(@NonNull String str, @NonNull String str2) {
        try {
            return u.u(nr.u(str, str2, nr.nr));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.iz.iz.u
    public boolean u(String str, int i) {
        String strNr = com.bytedance.pangle.pn.fx.nr(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strNr)));
        String strFx = com.bytedance.pangle.pn.fx.fx(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append(strFx);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(nr.nr(strNr));
        String string = sb.toString();
        String str3 = strFx + str2 + nr.u(strNr);
        if (!nr(strNr, string)) {
            return false;
        }
        u(string, str3);
        boolean zU = nr.u(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zU)));
        return zU;
    }

    private void u(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        String str3 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(str.replace(str3, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(str3, ".vdex")));
        }
    }
}
