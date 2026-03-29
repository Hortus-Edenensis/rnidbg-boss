package com.oplus.tbl.exoplayer2.text.dvb;

import com.oplus.tbl.exoplayer2.text.Cue;
import com.oplus.tbl.exoplayer2.text.Subtitle;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class DvbSubtitle implements Subtitle {
    private final List<Cue> cues;

    public DvbSubtitle(List<Cue> list) {
        this.cues = list;
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return this.cues;
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return 0L;
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return -1;
    }
}
