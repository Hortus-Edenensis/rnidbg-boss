package defpackage;

import android.content.Context;
import defpackage.nu6;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class v97 extends va7 {
    @Override // defpackage.va7
    public e07 b(ru6 ru6Var, Context context, String str) throws Throwable {
        w97.h("mspl", "mdap post");
        byte[] bArrA = c07.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap map = new HashMap();
        map.put("utdId", j07.e().d());
        map.put("logHeader", "RAW");
        map.put("bizCode", "alipaysdk");
        map.put("productId", "alipaysdk_android");
        map.put("Content-Encoding", "Gzip");
        map.put("productVersion", "15.8.10");
        nu6.b bVarA = nu6.a(context, new nu6.a("https://loggw-exsdk.alipay.com/loggw/logUpload.do", map, bArrA));
        w97.h("mspl", "mdap got " + bVarA);
        if (bVarA == null) {
            throw new RuntimeException("Response is null");
        }
        boolean zL = va7.l(bVarA);
        try {
            byte[] bArrB = bVarA.c;
            if (zL) {
                bArrB = c07.b(bArrB);
            }
            return new e07("", new String(bArrB, Charset.forName("UTF-8")));
        } catch (Exception e) {
            w97.d(e);
            return null;
        }
    }

    @Override // defpackage.va7
    public Map<String, String> i(boolean z, String str) {
        return new HashMap();
    }

    @Override // defpackage.va7
    public JSONObject j() {
        return null;
    }

    @Override // defpackage.va7
    public boolean o() {
        return false;
    }

    @Override // defpackage.va7
    public String g(ru6 ru6Var, String str, JSONObject jSONObject) {
        return str;
    }
}
