package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.dynamicloader.b;
import com.huawei.openalliance.ad.utils.u;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20095a;
    public static boolean b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20096a;

        public a(int i) {
            this.f20096a = i;
            put("action", "getExternalAppDirException");
            put("status", Integer.valueOf(i));
        }
    }

    static {
        String strA = eb4.a();
        f20095a = strA;
        b = false;
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(strA);
        String string = sb.toString();
        c = string;
        d = null;
        e = string;
        f = e + str + "image";
        g = e + str + "audio";
        h = e + str + "file";
        i = "";
        j = e + str + "camera";
        k = e + str + "emoji";
        l = e + str + "video";
        m = e + str + "backup_db/";
        n = e + str + "upload";
        o = e + str + "ad";
        p = e + str + "smallvideo";
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
    }

    public static String a(String str) {
        if (str == null || !str.startsWith("/")) {
            return str;
        }
        return "file://" + str;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static File c(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    public static File d(Context context) {
        File fileK = k(context, true);
        File file = new File(fileK, "glide-images");
        return (file.exists() || file.mkdir()) ? file : fileK;
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new File(str).delete();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0064 A[Catch: Exception -> 0x0060, TryCatch #0 {Exception -> 0x0060, blocks: (B:36:0x005c, B:40:0x0064, B:42:0x0069, B:44:0x006e), top: B:63:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0069 A[Catch: Exception -> 0x0060, TryCatch #0 {Exception -> 0x0060, blocks: (B:36:0x005c, B:40:0x0064, B:42:0x0069, B:44:0x006e), top: B:63:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e A[Catch: Exception -> 0x0060, TRY_LEAVE, TryCatch #0 {Exception -> 0x0060, blocks: (B:36:0x005c, B:40:0x0064, B:42:0x0069, B:44:0x006e), top: B:63:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0082 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:51:0x007a, B:55:0x0082, B:57:0x0087, B:59:0x008c), top: B:65:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0087 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:51:0x007a, B:55:0x0082, B:57:0x0087, B:59:0x008c), top: B:65:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008c A[Catch: Exception -> 0x007e, TRY_LEAVE, TryCatch #3 {Exception -> 0x007e, blocks: (B:51:0x007a, B:55:0x0082, B:57:0x0087, B:59:0x008c), top: B:65:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileChannel channel;
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        channel = null;
        FileChannel channel2 = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                channel = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                channel = null;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            channel = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            channel = null;
        }
        try {
            channel = fileInputStream.getChannel();
            try {
                channel2 = fileOutputStream.getChannel();
                channel.transferTo(0L, channel.size(), channel2);
                try {
                    fileInputStream.close();
                    channel.close();
                    fileOutputStream.close();
                    if (channel2 != null) {
                        channel2.close();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return true;
            } catch (IOException e5) {
                e = e5;
                fileChannel = channel2;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = channel2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                if (channel != null) {
                }
                if (fileOutputStream != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            channel = null;
            fileInputStream2 = fileInputStream;
            fileChannel = channel;
            e.printStackTrace();
            if (fileInputStream2 != null) {
            }
            if (channel != null) {
            }
            if (fileOutputStream != null) {
            }
            if (fileChannel != null) {
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            channel = null;
            fileInputStream2 = fileInputStream;
            fileChannel = channel;
            if (fileInputStream2 != null) {
            }
            if (channel != null) {
            }
            if (fileOutputStream != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.length() > 0 ? 1 : 0;
        }
        return -1;
    }

    public static String h() {
        int i2;
        String absolutePath;
        String externalStorageState = "";
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception | IncompatibleClassChangeError | NullPointerException unused) {
        }
        if ("mounted".equals(externalStorageState)) {
            File externalFilesDir = c.b().getExternalFilesDir(f20095a);
            if (externalFilesDir == null) {
                absolutePath = null;
                i2 = -1;
            } else {
                absolutePath = externalFilesDir.getAbsolutePath();
                i2 = 0;
            }
        } else {
            i2 = -2;
            absolutePath = null;
        }
        if (absolutePath != null) {
            return absolutePath;
        }
        String absolutePath2 = new File(c.b().getFilesDir(), f20095a).getAbsolutePath();
        LogUtil.i(u.Code, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(i2), (Throwable) null);
        return absolutePath2;
    }

    public static String i(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public static String j() {
        String strH = h();
        StringBuilder sb = new StringBuilder();
        sb.append(strH);
        String str = File.separator;
        sb.append(str);
        sb.append("crop");
        File file = new File(sb.toString());
        file.mkdirs();
        return file.getAbsolutePath() + str + ir5.b() + ".jpg";
    }

    public static File k(Context context, boolean z) {
        File cacheDir;
        String externalStorageState = "";
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException | RuntimeException unused) {
        }
        if (z && "mounted".equals(externalStorageState)) {
            cacheDir = new File(new File(new File(d), "data"), "cache");
            if (!cacheDir.exists() && !cacheDir.mkdirs()) {
                Log.w("ImageCacheDirectory", "Unable to create external cache directory");
            }
        } else {
            cacheDir = null;
        }
        if (cacheDir == null) {
            cacheDir = context.getCacheDir();
        }
        if (cacheDir != null) {
            return cacheDir;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        Log.i("ImageCacheDirectory", "Can't define system cache directory! '%s' will be used." + str);
        return new File(str);
    }

    public static File l(Context context) {
        return new File(context.getCacheDir(), "camera");
    }

    public static String m() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + f20095a;
    }

    public static String n() {
        String strH = h();
        if (Build.VERSION.SDK_INT >= 30 && Build.MANUFACTURER.toLowerCase().equalsIgnoreCase("vivo")) {
            strH = c.b().getCacheDir().getAbsolutePath();
        }
        File file = new File(strH + File.separator + "update");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    public static String o(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            tg4.b(context, g.j);
        }
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("sysCamera");
        File file = new File(sb.toString());
        file.mkdirs();
        return file.getAbsolutePath() + str + ir5.b() + ".jpg";
    }

    public static String p(String str) {
        return q() + str + ".apk.temp";
    }

    public static String q() {
        return n() + File.separator;
    }

    public static String r(String str) {
        return q() + str + b.b;
    }

    public static void s() {
        String strH = h();
        e = strH;
        if (strH == null) {
            strH = c;
        }
        d = strH;
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        String str = File.separator;
        sb.append(str);
        sb.append("log");
        i = sb.toString();
        f = d + str + "image";
        g = d + str + "audio";
        h = e + str + "file";
        j = d + str + "camera";
        k = e + str + "emoji";
        l = d + str + "video";
        m = d + str + "backup_db/";
        n = d + str + "upload";
        r = d + str + "ad_video";
        s = d + str + "open_screen";
        t = d + str + "room_music";
        u = d + str + "share";
        q = d + str + "gift_animation";
        File file = new File(d);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        File file2 = new File(g);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(i);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        File file4 = new File(l);
        if (!file4.exists()) {
            file4.mkdirs();
        }
        File file5 = new File(r);
        if (!file5.exists()) {
            file5.mkdirs();
        }
        File file6 = new File(s);
        if (!file6.exists()) {
            file6.mkdirs();
        }
        File file7 = new File(t);
        if (!file7.exists()) {
            file7.mkdirs();
        }
        File file8 = new File(u);
        if (!file8.exists()) {
            file8.mkdirs();
        }
        File file9 = new File(q);
        if (!file9.exists()) {
            file9.mkdirs();
        }
        File file10 = new File(k);
        if (!file10.exists()) {
            file10.mkdirs();
        }
        b = true;
    }

    public static void t() {
        File file = new File(e);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
