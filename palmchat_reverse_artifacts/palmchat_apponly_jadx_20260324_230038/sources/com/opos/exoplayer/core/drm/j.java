package com.opos.exoplayer.core.drm;

import com.opos.exoplayer.core.drm.DrmSession;
import com.opos.exoplayer.core.drm.c;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class j<T extends c> implements DrmSession<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DrmSession.a f8153a;

    public j(DrmSession.a aVar) {
        this.f8153a = (DrmSession.a) com.opos.exoplayer.core.util.a.a(aVar);
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public int e() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public DrmSession.a f() {
        return this.f8153a;
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public T g() {
        return null;
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public Map<String, String> h() {
        return null;
    }
}
