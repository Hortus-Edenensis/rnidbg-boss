package com.oplus.tblplayer.upstream;

import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IDataChannel extends DataSource {
    public static final int DEFAULT_TRACK_TYPE_AUDIO = 1;
    public static final int DEFAULT_TRACK_TYPE_UNKNOWN = 0;
    public static final int DEFAULT_TRACK_TYPE_VIDEO = 2;

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackType {
    }

    void configureAudio(String str, int i, int i2, int i3, List<byte[]> list);

    void configureVideo(String str, float f, int i, int i2, List<byte[]> list);

    void setDebug(boolean z);

    void write(int i, @NonNull byte[] bArr, int i2);

    void write(int i, @NonNull byte[] bArr, int i2, int i3, long j);

    void writeEos(int i);
}
