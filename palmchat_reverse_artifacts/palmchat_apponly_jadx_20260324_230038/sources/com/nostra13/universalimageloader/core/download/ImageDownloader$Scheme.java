package com.nostra13.universalimageloader.core.download;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.Locale;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public enum ImageDownloader$Scheme {
    HTTP(HttpHost.DEFAULT_SCHEME_NAME),
    HTTPS(BaseConstants.SCHEME_HTTPS),
    FILE("file"),
    CONTENT("content"),
    ASSETS("assets"),
    DRAWABLE("drawable"),
    UNKNOWN("");

    private String scheme;
    private String uriPrefix;

    ImageDownloader$Scheme(String str) {
        this.scheme = str;
        this.uriPrefix = str + "://";
    }

    private boolean belongsTo(String str) {
        return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
    }

    public static ImageDownloader$Scheme ofUri(String str) {
        if (str != null) {
            for (ImageDownloader$Scheme imageDownloader$Scheme : values()) {
                if (imageDownloader$Scheme.belongsTo(str)) {
                    return imageDownloader$Scheme;
                }
            }
        }
        return UNKNOWN;
    }

    public String crop(String str) {
        if (belongsTo(str)) {
            return str.substring(this.uriPrefix.length());
        }
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
    }

    public String wrap(String str) {
        return this.uriPrefix + str;
    }
}
