package com.zenmen.palmchat.redpacket.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.ho3;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VoucherRedPacketVo implements Parcelable {
    public static final Parcelable.Creator<VoucherRedPacketVo> CREATOR = new Parcelable.Creator<VoucherRedPacketVo>() { // from class: com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoucherRedPacketVo createFromParcel(Parcel parcel) {
            return new VoucherRedPacketVo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoucherRedPacketVo[] newArray(int i) {
            return new VoucherRedPacketVo[i];
        }
    };
    public static final String KEY_THREAD_HAS_VOUCHER = "key_thread_has_voucher_of_";
    public static final int TYPE_VOUCHER_RED_PACKET_NEWER = 4;
    public static final int TYPE_VOUCHER_RED_PACKET_ORDINARY = 2;
    public static final int TYPE_VOUCHER_RED_PACKET_RANDOM = 1;
    public static final int TYPE_VOUCHER_RED_PACKET_SPEC = 3;
    public String couponId;
    public int couponType;
    public String remark;
    public String specificNickname;
    public String specificUid;
    public String vcode;

    public VoucherRedPacketVo() {
    }

    private static VoucherRedPacketVo buildFromJson(String str) {
        VoucherRedPacketVo voucherRedPacketVo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("couponInfo");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            VoucherRedPacketVo voucherRedPacketVo2 = new VoucherRedPacketVo();
            try {
                voucherRedPacketVo2.couponId = jSONObjectOptJSONObject.optString("couponId");
                voucherRedPacketVo2.remark = jSONObjectOptJSONObject.optString("remark");
                voucherRedPacketVo2.vcode = jSONObjectOptJSONObject.optString(RedirectRespWrapper.KEY_VERCODE);
                voucherRedPacketVo2.specificUid = jSONObjectOptJSONObject.optString("specificUid");
                voucherRedPacketVo2.specificNickname = jSONObjectOptJSONObject.optString("specificNickname");
                voucherRedPacketVo2.couponType = jSONObjectOptJSONObject.optInt("couponType");
                return voucherRedPacketVo2;
            } catch (JSONException e) {
                e = e;
                voucherRedPacketVo = voucherRedPacketVo2;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        e.printStackTrace();
        return voucherRedPacketVo;
    }

    public static VoucherRedPacketVo buildFromMessageVo(MessageVo messageVo) {
        if (messageVo != null) {
            return buildFromJson(messageVo.extention);
        }
        return null;
    }

    public static void circleThreadHasVoucherStatus(String str, int i) {
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putInt(KEY_THREAD_HAS_VOUCHER + AccountUtils.p(AppContext.getContext()) + "_" + str, i).apply();
    }

    public static int getCircleThreadHasVoucherStatus(String str) {
        return SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).getInt(KEY_THREAD_HAS_VOUCHER + AccountUtils.p(AppContext.getContext()) + "_" + str, 0);
    }

    private static VoucherRedPacketVo getItemFromCursor(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        VoucherRedPacketVo voucherRedPacketVo = new VoucherRedPacketVo();
        String string = cursor.getString(cursor.getColumnIndex("msg_extend"));
        return !TextUtils.isEmpty(string) ? buildFromJson(string) : voucherRedPacketVo;
    }

    public static boolean isSpecTypeForOthers(ContentValues contentValues) {
        int iOptInt;
        String asString = contentValues.getAsString("msg_extend");
        if (!TextUtils.isEmpty(asString)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(asString).optJSONObject("couponInfo");
                if (jSONObjectOptJSONObject != null && ((iOptInt = jSONObjectOptJSONObject.optInt("couponType")) == 3 || iOptInt == 4)) {
                    String strOptString = jSONObjectOptJSONObject.optString("specificUid");
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("couponStatus", 0);
                    if (!TextUtils.equals(AccountUtils.p(AppContext.getContext()), strOptString) || iOptInt2 == 1) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static ArrayList<VoucherRedPacketVo> ungrabbedVoucherRedPackets(String str) {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, "contact_relate=? and msg_type=? and data1=?", new String[]{str + DomainHelper.Domains.DOMAIN_GROUPCHAT.domain, String.valueOf(22), String.valueOf(0)}, "_id DESC");
        if (cursorQuery == null) {
            return null;
        }
        ArrayList<VoucherRedPacketVo> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            VoucherRedPacketVo itemFromCursor = getItemFromCursor(cursorQuery);
            if (itemFromCursor != null) {
                if (TextUtils.isEmpty(itemFromCursor.specificUid) || "0".equals(itemFromCursor.specificUid)) {
                    arrayList.add(itemFromCursor);
                } else if (TextUtils.equals(AccountUtils.p(AppContext.getContext()), itemFromCursor.specificUid)) {
                    arrayList.add(itemFromCursor);
                }
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public String buildExtForSend() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("couponId", this.couponId);
            jSONObject2.put("remark", this.remark);
            jSONObject2.put(RedirectRespWrapper.KEY_VERCODE, this.vcode);
            jSONObject2.put("specificUid", this.specificUid);
            jSONObject2.put("specificNickname", this.specificNickname);
            jSONObject2.put("couponType", this.couponType);
            jSONObject.put("couponInfo", jSONObject2);
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
        parcel.writeString(this.couponId);
        parcel.writeString(this.remark);
        parcel.writeString(this.vcode);
        parcel.writeString(this.specificUid);
        parcel.writeString(this.specificNickname);
        parcel.writeInt(this.couponType);
    }

    public VoucherRedPacketVo(Parcel parcel) {
        this.couponId = parcel.readString();
        this.remark = parcel.readString();
        this.vcode = parcel.readString();
        this.specificUid = parcel.readString();
        this.specificNickname = parcel.readString();
        this.couponType = parcel.readInt();
    }
}
