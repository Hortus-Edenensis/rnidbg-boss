package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class te7 implements zl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f20974a;

    public te7(InputStream inputStream, String str) {
        this.f20974a = a(inputStream);
        b(str);
    }

    public final JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(t86.g(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    public final void b(String str) {
        try {
            JSONObject jSONObjectD = d(str);
            if (jSONObjectD == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f20974a.getJSONObject("client").put("app_id", jSONObjectD.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> itKeys = jSONObjectD.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!"package_name".equals(next)) {
                        c(next, jSONObjectD.get(next), this.f20974a);
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    public final void c(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    public final JSONObject d(String str) throws JSONException {
        JSONArray jSONArray = this.f20974a.getJSONArray("appInfos");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // defpackage.zl0
    public String getString(String str, String str2) {
        JSONObject jSONObject;
        int i;
        if (str.endsWith("/")) {
            return str2;
        }
        String[] strArrSplit = str.split("/");
        try {
            jSONObject = this.f20974a;
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        for (i = 1; i < strArrSplit.length; i++) {
            if (i == strArrSplit.length - 1) {
                str = jSONObject.get(strArrSplit[i]).toString();
                return str;
            }
            jSONObject = jSONObject.getJSONObject(strArrSplit[i]);
            return str2;
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f20974a.toString().hashCode() + '}';
    }
}
