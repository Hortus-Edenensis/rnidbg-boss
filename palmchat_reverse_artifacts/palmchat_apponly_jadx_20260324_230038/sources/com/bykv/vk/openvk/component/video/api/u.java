package com.bykv.vk.openvk.component.video.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface u {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.api.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0156u {
        void fx(u uVar);

        void nr(u uVar);

        void nr(u uVar, int i);

        void u(u uVar);

        void u(u uVar, int i);

        void u(u uVar, int i, int i2);

        void u(u uVar, int i, int i2, int i3);

        void u(u uVar, long j);

        void u(u uVar, long j, long j2);

        void u(u uVar, com.bykv.vk.openvk.component.video.api.fx.fx fxVar);

        void u(u uVar, JSONObject jSONObject, String str);

        void u(u uVar, boolean z);
    }

    boolean a();

    void b();

    long bg();

    void fx();

    void fx(boolean z);

    boolean iz();

    boolean jk();

    boolean k();

    int l();

    boolean mv();

    long my();

    SurfaceTexture n();

    void nr();

    void nr(boolean z);

    int o();

    void pn();

    boolean s();

    long sx();

    int t();

    void u();

    void u(float f);

    void u(int i);

    void u(long j);

    void u(SurfaceTexture surfaceTexture);

    void u(SurfaceHolder surfaceHolder);

    void u(iz izVar);

    void u(InterfaceC0156u interfaceC0156u);

    void u(boolean z);

    void u(boolean z, long j, boolean z2);

    SurfaceHolder x();
}
