package com.zenmen.media.roomchat;

import android.util.Log;
import com.huawei.openalliance.ad.constant.dc;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ZMRtcParseRoomInfo implements Serializable {
    private static final int ZMRTC_CHATROOM_CMD_ALICE_CREATE_ROOM_ACK = 101;
    private static final int ZMRTC_CHATROOM_CMD_NEW_INCOMING_CALL = 102;
    private static final int ZMRTC_CHATROOM_CMD_SYNC_GROUP_EVENT = 116;
    private static final int ZMRTC_CHATROOM_CMD_SYNC_GROUP_STATUS = 117;
    private static final int ZMRTC_CHATROOM_CMD_SYNC_ROOM_STATUS = 112;
    public static final int ZMRTC_CHATROOM_USER_CONNCECTING = 0;
    public static final int ZMRTC_CHATROOM_USER_CONNCECTTED = 1;
    public int mCmd;
    public long mGroupId;
    public int mRetCode;
    public long mRoomid;
    public long mRoomkey;
    public int mSessionId;
    public int mTag;
    public ArrayList<UserItem> mUserList = new ArrayList<>();
    public long transid;

    /* JADX INFO: compiled from: SearchBox */
    public class UserItem implements Serializable {
        public int mCameraOn;
        public long mInviterID;
        public boolean mIsInitator;
        public int mMute;
        public long mUserCID;
        public long mUserID;
        public int mUserStatus;

        public UserItem(long j, long j2, int i, long j3, boolean z, int i2, int i3) {
            this.mUserID = j;
            this.mUserCID = j2;
            this.mUserStatus = i;
            this.mIsInitator = z;
            this.mInviterID = j3;
            this.mMute = i2;
            this.mCameraOn = i3;
        }
    }

    public ZMRtcParseRoomInfo(String str) {
        this.mCmd = 0;
        this.mRoomid = 0L;
        this.mRoomkey = 0L;
        this.mSessionId = 0;
        this.mGroupId = 0L;
        this.mRetCode = 0;
        this.transid = 0L;
        this.mTag = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mCmd = jSONObject.getInt("cmd");
            try {
                this.mRoomid = jSONObject.getLong("roomid");
            } catch (Exception unused) {
                this.mRoomid = 0L;
            }
            try {
                this.mSessionId = jSONObject.getInt("sessionid");
            } catch (Exception unused2) {
            }
            try {
                this.transid = jSONObject.getLong("transid");
            } catch (Exception unused3) {
            }
            try {
                this.mGroupId = jSONObject.getLong("groupid");
            } catch (Exception unused4) {
            }
            try {
                this.mRetCode = jSONObject.getInt("retcode");
            } catch (JSONException unused5) {
                this.mRetCode = 0;
            }
            try {
                this.mTag = jSONObject.getInt("tag");
            } catch (JSONException unused6) {
                this.mTag = 0;
            }
            int i = this.mCmd;
            if (i == 102) {
                this.mRoomkey = jSONObject.getLong("roomkey");
                parseCurrentUserList(jSONObject);
            } else {
                if (i == 112) {
                    parseCurrentUserList(jSONObject);
                    return;
                }
                if (i == 116 || i == 117) {
                    Log.i("ZMRtcParseRoomInfo", "cmd:" + this.mCmd);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private int parseCurrentUserList(JSONObject jSONObject) throws JSONException {
        long j;
        long j2;
        int i;
        int i2;
        int i3;
        boolean z;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("roominfo");
            JSONArray jSONArray = jSONObject2.getJSONArray("userlist");
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                long j3 = 0;
                try {
                    j = jSONObject3.getLong(DeviceInfoUtil.UID_TAG);
                } catch (JSONException unused) {
                    j = 0;
                }
                try {
                    j2 = jSONObject3.getLong("cid");
                } catch (JSONException unused2) {
                    j2 = 0;
                }
                try {
                    i = jSONObject3.getInt("status");
                } catch (JSONException unused3) {
                    i = 0;
                }
                try {
                    j3 = jSONObject3.getLong("inviter");
                } catch (JSONException unused4) {
                }
                long j4 = j3;
                try {
                    i2 = jSONObject3.getInt(dc.C);
                } catch (JSONException unused5) {
                    i2 = 0;
                }
                try {
                    i3 = jSONObject3.getInt("camera");
                } catch (JSONException unused6) {
                    i3 = 0;
                }
                try {
                    z = jSONObject3.getLong(DeviceInfoUtil.UID_TAG) == jSONObject2.getLong("initiator_uid");
                } catch (JSONException unused7) {
                    z = false;
                }
                try {
                    this.mUserList.add(new UserItem(j, j2, i, j4, z, i2, i3));
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
