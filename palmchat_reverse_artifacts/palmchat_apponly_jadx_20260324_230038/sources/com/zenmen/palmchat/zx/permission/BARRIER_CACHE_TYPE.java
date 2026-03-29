package com.zenmen.palmchat.zx.permission;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/zenmen/palmchat/zx/permission/BARRIER_CACHE_TYPE;", "", "id", "", "Lcom/zenmen/palmchat/zx/permission/BarrierCacheTypeValue;", "(Ljava/lang/String;II)V", "getId", "()I", "MEMORY", "SP", "WEAK_MEMORY", "SOFT_MEMORY", "zx-permission_release"}, k = 1, mv = {1, 1, 16})
public enum BARRIER_CACHE_TYPE {
    MEMORY(0),
    SP(1),
    WEAK_MEMORY(2),
    SOFT_MEMORY(3);

    private final int id;

    BARRIER_CACHE_TYPE(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }
}
