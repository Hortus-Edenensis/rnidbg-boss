package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5400a;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.nr b;
    private Context fx;
    private boolean iz = false;
    private TTViewStub n;
    private TextView nr;
    private nr pn;
    private View u;
    private com.bykv.vk.openvk.component.video.api.fx.b x;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        boolean jk();

        void l();
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    private void b() {
        View view = this.u;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        if (this.fx == null) {
            return;
        }
        b();
    }

    private void nr() {
        this.x = null;
    }

    public void u(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.f5400a = view;
        this.fx = dw.getContext().getApplicationContext();
        try {
            this.n = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.n());
        } catch (Throwable unused) {
        }
    }

    private void u(Context context, View view, boolean z) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.n) == null || tTViewStub.getParent() == null || this.u != null) {
            return;
        }
        this.n.u();
        this.u = view.findViewById(2114387870);
        this.nr = (TextView) view.findViewById(2114387817);
        View viewFindViewById = view.findViewById(2114387880);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    k.this.fx();
                    if (k.this.b != null) {
                        k.this.b.u(u.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nativevideo.nr nrVar, nr nrVar2) {
        this.pn = nrVar2;
        this.b = nrVar;
    }

    public boolean u(int i, com.bykv.vk.openvk.component.video.api.fx.b bVar, boolean z) {
        Context context = this.fx;
        if (context != null && bVar != null) {
            try {
                u(context, this.f5400a, z);
                this.x = bVar;
                if (i == 1 || i == 2) {
                    return u(i);
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private boolean u(int i) {
        nr nrVar;
        if (u() || this.iz) {
            return true;
        }
        if (this.b != null && (nrVar = this.pn) != null) {
            if (nrVar.jk()) {
                this.b.pn(null, null);
            }
            this.b.u(u.PAUSE_VIDEO, (String) null);
        }
        u(this.x, true);
        return false;
    }

    public void u(boolean z) {
        if (z) {
            nr();
        }
        b();
    }

    public boolean u() {
        View view = this.u;
        return view != null && view.getVisibility() == 0;
    }

    private void u(com.bykv.vk.openvk.component.video.api.fx.b bVar, boolean z) {
        View view;
        String str;
        View view2;
        if (bVar == null || (view = this.u) == null || this.fx == null || view.getVisibility() == 0) {
            return;
        }
        nr nrVar = this.pn;
        if (nrVar != null) {
            nrVar.l();
        }
        int iCeil = (int) Math.ceil((bVar.pn() * 1.0d) / 1048576.0d);
        if (z) {
            str = q.u(this.fx, "tt_video_without_wifi_tips") + iCeil + q.u(this.fx, "tt_video_bytesize_MB") + q.u(this.fx, "tt_video_bytesize");
        } else {
            str = q.u(this.fx, "tt_video_without_wifi_tips") + q.u(this.fx, "tt_video_bytesize");
        }
        y.u(this.u, 0);
        y.u(this.nr, str);
        if (!y.b(this.u) || (view2 = this.u) == null) {
            return;
        }
        view2.bringToFront();
    }
}
