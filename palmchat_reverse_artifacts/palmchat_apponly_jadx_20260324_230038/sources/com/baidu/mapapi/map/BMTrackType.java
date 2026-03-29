package com.baidu.mapapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum BMTrackType {
    Surface(3),
    Default3D(4),
    Track(5),
    TrackGradient(6);

    private int b;

    BMTrackType(int i) {
        this.b = i;
    }

    public int getType() {
        return this.b;
    }
}
