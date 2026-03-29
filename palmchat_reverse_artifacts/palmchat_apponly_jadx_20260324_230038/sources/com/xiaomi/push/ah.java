package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class ah implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f100a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile String f104a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private volatile boolean f105b = false;
    private volatile String b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f103a = new Object();

    public ah(Context context) {
        this.f101a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f102a;
        if (serviceConnection != null) {
            try {
                this.f101a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo161a() {
        return f11407a;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo160a() {
        a("getOAID");
        return this.f104a;
    }

    private void a() {
        boolean zBindService;
        this.f102a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            zBindService = this.f101a.bindService(intent, this.f102a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f100a = zBindService ? 1 : 2;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public static String a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public static boolean m162a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    private void a(String str) {
        if (this.f100a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f103a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m74a("huawei's " + str + " wait...");
                this.f103a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            f11407a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() { // from class: com.xiaomi.push.ah.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ah.this.f104a = b.a(iBinder);
                        ah.this.f105b = b.m162a(iBinder);
                        ah.this.b();
                        ah.this.f100a = 2;
                        synchronized (ah.this.f103a) {
                            try {
                                ah.this.f103a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ah.this.b();
                        ah.this.f100a = 2;
                        synchronized (ah.this.f103a) {
                            try {
                                ah.this.f103a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ah.this.b();
                        ah.this.f100a = 2;
                        synchronized (ah.this.f103a) {
                            try {
                                ah.this.f103a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
