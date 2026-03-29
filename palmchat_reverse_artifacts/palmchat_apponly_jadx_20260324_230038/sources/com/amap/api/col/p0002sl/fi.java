package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fi implements INearbySearch {
    private static long e;
    private String b;
    private Context c;
    private dt d;
    private ExecutorService f;
    private UploadInfoCallback k;
    private TimerTask l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<NearbySearch.NearbyListener> f2754a = new ArrayList();
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {
        private a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (fi.this.k != null) {
                    int iB = fi.this.b(fi.this.k.OnUploadInfoCallback());
                    Message messageObtainMessage = fi.this.d.obtainMessage();
                    messageObtainMessage.arg1 = 10;
                    messageObtainMessage.obj = fi.this.f2754a;
                    messageObtainMessage.what = iB;
                    fi.this.d.sendMessage(messageObtainMessage);
                }
            } catch (Throwable th) {
                di.a(th, "NearbySearch", "UpdateDataTask");
            }
        }

        public /* synthetic */ a(fi fiVar, byte b) {
            this();
        }
    }

    public fi(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.c = context.getApplicationContext();
        this.d = dt.a();
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f2754a.add(nearbyListener);
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fi.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = fi.this.d.obtainMessage();
                    messageObtainMessage.arg1 = 8;
                    messageObtainMessage.obj = fi.this.f2754a;
                    try {
                        try {
                            fi.this.a();
                            messageObtainMessage.what = 1000;
                            if (fi.this.d == null) {
                                return;
                            }
                        } catch (AMapException e2) {
                            messageObtainMessage.what = e2.getErrorCode();
                            di.a(e2, "NearbySearch", "clearUserInfoAsyn");
                            if (fi.this.d == null) {
                                return;
                            }
                        }
                        fi.this.d.sendMessage(messageObtainMessage);
                    } catch (Throwable th) {
                        if (fi.this.d != null) {
                            fi.this.d.sendMessage(messageObtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.j.cancel();
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "destryoy");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f2754a.remove(nearbyListener);
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            dr.a(this.c);
            if (a(nearbyQuery)) {
                return new dv(this.c, nearbyQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fi.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = fi.this.d.obtainMessage();
                    messageObtainMessage.arg1 = 9;
                    dt.g gVar = new dt.g();
                    gVar.f2706a = fi.this.f2754a;
                    messageObtainMessage.obj = gVar;
                    try {
                        try {
                            gVar.b = fi.this.searchNearbyInfo(nearbyQuery);
                            messageObtainMessage.what = 1000;
                            if (fi.this.d == null) {
                                return;
                            }
                        } catch (AMapException e2) {
                            messageObtainMessage.what = e2.getErrorCode();
                            di.a(e2, "NearbySearch", "searchNearbyInfoAsyn");
                            if (fi.this.d == null) {
                                return;
                            }
                        }
                        fi.this.d.sendMessage(messageObtainMessage);
                    } catch (Throwable th) {
                        if (fi.this.d != null) {
                            fi.this.d.sendMessage(messageObtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        TimerTask timerTask;
        if (i < 7000) {
            i = 7000;
        }
        try {
            this.k = uploadInfoCallback;
            if (this.i && (timerTask = this.l) != null) {
                timerTask.cancel();
            }
            this.i = true;
            a aVar = new a(this, (byte) 0);
            this.l = aVar;
            this.j.schedule(aVar, 0L, i);
        } catch (Throwable th) {
            di.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        TimerTask timerTask;
        try {
            timerTask = this.l;
        } finally {
        }
        if (timerTask != null) {
            timerTask.cancel();
            this.i = false;
            this.l = null;
        } else {
            this.i = false;
            this.l = null;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() { // from class: com.amap.api.col.2sl.fi.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Message messageObtainMessage = fi.this.d.obtainMessage();
                    messageObtainMessage.arg1 = 10;
                    messageObtainMessage.obj = fi.this.f2754a;
                    messageObtainMessage.what = fi.this.a(uploadInfo);
                    fi.this.d.sendMessage(messageObtainMessage);
                } catch (Throwable th) {
                    di.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (!this.i) {
                if (a(this.b)) {
                    dr.a(this.c);
                    return new du(this.c, this.b).b().intValue();
                }
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
        } catch (AMapException e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(UploadInfo uploadInfo) {
        try {
            dr.a(this.c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (!a(userID)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            if (TextUtils.isEmpty(this.h)) {
                this.h = userID;
            }
            if (!userID.equals(this.h)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point != null && !point.equals(this.g)) {
                new dw(this.c, uploadInfo).b();
                this.g = point.copy();
                return 1000;
            }
            return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable unused) {
            return AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        return this.i ? AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR : b(uploadInfo);
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    private static boolean a(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }
}
