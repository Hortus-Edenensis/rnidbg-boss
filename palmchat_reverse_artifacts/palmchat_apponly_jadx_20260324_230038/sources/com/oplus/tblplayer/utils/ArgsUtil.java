package com.oplus.tblplayer.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ArgsUtil {
    public static <T> T safeGet(Object[] objArr, int i) {
        if (objArr == null || objArr.length <= i) {
            return null;
        }
        return (T) objArr[i];
    }
}
