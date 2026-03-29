package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.umcrash.IUMCrashCallbackWithType;
import com.umeng.umcrash.UMCrash;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class n36 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19429a = ac1.m;
    public static Boolean b = Boolean.TRUE;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements IUMCrashCallbackWithType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19430a;

        public a(Context context) {
            this.f19430a = context;
        }

        @Override // com.umeng.umcrash.IUMCrashCallbackWithType
        public String onCallback(IUMCrashCallbackWithType.CrashType crashType) {
            String str = "deviceId : " + ac1.h + "\nuid : " + AccountUtils.p(this.f19430a);
            LogUtil.i("UMengHelper", "onCallback type=" + crashType);
            return str;
        }
    }

    public static void a(Context context) {
        UMConfigure.init(context, "611e17381401b20b6f734277", f19429a, 1, "28d042d92f80807de35089a5a3a74d97");
        if (c()) {
            UMCrash.registerUMCrashCallback(new a(context));
        }
    }

    public static void b(Context context) {
        boolean zC = c();
        if (zC) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(UMCrash.KEY_ENABLE_CRASH_JAVA, zC);
            bundle.putBoolean(UMCrash.KEY_ENABLE_CRASH_NATIVE, zC);
            bundle.putBoolean(UMCrash.KEY_ENABLE_ANR, zC);
            bundle.putBoolean(UMCrash.KEY_ENABLE_PA, false);
            bundle.putBoolean(UMCrash.KEY_ENABLE_LAUNCH, false);
            bundle.putBoolean(UMCrash.KEY_ENABLE_MEM, false);
            bundle.putBoolean(UMCrash.KEY_ENABLE_NET, false);
            bundle.putBoolean(UMCrash.KEY_ENABLE_H5PAGE, false);
            UMCrash.initConfig(bundle);
            a(context);
            LogUtil.i("UMengHelper", "init in main process");
        }
    }

    public static boolean c() {
        if (b == null) {
            b = Boolean.valueOf(gw5.a().b("umengapm"));
        }
        LogUtil.i("UMengHelper", "isApmServiceEnable: " + b);
        return b.booleanValue();
    }

    public static void d(Context context) {
        if (c()) {
            LogUtil.i("UMengHelper", "preInit");
            UMConfigure.preInit(context, "611e17381401b20b6f734277", f19429a);
        }
    }
}
