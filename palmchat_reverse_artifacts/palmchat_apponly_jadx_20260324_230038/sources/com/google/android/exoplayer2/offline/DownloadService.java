package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.scheduler.Requirements;
import defpackage.g86;
import defpackage.r34;
import defpackage.vf1;
import defpackage.vh;
import defpackage.y53;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class DownloadService extends Service {
    public static final HashMap<Class<? extends DownloadService>, a> j = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f5908a;

    @StringRes
    public final int b;

    @StringRes
    public final int c;
    public a d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public DownloadService f5909a;

        public static /* synthetic */ vf1 a(a aVar) {
            aVar.getClass();
            return null;
        }

        public void b(DownloadService downloadService) {
            vh.g(this.f5909a == null);
            this.f5909a = downloadService;
            throw null;
        }

        public void c(DownloadService downloadService) {
            vh.g(this.f5909a == downloadService);
            this.f5909a = null;
        }
    }

    public abstract vf1 a();

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f5908a;
        if (str != null) {
            r34.a(this, str, this.b, this.c, 2);
        }
        a aVar = j.get(getClass());
        if (aVar != null) {
            this.d = aVar;
            aVar.b(this);
        } else {
            int i = g86.f17680a;
            a();
            throw null;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.i = true;
        ((a) vh.e(this.d)).c(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        String action;
        String stringExtra;
        this.e = i2;
        this.g = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra("content_id");
            this.f |= intent.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        a.a((a) vh.e(this.d));
        switch (action) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                if (((DownloadRequest) ((Intent) vh.e(intent)).getParcelableExtra("download_request")) != null) {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                y53.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                break;
                break;
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                if (((Requirements) ((Intent) vh.e(intent)).getParcelableExtra("requirements")) != null) {
                    throw null;
                }
                y53.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                break;
                break;
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) vh.e(intent)).hasExtra("stop_reason")) {
                    y53.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    throw null;
                }
                y53.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                break;
                break;
            default:
                y53.c("DownloadService", "Ignored unrecognized action: " + action);
                break;
        }
        if (g86.f17680a >= 26) {
            boolean z = this.f;
        }
        this.h = false;
        throw null;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.g = true;
    }
}
