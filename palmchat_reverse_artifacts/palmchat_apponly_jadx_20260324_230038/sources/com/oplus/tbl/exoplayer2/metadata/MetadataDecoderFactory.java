package com.oplus.tbl.exoplayer2.metadata;

import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.metadata.dvbsi.AppInfoTableDecoder;
import com.oplus.tbl.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.oplus.tbl.exoplayer2.metadata.icy.IcyDecoder;
import com.oplus.tbl.exoplayer2.metadata.id3.Id3Decoder;
import com.oplus.tbl.exoplayer2.metadata.scte35.SpliceInfoDecoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory() { // from class: com.oplus.tbl.exoplayer2.metadata.MetadataDecoderFactory.1
        @Override // com.oplus.tbl.exoplayer2.metadata.MetadataDecoderFactory
        public MetadataDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new AppInfoTableDecoder();
                    case "application/x-icy":
                        return new IcyDecoder();
                    case "application/id3":
                        return new Id3Decoder();
                    case "application/x-emsg":
                        return new EventMessageDecoder();
                    case "application/x-scte35":
                        return new SpliceInfoDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        @Override // com.oplus.tbl.exoplayer2.metadata.MetadataDecoderFactory
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }
    };

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
