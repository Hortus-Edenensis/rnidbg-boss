package com.oplus.tblplayer.extractor;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.extractor.Extractor;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.ffmpeg.FfmpegExtractor;
import com.oplus.tblplayer.ffmpeg.FfmpegLibrary;
import com.oplus.tblplayer.utils.LibraryLoaderDynamic;
import com.oplus.tblplayer.utils.LogUtil;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TBLExtractorsFactory extends DefaultExtractorsFactory2 {

    @Nullable
    private static final Constructor<? extends Extractor> FFMPEG_EXTENSION_EXTRACTOR_CONSTRUCTOR;
    private static final String TAG = "TBLExtractorsFactory";
    private int extractorMode;
    private int ffmpegExtractorFlags;

    static {
        Constructor<? extends Extractor> constructor = null;
        try {
            Boolean bool = Boolean.TRUE;
            int i = FfmpegLibrary.f7685a;
            if (bool.equals(FfmpegLibrary.class.getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                String str = FfmpegExtractor.TAG;
                constructor = FfmpegExtractor.class.asSubclass(Extractor.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            LogUtil.e(TAG, "There is some exception " + e.getMessage());
        }
        FFMPEG_EXTENSION_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    public TBLExtractorsFactory() {
        this(0, false);
    }

    private Constructor<? extends Extractor> reCreateFfmpegExtractor() {
        LogUtil.i(TAG, "FFMPEG_EXTENSION_EXTRACTOR_CONSTRUCTOR is null need get again");
        try {
            Boolean bool = Boolean.TRUE;
            int i = FfmpegLibrary.f7685a;
            boolean zEquals = bool.equals(FfmpegLibrary.class.getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]));
            LogUtil.d(TAG, "createExtractors: isFfmpegNativeLibraryAvailable " + zEquals);
            if (!zEquals) {
                return null;
            }
            String str = FfmpegExtractor.TAG;
            return FfmpegExtractor.class.asSubclass(Extractor.class).getConstructor(Integer.TYPE);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e) {
            LogUtil.e(TAG, "There is some exception " + e.getMessage());
            return null;
        }
    }

    @Override // com.oplus.tblplayer.extractor.DefaultExtractorsFactory2, com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        LogUtil.d(TAG, "createExtractors: extractor mode is " + LogUtil.getExtractorTypeString(this.extractorMode));
        arrayList = new ArrayList();
        int i = this.extractorMode;
        if (i == 0) {
            arrayList.addAll(Arrays.asList(super.createExtractors(uri, map)));
            Constructor<? extends Extractor> constructor = FFMPEG_EXTENSION_EXTRACTOR_CONSTRUCTOR;
            if (constructor != null) {
                try {
                    arrayList.add(constructor.newInstance(Integer.valueOf(this.ffmpegExtractorFlags)));
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating ffmpeg extractor", e);
                }
            } else {
                if (Globals.getDynamicLibrariesPath() != null && !LibraryLoaderDynamic.getNativeLibrariesLoaded().isEmpty()) {
                    try {
                        Constructor<? extends Extractor> constructorReCreateFfmpegExtractor = reCreateFfmpegExtractor();
                        if (constructorReCreateFfmpegExtractor != null) {
                            arrayList.add(constructorReCreateFfmpegExtractor.newInstance(Integer.valueOf(this.ffmpegExtractorFlags)));
                        }
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating ffmpeg extractor", e2);
                    }
                }
            }
        } else if (i != 2) {
            if (i != 3) {
                arrayList.addAll(Arrays.asList(super.createExtractors(uri, map)));
            } else {
                arrayList.addAll(Arrays.asList(super.createExtractors(uri, map)));
                Constructor<? extends Extractor> constructor2 = FFMPEG_EXTENSION_EXTRACTOR_CONSTRUCTOR;
                if (constructor2 != null) {
                    try {
                        arrayList.add(0, constructor2.newInstance(Integer.valueOf(this.ffmpegExtractorFlags)));
                    } catch (Exception e3) {
                        throw new IllegalStateException("Unexpected error creating ffmpeg extractor", e3);
                    }
                } else if (Globals.getDynamicLibrariesPath() != null && !LibraryLoaderDynamic.getNativeLibrariesLoaded().isEmpty()) {
                    try {
                        Constructor<? extends Extractor> constructorReCreateFfmpegExtractor2 = reCreateFfmpegExtractor();
                        if (constructorReCreateFfmpegExtractor2 != null) {
                            arrayList.add(constructorReCreateFfmpegExtractor2.newInstance(Integer.valueOf(this.ffmpegExtractorFlags)));
                        }
                    } catch (Exception e4) {
                        throw new IllegalStateException("Unexpected error creating ffmpeg extractor", e4);
                    }
                }
            }
        } else {
            Constructor<? extends Extractor> constructor3 = FFMPEG_EXTENSION_EXTRACTOR_CONSTRUCTOR;
            if (constructor3 != null) {
                try {
                    arrayList.add(constructor3.newInstance(Integer.valueOf(this.ffmpegExtractorFlags)));
                } catch (Exception e5) {
                    throw new IllegalStateException("Unexpected error creating ffmpeg extractor", e5);
                }
            } else {
                if (Globals.getDynamicLibrariesPath() != null && !LibraryLoaderDynamic.getNativeLibrariesLoaded().isEmpty()) {
                    try {
                        Constructor<? extends Extractor> constructorReCreateFfmpegExtractor3 = reCreateFfmpegExtractor();
                        if (constructorReCreateFfmpegExtractor3 != null) {
                            arrayList.add(constructorReCreateFfmpegExtractor3.newInstance(Integer.valueOf(this.ffmpegExtractorFlags)));
                        }
                    } catch (Exception e6) {
                        throw new IllegalStateException("Unexpected error creating ffmpeg extractor", e6);
                    }
                }
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    public TBLExtractorsFactory(int i, boolean z) {
        this.ffmpegExtractorFlags = z ? 1 : 0;
        this.extractorMode = i;
    }
}
