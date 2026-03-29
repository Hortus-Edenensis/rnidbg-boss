package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class z00 implements em4<Character> {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends e {
        public static final z00 b = new a();

        public a() {
            super("CharMatcher.ascii()");
        }

        @Override // defpackage.z00
        public boolean g(char c) {
            return c <= 127;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends z00 {
        @Override // defpackage.em4
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f22309a;
        public final char b;

        public c(char c, char c2) {
            dm4.d(c2 >= c);
            this.f22309a = c;
            this.b = c2;
        }

        @Override // defpackage.z00
        public boolean g(char c) {
            return this.f22309a <= c && c <= this.b;
        }

        public String toString() {
            return "CharMatcher.inRange('" + z00.j(this.f22309a) + "', '" + z00.j(this.b) + "')";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f22310a;

        public d(char c) {
            this.f22310a = c;
        }

        @Override // defpackage.z00
        public boolean g(char c) {
            return c == this.f22310a;
        }

        public String toString() {
            return "CharMatcher.is('" + z00.j(this.f22310a) + "')";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22311a;

        public e(String str) {
            this.f22311a = (String) dm4.o(str);
        }

        public final String toString() {
            return this.f22311a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f extends e {
        public static final z00 b = new f();

        public f() {
            super("CharMatcher.none()");
        }

        @Override // defpackage.z00
        public int e(CharSequence charSequence, int i) {
            dm4.q(i, charSequence.length());
            return -1;
        }

        @Override // defpackage.z00
        public boolean g(char c) {
            return false;
        }

        @Override // defpackage.z00
        public boolean h(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    public static z00 c() {
        return a.b;
    }

    public static z00 d(char c2, char c3) {
        return new c(c2, c3);
    }

    public static z00 f(char c2) {
        return new d(c2);
    }

    public static z00 i() {
        return f.b;
    }

    public static String j(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return g(ch.charValue());
    }

    public int e(CharSequence charSequence, int i) {
        int length = charSequence.length();
        dm4.q(i, length);
        while (i < length) {
            if (g(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean g(char c2);

    public boolean h(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!g(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
