package com.qq.gdt.action.e.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0053, code lost:
    
        r5.waitFor();
        r5 = r5.exitValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
    
        if (r5 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005c, code lost:
    
        java.lang.System.err.println("命令执行失败，退出值: " + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        BufferedReader bufferedReader;
        System.currentTimeMillis();
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/stat", "-c", "%i", str});
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            try {
                return Long.parseLong(line.trim()) + " ";
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            return "";
        }
    }
}
