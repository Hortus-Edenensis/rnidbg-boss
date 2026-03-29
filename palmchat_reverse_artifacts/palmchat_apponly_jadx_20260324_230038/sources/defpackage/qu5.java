package defpackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.k0;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class qu5 {
    public static final Pattern d = Pattern.compile("\\s+");
    public static final ImmutableSet<String> e = ImmutableSet.of("auto", "none");
    public static final ImmutableSet<String> f = ImmutableSet.of(TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    public static final ImmutableSet<String> g = ImmutableSet.of(TtmlNode.TEXT_EMPHASIS_MARK_FILLED, "open");
    public static final ImmutableSet<String> h = ImmutableSet.of("after", "before", TtmlNode.ANNOTATION_POSITION_OUTSIDE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20324a;
    public final int b;
    public final int c;

    public qu5(int i, int i2, int i3) {
        this.f20324a = i;
        this.b = i2;
        this.c = i3;
    }

    @Nullable
    public static qu5 a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strE = th.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(strE, d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static qu5 b(ImmutableSet<String> immutableSet) {
        byte b;
        byte b2;
        String str = (String) bv2.f(k0.e(h, immutableSet), TtmlNode.ANNOTATION_POSITION_OUTSIDE);
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
        k0.e eVarE = k0.e(e, immutableSet);
        if (!eVarE.isEmpty()) {
            String str2 = (String) eVarE.iterator().next();
            int iHashCode2 = str2.hashCode();
            if (iHashCode2 != 3005871) {
                b4 = (iHashCode2 == 3387192 && str2.equals("none")) ? (byte) 0 : (byte) -1;
            } else if (!str2.equals("auto")) {
            }
            return new qu5(b4 == 0 ? 0 : -1, 0, i);
        }
        k0.e eVarE2 = k0.e(g, immutableSet);
        k0.e eVarE3 = k0.e(f, immutableSet);
        if (eVarE2.isEmpty() && eVarE3.isEmpty()) {
            return new qu5(-1, 0, i);
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
        return new qu5(b3 != 0 ? b3 != 1 ? 1 : 3 : 2, i2, i);
    }
}
