package defpackage;

import com.zenmen.media.roomchat.ZMRoomChatImp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class qy4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ZMRoomChatImp f20354a;

    public static void a() {
        ZMRoomChatImp zMRoomChatImp = f20354a;
        if (zMRoomChatImp != null) {
            zMRoomChatImp.e();
            f20354a.nativeRelease();
            f20354a = null;
        }
    }

    public static ZMRoomChatImp b() {
        if (f20354a == null) {
            f20354a = new ZMRoomChatImp();
        }
        return f20354a;
    }
}
