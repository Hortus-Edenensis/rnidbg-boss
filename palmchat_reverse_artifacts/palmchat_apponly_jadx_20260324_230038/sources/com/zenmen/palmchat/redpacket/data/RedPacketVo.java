package com.zenmen.palmchat.redpacket.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.zenmen.palmchat.Vo.MessageVo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RedPacketVo implements Parcelable {
    public static final Parcelable.Creator<RedPacketVo> CREATOR = new Parcelable.Creator<RedPacketVo>() { // from class: com.zenmen.palmchat.redpacket.data.RedPacketVo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPacketVo createFromParcel(Parcel parcel) {
            return new RedPacketVo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPacketVo[] newArray(int i) {
            return new RedPacketVo[i];
        }
    };
    public String redId;
    public int redType;
    public String remark;
    public String vcode;

    public RedPacketVo() {
    }

    private static RedPacketVo buildFromJson(String str) {
        RedPacketVo redPacketVo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("redInfo");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            RedPacketVo redPacketVo2 = new RedPacketVo();
            try {
                redPacketVo2.redId = jSONObjectOptJSONObject.optString("redId");
                redPacketVo2.remark = jSONObjectOptJSONObject.optString("remark");
                redPacketVo2.vcode = jSONObjectOptJSONObject.optString(RedirectRespWrapper.KEY_VERCODE);
                redPacketVo2.redType = jSONObjectOptJSONObject.optInt("redType");
                return redPacketVo2;
            } catch (JSONException e) {
                e = e;
                redPacketVo = redPacketVo2;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        e.printStackTrace();
        return redPacketVo;
    }

    public static RedPacketVo buildFromMessageVo(MessageVo messageVo) {
        if (messageVo != null) {
            return buildFromJson(messageVo.extention);
        }
        return null;
    }

    public String buildExtForSend() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("redId", this.redId);
            jSONObject2.put("remark", this.remark);
            jSONObject2.put(RedirectRespWrapper.KEY_VERCODE, this.vcode);
            jSONObject2.put("redType", this.redType);
            jSONObject.put("redInfo", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.redId);
        parcel.writeString(this.remark);
        parcel.writeString(this.vcode);
        parcel.writeInt(this.redType);
    }

    public RedPacketVo(Parcel parcel) {
        this.redId = parcel.readString();
        this.remark = parcel.readString();
        this.vcode = parcel.readString();
        this.redType = parcel.readInt();
    }
}
