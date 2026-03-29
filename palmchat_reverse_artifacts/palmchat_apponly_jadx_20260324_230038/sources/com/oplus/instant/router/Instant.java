package com.oplus.instant.router;

import android.content.Context;
import com.oplus.instant.router.callback.Callback;
import defpackage.aw6;
import defpackage.d47;
import defpackage.h87;
import defpackage.i17;
import defpackage.ie7;
import defpackage.u97;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Instant {
    public static final String HOST_INSTANT = "instant";
    public static final String PATH_APP = "/app";
    public static final String SCHEME_OAPS = "oaps";

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Builder {
        public abstract Req build();

        public abstract Builder putExtra(String str, String str2);

        public abstract Builder putParams(String str, String str2);

        public abstract Builder putStat(String str, String str2);

        public abstract Builder setCallback(Callback callback);

        public abstract Builder setExtra(String str);

        public abstract Builder setFrom(String str);

        @Deprecated
        public abstract Builder setPackage(String str);

        @Deprecated
        public abstract Builder setPage(String str);

        @Deprecated
        public abstract Builder setPath(String str);

        public abstract Builder setRequestUrl(String str);

        public abstract Builder signAsPlatform();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class FromBuilder {
        public abstract String build();

        public abstract FromBuilder set(String str, String str2);

        public abstract FromBuilder setScene(String str);

        public abstract FromBuilder setTraceId(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IStatisticsProvider {
        void onStat(Map<String, String> map);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Req {
        public abstract void preload(Context context);

        public abstract void request(Context context);
    }

    public static Builder createBuilder(String str, String str2) {
        return new i17(str, str2);
    }

    public static FromBuilder createFromBuilder() {
        return new d47();
    }

    public static void enableLog() {
        h87.a();
    }

    public static String getGameEngineVersion(Context context) {
        return ie7.l(context);
    }

    public static String getSDKVersion() {
        return ie7.a();
    }

    public static String getVersion(Context context) {
        return ie7.b(context);
    }

    @Deprecated
    public static boolean isFitPltVersion(Context context, String str) {
        return ie7.g(context, str);
    }

    @Deprecated
    public static boolean isFitPltVersionStrict(Context context, String str) {
        return ie7.d(context, str);
    }

    @Deprecated
    public static boolean isInstantOapsUri(String str) {
        return u97.p(str);
    }

    public static boolean isInstantPlatformInstalled(Context context) {
        return ie7.f(context);
    }

    public static void setStatisticsProvider(IStatisticsProvider iStatisticsProvider) {
        aw6.a().b(iStatisticsProvider);
    }
}
