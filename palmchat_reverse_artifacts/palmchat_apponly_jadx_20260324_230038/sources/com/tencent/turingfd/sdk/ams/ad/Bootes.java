package com.tencent.turingfd.sdk.ams.ad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface Bootes extends IInterface {
    int a() throws RemoteException;

    int a(int i) throws RemoteException;

    int b(int i) throws RemoteException;

    boolean c(int i) throws RemoteException;

    Codlin d(int i) throws RemoteException;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Bootes$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Cdo extends Binder implements Bootes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f10667a = Cfinally.a(Cfinally.L0);

        /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Bootes$do$do, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0894do implements Bootes {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f10668a;

            public C0894do(IBinder iBinder) {
                this.f10668a = iBinder;
            }

            @Override // com.tencent.turingfd.sdk.ams.ad.Bootes
            public int a(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Cdo.f10667a);
                    parcelObtain.writeInt(i);
                    this.f10668a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10668a;
            }

            @Override // com.tencent.turingfd.sdk.ams.ad.Bootes
            public int b(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Cdo.f10667a);
                    parcelObtain.writeInt(i);
                    this.f10668a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.turingfd.sdk.ams.ad.Bootes
            public boolean c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Cdo.f10667a);
                    parcelObtain.writeInt(i);
                    this.f10668a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.turingfd.sdk.ams.ad.Bootes
            public Codlin d(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Cdo.f10667a);
                    parcelObtain.writeInt(i);
                    this.f10668a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? new Codlin(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.tencent.turingfd.sdk.ams.ad.Bootes
            public int a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Cdo.f10667a);
                    this.f10668a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
