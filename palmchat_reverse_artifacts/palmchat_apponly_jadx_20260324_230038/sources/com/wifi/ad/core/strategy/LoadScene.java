package com.wifi.ad.core.strategy;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.greendao.greendaogen.FeedDao;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/wifi/ad/core/strategy/LoadScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "DRAWAD", "SPLASH", FeedDao.TABLENAME, "REWARD", "INTERSTITIAL", "core_release"}, k = 1, mv = {1, 1, 16})
public enum LoadScene {
    DRAWAD("drawad"),
    SPLASH(MediationConstant.RIT_TYPE_SPLASH),
    FEED(MediationConstant.RIT_TYPE_FEED),
    REWARD("reward"),
    INTERSTITIAL(MediationConstant.RIT_TYPE_INTERSTITIAL);

    private final String scene;

    LoadScene(String str) {
        this.scene = str;
    }

    public final String getScene() {
        return this.scene;
    }
}
