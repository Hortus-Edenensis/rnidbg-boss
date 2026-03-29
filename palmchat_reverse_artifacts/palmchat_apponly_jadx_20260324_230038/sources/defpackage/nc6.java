package defpackage;

import android.webkit.JavascriptInterface;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.activity.webview2.WebView;
import com.zenmen.palmchat.browser.SRobotCompModel;
import com.zenmen.palmchat.utils.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007J\u0006\u0010\u000b\u001a\u00020\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'¨\u00067"}, d2 = {"Lnc6;", "", "", "onFound", "", "duration", "onPlay", "currentTime", "onTimeUpdate", "onPause", "onEnd", "a", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "webview", "Lcom/zenmen/palmchat/browser/SRobotCompModel;", "compModel", "c", "", "Ljava/lang/String;", "getOriginUrl", "()Ljava/lang/String;", "setOriginUrl", "(Ljava/lang/String;)V", "originUrl", t.l, "getComplainUrl", "complainUrl", "", "Z", "getVideoFound", "()Z", "setVideoFound", "(Z)V", "videoFound", "d", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "getVideoStartTime", "()J", "setVideoStartTime", "(J)V", "videoStartTime", "e", "getVideoDuration", "setVideoDuration", "videoDuration", "f", "getVideoCurrent", "setVideoCurrent", "videoCurrent", "g", "getVideoPlayTime", "setVideoPlayTime", bq.f.H, "<init>", "()V", "app_release"}, k = 1, mv = {1, 8, 0})
public final class nc6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String originUrl = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String complainUrl = "";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean videoFound;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public long videoStartTime;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public long videoDuration;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public long videoCurrent;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public long videoPlayTime;

    public final void a() {
        if (!a96.a(this.originUrl, this.complainUrl) || this.videoStartTime <= 0) {
            return;
        }
        this.videoPlayTime += System.currentTimeMillis() - this.videoStartTime;
        this.videoStartTime = 0L;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.complainUrl = str;
    }

    public final void c(WebView webview, SRobotCompModel compModel) {
        Intrinsics.checkNotNullParameter(webview, "webview");
        oc6.a(webview, compModel);
    }

    @JavascriptInterface
    public final void onEnd() {
        LogUtil.d("logrobot", "video: onEnd");
        a();
    }

    @JavascriptInterface
    public final void onFound() {
        LogUtil.d("logrobot", "video: onFound");
        if (a96.a(this.originUrl, this.complainUrl)) {
            this.videoFound = true;
        }
    }

    @JavascriptInterface
    public final void onPause() {
        LogUtil.d("logrobot", "video: onPause");
        a();
    }

    @JavascriptInterface
    public final void onPlay(long duration) {
        LogUtil.d("logrobot", "video: onPlay=" + duration);
        if (a96.a(this.originUrl, this.complainUrl)) {
            this.videoStartTime = System.currentTimeMillis();
            this.videoDuration = duration;
        }
    }

    @JavascriptInterface
    public final void onTimeUpdate(long currentTime) {
        LogUtil.d("logrobot", "video: onTimeUpdate=" + currentTime);
        if (a96.a(this.originUrl, this.complainUrl)) {
            this.videoCurrent = Math.max(this.videoCurrent, currentTime);
        }
    }
}
