package com.tencent.turingfd.sdk.ams.ad;

import android.os.Process;
import com.tencent.turingfd.sdk.ams.ad.Virgo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Filbert {
    public static String a() {
        StringBuilder sb = new StringBuilder();
        int iMyPid = Process.myPid();
        Virgo.Cdo cdoB = Virgo.b(iMyPid);
        if (cdoB == null) {
            return sb.toString();
        }
        int i = cdoB.e;
        if (i == 0) {
            return sb.toString();
        }
        if (i == iMyPid) {
            return sb.toString();
        }
        sb.append(iMyPid);
        sb.append(",");
        sb.append(cdoB.b);
        sb.append(",");
        sb.append(cdoB.c);
        sb.append(",");
        sb.append(i);
        sb.append(",");
        Virgo.Cdo cdoB2 = Virgo.b(i);
        if (cdoB2 != null) {
            sb.append(cdoB2.d);
            sb.append(",");
            sb.append(cdoB2.c);
            sb.append(",");
            sb.append(cdoB2.b);
        }
        return sb.toString();
    }
}
