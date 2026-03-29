package com.oplus.tbl.exoplayer2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BufferingStuckResult {
    public static final int BUFFERING_STUCK_BUFFERING_TIME_OVER_MAX_THRESHOLD = 4;
    public static final int BUFFERING_STUCK_BUFFERING_TIME_OVER_MIN_THRESHOLD = 3;
    public static final int BUFFERING_STUCK_NONE = 0;
    public static final int BUFFERING_STUCK_TOTAL_BUFFERING_COUNT_OVER = 1;
    public static final int BUFFERING_STUCK_TOTAL_BUFFERING_TIME_OVER = 2;
    public long stuckDurationMs;
    public long stuckTimeMs;
    public int stuckType;

    public BufferingStuckResult(int i, long j, long j2) {
        this.stuckType = i;
        this.stuckTimeMs = j;
        this.stuckDurationMs = j2;
    }

    public static BufferingStuckResult createResult(int i, long j, long j2) {
        return new BufferingStuckResult(i, j, j2);
    }

    public String toString() {
        return "BufferingStuckResult{stuckType=" + this.stuckType + ", stuckTimeMs=" + this.stuckTimeMs + ", stuckDurationMs=" + this.stuckDurationMs + '}';
    }
}
