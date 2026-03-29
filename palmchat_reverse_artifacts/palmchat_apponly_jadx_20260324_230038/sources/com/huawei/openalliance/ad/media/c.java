package com.huawei.openalliance.ad.media;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.ap;
import com.huawei.openalliance.ad.utils.bl;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c implements IMultiMediaPlayingManager {
    private static final String Code = "c";
    private static final byte[] I = new byte[0];
    private static c V;
    private MediaPlayerAgent B;
    private Context S;
    private final byte[] Z = new byte[0];
    private Queue<a> C = new ConcurrentLinkedQueue();
    private MediaStateListener F = new MediaStateListener() { // from class: com.huawei.openalliance.ad.media.c.1
        private void Code() {
            synchronized (c.this.Z) {
                if (fh.Code()) {
                    fh.Code(c.Code, "checkAndPlayNext current player: %s", c.this.B);
                }
                if (c.this.B == null) {
                    c.this.V();
                }
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
            if (fh.Code()) {
                fh.Code(c.Code, "onMediaCompletion: %s", mediaPlayerAgent);
            }
            c.this.V();
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
            if (fh.Code()) {
                fh.Code(c.Code, "onMediaPause: %s", mediaPlayerAgent);
            }
            Code();
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
            if (fh.Code()) {
                fh.Code(c.Code, "onMediaStop: %s", mediaPlayerAgent);
            }
            Code();
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onProgress(int i, int i2) {
        }
    };
    private com.huawei.openalliance.ad.media.listener.c D = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.media.c.2
        @Override // com.huawei.openalliance.ad.media.listener.c
        public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
            if (fh.Code()) {
                fh.Code(c.Code, "onError: %s", mediaPlayerAgent);
            }
            synchronized (c.this.Z) {
                mediaPlayerAgent.V(this);
            }
            c.this.V();
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        final String Code;
        final MediaPlayerAgent V;

        public a(String str, MediaPlayerAgent mediaPlayerAgent) {
            this.Code = str;
            this.V = mediaPlayerAgent;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.Code, aVar.Code) && this.V == aVar.V;
        }

        public int hashCode() {
            String str = this.Code;
            int iHashCode = str != null ? str.hashCode() : -1;
            MediaPlayerAgent mediaPlayerAgent = this.V;
            return iHashCode & super.hashCode() & (mediaPlayerAgent != null ? mediaPlayerAgent.hashCode() : -1);
        }

        public String toString() {
            return "Task [" + bl.Code(this.Code) + "]";
        }
    }

    private c(Context context) {
        this.S = context.getApplicationContext();
    }

    public static c Code(Context context) {
        c cVar;
        synchronized (I) {
            if (V == null) {
                V = new c(context);
            }
            cVar = V;
        }
        return cVar;
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Z(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            if (fh.Code()) {
                fh.Code(Code, "pause - url: %s player: %s currentPlayer: %s", bl.Code(str), mediaPlayerAgent, this.B);
            }
            if (mediaPlayerAgent == this.B) {
                fh.V(Code, "pause current");
                mediaPlayerAgent.I(str);
            } else {
                fh.V(Code, "pause - remove from queue");
                this.C.remove(new a(str, mediaPlayerAgent));
                V(mediaPlayerAgent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (ap.I(this.S)) {
            synchronized (this.Z) {
                a aVarPoll = this.C.poll();
                if (fh.Code()) {
                    fh.Code(Code, "playNextTask - task: %s currentPlayer: %s", aVarPoll, this.B);
                }
                if (aVarPoll != null) {
                    if (fh.Code()) {
                        fh.Code(Code, "playNextTask - play: %s", aVarPoll.V);
                    }
                    aVarPoll.V.Code(this.F);
                    aVarPoll.V.Code(this.D);
                    aVarPoll.V.Code(aVarPoll.Code);
                    this.B = aVarPoll.V;
                } else {
                    this.B = null;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void I(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            if (fh.Code()) {
                fh.Code(Code, "stop - url: %s player: %s currentPlayer: %s", bl.Code(str), mediaPlayerAgent, this.B);
            }
            if (mediaPlayerAgent == this.B) {
                fh.V(Code, "stop current");
                this.B = null;
                mediaPlayerAgent.V(str);
            } else {
                fh.V(Code, "stop - remove from queue");
                this.C.remove(new a(str, mediaPlayerAgent));
                V(mediaPlayerAgent);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            MediaPlayerAgent mediaPlayerAgent2 = this.B;
            if (mediaPlayerAgent == mediaPlayerAgent2) {
                V(mediaPlayerAgent2);
                this.B = null;
            }
            Iterator<a> it = this.C.iterator();
            while (it.hasNext()) {
                MediaPlayerAgent mediaPlayerAgent3 = it.next().V;
                if (mediaPlayerAgent3 == mediaPlayerAgent) {
                    V(mediaPlayerAgent3);
                    it.remove();
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(MediaPlayerAgent mediaPlayerAgent) {
        synchronized (this.Z) {
            if (mediaPlayerAgent != null) {
                mediaPlayerAgent.V(this.F);
                mediaPlayerAgent.V(this.D);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(String str, MediaPlayerAgent mediaPlayerAgent) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            if (fh.Code()) {
                fh.Code(Code, "autoPlay - url: %s player: %s, currentPlayer: %s", bl.Code(str), mediaPlayerAgent, this.B);
            }
            MediaPlayerAgent mediaPlayerAgent2 = this.B;
            if (mediaPlayerAgent == mediaPlayerAgent2 || mediaPlayerAgent2 == null) {
                mediaPlayerAgent.Code(this.F);
                mediaPlayerAgent.Code(this.D);
                mediaPlayerAgent.Code(str);
                this.B = mediaPlayerAgent;
                str2 = Code;
                str3 = "autoPlay - play directly";
            } else {
                a aVar = new a(str, mediaPlayerAgent);
                this.C.remove(aVar);
                this.C.add(aVar);
                str2 = Code;
                str3 = "autoPlay - add to queue";
            }
            fh.V(str2, str3);
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.Z) {
            if (fh.Code()) {
                fh.Code(Code, "manualPlay - url: %s player: %s currentPlayer: %s", bl.Code(str), mediaPlayerAgent, this.B);
            }
            MediaPlayerAgent mediaPlayerAgent2 = this.B;
            if (mediaPlayerAgent2 != null && mediaPlayerAgent != mediaPlayerAgent2) {
                mediaPlayerAgent2.Code();
                fh.V(Code, "manualPlay - stop other");
            }
            fh.V(Code, "manualPlay - play new");
            mediaPlayerAgent.Code(this.F);
            mediaPlayerAgent.Code(this.D);
            mediaPlayerAgent.Code(str);
            this.B = mediaPlayerAgent;
            this.C.remove(new a(str, mediaPlayerAgent));
        }
    }
}
