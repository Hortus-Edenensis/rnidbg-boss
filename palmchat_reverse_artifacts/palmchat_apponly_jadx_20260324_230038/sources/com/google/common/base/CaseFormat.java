package com.google.common.base;

import defpackage.dm4;
import defpackage.th;
import defpackage.xp0;
import defpackage.z00;
import j$.util.Objects;
import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class CaseFormat {
    public static final CaseFormat LOWER_CAMEL;
    public static final CaseFormat LOWER_UNDERSCORE;
    public static final CaseFormat UPPER_CAMEL;
    public static final CaseFormat UPPER_UNDERSCORE;
    private final z00 wordBoundary;
    private final String wordSeparator;
    public static final CaseFormat LOWER_HYPHEN = new a("LOWER_HYPHEN", 0, z00.f('-'), "-");
    private static final /* synthetic */ CaseFormat[] $VALUES = $values();

    /* JADX INFO: compiled from: SearchBox */
    public enum a extends CaseFormat {
        public a(String str, int i, z00 z00Var, String str2) {
            super(str, i, z00Var, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.LOWER_UNDERSCORE ? str.replace('-', '_') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? th.g(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return th.e(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f extends xp0<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        public final CaseFormat b;
        public final CaseFormat c;

        public f(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.b = (CaseFormat) dm4.o(caseFormat);
            this.c = (CaseFormat) dm4.o(caseFormat2);
        }

        @Override // defpackage.xp0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public String c(String str) {
            return this.b.to(this.c, str);
        }

        @Override // defpackage.u42
        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.b.equals(fVar.b) && this.c.equals(fVar.c);
        }

        public int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        public String toString() {
            return this.b + ".converterTo(" + this.c + ")";
        }
    }

    private static /* synthetic */ CaseFormat[] $values() {
        return new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    static {
        String str = "_";
        LOWER_UNDERSCORE = new CaseFormat("LOWER_UNDERSCORE", 1, z00.f('_'), str) { // from class: com.google.common.base.CaseFormat.b
            {
                a aVar = null;
            }

            @Override // com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat, String str2) {
                return caseFormat == CaseFormat.LOWER_HYPHEN ? str2.replace('_', '-') : caseFormat == CaseFormat.UPPER_UNDERSCORE ? th.g(str2) : super.convert(caseFormat, str2);
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str2) {
                return th.e(str2);
            }
        };
        String str2 = "";
        LOWER_CAMEL = new CaseFormat("LOWER_CAMEL", 2, z00.d('A', 'Z'), str2) { // from class: com.google.common.base.CaseFormat.c
            {
                a aVar = null;
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeFirstWord(String str3) {
                return th.e(str3);
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return CaseFormat.firstCharOnlyToUpper(str3);
            }
        };
        UPPER_CAMEL = new CaseFormat("UPPER_CAMEL", 3, z00.d('A', 'Z'), str2) { // from class: com.google.common.base.CaseFormat.d
            {
                a aVar = null;
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return CaseFormat.firstCharOnlyToUpper(str3);
            }
        };
        UPPER_UNDERSCORE = new CaseFormat("UPPER_UNDERSCORE", 4, z00.f('_'), str) { // from class: com.google.common.base.CaseFormat.e
            {
                a aVar = null;
            }

            @Override // com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat, String str3) {
                return caseFormat == CaseFormat.LOWER_HYPHEN ? th.e(str3.replace('_', '-')) : caseFormat == CaseFormat.LOWER_UNDERSCORE ? th.e(str3) : super.convert(caseFormat, str3);
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return th.g(str3);
            }
        };
    }

    public /* synthetic */ CaseFormat(String str, int i, z00 z00Var, String str2, a aVar) {
        this(str, i, z00Var, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return th.f(str.charAt(0)) + th.e(str.substring(1));
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int length = 0;
        int iE = -1;
        while (true) {
            iE = this.wordBoundary.e(str, iE + 1);
            if (iE == -1) {
                break;
            }
            if (length == 0) {
                sb = new StringBuilder(str.length() + (caseFormat.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(length, iE)));
            } else {
                Objects.requireNonNull(sb);
                sb.append(caseFormat.normalizeWord(str.substring(length, iE)));
            }
            sb.append(caseFormat.wordSeparator);
            length = this.wordSeparator.length() + iE;
        }
        if (length == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        Objects.requireNonNull(sb);
        sb.append(caseFormat.normalizeWord(str.substring(length)));
        return sb.toString();
    }

    public xp0<String, String> converterTo(CaseFormat caseFormat) {
        return new f(this, caseFormat);
    }

    public String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        dm4.o(caseFormat);
        dm4.o(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }

    private CaseFormat(String str, int i, z00 z00Var, String str2) {
        this.wordBoundary = z00Var;
        this.wordSeparator = str2;
    }
}
