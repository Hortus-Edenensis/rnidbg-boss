package defpackage;

import com.zenmen.palmchat.activity.webview2.WebView;
import com.zenmen.palmchat.browser.SRobotCompModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0006"}, d2 = {"Lcom/zenmen/palmchat/activity/webview2/WebView;", "webview", "Lcom/zenmen/palmchat/browser/SRobotCompModel;", "compModel", "", "a", "app_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nVideoListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoListener.kt\ncom/zenmen/palmchat/activity/webview2/VideoListenerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class oc6 {
    public static final void a(WebView webview, SRobotCompModel sRobotCompModel) {
        Intrinsics.checkNotNullParameter(webview, "webview");
        if (sRobotCompModel == null) {
            return;
        }
        webview.loadUrl(((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) (((Object) "javascript:") + "var videos = document.getElementsByTagName('video');")) + "var video = videos[videos.length-1];")) + "if (video != undefined) {")) + "window.VideoListener.onFound();")) + "function video_play() {")) + "window.VideoListener.onPlay(video.duration);")) + "}")) + "video.addEventListener('play', video_play);")) + "function video_update() {")) + "window.VideoListener.onTimeUpdate(video.currentTime);")) + "}")) + "video.addEventListener('timeupdate', video_update);")) + "function video_pause() {")) + "window.VideoListener.onPause();")) + "}")) + "video.addEventListener('pause', video_pause);")) + "function video_ended() {")) + "window.VideoListener.onEnd();")) + "}")) + "video.addEventListener('ended', video_ended);")) + "}");
    }
}
