package com.wifi.ad.core.utils;

import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MyComparator implements Comparator<Integer> {
    @Override // java.util.Comparator
    public int compare(Integer num, Integer num2) {
        if (num.intValue() > num2.intValue()) {
            return -1;
        }
        return num.intValue() < num2.intValue() ? 1 : 0;
    }
}
