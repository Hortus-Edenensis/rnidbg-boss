package com.bytedance.sdk.openadsdk.core.gi;

import android.os.SystemClock;
import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.s;
import com.huawei.hms.utils.FileUtil;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile String nr = "0";
    private static volatile long u;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gi.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0260u implements a {
        @Override // com.bytedance.sdk.component.nr.u.a
        public my u(a.u uVar) throws IOException {
            o oVarIz;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            s sVarU = uVar.u();
            my myVarU = uVar.u(sVarU);
            if (!"GET".equalsIgnoreCase(sVarU.fx()) || (oVarIz = myVarU.iz()) == null) {
                return myVarU;
            }
            long jU = oVarIz.u();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 0 && jU > FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                String unused = u.nr = String.format("%.2f", Double.valueOf(((jU / 1024.0d) / jElapsedRealtime2) * 1000.0d));
                long unused2 = u.u = System.currentTimeMillis();
                String unused3 = u.nr;
            }
            return myVarU;
        }
    }

    public static String u() {
        return System.currentTimeMillis() - u < com.heytap.mcssdk.constant.a.n ? nr : "0";
    }
}
