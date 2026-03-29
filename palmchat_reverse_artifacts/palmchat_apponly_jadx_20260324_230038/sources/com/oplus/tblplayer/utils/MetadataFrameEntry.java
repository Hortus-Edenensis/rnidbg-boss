package com.oplus.tblplayer.utils;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class MetadataFrameEntry implements Metadata.Entry {

    @NonNull
    private final ByteBuffer data;
    private final long pts;
    private final int type;

    public MetadataFrameEntry(@NonNull ByteBuffer byteBuffer, long j, int i) {
        this.data = byteBuffer;
        this.pts = j;
        this.type = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public final ByteBuffer getData() {
        return this.data;
    }

    public final long getPts() {
        return this.pts;
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.oplus.tbl.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public byte[] getWrappedMetadataBytes() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public Format getWrappedMetadataFormat() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    }
}
