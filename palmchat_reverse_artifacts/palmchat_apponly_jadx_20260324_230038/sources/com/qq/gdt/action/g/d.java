package com.qq.gdt.action.g;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {
    public static boolean a(String str, int i) {
        if (com.qq.gdt.action.d.a().g() == null) {
            return false;
        }
        int iE = com.qq.gdt.action.b.a(com.qq.gdt.action.d.a().g()).e();
        if (iE == 0) {
            if (str != null) {
                return !"TICKET".equals(str);
            }
            return true;
        }
        if (iE == 2) {
            return false;
        }
        if (iE != 4 || Arrays.asList(4000, 9001, 9002, 9003).contains(Integer.valueOf(i)) || str == null) {
            return true;
        }
        return !"TICKET".equals(str);
    }
}
