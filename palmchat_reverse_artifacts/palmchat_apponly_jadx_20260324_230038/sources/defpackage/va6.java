package defpackage;

import com.google.gson.annotations.SerializedName;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class va6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    public String f21394a;

    @SerializedName("user_id")
    public String b;

    @SerializedName("icon")
    public String c;
    public boolean d;
    public transient boolean e;
    public transient boolean f;
    public transient boolean g;

    public va6() {
    }

    public static List<va6> a(ArrayList<RoomUserInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            for (RoomUserInfo roomUserInfo : arrayList) {
                va6 va6Var = new va6();
                va6Var.b = roomUserInfo.uid;
                va6Var.f21394a = roomUserInfo.nickName;
                va6Var.c = roomUserInfo.headImg;
                va6Var.f = false;
                va6Var.e = true;
                va6Var.d = true;
                arrayList2.add(va6Var);
            }
        }
        return arrayList2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        va6 va6Var = (va6) obj;
        return Objects.equals(this.b, va6Var.b) && this.g == va6Var.g;
    }

    public int hashCode() {
        return Objects.hash(this.b, Boolean.valueOf(this.g));
    }

    public String toString() {
        return "VideoCallUserInfo{userName='" + this.f21394a + "', userId='" + this.b + "', isMicOn=" + this.e + ", isCameraOn=" + this.f + ", isScreenShare=" + this.g + '}';
    }

    public va6(String str) {
        this.b = str;
        this.f21394a = str;
    }
}
