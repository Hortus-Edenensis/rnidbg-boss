package com.zenmen.palmchat.deamon.AccountStubProvider;

import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.cq5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AccountSyncService extends AccountSyncServiceBase {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtil.d("AccountSync", " AccountSyncService.onCreate");
        this.f13919a = new cq5(getApplicationContext());
    }
}
