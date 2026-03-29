package com.oplus.tblplayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IRemoteLinker extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static class Default implements IRemoteLinker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.tblplayer.IRemoteLinker
        public IBinder create() throws RemoteException {
            return null;
        }
    }

    IBinder create() throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Stub extends Binder implements IRemoteLinker {
        private static final String DESCRIPTOR = "com.oplus.tblplayer.IRemoteLinker";
        static final int TRANSACTION_create = 1;

        /* JADX INFO: compiled from: SearchBox */
        public static class Proxy implements IRemoteLinker {
            public static IRemoteLinker sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.tblplayer.IRemoteLinker
            public IBinder create() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().create();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteLinker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteLinker)) ? new Proxy(iBinder) : (IRemoteLinker) iInterfaceQueryLocalInterface;
        }

        public static IRemoteLinker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteLinker iRemoteLinker) {
            if (Proxy.sDefaultImpl != null || iRemoteLinker == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteLinker;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            IBinder iBinderCreate = create();
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderCreate);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
