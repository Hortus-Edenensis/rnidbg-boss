package defpackage;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTFeedAd f17220a;
    public long b;
    public long c = 0;
    public a d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements TTAppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TTAppDownloadListener f17221a;

        public void a(TTAppDownloadListener tTAppDownloadListener) {
            this.f17221a = tTAppDownloadListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTAppDownloadListener tTAppDownloadListener = this.f17221a;
            if (tTAppDownloadListener != null) {
                tTAppDownloadListener.onDownloadActive(j, j2, str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTAppDownloadListener tTAppDownloadListener = this.f17221a;
            if (tTAppDownloadListener != null) {
                tTAppDownloadListener.onDownloadFailed(j, j2, str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            TTAppDownloadListener tTAppDownloadListener = this.f17221a;
            if (tTAppDownloadListener != null) {
                tTAppDownloadListener.onDownloadFinished(j, str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTAppDownloadListener tTAppDownloadListener = this.f17221a;
            if (tTAppDownloadListener != null) {
                tTAppDownloadListener.onDownloadPaused(j, j2, str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTAppDownloadListener tTAppDownloadListener = this.f17221a;
            if (tTAppDownloadListener != null) {
                tTAppDownloadListener.onIdle();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTAppDownloadListener tTAppDownloadListener = this.f17221a;
            if (tTAppDownloadListener != null) {
                tTAppDownloadListener.onInstalled(str, str2);
            }
        }

        public a() {
        }
    }

    public void a() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(null);
            this.d = null;
        }
    }

    public void b(TTAppDownloadListener tTAppDownloadListener) {
        a();
        a aVar = new a();
        this.d = aVar;
        aVar.a(tTAppDownloadListener);
        this.f17220a.setDownloadListener(this.d);
    }
}
