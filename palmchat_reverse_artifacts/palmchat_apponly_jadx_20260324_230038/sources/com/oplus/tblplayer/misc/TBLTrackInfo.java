package com.oplus.tblplayer.misc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.CommonUtil;
import defpackage.hp2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TBLTrackInfo implements ITrackInfo {
    private final boolean disabled;
    private final int length;
    private final ITrackInfo.SelectionOverride override;
    private final List<ITrackInfo.TrackInfoGroup> trackInfoGroups;
    private final int trackType;

    public TBLTrackInfo(int i, @NonNull List<ITrackInfo.TrackInfoGroup> list, boolean z, @Nullable ITrackInfo.SelectionOverride selectionOverride) {
        this.trackType = i;
        this.trackInfoGroups = CommonUtil.immutableList(list);
        this.length = list.size();
        this.disabled = z;
        this.override = selectionOverride;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ IMediaFormat getFormat() {
        return hp2.a(this);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ String getLanguage() {
        return hp2.b(this);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public ITrackInfo.SelectionOverride getSelectionOverride() {
        return this.override;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public ITrackInfo.TrackInfoGroup getTrackInfoGroup(int i) {
        AssertUtil.checkIndex(i, 0, this.length);
        return this.trackInfoGroups.get(i);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public int getTrackType() {
        return this.trackType;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public boolean isAutoSelected() {
        return !this.disabled && this.override == null;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public boolean isDisabled() {
        return this.disabled;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public int size() {
        return this.length;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ String toLineString() {
        return hp2.h(this);
    }
}
