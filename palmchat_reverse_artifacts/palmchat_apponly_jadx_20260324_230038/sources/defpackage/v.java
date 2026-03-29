package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f21331a = 0;
    public static int b = 1;
    public static OutputStream c;
    public static Logger d = Logger.getLogger("CxALog");

    public static void a(String str, Object... objArr) {
        if (1 >= f21331a) {
            if (objArr.length == 0) {
                b(str);
            } else {
                b(String.format(str, objArr));
            }
        }
    }

    public static void b(String str) {
        StackTraceElement stackTraceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
        String str2 = String.format("[%s,%d,%s] %s", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), stackTraceElement.getMethodName(), str);
        int i = b;
        if (i == 1) {
            d.warning(str2);
            return;
        }
        if (i == 2 && c != null) {
            try {
                byte[] bytes = str2.getBytes("utf-8");
                c.write(bytes, 0, bytes.length);
                if (str2.endsWith("\n")) {
                    return;
                }
                c.write("\n".getBytes());
            } catch (IOException e) {
                d.warning(e.getMessage());
            }
        }
    }

    public static void c(Exception exc) {
        if (4 >= f21331a) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter((Writer) stringWriter, true));
            b(stringWriter.toString());
        }
    }

    public static void d(String str) {
        if (4 >= f21331a) {
            b(str);
        }
    }

    public static void e(String str, Exception exc) {
        if (4 >= f21331a) {
            b(str + exc);
        }
    }

    public static void f(String str) {
        if (2 >= f21331a) {
            b(str);
        }
    }

    public static void g(String str, Object... objArr) {
        if (2 >= f21331a) {
            if (objArr.length == 0) {
                b(str);
            } else {
                b(String.format(str, objArr));
            }
        }
    }

    public static void h(String str) {
        if (3 >= f21331a) {
            b(str);
        }
    }
}
