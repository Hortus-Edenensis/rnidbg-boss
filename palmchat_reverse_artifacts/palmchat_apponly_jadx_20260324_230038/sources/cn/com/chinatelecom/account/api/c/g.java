package cn.com.chinatelecom.account.api.c;

import android.net.Network;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Network f2046a;
    public int b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    public Map<String, String> i;
    private int j;
    private int k;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2047a;
        private int b;
        private Network c;
        private int d;
        private String e;
        private String f;
        private boolean g;
        private boolean h;
        private String i;
        private String j;
        private Map<String, String> k;

        public a a(int i) {
            this.f2047a = i;
            return this;
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public a a(Network network) {
            this.c = network;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a a(boolean z) {
            this.g = z;
            return this;
        }

        public a a(boolean z, String str, String str2) {
            this.h = z;
            this.i = str;
            this.j = str2;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public g(a aVar) {
        this.j = aVar.f2047a;
        this.k = aVar.b;
        this.f2046a = aVar.c;
        this.b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.h = aVar.j;
        this.i = aVar.k;
    }

    public int a() {
        int i = this.j;
        if (i > 0) {
            return i;
        }
        return 3000;
    }

    public int b() {
        int i = this.k;
        if (i > 0) {
            return i;
        }
        return 3000;
    }
}
