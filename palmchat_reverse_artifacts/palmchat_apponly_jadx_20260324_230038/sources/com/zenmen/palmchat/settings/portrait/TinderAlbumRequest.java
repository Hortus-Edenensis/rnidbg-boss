package com.zenmen.palmchat.settings.portrait;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TinderAlbumRequest {
    public String pictureId;
    public String url;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Request {
        List<TinderAlbumRequest> pictureRequestList;
    }

    public TinderAlbumRequest(String str, String str2) {
        this.url = str;
        this.pictureId = str2;
    }
}
