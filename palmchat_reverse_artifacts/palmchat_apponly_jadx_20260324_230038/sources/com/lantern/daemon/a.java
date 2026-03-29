package com.lantern.daemon;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface a extends IInterface {
    void y() throws RemoteException;

    /* JADX INFO: renamed from: com.lantern.daemon.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0642a extends Binder implements a {
        public AbstractBinderC0642a() {
            attachInterface(this, "com.lantern.daemon.IPersistentService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.lantern.daemon.IPersistentService");
                return true;
            }
            parcel.enforceInterface("com.lantern.daemon.IPersistentService");
            y();
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
