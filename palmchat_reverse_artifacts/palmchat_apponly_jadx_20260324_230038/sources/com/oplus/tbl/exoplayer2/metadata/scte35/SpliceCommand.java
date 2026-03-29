package com.oplus.tbl.exoplayer2.metadata.scte35;

import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import defpackage.oo3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.oplus.tbl.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return oo3.a(this);
    }

    @Override // com.oplus.tbl.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format getWrappedMetadataFormat() {
        return oo3.b(this);
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
