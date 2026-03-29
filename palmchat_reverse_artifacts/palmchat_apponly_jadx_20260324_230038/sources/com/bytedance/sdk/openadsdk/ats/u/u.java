package com.bytedance.sdk.openadsdk.ats.u;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.t;
import com.bytedance.sdk.component.utils.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements t {
    @SuppressLint({"[ByDesign12.1]UsingRuntimeExec"})
    private String u(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        k.u("SystemPropAdb", "Exception while closing InputStream", e);
                    }
                    try {
                        processExec.destroy();
                    } catch (Throwable unused) {
                    }
                    return line;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        k.u("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                k.u("SystemPropAdb", "Exception while closing InputStream", e2);
                            }
                        }
                        if (processExec == null) {
                            return "";
                        }
                        try {
                            processExec.destroy();
                            return "";
                        } catch (Throwable unused2) {
                            return "";
                        }
                    } finally {
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
    }

    @Override // com.bytedance.sdk.component.b.t
    public String get(String str) {
        return u(str);
    }

    @Override // com.bytedance.sdk.component.b.t
    public boolean getBoolean(String str) {
        String strU = u(str);
        if (TextUtils.isEmpty(strU)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(strU);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.b.t
    public int getInt(String str) {
        String strU = u(str);
        if (TextUtils.isEmpty(strU)) {
            return 0;
        }
        try {
            return Integer.parseInt(strU);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.b.t
    public long getLong(String str) {
        String strU = u(str);
        if (TextUtils.isEmpty(strU)) {
            return 0L;
        }
        try {
            return Long.parseLong(strU);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.b.t
    public void set(String str, String str2) {
    }
}
