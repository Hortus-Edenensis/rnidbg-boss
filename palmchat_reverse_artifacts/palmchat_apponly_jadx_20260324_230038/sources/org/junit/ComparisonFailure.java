package org.junit;

import defpackage.uh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ComparisonFailure extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19853a;
        public final String b;
        public final String c;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f19854a;
            public final String b;

            public String a() {
                return e(b.this.c);
            }

            public String b() {
                if (this.f19854a.length() <= b.this.f19853a) {
                    return this.f19854a;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("...");
                String str = this.f19854a;
                sb.append(str.substring(str.length() - b.this.f19853a));
                return sb.toString();
            }

            public String c() {
                if (this.b.length() <= b.this.f19853a) {
                    return this.b;
                }
                return this.b.substring(0, b.this.f19853a) + "...";
            }

            public String d() {
                return e(b.this.b);
            }

            public final String e(String str) {
                return "[" + str.substring(this.f19854a.length(), str.length() - this.b.length()) + "]";
            }

            public a() {
                String strG = b.this.g();
                this.f19854a = strG;
                this.b = b.this.h(strG);
            }
        }

        public b(int i, String str, String str2) {
            this.f19853a = i;
            this.b = str;
            this.c = str2;
        }

        public String f(String str) {
            String str2;
            String str3 = this.b;
            if (str3 == null || (str2 = this.c) == null || str3.equals(str2)) {
                return uh.a(str, this.b, this.c);
            }
            a aVar = new a();
            String strB = aVar.b();
            String strC = aVar.c();
            return uh.a(str, strB + aVar.d() + strC, strB + aVar.a() + strC);
        }

        public final String g() {
            int iMin = Math.min(this.b.length(), this.c.length());
            for (int i = 0; i < iMin; i++) {
                if (this.b.charAt(i) != this.c.charAt(i)) {
                    return this.b.substring(0, i);
                }
            }
            return this.b.substring(0, iMin);
        }

        public final String h(String str) {
            int iMin = Math.min(this.b.length() - str.length(), this.c.length() - str.length()) - 1;
            int i = 0;
            while (i <= iMin) {
                if (this.b.charAt((r1.length() - 1) - i) != this.c.charAt((r2.length() - 1) - i)) {
                    break;
                }
                i++;
            }
            String str2 = this.b;
            return str2.substring(str2.length() - i);
        }
    }

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new b(20, this.fExpected, this.fActual).f(super.getMessage());
    }
}
