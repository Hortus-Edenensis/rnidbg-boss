package defpackage;

import android.text.TextUtils;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.a;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.rtc.bean.VoipCmdMsg;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class eb3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m96 f17258a;

    public static rh6 a(VoipCmdMsg voipCmdMsg) {
        rh6 rh6Var = null;
        if (voipCmdMsg != null) {
            LogUtil.i("RTC", "convert" + az2.c(voipCmdMsg));
            rh6 rh6Var2 = new rh6();
            rh6Var2.i = voipCmdMsg.userList;
            rh6Var2.h = "0".equals(voipCmdMsg.groupId) ? null : voipCmdMsg.groupId;
            rh6Var2.c = voipCmdMsg.roomId;
            rh6Var2.d = voipCmdMsg.roomToken;
            rh6Var2.b = (voipCmdMsg.mediaType == 0 ? CallType.VOICE : CallType.VIDEO).getValue();
            RoomUserInfo roomUserInfo = voipCmdMsg.caller;
            if (roomUserInfo != null) {
                rh6Var2.f = roomUserInfo.uid;
                rh6Var2.g = roomUserInfo.nickName;
            }
            rh6Var2.j = roomUserInfo;
            rh6Var2.l = um0.a();
            rh6Var2.m = voipCmdMsg.callSTime;
            rh6Var = rh6Var2;
        }
        LogUtil.i("RTC", "convert finish" + az2.c(rh6Var));
        return rh6Var;
    }

    public static int b(VoipState voipState) {
        if (voipState == VoipState.ACCEPTED) {
            return 2;
        }
        if (voipState == VoipState.CANCELLED) {
            return 4;
        }
        if (voipState == VoipState.TERMINATED) {
            return 6;
        }
        if (voipState == VoipState.REFUSED) {
            return 3;
        }
        return voipState == VoipState.UNAVAILABLE ? 5 : 0;
    }

    public static void c(VoipCmdMsg voipCmdMsg) {
        String str;
        rh6 rh6VarZ = a.t().z();
        if (rh6VarZ == null || (str = rh6VarZ.c) == null || str.equals(voipCmdMsg.roomId)) {
            rh6 rh6VarA = a(voipCmdMsg);
            int i = voipCmdMsg.subType;
            if (rh6VarA != null) {
                sh6 sh6Var = new sh6();
                sh6Var.b = rh6VarA;
                if (i == 1) {
                    er4.l(rh6VarA);
                    if (Math.abs(voipCmdMsg.createTime - ir5.c(true)) > 30000 || ap3.a().C()) {
                        return;
                    }
                    sx.b(rh6VarA, TextUtils.isEmpty(rh6VarA.h) ? "1v1Chat" : "groupChat");
                    return;
                }
                if (i == 2) {
                    sh6Var.f20748a = 4;
                    a.t().O(sh6Var);
                    return;
                }
                if (i == 3) {
                    sh6Var.f20748a = 3;
                    a.t().O(sh6Var);
                    return;
                }
                if (i == 4) {
                    sh6Var.f20748a = 5;
                    a.t().O(sh6Var);
                    return;
                }
                if (i == 5) {
                    sh6Var.f20748a = 3;
                    a.t().O(sh6Var);
                    return;
                }
                if (i == 6 || i == 8) {
                    sh6Var.f20748a = 3;
                    a.t().O(sh6Var);
                } else if (i == 7) {
                    if (voipCmdMsg.roomStatus == 0) {
                        sh6Var.f20748a = 5;
                        a.t().O(sh6Var);
                    }
                    ja6.f().g(rh6VarA);
                }
            }
        }
    }

    public static void d(CallCmd callCmd) {
        LogUtil.i("RTC", "onRtcStateChanged cmd=" + callCmd);
        m96 m96Var = f17258a;
        if (m96Var != null) {
            m96Var.a(callCmd);
        }
    }

    public static void e(ry4 ry4Var, VoipState voipState, jo2 jo2Var) {
        int iB = b(voipState);
        LogUtil.i("RTC", "sendServiceMsg state=" + voipState + " actionType=" + iB);
        m96 m96Var = f17258a;
        if (m96Var != null) {
            if (iB == 0) {
                jo2Var.onSuccess(null);
            } else {
                m96Var.b(ry4Var, iB, jo2Var);
            }
        }
    }

    public static void f(m96 m96Var) {
        f17258a = m96Var;
    }
}
