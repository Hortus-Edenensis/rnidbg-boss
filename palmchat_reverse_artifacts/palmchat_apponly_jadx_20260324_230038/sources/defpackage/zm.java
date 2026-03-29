package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface zm {
    boolean canPlay();

    ViewGroup getContainerView();

    String getPlayPath();

    boolean isZooming();

    void onPlayPause();

    void onPlayRelease();

    void onPlayResume();

    void onPlayStart(String str);
}
