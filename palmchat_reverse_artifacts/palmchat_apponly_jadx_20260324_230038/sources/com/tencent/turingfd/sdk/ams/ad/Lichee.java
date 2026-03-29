package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Lichee implements ITuringDID {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Canesatici f10714a;

    public Lichee(Canesatici canesatici) {
        this.f10714a = canesatici;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public String getAIDCode() {
        return ((Ginkgo) this.f10714a).g;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public String getAIDTicket() {
        return ((Ginkgo) this.f10714a).f;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public int getErrorCode() {
        return ((Ginkgo) this.f10714a).c;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public long getExpiredTimestamp() {
        return ((Ginkgo) this.f10714a).b;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public String getOpenIdTicket() {
        return ((Ginkgo) this.f10714a).f10700a;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.ITuringDID
    public String getTAIDTicket() {
        return ((Ginkgo) this.f10714a).e;
    }
}
