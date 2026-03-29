package org.jsoup.nodes;

import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.io.IOException;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class c extends g {
    public c(String str, String str2) {
        super(str2);
        this.c.k(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, str);
    }

    @Override // org.jsoup.nodes.g
    public void A(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.h()) {
            v(appendable, i, outputSettings);
        }
        appendable.append("<!--").append(T()).append("-->");
    }

    public String T() {
        return this.c.e(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT);
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return y();
    }

    @Override // org.jsoup.nodes.g
    public String x() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.g
    public void B(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }
}
