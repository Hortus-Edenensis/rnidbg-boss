package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class cv0 {
    public static void a(@Nullable a aVar) {
        if (aVar != null) {
            try {
                aVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
