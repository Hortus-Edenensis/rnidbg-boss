package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a0 extends m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4907a = "com.qiku.id";
    public static String b = "qiku.service.action.id";
    public Context c;
    public boolean d = false;
    public z e;
    public y f;

    public a0(Context context) {
        p0.a("QikuIdmanager", "QikuProvider");
        this.c = checkContext(context);
    }

    public final native boolean a(Intent intent);

    public native boolean a(String str);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // android.content.ServiceConnection
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    public native void onServiceDisconnected(ComponentName componentName);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}
