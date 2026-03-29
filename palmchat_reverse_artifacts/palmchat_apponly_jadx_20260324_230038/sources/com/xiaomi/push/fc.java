package com.xiaomi.push;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fc {
    public static int a(Throwable th) {
        boolean z = th instanceof fi;
        if (z) {
            fi fiVar = (fi) th;
            if (fiVar.a() != null) {
                th = fiVar.a();
            }
        }
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        if (th instanceof SocketTimeoutException) {
            return 105;
        }
        if (!(th instanceof SocketException)) {
            if (th instanceof UnknownHostException) {
                return 107;
            }
            return z ? 399 : 0;
        }
        if (message.indexOf("Network is unreachable") != -1) {
            return 102;
        }
        if (message.indexOf("Connection refused") != -1) {
            return 103;
        }
        if (message.indexOf("Connection timed out") != -1) {
            return 105;
        }
        if (message.endsWith("EACCES (Permission denied)")) {
            return 101;
        }
        if (message.indexOf("Connection reset by peer") != -1) {
            return 109;
        }
        if (message.indexOf("Broken pipe") != -1) {
            return 110;
        }
        if (message.indexOf("No route to host") != -1) {
            return 104;
        }
        if (message.endsWith("EINVAL (Invalid argument)")) {
            return 106;
        }
        return MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH;
    }
}
