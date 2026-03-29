package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class l extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f3377a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f3377a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b.a("handleMessage !!");
        if (message.what == 0) {
            this.f3377a.a((JSONObject) message.obj);
        }
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.j.get(message.getData().getString("listenerKey"));
        b.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
