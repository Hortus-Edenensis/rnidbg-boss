package com.bun.miitmdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface y extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements y {

        /* JADX INFO: renamed from: com.bun.miitmdid.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0150a implements y {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static y f4938a;
            public IBinder b;

            public C0150a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bun.miitmdid.y
            public native boolean a();

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.bun.miitmdid.y
            public native String getAAID();

            @Override // com.bun.miitmdid.y
            public native String getOAID();

            @Override // com.bun.miitmdid.y
            public native String getVAID();

            @Override // com.bun.miitmdid.y
            public native boolean isSupported();
        }

        public static native y a(IBinder iBinder);

        public static native y b();
    }

    boolean a();

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isSupported();
}
