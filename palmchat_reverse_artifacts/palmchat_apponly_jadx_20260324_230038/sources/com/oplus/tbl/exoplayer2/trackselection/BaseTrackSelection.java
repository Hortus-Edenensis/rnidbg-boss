package com.oplus.tbl.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.source.TrackGroup;
import com.oplus.tbl.exoplayer2.source.chunk.Chunk;
import com.oplus.tbl.exoplayer2.source.chunk.MediaChunk;
import com.oplus.tbl.exoplayer2.trackselection.BaseTrackSelection;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.mr1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection {
    private final long[] excludeUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        int i = 0;
        Assertions.checkState(iArr.length > 0);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length = iArr.length;
        this.length = length;
        this.formats = new Format[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.formats[i2] = trackGroup.getFormat(iArr[i2]);
        }
        Arrays.sort(this.formats, new Comparator() { // from class: yr
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BaseTrackSelection.lambda$new$0((Format) obj, (Format) obj2);
            }
        });
        this.tracks = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i >= i3) {
                this.excludeUntilTimes = new long[i3];
                return;
            } else {
                this.tracks[i] = trackGroup.indexOf(this.formats[i]);
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(Format format, Format format2) {
        return format2.bitrate - format.bitrate;
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public final boolean blacklist(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsBlacklisted = isBlacklisted(i, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !zIsBlacklisted) {
            zIsBlacklisted = (i2 == i || isBlacklisted(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zIsBlacklisted) {
            return false;
        }
        long[] jArr = this.excludeUntilTimes;
        jArr[i] = Math.max(jArr[i], Util.addWithOverflowDefault(jElapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        return list.size();
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int i) {
        return this.formats[i];
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.tracks[i];
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.tracks[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean isBlacklisted(int i, long j) {
        return this.excludeUntilTimes[i] > j;
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ void onDiscontinuity() {
        mr1.a(this);
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z) {
        mr1.b(this, z);
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ void onRebuffer() {
        mr1.c(this);
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public /* synthetic */ boolean shouldCancelChunkLoad(long j, Chunk chunk, List list) {
        return mr1.d(this, j, chunk, list);
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.formats[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public void disable() {
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public void enable() {
    }

    @Override // com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
    }
}
