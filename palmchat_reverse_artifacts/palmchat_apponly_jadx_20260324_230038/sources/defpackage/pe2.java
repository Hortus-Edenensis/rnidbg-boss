package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pe2<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20002a = "pe2";

    public GroupModifyResultVo n(String str) throws DaoException {
        GroupModifyResultVo groupModifyResultVoBuildFromJsonObject = null;
        try {
            String strZ = k86.Z(vm0.N0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("qrCode", str);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            JSONObject jSONObject2 = (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
            if (jSONObject2 != null) {
                LogUtil.i(f20002a, jSONObject2.toString());
                groupModifyResultVoBuildFromJsonObject = GroupModifyResultVo.buildFromJsonObject(jSONObject2);
                if (groupModifyResultVoBuildFromJsonObject != null && groupModifyResultVoBuildFromJsonObject.resultCode == 0) {
                    iq5.j(true, new String[0]);
                }
            }
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        } catch (TimeoutException e3) {
            e3.printStackTrace();
        } catch (JSONException unused2) {
            throw new DaoException("json error");
        }
        return groupModifyResultVoBuildFromJsonObject;
    }
}
