package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hv1 {
    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                b(file2);
                file2.delete();
            }
        }
        file.delete();
    }

    public static void c(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                    k63.a("FileUtils", "delete File:" + file.getPath());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static File d(File[] fileArr) {
        File file = null;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                if (file2.lastModified() > (file != null ? file.lastModified() : 0L)) {
                    file = file2;
                }
            }
        }
        return file;
    }

    public static File e(Context context, String str) {
        File filesDir;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            return new File(filesDir, str);
        }
        k63.l("FileUtils", "can't get file :" + str);
        return null;
    }

    public static File[] f(File file, FileFilter... fileFilterArr) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        if (fileFilterArr == null || fileFilterArr.length == 0 || (fileFilterArr.length == 1 && fileFilterArr[0] == null)) {
            return file.listFiles();
        }
        if (fileFilterArr.length == 1) {
            return file.listFiles(fileFilterArr[0]);
        }
        LinkedList<File> linkedList = new LinkedList();
        linkedList.add(file);
        int length = fileFilterArr.length;
        int i = 0;
        while (i < length) {
            FileFilter fileFilter = fileFilterArr[i];
            LinkedList linkedList2 = new LinkedList();
            for (File file2 : linkedList) {
                File[] fileArrListFiles = fileFilter != null ? file2.listFiles(fileFilter) : file2.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    Collections.addAll(linkedList2, fileArrListFiles);
                }
            }
            if (linkedList2.isEmpty()) {
                return null;
            }
            i++;
            linkedList = linkedList2;
        }
        return (File[]) linkedList.toArray(new File[0]);
    }

    public static File[] g(String str, FileFilter... fileFilterArr) {
        try {
            return f(new File(str), fileFilterArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] h(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                return z86.g(fileInputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    k63.a("FileUtils", "can't read, give up read. e:" + th);
                    return null;
                } finally {
                    z86.b(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String i(File file) {
        byte[] bArrH = h(file);
        if (bArrH == null) {
            return null;
        }
        try {
            return new String(bArrH, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            k63.a("FileUtils", "can't encoding, give up read :" + e);
            return null;
        }
    }

    public static boolean j(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = str.getBytes("UTF-8");
            } catch (Throwable th) {
                k63.l("FileUtils", "getBytes exception:" + th);
                return false;
            }
        } else {
            bytes = null;
        }
        return k(file, bytes);
    }

    public static boolean k(File file, byte[] bArr) {
        if (file == null || file.isDirectory()) {
            k63.l("FileUtils", "file should not be null or a directory");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th) {
                th = th;
                try {
                    k63.l("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                    return false;
                } finally {
                    z86.b(fileOutputStream);
                }
            }
        }
        a(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            fileOutputStream2.write(bArr);
            z86.b(fileOutputStream2);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
            k63.l("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements FileFilter {
        public static final a e = new a(true, false);
        public static final a f = new a(false, true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18059a;
        public final boolean b;
        public final String c;
        public final int d;

        public a(boolean z, boolean z2, String str, int i) {
            this.c = str;
            this.d = i;
            this.f18059a = z;
            this.b = z2;
        }

        public static a a(String str) {
            return new a(false, true, str, 3);
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (this.f18059a && !file.isFile()) {
                return false;
            }
            if (this.b && !file.isDirectory()) {
                return false;
            }
            if (TextUtils.isEmpty(this.c)) {
                return true;
            }
            int i = this.d;
            if (i == 1) {
                return file.getName().startsWith(this.c);
            }
            if (i == 2) {
                return file.getName().endsWith(this.c);
            }
            if (i == 3) {
                return file.getName().equals(this.c);
            }
            if (i != 4) {
                return false;
            }
            return file.getName().contains(this.c);
        }

        public a(boolean z, boolean z2) {
            this.f18059a = z;
            this.b = z2;
            this.c = null;
            this.d = 0;
        }
    }
}
