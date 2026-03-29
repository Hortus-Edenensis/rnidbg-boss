package defpackage;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.daemon.doubleprocess.b;
import com.lantern.daemon.doubleprocess.c;
import com.lantern.daemon.doubleprocess.nativ.NativeDaemonAPI20;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ut0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21284a = "bin";
    public final String b = "daemon";
    public IBinder c;
    public Parcel d;
    public b e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21285a;
        public final /* synthetic */ b b;

        public a(Context context, b bVar) {
            this.f21285a = context;
            this.b = bVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            new NativeDaemonAPI20(this.f21285a).doDaemon(this.f21285a.getPackageName(), this.b.b.b, new File(this.f21285a.getDir("bin", 0), "daemon").getAbsolutePath());
        }
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.putExtra(az.at, "persistent");
        intent.setComponent(new ComponentName(context.getPackageName(), bVar.f7534a.b));
        context.startService(intent);
        Process.killProcess(Process.myPid());
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void b(Context context, b bVar) {
        g();
        h(context, bVar.b.b);
        a aVar = new a(context, bVar);
        aVar.setPriority(10);
        aVar.start();
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public boolean c(Context context) {
        return j(context);
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void d() {
        if (k()) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.getClass();
            }
            Process.killProcess(Process.myPid());
        }
    }

    public final void e(Context context, String str, File file, String str2) throws InterruptedException, IOException {
        f(file, context.getAssets().open(str), str2);
    }

    public final void f(File file, InputStream inputStream, String str) throws InterruptedException, IOException {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                fileOutputStream.close();
                inputStream.close();
                Runtime.getRuntime().exec("chmod " + str + " " + absolutePath).waitFor();
                return;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    public final void g() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object objInvoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField("mRemote");
            declaredField.setAccessible(true);
            this.c = (IBinder) declaredField.get(objInvoke);
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

    @SuppressLint({"Recycle"})
    public final void h(Context context, String str) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), str));
        Parcel parcelObtain = Parcel.obtain();
        this.d = parcelObtain;
        parcelObtain.writeInterfaceToken("android.app.IActivityManager");
        this.d.writeStrongBinder(null);
        intent.writeToParcel(this.d, 0);
        this.d.writeString(null);
        this.d.writeInt(0);
    }

    public final boolean i(Context context, String str, String str2, String str3) {
        String str4;
        File file = new File(context.getDir(str, 0), str3);
        if (file.exists()) {
            return true;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
            } else {
                str4 = str2 + File.separator;
            }
            sb.append(str4);
            sb.append(str3);
            e(context, sb.toString(), file, "700");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean j(Context context) {
        return i(context, "bin", null, "daemon");
    }

    public final boolean k() {
        Parcel parcel;
        try {
            IBinder iBinder = this.c;
            if (iBinder != null && (parcel = this.d) != null) {
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
