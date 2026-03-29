package com.wifi.open.sec;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public final class SystemUserUtil {
    public static List<String> DataDirectories() {
        ArrayList arrayList = new ArrayList();
        try {
            String strGetCurrentUser = GetCurrentUser(c.b());
            if (!TextUtils.isEmpty(strGetCurrentUser)) {
                String strRunCommand = RunCommand("ps");
                if (!TextUtils.isEmpty(strRunCommand)) {
                    String[] strArrSplit = strRunCommand.split("\n");
                    if (strArrSplit.length > 0) {
                        for (String str : strArrSplit) {
                            if (str.contains(strGetCurrentUser)) {
                                int iLastIndexOf = str.lastIndexOf(" ");
                                String strSubstring = str.substring(iLastIndexOf <= 0 ? 0 : iLastIndexOf + 1, str.length());
                                if (!TextUtils.isEmpty(strSubstring) && new File(String.format("/data/data/%s", strSubstring)).exists()) {
                                    arrayList.add(strSubstring);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x000d, B:8:0x001d, B:9:0x0021, B:11:0x0031, B:14:0x0038, B:23:0x0051, B:17:0x0040, B:20:0x004b), top: B:35:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String GetCurrentUser(Context context) throws Throwable {
        boolean z;
        int iIntValue = 0;
        try {
            String strRunCommand = RunCommand("cat /proc/self/cgroup");
            if (!TextUtils.isEmpty(strRunCommand)) {
                int iLastIndexOf = strRunCommand.lastIndexOf(DeviceInfoUtil.UID_TAG);
                int iLastIndexOf2 = strRunCommand.lastIndexOf("/pid");
                if (iLastIndexOf >= 0) {
                    if (iLastIndexOf2 <= 0) {
                        iLastIndexOf2 = strRunCommand.length();
                    }
                    String strReplaceAll = strRunCommand.substring(iLastIndexOf + 4, iLastIndexOf2).replaceAll("\n", "");
                    if (strReplaceAll == null || strReplaceAll.length() == 0) {
                        z = false;
                        if (z) {
                            iIntValue = Integer.valueOf(strReplaceAll).intValue();
                        }
                    } else {
                        for (int i = 0; i < strReplaceAll.length(); i++) {
                            if (!Character.isDigit(strReplaceAll.charAt(i))) {
                                z = false;
                                break;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (iIntValue == 0 && context != null) {
            try {
                iIntValue = context.getApplicationInfo().uid;
            } catch (Exception unused2) {
            }
        }
        if (iIntValue == 0) {
            return null;
        }
        return GetUser(iIntValue);
    }

    private static String GetUser(int i) {
        Method method;
        if (Build.VERSION.SDK_INT > 27) {
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(i - 10000));
        }
        try {
            Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(null);
            if (obj == null || (method = obj.getClass().getMethod("getpwuid", Integer.TYPE)) == null) {
                return null;
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            Object objInvoke = method.invoke(obj, Integer.valueOf(i));
            if (objInvoke == null) {
                return null;
            }
            Field declaredField2 = objInvoke.getClass().getDeclaredField("pw_name");
            if (!declaredField2.isAccessible()) {
                declaredField2.setAccessible(true);
            }
            return (String) declaredField2.get(objInvoke);
        } catch (Exception unused) {
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(i - 10000));
        }
    }

    private static String RunCommand(String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        DataInputStream dataInputStream = null;
        try {
            Process processExec = Runtime.getRuntime().exec(str);
            DataInputStream dataInputStream2 = new DataInputStream(processExec.getInputStream());
            while (true) {
                try {
                    String line = dataInputStream2.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } catch (Exception unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream == null) {
                        return sb.toString();
                    }
                    try {
                        dataInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return sb.toString();
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            processExec.waitFor();
            try {
                dataInputStream2.close();
            } catch (IOException unused4) {
            }
            return sb.toString();
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
