package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t92 extends wt0 {
    public final ArrayList<ContactInfoItem> n(JSONObject jSONObject) throws Exception {
        JSONArray jSONArrayOptJSONArray;
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        if (jSONObject != null && jSONObject.getInt("resultCode") == 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(jSONObjectOptJSONObject.getString(DeviceInfoUtil.UID_TAG));
                contactInfoItem.setNickName(jSONObjectOptJSONObject.getString("nickname"));
                contactInfoItem.setIconURL(jSONObjectOptJSONObject.getString("headIconUrl"));
                arrayList.add(contactInfoItem);
            }
        }
        return arrayList;
    }

    public ArrayList<ContactInfoItem> o(Set<String> set) {
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        try {
            String strZ = k86.Z(nl0.z + "/user.ac.infos.v1");
            RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            jSONObject.put("targetUids", sb.toString().substring(0, r10.length() - 1));
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
            encryptedJsonRequest.setRetryPolicy(wt0.genRetryPolicy());
            normalRequestQueue.add(encryptedJsonRequest);
            return n((JSONObject) requestFutureNewFuture.get(encryptedJsonRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }
}
