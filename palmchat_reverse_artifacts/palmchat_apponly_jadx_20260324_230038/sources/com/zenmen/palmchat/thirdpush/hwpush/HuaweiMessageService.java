package com.zenmen.palmchat.thirdpush.hwpush;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.dm1;
import defpackage.fn2;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.nl0;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class HuaweiMessageService extends HmsMessageService {
    public long b = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15576a;

        public a(boolean z) {
            this.f15576a = z;
            put("isConnected", Boolean.valueOf(z));
        }
    }

    public final void c() {
        boolean zIsConnected;
        fn2 fn2VarU = ch.s().u();
        if (fn2VarU != null) {
            try {
                zIsConnected = fn2VarU.isConnected();
            } catch (RemoteException e) {
                e.printStackTrace();
                zIsConnected = false;
            }
        } else {
            zIsConnected = false;
        }
        if (!zIsConnected) {
            AppContext.getContext().initMessagingService(false, "STASRT_REASON_THIRD_PUSH_RECEIVE");
        }
        if (fn2VarU == null || zIsConnected) {
            iq5.j(false, new String[0]);
        }
        LogUtil.uploadInfoImmediateWithRateCheck("HW_PUSH_RECEIVE_1", new a(zIsConnected));
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        LogUtil.i("HWPUSH_MessageService", "onMessageReceived=" + remoteMessage);
        if (Math.abs(ir5.b() - this.b) > 5000) {
            c();
        }
        this.b = ir5.b();
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        LogUtil.i("HWPUSH_MessageService", "onNewToken=" + str);
        if (!TextUtils.isEmpty(str) && nl0.g() && PushTokenManager.h() && dm1.d()) {
            PushTokenManager.l(str, PushTokenManager.PushType.HUAWEI);
        }
    }
}
