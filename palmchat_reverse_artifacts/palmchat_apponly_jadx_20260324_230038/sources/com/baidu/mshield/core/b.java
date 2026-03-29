package com.baidu.mshield.core;

import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4029a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        try {
            char[] charArray = f4029a.toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[new Random().nextInt(62)];
            }
            return new String(cArr).getBytes();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return new byte[0];
        }
    }
}
