package com.opos.mobad.video.player.f;

import android.app.Activity;
import android.content.Context;
import com.nearme.play.api.AdTrialGameInfo;
import com.nearme.play.api.CardFeedback;
import com.nearme.play.api.GameCard;
import com.nearme.play.context.SdkCallback;
import com.nearme.play.router.RouterParams;
import com.opos.cmn.i.h;
import com.opos.mobad.cmn.service.b.a;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.video.player.f.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private a b;
    private GameCard c;
    private CardFeedback d;
    private c e;
    private volatile AdTrialGameInfo f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f10347a = d.STATE_INIT;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private volatile Boolean i = null;
    private AtomicInteger j = new AtomicInteger(0);
    private Runnable k = new Runnable() { // from class: com.opos.mobad.video.player.f.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.h();
        }
    };
    private AtomicInteger l = new AtomicInteger(0);
    private Runnable m = new Runnable() { // from class: com.opos.mobad.video.player.f.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.i();
        }
    };
    private a.InterfaceC0731a n = new a.InterfaceC0731a() { // from class: com.opos.mobad.video.player.f.b.3
        @Override // com.opos.mobad.cmn.service.b.a.InterfaceC0731a
        public void a() {
            if (b.this.f10347a == d.STATE_LOADING) {
                b.this.i();
            }
        }

        @Override // com.opos.mobad.cmn.service.b.a.InterfaceC0731a
        public void b() {
            if (b.this.f10347a == d.STATE_LOADING) {
                b.this.c(false);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.opos.mobad.b f10355a;
        public Activity b;
        public String c;
        public long d;
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0818b {
        void a(com.opos.mobad.video.player.f.a.a aVar);

        void a(com.opos.mobad.video.player.f.a.b bVar);

        void b(com.opos.mobad.video.player.f.a.a aVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AdItemData f10356a;
        public MaterialData b;
        public InterfaceC0818b c;
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum d {
        STATE_INIT(1),
        STATE_LOADING(2),
        STATE_LOAD_ERROR(3),
        STATE_LOAD_TIMEOUT(4),
        STATE_LOAD_FINISH(5),
        STATE_PLAYING(6),
        STATE_PLAY_FINISH(7);

        public final int h;

        d(int i2) {
            this.h = i2;
        }
    }

    public b(a aVar) {
        this.b = aVar;
        com.opos.mobad.cmn.service.b.a.a().a(this.n);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdTrialGameInfo adTrialGameInfo) {
        if (!this.h || adTrialGameInfo == null || this.g) {
            return;
        }
        this.g = true;
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.video.player.f.b.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b(adTrialGameInfo);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("TrialGamePresenter", "doShowInner() fail", e);
                    b.this.a(new com.opos.mobad.video.player.f.a.b(10418, "Trial game load failed. " + e.getMessage()));
                }
            }
        });
    }

    private void g() {
        com.opos.mobad.cmn.b.b.a(l(), new SdkCallback() { // from class: com.opos.mobad.video.player.f.b.6
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        long j = ((long) this.j.get()) * 1000;
        if (j >= n()) {
            InterfaceC0818b interfaceC0818bQ = q();
            if (interfaceC0818bQ != null) {
                this.f10347a = d.STATE_PLAY_FINISH;
                com.opos.mobad.video.player.f.a.a aVar = new com.opos.mobad.video.player.f.a.a();
                aVar.f10345a = j;
                aVar.b = n();
                interfaceC0818bQ.b(aVar);
                c();
            }
            b(true);
            return;
        }
        InterfaceC0818b interfaceC0818bQ2 = q();
        if (interfaceC0818bQ2 != null) {
            this.f10347a = d.STATE_PLAYING;
            com.opos.mobad.video.player.f.a.a aVar2 = new com.opos.mobad.video.player.f.a.a();
            aVar2.f10345a = j;
            aVar2.b = n();
            interfaceC0818bQ2.a(aVar2);
        }
        this.j.incrementAndGet();
        b(false);
        com.opos.mobad.d.c.c.a(this.k, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (((long) this.l.get()) * 1000 < 20000) {
                this.l.incrementAndGet();
                c(false);
                com.opos.mobad.d.c.c.a(this.m, 1000L);
            } else {
                if (this.f10347a == d.STATE_LOAD_FINISH) {
                    c(false);
                    return;
                }
                this.f10347a = d.STATE_LOAD_TIMEOUT;
                a(new com.opos.mobad.video.player.f.a.b(10418, "Trial game load failed. Load timeout."));
                c(false);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "onTimeoutTimerStart() fail", e);
        }
    }

    private CardFeedback j() {
        final InterfaceC0818b interfaceC0818bQ = q();
        return new CardFeedback() { // from class: com.opos.mobad.video.player.f.b.7
        };
    }

    private com.opos.mobad.b k() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.f10355a;
        }
        return null;
    }

    private Context l() {
        com.opos.mobad.b bVarK;
        if (this.b == null || (bVarK = k()) == null) {
            return null;
        }
        return bVarK.b();
    }

    private String m() {
        a aVar = this.b;
        return aVar != null ? aVar.c : "";
    }

    private long n() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.d;
        }
        return -1L;
    }

    private String o() {
        MaterialData materialData;
        c cVar = this.e;
        if (cVar == null || (materialData = cVar.b) == null) {
            return null;
        }
        return materialData.ai();
    }

    private long p() {
        MaterialData materialData;
        c cVar = this.e;
        if (cVar == null || (materialData = cVar.b) == null) {
            return -1L;
        }
        return materialData.aj();
    }

    private InterfaceC0818b q() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.c;
        }
        return null;
    }

    public void d() {
        GameCard gameCard = this.c;
        if (gameCard != null) {
            com.opos.mobad.cmn.b.c.c(gameCard);
            this.c = null;
        }
    }

    public void e() {
        try {
            d();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "destroy() fail", e);
        }
        com.opos.mobad.cmn.service.b.a.a().b(this.n);
        this.n = null;
        d(false);
        this.e = null;
        this.b = null;
    }

    public Map<String, String> f() {
        HashMap map = new HashMap();
        h.a(map, "posId", m());
        if (this.f != null) {
            h.a(map, "trialGameInfo", com.opos.mobad.cmn.b.a.a(this.f).toString());
        }
        if (this.e != null) {
            h.a(map, "trialGameId", o());
            h.a(map, "trialGameVId", String.valueOf(p()));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.video.player.f.a.b bVar) {
        this.f10347a = d.STATE_LOAD_ERROR;
        c(true);
        InterfaceC0818b interfaceC0818bQ = q();
        if (interfaceC0818bQ != null) {
            if (bVar != null) {
                bVar.c = f();
            }
            interfaceC0818bQ.a(bVar);
        }
    }

    private void d(boolean z) {
        c(z);
        b(z);
    }

    public void b() {
        if (this.f10347a.h < d.STATE_LOAD_FINISH.h) {
            com.opos.cmn.an.f.a.a("TrialGamePresenter", "handleResume but not load finish");
            return;
        }
        com.opos.cmn.an.f.a.b("TrialGamePresenter", "handleResume");
        try {
            GameCard gameCard = this.c;
            if (gameCard != null) {
                com.opos.mobad.cmn.b.c.a(gameCard);
                if (this.i != null) {
                    com.opos.mobad.cmn.b.c.a(this.c, this.i.booleanValue());
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "handleResume() fail", e);
        }
        h();
    }

    public void c() {
        if (this.f10347a.h < d.STATE_LOAD_FINISH.h) {
            com.opos.cmn.an.f.a.a("TrialGamePresenter", "handlePause but not load finish");
            return;
        }
        com.opos.cmn.an.f.a.b("TrialGamePresenter", "handlePause");
        try {
            GameCard gameCard = this.c;
            if (gameCard != null) {
                this.i = Boolean.valueOf(gameCard.isMute());
                com.opos.mobad.cmn.b.c.b(this.c);
                com.opos.mobad.cmn.b.c.a(this.c, true);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "handlePause() fail", e);
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdTrialGameInfo adTrialGameInfo) {
        com.opos.cmn.an.f.a.b("TrialGamePresenter", "launchGame() isPreloadCoreSuccess=", Boolean.valueOf(this.h));
        GameCard gameCardA = com.opos.mobad.cmn.b.b.a();
        this.c = gameCardA;
        if (gameCardA == null) {
            a(new com.opos.mobad.video.player.f.a.b(10418, "Trial game load failed. Game card is null."));
            return;
        }
        RouterParams routerParamsBuild = new RouterParams.Builder().setGameDesc(adTrialGameInfo.getName(), adTrialGameInfo.getGamePic()).setLaunchUri("hap://game/" + com.opos.mobad.cmn.b.a.b(adTrialGameInfo)).build();
        this.d = j();
        this.c.prepareAdTrialGameInfo(adTrialGameInfo);
        this.c.launchGame(routerParamsBuild, this.d);
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d(true);
        this.e = cVar;
        this.f = null;
        this.g = false;
        this.f10347a = d.STATE_INIT;
        a.C0817a c0817a = new a.C0817a();
        c0817a.f10344a = l();
        c0817a.b = o();
        c0817a.c = p();
        com.opos.mobad.video.player.f.a.a(c0817a, new a.b() { // from class: com.opos.mobad.video.player.f.b.4
            @Override // com.opos.mobad.video.player.f.a.b
            public void a(AdTrialGameInfo adTrialGameInfo) {
                if (adTrialGameInfo == null) {
                    b.this.a(new com.opos.mobad.video.player.f.a.b(10418, "Trial game load failed. Game info is null."));
                } else {
                    b.this.a(adTrialGameInfo);
                    b.this.f = adTrialGameInfo;
                }
            }

            @Override // com.opos.mobad.video.player.f.a.b
            public void a(com.opos.mobad.video.player.f.a.b bVar) {
                b.this.a(bVar);
            }
        });
        i();
        this.f10347a = d.STATE_LOADING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        try {
            com.opos.mobad.d.c.c.b(this.m);
            if (z) {
                this.l.set(0);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "onTimeoutTimerStop() fail", e);
        }
    }

    private void b(boolean z) {
        try {
            com.opos.mobad.d.c.c.b(this.k);
            if (z) {
                this.j.set(0);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "onCountTimerStop() fail", e);
        }
    }

    public void a(boolean z) {
        GameCard gameCard;
        try {
            boolean z2 = true;
            if (z == (!com.opos.mobad.cmn.b.c.d(this.c)) || (gameCard = this.c) == null) {
                return;
            }
            if (z) {
                z2 = false;
            }
            com.opos.mobad.cmn.b.c.a(gameCard, z2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "onSoundClick()", e);
        }
    }

    public boolean a() {
        try {
            GameCard gameCard = this.c;
            if (gameCard != null) {
                return com.opos.mobad.cmn.b.c.d(gameCard);
            }
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGamePresenter", "isMute()", e);
            return false;
        }
    }
}
