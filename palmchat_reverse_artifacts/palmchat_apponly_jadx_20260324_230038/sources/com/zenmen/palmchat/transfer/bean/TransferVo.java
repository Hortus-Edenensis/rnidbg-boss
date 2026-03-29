package com.zenmen.palmchat.transfer.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.zenmen.palmchat.Vo.MessageVo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TransferVo implements Parcelable {
    public static final Parcelable.Creator<TransferVo> CREATOR = new Parcelable.Creator<TransferVo>() { // from class: com.zenmen.palmchat.transfer.bean.TransferVo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransferVo createFromParcel(Parcel parcel) {
            return new TransferVo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransferVo[] newArray(int i) {
            return new TransferVo[i];
        }
    };
    public int amount;
    public String remark;
    public int status;
    public String transferId;
    public String vcode;

    public TransferVo() {
    }

    public static TransferVo buildFromJson(String str) {
        TransferVo transferVo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("transferMsg");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            TransferVo transferVo2 = new TransferVo();
            try {
                transferVo2.transferId = jSONObjectOptJSONObject.optString("transferId");
                transferVo2.remark = jSONObjectOptJSONObject.optString("remark");
                transferVo2.vcode = jSONObjectOptJSONObject.optString(RedirectRespWrapper.KEY_VERCODE);
                transferVo2.status = jSONObjectOptJSONObject.optInt("status");
                transferVo2.amount = jSONObjectOptJSONObject.optInt("amount");
                return transferVo2;
            } catch (JSONException e) {
                e = e;
                transferVo = transferVo2;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        e.printStackTrace();
        return transferVo;
    }

    public static TransferVo buildFromMessageVo(MessageVo messageVo) {
        if (messageVo != null) {
            return buildFromJson(messageVo.extention);
        }
        return null;
    }

    public String buildExtForSend() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("transferId", this.transferId);
            jSONObject2.put("remark", this.remark);
            jSONObject2.put(RedirectRespWrapper.KEY_VERCODE, this.vcode);
            jSONObject2.put("status", this.status);
            jSONObject2.put("amount", this.amount);
            jSONObject.put("transferMsg", jSONObject2);
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
        parcel.writeString(this.transferId);
        parcel.writeString(this.remark);
        parcel.writeString(this.vcode);
        parcel.writeInt(this.status);
        parcel.writeInt(this.amount);
    }

    public TransferVo(Parcel parcel) {
        this.transferId = parcel.readString();
        this.remark = parcel.readString();
        this.vcode = parcel.readString();
        this.status = parcel.readInt();
        this.amount = parcel.readInt();
    }
}
