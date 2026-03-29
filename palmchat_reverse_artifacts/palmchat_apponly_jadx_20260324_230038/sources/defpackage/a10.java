package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a10 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterable<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f1134a;

        /* JADX INFO: renamed from: a10$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0015a implements Iterator<CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1135a = 0;

            public C0015a() {
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharSequence next() {
                CharSequence charSequence = a.this.f1134a;
                int i = this.f1135a;
                this.f1135a = i + 1;
                return charSequence.subSequence(i, charSequence.length());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f1135a < a.this.f1134a.length();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Modification not supported");
            }
        }

        public a(CharSequence charSequence) {
            this.f1134a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<CharSequence> iterator() {
            return new C0015a();
        }
    }

    public static CharSequence a(CharSequence charSequence, CharSequence charSequence2) {
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence);
        sb.append(charSequence2);
        return sb;
    }

    public static CharSequence b(char[] cArr) {
        StringBuilder sb = new StringBuilder(cArr.length);
        sb.append(cArr);
        return sb;
    }

    public static Iterable<CharSequence> c(CharSequence charSequence) {
        return new a(charSequence);
    }

    public static CharSequence d(CharSequence charSequence, CharSequence charSequence2) {
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        for (int i = 0; i < iMin; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence.subSequence(0, iMin);
    }

    public static CharSequence e(CharSequence charSequence, int i) {
        return i >= charSequence.length() ? "" : charSequence.subSequence(i, charSequence.length());
    }

    public static CharSequence f(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        int length2 = charSequence.length();
        return length > length2 ? "" : charSequence.subSequence(length, length2);
    }

    public static char[] g(CharSequence charSequence) {
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = charSequence.charAt(i);
        }
        return cArr;
    }

    public static String h(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        StringBuilder sb = new StringBuilder(charSequence.length());
        sb.append(charSequence);
        return sb.toString();
    }
}
