package com.opos.process.bridge.b;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10380a;
    private String b;
    private Bundle c;
    private String d;
    private IBridgeTargetIdentify e;
    private int f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f10381a;
        private String b;
        private Bundle c;
        private String d;
        private IBridgeTargetIdentify e;
        private int f;

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(Context context) {
            this.f10381a = context;
            return this;
        }

        public a a(Bundle bundle) {
            this.c = bundle;
            return this;
        }

        public a a(IBridgeTargetIdentify iBridgeTargetIdentify) {
            this.e = iBridgeTargetIdentify;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public d a() {
            return new d(this.f10381a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public d(Context context, String str, Bundle bundle, String str2, IBridgeTargetIdentify iBridgeTargetIdentify, int i) {
        this.f10380a = context;
        this.b = str;
        this.c = bundle;
        this.d = str2;
        this.e = iBridgeTargetIdentify;
        this.f = i;
    }

    public Context a() {
        return this.f10380a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public IBridgeTargetIdentify d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }
}
