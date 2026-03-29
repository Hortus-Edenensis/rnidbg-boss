package defpackage;

import android.text.TextUtils;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.a;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class er4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17346a = false;
    public static HashMap<String, Boolean> b = new HashMap<>();

    public static String a(rh6 rh6Var) {
        return ap3.a().T().t() ? ap3.a().T().x().isVoiceMatch ? "audioMatch" : "videoMatch" : TextUtils.isEmpty(rh6Var.h) ? "1v1Chat" : "groupChat";
    }

    public static String b(rh6 rh6Var) {
        return e(rh6Var) ? c(rh6Var.i) : rh6Var.f;
    }

    public static String c(ArrayList<RoomUserInfo> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i).uid);
                if (i != arrayList.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static String d(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static boolean e(rh6 rh6Var) {
        String str = rh6Var.f;
        return str != null && str.equals(eg5.c().a());
    }

    public static boolean f() {
        String str;
        Boolean bool;
        RoomSDKInfo roomSDKInfo = ap3.a().T().x().chattinginfo;
        return (roomSDKInfo == null || (str = roomSDKInfo.roomId) == null || (bool = b.get(str)) == null || !bool.booleanValue()) ? false : true;
    }

    public static void g() {
        f17346a = false;
    }

    public static void h() {
        f17346a = true;
    }

    public static void i(String str, boolean z) {
        b.put(str, Boolean.valueOf(z));
    }

    public static void j(String str, int i, String str2, List<String> list) {
        HashMap map = new HashMap();
        map.put("fuid", d(list));
        map.put("type", String.valueOf(i));
        map.put("BusinessId", TextUtils.isEmpty(str) ? "1v1Chat" : "groupChat");
        map.put("roomId", str2);
        map.put("domain", TextUtils.isEmpty(str) ? "youni" : "muc.youni");
        map.put("bizType", "0");
        zn6.i("ByteRTC_dial", map);
    }

    public static void k(rh6 rh6Var, int i, long j) {
        HashMap map = new HashMap();
        map.put("fuid", b(rh6Var));
        map.put("type", CallType.formValue(rh6Var.b) == CallType.VOICE ? "0" : "1");
        map.put("BusinessId", a(rh6Var));
        map.put("roomId", rh6Var.c);
        map.put("domain", TextUtils.isEmpty(rh6Var.h) ? "youni" : "muc.youni");
        map.put("bizType", "0");
        map.put("reason", String.valueOf(i));
        map.put("duration", String.valueOf(j));
        zn6.i("ByteRTC_end", map);
    }

    public static void l(rh6 rh6Var) {
        HashMap map = new HashMap();
        map.put("fuid", b(rh6Var));
        map.put("type", CallType.formValue(rh6Var.b) == CallType.VOICE ? "0" : "1");
        map.put("BusinessId", TextUtils.isEmpty(rh6Var.h) ? "1v1Chat" : "groupChat");
        map.put("roomId", rh6Var.c);
        map.put("domain", TextUtils.isEmpty(rh6Var.h) ? "youni" : "muc.youni");
        map.put("bizType", "0");
        zn6.i("ByteRTC_get", map);
    }

    public static void m(rh6 rh6Var) {
        HashMap map = new HashMap();
        map.put("fuid", b(rh6Var));
        map.put("type", CallType.formValue(rh6Var.b) == CallType.VOICE ? "0" : "1");
        map.put("BusinessId", a(rh6Var));
        map.put("roomId", rh6Var.c);
        map.put("domain", TextUtils.isEmpty(rh6Var.h) ? "youni" : "muc.youni");
        map.put("bizType", "0");
        zn6.i("ByteRTC_start", map);
    }

    public static void n(VoipState voipState, rh6 rh6Var) {
        if (rh6Var != null) {
            if (voipState == VoipState.ONTHECALL) {
                m(rh6Var);
                return;
            }
            if (voipState == VoipState.CANCELLED) {
                k(rh6Var, 1, 0L);
                return;
            }
            if (voipState == VoipState.REFUSED) {
                k(rh6Var, 2, 0L);
            } else if (voipState == VoipState.UNAVAILABLE) {
                k(rh6Var, e(rh6Var) ? 15 : 5, 0L);
            } else if (voipState == VoipState.TERMINATED) {
                k(rh6Var, f17346a ? 13 : 3, a.t().s());
            }
        }
    }
}
