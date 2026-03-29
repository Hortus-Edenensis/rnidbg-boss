package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioPropertiesInfo {
    private static final int SPECTRUM_SIZE = 257;
    public int linearVolume;
    public int nonlinearVolume;
    public float[] spectrum;
    public int vad;
    public double voicePitch = 0.0d;
    public int deviceLoopDelay = -1;

    public AudioPropertiesInfo(int i, int i2, float[] fArr, int i3) {
        float[] fArr2 = new float[257];
        this.spectrum = fArr2;
        this.linearVolume = i;
        this.nonlinearVolume = i2;
        System.arraycopy(fArr, 0, fArr2, 0, 257);
        this.vad = i3;
    }

    public String toString() {
        return "AudioPropertiesInfo{linearVolume='" + this.linearVolume + "'nonlinearVolume='" + this.nonlinearVolume + "'voicePitch='" + this.voicePitch + "'deviceLoopDelay='" + this.deviceLoopDelay + "'}";
    }
}
