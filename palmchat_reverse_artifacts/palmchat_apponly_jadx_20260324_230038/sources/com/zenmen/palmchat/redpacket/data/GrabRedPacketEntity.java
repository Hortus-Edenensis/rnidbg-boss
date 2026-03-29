package com.zenmen.palmchat.redpacket.data;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GrabRedPacketEntity {
    public boolean haveGot;
    public String headUrl;
    public boolean isCanEnter;
    public boolean isDirectEnter;
    public boolean isOpen;
    public String msg;
    public String nickName;
    public int redStatus;
    public int redType;
    public String tips;
    public long uId;

    public GrabRedPacketEntity(int i, long j, String str, String str2, String str3, String str4, int i2) {
        this.redStatus = i;
        this.uId = j;
        this.nickName = str;
        this.headUrl = str2;
        this.tips = str3;
        this.msg = str4;
        this.redType = i2;
    }

    public static GrabRedPacketEntity buildFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GrabRedPacketEntity grabRedPacketEntity = new GrabRedPacketEntity();
        grabRedPacketEntity.redStatus = jSONObject.optInt("redStatus");
        grabRedPacketEntity.haveGot = jSONObject.optBoolean("haveGot", false);
        grabRedPacketEntity.isDirectEnter = jSONObject.optBoolean("isDirectEnter");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("from");
        if (jSONObjectOptJSONObject != null) {
            grabRedPacketEntity.uId = jSONObjectOptJSONObject.optLong("uId");
            grabRedPacketEntity.nickName = jSONObjectOptJSONObject.optString("nickName");
            grabRedPacketEntity.headUrl = jSONObjectOptJSONObject.optString("headUrl");
            grabRedPacketEntity.redType = jSONObjectOptJSONObject.optInt("redType");
        }
        grabRedPacketEntity.tips = jSONObject.optString("tips");
        grabRedPacketEntity.msg = jSONObject.optString("msg");
        grabRedPacketEntity.isOpen = jSONObject.optBoolean("isOpen");
        grabRedPacketEntity.isCanEnter = jSONObject.optBoolean("isCanEnter");
        return grabRedPacketEntity;
    }

    public GrabRedPacketEntity() {
    }
}
