package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.view.View;
import android.view.ViewGroup;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static volatile fx u;

    private fx() {
    }

    public static fx u() {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    u = new fx();
                }
            }
        }
        return u;
    }

    public b u(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        if (uVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(uVar.a())) {
            return new t(view, uVar);
        }
        if ("translate".equals(uVar.a())) {
            return new k(view, uVar);
        }
        if ("ripple".equals(uVar.a())) {
            return new n(view, uVar);
        }
        if ("marquee".equals(uVar.a())) {
            return new x(view, uVar);
        }
        if ("waggle".equals(uVar.a())) {
            return new my(view, uVar);
        }
        if ("shine".equals(uVar.a())) {
            return new l(view, uVar);
        }
        if ("swing".equals(uVar.a())) {
            return new s(view, uVar);
        }
        if ("fade".equals(uVar.a())) {
            return new u(view, uVar);
        }
        if ("rubIn".equals(uVar.a())) {
            return new jk(view, uVar);
        }
        if (FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION.equals(uVar.a())) {
            return new a(view, uVar);
        }
        if ("cutIn".equals(uVar.a())) {
            return new iz(view, uVar);
        }
        if ("stretch".equals(uVar.a())) {
            return new mv(view, uVar);
        }
        if ("bounce".equals(uVar.a())) {
            return new pn(view, uVar);
        }
        return null;
    }
}
