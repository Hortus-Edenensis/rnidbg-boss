package com.opos.exoplayer.core.drm;

import android.annotation.TargetApi;
import com.opos.exoplayer.core.drm.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public interface DrmSession<T extends c> {

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.opos.exoplayer.core.util.b {
        public a(Throwable th) {
            super(th);
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "DrmSessionException";
        }
    }

    int e();

    a f();

    T g();

    Map<String, String> h();
}
