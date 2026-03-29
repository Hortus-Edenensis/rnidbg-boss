package com.oplus.tbl.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.extractor.DefaultExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.Extractor;
import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorOutput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.PositionHolder;
import com.oplus.tbl.exoplayer2.extractor.mp3.Mp3Extractor;
import com.oplus.tbl.exoplayer2.upstream.DataReader;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    @Nullable
    private Extractor extractor;

    @Nullable
    private ExtractorInput extractorInput;
    private final ExtractorsFactory extractorsFactory;
    public boolean isNeedReselectExtractor = false;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.extractorsFactory = extractorsFactory;
    }

    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaExtractor
    public void disableSeekingOnMp3Streams() {
        Extractor extractor = this.extractor;
        if (extractor instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor).disableSeeking();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaExtractor
    public long getCurrentInputPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaExtractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) throws IOException {
        boolean z;
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataReader, j, j2);
        this.extractorInput = defaultExtractorInput;
        if (this.extractor == null || this.isNeedReselectExtractor) {
            Extractor[] extractorArrCreateExtractors = this.extractorsFactory.createExtractors(uri, map);
            if (extractorArrCreateExtractors.length == 1) {
                this.extractor = extractorArrCreateExtractors[0];
            } else {
                int length = extractorArrCreateExtractors.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Extractor extractor = extractorArrCreateExtractors[i];
                    try {
                    } catch (EOFException unused) {
                        if (this.extractor != null || defaultExtractorInput.getPosition() == j) {
                        }
                    } catch (Throwable th) {
                        Assertions.checkState(this.extractor != null || defaultExtractorInput.getPosition() == j);
                        defaultExtractorInput.resetPeekPosition();
                        throw th;
                    }
                    if (extractor.sniff(defaultExtractorInput)) {
                        if (!this.isNeedReselectExtractor || !extractor.toString().contains("Ffmpeg")) {
                            this.extractor = extractor;
                            Assertions.checkState(true);
                            defaultExtractorInput.resetPeekPosition();
                            break;
                        }
                        this.isNeedReselectExtractor = false;
                        z = this.extractor != null || defaultExtractorInput.getPosition() == j;
                    } else if (this.extractor != null || defaultExtractorInput.getPosition() == j) {
                    }
                    Assertions.checkState(z);
                    defaultExtractorInput.resetPeekPosition();
                    i++;
                }
                if (this.extractor == null) {
                    throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(extractorArrCreateExtractors) + ") could read the stream.", (Uri) Assertions.checkNotNull(uri));
                }
            }
            this.extractor.init(extractorOutput);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaExtractor
    public int read(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), positionHolder);
    }

    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        Extractor extractor = this.extractor;
        if (extractor != null) {
            extractor.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    @Override // com.oplus.tbl.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long j, long j2) {
        ((Extractor) Assertions.checkNotNull(this.extractor)).seek(j, j2);
    }
}
