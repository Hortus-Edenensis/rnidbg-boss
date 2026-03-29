package com.oplus.tblplayer.audioeffect;

import android.media.audiofx.Equalizer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLEqualizer extends Equalizer {
    private static final String TAG = "TBLEqualizer";
    private short mEqualizerBandsNum;
    private final int[][] mEqualizerBandsValue;
    private int mEqualizerMode;

    public TBLEqualizer(int i) throws RuntimeException {
        super(0, i);
        this.mEqualizerBandsValue = new int[][]{new int[]{50, 50, 50, 50, 50}, new int[]{60, 40, 30, 45, 60}, new int[]{75, 50, 35, 25, 50}, new int[]{75, 65, 50, 75, 85}, new int[]{50, 50, 50, 25, 15}, new int[]{50, 65, 65, 60, 65}, new int[]{70, 50, 50, 70, 80}, new int[]{70, 25, 50, 77, 75}, new int[]{70, 77, 55, 77, 88}, new int[]{75, 25, 55, 50, 75}};
        setEnabled(true);
        this.mEqualizerBandsNum = getNumberOfBands();
    }

    public int getTBLEqualizerMode() {
        return this.mEqualizerMode;
    }

    public void setTBLEqualizerMode(int i) {
        if (i < 0 || i > 9) {
            return;
        }
        this.mEqualizerMode = i;
        for (short s = 0; s < this.mEqualizerBandsNum; s = (short) (s + 1)) {
            setBandLevel(s, (short) (getBandLevelRange()[0] + (((getBandLevelRange()[1] - getBandLevelRange()[0]) * this.mEqualizerBandsValue[this.mEqualizerMode][s]) / 100)));
        }
    }
}
