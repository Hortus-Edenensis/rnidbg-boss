package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class rh6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("status")
    public int f20479a;

    @SerializedName("type")
    public int b;

    @SerializedName("room_id")
    public String c;

    @SerializedName("token")
    public String d;

    @SerializedName("user_id")
    public String e;

    @SerializedName("from_user_id")
    public String f;

    @SerializedName("from_user_name")
    public String g;
    public String h;
    public ArrayList<RoomUserInfo> i;
    public RoomUserInfo j;

    @SerializedName(RemoteMessageConst.TTL)
    public long k;

    @SerializedName("rtc_app_id")
    public String l;
    public long m;

    public CallType a() {
        return CallType.formValue(this.b);
    }

    public String toString() {
        return "VoipInfo{status=" + this.f20479a + ", callType=" + this.b + ", roomID='" + this.c + "', userId='" + this.e + "', callerUid='" + this.f + "', callerUname='" + this.g + "', calleeUid='" + this.i + "', groupId='" + this.h + "'}";
    }
}
