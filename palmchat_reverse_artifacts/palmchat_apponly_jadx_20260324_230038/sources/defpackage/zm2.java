package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class zm2 {
    public static boolean a(IMediaFormat iMediaFormat, @NonNull String str) {
        return false;
    }

    @Nullable
    public static ByteBuffer b(IMediaFormat iMediaFormat, @NonNull String str) {
        return null;
    }

    @NonNull
    public static ByteBuffer c(IMediaFormat iMediaFormat, @NonNull String str, @NonNull ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = iMediaFormat.getByteBuffer(str);
        return byteBuffer2 == null ? byteBuffer : byteBuffer2;
    }

    public static float d(IMediaFormat iMediaFormat, @NonNull String str) {
        throw null;
    }

    public static float e(IMediaFormat iMediaFormat, @NonNull String str, float f) {
        try {
            return iMediaFormat.getFloat(str);
        } catch (NullPointerException unused) {
            return f;
        }
    }

    public static int f(IMediaFormat iMediaFormat, @NonNull String str) {
        throw null;
    }

    public static int g(IMediaFormat iMediaFormat, @NonNull String str, int i) {
        try {
            return iMediaFormat.getInteger(str);
        } catch (NullPointerException unused) {
            return i;
        }
    }

    public static long h(IMediaFormat iMediaFormat, @NonNull String str) {
        throw null;
    }

    public static long i(IMediaFormat iMediaFormat, @NonNull String str, long j) {
        try {
            return iMediaFormat.getLong(str);
        } catch (NullPointerException unused) {
            return j;
        }
    }

    @Nullable
    public static String j(IMediaFormat iMediaFormat, @NonNull String str) {
        return null;
    }

    @NonNull
    public static String k(IMediaFormat iMediaFormat, @NonNull String str, @NonNull String str2) {
        String string = iMediaFormat.getString(str);
        return string == null ? str2 : string;
    }

    public static int l(IMediaFormat iMediaFormat, @NonNull String str) {
        return 0;
    }

    public static void m(IMediaFormat iMediaFormat, @NonNull String str, @Nullable ByteBuffer byteBuffer) {
    }

    public static void n(IMediaFormat iMediaFormat, @NonNull String str, float f) {
    }

    public static void o(IMediaFormat iMediaFormat, @NonNull String str, int i) {
    }

    public static void p(IMediaFormat iMediaFormat, @NonNull String str, long j) {
    }

    public static void q(IMediaFormat iMediaFormat, @NonNull String str, @Nullable String str2) {
    }
}
