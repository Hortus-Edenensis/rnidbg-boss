package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class cj5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, MediaItem.LocationInfo> f1996a = new HashMap();
    public Executor b = vw5.d(cj5.class.getSimpleName());
    public Executor c = ww5.b().a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public cj5 f1997a;
        public MediaItem b;

        public a(cj5 cj5Var, MediaItem mediaItem) {
            this.f1997a = cj5Var;
            this.b = mediaItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaItem.ExtractInfo extractInfo;
            if (this.f1997a.f1996a.containsKey(this.b.fileFullPath) || (extractInfo = this.b.extractInfo) == null) {
                return;
            }
            MediaItem.LocationInfo locationInfoC = ms1.c(AppContext.getContext(), extractInfo.lat, extractInfo.lng);
            if (locationInfoC != null) {
                this.b.setLocationInfo(locationInfoC);
                synchronized (cj5.class) {
                    this.f1997a.f1996a.put(this.b.fileFullPath, locationInfoC);
                }
            }
            ds0.a().b(new sg3());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static cj5 f1998a = new cj5();
    }

    public static cj5 c() {
        return b.f1998a;
    }

    public void b(MediaItem mediaItem, boolean z) {
        MediaItem.ExtractInfo extractInfo;
        if (mediaItem == null || TextUtils.isEmpty(mediaItem.fileFullPath) || (extractInfo = mediaItem.extractInfo) == null || !k86.K(extractInfo.lat, extractInfo.lng)) {
            return;
        }
        synchronized (cj5.class) {
            if (this.f1996a.containsKey(mediaItem.fileFullPath)) {
                mediaItem.setLocationInfo(this.f1996a.get(mediaItem.fileFullPath));
                return;
            }
            if (z) {
                this.c.execute(new a(this, mediaItem));
            } else {
                this.b.execute(new a(this, mediaItem));
            }
        }
    }

    public MediaItem.LocationInfo d(MediaItem mediaItem) {
        MediaItem.LocationInfo locationInfo;
        if (mediaItem == null || TextUtils.isEmpty(mediaItem.fileFullPath)) {
            return null;
        }
        synchronized (cj5.class) {
            locationInfo = this.f1996a.get(mediaItem.fileFullPath);
        }
        return locationInfo;
    }
}
