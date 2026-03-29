package com.zenmen.palmchat.redpacket.data;

import com.wifi.ad.core.config.EventParams;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RedPacketHistoryVo {
    private String amount;
    private String from;
    private String number;
    private String redId;
    private int redStatus;
    private String ts;
    private int type;

    public static ArrayList<RedPacketHistoryVo> parseFromJson(JSONArray jSONArray) {
        ArrayList<RedPacketHistoryVo> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        RedPacketHistoryVo redPacketHistoryVo = new RedPacketHistoryVo();
                        redPacketHistoryVo.setFrom(jSONObject.optString("from"));
                        redPacketHistoryVo.setTs(jSONObject.optString("ts"));
                        redPacketHistoryVo.setAmount(jSONObject.optString("amount"));
                        redPacketHistoryVo.setType(jSONObject.optInt("type"));
                        redPacketHistoryVo.setRedId(jSONObject.optString("redId"));
                        redPacketHistoryVo.setNumber(jSONObject.optString(EventParams.KEY_PARAM_NUMBER));
                        redPacketHistoryVo.setRedStatus(jSONObject.optInt("redStatus"));
                        arrayList.add(redPacketHistoryVo);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getFrom() {
        return this.from;
    }

    public String getNumber() {
        return this.number;
    }

    public String getRedId() {
        return this.redId;
    }

    public int getRedStatus() {
        return this.redStatus;
    }

    public String getTs() {
        return this.ts;
    }

    public int getType() {
        return this.type;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setRedId(String str) {
        this.redId = str;
    }

    public void setRedStatus(int i) {
        this.redStatus = i;
    }

    public void setTs(String str) {
        this.ts = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
