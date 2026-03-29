package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalSourceWantedData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SourceWantedData {
    public int frameRate;
    public int height;
    public int width;

    public SourceWantedData() {
    }

    public String toString() {
        return "SourceWantedData{width='" + this.width + "', height='" + this.height + "', frameRate='" + this.frameRate + "'}";
    }

    public SourceWantedData(InternalSourceWantedData internalSourceWantedData) {
        this.width = internalSourceWantedData.width;
        this.height = internalSourceWantedData.height;
        this.frameRate = internalSourceWantedData.frameRate;
    }
}
