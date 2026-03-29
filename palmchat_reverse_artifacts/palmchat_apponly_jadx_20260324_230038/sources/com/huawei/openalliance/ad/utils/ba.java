package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ba {
    private static final List<String> Code = new ArrayList();

    public static void Code(Context context) {
        List<String> list = Code;
        list.clear();
        list.add(az.Z(context));
        list.add(az.V(context));
        list.add(az.B(context));
        list.add(az.I(context));
    }

    public static boolean Code(String str) {
        List<String> list = Code;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }
}
