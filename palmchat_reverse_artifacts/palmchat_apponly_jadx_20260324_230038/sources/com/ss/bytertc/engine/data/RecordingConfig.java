package com.ss.bytertc.engine.data;

import com.ss.bytertc.engine.type.RecordingFileType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RecordingConfig {
    public String dirPath;
    public RecordingFileType recordingFileType;

    public RecordingConfig(String str, RecordingFileType recordingFileType) {
        RecordingFileType recordingFileType2 = RecordingFileType.AAC;
        this.dirPath = str;
        this.recordingFileType = recordingFileType;
    }

    public RecordingConfig() {
        this.recordingFileType = RecordingFileType.MP4;
    }
}
