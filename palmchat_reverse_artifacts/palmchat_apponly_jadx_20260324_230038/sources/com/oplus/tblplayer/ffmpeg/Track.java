package com.oplus.tblplayer.ffmpeg;

import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.extractor.TrackOutput;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import com.oplus.tbl.exoplayer2.video.AvcConfig;
import com.oplus.tbl.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Track {
    private static final String TAG = "FfmpegTrack";
    private int index;
    public List<byte[]> initializationData = new ArrayList();
    public String mimeType;
    public int nalUnitLengthFieldLength;
    private TrackOutput trackOutput;
    private int type;

    public Track(int i, int i2, String str, TrackOutput trackOutput) {
        this.index = i;
        this.type = i2;
        this.mimeType = str;
        this.trackOutput = trackOutput;
    }

    public int getIndex() {
        return this.index;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public TrackOutput getTrackOutput() {
        return this.trackOutput;
    }

    public int getType() {
        return this.type;
    }

    public void parseMediaCodecSpecificData(byte[] bArr) throws ParserException {
        ParsableByteArray parsableByteArray;
        int i;
        if (bArr == null || bArr.length == 0) {
            FfmpegUtil.i(TAG, "Track " + this.mimeType + " extra data is empty!");
            return;
        }
        FfmpegUtil.printExtraData(bArr);
        parsableByteArray = new ParsableByteArray(bArr);
        String str = this.mimeType;
        str.hashCode();
        switch (str) {
            case "video/av01":
                return;
            case "video/hevc":
                if (!FfmpegUtil.shouldRequireParseConfiguration(parsableByteArray)) {
                    this.initializationData.add(parsableByteArray.getData());
                    return;
                }
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                List<byte[]> list = hevcConfig.initializationData;
                if (list != null) {
                    this.initializationData.addAll(list);
                }
                i = hevcConfig.nalUnitLengthFieldLength;
                break;
                break;
            case "audio/vorbis":
                this.initializationData.addAll(FfmpegUtil.parseVorbisConfiguration(parsableByteArray.getData()));
                return;
            case "video/avc":
                if (!FfmpegUtil.shouldRequireParseConfiguration(parsableByteArray)) {
                    this.initializationData.add(parsableByteArray.getData());
                    return;
                }
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                this.initializationData = avcConfig.initializationData;
                i = avcConfig.nalUnitLengthFieldLength;
                break;
                break;
            case "audio/opus":
                this.initializationData.add(bArr);
                this.initializationData.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                this.initializationData.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                return;
            default:
                this.initializationData.add(parsableByteArray.getData());
                return;
        }
        this.nalUnitLengthFieldLength = i;
    }

    public void setTrackCodecParametersData(byte[] bArr) {
        this.initializationData.add(bArr);
    }

    public String toString() {
        return "Track {index=" + this.index + ", type=" + FfmpegUtil.getTrackTypeString(this.type) + ", mimeType=" + this.mimeType + "}";
    }
}
