package com.opos.exoplayer.core.extractor;

import com.opos.exoplayer.core.extractor.mkv.MatroskaExtractor;
import com.opos.exoplayer.core.extractor.mp3.Mp3Extractor;
import com.opos.exoplayer.core.extractor.mp4.FragmentedMp4Extractor;
import com.opos.exoplayer.core.extractor.mp4.Mp4Extractor;
import com.opos.exoplayer.core.extractor.ts.TsExtractor;
import com.opos.exoplayer.core.extractor.ts.o;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Constructor<? extends e> f8176a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f = 1;
    private int g;

    static {
        Constructor<? extends e> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating FLAC extension", e);
        }
        f8176a = constructor;
    }

    @Override // com.opos.exoplayer.core.extractor.h
    public synchronized e[] a() {
        e[] eVarArr;
        Constructor<? extends e> constructor = f8176a;
        eVarArr = new e[constructor == null ? 11 : 12];
        eVarArr[0] = new MatroskaExtractor(this.b);
        eVarArr[1] = new FragmentedMp4Extractor(this.d);
        eVarArr[2] = new Mp4Extractor(this.c);
        eVarArr[3] = new Mp3Extractor(this.e);
        eVarArr[4] = new com.opos.exoplayer.core.extractor.ts.c();
        eVarArr[5] = new com.opos.exoplayer.core.extractor.ts.a();
        eVarArr[6] = new TsExtractor(this.f, this.g);
        eVarArr[7] = new com.opos.exoplayer.core.extractor.a.a();
        eVarArr[8] = new com.opos.exoplayer.core.extractor.b.a();
        eVarArr[9] = new o();
        eVarArr[10] = new com.opos.exoplayer.core.extractor.c.a();
        if (constructor != null) {
            try {
                eVarArr[11] = constructor.newInstance(new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return eVarArr;
    }
}
