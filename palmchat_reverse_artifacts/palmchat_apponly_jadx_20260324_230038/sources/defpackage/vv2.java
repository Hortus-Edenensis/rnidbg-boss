package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vv2 extends JDispatchAction {
    public final void a(Context context, long j, int i, ByteBuffer byteBuffer) {
        if (i == 19) {
            tt5.u().r(context, "tcp_a18", null);
            return;
        }
        if (i == 30 || i == 32) {
            o75.m().u(context, 0, i);
            return;
        }
        if (i != 25) {
            if (i == 26 && byteBuffer != null) {
                short s = byteBuffer.getShort();
                if (s == 0) {
                    e66.b().f(context, j);
                    return;
                } else {
                    e66.b().e(context, j, s);
                    return;
                }
            }
            return;
        }
        try {
            Bundle bundle = new Bundle();
            byte[] bArrArray = byteBuffer.array();
            bundle.putByteArray("RESPONSE_BODY", bArrArray);
            if (bArrArray.length > 0) {
                tt5.u().x(Arrays.copyOf(bArrArray, bArrArray.length));
            }
            qv2.a(context, "cmd", bundle);
        } catch (Throwable th) {
            k63.l("JCoreDispatchAction", "[handleCoreAction] handle ctrl cmd is error:" + th);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i, int i2, long j, long j2, ByteBuffer byteBuffer) {
        try {
            a(context, j2, i, byteBuffer);
        } catch (Throwable th) {
            k63.l("JCoreDispatchAction", "dispatchMessage failed:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "core_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return wv2.b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i) {
        return i == 0 || i == 1 || i == 19 || i == 25 || i == 26 || i == 30 || i == 32;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.equals("asm")) {
                        o75.m().g(context, bundle);
                    } else if (str2.equals("asmr")) {
                        o75.m().h(context, bundle);
                    } else if (str2.equals("notification_state") || str2.equals("old_cmd") || str2.equals("user_present") || str2.equals("set_wake_enable")) {
                        qv2.a(context, str2, bundle);
                    }
                }
            } catch (Throwable th) {
                k63.l("JCoreDispatchAction", "onActionRun failed:" + th.getMessage());
            }
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
    }
}
