package androidx.media3.transformer;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.transformer.VideoEncoderSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import defpackage.ku2;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class CodecDbLite {
    private static final ImmutableListMultimap<Chipset, VideoEncoderEntry> ENCODER_DATASET;
    private static final VideoEncoderEntry ENCODER_DEFAULT = new VideoEncoderEntry("video/avc", 0, 0, 0);

    /* JADX INFO: compiled from: SearchBox */
    public static final class Chipset {
        private static final Chipset UNKNOWN = new Chipset("", "");
        private final String manufacturer;
        private final String model;

        public Chipset(String str, String str2) {
            this.manufacturer = str;
            this.model = str2;
        }

        public static Chipset current() {
            return Build.VERSION.SDK_INT >= 31 ? new Chipset(Build.SOC_MANUFACTURER, Build.SOC_MODEL) : UNKNOWN;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Chipset)) {
                return false;
            }
            Chipset chipset = (Chipset) obj;
            return Objects.equals(this.manufacturer, chipset.manufacturer) && Objects.equals(this.model, chipset.model);
        }

        public int hashCode() {
            return Objects.hash(this.manufacturer, this.model);
        }

        public String toString() {
            return String.format("Chipset(%s %s)", this.manufacturer, this.model);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class VideoEncoderEntry {
        private final int bFrameResolutionCutoff;
        private final int formatOptimizations;
        private final int maxBFrames;
        private final String mimeType;

        private VideoEncoderEntry(String str, int i, int i2, int i3) {
            this.mimeType = str;
            this.maxBFrames = i;
            this.bFrameResolutionCutoff = i2;
            this.formatOptimizations = i3;
        }
    }

    static {
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        int i9 = 497664000;
        int i10 = 1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        ENCODER_DATASET = ImmutableListMultimap.builder().f(new Chipset("Google", "Tensor G2"), new VideoEncoderEntry("video/hevc", i, 37538929, i2)).f(new Chipset("Google", "Tensor G2"), new VideoEncoderEntry("video/avc", i, 32739600, i2)).f(new Chipset("Google", "Tensor G3"), new VideoEncoderEntry("video/hevc", i, 37538350, i2)).f(new Chipset("Google", "Tensor G3"), new VideoEncoderEntry("video/avc", i, 32750593, i2)).f(new Chipset("Google", "Tensor G4"), new VideoEncoderEntry("video/av01", i, 32844500, i2)).f(new Chipset("Google", "Tensor G4"), new VideoEncoderEntry("video/hevc", i, 51851802, i2)).f(new Chipset("Google", "Tensor G4"), new VideoEncoderEntry("video/avc", i, 44206216, i2)).f(new Chipset("Mediatek", "MT6761"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6762"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6765"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6769T"), new VideoEncoderEntry("video/hevc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6769T"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6769Z"), new VideoEncoderEntry("video/hevc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6769Z"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6785"), new VideoEncoderEntry("video/hevc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6785"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6789V/CD"), new VideoEncoderEntry("video/hevc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6789V/CD"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6833V/NZA"), new VideoEncoderEntry("video/hevc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6833V/NZA"), new VideoEncoderEntry("video/avc", i3, i4, i2)).f(new Chipset("Mediatek", "MT6893"), new VideoEncoderEntry("video/hevc", i5, 34028841, i2)).f(new Chipset("Mediatek", "MT6893"), new VideoEncoderEntry("video/avc", i5, 457499715, i2)).f(new Chipset("Mediatek", "MT6983"), new VideoEncoderEntry("video/hevc", i5, 36134374, i2)).f(new Chipset("Mediatek", "MT6983"), new VideoEncoderEntry("video/avc", i5, 189533581, i2)).f(new Chipset("QTI", "SDM450"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM4350"), new VideoEncoderEntry("video/hevc", i6, i7, i2)).f(new Chipset("QTI", "SM4350"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM6125"), new VideoEncoderEntry("video/hevc", i6, i7, i2)).f(new Chipset("QTI", "SM6125"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM6225"), new VideoEncoderEntry("video/hevc", i6, i7, i2)).f(new Chipset("QTI", "SM6225"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM6375"), new VideoEncoderEntry("video/hevc", i6, i7, i2)).f(new Chipset("QTI", "SM6375"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM8250"), new VideoEncoderEntry("video/hevc", i6, i7, i2)).f(new Chipset("QTI", "SM8250"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM8350"), new VideoEncoderEntry("video/hevc", i6, i7, i2)).f(new Chipset("QTI", "SM8350"), new VideoEncoderEntry("video/avc", i6, i7, i2)).f(new Chipset("QTI", "SM8450"), new VideoEncoderEntry("video/hevc", i8, i9, i10)).f(new Chipset("QTI", "SM8450"), new VideoEncoderEntry("video/avc", i8, i9, i10)).f(new Chipset("QTI", "SM8475"), new VideoEncoderEntry("video/hevc", i8, i9, i10)).f(new Chipset("QTI", "SM8475"), new VideoEncoderEntry("video/avc", i8, i9, i10)).f(new Chipset("QTI", "SM8550"), new VideoEncoderEntry("video/hevc", i8, i9, i10)).f(new Chipset("QTI", "SM8550"), new VideoEncoderEntry("video/avc", i8, 110196681, i10)).f(new Chipset("QTI", "SM8650"), new VideoEncoderEntry("video/hevc", i8, 34344411, i10)).f(new Chipset("QTI", "SM8650"), new VideoEncoderEntry("video/avc", i8, 132451733, i10)).f(new Chipset("QTI", "SM8750"), new VideoEncoderEntry("video/hevc", i8, 52435727, i10)).f(new Chipset("QTI", "SM8750"), new VideoEncoderEntry("video/avc", i8, 159007069, i10)).f(new Chipset("Samsung", "Exynos 850"), new VideoEncoderEntry("video/hevc", i11, i12, i13)).f(new Chipset("Samsung", "Exynos 850"), new VideoEncoderEntry("video/avc", i11, i12, i13)).f(new Chipset("Samsung", "s5e8825"), new VideoEncoderEntry("video/hevc", i11, i12, i13)).f(new Chipset("Samsung", "s5e8825"), new VideoEncoderEntry("video/avc", i11, i12, i13)).f(new Chipset("Samsung", "s5e9925"), new VideoEncoderEntry("video/hevc", 1, 51506898, i13)).f(new Chipset("Samsung", "s5e9925"), new VideoEncoderEntry("video/avc", 2, 40856748, i13)).f(new Chipset("Spreadtrum", "SC9863A"), new VideoEncoderEntry("video/avc", i14, i15, i13)).f(new Chipset("Spreadtrum", "SC9863A"), new VideoEncoderEntry("video/hevc", i14, i15, i13)).f(new Chipset("Spreadtrum", "T606"), new VideoEncoderEntry("video/avc", i14, i15, i13)).f(new Chipset("Spreadtrum", "T606"), new VideoEncoderEntry("video/hevc", i14, i15, i13)).k();
    }

    private CodecDbLite() {
    }

    public static VideoEncoderSettings getRecommendedVideoEncoderSettings(Format format) {
        VideoEncoderEntry videoEncoderEntry;
        Assertions.checkArgument(MimeTypes.isVideo(format.sampleMimeType), "MIME must be a video MIME type.");
        Chipset chipsetCurrent = Chipset.current();
        ImmutableListMultimap<Chipset, VideoEncoderEntry> immutableListMultimap = ENCODER_DATASET;
        if (!immutableListMultimap.containsKey(chipsetCurrent)) {
            return VideoEncoderSettings.DEFAULT;
        }
        VideoEncoderSettings.Builder builder = new VideoEncoderSettings.Builder();
        ImmutableList<VideoEncoderEntry> immutableList = immutableListMultimap.get(chipsetCurrent);
        int i = 0;
        while (true) {
            if (i >= immutableList.size()) {
                videoEncoderEntry = null;
                break;
            }
            if (immutableList.get(i).mimeType.equals(format.sampleMimeType)) {
                videoEncoderEntry = immutableList.get(i);
                break;
            }
            i++;
        }
        if (videoEncoderEntry == null) {
            return builder.build();
        }
        if (((format.getPixelCount() == -1 || format.frameRate == -1.0f) ? Integer.MAX_VALUE : ku2.o(Math.round(format.getPixelCount() * format.frameRate))) < videoEncoderEntry.bFrameResolutionCutoff) {
            builder.setMaxBFrames(videoEncoderEntry.maxBFrames);
            if ((videoEncoderEntry.formatOptimizations & 1) != 0) {
                builder.setTemporalLayers(1, 2);
            }
        }
        return builder.build();
    }

    public static String getRecommendedVideoMimeType() {
        Chipset chipsetCurrent = Chipset.current();
        if (chipsetCurrent.equals(Chipset.UNKNOWN)) {
            return ENCODER_DEFAULT.mimeType;
        }
        ImmutableListMultimap<Chipset, VideoEncoderEntry> immutableListMultimap = ENCODER_DATASET;
        return !immutableListMultimap.containsKey(chipsetCurrent) ? ENCODER_DEFAULT.mimeType : immutableListMultimap.get(chipsetCurrent).get(0).mimeType;
    }
}
