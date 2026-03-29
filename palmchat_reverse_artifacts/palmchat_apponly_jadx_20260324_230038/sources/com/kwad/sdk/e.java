package com.kwad.sdk;

import com.oplus.tbl.exoplayer2.Renderer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static final e awh = new e(10000, "其他异常");
    public static final e awi = new e(10001, "初始化参数异常");
    public static final e awj = new e(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR, "SDK未调用init方法");
    public int code;
    public String msg;

    public e(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
