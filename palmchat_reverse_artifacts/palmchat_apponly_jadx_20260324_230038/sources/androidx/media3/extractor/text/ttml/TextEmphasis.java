package androidx.media3.extractor.text.ttml;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.k0;
import defpackage.bv2;
import defpackage.th;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class TextEmphasis {
    public static final int MARK_SHAPE_AUTO = -1;
    public static final int POSITION_OUTSIDE = -2;
    public final int markFill;
    public final int markShape;
    public final int position;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final ImmutableSet<String> SINGLE_STYLE_VALUES = ImmutableSet.of("auto", "none");
    private static final ImmutableSet<String> MARK_SHAPE_VALUES = ImmutableSet.of(TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    private static final ImmutableSet<String> MARK_FILL_VALUES = ImmutableSet.of(TtmlNode.TEXT_EMPHASIS_MARK_FILLED, "open");
    private static final ImmutableSet<String> POSITION_VALUES = ImmutableSet.of("after", "before", TtmlNode.ANNOTATION_POSITION_OUTSIDE);

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i, int i2, int i3) {
        this.markShape = i;
        this.markFill = i2;
        this.position = i3;
    }

    @Nullable
    public static TextEmphasis parse(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strE = th.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return parseWords(ImmutableSet.copyOf(TextUtils.split(strE, WHITESPACE_PATTERN)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TextEmphasis parseWords(ImmutableSet<String> immutableSet) {
        byte b;
        byte b2;
        String str = (String) bv2.f(k0.e(POSITION_VALUES, immutableSet), TtmlNode.ANNOTATION_POSITION_OUTSIDE);
        int iHashCode = str.hashCode();
        byte b3 = 0;
        byte b4 = 1;
        if (iHashCode != -1392885889) {
            if (iHashCode != -1106037339) {
                b = (iHashCode == 92734940 && str.equals("after")) ? (byte) 0 : (byte) -1;
            } else if (str.equals(TtmlNode.ANNOTATION_POSITION_OUTSIDE)) {
                b = 1;
            }
        } else if (str.equals("before")) {
            b = 2;
        }
        int i = b != 0 ? b != 1 ? 1 : -2 : 2;
        k0.e eVarE = k0.e(SINGLE_STYLE_VALUES, immutableSet);
        if (!eVarE.isEmpty()) {
            String str2 = (String) eVarE.iterator().next();
            int iHashCode2 = str2.hashCode();
            if (iHashCode2 != 3005871) {
                b4 = (iHashCode2 == 3387192 && str2.equals("none")) ? (byte) 0 : (byte) -1;
            } else if (!str2.equals("auto")) {
            }
            return new TextEmphasis(b4 == 0 ? 0 : -1, 0, i);
        }
        k0.e eVarE2 = k0.e(MARK_FILL_VALUES, immutableSet);
        k0.e eVarE3 = k0.e(MARK_SHAPE_VALUES, immutableSet);
        if (eVarE2.isEmpty() && eVarE3.isEmpty()) {
            return new TextEmphasis(-1, 0, i);
        }
        String str3 = (String) bv2.f(eVarE2, TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
        int iHashCode3 = str3.hashCode();
        if (iHashCode3 != -1274499742) {
            b2 = (iHashCode3 == 3417674 && str3.equals("open")) ? (byte) 0 : (byte) -1;
        } else if (str3.equals(TtmlNode.TEXT_EMPHASIS_MARK_FILLED)) {
            b2 = 1;
        }
        int i2 = b2 != 0 ? 1 : 2;
        String str4 = (String) bv2.f(eVarE3, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1360216880) {
            if (iHashCode4 != -905816648) {
                if (iHashCode4 != 99657 || !str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_DOT)) {
                    b3 = -1;
                }
            } else if (str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_SESAME)) {
                b3 = 1;
            }
        } else if (str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE)) {
            b3 = 2;
        }
        return new TextEmphasis(b3 != 0 ? b3 != 1 ? 1 : 3 : 2, i2, i);
    }
}
