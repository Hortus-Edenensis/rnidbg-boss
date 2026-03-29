package com.zenmen.palmchat.redpacket.data;

import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RedPacketInfoVo extends ContactInfoItem {
    private String amount;
    private long timestamp;

    public static ArrayList<RedPacketInfoVo> infoListFromJson(JSONArray jSONArray) {
        ArrayList<RedPacketInfoVo> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        arrayList.add(parseItem(jSONObject));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static RedPacketInfoVo parseItem(JSONObject jSONObject) {
        RedPacketInfoVo redPacketInfoVo = new RedPacketInfoVo();
        redPacketInfoVo.setUid(jSONObject.optString("uId"));
        redPacketInfoVo.setNickName(jSONObject.optString("nickName"));
        redPacketInfoVo.setIconURL(jSONObject.optString("headUrl"));
        redPacketInfoVo.setRank(jSONObject.optInt("rank"));
        redPacketInfoVo.setAmount(jSONObject.optString("amount"));
        redPacketInfoVo.setTimestamp(jSONObject.optLong("ts"));
        return redPacketInfoVo;
    }

    public String getAmount() {
        return this.amount;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
