package com.tencent.turingfd.sdk.ams.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.protected, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cprotected {

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.protected$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10768a;
        public final boolean b;

        public Cdo(String str, boolean z) {
            this.f10768a = str;
            this.b = z;
        }
    }

    public static Cdo a() {
        Context context;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Cif cif = new Cif();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, cif, 1)) {
                try {
                    IBinder iBinderA = cif.a();
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        iBinderA.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        parcelObtain = Parcel.obtain();
                        parcelObtain2 = Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            parcelObtain.writeInt(1);
                            iBinderA.transact(2, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                            boolean z = parcelObtain2.readInt() != 0;
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return new Cdo(string, z);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                } finally {
                    context.unbindService(cif);
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.protected$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class Cif implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10769a = false;
        public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

        public IBinder a() throws InterruptedException {
            if (this.f10769a) {
                throw new IllegalStateException();
            }
            this.f10769a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
