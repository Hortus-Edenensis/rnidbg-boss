package com.lantern.auth.core;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLFile {
    public static final int BUFSIZE = 8192;

    public static boolean copy(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        if (str2.startsWith("file://")) {
            str2 = str2.substring(7);
        }
        return copy(new File(str), new File(str2));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:39|3)|(5:44|4|(1:6)(1:46)|38|27)|7|41|8|38|27|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r8 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyStreams(InputStream inputStream, FileOutputStream fileOutputStream) throws Throwable {
        ?? r3;
        byte[] bArr;
        BufferedOutputStream bufferedOutputStream;
        boolean z = true;
        ?? r32 = 0;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bArr = new byte[8192];
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 8192);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, 8192);
                r3 = -1;
                r32 = -1;
                if (i == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, i);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream2 = bufferedOutputStream;
                BLLog.e("Exception while copying: " + e);
                ?? r33 = bufferedOutputStream2;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                        r32 = bufferedOutputStream2;
                    } catch (IOException e3) {
                        e = e3;
                        StringBuilder sb = new StringBuilder();
                        r3 = bufferedOutputStream2;
                        sb.append("Exception while closing the stream: ");
                        sb.append(e);
                        BLLog.e(sb.toString());
                        r33 = r3;
                        z = false;
                        r32 = r33;
                    }
                } else {
                    z = false;
                    r32 = r33;
                }
            } catch (Throwable th2) {
                th = th2;
                r32 = bufferedOutputStream;
                if (r32 != 0) {
                    try {
                        r32.close();
                    } catch (IOException e4) {
                        BLLog.e("Exception while closing the stream: " + e4);
                    }
                }
                throw th;
            }
            return z;
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return z;
    }

    public static boolean copyWithoutOutputClosing(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        byte[] bArr;
        OutputStream outputStreamMakeOutputBuffered;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        try {
            try {
                bArr = new byte[8192];
                inputStream = makeInputBuffered(inputStream);
                outputStreamMakeOutputBuffered = makeOutputBuffered(outputStream);
            } catch (IOException e) {
                BLLog.e("Exception while copying: " + e);
                if (inputStream == null) {
                    return false;
                }
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    sb = new StringBuilder();
                    sb.append("Exception while closing the stream: ");
                    sb.append(e);
                    BLLog.e(sb.toString());
                    return false;
                }
            }
            try {
                while (true) {
                    int i = inputStream.read(bArr, 0, 8192);
                    if (i == -1) {
                        break;
                    }
                    outputStreamMakeOutputBuffered.write(bArr, 0, i);
                    return true;
                }
                inputStream.close();
                return true;
            } catch (IOException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append("Exception while closing the stream: ");
                sb.append(e);
                BLLog.e(sb.toString());
                return false;
            }
            outputStreamMakeOutputBuffered.flush();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    BLLog.e("Exception while closing the stream: " + e4);
                }
            }
            throw th;
        }
    }

    public static boolean createNoMediaFile(File file) {
        File file2 = new File(file, ".nomedia");
        if (file2.exists()) {
            return true;
        }
        try {
            return file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void delete(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            deleteFolderAllFiles(str);
            new File(str).delete();
        }
    }

    private static void deleteFolderAllFiles(String str) {
        File[] fileArrListFiles;
        File file = new File(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                delete(file2.getAbsolutePath());
            }
        }
    }

    public static boolean exists(String str) {
        return new File(str).exists();
    }

    public static byte[] getData(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static FileOutputStream getEmptyFileOutputStream(File file) {
        File parentFile;
        if (file == null) {
            return null;
        }
        if (!file.exists() && (parentFile = file.getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File getFileByTime(String str, String str2) {
        return new File(str + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + str2);
    }

    public static String getFileExtension(String str) {
        int iLastIndexOf;
        return (str == null || (iLastIndexOf = str.lastIndexOf(".")) < 0) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static String getFileName(String str) {
        String str2 = File.separator;
        if (str == null) {
            return "";
        }
        if (str.startsWith("http://")) {
            str2 = "/";
        }
        int iLastIndexOf = str.lastIndexOf(str2);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : "";
    }

    public static String getFileNameNoExt(String str) {
        String str2 = File.separator;
        if (str == null) {
            return "";
        }
        if (str.startsWith("http://")) {
            str2 = "/";
        }
        int iLastIndexOf = str.lastIndexOf(str2);
        if (iLastIndexOf < 0) {
            return "";
        }
        int iLastIndexOf2 = str.lastIndexOf(".");
        return (iLastIndexOf2 <= 0 || iLastIndexOf2 <= iLastIndexOf) ? str.substring(iLastIndexOf + 1) : str.substring(iLastIndexOf + 1, iLastIndexOf2);
    }

    public static long getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        return new File(str).length();
    }

    public static InputStream getInputStream(String str) {
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        try {
            return new FileInputStream(str);
        } catch (FileNotFoundException e) {
            BLLog.e("FileNotFoundException:" + e.getMessage());
            return null;
        }
    }

    public static OutputStream getOutputStream(String str) {
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        try {
            return new FileOutputStream(str);
        } catch (FileNotFoundException e) {
            BLLog.e("FileNotFoundException:" + e.getMessage());
            return null;
        }
    }

    public static String getString(File file, String str) {
        if (str == null || str.length() == 0) {
            str = "UTF-8";
        }
        try {
            return new String(getData(new FileInputStream(file)), str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static File getUniqueDestination(String str, String str2) {
        File file = new File(str + "." + str2);
        int i = 2;
        while (file.exists()) {
            file = new File(str + "_" + i + "." + str2);
            i++;
        }
        return file;
    }

    public static InputStream makeInputBuffered(String str) {
        try {
            return makeInputBuffered(new FileInputStream(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static OutputStream makeOutputBuffered(String str) {
        try {
            return makeOutputBuffered(new FileOutputStream(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean mkdirs(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return mkdirs(new File(str));
    }

    public static byte[] readFile(String str) {
        try {
            return getData(new FileInputStream(str));
        } catch (FileNotFoundException e) {
            BLLog.e("FileNotFoundException:" + e.getMessage());
            return null;
        } catch (IOException e2) {
            BLLog.e("IOException:" + e2.getMessage());
            return null;
        }
    }

    public static boolean writeFile(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str3 == null || str3.length() == 0) {
            str3 = "UTF-8";
        }
        try {
            return writeFile(str, str2.getBytes(str3));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean mkdirs(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static InputStream makeInputBuffered(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream, 8192);
    }

    public static OutputStream makeOutputBuffered(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return outputStream instanceof BufferedOutputStream ? outputStream : new BufferedOutputStream(outputStream, 8192);
    }

    public static boolean copy(File file, File file2) {
        if (file != null && file2 != null) {
            try {
                return copy(new FileInputStream(file), new FileOutputStream(file2));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean writeFile(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                if (str.startsWith("file://")) {
                    str = str.substring(7);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                return true;
            } catch (FileNotFoundException e) {
                BLLog.e("FileNotFoundException:" + e.getMessage());
                return false;
            } catch (IOException e2) {
                BLLog.e("IOException:" + e2.getMessage());
                return false;
            }
        }
        BLLog.e("data is empty:" + bArr);
        return false;
    }

    public static FileOutputStream getEmptyFileOutputStream(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return getEmptyFileOutputStream(new File(str));
    }

    public static boolean copy(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        boolean z = false;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        try {
            try {
                byte[] bArr = new byte[8192];
                inputStream = makeInputBuffered(inputStream);
                outputStream = makeOutputBuffered(outputStream);
                while (true) {
                    int i = inputStream.read(bArr, 0, 8192);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        outputStream.flush();
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                        }
                        try {
                            inputStream.close();
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            z = true;
                            sb = new StringBuilder();
                            sb.append("Exception while closing the stream: ");
                            sb.append(e);
                            BLLog.e(sb.toString());
                            return z;
                        }
                    }
                }
            } catch (IOException e3) {
                BLLog.e("Exception while copying: " + e3);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                        z = true;
                    } catch (IOException e4) {
                        e = e4;
                        sb = new StringBuilder();
                        sb.append("Exception while closing the stream: ");
                        sb.append(e);
                        BLLog.e(sb.toString());
                        return z;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                    return true;
                }
                return z;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    BLLog.e("Exception while closing the stream: " + e5);
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static boolean writeFile(String str, byte[] bArr, boolean z) {
        int iLastIndexOf;
        if (bArr != null && bArr.length != 0) {
            try {
                if (str.startsWith("file://")) {
                    str = str.substring(7);
                }
                if (z && (iLastIndexOf = str.lastIndexOf(File.separator)) >= 0) {
                    File file = new File(str.substring(0, iLastIndexOf + 1));
                    if (!file.exists() && !file.mkdirs()) {
                        BLLog.e("Make dest dir failed:" + file.toString());
                        return false;
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                return true;
            } catch (FileNotFoundException e) {
                BLLog.e("FileNotFoundException:" + e.getMessage());
                return false;
            } catch (IOException e2) {
                BLLog.e("IOException:" + e2.getMessage());
                return false;
            }
        }
        BLLog.e("data is empty:" + bArr);
        return false;
    }
}
