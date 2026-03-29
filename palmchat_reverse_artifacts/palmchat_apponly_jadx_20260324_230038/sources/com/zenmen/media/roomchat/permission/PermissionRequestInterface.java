package com.zenmen.media.roomchat.permission;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface PermissionRequestInterface {

    /* JADX INFO: compiled from: SearchBox */
    public enum RequestType {
        FloatView,
        Camera,
        Record_Audio
    }

    void B0();

    void I();

    void g1();

    void l();

    void onCancel();

    void p1();
}
