package com.oplus.tbl.exoplayer2.extractor.mkv;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.audio.AacUtil;
import com.oplus.tbl.exoplayer2.audio.Ac3Util;
import com.oplus.tbl.exoplayer2.drm.DrmInitData;
import com.oplus.tbl.exoplayer2.extractor.ChunkIndex;
import com.oplus.tbl.exoplayer2.extractor.Extractor;
import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorOutput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.PositionHolder;
import com.oplus.tbl.exoplayer2.extractor.SeekMap;
import com.oplus.tbl.exoplayer2.extractor.TrackOutput;
import com.oplus.tbl.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.oplus.tbl.exoplayer2.upstream.DataReader;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.LongArray;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tbl.exoplayer2.util.NalUnitUtil;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.AvcConfig;
import com.oplus.tbl.exoplayer2.video.DolbyVisionConfig;
import com.oplus.tbl.exoplayer2.video.HevcConfig;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MatroskaExtractor implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final Map<String, Integer> TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private final ParsableByteArray blockAdditionalData;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;

    @Nullable
    private LongArray cueClusterPositions;

    @Nullable
    private LongArray cueTimesUs;
    private long cuesContentPosition;

    @Nullable
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: ee3
        @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return MatroskaExtractor.lambda$static$0();
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
        public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
            return ws1.a(this, uri, map);
        }
    };
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int i, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int i) {
            return MatroskaExtractor.this.getElementType(i);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int i) {
            return MatroskaExtractor.this.isLevel1Element(i);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        private int blockAddIdType;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        private String language;
        public int maxBlockAdditionId;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionType = -1;
            this.projectionPoseYaw = 0.0f;
            this.projectionPosePitch = 0.0f;
            this.projectionPoseRoll = 0.0f;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assertOutputInitialized() {
            Assertions.checkNotNull(this.output);
        }

        private byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw new ParserException("Missing CodecPrivate for codec " + str);
        }

        @Nullable
        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.maxMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) (this.minMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) this.maxContentLuminance);
            byteBufferOrder.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (littleEndianUnsignedInt == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (littleEndianUnsignedInt == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (littleEndianUnsignedInt != 826496599) {
                    Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>("video/x-unknown", null);
                }
                byte[] data = parsableByteArray.getData();
                for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                    if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                    }
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort == 1) {
                    return true;
                }
                if (littleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits()) {
                    if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i3 = 1;
                int i4 = 0;
                while (true) {
                    i = bArr[i3];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i4 += 255;
                    i3++;
                }
                int i5 = i3 + 1;
                int i6 = i4 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:197:0x03ff  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0418  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x041a  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0427  */
        /* JADX WARN: Removed duplicated region for block: B:207:0x0439  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x0507  */
        /* JADX WARN: Removed duplicated region for block: B:272:0x055a  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        @OptIn(markerClass = {UnstableApi.class})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void initializeOutput(ExtractorOutput extractorOutput, int i) throws ParserException {
            byte b;
            String str;
            List<byte[]> listSingletonList;
            StringBuilder sb;
            String str2;
            int i2;
            String str3;
            List<byte[]> list;
            String str4;
            byte[] bArr;
            String str5;
            Format.Builder builder;
            int i3;
            int i4;
            DolbyVisionConfig dolbyVisionConfig;
            String str6 = this.codecId;
            str6.hashCode();
            int pcmEncoding = 4;
            int i5 = 3;
            int i6 = 0;
            switch (str6.hashCode()) {
                case -2095576542:
                    b = !str6.equals(MatroskaExtractor.CODEC_ID_MPEG4_AP) ? (byte) -1 : (byte) 0;
                    break;
                case -2095575984:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_MPEG4_SP)) {
                        b = 1;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_ACM)) {
                        b = 2;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_TRUEHD)) {
                        b = 3;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_VORBIS)) {
                        b = 4;
                        break;
                    }
                    break;
                case -1482641358:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_MP2)) {
                        b = 5;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_MP3)) {
                        b = 6;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_FOURCC)) {
                        b = 7;
                        break;
                    }
                    break;
                case -933872740:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_DVBSUB)) {
                        b = 8;
                        break;
                    }
                    break;
                case -538363189:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_MPEG4_ASP)) {
                        b = 9;
                        break;
                    }
                    break;
                case -538363109:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_H264)) {
                        b = 10;
                        break;
                    }
                    break;
                case -425012669:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_VOBSUB)) {
                        b = 11;
                        break;
                    }
                    break;
                case -356037306:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_DTS_LOSSLESS)) {
                        b = 12;
                        break;
                    }
                    break;
                case 62923557:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_AAC)) {
                        b = dn.k;
                        break;
                    }
                    break;
                case 62923603:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_AC3)) {
                        b = dn.l;
                        break;
                    }
                    break;
                case 62927045:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_DTS)) {
                        b = 15;
                        break;
                    }
                    break;
                case 82318131:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_AV1)) {
                        b = 16;
                        break;
                    }
                    break;
                case 82338133:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_VP8)) {
                        b = 17;
                        break;
                    }
                    break;
                case 82338134:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_VP9)) {
                        b = 18;
                        break;
                    }
                    break;
                case 99146302:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_PGS)) {
                        b = 19;
                        break;
                    }
                    break;
                case 444813526:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_THEORA)) {
                        b = 20;
                        break;
                    }
                    break;
                case 542569478:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_DTS_EXPRESS)) {
                        b = 21;
                        break;
                    }
                    break;
                case 635596514:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_PCM_FLOAT)) {
                        b = 22;
                        break;
                    }
                    break;
                case 725948237:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_PCM_INT_BIG)) {
                        b = 23;
                        break;
                    }
                    break;
                case 725957860:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_PCM_INT_LIT)) {
                        b = 24;
                        break;
                    }
                    break;
                case 738597099:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_ASS)) {
                        b = 25;
                        break;
                    }
                    break;
                case 855502857:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_H265)) {
                        b = 26;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_SUBRIP)) {
                        b = 27;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_MPEG2)) {
                        b = 28;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_E_AC3)) {
                        b = 29;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_FLAC)) {
                        b = 30;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str6.equals(MatroskaExtractor.CODEC_ID_OPUS)) {
                        b = TELogUtils.DEBUG_LEVEL_V;
                        break;
                    }
                    break;
            }
            String str7 = "audio/raw";
            switch (b) {
                case 0:
                case 1:
                case 9:
                    str = "application/pgs";
                    byte[] bArr2 = this.codecPrivate;
                    listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                    str7 = "video/mp4v-es";
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null && (dolbyVisionConfig = DolbyVisionConfig.parse(new ParsableByteArray(bArr))) != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str7 = "video/dolby-vision";
                    }
                    str5 = str7;
                    int i7 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(pcmEncoding);
                        i5 = 1;
                    } else if (MimeTypes.isVideo(str5)) {
                        if (this.displayUnit == 0) {
                            int i8 = this.displayWidth;
                            i3 = -1;
                            if (i8 == -1) {
                                i8 = this.width;
                            }
                            this.displayWidth = i8;
                            int i9 = this.displayHeight;
                            if (i9 == -1) {
                                i9 = this.height;
                            }
                            this.displayHeight = i9;
                        } else {
                            i3 = -1;
                        }
                        float f = (this.displayWidth == i3 || (i4 = this.displayHeight) == i3) ? -1.0f : (this.height * r2) / (this.width * i4);
                        ColorInfo colorInfoBuild = this.hasColorInfo ? new ColorInfo.Builder().setColorSpace(this.colorSpace).setColorRange(this.colorRange).setColorTransfer(this.colorTransfer).setHdrStaticInfo(getHdrStaticInfo()).build() : null;
                        int iIntValue = (this.name == null || !MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) ? -1 : ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                        if (this.projectionType == 0 && Float.compare(this.projectionPoseYaw, 0.0f) == 0 && Float.compare(this.projectionPosePitch, 0.0f) == 0) {
                            if (Float.compare(this.projectionPoseRoll, 0.0f) != 0) {
                                if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    i6 = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) == 0 || Float.compare(this.projectionPosePitch, 180.0f) == 0) {
                                    i6 = EffectConstants.ROTATION_DEGREES_180;
                                } else if (Float.compare(this.projectionPosePitch, -90.0f) == 0) {
                                    i6 = 270;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i6).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i5 = 2;
                        } else {
                            i6 = iIntValue;
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i6).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i5 = 2;
                        }
                    } else if (!"application/x-subrip".equals(str5) && !"text/x-ssa".equals(str5) && !"application/vobsub".equals(str5) && !str.equals(str5) && !"application/dvbsubs".equals(str5)) {
                        throw new ParserException("Unexpected MIME type.");
                    }
                    if (this.name != null && !MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack;
                    trackOutputTrack.format(formatBuild);
                    return;
                case 2:
                    str = "application/pgs";
                    if (!parseMsAcmCodecPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)))) {
                        sb = new StringBuilder();
                        sb.append("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w(MatroskaExtractor.TAG, sb.toString());
                        str7 = "audio/x-unknown";
                        listSingletonList = null;
                        str3 = null;
                        pcmEncoding = -1;
                        i2 = -1;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        str5 = str7;
                        int i72 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str5)) {
                        }
                        if (this.name != null) {
                        }
                        Format formatBuild2 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack2 = extractorOutput.track(this.number, i5);
                        this.output = trackOutputTrack2;
                        trackOutputTrack2.format(formatBuild2);
                        return;
                    }
                    pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding == 0) {
                        sb = new StringBuilder();
                        str2 = "Unsupported PCM bit depth: ";
                        sb.append(str2);
                        sb.append(this.audioBitDepth);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w(MatroskaExtractor.TAG, sb.toString());
                        str7 = "audio/x-unknown";
                        listSingletonList = null;
                        str3 = null;
                        pcmEncoding = -1;
                        i2 = -1;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                            str3 = dolbyVisionConfig.codecs;
                            str7 = "video/dolby-vision";
                        }
                        str5 = str7;
                        int i722 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str5)) {
                        }
                        if (this.name != null) {
                            builder.setLabel(this.name);
                        }
                        Format formatBuild22 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack22 = extractorOutput.track(this.number, i5);
                        this.output = trackOutputTrack22;
                        trackOutputTrack22.format(formatBuild22);
                        return;
                    }
                    listSingletonList = null;
                    str3 = null;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222;
                    trackOutputTrack222.format(formatBuild222);
                    return;
                case 3:
                    str = "application/pgs";
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str7 = "audio/true-hd";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222;
                    trackOutputTrack2222.format(formatBuild2222);
                    return;
                case 4:
                    str = "application/pgs";
                    listSingletonList = parseVorbisCodecPrivate(getCodecPrivate(this.codecId));
                    str7 = "audio/vorbis";
                    i2 = 8192;
                    str3 = null;
                    pcmEncoding = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222;
                    trackOutputTrack22222.format(formatBuild22222);
                    return;
                case 5:
                    str = "application/pgs";
                    str7 = "audio/mpeg-L2";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = 4096;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222;
                    trackOutputTrack222222.format(formatBuild222222);
                    return;
                case 6:
                    str = "application/pgs";
                    str7 = "audio/mpeg";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = 4096;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222;
                    trackOutputTrack2222222.format(formatBuild2222222);
                    return;
                case 7:
                    str = "application/pgs";
                    Pair<String, List<byte[]>> fourCcPrivate = parseFourCcPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    str7 = (String) fourCcPrivate.first;
                    listSingletonList = (List) fourCcPrivate.second;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222;
                    trackOutputTrack22222222.format(formatBuild22222222);
                    return;
                case 8:
                    str = "application/pgs";
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(getCodecPrivate(this.codecId), 0, bArr3, 0, 4);
                    listSingletonList = ImmutableList.of(bArr3);
                    str7 = "application/dvbsubs";
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222;
                    trackOutputTrack222222222.format(formatBuild222222222);
                    return;
                case 10:
                    str = "application/pgs";
                    AvcConfig avcConfig = AvcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list = avcConfig.initializationData;
                    this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                    str4 = avcConfig.codecs;
                    str7 = "video/avc";
                    pcmEncoding = -1;
                    i2 = -1;
                    List<byte[]> list2 = list;
                    str3 = str4;
                    listSingletonList = list2;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222;
                    trackOutputTrack2222222222.format(formatBuild2222222222);
                    return;
                case 11:
                    str = "application/pgs";
                    listSingletonList = ImmutableList.of(getCodecPrivate(this.codecId));
                    str7 = "application/vobsub";
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222222;
                    trackOutputTrack22222222222.format(formatBuild22222222222);
                    return;
                case 12:
                    str = "application/pgs";
                    str7 = "audio/vnd.dts.hd";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222222;
                    trackOutputTrack222222222222.format(formatBuild222222222222);
                    return;
                case 13:
                    str = "application/pgs";
                    listSingletonList = Collections.singletonList(getCodecPrivate(this.codecId));
                    AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(this.codecPrivate);
                    this.sampleRate = audioSpecificConfig.sampleRateHz;
                    this.channelCount = audioSpecificConfig.channelCount;
                    str3 = audioSpecificConfig.codecs;
                    str7 = "audio/mp4a-latm";
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222;
                    trackOutputTrack2222222222222.format(formatBuild2222222222222);
                    return;
                case 14:
                    str = "application/pgs";
                    str7 = "audio/ac3";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222222222;
                    trackOutputTrack22222222222222.format(formatBuild22222222222222);
                    return;
                case 15:
                case 21:
                    str = "application/pgs";
                    str7 = "audio/vnd.dts";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222222222;
                    trackOutputTrack222222222222222.format(formatBuild222222222222222);
                    return;
                case 16:
                    str = "application/pgs";
                    str7 = "video/av01";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222;
                    trackOutputTrack2222222222222222.format(formatBuild2222222222222222);
                    return;
                case 17:
                    str = "application/pgs";
                    str7 = "video/x-vnd.on2.vp8";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222222222222;
                    trackOutputTrack22222222222222222.format(formatBuild22222222222222222);
                    return;
                case 18:
                    str = "application/pgs";
                    str7 = "video/x-vnd.on2.vp9";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222222222222;
                    trackOutputTrack222222222222222222.format(formatBuild222222222222222222);
                    return;
                case 19:
                    str = "application/pgs";
                    listSingletonList = null;
                    str3 = null;
                    str7 = str;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222222;
                    trackOutputTrack2222222222222222222.format(formatBuild2222222222222222222);
                    return;
                case 20:
                    str = "application/pgs";
                    str7 = "video/x-unknown";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222222222222222;
                    trackOutputTrack22222222222222222222.format(formatBuild22222222222222222222);
                    return;
                case 22:
                    str = "application/pgs";
                    if (this.audioBitDepth != 32) {
                        sb = new StringBuilder();
                        str2 = "Unsupported floating point PCM bit depth: ";
                        sb.append(str2);
                        sb.append(this.audioBitDepth);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w(MatroskaExtractor.TAG, sb.toString());
                        str7 = "audio/x-unknown";
                        listSingletonList = null;
                        str3 = null;
                        pcmEncoding = -1;
                        i2 = -1;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        str5 = str7;
                        int i7222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str5)) {
                        }
                        if (this.name != null) {
                        }
                        Format formatBuild222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack222222222222222222222 = extractorOutput.track(this.number, i5);
                        this.output = trackOutputTrack222222222222222222222;
                        trackOutputTrack222222222222222222222.format(formatBuild222222222222222222222);
                        return;
                    }
                    listSingletonList = null;
                    str3 = null;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222222222;
                    trackOutputTrack2222222222222222222222.format(formatBuild2222222222222222222222);
                    return;
                case 23:
                    str = "application/pgs";
                    int i10 = this.audioBitDepth;
                    if (i10 == 8) {
                        listSingletonList = null;
                        str3 = null;
                        pcmEncoding = 3;
                        i2 = -1;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        str5 = str7;
                        int i722222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str5)) {
                        }
                        if (this.name != null) {
                        }
                        Format formatBuild22222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack22222222222222222222222 = extractorOutput.track(this.number, i5);
                        this.output = trackOutputTrack22222222222222222222222;
                        trackOutputTrack22222222222222222222222.format(formatBuild22222222222222222222222);
                        return;
                    }
                    if (i10 == 16) {
                        pcmEncoding = 268435456;
                        listSingletonList = null;
                        str3 = null;
                        i2 = -1;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        str5 = str7;
                        int i7222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str5)) {
                        }
                        if (this.name != null) {
                        }
                        Format formatBuild222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack222222222222222222222222 = extractorOutput.track(this.number, i5);
                        this.output = trackOutputTrack222222222222222222222222;
                        trackOutputTrack222222222222222222222222.format(formatBuild222222222222222222222222);
                        return;
                    }
                    sb = new StringBuilder();
                    str2 = "Unsupported big endian PCM bit depth: ";
                    sb.append(str2);
                    sb.append(this.audioBitDepth);
                    sb.append(". Setting mimeType to ");
                    sb.append("audio/x-unknown");
                    Log.w(MatroskaExtractor.TAG, sb.toString());
                    str7 = "audio/x-unknown";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222222222222;
                    trackOutputTrack2222222222222222222222222.format(formatBuild2222222222222222222222222);
                    return;
                case 24:
                    str = "application/pgs";
                    pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding == 0) {
                        sb = new StringBuilder();
                        str2 = "Unsupported little endian PCM bit depth: ";
                        sb.append(str2);
                        sb.append(this.audioBitDepth);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w(MatroskaExtractor.TAG, sb.toString());
                        str7 = "audio/x-unknown";
                        listSingletonList = null;
                        str3 = null;
                        pcmEncoding = -1;
                        i2 = -1;
                        bArr = this.dolbyVisionConfigBytes;
                        if (bArr != null) {
                        }
                        str5 = str7;
                        int i722222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str5)) {
                        }
                        if (this.name != null) {
                        }
                        Format formatBuild22222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack22222222222222222222222222 = extractorOutput.track(this.number, i5);
                        this.output = trackOutputTrack22222222222222222222222222;
                        trackOutputTrack22222222222222222222222222.format(formatBuild22222222222222222222222222);
                        return;
                    }
                    listSingletonList = null;
                    str3 = null;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222222222222222222222;
                    trackOutputTrack222222222222222222222222222.format(formatBuild222222222222222222222222222);
                    return;
                case 25:
                    str = "application/pgs";
                    listSingletonList = ImmutableList.of(MatroskaExtractor.SSA_DIALOGUE_FORMAT, getCodecPrivate(this.codecId));
                    str7 = "text/x-ssa";
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222222222222222;
                    trackOutputTrack2222222222222222222222222222.format(formatBuild2222222222222222222222222222);
                    return;
                case 26:
                    str = "application/pgs";
                    HevcConfig hevcConfig = HevcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list = hevcConfig.initializationData;
                    this.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    str4 = hevcConfig.codecs;
                    str7 = "video/hevc";
                    pcmEncoding = -1;
                    i2 = -1;
                    List<byte[]> list22 = list;
                    str3 = str4;
                    listSingletonList = list22;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222222222222222222222222;
                    trackOutputTrack22222222222222222222222222222.format(formatBuild22222222222222222222222222222);
                    return;
                case 27:
                    str = "application/pgs";
                    str7 = "application/x-subrip";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222222222222222222222222;
                    trackOutputTrack222222222222222222222222222222.format(formatBuild222222222222222222222222222222);
                    return;
                case 28:
                    str = "application/pgs";
                    str7 = "video/mpeg2";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222222222222222222;
                    trackOutputTrack2222222222222222222222222222222.format(formatBuild2222222222222222222222222222222);
                    return;
                case 29:
                    str = "application/pgs";
                    str7 = "audio/eac3";
                    listSingletonList = null;
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i722222222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild22222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i722222222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack22222222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack22222222222222222222222222222222;
                    trackOutputTrack22222222222222222222222222222222.format(formatBuild22222222222222222222222222222222);
                    return;
                case 30:
                    str = "application/pgs";
                    listSingletonList = Collections.singletonList(getCodecPrivate(this.codecId));
                    str7 = "audio/flac";
                    str3 = null;
                    pcmEncoding = -1;
                    i2 = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i7222222222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild222222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i7222222222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack222222222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack222222222222222222222222222222222;
                    trackOutputTrack222222222222222222222222222222222.format(formatBuild222222222222222222222222222222222);
                    return;
                case 31:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(getCodecPrivate(this.codecId));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    str = "application/pgs";
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.codecDelayNs).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.seekPreRollNs).array());
                    str7 = "audio/opus";
                    i2 = MatroskaExtractor.OPUS_MAX_INPUT_SIZE;
                    str3 = null;
                    pcmEncoding = -1;
                    bArr = this.dolbyVisionConfigBytes;
                    if (bArr != null) {
                    }
                    str5 = str7;
                    int i72222222222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0 | (this.flagForced ? 2 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str5)) {
                    }
                    if (this.name != null) {
                    }
                    Format formatBuild2222222222222222222222222222222222 = builder.setId(i).setSampleMimeType(str5).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i72222222222222222222222222222222222).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack2222222222222222222222222222222222 = extractorOutput.track(this.number, i5);
                    this.output = trackOutputTrack2222222222222222222222222222222222;
                    trackOutputTrack2222222222222222222222222222222222.format(formatBuild2222222222222222222222222222222222);
                    return;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
        }

        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class TrueHdSampleRechunker {
        private int chunkFlags;
        private int chunkOffset;
        private int chunkSampleCount;
        private int chunkSize;
        private long chunkTimeUs;
        private boolean foundSyncframe;
        private final byte[] syncframePrefix = new byte[10];

        public void outputPendingSampleMetadata(Track track) {
            if (this.chunkSampleCount > 0) {
                track.output.sampleMetadata(this.chunkTimeUs, this.chunkFlags, this.chunkSize, this.chunkOffset, track.cryptoData);
                this.chunkSampleCount = 0;
            }
        }

        public void reset() {
            this.foundSyncframe = false;
            this.chunkSampleCount = 0;
        }

        public void sampleMetadata(Track track, long j, int i, int i2, int i3) {
            if (this.foundSyncframe) {
                int i4 = this.chunkSampleCount;
                int i5 = i4 + 1;
                this.chunkSampleCount = i5;
                if (i4 == 0) {
                    this.chunkTimeUs = j;
                    this.chunkFlags = i;
                    this.chunkSize = 0;
                }
                this.chunkSize += i2;
                this.chunkOffset = i3;
                if (i5 >= 16) {
                    outputPendingSampleMetadata(track);
                }
            }
        }

        public void startSample(ExtractorInput extractorInput) throws IOException {
            if (this.foundSyncframe) {
                return;
            }
            extractorInput.peekFully(this.syncframePrefix, 0, 10);
            extractorInput.resetPeekPosition();
            if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) == 0) {
                return;
            }
            this.foundSyncframe = true;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(EffectConstants.ROTATION_DEGREES_180));
        map.put("htc_video_rotA-270", 270);
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor() {
        this(0);
    }

    private void assertInCues(int i) throws ParserException {
        if (this.cueTimesUs == null || this.cueClusterPositions == null) {
            throw new ParserException("Element " + i + " must be in a Cues");
        }
    }

    private void assertInTrackEntry(int i) throws ParserException {
        if (this.currentTrack != null) {
            return;
        }
        throw new ParserException("Element " + i + " must be in a TrackEntry");
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.extractorOutput);
    }

    private SeekMap buildSeekMap(@Nullable LongArray longArray, @Nullable LongArray longArray2) {
        int i;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || longArray == null || longArray.size() == 0 || longArray2 == null || longArray2.size() != longArray.size()) {
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = longArray.size();
        int[] iArrCopyOf = new int[size];
        long[] jArrCopyOf = new long[size];
        long[] jArrCopyOf2 = new long[size];
        long[] jArrCopyOf3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArrCopyOf3[i3] = longArray.get(i3);
            jArrCopyOf[i3] = this.segmentContentPosition + longArray2.get(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArrCopyOf[i2] = (int) (jArrCopyOf[i4] - jArrCopyOf[i2]);
            jArrCopyOf2[i2] = jArrCopyOf3[i4] - jArrCopyOf3[i2];
            i2 = i4;
        }
        iArrCopyOf[i] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArrCopyOf[i]);
        long j = this.durationUs - jArrCopyOf3[i];
        jArrCopyOf2[i] = j;
        if (j <= 0) {
            Log.w(TAG, "Discarding last cue point with unexpected duration: " + j);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i);
        }
        return new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private void commitSampleToOutput(Track track, long j, int i, int i2, int i3) {
        String str;
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, j, i, i2, i3);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId) || CODEC_ID_ASS.equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    str = "Skipping subtitle sample in laced block.";
                } else {
                    long j2 = this.blockDurationUs;
                    if (j2 == -9223372036854775807L) {
                        str = "Skipping subtitle sample with no duration.";
                    } else {
                        setSubtitleEndTime(track.codecId, j2, this.subtitleSample.getData());
                        int position = this.subtitleSample.getPosition();
                        while (true) {
                            if (position >= this.subtitleSample.limit()) {
                                break;
                            }
                            if (this.subtitleSample.getData()[position] == 0) {
                                this.subtitleSample.setLimit(position);
                                break;
                            }
                            position++;
                        }
                        TrackOutput trackOutput = track.output;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        i2 += this.subtitleSample.limit();
                    }
                }
                Log.w(TAG, str);
            }
            if ((268435456 & i) != 0) {
                if (this.blockSampleCount > 1) {
                    i &= -268435457;
                } else {
                    int iLimit = this.blockAdditionalData.limit();
                    track.output.sampleData(this.blockAdditionalData, iLimit, 2);
                    i2 += iLimit;
                }
            }
            track.output.sampleMetadata(j, i, i2, i3, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private static int[] ensureArrayCapacity(@Nullable int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private int finishWriteSampleData() {
        int i = this.sampleBytesWritten;
        resetWriteSampleData();
        return i;
    }

    private static byte[] formatSubtitleTimecode(long j, String str, long j2) {
        Assertions.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    private Track getCurrentTrack(int i) throws ParserException {
        assertInTrackEntry(i);
        return this.currentTrack;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean isCodecSupported(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals(CODEC_ID_MPEG4_AP)) {
                    b = 0;
                }
                break;
            case -2095575984:
                if (str.equals(CODEC_ID_MPEG4_SP)) {
                    b = 1;
                }
                break;
            case -1985379776:
                if (str.equals(CODEC_ID_ACM)) {
                    b = 2;
                }
                break;
            case -1784763192:
                if (str.equals(CODEC_ID_TRUEHD)) {
                    b = 3;
                }
                break;
            case -1730367663:
                if (str.equals(CODEC_ID_VORBIS)) {
                    b = 4;
                }
                break;
            case -1482641358:
                if (str.equals(CODEC_ID_MP2)) {
                    b = 5;
                }
                break;
            case -1482641357:
                if (str.equals(CODEC_ID_MP3)) {
                    b = 6;
                }
                break;
            case -1373388978:
                if (str.equals(CODEC_ID_FOURCC)) {
                    b = 7;
                }
                break;
            case -933872740:
                if (str.equals(CODEC_ID_DVBSUB)) {
                    b = 8;
                }
                break;
            case -538363189:
                if (str.equals(CODEC_ID_MPEG4_ASP)) {
                    b = 9;
                }
                break;
            case -538363109:
                if (str.equals(CODEC_ID_H264)) {
                    b = 10;
                }
                break;
            case -425012669:
                if (str.equals(CODEC_ID_VOBSUB)) {
                    b = 11;
                }
                break;
            case -356037306:
                if (str.equals(CODEC_ID_DTS_LOSSLESS)) {
                    b = 12;
                }
                break;
            case 62923557:
                if (str.equals(CODEC_ID_AAC)) {
                    b = dn.k;
                }
                break;
            case 62923603:
                if (str.equals(CODEC_ID_AC3)) {
                    b = dn.l;
                }
                break;
            case 62927045:
                if (str.equals(CODEC_ID_DTS)) {
                    b = 15;
                }
                break;
            case 82318131:
                if (str.equals(CODEC_ID_AV1)) {
                    b = 16;
                }
                break;
            case 82338133:
                if (str.equals(CODEC_ID_VP8)) {
                    b = 17;
                }
                break;
            case 82338134:
                if (str.equals(CODEC_ID_VP9)) {
                    b = 18;
                }
                break;
            case 99146302:
                if (str.equals(CODEC_ID_PGS)) {
                    b = 19;
                }
                break;
            case 444813526:
                if (str.equals(CODEC_ID_THEORA)) {
                    b = 20;
                }
                break;
            case 542569478:
                if (str.equals(CODEC_ID_DTS_EXPRESS)) {
                    b = 21;
                }
                break;
            case 635596514:
                if (str.equals(CODEC_ID_PCM_FLOAT)) {
                    b = 22;
                }
                break;
            case 725948237:
                if (str.equals(CODEC_ID_PCM_INT_BIG)) {
                    b = 23;
                }
                break;
            case 725957860:
                if (str.equals(CODEC_ID_PCM_INT_LIT)) {
                    b = 24;
                }
                break;
            case 738597099:
                if (str.equals(CODEC_ID_ASS)) {
                    b = 25;
                }
                break;
            case 855502857:
                if (str.equals(CODEC_ID_H265)) {
                    b = 26;
                }
                break;
            case 1422270023:
                if (str.equals(CODEC_ID_SUBRIP)) {
                    b = 27;
                }
                break;
            case 1809237540:
                if (str.equals(CODEC_ID_MPEG2)) {
                    b = 28;
                }
                break;
            case 1950749482:
                if (str.equals(CODEC_ID_E_AC3)) {
                    b = 29;
                }
                break;
            case 1950789798:
                if (str.equals(CODEC_ID_FLAC)) {
                    b = 30;
                }
                break;
            case 1951062397:
                if (str.equals(CODEC_ID_OPUS)) {
                    b = TELogUtils.DEBUG_LEVEL_V;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j2 = this.seekPositionAfterBuildingCues;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i) throws IOException {
        if (this.scratch.limit() >= i) {
            return;
        }
        if (this.scratch.capacity() < i) {
            ParsableByteArray parsableByteArray = this.scratch;
            parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i));
        }
        extractorInput.readFully(this.scratch.getData(), this.scratch.limit(), i - this.scratch.limit());
        this.scratch.setLimit(i);
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private long scaleTimecodeToUs(long j) throws ParserException {
        long j2 = this.timecodeScale;
        if (j2 != -9223372036854775807L) {
            return Util.scaleLargeTimestamp(j, j2, 1000L);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void setSubtitleEndTime(String str, long j, byte[] bArr) {
        byte[] subtitleTimecode;
        int i;
        str.hashCode();
        if (str.equals(CODEC_ID_ASS)) {
            subtitleTimecode = formatSubtitleTimecode(j, SSA_TIMECODE_FORMAT, 10000L);
            i = 21;
        } else {
            if (!str.equals(CODEC_ID_SUBRIP)) {
                throw new IllegalArgumentException();
            }
            subtitleTimecode = formatSubtitleTimecode(j, SUBRIP_TIMECODE_FORMAT, 1000L);
            i = 19;
        }
        System.arraycopy(subtitleTimecode, 0, bArr, i, subtitleTimecode.length);
    }

    private int writeSampleData(ExtractorInput extractorInput, Track track, int i) throws IOException {
        int i2;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
        } else {
            if (!CODEC_ID_ASS.equals(track.codecId)) {
                TrackOutput trackOutput = track.output;
                if (!this.sampleEncodingHandled) {
                    if (track.hasContentEncryption) {
                        this.blockFlags &= -1073741825;
                        if (!this.sampleSignalByteRead) {
                            extractorInput.readFully(this.scratch.getData(), 0, 1);
                            this.sampleBytesRead++;
                            if ((this.scratch.getData()[0] & ByteCompanionObject.MIN_VALUE) == 128) {
                                throw new ParserException("Extension bit is set in signal byte");
                            }
                            this.sampleSignalByte = this.scratch.getData()[0];
                            this.sampleSignalByteRead = true;
                        }
                        byte b = this.sampleSignalByte;
                        if ((b & 1) == 1) {
                            boolean z = (b & 2) == 2;
                            this.blockFlags |= 1073741824;
                            if (!this.sampleInitializationVectorRead) {
                                extractorInput.readFully(this.encryptionInitializationVector.getData(), 0, 8);
                                this.sampleBytesRead += 8;
                                this.sampleInitializationVectorRead = true;
                                this.scratch.getData()[0] = (byte) ((z ? 128 : 0) | 8);
                                this.scratch.setPosition(0);
                                trackOutput.sampleData(this.scratch, 1, 1);
                                this.sampleBytesWritten++;
                                this.encryptionInitializationVector.setPosition(0);
                                trackOutput.sampleData(this.encryptionInitializationVector, 8, 1);
                                this.sampleBytesWritten += 8;
                            }
                            if (z) {
                                if (!this.samplePartitionCountRead) {
                                    extractorInput.readFully(this.scratch.getData(), 0, 1);
                                    this.sampleBytesRead++;
                                    this.scratch.setPosition(0);
                                    this.samplePartitionCount = this.scratch.readUnsignedByte();
                                    this.samplePartitionCountRead = true;
                                }
                                int i3 = this.samplePartitionCount * 4;
                                this.scratch.reset(i3);
                                extractorInput.readFully(this.scratch.getData(), 0, i3);
                                this.sampleBytesRead += i3;
                                short s = (short) ((this.samplePartitionCount / 2) + 1);
                                int i4 = (s * 6) + 2;
                                ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                                if (byteBuffer == null || byteBuffer.capacity() < i4) {
                                    this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i4);
                                }
                                this.encryptionSubsampleDataBuffer.position(0);
                                this.encryptionSubsampleDataBuffer.putShort(s);
                                int i5 = 0;
                                int i6 = 0;
                                while (true) {
                                    i2 = this.samplePartitionCount;
                                    if (i5 >= i2) {
                                        break;
                                    }
                                    int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                    if (i5 % 2 == 0) {
                                        this.encryptionSubsampleDataBuffer.putShort((short) (unsignedIntToInt - i6));
                                    } else {
                                        this.encryptionSubsampleDataBuffer.putInt(unsignedIntToInt - i6);
                                    }
                                    i5++;
                                    i6 = unsignedIntToInt;
                                }
                                int i7 = (i - this.sampleBytesRead) - i6;
                                int i8 = i2 % 2;
                                ByteBuffer byteBuffer2 = this.encryptionSubsampleDataBuffer;
                                if (i8 == 1) {
                                    byteBuffer2.putInt(i7);
                                } else {
                                    byteBuffer2.putShort((short) i7);
                                    this.encryptionSubsampleDataBuffer.putInt(0);
                                }
                                this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i4);
                                trackOutput.sampleData(this.encryptionSubsampleData, i4, 1);
                                this.sampleBytesWritten += i4;
                            }
                        }
                    } else {
                        byte[] bArr = track.sampleStrippedBytes;
                        if (bArr != null) {
                            this.sampleStrippedBytes.reset(bArr, bArr.length);
                        }
                    }
                    if (track.maxBlockAdditionId > 0) {
                        this.blockFlags |= 268435456;
                        this.blockAdditionalData.reset(0);
                        this.scratch.reset(4);
                        this.scratch.getData()[0] = (byte) ((i >> 24) & 255);
                        this.scratch.getData()[1] = (byte) ((i >> 16) & 255);
                        this.scratch.getData()[2] = (byte) ((i >> 8) & 255);
                        this.scratch.getData()[3] = (byte) (i & 255);
                        trackOutput.sampleData(this.scratch, 4, 2);
                        this.sampleBytesWritten += 4;
                    }
                    this.sampleEncodingHandled = true;
                }
                int iLimit = i + this.sampleStrippedBytes.limit();
                if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
                    if (track.trueHdSampleRechunker != null) {
                        Assertions.checkState(this.sampleStrippedBytes.limit() == 0);
                        track.trueHdSampleRechunker.startSample(extractorInput);
                    }
                    while (true) {
                        int i9 = this.sampleBytesRead;
                        if (i9 >= iLimit) {
                            break;
                        }
                        int iWriteToOutput = writeToOutput(extractorInput, trackOutput, iLimit - i9);
                        this.sampleBytesRead += iWriteToOutput;
                        this.sampleBytesWritten += iWriteToOutput;
                    }
                } else {
                    byte[] data = this.nalLength.getData();
                    data[0] = 0;
                    data[1] = 0;
                    data[2] = 0;
                    int i10 = track.nalUnitLengthFieldLength;
                    int i11 = 4 - i10;
                    while (this.sampleBytesRead < iLimit) {
                        int i12 = this.sampleCurrentNalBytesRemaining;
                        if (i12 == 0) {
                            writeToTarget(extractorInput, data, i11, i10);
                            this.sampleBytesRead += i10;
                            this.nalLength.setPosition(0);
                            this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                            this.nalStartCode.setPosition(0);
                            trackOutput.sampleData(this.nalStartCode, 4);
                            this.sampleBytesWritten += 4;
                        } else {
                            int iWriteToOutput2 = writeToOutput(extractorInput, trackOutput, i12);
                            this.sampleBytesRead += iWriteToOutput2;
                            this.sampleBytesWritten += iWriteToOutput2;
                            this.sampleCurrentNalBytesRemaining -= iWriteToOutput2;
                        }
                    }
                }
                if (CODEC_ID_VORBIS.equals(track.codecId)) {
                    this.vorbisNumPageSamples.setPosition(0);
                    trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                    this.sampleBytesWritten += 4;
                }
                return finishWriteSampleData();
            }
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
        }
        return finishWriteSampleData();
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.reset(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.getData(), bArr.length, i);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(length);
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i) throws IOException {
        int iBytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (iBytesLeft <= 0) {
            return trackOutput.sampleData((DataReader) extractorInput, i, false);
        }
        int iMin = Math.min(i, iBytesLeft);
        trackOutput.sampleData(this.sampleStrippedBytes, iMin);
        return iMin;
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        int iMin = Math.min(i2, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i, iMin);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0236, code lost:
    
        throw new com.oplus.tbl.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
        long j;
        int i3;
        int i4;
        int i5;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (this.blockState != 2) {
                    return;
                }
                handleBlockAdditionalData(this.tracks.get(this.blockTrackNumber), this.blockAdditionalId, extractorInput, i2);
                return;
            }
            if (i == ID_BLOCK_ADD_ID_EXTRA_DATA) {
                handleBlockAddIDExtraData(getCurrentTrack(i), extractorInput, i2);
                return;
            }
            if (i == ID_CONTENT_COMPRESSION_SETTINGS) {
                assertInTrackEntry(i);
                byte[] bArr = new byte[i2];
                this.currentTrack.sampleStrippedBytes = bArr;
                extractorInput.readFully(bArr, 0, i2);
                return;
            }
            if (i == ID_CONTENT_ENCRYPTION_KEY_ID) {
                byte[] bArr2 = new byte[i2];
                extractorInput.readFully(bArr2, 0, i2);
                getCurrentTrack(i).cryptoData = new TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            }
            if (i == ID_SEEK_ID) {
                Arrays.fill(this.seekEntryIdBytes.getData(), (byte) 0);
                extractorInput.readFully(this.seekEntryIdBytes.getData(), 4 - i2, i2);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                return;
            }
            if (i == ID_CODEC_PRIVATE) {
                assertInTrackEntry(i);
                byte[] bArr3 = new byte[i2];
                this.currentTrack.codecPrivate = bArr3;
                extractorInput.readFully(bArr3, 0, i2);
                return;
            }
            if (i != ID_PROJECTION_PRIVATE) {
                throw new ParserException("Unexpected id: " + i);
            }
            assertInTrackEntry(i);
            byte[] bArr4 = new byte[i2];
            this.currentTrack.projectionData = bArr4;
            extractorInput.readFully(bArr4, 0, i2);
            return;
        }
        int i6 = 8;
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = -9223372036854775807L;
            this.blockState = 1;
            this.scratch.reset(0);
        }
        Track track = this.tracks.get(this.blockTrackNumber);
        if (track == null) {
            extractorInput.skipFully(i2 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        track.assertOutputInitialized();
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i7 = (this.scratch.getData()[2] & 6) >> 1;
            byte b = UByte.MAX_VALUE;
            if (i7 == 0) {
                this.blockSampleCount = 1;
                int[] iArrEnsureArrayCapacity = ensureArrayCapacity(this.blockSampleSizes, 1);
                this.blockSampleSizes = iArrEnsureArrayCapacity;
                iArrEnsureArrayCapacity[0] = (i2 - this.blockTrackNumberLength) - 3;
            } else {
                int i8 = 4;
                readScratch(extractorInput, 4);
                int i9 = (this.scratch.getData()[3] & UByte.MAX_VALUE) + 1;
                this.blockSampleCount = i9;
                int[] iArrEnsureArrayCapacity2 = ensureArrayCapacity(this.blockSampleSizes, i9);
                this.blockSampleSizes = iArrEnsureArrayCapacity2;
                if (i7 == 2) {
                    int i10 = (i2 - this.blockTrackNumberLength) - 4;
                    int i11 = this.blockSampleCount;
                    Arrays.fill(iArrEnsureArrayCapacity2, 0, i11, i10 / i11);
                } else if (i7 == 1) {
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        i3 = this.blockSampleCount;
                        if (i12 >= i3 - 1) {
                            break;
                        }
                        this.blockSampleSizes[i12] = 0;
                        do {
                            i8++;
                            readScratch(extractorInput, i8);
                            i4 = this.scratch.getData()[i8 - 1] & UByte.MAX_VALUE;
                            int[] iArr = this.blockSampleSizes;
                            i5 = iArr[i12] + i4;
                            iArr[i12] = i5;
                        } while (i4 == 255);
                        i13 += i5;
                        i12++;
                    }
                    this.blockSampleSizes[i3 - 1] = ((i2 - this.blockTrackNumberLength) - i8) - i13;
                } else {
                    if (i7 != 3) {
                        throw new ParserException("Unexpected lacing value: " + i7);
                    }
                    int i14 = 0;
                    int i15 = 0;
                    while (true) {
                        int i16 = this.blockSampleCount;
                        if (i14 >= i16 - 1) {
                            this.blockSampleSizes[i16 - 1] = ((i2 - this.blockTrackNumberLength) - i8) - i15;
                            break;
                        }
                        this.blockSampleSizes[i14] = 0;
                        i8++;
                        readScratch(extractorInput, i8);
                        int i17 = i8 - 1;
                        if (this.scratch.getData()[i17] == 0) {
                            throw new ParserException("No valid varint length mask found");
                        }
                        int i18 = 0;
                        while (true) {
                            if (i18 >= i6) {
                                j = 0;
                                break;
                            }
                            int i19 = 1 << (7 - i18);
                            if ((this.scratch.getData()[i17] & i19) != 0) {
                                int i20 = i8 + i18;
                                readScratch(extractorInput, i20);
                                j = (~i19) & this.scratch.getData()[i17] & b;
                                int i21 = i17 + 1;
                                while (i21 < i20) {
                                    j = (j << i6) | ((long) (this.scratch.getData()[i21] & b));
                                    i21++;
                                    i20 = i20;
                                    i6 = 8;
                                    b = UByte.MAX_VALUE;
                                }
                                int i22 = i20;
                                if (i14 > 0) {
                                    j -= (1 << ((i18 * 7) + 6)) - 1;
                                }
                                i8 = i22;
                            } else {
                                i18++;
                                i6 = 8;
                                b = UByte.MAX_VALUE;
                            }
                        }
                        if (j < -2147483648L || j > 2147483647L) {
                            break;
                        }
                        int i23 = (int) j;
                        int[] iArr2 = this.blockSampleSizes;
                        if (i14 != 0) {
                            i23 += iArr2[i14 - 1];
                        }
                        iArr2[i14] = i23;
                        i15 += i23;
                        i14++;
                        i6 = 8;
                        b = UByte.MAX_VALUE;
                    }
                }
            }
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[0] << 8) | (this.scratch.getData()[1] & UByte.MAX_VALUE));
            this.blockFlags = (track.type == 2 || (i == 163 && (this.scratch.getData()[2] & ByteCompanionObject.MIN_VALUE) == 128)) ? 1 : 0;
            this.blockState = 2;
            this.blockSampleIndex = 0;
        }
        if (i == 163) {
            while (true) {
                int i24 = this.blockSampleIndex;
                if (i24 >= this.blockSampleCount) {
                    this.blockState = 0;
                    return;
                } else {
                    commitSampleToOutput(track, ((long) ((this.blockSampleIndex * track.defaultSampleDurationNs) / 1000)) + this.blockTimeUs, this.blockFlags, writeSampleData(extractorInput, track, this.blockSampleSizes[i24]), 0);
                    this.blockSampleIndex++;
                }
            }
        } else {
            while (true) {
                int i25 = this.blockSampleIndex;
                if (i25 >= this.blockSampleCount) {
                    return;
                }
                int[] iArr3 = this.blockSampleSizes;
                iArr3[i25] = writeSampleData(extractorInput, track, iArr3[i25]);
                this.blockSampleIndex++;
            }
        }
    }

    @CallSuper
    public void endMasterElement(int i) throws ParserException {
        assertInitialized();
        if (i == 160) {
            if (this.blockState != 2) {
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.blockSampleCount; i3++) {
                i2 += this.blockSampleSizes[i3];
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            track.assertOutputInitialized();
            for (int i4 = 0; i4 < this.blockSampleCount; i4++) {
                long j = ((long) ((track.defaultSampleDurationNs * i4) / 1000)) + this.blockTimeUs;
                int i5 = this.blockFlags;
                if (i4 == 0 && !this.blockHasReferenceBlock) {
                    i5 |= 1;
                }
                int i6 = this.blockSampleSizes[i4];
                i2 -= i6;
                commitSampleToOutput(track, j, i5, i6, i2);
            }
            this.blockState = 0;
            return;
        }
        if (i == 174) {
            Track track2 = (Track) Assertions.checkStateNotNull(this.currentTrack);
            String str = track2.codecId;
            if (str == null) {
                throw new ParserException("CodecId is missing in TrackEntry element");
            }
            if (isCodecSupported(str)) {
                track2.initializeOutput(this.extractorOutput, track2.number);
                this.tracks.put(track2.number, track2);
            }
            this.currentTrack = null;
            return;
        }
        if (i == ID_SEEK) {
            int i7 = this.seekEntryId;
            if (i7 != -1) {
                long j2 = this.seekEntryPosition;
                if (j2 != -1) {
                    if (i7 == ID_CUES) {
                        this.cuesContentPosition = j2;
                        return;
                    }
                    return;
                }
            }
            throw new ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == ID_CONTENT_ENCODING) {
            assertInTrackEntry(i);
            Track track3 = this.currentTrack;
            if (track3.hasContentEncryption) {
                if (track3.cryptoData == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey));
                return;
            }
            return;
        }
        if (i == ID_CONTENT_ENCODINGS) {
            assertInTrackEntry(i);
            Track track4 = this.currentTrack;
            if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                throw new ParserException("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.timecodeScale == -9223372036854775807L) {
                this.timecodeScale = 1000000L;
            }
            long j3 = this.durationTimecode;
            if (j3 != -9223372036854775807L) {
                this.durationUs = scaleTimecodeToUs(j3);
                return;
            }
            return;
        }
        if (i == ID_TRACKS) {
            if (this.tracks.size() == 0) {
                throw new ParserException("No valid tracks were found");
            }
            this.extractorOutput.endTracks();
        } else {
            if (i != ID_CUES) {
                return;
            }
            if (!this.sentSeekMap) {
                this.extractorOutput.seekMap(buildSeekMap(this.cueTimesUs, this.cueClusterPositions));
                this.sentSeekMap = true;
            }
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
        }
    }

    @CallSuper
    public void floatElement(int i, double d) throws ParserException {
        if (i == 181) {
            getCurrentTrack(i).sampleRate = (int) d;
        }
        if (i == ID_DURATION) {
            this.durationTimecode = (long) d;
            return;
        }
        switch (i) {
            case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                getCurrentTrack(i).primaryRChromaticityX = (float) d;
                break;
            case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                getCurrentTrack(i).primaryRChromaticityY = (float) d;
                break;
            case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                getCurrentTrack(i).primaryGChromaticityX = (float) d;
                break;
            case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                getCurrentTrack(i).primaryGChromaticityY = (float) d;
                break;
            case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                getCurrentTrack(i).primaryBChromaticityX = (float) d;
                break;
            case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                getCurrentTrack(i).primaryBChromaticityY = (float) d;
                break;
            case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                getCurrentTrack(i).whitePointChromaticityX = (float) d;
                break;
            case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                getCurrentTrack(i).whitePointChromaticityY = (float) d;
                break;
            case ID_LUMNINANCE_MAX /* 21977 */:
                getCurrentTrack(i).maxMasteringLuminance = (float) d;
                break;
            case ID_LUMNINANCE_MIN /* 21978 */:
                getCurrentTrack(i).minMasteringLuminance = (float) d;
                break;
            default:
                switch (i) {
                    case ID_PROJECTION_POSE_YAW /* 30323 */:
                        getCurrentTrack(i).projectionPoseYaw = (float) d;
                        break;
                    case ID_PROJECTION_POSE_PITCH /* 30324 */:
                        getCurrentTrack(i).projectionPosePitch = (float) d;
                        break;
                    case ID_PROJECTION_POSE_ROLL /* 30325 */:
                        getCurrentTrack(i).projectionPoseRoll = (float) d;
                        break;
                }
                break;
        }
    }

    @CallSuper
    public int getElementType(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case ID_BLOCK_ADD_ID /* 238 */:
            case 241:
            case 251:
            case ID_BLOCK_ADD_ID_TYPE /* 16871 */:
            case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
            case ID_DOC_TYPE_READ_VERSION /* 17029 */:
            case ID_EBML_READ_VERSION /* 17143 */:
            case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
            case ID_CONTENT_ENCODING_ORDER /* 20529 */:
            case ID_CONTENT_ENCODING_SCOPE /* 20530 */:
            case ID_SEEK_POSITION /* 21420 */:
            case ID_STEREO_MODE /* 21432 */:
            case ID_DISPLAY_WIDTH /* 21680 */:
            case ID_DISPLAY_UNIT /* 21682 */:
            case ID_DISPLAY_HEIGHT /* 21690 */:
            case ID_FLAG_FORCED /* 21930 */:
            case ID_COLOUR_RANGE /* 21945 */:
            case ID_COLOUR_TRANSFER /* 21946 */:
            case ID_COLOUR_PRIMARIES /* 21947 */:
            case ID_MAX_CLL /* 21948 */:
            case ID_MAX_FALL /* 21949 */:
            case ID_MAX_BLOCK_ADDITION_ID /* 21998 */:
            case ID_CODEC_DELAY /* 22186 */:
            case ID_SEEK_PRE_ROLL /* 22203 */:
            case ID_AUDIO_BIT_DEPTH /* 25188 */:
            case ID_PROJECTION_TYPE /* 30321 */:
            case ID_DEFAULT_DURATION /* 2352003 */:
            case ID_TIMECODE_SCALE /* 2807729 */:
                return 2;
            case 134:
            case ID_DOC_TYPE /* 17026 */:
            case ID_NAME /* 21358 */:
            case ID_LANGUAGE /* 2274716 */:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case ID_AUDIO /* 225 */:
            case ID_BLOCK_ADDITION_MAPPING /* 16868 */:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS /* 18407 */:
            case ID_SEEK /* 19899 */:
            case ID_CONTENT_COMPRESSION /* 20532 */:
            case ID_CONTENT_ENCRYPTION /* 20533 */:
            case ID_COLOUR /* 21936 */:
            case ID_MASTERING_METADATA /* 21968 */:
            case ID_CONTENT_ENCODING /* 25152 */:
            case ID_CONTENT_ENCODINGS /* 28032 */:
            case ID_BLOCK_ADDITIONS /* 30113 */:
            case ID_PROJECTION /* 30320 */:
            case ID_SEEK_HEAD /* 290298740 */:
            case 357149030:
            case ID_TRACKS /* 374648427 */:
            case ID_SEGMENT /* 408125543 */:
            case ID_EBML /* 440786851 */:
            case ID_CUES /* 475249515 */:
            case ID_CLUSTER /* 524531317 */:
                return 1;
            case 161:
            case 163:
            case 165:
            case ID_BLOCK_ADD_ID_EXTRA_DATA /* 16877 */:
            case ID_CONTENT_COMPRESSION_SETTINGS /* 16981 */:
            case ID_CONTENT_ENCRYPTION_KEY_ID /* 18402 */:
            case ID_SEEK_ID /* 21419 */:
            case ID_CODEC_PRIVATE /* 25506 */:
            case ID_PROJECTION_PRIVATE /* 30322 */:
                return 4;
            case 181:
            case ID_DURATION /* 17545 */:
            case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
            case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
            case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
            case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
            case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
            case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
            case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
            case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
            case ID_LUMNINANCE_MAX /* 21977 */:
            case ID_LUMNINANCE_MIN /* 21978 */:
            case ID_PROJECTION_POSE_YAW /* 30323 */:
            case ID_PROJECTION_POSE_PITCH /* 30324 */:
            case ID_PROJECTION_POSE_ROLL /* 30325 */:
                return 5;
            default:
                return 0;
        }
    }

    public void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i) throws IOException {
        if (track.blockAddIdType != 1685485123 && track.blockAddIdType != 1685480259) {
            extractorInput.skipFully(i);
            return;
        }
        byte[] bArr = new byte[i];
        track.dolbyVisionConfigBytes = bArr;
        extractorInput.readFully(bArr, 0, i);
    }

    public void handleBlockAdditionalData(Track track, int i, ExtractorInput extractorInput, int i2) throws IOException {
        if (i != 4 || !CODEC_ID_VP9.equals(track.codecId)) {
            extractorInput.skipFully(i2);
        } else {
            this.blockAdditionalData.reset(i2);
            extractorInput.readFully(this.blockAdditionalData.getData(), 0, i2);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @CallSuper
    public void integerElement(int i, long j) throws ParserException {
        if (i == ID_CONTENT_ENCODING_ORDER) {
            if (j == 0) {
                return;
            }
            throw new ParserException("ContentEncodingOrder " + j + " not supported");
        }
        if (i == ID_CONTENT_ENCODING_SCOPE) {
            if (j == 1) {
                return;
            }
            throw new ParserException("ContentEncodingScope " + j + " not supported");
        }
        switch (i) {
            case 131:
                getCurrentTrack(i).type = (int) j;
                return;
            case 136:
                getCurrentTrack(i).flagDefault = j == 1;
                return;
            case 155:
                this.blockDurationUs = scaleTimecodeToUs(j);
                return;
            case 159:
                getCurrentTrack(i).channelCount = (int) j;
                return;
            case 176:
                getCurrentTrack(i).width = (int) j;
                return;
            case 179:
                assertInCues(i);
                this.cueTimesUs.add(scaleTimecodeToUs(j));
                return;
            case 186:
                getCurrentTrack(i).height = (int) j;
                return;
            case 215:
                getCurrentTrack(i).number = (int) j;
                return;
            case 231:
                this.clusterTimecodeUs = scaleTimecodeToUs(j);
                return;
            case ID_BLOCK_ADD_ID /* 238 */:
                this.blockAdditionalId = (int) j;
                return;
            case 241:
                if (this.seenClusterPositionForCurrentCuePoint) {
                    return;
                }
                assertInCues(i);
                this.cueClusterPositions.add(j);
                this.seenClusterPositionForCurrentCuePoint = true;
                return;
            case 251:
                this.blockHasReferenceBlock = true;
                return;
            case ID_BLOCK_ADD_ID_TYPE /* 16871 */:
                getCurrentTrack(i).blockAddIdType = (int) j;
                return;
            case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                if (j == 3) {
                    return;
                }
                throw new ParserException("ContentCompAlgo " + j + " not supported");
            case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                if (j < 1 || j > 2) {
                    throw new ParserException("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case ID_EBML_READ_VERSION /* 17143 */:
                if (j == 1) {
                    return;
                }
                throw new ParserException("EBMLReadVersion " + j + " not supported");
            case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                if (j == 5) {
                    return;
                }
                throw new ParserException("ContentEncAlgo " + j + " not supported");
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                if (j == 1) {
                    return;
                }
                throw new ParserException("AESSettingsCipherMode " + j + " not supported");
            case ID_SEEK_POSITION /* 21420 */:
                this.seekEntryPosition = j + this.segmentContentPosition;
                return;
            case ID_STEREO_MODE /* 21432 */:
                int i2 = (int) j;
                assertInTrackEntry(i);
                if (i2 == 0) {
                    this.currentTrack.stereoMode = 0;
                    return;
                }
                if (i2 == 1) {
                    this.currentTrack.stereoMode = 2;
                    return;
                } else if (i2 == 3) {
                    this.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.currentTrack.stereoMode = 3;
                    return;
                }
            case ID_DISPLAY_WIDTH /* 21680 */:
                getCurrentTrack(i).displayWidth = (int) j;
                return;
            case ID_DISPLAY_UNIT /* 21682 */:
                getCurrentTrack(i).displayUnit = (int) j;
                return;
            case ID_DISPLAY_HEIGHT /* 21690 */:
                getCurrentTrack(i).displayHeight = (int) j;
                return;
            case ID_FLAG_FORCED /* 21930 */:
                getCurrentTrack(i).flagForced = j == 1;
                return;
            case ID_MAX_BLOCK_ADDITION_ID /* 21998 */:
                getCurrentTrack(i).maxBlockAdditionId = (int) j;
                return;
            case ID_CODEC_DELAY /* 22186 */:
                getCurrentTrack(i).codecDelayNs = j;
                return;
            case ID_SEEK_PRE_ROLL /* 22203 */:
                getCurrentTrack(i).seekPreRollNs = j;
                return;
            case ID_AUDIO_BIT_DEPTH /* 25188 */:
                getCurrentTrack(i).audioBitDepth = (int) j;
                return;
            case ID_PROJECTION_TYPE /* 30321 */:
                assertInTrackEntry(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.currentTrack.projectionType = 0;
                    return;
                }
                if (i3 == 1) {
                    this.currentTrack.projectionType = 1;
                    return;
                } else if (i3 == 2) {
                    this.currentTrack.projectionType = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.currentTrack.projectionType = 3;
                    return;
                }
            case ID_DEFAULT_DURATION /* 2352003 */:
                getCurrentTrack(i).defaultSampleDurationNs = (int) j;
                return;
            case ID_TIMECODE_SCALE /* 2807729 */:
                this.timecodeScale = j;
                return;
            default:
                switch (i) {
                    case ID_COLOUR_RANGE /* 21945 */:
                        assertInTrackEntry(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.currentTrack.colorRange = 1;
                            return;
                        }
                    case ID_COLOUR_TRANSFER /* 21946 */:
                        assertInTrackEntry(i);
                        int i5 = (int) j;
                        if (i5 != 1) {
                            if (i5 == 16) {
                                this.currentTrack.colorTransfer = 6;
                                return;
                            } else if (i5 == 18) {
                                this.currentTrack.colorTransfer = 7;
                                return;
                            } else if (i5 != 6 && i5 != 7) {
                                return;
                            }
                        }
                        this.currentTrack.colorTransfer = 3;
                        return;
                    case ID_COLOUR_PRIMARIES /* 21947 */:
                        assertInTrackEntry(i);
                        Track track = this.currentTrack;
                        track.hasColorInfo = true;
                        int i6 = (int) j;
                        if (i6 == 1) {
                            track.colorSpace = 1;
                            return;
                        }
                        if (i6 == 9) {
                            track.colorSpace = 6;
                            return;
                        } else {
                            if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                track.colorSpace = 2;
                                return;
                            }
                            return;
                        }
                    case ID_MAX_CLL /* 21948 */:
                        getCurrentTrack(i).maxContentLuminance = (int) j;
                        return;
                    case ID_MAX_FALL /* 21949 */:
                        getCurrentTrack(i).maxFrameAverageLuminance = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean isLevel1Element(int i) {
        return i == 357149030 || i == ID_CLUSTER || i == ID_CUES || i == ID_TRACKS;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.haveOutputSample = false;
        boolean z = true;
        while (z && !this.haveOutputSample) {
            z = this.reader.read(extractorInput);
            if (z && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            Track trackValueAt = this.tracks.valueAt(i);
            trackValueAt.assertOutputInitialized();
            trackValueAt.outputPendingSampleMetadata();
        }
        return -1;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    @CallSuper
    public void seek(long j, long j2) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).reset();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().sniff(extractorInput);
    }

    @CallSuper
    public void startMasterElement(int i, long j, long j2) throws ParserException {
        assertInitialized();
        if (i == 160) {
            this.blockHasReferenceBlock = false;
            return;
        }
        if (i == 174) {
            this.currentTrack = new Track();
            return;
        }
        if (i == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
            return;
        }
        if (i == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
            return;
        }
        if (i == ID_CONTENT_ENCRYPTION) {
            getCurrentTrack(i).hasContentEncryption = true;
            return;
        }
        if (i == ID_MASTERING_METADATA) {
            getCurrentTrack(i).hasColorInfo = true;
            return;
        }
        if (i == ID_SEGMENT) {
            long j3 = this.segmentContentPosition;
            if (j3 != -1 && j3 != j) {
                throw new ParserException("Multiple Segment elements not supported");
            }
            this.segmentContentPosition = j;
            this.segmentContentSize = j2;
            return;
        }
        if (i == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i == ID_CLUSTER && !this.sentSeekMap) {
            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                this.seekForCues = true;
            } else {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
            }
        }
    }

    @CallSuper
    public void stringElement(int i, String str) throws ParserException {
        if (i == 134) {
            getCurrentTrack(i).codecId = str;
            return;
        }
        if (i != ID_DOC_TYPE) {
            if (i == ID_NAME) {
                getCurrentTrack(i).name = str;
                return;
            } else {
                if (i != ID_LANGUAGE) {
                    return;
                }
                getCurrentTrack(i).language = str;
                return;
            }
        }
        if (DOC_TYPE_WEBM.equals(str) || DOC_TYPE_MATROSKA.equals(str)) {
            return;
        }
        throw new ParserException("DocType " + str + " not supported");
    }

    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i);
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlProcessor());
        this.seekForCuesEnabled = (i & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.blockAdditionalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public final void release() {
    }
}
