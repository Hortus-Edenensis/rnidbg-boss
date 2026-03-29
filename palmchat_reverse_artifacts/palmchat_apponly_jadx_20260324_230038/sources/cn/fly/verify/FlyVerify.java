package cn.fly.verify;

import android.content.Context;
import cn.fly.verify.common.callback.OperationCallback;
import cn.fly.verify.pure.entity.PreVerifyResult;
import cn.fly.verify.pure.entity.VerifyResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class FlyVerify {
    public static final int SDK_VERSION_CODE;
    private static final String SDK_VERSION_NAME = "13.6.2";
    public static final p instance = p.a();
    public static String sdkTag = "FLYVERIFY";

    static {
        int i = 0;
        for (String str : "13.6.2".split("\\.")) {
            i = (i * 100) + Integer.parseInt(str);
        }
        SDK_VERSION_CODE = i;
    }

    public static String getVersion() {
        return "13.6.2";
    }

    public static void init(Context context, String str, String str2) {
        ax.a(context, str, str2);
    }

    public static void preVerify(OperationCallback<PreVerifyResult> operationCallback) {
        instance.a(operationCallback);
    }

    public static void setPreVerifyTimeout(long j) {
        ak.f2068a = Long.valueOf(j);
    }

    public static void submitPolicyGrantResult(CustomController customController, boolean z) {
        ax.a(customController, z);
    }

    public static void updateCustomController(CustomController customController) {
        ax.a(customController);
    }

    public static void verify(OperationCallback<VerifyResult> operationCallback) {
        instance.b(operationCallback);
    }

    public static void preVerify(OperationCallback<PreVerifyResult> operationCallback, boolean z) {
        instance.a(operationCallback, z);
    }

    public static void submitPolicyGrantResult(boolean z) {
        ax.a(z);
    }
}
