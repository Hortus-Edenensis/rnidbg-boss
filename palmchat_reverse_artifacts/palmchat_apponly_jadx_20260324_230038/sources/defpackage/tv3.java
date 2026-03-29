package defpackage;

import androidx.annotation.NonNull;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NestAdData f21078a;
    public boolean b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestAdData.AdRenderListener {
        public a() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdRenderListener
        public void onRenderFail(String str, NestAdData nestAdData, int i, String str2) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onRenderFail");
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdRenderListener
        public void onRenderSuccess(String str, NestAdData nestAdData) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onRenderSuccess");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21080a = false;

        public b() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(@NonNull NestAdData nestAdData) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onDownloadComplete");
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(@NonNull NestAdData nestAdData) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onDownloadFailed");
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(@NonNull NestAdData nestAdData) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onDownloadInstalled");
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(@NonNull NestAdData nestAdData) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onDownloadPause");
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(@NonNull NestAdData nestAdData, int i) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onDownloadProgress:" + i);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(@NonNull NestAdData nestAdData) {
            LogUtil.d(com.zenmen.palmchat.peoplenearby.ad.a.f, "reward onDownloadStart");
            if (this.f21080a) {
                return;
            }
            this.f21080a = true;
        }
    }

    public NestAdData a() {
        return this.f21078a;
    }

    public boolean b() {
        return this.b;
    }

    public void c(NestAdData nestAdData) {
        this.f21078a = nestAdData;
        if (nestAdData == null) {
            return;
        }
        nestAdData.setAdRenderListener(new a());
        this.f21078a.setAppDownloadListener(new b());
    }

    public void d(boolean z) {
        this.b = z;
    }
}
