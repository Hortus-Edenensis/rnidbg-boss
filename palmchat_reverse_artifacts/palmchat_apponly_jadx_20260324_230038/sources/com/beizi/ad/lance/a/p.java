package com.beizi.ad.lance.a;

import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class p {
    public static boolean a(int i) {
        float fNextInt = new Random().nextInt(100);
        m.c("BeiZisAd", "ratio = " + fNextInt + ",ratioCheckNum = " + i);
        return fNextInt < ((float) i);
    }
}
