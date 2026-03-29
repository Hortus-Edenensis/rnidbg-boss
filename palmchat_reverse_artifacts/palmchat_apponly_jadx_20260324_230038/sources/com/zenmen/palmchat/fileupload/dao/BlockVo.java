package com.zenmen.palmchat.fileupload.dao;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BlockVo {
    public String blockId;
    public int chunkSize;
    public int index;
    public int offset;
    public int paramSize;
    public int size;

    public String toString() {
        return this.blockId + " index=" + this.index + " size=" + this.size + "offset=" + this.offset + "chunkSize=" + this.chunkSize + "paramSize=" + this.paramSize;
    }
}
