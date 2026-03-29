package com.lantern.daemon.doubleprocess;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.lantern.daemon.doubleprocess.c;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7533a;

    public a(b bVar) {
        this.f7533a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/cmdline"));
                try {
                    String line = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(line)) {
                        line = line.trim();
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return line;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
    }

    public final void b(Context context) throws Throwable {
        if (this.f7533a == null) {
            return;
        }
        String strA = a();
        String packageName = context.getPackageName();
        c cVarA = c.a.a();
        if (cVarA != null) {
            if (strA.startsWith(this.f7533a.f7534a.f7535a)) {
                cVarA.b(context, this.f7533a);
            } else if (strA.startsWith(this.f7533a.b.f7535a)) {
                cVarA.a(context, this.f7533a);
            } else if (strA.startsWith(packageName)) {
                cVarA.c(context);
            }
        }
    }

    public void c(Context context) {
        b(context);
    }
}
