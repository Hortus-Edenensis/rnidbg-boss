package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class sa6 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jo2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jo2 f20699a;

        public a(jo2 jo2Var) {
            this.f20699a = jo2Var;
        }

        @Override // defpackage.jo2
        public void onError(int i, String str) {
            hc1 hc1Var = new hc1();
            hc1Var.f21045a = 0;
            this.f20699a.onSuccess(hc1Var);
        }

        @Override // defpackage.jo2
        public void onSuccess(Object obj) {
            hc1 hc1Var = new hc1();
            hc1Var.f21045a = 0;
            this.f20699a.onSuccess(hc1Var);
        }
    }

    public void a(CallCmd.a aVar, jo2 jo2Var) {
        if (aVar.e != null) {
            String strA = eg5.c().a();
            String strB = eg5.c().b();
            hc1 hc1Var = new hc1();
            rh6 rh6Var = new rh6();
            rh6Var.j = RoomUserInfo.buildFromSelf();
            rh6Var.f = strA;
            RoomSDKInfo roomSDKInfo = aVar.e;
            rh6Var.i = roomSDKInfo.userList;
            rh6Var.h = roomSDKInfo.groupId;
            rh6Var.l = um0.a();
            rh6Var.g = strB;
            rh6Var.b = aVar.f11317a.getValue();
            RoomSDKInfo roomSDKInfo2 = aVar.e;
            rh6Var.c = roomSDKInfo2.roomId;
            rh6Var.e = strA;
            rh6Var.d = roomSDKInfo2.roomToken;
            rh6Var.k = ir5.b();
            hc1Var.d = rh6Var;
            jo2Var.onSuccess(hc1Var);
        }
    }

    public void b(ry4 ry4Var, CallType callType, VoipState voipState, jo2 jo2Var) {
        if (ry4Var == null || TextUtils.isEmpty(ry4Var.f20624a) || callType == null || voipState == null) {
            jo2Var.onError(-1, i86.c(R$string.argument_is_invalid, new String[0]));
            return;
        }
        Log.d("VideoCallRTSClient", "updateVoipState status:" + voipState);
        eb3.e(ry4Var, voipState, new a(jo2Var));
    }
}
