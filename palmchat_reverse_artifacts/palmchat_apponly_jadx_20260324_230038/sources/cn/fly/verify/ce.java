package cn.fly.verify;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f2142a;
    protected final String b;
    private boolean c = false;
    private boolean d = false;
    private String e = null;
    private int f = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2144a;
        String b;
    }

    public ce(Context context) {
        this.f2142a = context;
        this.b = context.getPackageName();
    }

    private synchronized void f() {
        if (this.c) {
            return;
        }
        if (a(a()) || this.f >= 4) {
            this.c = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #5 {all -> 0x005e, blocks: (B:22:0x0056, B:24:0x005b), top: B:35:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(String str, IBinder iBinder, String str2, int i) throws Throwable {
        Parcel parcelObtain;
        Parcel parcel;
        Parcel parcelObtain2 = null;
        try {
            parcelObtain = Parcel.obtain();
            try {
                parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(str2);
                iBinder.transact(i, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                int i2 = parcelObtain2.readInt();
                try {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable unused) {
                }
                return i2;
            } catch (RemoteException unused2) {
                parcel = parcelObtain2;
                parcelObtain2 = parcelObtain;
                try {
                    en.a().a("getIntValue: " + str + " failed! (remoteException)", new Object[0]);
                    if (parcel != null) {
                        try {
                            parcel.recycle();
                        } catch (Throwable unused3) {
                            return 0;
                        }
                    }
                    if (parcelObtain2 != null) {
                        parcelObtain2.recycle();
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    parcelObtain = parcelObtain2;
                    parcelObtain2 = parcel;
                    if (parcelObtain2 != null) {
                        try {
                            parcelObtain2.recycle();
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    }
                    if (parcelObtain != null) {
                        parcelObtain.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (parcelObtain2 != null) {
                }
                if (parcelObtain != null) {
                }
                throw th;
            }
        } catch (RemoteException unused5) {
            parcel = null;
        } catch (Throwable th3) {
            th = th3;
            parcelObtain = null;
        }
    }

    public b b() {
        return null;
    }

    public long c() {
        return ((((long) (this.f - 1)) * 2) + 2) * 1000;
    }

    public synchronized String d() {
        f();
        return this.e;
    }

    public synchronized boolean e() {
        f();
        return this.d;
    }

    public Intent a() {
        return null;
    }

    private b a(Context context, Intent intent) throws Throwable {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Throwable("unable to invoke in main thread!");
        }
        a aVar = new a();
        try {
            boolean zBindService = Build.VERSION.SDK_INT >= 34 ? context.bindService(intent, aVar, 513) : context.bindService(intent, aVar, 1);
            if (intent == null || !zBindService) {
                StringBuilder sb = new StringBuilder();
                sb.append("bind service ");
                sb.append(intent == null ? com.igexin.push.core.b.m : intent.getComponent());
                sb.append(" failed!");
                throw new Throwable(sb.toString());
            }
            long jC = c();
            en.a().a("wte " + jC, new Object[0]);
            IBinder iBinderA = aVar.a(c());
            if (iBinderA != null) {
                return a(iBinderA);
            }
            throw new Throwable("get binder " + intent.getComponent() + " failed!");
        } finally {
            try {
                context.unbindService(aVar);
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
    }

    public b a(IBinder iBinder) {
        return null;
    }

    public String a(String str, IBinder iBinder, String str2, int i, String... strArr) {
        Parcel parcelObtain;
        Parcel parcelObtain2;
        try {
            parcelObtain = Parcel.obtain();
            try {
                parcelObtain2 = Parcel.obtain();
            } catch (Throwable th) {
                th = th;
                parcelObtain2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            parcelObtain = null;
            parcelObtain2 = null;
        }
        try {
            parcelObtain.writeInterfaceToken(str2);
            if (strArr != null && strArr.length > 0) {
                for (String str3 : strArr) {
                    parcelObtain.writeString(str3);
                }
            }
            iBinder.transact(i, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable unused) {
            }
            return string;
        } catch (Throwable th3) {
            th = th3;
            try {
                en.a().a("getStringValue: " + str + " failed! " + th.getMessage(), new Object[0]);
                if (parcelObtain2 != null) {
                    try {
                        parcelObtain2.recycle();
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                return null;
            } finally {
                if (parcelObtain2 != null) {
                    try {
                        parcelObtain2.recycle();
                    } catch (Throwable unused3) {
                    }
                }
                if (parcelObtain != null) {
                    parcelObtain.recycle();
                }
            }
        }
    }

    public synchronized void a(String str) {
        if (str != null) {
            if (!Pattern.compile("^[0fF\\-]+").matcher(str).matches()) {
                this.e = str;
            }
        }
    }

    private synchronized boolean a(Intent intent) {
        boolean z;
        b bVarB;
        z = true;
        this.f++;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            bVarB = b();
            if (bVarB == null) {
                bVarB = a(this.f2142a, intent);
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
        if (bVarB != null) {
            this.d = bVarB.f2144a;
            this.e = bVarB.b;
        } else {
            z = false;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        en.a().a("oa use time: " + jElapsedRealtime2, new Object[0]);
        return z;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2143a;
        private final BlockingQueue<IBinder> c;

        private a() {
            this.f2143a = false;
            this.c = new LinkedBlockingQueue();
        }

        public IBinder a(long j) throws InterruptedException {
            if (this.f2143a) {
                throw new IllegalStateException();
            }
            this.f2143a = true;
            BlockingQueue<IBinder> blockingQueue = this.c;
            if (j <= 0) {
                j = com.igexin.push.config.c.j;
            }
            return blockingQueue.poll(j, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
