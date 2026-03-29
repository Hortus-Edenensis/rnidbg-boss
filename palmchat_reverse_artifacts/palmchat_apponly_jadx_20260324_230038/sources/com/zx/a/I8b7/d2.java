package com.zx.a.I8b7;

import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d2 implements Comparator<String> {
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        return str.compareTo(str2) > 0 ? 1 : -1;
    }
}
