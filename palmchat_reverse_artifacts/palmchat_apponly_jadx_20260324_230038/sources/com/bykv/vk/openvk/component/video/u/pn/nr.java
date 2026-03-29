package com.bykv.vk.openvk.component.video.u.pn;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.util.HashMap;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.u.pn.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0162nr {
        void u(Bitmap bitmap);
    }

    public static void u(long j, String str, InterfaceC0162nr interfaceC0162nr) {
        new u(interfaceC0162nr, j).u((Object[]) new String[]{str});
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.bytedance.sdk.component.jk.b.nr<String, Integer, Bitmap> {
        private long fx;
        private InterfaceC0162nr nr;

        public u(InterfaceC0162nr interfaceC0162nr, long j) {
            this.nr = interfaceC0162nr;
            this.fx = j;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap frameAtTime = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.fx * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0162nr interfaceC0162nr = this.nr;
            if (interfaceC0162nr != null) {
                interfaceC0162nr.u(bitmap);
            }
        }
    }
}
