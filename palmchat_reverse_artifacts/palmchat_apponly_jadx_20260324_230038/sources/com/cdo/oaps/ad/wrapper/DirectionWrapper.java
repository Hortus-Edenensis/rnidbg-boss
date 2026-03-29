package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DirectionWrapper extends BaseWrapper {
    public DirectionWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DirectionWrapper wrapper(Map<String, Object> map) {
        return new DirectionWrapper(map);
    }

    public int getDirectionType() {
        try {
            return getInt(OapsKey.KEY_DIRECTION_TYPE);
        } catch (ag unused) {
            return 0;
        }
    }

    public DirectionWrapper setDirectionType(int i) {
        return (DirectionWrapper) set(OapsKey.KEY_DIRECTION_TYPE, Integer.valueOf(i));
    }
}
