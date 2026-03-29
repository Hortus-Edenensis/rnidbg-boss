package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.HashMap;
import ms.bz.bd.c.Pgl.pblz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
final class w0 extends pblz.pgla {
    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object b(long j, String str, Object obj) throws Throwable {
        String string;
        Context contextA = pblw.b().a();
        ApplicationInfo applicationInfo = contextA.getPackageManager().getApplicationInfo(contextA.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        HashMap mapA = pblc.a(str2);
        String string2 = "";
        String str3 = (mapA == null || !mapA.containsKey(1903654775)) ? "" : (String) mapA.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d485f8", new byte[]{120, 51, 95, 64, 102, 58, 106, 16, 103, 98, 74, 53, 67, 64, 87, 33, 98, 25}));
            } catch (JSONException unused) {
                string = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8bc735", new byte[]{114}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "363481", new byte[]{48, 49, 76, 69, 6, 53, 53, 40, 96, 113, 43, 56, 68}));
            } catch (JSONException unused2) {
            }
            sb.append(string2);
            string2 = sb.toString();
        }
        return string2.length() == 0 ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "57624a", new byte[]{10, 58, 75, 67}) : string2;
    }
}
