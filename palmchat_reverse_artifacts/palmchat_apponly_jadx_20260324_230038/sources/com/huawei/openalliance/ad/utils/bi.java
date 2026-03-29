package com.huawei.openalliance.ad.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class bi {
    public static boolean Code(long j) {
        if (j == 0) {
            return false;
        }
        return Code("yyyy-MM-dd", j);
    }

    private static boolean Code(String str, long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }
}
