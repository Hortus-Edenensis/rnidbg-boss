package defpackage;

import com.zenmen.openapi.impl.OAAccountUtils;
import com.zenmen.openapi.impl.OADeviceUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m44 {
    public static Map<String, String> a() {
        Map<String, String> publicParams = OAAccountUtils.getPublicParams(OADeviceUtils.getPublicParams(new HashMap()));
        publicParams.put("ts", System.currentTimeMillis() + "");
        return publicParams;
    }
}
