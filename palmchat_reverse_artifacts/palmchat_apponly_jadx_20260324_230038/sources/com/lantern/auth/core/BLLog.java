package com.lantern.auth.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLLog {
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_OFF = 5;
    public static final int LEVEL_WARNING = 3;
    public static final int OUTPUT_LOGGER = 1;
    public static final int OUTPUT_STDOUT = 0;
    public static final int OUTPUT_STREAM = 2;
    private static Logger log = Logger.getLogger("BLLog");
    public static int mLevel = 3;
    private static OutputStream mOutStream = null;
    public static int mOutput = 1;

    public static void d(String str, Object... objArr) {
        if (1 >= mLevel) {
            if (objArr.length == 0) {
                display(str);
            } else {
                display(String.format(str, objArr));
            }
        }
    }

    private static void display(String str) {
        StackTraceElement stackTraceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
        String str2 = String.format("[%s,%d,%s] %s", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), stackTraceElement.getMethodName(), str);
        int i = mOutput;
        if (i == 0) {
            System.out.println(str2);
            return;
        }
        if (i == 1) {
            log.warning(str2);
            return;
        }
        if (i == 2 && mOutStream != null) {
            try {
                byte[] bytes = str2.getBytes("utf-8");
                mOutStream.write(bytes, 0, bytes.length);
                if (str2.endsWith("\n")) {
                    return;
                }
                mOutStream.write("\n".getBytes());
            } catch (IOException e) {
                log.warning(e.getMessage());
            }
        }
    }

    public static void e(String str) {
        if (4 >= mLevel) {
            display(str);
        }
    }

    public static void i(String str) {
        if (2 >= mLevel) {
            display(str);
        }
    }

    public static boolean isDebugLevel() {
        return mLevel == 1;
    }

    public static void printStack() {
        if (1 >= mLevel) {
            Exception exc = new Exception("this is a log");
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter((Writer) stringWriter, true));
            display(stringWriter.toString());
        }
    }

    public static void setLevel(int i) {
        mLevel = i;
    }

    public static void setOutput(int i, OutputStream outputStream) {
        mOutput = i;
        mOutStream = outputStream;
    }

    public static void setTag(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        log = Logger.getLogger(str);
    }

    public static void w(String str) {
        if (3 >= mLevel) {
            display(str);
        }
    }

    public static void e(String str, Exception exc) {
        if (4 >= mLevel) {
            display(str + exc);
        }
    }

    public static void i(String str, Object... objArr) {
        if (2 >= mLevel) {
            if (objArr.length == 0) {
                display(str);
            } else {
                display(String.format(str, objArr));
            }
        }
    }

    public static void w(String str, Object... objArr) {
        if (3 >= mLevel) {
            if (objArr.length == 0) {
                display(str);
            } else {
                display(String.format(str, objArr));
            }
        }
    }

    public static void e(Exception exc) {
        if (4 >= mLevel) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter((Writer) stringWriter, true));
            display(stringWriter.toString());
        }
    }
}
