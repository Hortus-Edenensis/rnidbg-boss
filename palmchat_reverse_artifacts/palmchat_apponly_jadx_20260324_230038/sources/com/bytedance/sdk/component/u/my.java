package com.bytedance.sdk.component.u;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my {
    public final String b;
    public final String fx;
    public final String iz;
    public final String n;
    public final String nr;
    public final String pn;
    public final int u;
    public final String x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private String b;
        private String fx;
        private String iz;
        private String nr;
        private String pn;
        private String u;
        private String x;

        private u() {
        }

        public u b(String str) {
            this.b = str;
            return this;
        }

        public u fx(String str) {
            this.fx = str;
            return this;
        }

        public u iz(String str) {
            this.iz = str;
            return this;
        }

        public u nr(String str) {
            this.nr = str;
            return this;
        }

        public u pn(String str) {
            this.pn = str;
            return this;
        }

        public u u(String str) {
            this.u = str;
            return this;
        }

        public u x(String str) {
            this.x = str;
            return this;
        }

        public my u() {
            return new my(this);
        }
    }

    public static u u() {
        return new u();
    }

    public String toString() {
        return "methodName: " + this.b + ", params: " + this.pn + ", callbackId: " + this.iz + ", type: " + this.fx + ", version: " + this.nr + ", ";
    }

    private my(String str, int i) {
        this.nr = null;
        this.fx = null;
        this.b = null;
        this.pn = null;
        this.iz = str;
        this.x = null;
        this.u = i;
        this.n = null;
    }

    public static my u(String str, int i) {
        return new my(str, i);
    }

    public static boolean u(my myVar) {
        return myVar == null || myVar.u != 1 || TextUtils.isEmpty(myVar.b) || TextUtils.isEmpty(myVar.pn);
    }

    private my(u uVar) {
        this.nr = uVar.u;
        this.fx = uVar.nr;
        this.b = uVar.fx;
        this.pn = uVar.b;
        this.iz = uVar.pn;
        this.x = uVar.iz;
        this.u = 1;
        this.n = uVar.x;
    }
}
