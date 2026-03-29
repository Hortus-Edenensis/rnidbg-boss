package com.zm.fda.O52OZ;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16632a = 8192;
    public static final String b = "Z25O0";

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
        } catch (Throwable th) {
            th = th;
            fileInputStream2 = fileInputStream;
        }
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            try {
                byte[] bArrA = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return bArrA;
            } catch (FileNotFoundException e3) {
                e = e3;
                Log.e(b, "FileNotFoundException:", e);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (IOException e4) {
                e = e4;
                Log.e(b, "IOException:", e);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileInputStream = null;
        } catch (IOException e7) {
            e = e7;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str3 == null || str3.length() == 0) {
            str3 = "UTF-8";
        }
        try {
            return a(str, str2.getBytes(str3));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bArr != null && bArr.length != 0) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        if (str.startsWith("file://")) {
                            str = str.substring(7);
                        }
                        fileOutputStream = new FileOutputStream(str);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return true;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                Log.e(b, "writeFile: ", e);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return false;
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                Log.e(b, "writeFile: ", e);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        }
        Log.d(b, "writeFile: data is empty");
        return false;
    }

    public static long a(String str) {
        Throwable th;
        FileChannel fileChannel;
        File file;
        FileChannel fileChannel2;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        FileInputStream fileInputStream = null;
        FileChannel channel = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                file = new File(str);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
        if (file.exists()) {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                channel = fileInputStream3.getChannel();
                if (channel != null) {
                    long size = channel.size();
                    try {
                        fileInputStream3.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        channel.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    return size;
                }
                fileInputStream2 = fileInputStream3;
                fileChannel2 = channel;
            } catch (Throwable th6) {
                th = th6;
                FileChannel fileChannel3 = channel;
                fileInputStream = fileInputStream3;
                fileChannel = fileChannel3;
                try {
                    th.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return 0L;
                } finally {
                }
            }
            return 0L;
        }
        fileChannel2 = null;
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (Throwable th8) {
                th8.printStackTrace();
            }
        }
        if (fileChannel2 != null) {
            fileChannel2.close();
        }
        return 0L;
    }
}
