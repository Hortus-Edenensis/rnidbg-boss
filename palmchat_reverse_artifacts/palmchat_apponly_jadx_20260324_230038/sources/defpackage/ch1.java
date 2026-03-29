package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ch1 {
    public static void a(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.b(null);
        }
        if (drmSession != null) {
            drmSession.a(null);
        }
    }
}
