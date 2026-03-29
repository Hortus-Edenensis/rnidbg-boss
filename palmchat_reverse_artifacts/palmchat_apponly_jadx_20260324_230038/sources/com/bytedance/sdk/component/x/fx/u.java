package com.bytedance.sdk.component.x.fx;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.x.nr, com.bytedance.sdk.component.x.u {
    private final boolean nr = false;
    private final com.bytedance.sdk.component.b.nr.u u;

    public u(com.bytedance.sdk.component.b.nr.u uVar) {
        this.u = uVar;
    }

    @Override // com.bytedance.sdk.component.x.u
    public Map<String, Object> u(File file) {
        if (file.getName().endsWith(".prop")) {
            return new nr(this.u, this.nr).u(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        return (!file2.exists() || file2.length() <= 0) ? file.getName().endsWith("xml") ? pn.u() ? new pn(this.u, this.nr).u(file) : new iz(this.u, this.nr).u(file) : new ConcurrentHashMap() : new nr(this.u, this.nr).u(file2);
    }

    @Override // com.bytedance.sdk.component.x.nr
    public void u(Map<String, Object> map, File file) throws IOException {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new nr(this.u, this.nr).u(map, file);
    }
}
