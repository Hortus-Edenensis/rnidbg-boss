package com.bykv.vk.openvk.component.video.u.u;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.fx.nr;
import com.bykv.vk.openvk.component.video.u.u.u.fx;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends MediaDataSource {
    public static final ConcurrentHashMap<String, u> u = new ConcurrentHashMap<>();
    private final Context b;
    private long fx = -2147483648L;
    private final fx nr;
    private final iz pn;

    public u(Context context, nr nrVar, iz izVar) {
        this.b = context;
        this.pn = izVar;
        this.nr = new com.bykv.vk.openvk.component.video.u.u.u.nr(context, nrVar, izVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pn.my();
        fx fxVar = this.nr;
        if (fxVar != null) {
            fxVar.nr();
        }
        u.remove(this.pn.o());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.fx == -2147483648L) {
            if (this.b == null || TextUtils.isEmpty(this.pn.my())) {
                return -1L;
            }
            this.fx = this.nr.fx();
        }
        return this.fx;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.nr.u(j, bArr, i, i2);
    }

    public iz u() {
        return this.pn;
    }

    public static u u(Context context, nr nrVar, iz izVar) {
        u uVar = new u(context, nrVar, izVar);
        u.put(izVar.o(), uVar);
        return uVar;
    }
}
