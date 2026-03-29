package defpackage;

import android.content.Context;
import android.os.Handler;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupChattingUIActivity;
import com.zenmen.media.roomchatdemo.videocallgroup.d;
import com.zenmen.palmchat.chat.groupvideochat.vo.UserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class wa6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21647a = "wa6";

    public static int a(Class cls) {
        try {
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivityW2 = VideoCallGroupChattingUIActivity.w2();
            if (videoCallGroupChattingUIActivityW2 == null || cls == VideoCallGroupChattingUIActivity.class) {
                return -1;
            }
            return videoCallGroupChattingUIActivityW2.getPageId();
        } catch (Exception e) {
            LogUtil.i(f21647a, e.getStackTrace().toString());
            return -1;
        }
    }

    public static void b(String str, Context context) {
        try {
            d.P().U(Long.parseLong(str), context);
        } catch (Exception e) {
            LogUtil.i(f21647a, e.getStackTrace().toString());
        }
    }

    public static yf5 c(Handler handler) {
        yf5 yf5VarA;
        yf5 yf5Var = null;
        try {
            yf5VarA = yf5.A();
        } catch (Exception e) {
            e = e;
        }
        try {
            yf5VarA.C(null, 123, handler);
            return yf5VarA;
        } catch (Exception e2) {
            e = e2;
            yf5Var = yf5VarA;
            e.printStackTrace();
            return yf5Var;
        }
    }

    public static boolean d() {
        return oa6.i();
    }

    public static boolean e(String str) {
        if (d.P() != null) {
            return d.P().Z(str);
        }
        return false;
    }

    public static boolean f() {
        if (d.P() != null) {
            return d.P().a0("updateStatus");
        }
        return false;
    }

    public static void g(String str, String str2, List<UserInfo> list) {
        na6.i(RTCParameters.l(), Long.parseLong(str), str2, list);
    }

    public static void h(boolean z, String str) {
        try {
            if (z) {
                d.P().S();
            } else {
                d.P().p(Long.parseLong(str));
            }
        } catch (Exception e) {
            LogUtil.i(f21647a, e.getStackTrace().toString());
        }
    }

    public static void i(String str, String str2, String str3, List<String> list, int i) {
        try {
            na6.j(RTCParameters.l(), Long.parseLong(str), Long.parseLong(str2));
            d.P().J(i, Long.parseLong(str2), Long.parseLong(str3), Long.parseLong(str), list);
        } catch (Exception e) {
            LogUtil.i(f21647a, e.getStackTrace().toString());
        }
    }

    public static void j(String str) {
        try {
            if (d.P() != null) {
                d.P().g0(str);
            }
        } catch (Exception e) {
            LogUtil.i(f21647a, e.getStackTrace().toString());
        }
    }

    public static void k() {
        try {
            d.P().s0();
        } catch (Exception e) {
            LogUtil.i(f21647a, e.getStackTrace().toString());
        }
    }
}
