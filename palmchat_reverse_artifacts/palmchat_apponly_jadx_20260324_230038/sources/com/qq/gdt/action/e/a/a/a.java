package com.qq.gdt.action.e.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static String a(String str) {
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/cat", str});
            String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            if (line != null) {
                return line.trim();
            }
            processExec.waitFor();
            int iExitValue = processExec.exitValue();
            if (iExitValue == 0) {
                return "get cat error";
            }
            System.err.println("命令执行失败，退出值: " + iExitValue);
            return "get cat error";
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "get cat error";
        }
    }
}
