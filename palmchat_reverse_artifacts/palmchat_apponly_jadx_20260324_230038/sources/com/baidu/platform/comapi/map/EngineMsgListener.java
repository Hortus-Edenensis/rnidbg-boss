package com.baidu.platform.comapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface EngineMsgListener {
    void onEnterIndoorMapMode(IndoorMapInfo indoorMapInfo);

    void onExitIndoorMapMode();

    void onLongLinkConnect();

    void onLongLinkDisConnect();
}
