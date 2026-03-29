package ms.bz.bd.c.Pgl;

import android.os.Build;
import java.util.HashMap;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblg {
    public static HashMap a() {
        HashMap map = new HashMap();
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f987f9", new byte[]{38}), Build.MODEL);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "009228", new byte[]{115}), Build.BRAND);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "33c99d", new byte[]{113}), Build.BOARD);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2c1e7d", new byte[]{119}), Build.VERSION.RELEASE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "74590a", new byte[]{115}), Build.DISPLAY);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e5cbef", new byte[]{34}), Build.HARDWARE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9915de", new byte[]{ByteCompanionObject.MAX_VALUE}), Build.FINGERPRINT);
        return map;
    }

    public static String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap mapA = a();
            for (String str : mapA.keySet()) {
                jSONObject.put(str, mapA.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d5e041", new byte[]{110, 42});
        }
    }
}
