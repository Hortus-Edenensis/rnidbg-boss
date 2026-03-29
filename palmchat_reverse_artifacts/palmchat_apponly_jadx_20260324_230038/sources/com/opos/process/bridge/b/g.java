package com.opos.process.bridge.b;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, Object> f10382a;
    private Context b;
    private String c;
    private Bundle d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f10383a = null;
        private String b = "";
        private String c = "";
        private Bundle d = null;
        private Map<String, Object> e = null;

        public a a(Context context) {
            this.f10383a = context;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(Bundle bundle) {
            this.d = bundle;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.e = map;
            return this;
        }

        public g a() {
            return new g(this.f10383a, this.b, this.d, this.e);
        }
    }

    public g(Context context, String str, Bundle bundle, Map<String, Object> map) {
        this.b = context;
        this.c = str;
        this.d = bundle;
        this.f10382a = map;
    }
}
