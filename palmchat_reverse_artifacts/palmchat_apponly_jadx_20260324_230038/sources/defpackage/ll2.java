package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface ll2 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    String bind(ll2 ll2Var, String str) throws RemoteException;

    Bundle execute(String str, String str2, Bundle bundle) throws RemoteException;

    IBinder getBinderByType(String str, String str2) throws RemoteException;

    void onAction(String str, String str2, Bundle bundle) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements ll2 {
        static final int TRANSACTION_bind = 4;
        static final int TRANSACTION_execute = 3;
        static final int TRANSACTION_getBinderByType = 1;
        static final int TRANSACTION_onAction = 2;

        /* JADX INFO: renamed from: ll2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1244a implements ll2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f19025a;

            public C1244a(IBinder iBinder) {
                this.f19025a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19025a;
            }

            @Override // defpackage.ll2
            public String bind(ll2 ll2Var, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
                    parcelObtain.writeStrongInterface(ll2Var);
                    parcelObtain.writeString(str);
                    this.f19025a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.ll2
            public Bundle execute(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    b.d(parcelObtain, bundle, 0);
                    this.f19025a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) b.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.ll2
            public void onAction(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    b.d(parcelObtain, bundle, 0);
                    this.f19025a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "cn.jiguang.android.IDataShare");
        }

        public static ll2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("cn.jiguang.android.IDataShare");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ll2)) ? new C1244a(iBinder) : (ll2) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("cn.jiguang.android.IDataShare");
            }
            if (i == 1598968902) {
                parcel2.writeString("cn.jiguang.android.IDataShare");
                return true;
            }
            if (i == 1) {
                IBinder binderByType = getBinderByType(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binderByType);
            } else if (i == 2) {
                onAction(parcel.readString(), parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
            } else if (i == 3) {
                Bundle bundleExecute = execute(parcel.readString(), parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                b.d(parcel2, bundleExecute, 1);
            } else {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                String strBind = bind(asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strBind);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
