package com.tencent.turingfd.sdk.ams.ad;

import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cepheus {
    public static String a(String str) {
        int iIndexOf;
        String[] strArrSplit = str.split(" ", 3);
        if (strArrSplit.length <= 2 || !"rwxp".equals(strArrSplit[1]) || (iIndexOf = strArrSplit[2].indexOf(47)) == -1) {
            return null;
        }
        String strTrim = strArrSplit[2].substring(iIndexOf).trim();
        if (strTrim.startsWith("/data/")) {
            return null;
        }
        return strArrSplit[1] + x.aQ + strTrim;
    }
}
