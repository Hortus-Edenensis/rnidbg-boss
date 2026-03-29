package com.zenmen.palmchat.lxvoip;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.rtc.bean.VoipCmdMsg;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.eb3;
import defpackage.eg5;
import defpackage.hg5;
import defpackage.ja6;
import defpackage.jy;
import defpackage.l96;
import defpackage.rh6;
import defpackage.rx;
import defpackage.va6;
import defpackage.ww;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LxVoipManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum CallMediaType {
        CALL_MEDIA_TYPE_AUDIO,
        CALL_MEDIA_TYPE_VIDEO
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14575a;
        public final /* synthetic */ CallType b;
        public final /* synthetic */ RoomSDKInfo c;

        public a(Activity activity, CallType callType, RoomSDKInfo roomSDKInfo) {
            this.f14575a = activity;
            this.b = callType;
            this.c = roomSDKInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.jy
        public void a(jy.a aVar) {
            if (!aVar.b) {
                hg5.g((String) aVar.f18531a);
                return;
            }
            Activity activity = this.f14575a;
            CallType callType = this.b;
            String strA = eg5.c().a();
            RoomSDKInfo roomSDKInfo = this.c;
            String str = roomSDKInfo.groupId;
            ArrayList<RoomUserInfo> arrayList = roomSDKInfo.userList;
            CallActivity.S1(activity, callType, strA, str, arrayList, arrayList.get(0).nickName);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements jy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14576a;
        public final /* synthetic */ CallType b;
        public final /* synthetic */ RoomSDKInfo c;

        public b(Activity activity, CallType callType, RoomSDKInfo roomSDKInfo) {
            this.f14576a = activity;
            this.b = callType;
            this.c = roomSDKInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.jy
        public void a(jy.a aVar) {
            LogUtil.i("RTC", "joinRoom " + aVar.b);
            if (!aVar.b) {
                hg5.g((String) aVar.f18531a);
                return;
            }
            Activity activity = this.f14576a;
            CallType callType = this.b;
            String strA = eg5.c().a();
            RoomSDKInfo roomSDKInfo = this.c;
            String str = roomSDKInfo.groupId;
            ArrayList<RoomUserInfo> arrayList = roomSDKInfo.userList;
            CallActivity.S1(activity, callType, strA, str, arrayList, arrayList.get(0).nickName);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements rx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14577a;

        public c(ArrayList arrayList) {
            this.f14577a = arrayList;
        }

        @Override // defpackage.rx
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                ja6.f().b(va6.a(this.f14577a));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static LxVoipManager f14578a = new LxVoipManager();
    }

    public static LxVoipManager b() {
        return d.f14578a;
    }

    public static boolean f() {
        return true;
    }

    public Intent a() {
        return CallActivity.I1();
    }

    public RoomSDKInfo c() {
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        if (rh6VarZ == null) {
            return null;
        }
        RoomSDKInfo roomSDKInfo = new RoomSDKInfo();
        roomSDKInfo.groupId = rh6VarZ.h;
        roomSDKInfo.roomId = rh6VarZ.c;
        roomSDKInfo.roomToken = rh6VarZ.d;
        roomSDKInfo.userList = rh6VarZ.i;
        roomSDKInfo.type = rh6VarZ.b;
        return roomSDKInfo;
    }

    public void d(Application application) {
        l96.a(application, new ww.e());
    }

    public void e(String str) {
        l96.b(str);
    }

    public boolean g() {
        return com.volcengine.lxvertc.videocall.call.a.t().J() && com.volcengine.lxvertc.videocall.call.a.t().z() != null;
    }

    public void h(Activity activity, boolean z, RoomSDKInfo roomSDKInfo) {
        CallType callType = z ? CallType.VOICE : CallType.VIDEO;
        com.volcengine.lxvertc.videocall.call.a.t().K(roomSDKInfo, callType, new b(activity, callType, roomSDKInfo));
    }

    public void i(ArrayList<String> arrayList, ArrayList<RoomUserInfo> arrayList2) {
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        if (rh6VarZ != null) {
            ww.d(rh6VarZ.c, 1, rh6VarZ.h, arrayList, new c(arrayList2));
        }
    }

    public void j() {
        if (b().g()) {
            com.volcengine.lxvertc.videocall.call.a.t().A(null);
        }
    }

    public void k(VoipCmdMsg voipCmdMsg) {
        eb3.c(voipCmdMsg);
    }

    public void l(VoiceMatchInfo voiceMatchInfo) {
        rh6 rh6Var = new rh6();
        rh6Var.b = (voiceMatchInfo.isVoiceMatch ? CallType.VOICE : CallType.VIDEO).getValue();
        rh6Var.f = "";
        ArrayList<RoomUserInfo> arrayList = new ArrayList<>();
        rh6Var.i = arrayList;
        arrayList.add(voiceMatchInfo.getMatchUserInfo());
        rh6Var.g = "";
        CallActivity.U1(rh6Var.a(), rh6Var.f, rh6Var.h, rh6Var.i, rh6Var.g);
    }

    public void m(Activity activity, RoomSDKInfo roomSDKInfo, CallMediaType callMediaType) {
        CallMediaType callMediaType2 = CallMediaType.CALL_MEDIA_TYPE_AUDIO;
        com.volcengine.lxvertc.videocall.call.a.t().q(roomSDKInfo, callMediaType == callMediaType2 ? CallType.VOICE : CallType.VIDEO, new a(activity, callMediaType == callMediaType2 ? CallType.VOICE : CallType.VIDEO, roomSDKInfo));
    }
}
