package com.oplus.tbl.exoplayer2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StreamingStuckResult {
    public static final int TYPE_NORMAL_REPORT = 0;
    public static final int TYPE_RECEIVE_STUCK = 1;
    public static final int TYPE_RENDER_STUCK = 2;
    public long presentationTimeUs;
    public long receiveFrameAverageTimeMs;
    public int receiveFrameCountLastTime;
    public long renderFrameAverageTimeMs;
    public int renderFrameCountLastTime;
    public long stuckDurationMs;
    public long stuckTimeMs;
    public int stuckType;

    private StreamingStuckResult(int i, long j, long j2, long j3, long j4, int i2, long j5, int i3) {
        this.stuckType = i;
        this.stuckTimeMs = j;
        this.stuckDurationMs = j2;
        this.presentationTimeUs = j3;
        this.receiveFrameAverageTimeMs = j4;
        this.receiveFrameCountLastTime = i2;
        this.renderFrameAverageTimeMs = j5;
        this.renderFrameCountLastTime = i3;
    }

    public static StreamingStuckResult createNormalResult(long j, int i, long j2, int i2) {
        return new StreamingStuckResult(0, 0L, 0L, 0L, j, i, j2, i2);
    }

    public static StreamingStuckResult createStuckResult(int i, long j, long j2, long j3) {
        return new StreamingStuckResult(i, j, j2, j3, 0L, 0, 0L, 0);
    }

    public String stuckTypeToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "Unexpected value" : "Render stuck" : "Receive stuck" : "Normal report";
    }

    public String timeFormatToString(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j));
    }

    public String toString() {
        StringBuilder sb;
        if (this.stuckType == 0) {
            sb = new StringBuilder();
            sb.append("StreamingStuckResult{stuckType=");
            sb.append(stuckTypeToString(this.stuckType));
            sb.append(", receiveFrameAverageTimeMs= ");
            sb.append(this.receiveFrameAverageTimeMs);
            sb.append(", receiveFrameCountLastTime= ");
            sb.append(this.receiveFrameCountLastTime);
            sb.append(", renderFrameAverageTimeMs= ");
            sb.append(this.renderFrameAverageTimeMs);
            sb.append(", renderFrameCountLastTime= ");
            sb.append(this.renderFrameCountLastTime);
        } else {
            sb = new StringBuilder();
            sb.append("StreamingStuckResult{stuckType=");
            sb.append(stuckTypeToString(this.stuckType));
            sb.append(", stuckTimeMs=");
            sb.append(timeFormatToString(this.stuckTimeMs));
            sb.append(", stuckDurationMs=");
            sb.append(this.stuckDurationMs);
            sb.append(", pts=");
            sb.append(this.presentationTimeUs);
        }
        sb.append('}');
        return sb.toString();
    }
}
