package com.zenmen.palmchat.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.tm;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AccountService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tm f12175a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f12175a.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f12175a = new tm(this);
    }
}
