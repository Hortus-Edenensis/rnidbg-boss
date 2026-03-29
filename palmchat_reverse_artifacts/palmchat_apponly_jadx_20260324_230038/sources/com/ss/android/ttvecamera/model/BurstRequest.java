package com.ss.android.ttvecamera.model;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BurstRequest {
    public static final int BURST_TYPE_BURST = 1;
    public static final int BURST_TYPE_NORMAL = 0;
    public int burstType = 0;
    public List<Integer> aeExposureValues = null;
    public int imageWidth = 0;
    public int imageHeight = 0;
    public int frameInterval = 0;
    public boolean canStopRepeating = false;
}
