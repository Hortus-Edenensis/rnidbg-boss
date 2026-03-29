package a.a.c.a.a;

import a.a.c.a.a.e;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f1094a = 0;

        /* JADX INFO: renamed from: a.a.c.a.a.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0009a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1095a;

            public C0009a(IBinder iBinder) {
                this.f1095a = iBinder;
            }

            @Override // a.a.c.a.a.f
            public void a(e eVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(eVar != null ? (e.a) eVar : null);
                    if (!this.f1095a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f1094a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1095a;
            }

            @Override // a.a.c.a.a.f
            public void b(e eVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(eVar != null ? (e.a) eVar : null);
                    if (!this.f1095a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f1094a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    void a(e eVar);

    void b(e eVar);
}
