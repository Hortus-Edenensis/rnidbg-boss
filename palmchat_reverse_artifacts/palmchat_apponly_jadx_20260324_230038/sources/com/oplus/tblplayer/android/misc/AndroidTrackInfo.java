package com.oplus.tblplayer.android.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import com.igexin.push.core.b;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.oplus.tblplayer.misc.ITrackInfo;
import defpackage.hp2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AndroidTrackInfo implements ITrackInfo {
    private final MediaPlayer.TrackInfo mTrackInfo;

    private AndroidTrackInfo(MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mediaPlayer) {
        return fromTrackInfo(mediaPlayer.getTrackInfo());
    }

    private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null) {
            return null;
        }
        AndroidTrackInfo[] androidTrackInfoArr = new AndroidTrackInfo[trackInfoArr.length];
        for (int i = 0; i < trackInfoArr.length; i++) {
            androidTrackInfoArr[i] = new AndroidTrackInfo(trackInfoArr[i]);
        }
        return androidTrackInfoArr;
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    @TargetApi(19)
    public IMediaFormat getFormat() {
        MediaFormat format;
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null || (format = trackInfo.getFormat()) == null) {
            return null;
        }
        return new AndroidMediaFormat(format);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    @TargetApi(16)
    public String getLanguage() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        return trackInfo == null ? "und" : trackInfo.getLanguage();
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ ITrackInfo.SelectionOverride getSelectionOverride() {
        return hp2.c(this);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ ITrackInfo.TrackInfoGroup getTrackInfoGroup(int i) {
        return hp2.d(this, i);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    @TargetApi(16)
    public int getTrackType() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return 0;
        }
        return trackInfo.getTrackType();
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ boolean isAutoSelected() {
        return hp2.e(this);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ boolean isDisabled() {
        return hp2.f(this);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    public /* synthetic */ int size() {
        return hp2.g(this);
    }

    @Override // com.oplus.tblplayer.misc.ITrackInfo
    @TargetApi(16)
    public String toLineString() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        return trackInfo != null ? trackInfo.toString() : b.m;
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append('{');
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        sb.append(trackInfo != null ? trackInfo.toString() : b.m);
        sb.append('}');
        return sb.toString();
    }
}
