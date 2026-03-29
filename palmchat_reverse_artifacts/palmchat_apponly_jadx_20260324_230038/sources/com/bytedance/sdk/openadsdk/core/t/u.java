package com.bytedance.sdk.openadsdk.core.t;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.t.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class CallableC0288u implements Callable<Void> {
        private final File nr;

        private CallableC0288u(File file) {
            this.nr = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            u.this.nr(this.nr);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(File file) throws IOException {
        try {
            n.nr(file);
        } catch (Throwable unused) {
        }
        List<File> listU = n.u(file.getParentFile());
        k.nr("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listU.size());
        u(listU);
    }

    public abstract void u(List<File> list);

    public abstract boolean u(long j, int i);

    public abstract boolean u(File file, long j, int i);

    public void u(File file) throws IOException {
        final com.bytedance.sdk.component.jk.n nVar = new com.bytedance.sdk.component.jk.n(new CallableC0288u(file), 1, 2);
        x.nr(new a("touch", nVar.u()) { // from class: com.bytedance.sdk.openadsdk.core.t.u.1
            @Override // java.lang.Runnable
            public void run() {
                nVar.run();
            }
        });
    }

    public long nr(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }
}
