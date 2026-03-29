package com.getui.gtc.base.log.c;

import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.getui.gtc.base.log.ILogDestination;
import com.getui.gtc.base.log.ILogFormatter;
import com.getui.gtc.base.util.CommonUtil;
import com.oplus.tblplayer.Constants;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements ILogFormatter {
    private final ILogDestination c;
    private String e;
    private final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5700a = "";
    public int b = 8;

    public a(ILogDestination iLogDestination) {
        this.e = "";
        this.c = (ILogDestination) com.getui.gtc.base.log.e.a.a(iLogDestination);
        this.e = CommonUtil.getProcessName();
    }

    private String a() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.b];
            String className = stackTraceElement.getClassName();
            return String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (Throwable unused) {
            return "";
        }
    }

    private String b() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.b];
            String className = stackTraceElement.getClassName();
            return String.format("(%s:%d)", className.substring(className.lastIndexOf(".") + 1) + ".java", Integer.valueOf(stackTraceElement.getLineNumber()));
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.getui.gtc.base.log.ILogFormatter
    public final void log(int i, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.format(new Date()));
        sb.append(" ");
        sb.append(Process.myPid());
        sb.append("/");
        sb.append(this.e);
        sb.append(" ");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? Constants.STRING_VALUE_UNSET : ExifInterface.LONGITUDE_EAST : "W" : "I" : "D" : ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        sb.append("/");
        String strA = a();
        String str3 = TextUtils.isEmpty(str) ? this.f5700a : str;
        if (!TextUtils.isEmpty(str3)) {
            strA = str3 + "-" + strA;
        }
        sb.append(strA);
        sb.append(": ");
        sb.append(a(str2, th));
        String string = sb.toString();
        if (!string.endsWith("\n")) {
            string = string + "\n";
        }
        this.c.log(i, str, string);
    }

    private String a(String str, Throwable th) {
        if (th != null && str != null) {
            str = str + " : " + a(th);
        }
        if (th != null && str == null) {
            str = a(th);
        }
        if (TextUtils.isEmpty(str)) {
            str = "Empty/NULL log message";
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("{") && strTrim.endsWith("}")) {
            try {
                strTrim = new JSONObject(strTrim).toString(2);
            } catch (Throwable unused) {
            }
        }
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            try {
                strTrim = new JSONArray(strTrim).toString(2);
            } catch (Throwable unused2) {
            }
        }
        String strB = b();
        if (th != null) {
            return strTrim;
        }
        return strTrim + " " + strB;
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter((OutputStream) byteArrayOutputStream, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }
}
