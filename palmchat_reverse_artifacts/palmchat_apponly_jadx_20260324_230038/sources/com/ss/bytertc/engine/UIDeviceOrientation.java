package com.ss.bytertc.engine;

import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum UIDeviceOrientation {
    Portrait(0),
    LandscapeLeft(90),
    PortraitUpsidedown(EffectConstants.ROTATION_DEGREES_180),
    LandscapeRight(270);

    private int value;

    UIDeviceOrientation() {
        this.value = 0;
    }

    public int value() {
        return this.value;
    }

    UIDeviceOrientation(int i) {
        this.value = i;
    }
}
