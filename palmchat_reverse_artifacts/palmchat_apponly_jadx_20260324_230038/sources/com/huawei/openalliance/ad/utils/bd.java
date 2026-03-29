package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class bd {
    private static final String Code = "SwUt";

    public static Integer Code(String str, int i) {
        return Code(str, i, 0);
    }

    private static Integer V(String str, int i) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            try {
                return Integer.valueOf(Integer.parseInt(str.substring(i, i + 1)));
            } catch (RuntimeException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("getSwh ");
                sb.append(e.getClass().getSimpleName());
                fh.I(Code, sb.toString());
                return null;
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("getSwh ");
                sb.append(e.getClass().getSimpleName());
                fh.I(Code, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static Integer Code(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || i2 < 0) {
            return null;
        }
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length < i2 + 1) {
            return null;
        }
        return V(strArrSplit[i2], i);
    }
}
