package com.oplus.tblplayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.tblplayer.misc.TimedText;
import com.oplus.tblplayer.monitor.Report;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IRemoteObservable extends IInterface {
    void notifyBufferedUpdate(int i) throws RemoteException;

    void notifyBufferingUpdate(int i) throws RemoteException;

    void notifyCompletion() throws RemoteException;

    void notifyDownstreamSizeChanged(int i, int i2, int i3, float f) throws RemoteException;

    boolean notifyError(int i, int i2, String str) throws RemoteException;

    boolean notifyInfo(int i, List<String> list) throws RemoteException;

    void notifyIsPlayingChanged(boolean z) throws RemoteException;

    void notifyPlaybackResult(Report report) throws RemoteException;

    void notifyPlayerStateChanged(int i) throws RemoteException;

    void notifyPrepared() throws RemoteException;

    void notifySeekComplete() throws RemoteException;

    void notifyTimedText(TimedText timedText) throws RemoteException;

    void notifyVideoSizeChanged(int i, int i2, int i3, float f) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static class Default implements IRemoteObservable {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyError(int i, int i2, String str) throws RemoteException {
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyInfo(int i, List<String> list) throws RemoteException {
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyCompletion() throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPrepared() throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifySeekComplete() throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferedUpdate(int i) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferingUpdate(int i) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyIsPlayingChanged(boolean z) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlaybackResult(Report report) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlayerStateChanged(int i) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyTimedText(TimedText timedText) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyDownstreamSizeChanged(int i, int i2, int i3, float f) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyVideoSizeChanged(int i, int i2, int i3, float f) throws RemoteException {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Stub extends Binder implements IRemoteObservable {
        private static final String DESCRIPTOR = "com.oplus.tblplayer.IRemoteObservable";
        static final int TRANSACTION_notifyBufferedUpdate = 4;
        static final int TRANSACTION_notifyBufferingUpdate = 3;
        static final int TRANSACTION_notifyCompletion = 2;
        static final int TRANSACTION_notifyDownstreamSizeChanged = 13;
        static final int TRANSACTION_notifyError = 7;
        static final int TRANSACTION_notifyInfo = 8;
        static final int TRANSACTION_notifyIsPlayingChanged = 12;
        static final int TRANSACTION_notifyPlaybackResult = 10;
        static final int TRANSACTION_notifyPlayerStateChanged = 11;
        static final int TRANSACTION_notifyPrepared = 1;
        static final int TRANSACTION_notifySeekComplete = 5;
        static final int TRANSACTION_notifyTimedText = 9;
        static final int TRANSACTION_notifyVideoSizeChanged = 6;

        /* JADX INFO: compiled from: SearchBox */
        public static class Proxy implements IRemoteObservable {
            public static IRemoteObservable sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyBufferedUpdate(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyBufferedUpdate(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyBufferingUpdate(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyBufferingUpdate(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyCompletion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyCompletion();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyDownstreamSizeChanged(int i, int i2, int i3, float f) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeFloat(f);
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyDownstreamSizeChanged(i, i2, i3, f);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public boolean notifyError(int i, int i2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyError(i, i2, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public boolean notifyInfo(int i, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyInfo(i, list);
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.readStringList(list);
                    return z;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyIsPlayingChanged(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyIsPlayingChanged(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPlaybackResult(Report report) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (report != null) {
                        parcelObtain.writeInt(1);
                        report.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyPlaybackResult(report);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPlayerStateChanged(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyPlayerStateChanged(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPrepared() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyPrepared();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifySeekComplete() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifySeekComplete();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyTimedText(TimedText timedText) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (timedText != null) {
                        parcelObtain.writeInt(1);
                        timedText.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyTimedText(timedText);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyVideoSizeChanged(int i, int i2, int i3, float f) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeFloat(f);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyVideoSizeChanged(i, i2, i3, f);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteObservable asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteObservable)) ? new Proxy(iBinder) : (IRemoteObservable) iInterfaceQueryLocalInterface;
        }

        public static IRemoteObservable getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteObservable iRemoteObservable) {
            if (Proxy.sDefaultImpl != null || iRemoteObservable == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteObservable;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPrepared();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyCompletion();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyBufferingUpdate(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyBufferedUpdate(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifySeekComplete();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyVideoSizeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zNotifyError = notifyError(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zNotifyError ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int i3 = parcel.readInt();
                    ArrayList arrayList = new ArrayList();
                    boolean zNotifyInfo = notifyInfo(i3, arrayList);
                    parcel2.writeNoException();
                    parcel2.writeInt(zNotifyInfo ? 1 : 0);
                    parcel2.writeStringList(arrayList);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyTimedText(parcel.readInt() != 0 ? TimedText.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPlaybackResult(parcel.readInt() != 0 ? Report.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPlayerStateChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyIsPlayingChanged(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyDownstreamSizeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
