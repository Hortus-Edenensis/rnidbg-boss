package com.opos.mobad.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8537a = new h() { // from class: com.opos.mobad.ad.h.1
        @Override // com.opos.mobad.ad.h
        public void onFailed(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("init failed.reason=");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.c("IInitListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.h
        public void onSuccess() {
            com.opos.cmn.an.f.a.b("IInitListener", "init success.");
        }
    };

    void onFailed(String str);

    void onSuccess();
}
