package com.zx.a.I8b7;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zx.a.I8b7.l2;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f16777a;

    public b0(y yVar) {
        this.f16777a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            y yVar = this.f16777a;
            if (yVar.b != null) {
                yVar.b = new JSONArray();
                l2 l2Var = l2.a.f16824a;
                l2Var.f16823a.getClass();
                l2Var.f16823a.a(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, "", true);
            }
        } catch (Throwable unused) {
        }
    }
}
