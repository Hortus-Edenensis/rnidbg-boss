package com.lantern.daemon.dp3.utils;

import android.os.Build;
import android.util.AndroidRuntimeException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ShellUtils {
    public static String exec(File file, Map map, String[] strArr) {
        String path;
        String str = System.getenv("PATH");
        if (str == null || str.length() <= 0) {
            path = null;
        } else {
            for (String str2 : str.split(":")) {
                File file2 = new File(str2, "sh");
                if (file2.exists()) {
                    path = file2.getPath();
                    break;
                }
            }
            path = null;
        }
        if (path == null) {
            throw new RuntimeException("The devices(" + Build.MODEL + ") has not shell " + path);
        }
        try {
            ProcessBuilder processBuilderRedirectErrorStream = new ProcessBuilder(new String[0]).command(path).redirectErrorStream(true);
            if (file != null) {
                processBuilderRedirectErrorStream.directory(file);
            }
            try {
                processBuilderRedirectErrorStream.environment().putAll(System.getenv());
                if (map != null && map.size() > 0) {
                    processBuilderRedirectErrorStream.environment().putAll(map);
                }
            } catch (Exception unused) {
            }
            try {
                Process processStart = processBuilderRedirectErrorStream.start();
                OutputStream outputStream = processStart.getOutputStream();
                new BufferedReader(new InputStreamReader(processStart.getInputStream(), "utf-8"));
                new BufferedReader(new InputStreamReader(processStart.getErrorStream(), "utf-8"));
                for (String str3 : strArr) {
                    if (!str3.endsWith("\n")) {
                        str3 = str3 + "\n";
                    }
                    outputStream.write(str3.getBytes());
                    outputStream.flush();
                }
                outputStream.write("exit 156\n".getBytes());
                outputStream.flush();
                outputStream.close();
                processStart.waitFor();
                return "";
            } catch (Exception unused2) {
                return "";
            }
        } catch (Exception e) {
            throw new AndroidRuntimeException(e);
        }
    }
}
