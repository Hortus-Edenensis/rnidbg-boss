package com.getui.gtc.base.http;

import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface Interceptor {

    /* JADX INFO: compiled from: SearchBox */
    public interface Chain {
        HttpURLConnection connection();

        Response proceed(Request request) throws IOException;

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
