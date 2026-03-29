package cn.fly.verify;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.fly.verify.fq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile IBinder f2343a = null;
    private static int b = 0;
    private static volatile int c = Integer.MIN_VALUE;

    private static int a(Context context) throws Throwable {
        int i = b;
        if (i != 0) {
            return i;
        }
        int iIntValue = ((Integer) ew.a(context).a(ec.b("034cdGcbcidcchcbec4bPdc_dhedhXec=i4ceecdhfk,cbLck-c3dd?eEgb-cdcVdd.e[ci") + "$" + ec.b("004Sdi0h6cfed"), ec.b("026FdjfhdkdgdidkfjdjdhffdgcgddNeh_fk?cb!ck2cRddTe3dh[dNdedc"), (Object) null)).intValue();
        b = iIntValue;
        return iIntValue;
    }

    private static Parcelable.Creator<?> b() throws Throwable {
        return (Parcelable.Creator) fy.c(fy.a(ec.b("030cd5cbcidcchcbecRb*dc^dhedh(ec7iQceecfk=cb2ckNcEdd<e9dhBdFdedc")), ec.b("007%fjfhfgdkdjfffh"));
    }

    private static int c() {
        if (c != Integer.MIN_VALUE) {
            return c;
        }
        try {
            int iIntValue = ((Integer) fy.a(fy.a(ec.b("021cdJcbcidcchcbecdcegecdfeg$eWciei,cd[cb$fe")), ec.b("009'ddFehOdfeg(eDcidhcb"), new Object[]{Integer.valueOf(Process.myUid())}, (Class<?>[]) new Class[]{Integer.TYPE})).intValue();
            c = iIntValue;
            return iIntValue;
        } catch (Throwable th) {
            en.a().a(th);
            return 0;
        }
    }

    private static int a(Context context, String str, String[] strArr, File file, File file2, File file3, HandlerThread handlerThread) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3 = null;
        try {
            IBinder iBinder = (IBinder) ew.a(context).a(ec.b("025cd9cbcidcchcbecdcegecdi$e2ciccch'be]gb;cdcWddEeQci"), (Object) null, ec.b("0105ddDeh?di6eGciccchWbe"), new Class[]{String.class}, new Object[]{str});
            Object objA = ew.a(context).a(ec.b("024cd>cbcidcchcbecdcegecdi0geffMfjVcff(edScb ck"));
            FileOutputStream fileOutputStream4 = new FileOutputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream2 = new FileOutputStream(file3);
                    try {
                        ew.a(context).a(IBinder.class, iBinder, ec.b("0123eg4geff6fjdccece5cd3cb"), new Class[]{FileDescriptor.class, FileDescriptor.class, FileDescriptor.class, String[].class, Class.forName(ec.b("024cd>cbcidcchcbecdcegecdi^geff'fjUcffRedScb6ck")), ResultReceiver.class}, new Object[]{fileOutputStream4.getFD(), fileOutputStream.getFD(), fileOutputStream2.getFD(), strArr, objA, new ResultReceiver(new Handler(handlerThread.getLooper()))});
                        eg.a(fileOutputStream4, fileOutputStream, fileOutputStream2);
                        return 0;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream3 = fileOutputStream4;
                        eg.a(fileOutputStream3, fileOutputStream, fileOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileOutputStream2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileOutputStream2 = null;
        }
    }

    public static Object a(Context context, String str, int i) throws Throwable {
        return a(context, str, i, c(), a(context));
    }

    private static Object a(Context context, String str, int i, int i2, int i3) throws Throwable {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        if (f2343a == null) {
            f2343a = (IBinder) ew.a(context).a(ec.b("025cd5cbcidcchcbecdcegecdiXe0ciccch_be^gb!cdc$dd3e3ci"), (Object) null, ec.b("010Add,ehBdi(eOciccch!be"), new Class[]{String.class}, new Object[]{ec.b("007icb.ckDc7ddLe")});
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(ec.b("034cd_cbcidcchcbec2b+dcMdhedh2ec!i6ceecdhfk-cb?ck c(dd[eQgb%cdc!dd[eYci"));
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            f2343a.transact(i3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readTypedObject(b());
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            ew.a(context).b(context);
        }
    }

    public static Set<String> a(Context context, int i) {
        Set<String> setA;
        HandlerThread handlerThread = new HandlerThread(ek.f2243a + "XPL-1");
        handlerThread.start();
        Set<String> set = null;
        try {
            try {
            } catch (Throwable th) {
                try {
                    en.a().a(th);
                    handlerThread.quitSafely();
                } catch (Throwable th2) {
                    try {
                        handlerThread.quitSafely();
                    } catch (Throwable th3) {
                        en.a().a(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            en.a().a(th4);
        }
        if (i != 1) {
            if (i == 4 && !ec.b("005JceTe1chfbcf").equalsIgnoreCase(er.a(context).d().m()) && a()) {
                setA = a(context, handlerThread);
            }
            handlerThread.quitSafely();
            return set;
        }
        setA = a(context, true, handlerThread);
        set = setA;
        handlerThread.quitSafely();
        return set;
    }

    public static Set<String> a(Context context, HandlerThread handlerThread) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        if (Cdo.b()) {
            File file = new File(context.getFilesDir(), ".tmp11");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ec.b("002GchQd") + System.currentTimeMillis());
            File file3 = new File(file, "out" + System.currentTimeMillis());
            File file4 = new File(file, NotificationCompat.CATEGORY_ERROR + System.currentTimeMillis());
            if (file3.exists()) {
                file3.delete();
            }
            try {
                a(context, ec.b("007icbXckZcVdd6e"), new String[]{ec.b("004fAcheg=h"), "packages"}, file2, file3, file4, handlerThread);
                if (!file3.exists() || file3.length() <= 0) {
                    eg.a(null, null, null);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                } else {
                    HashSet hashSet = new HashSet();
                    fileInputStream = new FileInputStream(file3);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                String strB = ec.b("008icbJckAc4dd2ej");
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    String strTrim = line.trim();
                                    if (strTrim.length() > strB.length() && strTrim.substring(0, strB.length()).equalsIgnoreCase(strB)) {
                                        String strTrim2 = strTrim.substring(strB.length()).trim();
                                        if (!TextUtils.isEmpty(strTrim2)) {
                                            hashSet.add(strTrim2);
                                        }
                                    }
                                }
                                eg.a(bufferedReader2, inputStreamReader, fileInputStream);
                                file2.delete();
                                file3.delete();
                                file4.delete();
                                return hashSet;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                inputStreamReader = null;
            }
            eg.a(bufferedReader, inputStreamReader, fileInputStream);
            file2.delete();
            file3.delete();
            file4.delete();
            throw th;
        }
        return null;
    }

    public static Set<String> a(Context context, boolean z, HandlerThread handlerThread) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        if (Cdo.b()) {
            File file = new File(context.getFilesDir(), ".tmp11");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ec.b("002+chEd") + System.currentTimeMillis());
            File file3 = new File(file, "out" + System.currentTimeMillis());
            File file4 = new File(file, NotificationCompat.CATEGORY_ERROR + System.currentTimeMillis());
            if (file3.exists()) {
                file3.delete();
            }
            try {
                if (z) {
                    a(context, ec.b("007icbGckXcPdd7e"), new String[]{ec.b("016YcdcfBeVcicjgjWcbh%chccch*hOch:e?eg"), "-a", ec.b("026cd?cbcidcchcbecch4dhedh6ec cbh[chdc2dXecgbdkdhdg"), "--user", "0"}, file2, file3, file4, handlerThread);
                } else {
                    a(context, ec.b("007icbPckRc7dd4e"), new String[]{ec.b("016WcdcfJe.cicjgj)cbhZchccch3h-chMeDeg"), "-a", ec.b("026cd6cbcidcchcbecch*dhedh ecBcbh!chdcXdQecgbdkdhdg"), "-c", ec.b("032cd=cbcidcchcbecch6dhedh*ec3bche>dddccicjecebdkdfdgfjeifgfh"), "--user", "0"}, file2, file3, file4, handlerThread);
                }
                if (!file3.exists() || file3.length() <= 0) {
                    eg.a(null, null, null);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                } else {
                    HashSet hashSet = new HashSet();
                    fileInputStream = new FileInputStream(file3);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                String strB = ec.b("012icbVckZc:dd(eYdgZc[ceYe(hh");
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    String strTrim = line.trim();
                                    if (strTrim.length() > strB.length() && strTrim.substring(0, strB.length()).equalsIgnoreCase(strB)) {
                                        String strTrim2 = strTrim.substring(strB.length()).trim();
                                        if (!TextUtils.isEmpty(strTrim2)) {
                                            hashSet.add(strTrim2);
                                        }
                                    }
                                }
                                eg.a(bufferedReader2, inputStreamReader, fileInputStream);
                                file2.delete();
                                file3.delete();
                                file4.delete();
                                return hashSet;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                inputStreamReader = null;
            }
            eg.a(bufferedReader, inputStreamReader, fileInputStream);
            file2.delete();
            file3.delete();
            file4.delete();
            throw th;
        }
        return null;
    }

    public static boolean a() {
        try {
            if (ec.b("006gPcfNc>eeQe$ch").equalsIgnoreCase(fq.d.k())) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final int[] iArr = new int[1];
                fq.a(ax.g()).D().a(new fq.a() { // from class: cn.fly.verify.ez.1
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar) {
                        String strC = bVar.C();
                        if (strC == null) {
                            strC = "";
                        }
                        iArr[0] = "3.0.0.200".compareTo(strC);
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
                return iArr[0] > 0;
            }
            return true;
        } catch (Throwable th) {
            en.a().a(th);
            return true;
        }
    }
}
