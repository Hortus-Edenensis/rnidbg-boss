package com.ss.android.ttvecamera;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TELogUtils {
    private static String APPNAME = "VESDK-";
    private static String AUTO_TEST_MONITOR = "monitorInfo";
    private static byte DEBUG_LEVEL = 3;
    public static final byte DEBUG_LEVEL_D = 15;
    public static final byte DEBUG_LEVEL_E = 1;
    public static final byte DEBUG_LEVEL_I = 7;
    public static final byte DEBUG_LEVEL_N = 0;
    public static final byte DEBUG_LEVEL_V = 31;
    public static final byte DEBUG_LEVEL_W = 3;
    public static final byte LOGD = 8;
    public static final byte LOGE = 1;
    public static final byte LOGI = 4;
    public static final byte LOGV = 16;
    public static final byte LOGW = 2;
    public static final boolean TEST_LOG_FLAG = false;
    private static volatile ILog mLogOutput = new DefaultLog();

    /* JADX INFO: compiled from: SearchBox */
    public static class DefaultLog implements ILog {
        @Override // com.ss.android.ttvecamera.TELogUtils.ILog
        public void Log(byte b, String str, String str2) {
            if (b == 16) {
                Log.v(str, str2);
                return;
            }
            if (b == 8) {
                Log.d(str, str2);
                return;
            }
            if (b == 4) {
                Log.i(str, str2);
                return;
            }
            if (b == 2) {
                Log.w(str, str2);
            } else if (b == 1) {
                Log.e(str, str2);
            } else {
                Log.d(str, str2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ILog {
        void Log(byte b, String str, String str2);
    }

    public static void d(String str, String str2) {
        if ((DEBUG_LEVEL & 8) != 0) {
            mLogOutput.Log((byte) 8, APPNAME + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if ((DEBUG_LEVEL & 1) != 0) {
            mLogOutput.Log((byte) 1, APPNAME + str, str2);
        }
    }

    public static int getAndroidLogLevel(byte b) {
        if (b == 1) {
            return 6;
        }
        if (b == 3) {
            return 5;
        }
        if (b == 7) {
            return 4;
        }
        if (b != 15) {
            return b != 31 ? 0 : 2;
        }
        return 3;
    }

    public static byte getLogLevel(int i) {
        if (i == 2) {
            return DEBUG_LEVEL_V;
        }
        if (i == 3) {
            return (byte) 15;
        }
        if (i == 4) {
            return (byte) 7;
        }
        if (i != 5) {
            return i != 6 ? (byte) 0 : (byte) 1;
        }
        return (byte) 3;
    }

    public static String getStackTraceString() {
        return Log.getStackTraceString(new Throwable());
    }

    public static void i(String str, String str2) {
        if ((DEBUG_LEVEL & 4) != 0) {
            mLogOutput.Log((byte) 4, APPNAME + str, str2);
        }
    }

    public static void logMonitorInfo(String str, Object obj) {
        if ((DEBUG_LEVEL & 8) != 0) {
            Log.d(AUTO_TEST_MONITOR, str + " = " + obj.toString());
        }
    }

    public static void printStackTrace() {
        d("Debug", getStackTraceString());
    }

    public static void register(ILog iLog) {
        if (iLog != null) {
            mLogOutput = iLog;
        } else {
            mLogOutput = new DefaultLog();
        }
    }

    public static void setUp(String str, byte b) {
        if (str != null && str.length() > 0) {
            APPNAME = str + "-";
        }
        DEBUG_LEVEL = b;
    }

    public static void v(String str, String str2) {
        if ((DEBUG_LEVEL & 16) != 0) {
            mLogOutput.Log((byte) 16, APPNAME + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if ((DEBUG_LEVEL & 2) != 0) {
            mLogOutput.Log((byte) 2, APPNAME + str, str2);
        }
    }

    public static byte getLogLevel() {
        return DEBUG_LEVEL;
    }

    public static void d(Class<?> cls, String str) {
        if ((DEBUG_LEVEL & 8) != 0) {
            mLogOutput.Log((byte) 8, APPNAME + cls.getSimpleName(), str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if ((DEBUG_LEVEL & 1) != 0) {
            String str3 = APPNAME + str;
            mLogOutput.Log((byte) 1, str3, str2 + "\n***StackTrace***\n" + Log.getStackTraceString(th));
        }
    }

    public static void setUp(String str, int i) {
        setUp(str, getLogLevel(i));
    }

    public static void v(Class<?> cls, String str) {
        if ((DEBUG_LEVEL & 16) != 0) {
            mLogOutput.Log((byte) 16, APPNAME + cls.getSimpleName(), str);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if ((DEBUG_LEVEL & 2) != 0) {
            String str3 = APPNAME + str;
            mLogOutput.Log((byte) 2, str3, str2 + "\n***StackTrace***\n" + Log.getStackTraceString(th));
        }
    }

    public static void e(Class<?> cls, String str) {
        if ((DEBUG_LEVEL & 1) != 0) {
            mLogOutput.Log((byte) 1, APPNAME + cls.getSimpleName(), str);
        }
    }

    public static void w(Class<?> cls, String str) {
        if ((DEBUG_LEVEL & 2) != 0) {
            mLogOutput.Log((byte) 2, APPNAME + cls.getSimpleName(), str);
        }
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        if ((DEBUG_LEVEL & 1) != 0) {
            String str2 = APPNAME + cls.getSimpleName();
            mLogOutput.Log((byte) 1, str2, str + "\n***StackTrace***\n" + Log.getStackTraceString(th));
        }
    }

    public static void w(Class<?> cls, String str, Throwable th) {
        if ((DEBUG_LEVEL & 2) != 0) {
            String str2 = APPNAME + cls.getSimpleName();
            mLogOutput.Log((byte) 2, str2, str + "\n***StackTrace***\n" + Log.getStackTraceString(th));
        }
    }
}
