package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.ParcelPair;
import com.zenmen.palmchat.Vo.SyncKeys;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public interface fn2 extends IInterface {

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

    void A() throws RemoteException;

    void E() throws RemoteException;

    void F(String str) throws RemoteException;

    void G() throws RemoteException;

    void J() throws RemoteException;

    void M(String str, String str2, String str3, String str4) throws RemoteException;

    ParcelPair h() throws RemoteException;

    void i(String str, String str2) throws RemoteException;

    boolean isConnected() throws RemoteException;

    void j() throws RemoteException;

    boolean k(boolean z, boolean z2, SyncKeys syncKeys) throws RemoteException;

    void l(MessageVo messageVo) throws RemoteException;

    void n(String str, String str2) throws RemoteException;

    boolean o(boolean z, boolean z2, List<String> list) throws RemoteException;

    void p() throws RemoteException;

    void q() throws RemoteException;

    void r(MessageVo messageVo) throws RemoteException;

    void s(String str) throws RemoteException;

    boolean w() throws RemoteException;

    void x(long j) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements fn2 {

        /* JADX INFO: renamed from: fn2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1193a implements fn2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f17563a;

            public C1193a(IBinder iBinder) {
                this.f17563a = iBinder;
            }

            @Override // defpackage.fn2
            public void A() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void E() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17563a;
            }

            @Override // defpackage.fn2
            public ParcelPair h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ParcelPair) b.c(parcelObtain2, ParcelPair.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void i(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f17563a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public boolean isConnected() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void j() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public boolean k(boolean z, boolean z2, SyncKeys syncKeys) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    b.d(parcelObtain, syncKeys, 0);
                    this.f17563a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void l(MessageVo messageVo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    b.d(parcelObtain, messageVo, 0);
                    this.f17563a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void r(MessageVo messageVo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    b.d(parcelObtain, messageVo, 0);
                    this.f17563a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void s(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    parcelObtain.writeString(str);
                    this.f17563a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public boolean w() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    this.f17563a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // defpackage.fn2
            public void x(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                    parcelObtain.writeLong(j);
                    this.f17563a.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.zenmen.palmchat.messaging.IMessagingServiceInterface");
        }

        public static fn2 g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof fn2)) ? new C1193a(iBinder) : (fn2) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.zenmen.palmchat.messaging.IMessagingServiceInterface");
                return true;
            }
            switch (i) {
                case 1:
                    r((MessageVo) b.c(parcel, MessageVo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    s(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    A();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    F(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    l((MessageVo) b.c(parcel, MessageVo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    J();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    q();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    E();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    boolean zIsConnected = isConnected();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsConnected ? 1 : 0);
                    return true;
                case 10:
                    boolean zW = w();
                    parcel2.writeNoException();
                    parcel2.writeInt(zW ? 1 : 0);
                    return true;
                case 11:
                    p();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    j();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    boolean zK = k(parcel.readInt() != 0, parcel.readInt() != 0, (SyncKeys) b.c(parcel, SyncKeys.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zK ? 1 : 0);
                    return true;
                case 14:
                    boolean zO = o(parcel.readInt() != 0, parcel.readInt() != 0, parcel.createStringArrayList());
                    parcel2.writeNoException();
                    parcel2.writeInt(zO ? 1 : 0);
                    return true;
                case 15:
                    i(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    ParcelPair parcelPairH = h();
                    parcel2.writeNoException();
                    b.d(parcel2, parcelPairH, 1);
                    return true;
                case 17:
                    M(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    G();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    n(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    x(parcel.readLong());
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
