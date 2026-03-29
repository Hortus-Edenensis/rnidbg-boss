package com.bytedance.sdk.openadsdk.core.l.nr;

import com.bytedance.sdk.openadsdk.core.l.nr.nr;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements u {
    private final ConcurrentHashMap<Integer, u> u = new ConcurrentHashMap<>();

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
    public void fx(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, u> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new nr.u().u(next.getValue()).u("onDownloadFailed").u(j).nr(j2).nr(str).fx(str2).u();
            }
        }
    }

    public void nr() {
        if (this.u.isEmpty()) {
            return;
        }
        this.u.clear();
    }

    public void u(u uVar) {
        if (uVar != null) {
            this.u.put(Integer.valueOf(uVar.hashCode()), uVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
    public void u() {
        Iterator<Map.Entry<Integer, u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, u> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new nr.u().u(next.getValue()).u("onIdle").u();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
    public void nr(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, u> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new nr.u().u(next.getValue()).u("onDownloadPaused").u(j).nr(j2).nr(str).fx(str2).u();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
    public void u(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, u> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new nr.u().u(next.getValue()).u("onDownloadActive").u(j).nr(j2).nr(str).fx(str2).u();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
    public void u(String str, String str2) {
        Iterator<Map.Entry<Integer, u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, u> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().u(str, str2);
                new nr.u().u(next.getValue()).u("onInstalled").nr(str).fx(str2).u();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
    public void u(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, u> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new nr.u().u(next.getValue()).u("onDownloadFinished").u(j).nr(str).fx(str2).u();
            }
        }
    }
}
