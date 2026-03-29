package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblz;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class g0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        Method declaredMethod;
        Context contextA = pblw.b().a();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) contextA.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "49e689", new byte[]{36, 56, 21, 71, 20, Base64.padSymbol, 62, 26, Base64.padSymbol, 106, 44, 47, 15}));
        if (accessibilityManager != null) {
            try {
                declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a2d35a", new byte[]{119, 53, 3, 110, 4, 101, 118, 18, 57, 111, 117, 52, 54, 68, 9, 115, 113, 0, 60, 97, 121, 60, 30, 83, 19, 69, 103, 1, 35, 106, 115, 53, 59, 78, 25, 98}), new Class[0]);
            } catch (Throwable unused) {
            }
            List<AccessibilityServiceInfo> list = declaredMethod != null ? (List) declaredMethod.invoke(accessibilityManager, new Object[0]) : null;
            if (list == null || list.size() == 0) {
                return jSONArray.toString();
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "43e713", new byte[]{32, 39}), accessibilityServiceInfo.eventTypes);
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc2f1b", new byte[]{123, 101}), accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
