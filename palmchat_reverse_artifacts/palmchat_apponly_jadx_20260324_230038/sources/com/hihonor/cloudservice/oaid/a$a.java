package com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a$a extends Binder implements IInterface {
    public a$a() {
        attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
    }

    @Override // android.os.IInterface
    public native IBinder asBinder();

    @Override // android.os.Binder
    public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
}
