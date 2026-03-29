package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface qn2 extends IInterface {
    void onFail(int i, String str);

    void onSuccess();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements qn2 {
        private static final String DESCRIPTOR = "com.mcs.aidl.INotifiPermissionCallback";
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        /* JADX INFO: renamed from: qn2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1269a implements qn2 {
            public static qn2 b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f20281a;

            public C1269a(IBinder iBinder) {
                this.f20281a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20281a;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static qn2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qn2)) ? new C1269a(iBinder) : (qn2) iInterfaceQueryLocalInterface;
        }

        public static qn2 getDefaultImpl() {
            return C1269a.b;
        }

        public static boolean setDefaultImpl(qn2 qn2Var) {
            if (C1269a.b != null || qn2Var == null) {
                return false;
            }
            C1269a.b = qn2Var;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess();
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onFail(parcel.readInt(), parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
