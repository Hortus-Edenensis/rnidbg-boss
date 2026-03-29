package defpackage;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class vg3 {
    public static void a(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, @Nullable xg0 xg0Var) {
        if (xg0Var != null) {
            d(mediaFormat, IMediaFormat.KEY_COLOR_TRANSFER, xg0Var.c);
            d(mediaFormat, IMediaFormat.KEY_COLOR_STANDARD, xg0Var.f21949a);
            d(mediaFormat, IMediaFormat.KEY_COLOR_RANGE, xg0Var.b);
            a(mediaFormat, IMediaFormat.KEY_HDR_STATIC_INFO, xg0Var.d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap(list.get(i)));
        }
    }
}
