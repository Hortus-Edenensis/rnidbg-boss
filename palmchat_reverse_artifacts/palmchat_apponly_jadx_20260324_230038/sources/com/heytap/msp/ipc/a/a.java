package com.heytap.msp.ipc.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.msp.ipc.common.exception.IPCBridgeDispatchException;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.heytap.msp.ipc.common.exception.IPCBridgeExecuteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
abstract class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Parcelable f6362a;
    protected String b;
    protected String c;
    final ReentrantLock d;
    int e;

    public a(List<l> list, String str, String str2, Parcelable parcelable, Bundle bundle) {
        super(list);
        this.d = new ReentrantLock(true);
        this.e = 5000;
        this.c = str;
        this.b = str2;
        this.f6362a = parcelable;
        this.j = bundle;
    }

    public Object a(int i, Object... objArr) throws IPCBridgeException {
        return a(this.h, b(), this.f6362a, i, objArr);
    }

    public abstract Bundle b(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException;

    @Override // com.heytap.msp.ipc.a.g
    public String b() {
        return this.b;
    }

    public Object a(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        j.b("BaseClient", "callForResult");
        Bundle bundleB = b(context, str, parcelable, i, objArr);
        j.a("BaseClient", "callRemote --- resultBundle:" + bundleB);
        if (bundleB == null) {
            j.c("BaseClient", "remote response is NULL");
            throw new IPCBridgeException("remote response is NULL", 102004);
        }
        bundleB.setClassLoader(getClass().getClassLoader());
        int i2 = bundleB.getInt("resultCode");
        if (i2 == 0) {
            return bundleB.get("resultData");
        }
        String string = bundleB.getString("resultMsg");
        j.c("BaseClient", "error code:" + i2 + ", message:" + string);
        if (i2 == 101008) {
            Exception exc = (Exception) bundleB.getSerializable("resultException");
            j.a("BaseClient", "code:" + i2, exc);
            throw new IPCBridgeException(exc, i2);
        }
        if (i2 < 102000) {
            throw new IPCBridgeException(string, i2);
        }
        if (i2 < 103000) {
            throw new IPCBridgeDispatchException(string, i2);
        }
        if (i2 != 103000) {
            throw new IPCBridgeException(string, i2);
        }
        int i3 = bundleB.getInt("interceptorCode");
        String string2 = bundleB.getString("interceptorMsg");
        j.c("BaseClient", "interceptor error code:" + i2 + ", message:" + string);
        throw new IPCBridgeExecuteException(string2, i3);
    }

    @Override // com.heytap.msp.ipc.a.g
    public String a() {
        return this.c;
    }

    @Override // com.heytap.msp.ipc.a.g
    public List<l> a(List<l> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new l(it.next()));
        }
        return arrayList;
    }

    public void a(com.heytap.msp.ipc.c.a aVar) {
        j.b("BaseClient", "setServerFilter:" + aVar.getClass().getName());
        this.i = aVar;
    }
}
