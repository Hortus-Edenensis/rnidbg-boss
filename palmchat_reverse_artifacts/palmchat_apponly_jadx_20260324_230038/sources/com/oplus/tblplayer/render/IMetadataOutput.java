package com.oplus.tblplayer.render;

import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.metadata.MetadataOutput;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IMetadataOutput extends MetadataOutput {
    @Override // com.oplus.tbl.exoplayer2.metadata.MetadataOutput
    void onMetadata(@NonNull Metadata metadata);

    void onMetadataReset();
}
