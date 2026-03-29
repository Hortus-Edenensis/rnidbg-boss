package com.zenmen.find.bean;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class FindFriendCondition extends JSONObject {
    public FindFriendCondition() {
    }

    public boolean isDefaultCond() {
        JSONObject jSONObjectOptJSONObject = optJSONObject("normalCond");
        JSONObject jSONObjectOptJSONObject2 = optJSONObject("vipCond");
        if (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.keys().hasNext()) {
            return jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.keys().hasNext();
        }
        return false;
    }

    public JSONObject mergeParams(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = optJSONObject("normalCond");
        JSONObject jSONObjectOptJSONObject2 = optJSONObject("vipCond");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, jSONObjectOptJSONObject.opt(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                try {
                    jSONObject.put(next2, jSONObjectOptJSONObject2.opt(next2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public void resetVipCond() {
        try {
            put("vipCond", new JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public FindFriendCondition(String str) throws JSONException {
        super(str);
    }
}
