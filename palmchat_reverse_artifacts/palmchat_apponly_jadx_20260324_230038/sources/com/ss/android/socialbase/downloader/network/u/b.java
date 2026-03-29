package com.ss.android.socialbase.downloader.network.u;

import com.ss.android.socialbase.downloader.network.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements a {
    private boolean b;
    private a fx;
    private InputStream iz;
    private final List<com.ss.android.socialbase.downloader.model.fx> nr;
    private long pn;
    protected final Object u;

    @Override // com.ss.android.socialbase.downloader.network.a
    public void b() {
        a aVar = this.fx;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.x
    public void fx() {
        a aVar = this.fx;
        if (aVar != null) {
            aVar.fx();
        }
    }

    public List<com.ss.android.socialbase.downloader.model.fx> iz() {
        return this.nr;
    }

    public boolean n() {
        return System.currentTimeMillis() - this.pn < nr.u;
    }

    @Override // com.ss.android.socialbase.downloader.network.x
    public int nr() throws IOException {
        a aVar = this.fx;
        if (aVar != null) {
            return aVar.nr();
        }
        return 0;
    }

    public void pn() throws InterruptedException {
        synchronized (this.u) {
            if (this.b && this.fx == null) {
                this.u.wait();
            }
        }
    }

    public boolean u(int i) {
        return i >= 200 && i < 300;
    }

    public boolean x() {
        try {
            a aVar = this.fx;
            if (aVar != null) {
                return u(aVar.nr());
            }
            return false;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.a
    public InputStream u() throws IOException {
        InputStream inputStream = this.iz;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.x
    public String u(String str) {
        a aVar = this.fx;
        if (aVar != null) {
            return aVar.u(str);
        }
        return null;
    }
}
