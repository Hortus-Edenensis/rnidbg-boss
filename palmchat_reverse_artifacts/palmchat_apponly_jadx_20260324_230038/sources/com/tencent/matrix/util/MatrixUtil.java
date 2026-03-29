package com.tencent.matrix.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class MatrixUtil {
    private static final String TAG = "Matrix.MatrixUtil";
    private static String processName;
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final ThreadLocal<MessageDigest> MD5_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.tencent.matrix.util.MatrixUtil.1
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };
    private static final ThreadLocal<MessageDigest> SHA256_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.tencent.matrix.util.MatrixUtil.2
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(x.dW);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Initialize SHA256-DIGEST failed.", e);
            }
        }
    };

    private MatrixUtil() {
    }

    private static void appendHexPair(byte b, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.w(TAG, "Failed to close resource", e);
            }
        }
    }

    public static String convertStreamToString(InputStream inputStream) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        bufferedReader2.close();
                        return sb.toString();
                    }
                    sb.append(line);
                    sb.append('\n');
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String formatTime(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String getLatestStack(String str, int i) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length <= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(strArrSplit[i2]);
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String getProcessName(Context context) throws Throwable {
        String str = processName;
        if (str != null) {
            return str;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    private static String getProcessNameInternal(Context context) throws Throwable {
        FileInputStream fileInputStream;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager.RunningAppProcessInfo next;
        int iMyPid = Process.myPid();
        if (context == null || iMyPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        FileInputStream fileInputStream2 = null;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            try {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (next.pid == iMyPid) {
                        break;
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "getProcessNameInternal exception:" + e.getMessage());
            }
            next = null;
            if (next != null) {
                return next.processName;
            }
        }
        byte[] bArr = new byte[128];
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + iMyPid + "/cmdline");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            Log.e(TAG, e3.getMessage());
        }
        try {
            int i = fileInputStream.read(bArr);
            if (i > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        break;
                    }
                    if (bArr[i2] <= 0) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                String str = new String(bArr, 0, i, Charset.forName("UTF-8"));
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    Log.e(TAG, e4.getMessage());
                }
                return str;
            }
            fileInputStream.close();
        } catch (Exception e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            Log.e(TAG, "getProcessNameInternal exception:" + e.getMessage());
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e6) {
                    Log.e(TAG, e6.getMessage());
                }
            }
            throw th;
        }
        return "";
    }

    private static byte[] getSHA(String str) throws NoSuchAlgorithmException {
        return SHA256_DIGEST.get().digest(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String getSHA256String(String str) throws NoSuchAlgorithmException {
        return toHexString(getSHA(str));
    }

    public static String getStringFromFile(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String strConvertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                return strConvertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static boolean isInMainProcess(Context context) throws Throwable {
        String packageName = context.getPackageName();
        String processName2 = getProcessName(context);
        if (processName2 == null || processName2.length() == 0) {
            processName2 = "";
        }
        return packageName.equals(processName2);
    }

    public static boolean isInMainThread(long j) {
        return Looper.getMainLooper().getThread().getId() == j;
    }

    public static long parseLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return str.length() <= 0 ? j : Long.decode(str).longValue();
        } catch (NumberFormatException e) {
            MatrixLog.w(TAG, "parseLong error: " + e.getMessage(), new Object[0]);
            return j;
        }
    }

    public static String printException(Exception exc) {
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(exc.toString());
        for (int i = 2; i < stackTrace.length; i++) {
            sb.append('[');
            sb.append(stackTrace[i].getClassName());
            sb.append(':');
            sb.append(stackTrace[i].getMethodName());
            sb.append("(" + stackTrace[i].getLineNumber() + ")]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printFileByLine(String str, String str2) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str2)), "UTF-8"));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        bufferedReader2.close();
                        return;
                    }
                    MatrixLog.i(str, line, new Object[0]);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        MatrixLog.e(str, "printFileByLine failed e : " + th.getMessage(), new Object[0]);
                        if (bufferedReader != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(new BigInteger(1, bArr).toString(16));
        while (sb.length() < 32) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    private static String bufferToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(byte[] bArr) {
        return bufferToHex(MD5_DIGEST.get().digest(bArr));
    }
}
