package defpackage;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.media3.muxer.MuxerUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ck5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2000a;
    public final int b;

    @Nullable
    @ColorInt
    public final Integer c;

    @Nullable
    @ColorInt
    public final Integer d;
    public final float e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2001a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;

        public a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f2001a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.k = i11;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static a a(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                String strE = th.e(strArrSplit[i11].trim());
                strE.hashCode();
                switch (strE) {
                    case "italic":
                        i7 = i11;
                        break;
                    case "underline":
                        i8 = i11;
                        break;
                    case "strikeout":
                        i9 = i11;
                        break;
                    case "primarycolour":
                        i3 = i11;
                        break;
                    case "bold":
                        i6 = i11;
                        break;
                    case "name":
                        i = i11;
                        break;
                    case "fontsize":
                        i5 = i11;
                        break;
                    case "borderstyle":
                        i10 = i11;
                        break;
                    case "alignment":
                        i2 = i11;
                        break;
                    case "outlinecolour":
                        i4 = i11;
                        break;
                }
            }
            if (i != -1) {
                return new a(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, strArrSplit.length);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public static final Pattern c = Pattern.compile("\\{([^}]*)\\}");
        public static final Pattern d = Pattern.compile(g86.C("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final Pattern e = Pattern.compile(g86.C("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final Pattern f = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2002a;

        @Nullable
        public final PointF b;

        public b(int i, @Nullable PointF pointF) {
            this.f2002a = i;
            this.b = pointF;
        }

        public static int a(String str) {
            Matcher matcher = f.matcher(str);
            if (matcher.find()) {
                return ck5.e((String) vh.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = c.matcher(str);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str2 = (String) vh.e(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i, pointF);
        }

        @Nullable
        public static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = d.matcher(str);
            Matcher matcher2 = e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    y53.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) vh.e(strGroup)).trim()), Float.parseFloat(((String) vh.e(strGroup2)).trim()));
        }

        public static String d(String str) {
            return c.matcher(str).replaceAll("");
        }
    }

    public ck5(String str, int i, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.f2000a = str;
        this.b = i;
        this.c = num;
        this.d = num2;
        this.e = f;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = i2;
    }

    @Nullable
    public static ck5 b(String str, a aVar) {
        vh.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i = aVar.k;
        if (length != i) {
            y53.i("SsaStyle", g86.C("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f2001a].trim();
            int i2 = aVar.b;
            int iE = i2 != -1 ? e(strArrSplit[i2].trim()) : -1;
            int i3 = aVar.c;
            Integer numH = i3 != -1 ? h(strArrSplit[i3].trim()) : null;
            int i4 = aVar.d;
            Integer numH2 = i4 != -1 ? h(strArrSplit[i4].trim()) : null;
            int i5 = aVar.e;
            float fI = i5 != -1 ? i(strArrSplit[i5].trim()) : -3.4028235E38f;
            int i6 = aVar.f;
            boolean z = i6 != -1 && f(strArrSplit[i6].trim());
            int i7 = aVar.g;
            boolean z2 = i7 != -1 && f(strArrSplit[i7].trim());
            int i8 = aVar.h;
            boolean z3 = i8 != -1 && f(strArrSplit[i8].trim());
            int i9 = aVar.i;
            boolean z4 = i9 != -1 && f(strArrSplit[i9].trim());
            int i10 = aVar.j;
            return new ck5(strTrim, iE, numH, numH2, fI, z, z2, z3, z4, i10 != -1 ? g(strArrSplit[i10].trim()) : -1);
        } catch (RuntimeException e) {
            y53.j("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e);
            return null;
        }
    }

    public static boolean c(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean d(int i) {
        return i == 1 || i == 3;
    }

    public static int e(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            if (c(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        y53.i("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean f(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            y53.j("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }

    public static int g(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            if (d(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        y53.i("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    @Nullable
    @ColorInt
    public static Integer h(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            vh.a(j <= MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            return Integer.valueOf(Color.argb(ku2.e(((j >> 24) & 255) ^ 255), ku2.e(j & 255), ku2.e((j >> 8) & 255), ku2.e((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            y53.j("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    public static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            y53.j("SsaStyle", "Failed to parse font size: '" + str + "'", e);
            return -3.4028235E38f;
        }
    }
}
