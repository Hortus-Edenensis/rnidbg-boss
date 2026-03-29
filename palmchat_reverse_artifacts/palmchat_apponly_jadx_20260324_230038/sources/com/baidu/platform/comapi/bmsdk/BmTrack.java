package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Track;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmTrack extends BmDrawItem {
    private Track i;

    public BmTrack() {
        super(25, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native long nativeCreate();

    private static native boolean nativeSetTrackMove(long j, boolean z);

    public void a(Track track) {
        this.i = track;
    }

    public boolean c(boolean z) {
        return nativeSetTrackMove(this.nativeInstance, z);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }
}
