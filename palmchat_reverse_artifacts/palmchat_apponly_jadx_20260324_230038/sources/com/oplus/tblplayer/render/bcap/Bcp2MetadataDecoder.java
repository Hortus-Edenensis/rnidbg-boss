package com.oplus.tblplayer.render.bcap;

import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.metadata.MetadataDecoder;
import com.oplus.tbl.exoplayer2.metadata.MetadataDecoderFactory;
import com.oplus.tbl.exoplayer2.metadata.MetadataInputBuffer;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.utils.BufferUtil;
import com.oplus.tblplayer.utils.MetadataFrameEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Bcp2MetadataDecoder implements MetadataDecoder {

    @NonNull
    public static final MetadataDecoderFactory factory = new MetadataDecoderFactory() { // from class: com.oplus.tblplayer.render.bcap.Bcp2MetadataDecoder.1
        @Override // com.oplus.tbl.exoplayer2.metadata.MetadataDecoderFactory
        public boolean supportsFormat(@NonNull Format format) {
            Assertions.checkNotNull(format.sampleMimeType);
            return format.sampleMimeType.equals(Constants.APPLICATION_BCP2);
        }

        @Override // com.oplus.tbl.exoplayer2.metadata.MetadataDecoderFactory
        @NonNull
        public Bcp2MetadataDecoder createDecoder(@NonNull Format format) {
            return new Bcp2MetadataDecoder();
        }
    };

    @Override // com.oplus.tbl.exoplayer2.metadata.MetadataDecoder
    @NonNull
    public Metadata decode(@NonNull MetadataInputBuffer metadataInputBuffer) {
        return new Metadata(new MetadataFrameEntry(BufferUtil.copyMetadataBuffer(metadataInputBuffer), metadataInputBuffer.timeUs, 1) { // from class: com.oplus.tblplayer.render.bcap.Bcp2MetadataDecoder.2
        });
    }
}
