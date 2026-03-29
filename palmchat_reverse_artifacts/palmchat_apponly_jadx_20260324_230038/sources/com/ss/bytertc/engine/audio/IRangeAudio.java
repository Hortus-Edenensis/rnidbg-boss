package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.data.ReceiveRange;
import com.ss.bytertc.engine.type.AttenuationType;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IRangeAudio {
    void enableRangeAudio(boolean z);

    int setAttenuationModel(AttenuationType attenuationType, float f);

    void setNoAttenuationFlags(List<String> list);

    int updatePosition(Position position);

    int updateReceiveRange(ReceiveRange receiveRange);
}
