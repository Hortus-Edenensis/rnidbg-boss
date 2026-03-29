package com.oplus.tbl.exoplayer2.text.tx3g;

import com.oplus.tbl.exoplayer2.text.Cue;
import com.oplus.tbl.exoplayer2.text.Subtitle;
import com.oplus.tbl.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle EMPTY = new Tx3gSubtitle();
    private final List<Cue> cues;

    private Tx3gSubtitle() {
        this.cues = Collections.emptyList();
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return j >= 0 ? this.cues : Collections.emptyList();
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.oplus.tbl.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }

    public Tx3gSubtitle(Cue cue) {
        this.cues = Collections.singletonList(cue);
    }
}
