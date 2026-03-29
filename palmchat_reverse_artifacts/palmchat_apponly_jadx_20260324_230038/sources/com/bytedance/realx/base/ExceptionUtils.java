package com.bytedance.realx.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ExceptionUtils {
    public static String stackTrace(Throwable th) {
        th.printStackTrace(new PrintWriter(new StringWriter()));
        return th.toString();
    }
}
