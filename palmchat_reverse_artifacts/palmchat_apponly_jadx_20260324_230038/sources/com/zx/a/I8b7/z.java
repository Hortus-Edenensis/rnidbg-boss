package com.zx.a.I8b7;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zx.a.I8b7.l2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16890a;
    public final /* synthetic */ String b;
    public final /* synthetic */ y c;

    public z(y yVar, int i, String str) {
        this.c = yVar;
        this.f16890a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.c.b.length() >= 10) {
                r2.a("error list length > MAX_COUNT " + this.c.b.length());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.f16890a);
            jSONObject.put("msg", this.b);
            this.c.b.put(jSONObject);
            r2.a("error add:" + jSONObject);
            if (m3.G) {
                r2.a("error save:" + this.c.b.toString());
                l2 l2Var = l2.a.f16824a;
                u3 u3Var = l2Var.f16823a;
                String string = this.c.b.toString();
                u3Var.getClass();
                l2Var.f16823a.a(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, string, true);
            }
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}
