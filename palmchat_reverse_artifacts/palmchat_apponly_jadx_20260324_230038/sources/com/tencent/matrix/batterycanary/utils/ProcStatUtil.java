package com.tencent.matrix.batterycanary.utils;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class ProcStatUtil {
    private static final String TAG = "Matrix.battery.ProcStatUtil";
    private static final ThreadLocal<byte[]> sBufferRef = new ThreadLocal<>();

    @Nullable
    private static OnParseError sParseError;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnParseError {
        void onError(int i, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ParseException extends Exception {
        public final String content;

        public ParseException(String str) {
            this.content = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ProcStat {
        public String comm = "";
        public String stat = "_";
        public long utime = -1;
        public long stime = -1;
        public long cutime = -1;
        public long cstime = -1;

        public long getJiffies() {
            return this.utime + this.stime + this.cutime + this.cstime;
        }
    }

    @Nullable
    public static ProcStat current() {
        return of(Process.myPid(), Process.myTid());
    }

    @Nullable
    public static ProcStat currentPid() {
        return of(Process.myPid());
    }

    public static byte[] getLocalBuffers() {
        ThreadLocal<byte[]> threadLocal = sBufferRef;
        if (threadLocal.get() == null) {
            threadLocal.set(new byte[128]);
        }
        return threadLocal.get();
    }

    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("-") ? TextUtils.isDigitsOnly(str.substring(1)) : TextUtils.isDigitsOnly(str);
    }

    @Nullable
    public static ProcStat of(int i) {
        return parse(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + i + SysPerformanceCollector.APP_CPU_INFO_FILE);
    }

    @Nullable
    public static ProcStat parse(String str) {
        ProcStat withSplits;
        try {
            try {
                withSplits = parseWithBufferForPath(str, getLocalBuffers());
            } catch (ParseException e) {
                OnParseError onParseError = sParseError;
                if (onParseError != null) {
                    onParseError.onError(1, e.content);
                }
                withSplits = null;
            }
            if (withSplits == null || withSplits.comm == null) {
                MatrixLog.w(TAG, "#parseJiffies read with buffer fail, fallback with spilts", new Object[0]);
                try {
                    withSplits = parseWithSplits(BatteryCanaryUtil.cat(str));
                } catch (ParseException e2) {
                    OnParseError onParseError2 = sParseError;
                    if (onParseError2 != null) {
                        onParseError2.onError(2, e2.content);
                    }
                }
                if (withSplits != null) {
                    if (withSplits.comm == null) {
                    }
                }
                MatrixLog.w(TAG, "#parseJiffies read with splits fail", new Object[0]);
                return null;
            }
            return withSplits;
        } catch (Throwable th) {
            MatrixLog.w(TAG, "#parseJiffies fail: " + th.getMessage(), new Object[0]);
            OnParseError onParseError3 = sParseError;
            if (onParseError3 != null) {
                onParseError3.onError(0, BatteryCanaryUtil.cat(str) + "\n" + th.getMessage());
            }
            return null;
        }
    }

    @VisibleForTesting
    public static ProcStat parseWithBuffer(byte[] bArr) throws ParseException {
        int i;
        ProcStat procStat = new ProcStat();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (Character.isSpaceChar(bArr[i2])) {
                i3++;
            } else if (i3 == 1) {
                int i4 = i2;
                int i5 = 0;
                while (i4 < length && 41 != bArr[i4]) {
                    i4++;
                    i5++;
                }
                if (40 == bArr[i2]) {
                    i2++;
                    i5--;
                }
                if (41 == bArr[(i2 + i5) - 1]) {
                    i5--;
                }
                if (i5 > 0) {
                    procStat.comm = safeBytesToString(bArr, i2, i5);
                }
                i2 = i4;
                i3 = 2;
            } else if (i3 != 3) {
                switch (i3) {
                    case 14:
                        i = i2;
                        int i6 = 0;
                        while (i < length && !Character.isSpaceChar(bArr[i])) {
                            i++;
                            i6++;
                        }
                        String strSafeBytesToString = safeBytesToString(bArr, i2, i6);
                        if (!isNumeric(strSafeBytesToString)) {
                            throw new ParseException(safeBytesToString(bArr, 0, bArr.length) + "\nutime: " + strSafeBytesToString);
                        }
                        procStat.utime = MatrixUtil.parseLong(strSafeBytesToString, 0L);
                        i2 = i;
                        break;
                        break;
                    case 15:
                        i = i2;
                        int i7 = 0;
                        while (i < length && !Character.isSpaceChar(bArr[i])) {
                            i++;
                            i7++;
                        }
                        String strSafeBytesToString2 = safeBytesToString(bArr, i2, i7);
                        if (!isNumeric(strSafeBytesToString2)) {
                            throw new ParseException(safeBytesToString(bArr, 0, bArr.length) + "\nstime: " + strSafeBytesToString2);
                        }
                        procStat.stime = MatrixUtil.parseLong(strSafeBytesToString2, 0L);
                        i2 = i;
                        break;
                        break;
                    case 16:
                        i = i2;
                        int i8 = 0;
                        while (i < length && !Character.isSpaceChar(bArr[i])) {
                            i++;
                            i8++;
                        }
                        String strSafeBytesToString3 = safeBytesToString(bArr, i2, i8);
                        if (!isNumeric(strSafeBytesToString3)) {
                            throw new ParseException(safeBytesToString(bArr, 0, bArr.length) + "\ncutime: " + strSafeBytesToString3);
                        }
                        procStat.cutime = MatrixUtil.parseLong(strSafeBytesToString3, 0L);
                        i2 = i;
                        break;
                        break;
                    case 17:
                        i = i2;
                        int i9 = 0;
                        while (i < length && !Character.isSpaceChar(bArr[i])) {
                            i++;
                            i9++;
                        }
                        String strSafeBytesToString4 = safeBytesToString(bArr, i2, i9);
                        if (!isNumeric(strSafeBytesToString4)) {
                            throw new ParseException(safeBytesToString(bArr, 0, bArr.length) + "\ncstime: " + strSafeBytesToString4);
                        }
                        procStat.cstime = MatrixUtil.parseLong(strSafeBytesToString4, 0L);
                        i2 = i;
                        break;
                        break;
                }
            } else {
                int i10 = i2;
                int i11 = 0;
                while (i10 < length && !Character.isSpaceChar(bArr[i10])) {
                    i10++;
                    i11++;
                }
                procStat.stat = safeBytesToString(bArr, i2, i11);
                i2 = i10;
            }
            i2++;
        }
        return procStat;
    }

    public static ProcStat parseWithBufferForPath(String str, byte[] bArr) throws ParseException {
        int i;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                i = fileInputStream.read(bArr);
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e) {
            MatrixLog.printErrStackTrace(TAG, e, "read buffer from file fail", new Object[0]);
            i = -1;
        }
        if (i <= 0) {
            return null;
        }
        return parseWithBuffer(bArr);
    }

    @VisibleForTesting
    public static ProcStat parseWithSplits(String str) throws ParseException {
        ProcStat procStat = new ProcStat();
        if (!TextUtils.isEmpty(str)) {
            int iIndexOf = str.indexOf(")");
            if (iIndexOf <= 0) {
                throw new IllegalStateException(str + " has not ')'");
            }
            String strSubstring = str.substring(0, iIndexOf);
            procStat.comm = strSubstring.substring(strSubstring.indexOf("(") + 1, iIndexOf);
            String[] strArrSplit = str.substring(iIndexOf + 1).split(" ");
            if (!isNumeric(strArrSplit[12])) {
                throw new ParseException(str + "\nutime: " + strArrSplit[12]);
            }
            if (!isNumeric(strArrSplit[13])) {
                throw new ParseException(str + "\nstime: " + strArrSplit[13]);
            }
            if (!isNumeric(strArrSplit[14])) {
                throw new ParseException(str + "\ncutime: " + strArrSplit[14]);
            }
            if (!isNumeric(strArrSplit[15])) {
                throw new ParseException(str + "\ncstime: " + strArrSplit[15]);
            }
            procStat.stat = strArrSplit[1];
            procStat.utime = MatrixUtil.parseLong(strArrSplit[12], 0L);
            procStat.stime = MatrixUtil.parseLong(strArrSplit[13], 0L);
            procStat.cutime = MatrixUtil.parseLong(strArrSplit[14], 0L);
            procStat.cstime = MatrixUtil.parseLong(strArrSplit[15], 0L);
        }
        return procStat;
    }

    @VisibleForTesting
    public static String safeBytesToString(byte[] bArr, int i, int i2) {
        try {
            CharBuffer charBufferDecode = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bArr, i, i2));
            return String.valueOf(charBufferDecode.array(), 0, charBufferDecode.limit());
        } catch (IndexOutOfBoundsException e) {
            MatrixLog.w(TAG, "#safeBytesToString failed: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static void setParseErrorListener(OnParseError onParseError) {
        sParseError = onParseError;
    }

    @Nullable
    public static ProcStat of(int i, int i2) {
        return parse(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + i + "/task/" + i2 + SysPerformanceCollector.APP_CPU_INFO_FILE);
    }
}
