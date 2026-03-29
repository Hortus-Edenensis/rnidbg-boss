package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class dp {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f277a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f280b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f283c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f285d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private boolean f287e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        private boolean f288f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11512a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private long f275a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f276a = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f279b = "";

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private String f282c = "";

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private String f284d = "";

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private String f286e = "";
        private int b = 1;
        private int c = 0;
        private int d = 0;
        private String f = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private long f278b = 0;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private long f281c = 0;
        private int e = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m311b() {
            return this.f280b;
        }

        public int c() {
            return this.f11512a;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m316d() {
            return this.f285d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m318e() {
            return this.f287e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public boolean m320f() {
            return this.f288f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m308a() {
            return this.f277a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m310b() {
            return this.f279b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m314c() {
            return this.f283c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public String m315d() {
            return this.f284d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public String m317e() {
            return this.f286e;
        }

        public int f() {
            return this.d;
        }

        public a a(int i) {
            this.f277a = true;
            this.f11512a = i;
            return this;
        }

        public a b(String str) {
            this.f285d = true;
            this.f279b = str;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public String m313c() {
            return this.f282c;
        }

        public a d(String str) {
            this.f288f = true;
            this.f284d = str;
            return this;
        }

        public a e(String str) {
            this.g = true;
            this.f286e = str;
            return this;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public String m319f() {
            return this.f;
        }

        public a c(String str) {
            this.f287e = true;
            this.f282c = str;
            return this;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public long m305a() {
            return this.f275a;
        }

        public a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        public a a(long j) {
            this.f280b = true;
            this.f275a = j;
            return this;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public long m309b() {
            return this.f278b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m307a() {
            return this.f276a;
        }

        public a b(long j) {
            this.l = true;
            this.f278b = j;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public long m312c() {
            return this.f281c;
        }

        public a a(String str) {
            this.f283c = true;
            this.f276a = str;
            return this;
        }

        public a c(long j) {
            this.m = true;
            this.f281c = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m308a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m311b()) {
                iA += com.xiaomi.push.c.b(2, m305a());
            }
            if (m314c()) {
                iA += com.xiaomi.push.c.a(3, m307a());
            }
            if (m316d()) {
                iA += com.xiaomi.push.c.a(4, m310b());
            }
            if (m318e()) {
                iA += com.xiaomi.push.c.a(5, m313c());
            }
            if (m320f()) {
                iA += com.xiaomi.push.c.a(6, m315d());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(7, m317e());
            }
            if (h()) {
                iA += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                iA += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                iA += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                iA += com.xiaomi.push.c.a(11, m319f());
            }
            if (l()) {
                iA += com.xiaomi.push.c.b(12, m309b());
            }
            if (m()) {
                iA += com.xiaomi.push.c.b(13, m312c());
            }
            this.e = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public a m306a() {
            this.f288f = false;
            this.f284d = "";
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m308a()) {
                cVar.m222a(1, c());
            }
            if (m311b()) {
                cVar.m236b(2, m305a());
            }
            if (m314c()) {
                cVar.m226a(3, m307a());
            }
            if (m316d()) {
                cVar.m226a(4, m310b());
            }
            if (m318e()) {
                cVar.m226a(5, m313c());
            }
            if (m320f()) {
                cVar.m226a(6, m315d());
            }
            if (g()) {
                cVar.m226a(7, m317e());
            }
            if (h()) {
                cVar.m222a(8, d());
            }
            if (i()) {
                cVar.m222a(9, e());
            }
            if (j()) {
                cVar.m222a(10, f());
            }
            if (k()) {
                cVar.m226a(11, m319f());
            }
            if (l()) {
                cVar.m236b(12, m309b());
            }
            if (m()) {
                cVar.m236b(13, m312c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                switch (iM186a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m195b());
                        break;
                    case 16:
                        a(bVar.m196b());
                        break;
                    case 26:
                        a(bVar.m189a());
                        break;
                    case 34:
                        b(bVar.m189a());
                        break;
                    case 42:
                        c(bVar.m189a());
                        break;
                    case 50:
                        d(bVar.m189a());
                        break;
                    case 58:
                        e(bVar.m189a());
                        break;
                    case 64:
                        b(bVar.m195b());
                        break;
                    case 72:
                        c(bVar.m195b());
                        break;
                    case 80:
                        d(bVar.m195b());
                        break;
                    case 90:
                        f(bVar.m189a());
                        break;
                    case 96:
                        b(bVar.m196b());
                        break;
                    case 104:
                        c(bVar.m196b());
                        break;
                    default:
                        if (!a(bVar, iM186a)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f289a;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f291c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f292d;
        private boolean e;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f290b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11513a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m322b() {
            return this.f289a;
        }

        public int c() {
            return this.f11513a;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m321a() {
            return this.f290b;
        }

        public b b(int i) {
            this.f292d = true;
            this.b = i;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m323c() {
            return this.f291c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m324d() {
            return this.f292d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m325e() {
            return this.e;
        }

        public b a(boolean z) {
            this.f289a = true;
            this.f290b = z;
            return this;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m322b() ? 0 + com.xiaomi.push.c.a(1, m321a()) : 0;
            if (m323c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m324d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m325e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            this.d = iA;
            return iA;
        }

        public b a(int i) {
            this.f291c = true;
            this.f11513a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m322b()) {
                cVar.m227a(1, m321a());
            }
            if (m323c()) {
                cVar.m222a(3, c());
            }
            if (m324d()) {
                cVar.m222a(4, d());
            }
            if (m325e()) {
                cVar.m222a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 8) {
                    a(bVar.m192a());
                } else if (iM186a == 24) {
                    a(bVar.m195b());
                } else if (iM186a == 32) {
                    b(bVar.m195b());
                } else if (iM186a != 40) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    c(bVar.m195b());
                }
            }
        }

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f294a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f295b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f296c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f297d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private boolean f298e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        private boolean f299f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f293a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11514a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m328b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m326a() {
            return this.f293a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m329b() {
            return this.f295b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m330c() {
            return this.f296c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m331d() {
            return this.f297d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m332e() {
            return this.f298e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public boolean m333f() {
            return this.f299f;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m327a() {
            return this.f294a;
        }

        public c b(String str) {
            this.f295b = true;
            this.b = str;
            return this;
        }

        public c c(String str) {
            this.f296c = true;
            this.c = str;
            return this;
        }

        public c d(String str) {
            this.f297d = true;
            this.d = str;
            return this;
        }

        public c e(String str) {
            this.f298e = true;
            this.e = str;
            return this;
        }

        public c f(String str) {
            this.f299f = true;
            this.f = str;
            return this;
        }

        public c a(String str) {
            this.f294a = true;
            this.f293a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m327a() ? 0 + com.xiaomi.push.c.a(1, m326a()) : 0;
            if (m329b()) {
                iA += com.xiaomi.push.c.a(2, m328b());
            }
            if (m330c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m331d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m332e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (m333f()) {
                iA += com.xiaomi.push.c.a(6, f());
            }
            this.f11514a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m327a()) {
                cVar.m226a(1, m326a());
            }
            if (m329b()) {
                cVar.m226a(2, m328b());
            }
            if (m330c()) {
                cVar.m226a(3, c());
            }
            if (m331d()) {
                cVar.m226a(4, d());
            }
            if (m332e()) {
                cVar.m226a(5, e());
            }
            if (m333f()) {
                cVar.m226a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f11514a < 0) {
                b();
            }
            return this.f11514a;
        }

        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 10) {
                    a(bVar.m189a());
                } else if (iM186a == 18) {
                    b(bVar.m189a());
                } else if (iM186a == 26) {
                    c(bVar.m189a());
                } else if (iM186a == 34) {
                    d(bVar.m189a());
                } else if (iM186a == 42) {
                    e(bVar.m189a());
                } else if (iM186a != 50) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    f(bVar.m189a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f301a;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f303c;
        private boolean d;
        private boolean e;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f302b = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f300a = "";
        private String b = "";
        private String c = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11515a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m337b() {
            return this.f301a;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m338c() {
            return this.f303c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m335a() {
            return this.f302b;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m336b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public d a(boolean z) {
            this.f301a = true;
            this.f302b = z;
            return this;
        }

        public d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        public d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m334a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m337b() ? 0 + com.xiaomi.push.c.a(1, m335a()) : 0;
            if (m338c()) {
                iA += com.xiaomi.push.c.a(2, m334a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(3, m336b());
            }
            if (e()) {
                iA += com.xiaomi.push.c.a(4, c());
            }
            this.f11515a = iA;
            return iA;
        }

        public d a(String str) {
            this.f303c = true;
            this.f300a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m337b()) {
                cVar.m227a(1, m335a());
            }
            if (m338c()) {
                cVar.m226a(2, m334a());
            }
            if (d()) {
                cVar.m226a(3, m336b());
            }
            if (e()) {
                cVar.m226a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f11515a < 0) {
                b();
            }
            return this.f11515a;
        }

        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 8) {
                    a(bVar.m192a());
                } else if (iM186a == 18) {
                    a(bVar.m189a());
                } else if (iM186a == 26) {
                    b(bVar.m189a());
                } else if (iM186a != 34) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    c(bVar.m189a());
                }
            }
        }

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f304a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f307a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private com.xiaomi.push.a f308b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f310b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f312c;
        private int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private boolean f314d;
        private int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private boolean f316e;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        private boolean f317f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11516a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f306a = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f309b = "";

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private String f311c = "";
        private int b = 0;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        private String f313d = "";

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        private String f315e = "";
        private String f = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private b f305a = null;
        private int c = 0;

        public e() {
            com.xiaomi.push.a aVar = com.xiaomi.push.a.f11396a;
            this.f304a = aVar;
            this.f308b = aVar;
            this.d = 0;
            this.e = -1;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m345b() {
            return this.f310b;
        }

        public int c() {
            return this.f11516a;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m349d() {
            return this.f314d;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m351e() {
            return this.f316e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public boolean m353f() {
            return this.f317f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m342a() {
            return this.f307a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m344b() {
            return this.f309b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m347c() {
            return this.f312c;
        }

        public int d() {
            return this.b;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public String m350e() {
            return this.f315e;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public String m352f() {
            return this.f;
        }

        public e a(int i) {
            this.f307a = true;
            this.f11516a = i;
            return this;
        }

        public e b(String str) {
            this.f312c = true;
            this.f309b = str;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public String m346c() {
            return this.f311c;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public String m348d() {
            return this.f313d;
        }

        public e e(String str) {
            this.g = true;
            this.f315e = str;
            return this;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public e c(String str) {
            this.f314d = true;
            this.f311c = str;
            return this;
        }

        public e d(String str) {
            this.f317f = true;
            this.f313d = str;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m341a() {
            return this.f306a;
        }

        public e b(int i) {
            this.f316e = true;
            this.b = i;
            return this;
        }

        public int e() {
            return this.c;
        }

        public int f() {
            return this.d;
        }

        public e a(String str) {
            this.f310b = true;
            this.f306a = str;
            return this;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e d(int i) {
            this.m = true;
            this.d = i;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public com.xiaomi.push.a m343b() {
            return this.f308b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public b m340a() {
            return this.f305a;
        }

        public e b(com.xiaomi.push.a aVar) {
            this.l = true;
            this.f308b = aVar;
            return this;
        }

        public e a(b bVar) {
            bVar.getClass();
            this.i = true;
            this.f305a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iB = m342a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m345b()) {
                iB += com.xiaomi.push.c.a(2, m341a());
            }
            if (m347c()) {
                iB += com.xiaomi.push.c.a(3, m344b());
            }
            if (m349d()) {
                iB += com.xiaomi.push.c.a(4, m346c());
            }
            if (m351e()) {
                iB += com.xiaomi.push.c.a(5, d());
            }
            if (m353f()) {
                iB += com.xiaomi.push.c.a(6, m348d());
            }
            if (g()) {
                iB += com.xiaomi.push.c.a(7, m350e());
            }
            if (h()) {
                iB += com.xiaomi.push.c.a(8, m352f());
            }
            if (i()) {
                iB += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m340a());
            }
            if (j()) {
                iB += com.xiaomi.push.c.a(10, e());
            }
            if (k()) {
                iB += com.xiaomi.push.c.a(11, m339a());
            }
            if (l()) {
                iB += com.xiaomi.push.c.a(12, m343b());
            }
            if (m()) {
                iB += com.xiaomi.push.c.a(13, f());
            }
            this.e = iB;
            return iB;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m339a() {
            return this.f304a;
        }

        public e a(com.xiaomi.push.a aVar) {
            this.k = true;
            this.f304a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m342a()) {
                cVar.m235b(1, c());
            }
            if (m345b()) {
                cVar.m226a(2, m341a());
            }
            if (m347c()) {
                cVar.m226a(3, m344b());
            }
            if (m349d()) {
                cVar.m226a(4, m346c());
            }
            if (m351e()) {
                cVar.m222a(5, d());
            }
            if (m353f()) {
                cVar.m226a(6, m348d());
            }
            if (g()) {
                cVar.m226a(7, m350e());
            }
            if (h()) {
                cVar.m226a(8, m352f());
            }
            if (i()) {
                cVar.m225a(9, (com.xiaomi.push.e) m340a());
            }
            if (j()) {
                cVar.m222a(10, e());
            }
            if (k()) {
                cVar.m224a(11, m339a());
            }
            if (l()) {
                cVar.m224a(12, m343b());
            }
            if (m()) {
                cVar.m222a(13, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                switch (iM186a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m189a());
                        break;
                    case 26:
                        b(bVar.m189a());
                        break;
                    case 34:
                        c(bVar.m189a());
                        break;
                    case 40:
                        b(bVar.m195b());
                        break;
                    case 50:
                        d(bVar.m189a());
                        break;
                    case 58:
                        e(bVar.m189a());
                        break;
                    case 66:
                        f(bVar.m189a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m195b());
                        break;
                    case 90:
                        a(bVar.m188a());
                        break;
                    case 98:
                        b(bVar.m188a());
                        break;
                    case 104:
                        d(bVar.m195b());
                        break;
                    default:
                        if (!a(bVar, iM186a)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f320a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f321b;
        private boolean c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f319a = "";
        private String b = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private b f318a = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11517a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m357b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m355a() {
            return this.f319a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m358b() {
            return this.f321b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m356a() {
            return this.f320a;
        }

        public f b(String str) {
            this.f321b = true;
            this.b = str;
            return this;
        }

        public f a(String str) {
            this.f320a = true;
            this.f319a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m356a() ? 0 + com.xiaomi.push.c.a(1, m355a()) : 0;
            if (m358b()) {
                iA += com.xiaomi.push.c.a(2, m357b());
            }
            if (c()) {
                iA += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m354a());
            }
            this.f11517a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public b m354a() {
            return this.f318a;
        }

        public f a(b bVar) {
            bVar.getClass();
            this.c = true;
            this.f318a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m356a()) {
                cVar.m226a(1, m355a());
            }
            if (m358b()) {
                cVar.m226a(2, m357b());
            }
            if (c()) {
                cVar.m225a(3, (com.xiaomi.push.e) m354a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f11517a < 0) {
                b();
            }
            return this.f11517a;
        }

        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 10) {
                    a(bVar.m189a());
                } else if (iM186a == 18) {
                    b(bVar.m189a());
                } else if (iM186a != 26) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f323a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f324b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f325c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f322a = "";
        private String b = "";
        private String c = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11518a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m361b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m359a() {
            return this.f322a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m362b() {
            return this.f324b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m363c() {
            return this.f325c;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m360a() {
            return this.f323a;
        }

        public g b(String str) {
            this.f324b = true;
            this.b = str;
            return this;
        }

        public g c(String str) {
            this.f325c = true;
            this.c = str;
            return this;
        }

        public g a(String str) {
            this.f323a = true;
            this.f322a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m360a() ? 0 + com.xiaomi.push.c.a(1, m359a()) : 0;
            if (m362b()) {
                iA += com.xiaomi.push.c.a(2, m361b());
            }
            if (m363c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            this.f11518a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m360a()) {
                cVar.m226a(1, m359a());
            }
            if (m362b()) {
                cVar.m226a(2, m361b());
            }
            if (m363c()) {
                cVar.m226a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f11518a < 0) {
                b();
            }
            return this.f11518a;
        }

        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 10) {
                    a(bVar.m189a());
                } else if (iM186a == 18) {
                    b(bVar.m189a());
                } else if (iM186a != 26) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    c(bVar.m189a());
                }
            }
        }

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f327a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f328b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11519a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f326a = "";
        private int b = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m366b() {
            return this.f328b;
        }

        public int c() {
            return this.f11519a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m365a() {
            return this.f327a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m365a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m366b()) {
                iA += com.xiaomi.push.c.a(2, m364a());
            }
            this.b = iA;
            return iA;
        }

        public h a(int i) {
            this.f327a = true;
            this.f11519a = i;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m364a() {
            return this.f326a;
        }

        public h a(String str) {
            this.f328b = true;
            this.f326a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m365a()) {
                cVar.m222a(1, c());
            }
            if (m366b()) {
                cVar.m226a(2, m364a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 8) {
                    a(bVar.m195b());
                } else if (iM186a != 18) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    a(bVar.m189a());
                }
            }
        }

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f330a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f329a = com.xiaomi.push.a.f11396a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11520a = -1;

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m368a() ? 0 + com.xiaomi.push.c.a(1, m367a()) : 0;
            this.f11520a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m367a() {
            return this.f329a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m368a() {
            return this.f330a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f330a = true;
            this.f329a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m368a()) {
                cVar.m224a(1, m367a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f11520a < 0) {
                b();
            }
            return this.f11520a;
        }

        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a != 10) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    a(bVar.m188a());
                }
            }
        }

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f333a;
        private boolean b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f331a = com.xiaomi.push.a.f11396a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private b f332a = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11521a = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m372b() {
            return this.b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m369a() {
            return this.f331a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m371a() ? 0 + com.xiaomi.push.c.a(1, m369a()) : 0;
            if (m372b()) {
                iA += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m370a());
            }
            this.f11521a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m371a() {
            return this.f333a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f333a = true;
            this.f331a = aVar;
            return this;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public b m370a() {
            return this.f332a;
        }

        public j a(b bVar) {
            bVar.getClass();
            this.b = true;
            this.f332a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m371a()) {
                cVar.m224a(1, m369a());
            }
            if (m372b()) {
                cVar.m225a(2, (com.xiaomi.push.e) m370a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f11521a < 0) {
                b();
            }
            return this.f11521a;
        }

        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 10) {
                    a(bVar.m188a());
                } else if (iM186a != 18) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class k extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f336a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f339b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f335a = "";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f338b = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private long f334a = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private long f337b = 0;
        private boolean f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11522a = 0;
        private int b = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public String m377b() {
            return this.f338b;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m379c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m374a() {
            return this.f335a;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m378b() {
            return this.f339b;
        }

        public int c() {
            return this.f11522a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m375a() {
            return this.f336a;
        }

        public k b(String str) {
            this.f339b = true;
            this.f338b = str;
            return this;
        }

        public k a(String str) {
            this.f336a = true;
            this.f335a = str;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public long m376b() {
            return this.f337b;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public long m373a() {
            return this.f334a;
        }

        public k b(long j) {
            this.d = true;
            this.f337b = j;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f334a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m375a() ? 0 + com.xiaomi.push.c.a(1, m374a()) : 0;
            if (m378b()) {
                iA += com.xiaomi.push.c.a(2, m377b());
            }
            if (m379c()) {
                iA += com.xiaomi.push.c.a(3, m373a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(4, m376b());
            }
            if (f()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(6, c());
            }
            this.b = iA;
            return iA;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        public k a(int i) {
            this.g = true;
            this.f11522a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m375a()) {
                cVar.m226a(1, m374a());
            }
            if (m378b()) {
                cVar.m226a(2, m377b());
            }
            if (m379c()) {
                cVar.m223a(3, m373a());
            }
            if (d()) {
                cVar.m223a(4, m376b());
            }
            if (f()) {
                cVar.m227a(5, e());
            }
            if (g()) {
                cVar.m222a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM186a = bVar.m186a();
                if (iM186a == 0) {
                    return this;
                }
                if (iM186a == 10) {
                    a(bVar.m189a());
                } else if (iM186a == 18) {
                    b(bVar.m189a());
                } else if (iM186a == 24) {
                    a(bVar.m187a());
                } else if (iM186a == 32) {
                    b(bVar.m187a());
                } else if (iM186a == 40) {
                    a(bVar.m192a());
                } else if (iM186a != 48) {
                    if (!a(bVar, iM186a)) {
                        return this;
                    }
                } else {
                    a(bVar.m195b());
                }
            }
        }

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }
    }
}
