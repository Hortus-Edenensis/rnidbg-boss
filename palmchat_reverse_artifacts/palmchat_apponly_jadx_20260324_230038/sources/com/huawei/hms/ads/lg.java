package com.huawei.hms.ads;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class lg {
    private String Code;
    private Boolean I;
    private Boolean V;
    private List<String> Z;

    public lg() {
        Boolean bool = Boolean.TRUE;
        this.V = bool;
        this.I = bool;
    }

    public String Code() {
        return this.Code;
    }

    public Boolean I() {
        return this.I;
    }

    public Boolean V() {
        return this.V;
    }

    public List<String> Z() {
        return this.Z;
    }

    public void Code(Boolean bool) {
        this.V = bool;
    }

    public void V(Boolean bool) {
        this.I = bool;
    }

    public void Code(String str) {
        this.Code = str;
    }

    public void Code(List<String> list) {
        this.Z = list;
    }
}
