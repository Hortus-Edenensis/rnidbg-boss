package com.baidu.mapauto.auth.org.spongycastle.util;

import com.huawei.hms.ads.ex;
import java.security.AccessControlException;
import java.security.AccessController;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f3916a = new ThreadLocal();

    public static boolean a() {
        try {
            String str = (String) AccessController.doPrivileged(new b());
            if (str == null) {
                return false;
            }
            int i = d.f3917a;
            char[] charArray = str.toCharArray();
            boolean z = false;
            for (int i2 = 0; i2 != charArray.length; i2++) {
                char c = charArray[i2];
                if ('A' <= c && 'Z' >= c) {
                    charArray[i2] = (char) ((c - 'A') + 97);
                    z = true;
                }
            }
            if (z) {
                str = new String(charArray);
            }
            return ex.Code.equals(str);
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
