package com.amap.api.col.p0002sl;

import android.util.Base64;
import com.huawei.hms.ads.ex;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jo {
    public static boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            kv kvVar = new kv();
            kvVar.b.put("Content-Type", "application/octet-stream");
            kvVar.b.put("aps_c_src", Base64.encodeToString(kv.a().getBytes(), 2));
            kvVar.b.put("aps_c_key", Base64.encodeToString(kv.b().getBytes(), 2));
            kvVar.d = bArr;
            if (jf.f2928a) {
                kvVar.f2948a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                kvVar.f2948a = (jf.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            kw kwVarA = kj.b().a(kvVar);
            byte[] bArr2 = (kwVarA == null || kwVarA.f2949a != 200) ? null : kwVarA.c;
            if (bArr2 != null) {
                return ex.Code.equals(new String(bArr2, StandardCharsets.UTF_8));
            }
            return false;
        } catch (Exception e) {
            ku.a(e);
            return false;
        }
    }
}
