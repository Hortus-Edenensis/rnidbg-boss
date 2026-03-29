package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.oplus.tblplayer.Constants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class st3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f20842a = new AtomicBoolean(false);

    public static File a(Context context) {
        File file;
        if (context != null) {
            try {
                file = new File((String) ApplicationInfo.class.getField("nativeLibraryDir").get(context.getApplicationInfo()));
            } catch (Throwable th) {
                th.printStackTrace();
                file = null;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File(context.getApplicationInfo().dataDir, Constants.LIBRARY_PREFIX);
        }
        if (file.isDirectory()) {
            return file;
        }
        return null;
    }

    public static void b(Context context) {
        c(context, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0139 A[Catch: all -> 0x0151, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:11:0x0036, B:13:0x003e, B:15:0x0040, B:49:0x00dc, B:56:0x0112, B:62:0x0139, B:65:0x013e, B:69:0x014f, B:68:0x014a, B:64:0x013b, B:17:0x0048, B:38:0x00a6, B:40:0x00ae, B:43:0x00b8, B:45:0x00be, B:47:0x00cb, B:48:0x00d2, B:52:0x00df, B:53:0x00e4, B:55:0x00ff, B:60:0x011d, B:59:0x0115, B:20:0x0055, B:23:0x0060, B:26:0x006b, B:29:0x0076, B:32:0x0081, B:37:0x009f), top: B:74:0x0036, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, boolean z) {
        String str;
        File fileA;
        File file;
        File file2;
        boolean zIsPrivacyAgreeBeforInit = AppContext.getContext().isPrivacyAgreeBeforInit();
        Log.i("LXNativeLoader", "initNativeLibs " + zIsPrivacyAgreeBeforInit);
        if ((zIsPrivacyAgreeBeforInit || z) && !f20842a.get()) {
            Log.i("LXNativeLoader", "initNativeLibs  start");
            synchronized (f20842a) {
                if (f20842a.get()) {
                    return;
                }
                Log.i("LXNativeLoader", "initNativeLibs loadLibrary!!!!");
                try {
                    try {
                        String str2 = Build.CPU_ABI;
                        if (str2.equalsIgnoreCase("armeabi-v7a")) {
                            str = "armeabi-v7a";
                        } else if (str2.equalsIgnoreCase("armeabi")) {
                            str = "armeabi";
                        } else if (str2.equalsIgnoreCase("x86")) {
                            str = "x86";
                        } else if (str2.equalsIgnoreCase("mips")) {
                            str = "mips";
                        } else if (str2.equalsIgnoreCase("arm64-v8a")) {
                            str = "arm64-v8a";
                        } else {
                            LogUtil.e("LXNativeLoader", "Unsupported arch: " + str2, 1);
                            str = "armeabi";
                        }
                    } catch (Exception e) {
                        LogUtil.e("LXNativeLoader", e, 1);
                        str = "armeabi";
                    }
                    String property = System.getProperty("os.arch");
                    if (property != null && property.contains("686")) {
                        str = "x86";
                    }
                    fileA = a(context);
                } catch (Throwable th) {
                    th.printStackTrace();
                    try {
                        System.loadLibrary("zhangxin.2");
                        f20842a.set(true);
                    } catch (Error e2) {
                        LogUtil.e("LXNativeLoader", e2, 1);
                    }
                    return;
                }
                if (fileA != null && new File(fileA, "libzhangxin.2.so").exists()) {
                    Log.d("LXNativeLoader", "Load normal lib");
                    try {
                        System.loadLibrary("zhangxin.2");
                        f20842a.set(true);
                        return;
                    } catch (Error e3) {
                        LogUtil.e("LXNativeLoader", e3, 1);
                        file = new File(context.getFilesDir(), Constants.LIBRARY_PREFIX);
                        file.mkdirs();
                        file2 = new File(file, "libzhangxin.2loc.so");
                        if (file2.exists()) {
                        }
                        Log.e("LXNativeLoader", "Library not found, arch = " + str);
                        if (d(context, file, file2, str)) {
                        }
                        System.loadLibrary("zhangxin.2");
                        f20842a.set(true);
                        return;
                    }
                }
                file = new File(context.getFilesDir(), Constants.LIBRARY_PREFIX);
                file.mkdirs();
                file2 = new File(file, "libzhangxin.2loc.so");
                if (file2.exists()) {
                    try {
                        Log.d("LXNativeLoader", "Load local lib");
                        System.load(file2.getAbsolutePath());
                        f20842a.set(true);
                        return;
                    } catch (Error e4) {
                        LogUtil.e("LXNativeLoader", e4, 1);
                        file2.delete();
                        Log.e("LXNativeLoader", "Library not found, arch = " + str);
                        if (d(context, file, file2, str)) {
                        }
                        System.loadLibrary("zhangxin.2");
                        f20842a.set(true);
                        return;
                    }
                }
                Log.e("LXNativeLoader", "Library not found, arch = " + str);
                if (d(context, file, file2, str)) {
                    return;
                }
                System.loadLibrary("zhangxin.2");
                f20842a.set(true);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public static boolean d(Context context, File file, File file2, String str) throws Throwable {
        ?? zipFile;
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        try {
            for (File file3 : file.listFiles()) {
                file3.delete();
            }
        } catch (Exception e2) {
            LogUtil.e("LXNativeLoader", e2);
        }
        try {
            try {
                zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                try {
                    ZipEntry entry = zipFile.getEntry("lib/" + ((String) str) + "/libzhangxin.2.so");
                    if (entry == null) {
                        throw new Exception("Unable to find file in apk:lib/" + ((String) str) + "/zhangxin.2");
                    }
                    context = zipFile.getInputStream(entry);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = context.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                Thread.yield();
                                fileOutputStream.write(bArr, 0, i);
                            }
                            file2.setReadable(true, false);
                            file2.setExecutable(true, false);
                            file2.setWritable(true);
                            try {
                                System.load(file2.getAbsolutePath());
                                f20842a.set(true);
                            } catch (Error e3) {
                                LogUtil.e("LXNativeLoader", e3);
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                LogUtil.e("LXNativeLoader", e4);
                            }
                            try {
                                context.close();
                            } catch (Exception e5) {
                                LogUtil.e("LXNativeLoader", e5);
                            }
                            try {
                                zipFile.close();
                            } catch (Exception e6) {
                                LogUtil.e("LXNativeLoader", e6);
                            }
                            return true;
                        } catch (Exception e7) {
                            e = e7;
                            LogUtil.e("LXNativeLoader", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e8) {
                                    LogUtil.e("LXNativeLoader", e8);
                                }
                            }
                            if (context != 0) {
                                try {
                                    context.close();
                                } catch (Exception e9) {
                                    LogUtil.e("LXNativeLoader", e9);
                                }
                            }
                            if (zipFile != 0) {
                                try {
                                    zipFile.close();
                                } catch (Exception e10) {
                                    LogUtil.e("LXNativeLoader", e10);
                                }
                            }
                            return false;
                        }
                    } catch (Exception e11) {
                        fileOutputStream = null;
                        e = e11;
                    } catch (Throwable th2) {
                        str = 0;
                        th = th2;
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (Exception e12) {
                                LogUtil.e("LXNativeLoader", e12);
                            }
                        }
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (Exception e13) {
                                LogUtil.e("LXNativeLoader", e13);
                            }
                        }
                        if (zipFile == 0) {
                            throw th;
                        }
                        try {
                            zipFile.close();
                            throw th;
                        } catch (Exception e14) {
                            LogUtil.e("LXNativeLoader", e14);
                            throw th;
                        }
                    }
                } catch (Exception e15) {
                    fileOutputStream = null;
                    e = e15;
                    context = 0;
                } catch (Throwable th3) {
                    str = 0;
                    th = th3;
                    context = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e16) {
            fileOutputStream = null;
            zipFile = 0;
            e = e16;
            context = 0;
        } catch (Throwable th5) {
            str = 0;
            zipFile = 0;
            th = th5;
            context = 0;
        }
    }

    public static void e(boolean z) {
        boolean zIsPrivacyAgreeBeforInit = AppContext.getContext().isPrivacyAgreeBeforInit();
        Log.i("LXNativeLoader", "tryLoadNativeLibs " + zIsPrivacyAgreeBeforInit + " checkPrivacy=" + z);
        if ((zIsPrivacyAgreeBeforInit || !z) && !f20842a.get()) {
            Log.i("LXNativeLoader", "tryLoadNativeLibs enter");
            synchronized (f20842a) {
                if (f20842a.get()) {
                    return;
                }
                Log.i("LXNativeLoader", "tryLoadNativeLibs loadLibrary!!!!");
                try {
                    System.loadLibrary("zhangxin.2");
                    f20842a.set(true);
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
