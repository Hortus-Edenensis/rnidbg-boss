package defpackage;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.daemon.doubleprocess.c;
import com.lantern.daemon.doubleprocess.nativ.NativeDaemonAPI21;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class rt0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f20562a;
    public Parcel b;
    public com.lantern.daemon.doubleprocess.b c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20563a;

        public a(Context context) {
            this.f20563a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            File dir = this.f20563a.getDir("indicators", 0);
            new NativeDaemonAPI21(this.f20563a).doDaemon(new File(dir, "indicator_p").getAbsolutePath(), new File(dir, "indicator_d").getAbsolutePath(), new File(dir, "observer_p").getAbsolutePath(), new File(dir, "observer_d").getAbsolutePath());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20564a;

        public b(Context context) {
            this.f20564a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            File dir = this.f20564a.getDir("indicators", 0);
            new NativeDaemonAPI21(this.f20564a).doDaemon(new File(dir, "indicator_d").getAbsolutePath(), new File(dir, "indicator_p").getAbsolutePath(), new File(dir, "observer_d").getAbsolutePath(), new File(dir, "observer_p").getAbsolutePath());
        }
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void a(Context context, com.lantern.daemon.doubleprocess.b bVar) {
        f();
        h(context, bVar.f7534a.b);
        i();
        new b(context).start();
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void b(Context context, com.lantern.daemon.doubleprocess.b bVar) {
        f();
        h(context, bVar.b.b);
        i();
        new a(context).start();
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public boolean c(Context context) {
        return g(context);
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void d() {
        if (i()) {
            com.lantern.daemon.doubleprocess.b bVar = this.c;
            if (bVar != null) {
                bVar.getClass();
            }
            Process.killProcess(Process.myPid());
        }
    }

    public final void e(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.exists()) {
            return;
        }
        file2.createNewFile();
    }

    public final void f() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object objInvoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField("mRemote");
            declaredField.setAccessible(true);
            this.f20562a = (IBinder) declaredField.get(objInvoke);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
    }

    public final boolean g(Context context) {
        File dir = context.getDir("indicators", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            e(dir, "indicator_p");
            e(dir, "indicator_d");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"Recycle"})
    public final void h(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra(az.at, "persistent");
        intent.setComponent(new ComponentName(context.getPackageName(), str));
        Parcel parcelObtain = Parcel.obtain();
        this.b = parcelObtain;
        parcelObtain.writeInterfaceToken("android.app.IActivityManager");
        this.b.writeStrongBinder(null);
        intent.writeToParcel(this.b, 0);
        this.b.writeString(null);
        this.b.writeInt(0);
    }

    public final boolean i() {
        Parcel parcel;
        try {
            IBinder iBinder = this.f20562a;
            if (iBinder != null && (parcel = this.b) != null) {
                iBinder.transact(34, parcel, null, 0);
                return true;
            }
            Log.e("Daemon", "REMOTE IS NULL or PARCEL IS NULL !!!");
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
