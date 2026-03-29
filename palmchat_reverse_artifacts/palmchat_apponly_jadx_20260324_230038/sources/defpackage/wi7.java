package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class wi7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21722a;
    public static File b;
    public static File c;

    public static File A(File file) {
        return new File(c(x97.m(), file.getName()), "logcat.txt");
    }

    public static File B(Context context) {
        return new File(E(context), "apmlite/alogCrash");
    }

    public static File C(File file) {
        return new File(c(x97.m(), file.getName()), "fds.txt");
    }

    public static File D(File file) {
        return new File(c(x97.m(), file.getName()), "threads.txt");
    }

    public static String E(Context context) {
        if (TextUtils.isEmpty(f21722a)) {
            try {
                f21722a = context.getFilesDir().getAbsolutePath();
            } catch (Exception e) {
                f21722a = "/sdcard/";
                e.printStackTrace();
            }
        }
        return f21722a;
    }

    public static File F(Context context) {
        return new File(E(context) + "/apmlite/CustomFile/" + x97.l());
    }

    public static File G(File file) {
        return new File(c(x97.m(), file.getName()), "meminfo.txt");
    }

    public static File H(Context context) {
        return new File(E(context), "apmlite/CustomFile");
    }

    public static File I(File file) {
        return new File(c(x97.m(), file.getName()), "pthreads.txt");
    }

    public static File J(File file) {
        return new File(c(x97.m(), file.getName()), "rountines.txt");
    }

    public static File K(File file) {
        return new File(c(x97.m(), file.getName()), "leakd_threads.txt");
    }

    public static File L(File file) {
        return new File(file, "abortmsg.txt");
    }

    public static File a() {
        File file = b;
        return file == null ? o(x97.m()) : file;
    }

    public static File b(Context context) {
        return new File(E(context), "apmlite/CrashLogJava");
    }

    public static File c(Context context, String str) {
        return new File(E(context) + "/apmlite/CrashCommonLog/" + str);
    }

    public static File d(File file) {
        return new File(file, "flog.txt");
    }

    public static File e(File file, String str) {
        return new File(file, file.getName() + str);
    }

    public static File f(String str) {
        return new File(c(x97.m(), str), "fds.txt");
    }

    public static File g(Context context) {
        return new File(E(context), "apmlite/CrashLogSimple");
    }

    public static File h(Context context, String str) {
        return new File(E(context) + "/apmlite/CustomFile/" + str);
    }

    public static File i(File file) {
        return new File(file, "tombstone.txt");
    }

    public static File j(String str) {
        return new File(c(x97.m(), str), "threads.txt");
    }

    public static String k() {
        return "anr_" + x97.k();
    }

    public static File l(Context context) {
        return new File(E(context), "apmlite/RuntimeContext");
    }

    public static File m(File file) {
        return new File(file, "header.bin");
    }

    public static File n(String str) {
        return new File(c(x97.m(), str), "meminfo.txt");
    }

    public static File o(Context context) {
        if (b == null) {
            if (context == null) {
                context = x97.m();
            }
            b = new File(E(context), "apmlite/CrashLogNative");
        }
        return b;
    }

    public static File p(File file) {
        return new File(c(x97.m(), file.getName()), "maps.txt");
    }

    public static File q(String str) {
        return new File(c(x97.m(), str), "pthreads.txt");
    }

    public static File r(Context context) {
        if (c == null) {
            c = new File(E(context) + "/apmlite/CrashCommonLog/" + x97.l());
        }
        return c;
    }

    public static File s(File file) {
        return new File(file, "callback.json");
    }

    public static File t(String str) {
        return new File(c(x97.m(), str), "rountines.txt");
    }

    public static File u(Context context) {
        return new File(E(context), "apmlite/CrashCommonLog");
    }

    public static File v(File file) {
        return new File(file, "upload.json");
    }

    public static File w(String str) {
        return new File(c(x97.m(), str), "leakd_threads.txt");
    }

    public static File x(Context context) {
        return new File(E(context), "apmlite/issueCrashTimes");
    }

    public static File y(File file) {
        return new File(file, "javastack.txt");
    }

    public static File z(Context context) {
        return new File(E(context) + "/apmlite/issueCrashTimes/current.times");
    }
}
