package com.zenmen.palmchat.groupchat.dao;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupModifyResultVo implements Parcelable {
    public static final Parcelable.Creator<GroupModifyResultVo> CREATOR = new a();
    public static final int RESULT_CODE_ALREADY_IN_GROUP = 4006;
    public static final int RESULT_CODE_FAIL_NONE_FRIEND = 4002;
    public static final int RESULT_CODE_OK = 0;
    public static final int RESULT_CODE_SUCCESS_PARTLY = 4001;
    public static final int RESUL_CODE_BLACK_LIST = 5077;
    public static final int RESUL_CODE_CARD_NEED_REALNAME = 4029;
    public static final int RESUL_CODE_CARD_NEED_REALNAME_OWNER = 4030;
    public static final int RESUL_CODE_GEN_QR_NEED_CHOOSE_TYPE = 4036;
    public static final int RESUL_CODE_GEN_QR_NEED_REALNAME = 4031;
    public static final int RESUL_CODE_INVITE_BLACK_LIST_TYPE = 5082;
    public static final int RESUL_CODE_INVITE_NEED_CHOOSE_TYPE = 4035;
    public static final int RESUL_CODE_INVITE_REALNAME = 4026;
    public static final int RESUL_CODE_INVITE_REALNAME_OWNER = 4027;
    public static final int RESUL_CODE_NOT_ALLOW_MODIFY_CIRCLE_NAME = 5308;
    public static final int RESUL_CODE_ONLY_INVITE = 4022;
    public static final int RESUL_CODE_QR_NEED_REALNAME = 4033;
    public static final int RESUL_CODE_QR_NEED_REALNAME_OWNER = 4034;
    public static final int RESUL_CODE_QR_NEED_VERIFY = 5061;
    public static final int RESUL_CODE_REALNAME = 4028;
    public static final int RESUL_CODE_SUCCESS_NUMBER_BIG = 4015;
    public static final int RESUL_CODE_SUCCESS_NUMBER_INVITE = 4016;
    public static final int RESUL_CODE_USER_HAVE_REMOVED = 5083;
    public static final int RESUL_CODE_USER_NOT_ALLOW_OP = 5084;
    public String errorMsg;
    public String[] members;
    public int resultCode;
    public String roomId;
    public int scenes;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GroupModifyResultVo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo createFromParcel(Parcel parcel) {
            return new GroupModifyResultVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo[] newArray(int i) {
            return new GroupModifyResultVo[i];
        }
    }

    public GroupModifyResultVo() {
        this.resultCode = -1;
    }

    public static GroupModifyResultVo buildFromJsonObject(JSONObject jSONObject) {
        String[] strArr;
        GroupModifyResultVo groupModifyResultVo = new GroupModifyResultVo();
        groupModifyResultVo.resultCode = jSONObject.optInt("resultCode");
        groupModifyResultVo.roomId = jSONObject.optString("roomId");
        groupModifyResultVo.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        groupModifyResultVo.scenes = jSONObject.optInt("scenes", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        if (jSONArrayOptJSONArray != null) {
            strArr = new String[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                strArr[i] = jSONArrayOptJSONArray.optString(i);
            }
        } else {
            strArr = null;
        }
        groupModifyResultVo.members = strArr;
        return groupModifyResultVo;
    }

    public static void onDialogEvent(GroupModifyResultVo groupModifyResultVo, String str) {
        if (groupModifyResultVo == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("code", Integer.valueOf(groupModifyResultVo.resultCode));
        map.put("scene", Integer.valueOf(groupModifyResultVo.scenes));
        zn6.j("group_ban_dialog", str, map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.resultCode);
        parcel.writeStringArray(this.members);
        parcel.writeString(this.roomId);
        parcel.writeString(this.errorMsg);
    }

    public GroupModifyResultVo(Parcel parcel) {
        this.resultCode = -1;
        this.resultCode = parcel.readInt();
        this.members = parcel.createStringArray();
        this.roomId = parcel.readString();
        this.errorMsg = parcel.readString();
    }
}
