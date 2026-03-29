package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.utils.ax;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface g extends d, Serializable {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static g Code(String str) {
            Serializable serializableV = ax.V(str);
            if (serializableV instanceof AdContentData) {
                return new l((AdContentData) serializableV);
            }
            return null;
        }

        public static String Code(g gVar) {
            if (gVar instanceof l) {
                return ax.Code(((l) gVar).I);
            }
            return null;
        }
    }

    List<ImageInfo> B();

    VideoInfo C();

    List<String> L();

    ImageInfo Z();

    List<String> a();

    boolean b_();

    List<FeedbackInfo> t();
}
