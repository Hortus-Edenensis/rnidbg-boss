package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cdadata.sdk.api.ZMDataSDKManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class o67 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19704a = "android.intent.action.SCREEN_ON";
    public String b = "android.intent.action.SCREEN_OFF";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        z47 zMDataActivityLifecycleCallbacks;
        String str;
        if (this.f19704a.equals(intent.getAction())) {
            zMDataActivityLifecycleCallbacks = ZMDataSDKManager.getInstance().getZMDataActivityLifecycleCallbacks();
            str = "AppScreenOn";
        } else {
            if (!this.b.equals(intent.getAction())) {
                return;
            }
            zMDataActivityLifecycleCallbacks = ZMDataSDKManager.getInstance().getZMDataActivityLifecycleCallbacks();
            str = "AppScreenOff";
        }
        zMDataActivityLifecycleCallbacks.f(str, false);
    }
}
