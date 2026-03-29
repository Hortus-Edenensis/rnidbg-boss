package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class u {
    public static final String Code = "FileUtil";
    private static final int I = 2048;
    private static final int V = 10;

    public static boolean B(File file) {
        return file.exists() && file.length() > 0;
    }

    private static boolean C(File file) {
        try {
            File file2 = new File(file.getCanonicalPath() + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                return file2.delete();
            }
            return false;
        } catch (IOException unused) {
            fh.I(Code, "deleteSingleFile IOException");
            return false;
        }
    }

    public static String Code(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return V(context.createDeviceProtectedStorageContext().getDataDir());
        }
        String strV = V(context.getFilesDir());
        int iLastIndexOf = strV.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? strV : strV.substring(0, iLastIndexOf);
    }

    private static void F(File file) {
        if (file == null) {
            return;
        }
        int i = 0;
        while (i < 10 && file != null && !ba.Code(V(file))) {
            i++;
            if (file.exists()) {
                fh.Code(Code, "current file exists");
                if (file.isFile()) {
                    C(file);
                    return;
                }
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && TextUtils.equals(V(parentFile), V(file))) {
                fh.I(Code, "parent file is the same as current");
                return;
            }
            file = parentFile;
        }
    }

    public static void I(File file) {
        if (file == null || !file.exists()) {
            fh.Code(Code, "file is null or file in not exists");
            return;
        }
        if (!file.isFile()) {
            if (file.delete()) {
                return;
            }
            fh.I(Code, "cannot delete file");
            return;
        }
        File file2 = new File(V(file) + "_delete");
        if (file.renameTo(file2)) {
            if (file2.delete()) {
                return;
            }
        } else if (file.delete()) {
            return;
        }
        fh.I(Code, "fail to delete file");
    }

    private static void S(File file) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        S(file2);
                    } else {
                        C(file2);
                    }
                }
            }
            C(file);
        }
    }

    public static String V(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            fh.Z(Code, "get path error");
            return null;
        }
    }

    public static String Z(File file) {
        FileInputStream fileInputStream;
        Object th;
        BufferedReader bufferedReader;
        if (!file.exists()) {
            fh.V(Code, "local file not exist");
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            bufferedReader = null;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append(com.huawei.openalliance.ad.constant.x.dV);
            } catch (Throwable th4) {
                th = th4;
                try {
                    fh.I(Code, "read file error: %s", th.getClass().getSimpleName());
                } catch (Throwable th5) {
                    bb.Code(bufferedReader);
                    bb.Code((Closeable) fileInputStream);
                    throw th5;
                }
            }
            bb.Code(bufferedReader);
            bb.Code((Closeable) fileInputStream);
            return sb.toString().trim();
        }
        bufferedReader.close();
        bb.Code(bufferedReader);
        bb.Code((Closeable) fileInputStream);
        return sb.toString().trim();
    }

    public static String Code(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr, 0, 4) > 0) {
                return y.Code(bArr);
            }
            return null;
        } catch (IOException unused) {
            fh.Z(Code, "fail to read file header");
            return null;
        }
    }

    public static void Code(String str) {
        if (bc.Code(str)) {
            return;
        }
        S(new File(str));
    }

    public static boolean Code(Context context, String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        Uri uri = Uri.parse(str);
        InputStream inputStream = null;
        try {
            if (z.Code(context, uri)) {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    if (inputStreamOpenInputStream == null) {
                        fh.I(Code, "get input stream failed: null.");
                        bb.Code((Closeable) inputStreamOpenInputStream);
                    } else {
                        File file = new File(str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i = inputStreamOpenInputStream.read(bArr);
                                if (i == -1) {
                                    bb.Code((Closeable) inputStreamOpenInputStream);
                                    bb.Code(bufferedOutputStream);
                                    return true;
                                }
                                bufferedOutputStream.write(bArr, 0, i);
                            }
                        } catch (Throwable th) {
                            inputStream = inputStreamOpenInputStream;
                            th = th;
                            try {
                                fh.Z(Code, "copy style file exception:" + th.getClass().getSimpleName());
                                return false;
                            } finally {
                                bb.Code((Closeable) inputStream);
                                bb.Code(bufferedOutputStream);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    inputStream = inputStreamOpenInputStream;
                    th = th2;
                    bufferedOutputStream = null;
                }
            } else {
                fh.I(Code, "invalid uri");
                bb.Code((Closeable) null);
            }
            bb.Code((Closeable) null);
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean Code(File file) {
        if (file == null || file.mkdirs()) {
            return true;
        }
        F(file);
        return file.mkdirs();
    }
}
