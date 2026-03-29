package com.zenmen.palmchat.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.igexin.sdk.PushConsts;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.by5;
import defpackage.ch;
import defpackage.r75;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class PhoneStateChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<String> f14693a = new a();
    public Set<String> b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashSet<String> {
        public a() {
            add("android.provider.Telephony.SMS_RECEIVED");
            add("android.intent.action.BATTERY_CHANGED");
            add(PushConsts.ACTION_BROADCAST_USER_PRESENT);
            add("android.intent.action.BOOT_COMPLETED");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashSet<String> {
        public b() {
            add("android.intent.action.ACTION_NEW_PICTURE");
            add("android.intent.action.ACTION_NEW_VIDEO");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            LogUtil.i("PhoneStateChangeReceiver", "action =" + action);
            if (action != null) {
                if (action.equals("android.intent.action.LOCALE_CHANGED")) {
                    if (ch.s().u() != null) {
                        try {
                            ch.s().u().A();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    VolleyNetwork.setUserAgent(context);
                    if (AppContext.getContext() != null) {
                        AppContext.getContext().sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
                        return;
                    }
                    return;
                }
                if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                    by5.l(Locale.getDefault());
                    return;
                }
                if (r75.k()) {
                    return;
                }
                boolean z = true;
                if (!this.f14693a.contains(action) && this.b.contains(action)) {
                    z = false;
                }
                if (z) {
                    AppContext.getContext().initMessagingService("STASRT_REASON_PHONE_STATUS_CHANGE" + action);
                }
            }
        }
    }
}
