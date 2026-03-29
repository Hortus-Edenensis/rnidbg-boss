package defpackage;

import com.zenmen.listui.list.BaseNetBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface ei5<R extends BaseNetBean> {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static void a(JSONObject jSONObject, aw awVar) {
            if (awVar != null) {
                try {
                    jSONObject.put("net_cacheConfig", awVar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static aw b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            aw awVar = (aw) jSONObject.opt("net_cacheConfig");
            jSONObject.remove("net_cacheConfig");
            return awVar;
        }
    }

    JSONObject genRequestParams();

    R handle(JSONObject jSONObject);

    void onPostExecute(R r);
}
