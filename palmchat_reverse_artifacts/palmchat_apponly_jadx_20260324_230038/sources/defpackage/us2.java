package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.huawei.openalliance.ad.constant.x;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class us2 extends wt0 {
    public static final String c = "us2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21280a = nl0.s + "/room/v3/create";
    public String b = nl0.s + "/room/v5/create";

    public GroupModifyResultVo n(ArrayList<ContactInfoItem> arrayList, String str) throws DaoException {
        int i;
        GroupModifyResultVo groupModifyResultVoBuildFromJsonObject = null;
        try {
            String strA0 = k86.a0(this.f21280a, str);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (ContactInfoItem contactInfoItem : arrayList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(DeviceInfoUtil.UID_TAG, Long.parseLong(contactInfoItem.getUid()));
                jSONObject2.put("nickname", contactInfoItem.getNickName());
                jSONObject2.put("headIconUrl", contactInfoItem.getIconURL());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("members", jSONArray);
            if (oc0.f()) {
                jSONObject.put("roomType", 1);
            }
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strA0, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            JSONObject jSONObject3 = (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
            if (jSONObject3 != null) {
                LogUtil.i(c, jSONObject3.toString());
                groupModifyResultVoBuildFromJsonObject = GroupModifyResultVo.buildFromJsonObject(jSONObject3);
                if (groupModifyResultVoBuildFromJsonObject != null && ((i = groupModifyResultVoBuildFromJsonObject.resultCode) == 0 || i == 4001)) {
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

    public GroupModifyResultVo o(String str, String str2, String str3, int i, String str4) throws DaoException {
        int i2;
        GroupModifyResultVo groupModifyResultVoBuildFromJsonObject = null;
        try {
            String strA0 = k86.a0(this.b, str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("roomType", 2);
            jSONObject.put("headImg", str2);
            jSONObject.put("recmdSwitch", i);
            jSONObject.put("roomName", str4);
            jSONObject.put(x.cw, str3);
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strA0, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            normalRequestQueue.add(encryptedJsonRequest);
            JSONObject jSONObject2 = (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
            if (jSONObject2 != null) {
                LogUtil.i(c, jSONObject2.toString());
                groupModifyResultVoBuildFromJsonObject = GroupModifyResultVo.buildFromJsonObject(jSONObject2);
                if (groupModifyResultVoBuildFromJsonObject != null && ((i2 = groupModifyResultVoBuildFromJsonObject.resultCode) == 0 || i2 == 4001)) {
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
