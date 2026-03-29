package com.zenmen.palmchat.redpacket.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RedPacketOrderVo implements Parcelable {
    public static final Parcelable.Creator<RedPacketOrderVo> CREATOR = new Parcelable.Creator<RedPacketOrderVo>() { // from class: com.zenmen.palmchat.redpacket.data.RedPacketOrderVo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPacketOrderVo createFromParcel(Parcel parcel) {
            return new RedPacketOrderVo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPacketOrderVo[] newArray(int i) {
            return new RedPacketOrderVo[i];
        }
    };
    public int amoutToPay;
    public String appId;
    public String mchId;
    public String nonceStr;
    public String prepayId;
    public String redId;
    public String shengPaySign;
    public String shengPaySignType;
    public String sign;
    public String signType;
    public String timestamp;
    public String tradeType;
    public String transferId;
    public String vcode;

    public RedPacketOrderVo(Parcel parcel) {
        this.redId = parcel.readString();
        this.transferId = parcel.readString();
        this.vcode = parcel.readString();
        this.appId = parcel.readString();
        this.mchId = parcel.readString();
        this.prepayId = parcel.readString();
        this.timestamp = parcel.readString();
        this.nonceStr = parcel.readString();
        this.signType = parcel.readString();
        this.sign = parcel.readString();
        this.shengPaySign = parcel.readString();
        this.tradeType = parcel.readString();
        this.shengPaySignType = parcel.readString();
        this.amoutToPay = parcel.readInt();
    }

    public static RedPacketOrderVo parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RedPacketOrderVo redPacketOrderVo = new RedPacketOrderVo();
        redPacketOrderVo.redId = jSONObject.optString("redId");
        redPacketOrderVo.transferId = jSONObject.optString("transferId");
        redPacketOrderVo.vcode = jSONObject.optString(RedirectRespWrapper.KEY_VERCODE);
        redPacketOrderVo.shengPaySign = jSONObject.optString("shengPaySign");
        redPacketOrderVo.tradeType = jSONObject.optString("tradeType");
        redPacketOrderVo.shengPaySignType = jSONObject.optString("shengPaySignType");
        redPacketOrderVo.amoutToPay = jSONObject.optInt("amoutToPay");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("payParams");
        if (jSONObjectOptJSONObject == null) {
            return redPacketOrderVo;
        }
        redPacketOrderVo.appId = jSONObjectOptJSONObject.optString("appId");
        redPacketOrderVo.mchId = jSONObjectOptJSONObject.optString("mchId");
        redPacketOrderVo.prepayId = jSONObjectOptJSONObject.optString("prepayId");
        redPacketOrderVo.timestamp = jSONObjectOptJSONObject.optString("timestamp");
        redPacketOrderVo.nonceStr = jSONObjectOptJSONObject.optString("nonceStr");
        redPacketOrderVo.signType = jSONObjectOptJSONObject.optString("signType");
        redPacketOrderVo.sign = jSONObjectOptJSONObject.optString("sign");
        return redPacketOrderVo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.redId);
        parcel.writeString(this.transferId);
        parcel.writeString(this.vcode);
        parcel.writeString(this.appId);
        parcel.writeString(this.mchId);
        parcel.writeString(this.prepayId);
        parcel.writeString(this.timestamp);
        parcel.writeString(this.nonceStr);
        parcel.writeString(this.signType);
        parcel.writeString(this.sign);
        parcel.writeString(this.shengPaySign);
        parcel.writeString(this.tradeType);
        parcel.writeString(this.shengPaySignType);
        parcel.writeInt(this.amoutToPay);
    }

    public RedPacketOrderVo() {
    }
}
