package com.opos.cmn.an.e.b;

import android.os.Environment;
import android.os.StatFs;
import com.opos.cmn.an.d.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static void a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public static String b() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static long c() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "", e);
            return 0L;
        }
    }

    public static String d(File file) {
        return file != null ? c(file.getAbsolutePath()) : "";
    }

    public static long e(String str) {
        if (b.a(str)) {
            return 0L;
        }
        return h(new File(str));
    }

    public static boolean f(File file) {
        if (file != null) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                com.opos.cmn.an.f.a.c("FileTool", "createNewFile", e);
            }
        }
        return false;
    }

    public static long g(File file) {
        if (a(file)) {
            return file.length();
        }
        return 0L;
    }

    public static long h(File file) {
        long j = 0;
        if (file != null) {
            try {
                j = file.isDirectory() ? j(file) : i(file);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FileTool", "", e);
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003f A[Catch: Exception -> 0x002d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x002d, blocks: (B:18:0x0029, B:29:0x003f), top: B:32:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long i(File file) throws Throwable {
        long jAvailable = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (file != null) {
                    try {
                        if (a(file)) {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                jAvailable = fileInputStream2.available();
                                fileInputStream = fileInputStream2;
                            } catch (Exception e) {
                                e = e;
                                fileInputStream = fileInputStream2;
                                com.opos.cmn.an.f.a.c("FileTool", "", e);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return jAvailable;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        com.opos.cmn.an.f.a.c("FileTool", "", e2);
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } else if (fileInputStream != null) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            com.opos.cmn.an.f.a.c("FileTool", "", e4);
        }
        return jAvailable;
    }

    private static long j(File file) {
        long j = 0;
        if (file != null) {
            try {
                if (b(file)) {
                    File[] fileArrListFiles = file.listFiles();
                    for (int i = 0; i < fileArrListFiles.length; i++) {
                        j += fileArrListFiles[i].isDirectory() ? j(fileArrListFiles[i]) : i(fileArrListFiles[i]);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FileTool", "", e);
            }
        }
        return j;
    }

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "isSdCardAvailable", e);
            return false;
        }
    }

    public static boolean b(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static String c(String str) {
        int iLastIndexOf;
        return (b.a(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? "" : str.substring(0, iLastIndexOf);
    }

    public static boolean d(String str) {
        try {
            return e(new File(str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "deleteFile", e);
            return false;
        }
    }

    public static boolean e(File file) {
        try {
            if (a(file)) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "deleteFile", e);
            return false;
        }
    }

    public static boolean f(String str) {
        if (b.a(str)) {
            return false;
        }
        return new File(str).mkdirs();
    }

    public static boolean a(File file) {
        if (file != null) {
            return file.exists();
        }
        return false;
    }

    public static boolean b(String str) {
        if (b.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static boolean c(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return false;
        }
        return parentFile.mkdirs();
    }

    public static boolean a(File file, File file2) {
        if (file != null && file2 != null) {
            try {
                return file.renameTo(file2);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FileTool", "rename", e);
            }
        }
        return false;
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        boolean z = false;
        if (inputStream != null && file != null) {
            try {
                if (!a(file) && ((!b(d(file)) && !c(file)) || !f(file))) {
                    return false;
                }
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (-1 == i) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i);
                        }
                        fileOutputStream2.flush();
                        z = true;
                        a(fileOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FileTool", "saveInputStream2File", e);
            }
        }
        return z;
    }

    public static boolean a(String str) {
        if (b.a(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "inputStream2Bytes", e);
            return null;
        }
    }
}
