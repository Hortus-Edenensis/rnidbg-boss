package com.xiaomi.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.xiaomi.push.do, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class Cdo {

    /* JADX INFO: renamed from: com.xiaomi.push.do$a */
    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f272a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f273b;
        private boolean d;
        private boolean e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11511a = 0;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f274c = false;
        private int b = 0;
        private boolean f = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f271a = Collections.emptyList();
        private int c = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m301b() {
            return this.f274c;
        }

        public int c() {
            return this.f11511a;
        }

        public int d() {
            return this.b;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m304e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m300a() {
            return this.f272a;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m302c() {
            return this.f273b;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m303d() {
            return this.d;
        }

        public int e() {
            return this.f271a.size();
        }

        public a a(int i) {
            this.f272a = true;
            this.f11511a = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        public a a(boolean z) {
            this.f273b = true;
            this.f274c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = 0;
            int iB = m300a() ? c.b(1, c()) + 0 : 0;
            if (m302c()) {
                iB += c.a(2, m301b());
            }
            if (m303d()) {
                iB += c.a(3, d());
            }
            if (f()) {
                iB += c.a(4, m304e());
            }
            Iterator<String> it = m299a().iterator();
            while (it.hasNext()) {
                iA += c.a(it.next());
            }
            int size = iB + iA + (m299a().size() * 1);
            this.c = size;
            return size;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public List<String> m299a() {
            return this.f271a;
        }

        public a a(String str) {
            str.getClass();
            if (this.f271a.isEmpty()) {
                this.f271a = new ArrayList();
            }
            this.f271a.add(str);
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) throws IOException {
            if (m300a()) {
                cVar.m235b(1, c());
            }
            if (m302c()) {
                cVar.m227a(2, m301b());
            }
            if (m303d()) {
                cVar.m222a(3, d());
            }
            if (f()) {
                cVar.m227a(4, m304e());
            }
            Iterator<String> it = m299a().iterator();
            while (it.hasNext()) {
                cVar.m226a(5, it.next());
            }
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) throws d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 8) {
                    a(bVar.c());
                } else if (iM186a == 16) {
                    a(bVar.m192a());
                } else if (iM186a == 24) {
                    b(bVar.m195b());
                } else if (iM186a == 32) {
                    b(bVar.m192a());
                } else if (iM186a != 42) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    a(bVar.m189a());
                }
            }
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
