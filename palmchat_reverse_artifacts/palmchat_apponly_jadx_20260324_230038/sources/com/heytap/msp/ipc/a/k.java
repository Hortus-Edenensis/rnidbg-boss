package com.heytap.msp.ipc.a;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class k {
    public static <E> String a(List<E> list) {
        return a(list, ",");
    }

    public static <E> String a(List<E> list, String str) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) != null ? list.get(i).toString() : "");
            if (i < list.size() - 1) {
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
