package androidx.media3.muxer;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.collect.ImmutableMap;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.uc.crashsdk.export.LogType;
import defpackage.g0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class AacWriter {
    private static final int ADTS_HEADER_LENGTH = 7;
    private static final ImmutableMap<Integer, Integer> SAMPLE_RATE_TABLE_INDEX = ImmutableMap.ofEntries(g0.a(96000, 0), g0.a(88200, 1), g0.a(64000, 2), g0.a(48000, 3), g0.a(44100, 4), g0.a(Integer.valueOf(LogType.UNEXP_KNOWN_REASON), 5), g0.a(Integer.valueOf(ErrorCode.REASON_HLS_PLAYLIST_RESET), 6), g0.a(22050, 7), g0.a(16000, 8), g0.a(Integer.valueOf(ErrorCode.REASON_TEE), 9), g0.a(11025, 10), g0.a(8000, 11), g0.a(7350, 12));
    private Format format;
    private final FileChannel outputFileChannel;
    private int profileCode;
    private int sampleFreqIndex;

    public AacWriter(FileOutputStream fileOutputStream) {
        this.outputFileChannel = fileOutputStream.getChannel();
    }

    private ByteBuffer createAdtsHeader(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
        byteBufferAllocate.put((byte) -1);
        byteBufferAllocate.put((byte) -15);
        int i2 = ((Format) Assertions.checkNotNull(this.format)).channelCount;
        byteBufferAllocate.put((byte) ((this.profileCode << 6) | (this.sampleFreqIndex << 2) | 0 | (i2 >> 2)));
        byteBufferAllocate.put((byte) (((i2 & 3) << 6) | 0 | ((i & BmLocated.HALF_LEFT_BOTTOM) >> 11)));
        byteBufferAllocate.put((byte) ((i & 2040) >> 3));
        byteBufferAllocate.put((byte) (((i & 7) << 5) | 31));
        byteBufferAllocate.put((byte) MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public void setFormat(Format format) {
        int i = format.channelCount;
        Assertions.checkArgument(i >= 1 && i <= 7, "Channel count must be between 1 and 7, got " + format.channelCount);
        this.profileCode = ((Integer) ((Pair) Assertions.checkNotNull(CodecSpecificDataUtil.getCodecProfileAndLevel(format))).first).intValue();
        this.sampleFreqIndex = ((Integer) Assertions.checkNotNull(SAMPLE_RATE_TABLE_INDEX.get(Integer.valueOf(format.sampleRate)))).intValue();
        this.format = format;
    }

    public void writeSampleData(ByteBuffer byteBuffer, BufferInfo bufferInfo) throws IOException {
        this.outputFileChannel.write(createAdtsHeader(bufferInfo.size + 7));
        this.outputFileChannel.write(byteBuffer);
    }
}
