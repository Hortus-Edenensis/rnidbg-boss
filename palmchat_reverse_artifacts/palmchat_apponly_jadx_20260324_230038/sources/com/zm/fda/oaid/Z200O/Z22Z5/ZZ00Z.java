package com.zm.fda.oaid.Z200O.Z22Z5;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {
    public static final int b = 8;
    public static final int c = 9;
    public static int d = 2;
    public static int e = 3;
    public static int f = 4;
    public static int g = 5;
    public static int h = 6;
    public static int i = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f16711a;

    /* JADX INFO: renamed from: com.zm.fda.oaid.Z200O.Z22Z5.ZZ00Z$ZZ00Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C1174ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ZZ00Z f16712a = new ZZ00Z();
    }

    public static ZZ00Z a() {
        return C1174ZZ00Z.f16712a;
    }

    public String b() {
        if (this.f16711a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f16711a.transact(f, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public boolean c() {
        if (this.f16711a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.f16711a.transact(9, parcelObtain, parcelObtain2, 0);
                return Build.VERSION.SDK_INT >= 29 ? parcelObtain2.readBoolean() : false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    public boolean d() {
        if (this.f16711a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.f16711a.transact(d, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readInt() == 1;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    public ZZ00Z() {
        Method declaredMethod;
        this.f16711a = null;
        try {
            Class<?> cls = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("YW5kcm9pZC5vcy5TeXN0ZW1Qcm9wZXJ0aWVz"));
            String str = (String) cls.getMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0"), String.class, String.class).invoke(cls, com.zm.fda.oaid.Z2500.OO22Z.a("cm8uYnVpbGQudWl2ZXJzaW9u"), "");
            if (str == null || !str.contains(com.zm.fda.oaid.Z2500.OO22Z.a("MzYwVUk=")) || (declaredMethod = Class.forName(com.zm.fda.oaid.Z2500.OO22Z.a("YW5kcm9pZC5vcy5TZXJ2aWNlTWFuYWdlcg==")).getDeclaredMethod(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0U2VydmljZQ=="), String.class)) == null) {
                return;
            }
            this.f16711a = (IBinder) declaredMethod.invoke(null, com.zm.fda.oaid.Z2500.OO22Z.a("cWlrdWlk"));
        } catch (Throwable th) {
            Log.e("QikuOaidManager", "Failure get qikuid service", th);
        }
    }
}
