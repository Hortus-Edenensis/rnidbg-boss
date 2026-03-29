package com.oplus.tbl.exoplayer2.extractor;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.extractor.amr.AmrExtractor;
import com.oplus.tbl.exoplayer2.extractor.flac.FlacExtractor;
import com.oplus.tbl.exoplayer2.extractor.flv.FlvExtractor;
import com.oplus.tbl.exoplayer2.extractor.jpeg.JpegExtractor;
import com.oplus.tbl.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.oplus.tbl.exoplayer2.extractor.mp3.Mp3Extractor;
import com.oplus.tbl.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.oplus.tbl.exoplayer2.extractor.mp4.Mp4Extractor;
import com.oplus.tbl.exoplayer2.extractor.ogg.OggExtractor;
import com.oplus.tbl.exoplayer2.extractor.ts.Ac3Extractor;
import com.oplus.tbl.exoplayer2.extractor.ts.Ac4Extractor;
import com.oplus.tbl.exoplayer2.extractor.ts.AdtsExtractor;
import com.oplus.tbl.exoplayer2.extractor.ts.PsExtractor;
import com.oplus.tbl.exoplayer2.extractor.ts.TsExtractor;
import com.oplus.tbl.exoplayer2.extractor.wav.WavExtractor;
import com.oplus.tbl.exoplayer2.util.FileTypes;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final int[] DEFAULT_EXTRACTOR_ORDER = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    @Nullable
    private static final Constructor<? extends Extractor> FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private int flacFlags;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode = 1;
    private int tsTimestampSearchBytes = 112800;

    static {
        Constructor<? extends Extractor> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.oplus.tbl.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.oplus.tbl.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating FLAC extension", e);
        }
        FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    private void addExtractorsForFileType(int i, List<Extractor> list) {
        Extractor ac3Extractor;
        switch (i) {
            case 0:
                ac3Extractor = new Ac3Extractor();
                break;
            case 1:
                ac3Extractor = new Ac4Extractor();
                break;
            case 2:
                ac3Extractor = new AdtsExtractor(this.adtsFlags | (this.constantBitrateSeekingEnabled ? 1 : 0));
                break;
            case 3:
                ac3Extractor = new AmrExtractor(this.amrFlags | (this.constantBitrateSeekingEnabled ? 1 : 0));
                break;
            case 4:
                Constructor<? extends Extractor> constructor = FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
                if (constructor == null) {
                    ac3Extractor = new FlacExtractor(this.flacFlags);
                    break;
                } else {
                    try {
                        list.add(constructor.newInstance(Integer.valueOf(this.flacFlags)));
                        return;
                    } catch (Exception e) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                    }
                }
                break;
            case 5:
                ac3Extractor = new FlvExtractor();
                break;
            case 6:
                ac3Extractor = new MatroskaExtractor(this.matroskaFlags);
                break;
            case 7:
                ac3Extractor = new Mp3Extractor(this.mp3Flags | (this.constantBitrateSeekingEnabled ? 1 : 0));
                break;
            case 8:
                list.add(new FragmentedMp4Extractor(this.fragmentedMp4Flags));
                ac3Extractor = new Mp4Extractor(this.mp4Flags);
                break;
            case 9:
                ac3Extractor = new OggExtractor();
                break;
            case 10:
                ac3Extractor = new PsExtractor();
                break;
            case 11:
                ac3Extractor = new TsExtractor(this.tsMode, this.tsFlags, this.tsTimestampSearchBytes);
                break;
            case 12:
                ac3Extractor = new WavExtractor();
                break;
            case 13:
            default:
                return;
            case 14:
                ac3Extractor = new JpegExtractor();
                break;
        }
        list.add(ac3Extractor);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    public synchronized DefaultExtractorsFactory setAdtsExtractorFlags(int i) {
        this.adtsFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAmrExtractorFlags(int i) {
        this.amrFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.constantBitrateSeekingEnabled = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFlacExtractorFlags(int i) {
        this.flacFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i) {
        this.fragmentedMp4Flags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i) {
        this.matroskaFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i) {
        this.mp3Flags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i) {
        this.mp4Flags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i) {
        this.tsFlags = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i) {
        this.tsMode = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int i) {
        this.tsTimestampSearchBytes = i;
        return this;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iInferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
        if (iInferFileTypeFromResponseHeaders != -1) {
            addExtractorsForFileType(iInferFileTypeFromResponseHeaders, arrayList);
        }
        int iInferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
        if (iInferFileTypeFromUri != -1 && iInferFileTypeFromUri != iInferFileTypeFromResponseHeaders) {
            addExtractorsForFileType(iInferFileTypeFromUri, arrayList);
        }
        for (int i : DEFAULT_EXTRACTOR_ORDER) {
            if (i != iInferFileTypeFromResponseHeaders && i != iInferFileTypeFromUri) {
                addExtractorsForFileType(i, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }
}
