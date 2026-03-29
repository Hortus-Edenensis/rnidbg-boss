package defpackage;

import android.text.TextUtils;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.rtc.bean.VoipCmdMsg;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cx {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ iy f16940a;

        public a(iy iyVar) {
            this.f16940a = iyVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ap3.a().N(this.f16940a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ iy f16941a;

        public b(iy iyVar) {
            this.f16941a = iyVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ap3.a().N(this.f16941a);
        }
    }

    public static String a(boolean z, int i, long j) {
        String str = j > 0 ? j >= 3600 ? String.format(Locale.ROOT, "%d:%02d:%02d", Long.valueOf(j / 3600), Long.valueOf((j % 3600) / 60), Long.valueOf(j % 60)) : String.format(Locale.ROOT, "%02d:%02d", Long.valueOf((j % 3600) / 60), Long.valueOf(j % 60)) : null;
        String str2 = "对方忙线中";
        if (z) {
            if (i == 5) {
                str2 = "对方无应答";
            } else if (i == 6 && str != null) {
                str2 = "通话时长 " + str;
            } else if (i == 3) {
                str2 = "对方已拒绝";
            } else if (i != 9) {
                str2 = "已取消";
            }
            if (j > 0) {
                str2 = "通话时长 " + str;
            }
        } else {
            if (i == 6 && str != null) {
                str2 = "通话时长 " + str;
            } else if (i == 3) {
                str2 = "已拒绝";
            } else if (i != 9) {
                str2 = "对方已取消";
            }
            if (j > 0) {
                str2 = "通话时长 " + str;
            }
        }
        LogUtil.i("CallLogManager", "message=" + str2 + " reason=" + i + " time=" + j + " iscaller=" + z);
        return str2;
    }

    public static int b(CallCmd callCmd) {
        if (callCmd == CallCmd.TIME_OUT) {
            return 5;
        }
        if (callCmd == CallCmd.REFUSE) {
            return 3;
        }
        if (callCmd == CallCmd.CANCEL) {
            return 4;
        }
        return callCmd == CallCmd.HANGUP ? 6 : 1;
    }

    public static void c(VoipCmdMsg voipCmdMsg) {
        LogUtil.i("CallLogManager", "insertMsgFromLxSocket cmd=" + az2.c(voipCmdMsg));
        if (voipCmdMsg != null) {
            int i = voipCmdMsg.subType;
            if ((i == 5 || i == 3 || i == 4 || i == 6) && TextUtils.isEmpty(voipCmdMsg.groupId)) {
                int i2 = voipCmdMsg.subType;
                long j = voipCmdMsg.duration / 1000;
                iy iyVar = new iy();
                iyVar.g = voipCmdMsg.roomId;
                boolean zEquals = eg5.c().a().equals(voipCmdMsg.caller.uid);
                iyVar.b = voipCmdMsg.getTargetUid();
                iyVar.c = zEquals;
                iyVar.f = zEquals || i2 == 4 || i2 == 6 || i2 == 3;
                iyVar.d = voipCmdMsg.mediaType == 0 ? LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_AUDIO : LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_VIDEO;
                iyVar.e = a(zEquals, i2, j);
                iyVar.f18288a = 0;
                u93.e(new a(iyVar));
            }
        }
    }

    public static void d(CallCmd callCmd) {
        int iB = b(callCmd);
        LogUtil.i("CallLogManager", "insertMsgFromRTCCallback cmd" + callCmd);
        long jS = com.volcengine.lxvertc.videocall.call.a.t().s() / 1000;
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        if (rh6VarZ != null) {
            if ((iB == 5 || iB == 3 || iB == 4 || iB == 6) && TextUtils.isEmpty(rh6VarZ.h) && !TextUtils.isEmpty(eg5.c().a())) {
                LogUtil.i("CallLogManager", "insertMsgFromRongCallback enter during=" + jS);
                if (ap3.a().T().t() && iB == 5) {
                    return;
                }
                iy iyVar = new iy();
                iyVar.g = rh6VarZ.c;
                boolean zEquals = eg5.c().a().equals(rh6VarZ.f);
                String str = rh6VarZ.i.get(0).uid;
                if (!zEquals) {
                    str = rh6VarZ.f;
                }
                iyVar.b = str;
                iyVar.c = zEquals;
                iyVar.f = zEquals || iB == 4 || iB == 6 || iB == 3;
                iyVar.d = CallType.formValue(rh6VarZ.b) == CallType.VOICE ? LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_AUDIO : LxVoipManager.CallMediaType.CALL_MEDIA_TYPE_VIDEO;
                iyVar.e = a(zEquals, iB, jS);
                iyVar.f18288a = 0;
                u93.e(new b(iyVar));
            }
        }
    }
}
