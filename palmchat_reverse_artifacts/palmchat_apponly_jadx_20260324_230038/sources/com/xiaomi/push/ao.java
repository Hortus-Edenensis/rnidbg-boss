package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class ao implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f125a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f128a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f129a = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f130a;
        String b;
        String c;
        String d;

        private a() {
            this.f130a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public ao(Context context) {
        this.f126a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m167b() {
        ServiceConnection serviceConnection = this.f127a;
        if (serviceConnection != null) {
            try {
                this.f126a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f126a.getPackageManager().getPackageInfo(this.f126a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo161a() {
        return f11416a;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo160a() {
        a("getOAID");
        if (this.f128a == null) {
            return null;
        }
        return this.f128a.b;
    }

    private void a() {
        boolean zBindService;
        this.f127a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            zBindService = this.f126a.bindService(intent, this.f127a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f125a = zBindService ? 1 : 2;
    }

    private void a(String str) {
        if (this.f125a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f129a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m74a("oppo's " + str + " wait...");
                this.f129a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    longVersionCode = packageInfo.getLongVersionCode();
                } else {
                    longVersionCode = packageInfo.versionCode;
                }
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f11416a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (ao.this.f128a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.ao.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = ao.this.f126a.getPackageName();
                        String strB = ao.this.b();
                        a aVar = new a();
                        aVar.b = c.a(iBinder, packageName, strB, "OUID");
                        ao.this.f128a = aVar;
                        ao.this.m167b();
                        ao.this.f125a = 2;
                        synchronized (ao.this.f129a) {
                            try {
                                ao.this.f129a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ao.this.m167b();
                        ao.this.f125a = 2;
                        synchronized (ao.this.f129a) {
                            try {
                                ao.this.f129a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ao.this.m167b();
                        ao.this.f125a = 2;
                        synchronized (ao.this.f129a) {
                            try {
                                ao.this.f129a.notifyAll();
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
