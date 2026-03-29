package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static String[] u(File file) {
        String[] strArrU = com.bytedance.pangle.util.u.nr.u(file);
        return TextUtils.isEmpty(strArrU[0]) ? com.bytedance.pangle.util.u.u.u(file) : strArrU;
    }
}
