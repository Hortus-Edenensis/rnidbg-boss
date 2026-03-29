package com.opos.mobad.cmn.b;

import com.nearme.play.api.GameCard;
import com.nearme.play.context.SdkCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static void a(GameCard gameCard) {
        if (gameCard != null) {
            try {
                gameCard.handleResume();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GameCardUtils", "handleResume() fail", e);
            }
        }
    }

    public static void b(GameCard gameCard) {
        if (gameCard != null) {
            try {
                gameCard.handlePause();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GameCardUtils", "handlePause() fail", e);
            }
        }
    }

    public static void c(GameCard gameCard) {
        if (gameCard != null) {
            try {
                gameCard.exitGame();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GameCardUtils", "exitGame() fail", e);
            }
        }
    }

    public static boolean d(GameCard gameCard) {
        if (gameCard == null) {
            return false;
        }
        try {
            return gameCard.isMute();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GameCardUtils", "isMute() fail", e);
            return false;
        }
    }

    public static void a(GameCard gameCard, SdkCallback sdkCallback) {
        if (gameCard != null) {
            try {
                gameCard.preLoadCore(sdkCallback);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GameCardUtils", "preloadCore() fail", e);
            }
        }
    }

    public static void a(GameCard gameCard, boolean z) {
        if (gameCard != null) {
            try {
                gameCard.mute(z);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GameCardUtils", "mute() fail", e);
            }
        }
    }
}
