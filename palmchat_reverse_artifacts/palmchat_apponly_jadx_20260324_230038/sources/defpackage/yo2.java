package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import defpackage.ap2;
import defpackage.zo2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface yo2 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void cancelSync(ap2 ap2Var) throws RemoteException;

    void onUnsyncableAccount(zo2 zo2Var) throws RemoteException;

    void startSync(ap2 ap2Var, String str, Account account, Bundle bundle) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements yo2 {
        public static final String DESCRIPTOR = "android.content.ISyncAdapter";
        static final int TRANSACTION_cancelSync = 3;
        static final int TRANSACTION_onUnsyncableAccount = 1;
        static final int TRANSACTION_startSync = 2;

        /* JADX INFO: renamed from: yo2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1295a implements yo2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f22242a;

            public C1295a(IBinder iBinder) {
                this.f22242a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22242a;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static yo2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof yo2)) ? new C1295a(iBinder) : (yo2) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onUnsyncableAccount(zo2.a.g(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 2) {
                startSync(ap2.a.g(parcel.readStrongBinder()), parcel.readString(), (Account) b.b(parcel, Account.CREATOR), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                cancelSync(ap2.a.g(parcel.readStrongBinder()));
                parcel2.writeNoException();
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
