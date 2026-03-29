package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ILoggerReporter {

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(d dVar);
}
