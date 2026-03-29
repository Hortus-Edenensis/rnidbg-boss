package com.amazing.media;

import android.media.MediaPlayer;
import defpackage.lk1;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class AudioPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f3284a = new MediaPlayer();
    public String b;

    @lk1
    public AudioPlayer(String str) {
        this.b = str;
    }

    @lk1
    public void destroy() {
        MediaPlayer mediaPlayer = this.f3284a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f3284a.release();
            this.f3284a = null;
        }
    }

    @lk1
    public boolean isPlaying() {
        return this.f3284a.isPlaying();
    }

    @lk1
    public void pause() {
        this.f3284a.pause();
    }

    @lk1
    public void play() {
        this.f3284a.reset();
        if (prepare()) {
            this.f3284a.start();
        }
    }

    @lk1
    public boolean prepare() {
        try {
            this.f3284a.setDataSource(this.b);
            this.f3284a.setAudioStreamType(3);
            this.f3284a.prepare();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @lk1
    public void resume() {
        this.f3284a.start();
    }

    @lk1
    public void setLoop(boolean z) {
        this.f3284a.setLooping(z);
    }

    @lk1
    public void stop() {
        this.f3284a.stop();
    }
}
