package com.bytedance.sdk.openadsdk.core.t;

import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private volatile boolean fx;
    private int nr;
    private int u;

    public nr(int i, int i2) {
        this.u = 15;
        this.nr = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.u = i;
        this.nr = i2;
    }

    private void b(List<File> list) {
        long jNr;
        int size;
        boolean zU;
        if (list != null) {
            try {
                if (list.size() == 0 || (zU = u((jNr = nr(list)), (size = list.size())))) {
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zU) {
                        k.nr("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jNr -= length;
                        } else {
                            k.nr("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (u(file2, jNr, size)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void fx(List<File> list) {
        long jNr = nr(list);
        int size = list.size();
        if (u(jNr, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jNr -= length;
            }
            if (u(file, jNr, size)) {
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.t.u
    public boolean u(long j, int i) {
        return i <= this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.t.u
    public boolean u(File file, long j, int i) {
        return i <= this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.t.u
    public void u(List<File> list) {
        if (this.fx) {
            b(list);
            this.fx = false;
        } else {
            fx(list);
        }
    }
}
