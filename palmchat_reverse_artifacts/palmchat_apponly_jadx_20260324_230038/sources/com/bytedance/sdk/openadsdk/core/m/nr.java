package com.bytedance.sdk.openadsdk.core.m;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private ConcurrentHashMap<String, Object> u = new ConcurrentHashMap<>();

    private String nr(String str, String str2) {
        return (str == null || !this.u.containsKey(str)) ? str2 : (String) this.u.get(str);
    }

    public void u(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.u.put(str, str2);
    }

    public String u(String str) {
        return nr(str, "");
    }

    public int nr(String str) {
        return nr(str, 0);
    }

    public void u(String str, int i) {
        if (str != null) {
            this.u.put(str, Integer.valueOf(i));
        }
    }

    private int nr(String str, int i) {
        return (str == null || !this.u.containsKey(str)) ? i : ((Integer) this.u.get(str)).intValue();
    }
}
