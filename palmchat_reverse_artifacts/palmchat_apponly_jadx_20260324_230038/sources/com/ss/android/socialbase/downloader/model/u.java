package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.a;
import com.ss.android.socialbase.downloader.depend.dw;
import com.ss.android.socialbase.downloader.depend.iz;
import com.ss.android.socialbase.downloader.depend.jk;
import com.ss.android.socialbase.downloader.depend.kj;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.my;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.pn;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.wq;
import com.ss.android.socialbase.downloader.depend.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface u extends IInterface {
    my a() throws RemoteException;

    rh b() throws RemoteException;

    kj fx() throws RemoteException;

    l fx(int i) throws RemoteException;

    iz iz() throws RemoteException;

    jk jk() throws RemoteException;

    int l() throws RemoteException;

    wq n() throws RemoteException;

    a nr(int i) throws RemoteException;

    com.ss.android.socialbase.downloader.depend.pn nr() throws RemoteException;

    n pn() throws RemoteException;

    x t() throws RemoteException;

    int u(int i) throws RemoteException;

    a u(int i, int i2) throws RemoteException;

    DownloadInfo u() throws RemoteException;

    dw x() throws RemoteException;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0879u extends Binder implements u {
        public AbstractBinderC0879u() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static u mv() {
            return C0880u.u;
        }

        public static u u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof u)) ? new C0880u(iBinder) : (u) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo downloadInfoU = u();
                    parcel2.writeNoException();
                    if (downloadInfoU != null) {
                        parcel2.writeInt(1);
                        downloadInfoU.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.depend.pn pnVarNr = nr();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pnVarNr != null ? pnVarNr.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iU = u(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iU);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    a aVarU = u(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aVarU != null ? aVarU.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    a aVarNr = nr(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aVarNr != null ? aVarNr.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    kj kjVarFx = fx();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kjVarFx != null ? kjVarFx.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    rh rhVarB = b();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(rhVarB != null ? rhVarB.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    n nVarPn = pn();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nVarPn != null ? nVarPn.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    iz izVarIz = iz();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(izVarIz != null ? izVarIz.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    dw dwVarX = x();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(dwVarX != null ? dwVarX.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    wq wqVarN = n();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(wqVarN != null ? wqVarN.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    my myVarA = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(myVarA != null ? myVarA.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    jk jkVarJk = jk();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(jkVarJk != null ? jkVarJk.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    x xVarT = t();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(xVarT != null ? xVarT.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iL = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(iL);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    l lVarFx = fx(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(lVarFx != null ? lVarFx.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.u$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0880u implements u {
            public static u u;
            private IBinder nr;

            public C0880u(IBinder iBinder) {
                this.nr = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public my a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().a();
                    }
                    parcelObtain2.readException();
                    return my.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.nr;
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public rh b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().b();
                    }
                    parcelObtain2.readException();
                    return rh.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public kj fx() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().fx();
                    }
                    parcelObtain2.readException();
                    return kj.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public iz iz() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().iz();
                    }
                    parcelObtain2.readException();
                    return iz.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public jk jk() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().jk();
                    }
                    parcelObtain2.readException();
                    return jk.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public int l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().l();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public wq n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().n();
                    }
                    parcelObtain2.readException();
                    return wq.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.pn nr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().nr();
                    }
                    parcelObtain2.readException();
                    return pn.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public n pn() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().pn();
                    }
                    parcelObtain2.readException();
                    return n.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public x t() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().t();
                    }
                    parcelObtain2.readException();
                    return x.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public DownloadInfo u() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().u();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public dw x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.nr.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().x();
                    }
                    parcelObtain2.readException();
                    return dw.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public l fx(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.nr.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().fx(i);
                    }
                    parcelObtain2.readException();
                    return l.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public a nr(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.nr.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().nr(i);
                    }
                    parcelObtain2.readException();
                    return a.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public int u(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.nr.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().u(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public a u(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.nr.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0879u.mv() != null) {
                        return AbstractBinderC0879u.mv().u(i, i2);
                    }
                    parcelObtain2.readException();
                    return a.u.u(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
