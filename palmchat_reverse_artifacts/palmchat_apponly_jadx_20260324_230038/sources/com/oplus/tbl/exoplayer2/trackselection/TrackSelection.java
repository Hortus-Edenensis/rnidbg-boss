package com.oplus.tbl.exoplayer2.trackselection;

import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.source.TrackGroup;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface TrackSelection {
    Format getFormat(int i);

    int getIndexInTrackGroup(int i);

    TrackGroup getTrackGroup();

    int indexOf(int i);

    int indexOf(Format format);

    int length();
}
