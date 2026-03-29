package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class n1 {

    /* JADX INFO: compiled from: SearchBox */
    public static class pgla implements Comparator<Object> {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int iAbs = Math.abs(((ScanResult) obj).level);
            int iAbs2 = Math.abs(((ScanResult) obj2).level);
            if (iAbs > iAbs2) {
                return 1;
            }
            return iAbs == iAbs2 ? 0 : -1;
        }
    }

    public static String a(Context context) {
        int i;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String string = null;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(pblr.a("6765745363616e526573756c7473")), new Class[0]);
            list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, new Object[0]) : null;
        } catch (Throwable unused) {
        }
        if (list == null || list.size() <= 0) {
            return jSONArray.toString();
        }
        Collections.sort(list, new pgla());
        for (i = 0; i < list.size() && i < 10; i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ss", v1.a(((ScanResult) list.get(i)).SSID));
                jSONObject.put(CmcdConfiguration.KEY_BUFFER_STARVATION, v1.a(((ScanResult) list.get(i)).BSSID));
                jSONArray.put(jSONObject);
            } catch (JSONException unused2) {
            }
        }
        string = jSONArray.toString();
        return string == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : string.trim();
    }
}
