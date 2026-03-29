package com.ss.android.socialbase.downloader.nr;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.bq;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.iz.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.nr.fx;
import com.ss.android.socialbase.downloader.nr.nr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz implements ServiceConnection, bq {
    private static long b;
    private static int fx;
    private static boolean nr;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Future<?> f10625a;

    @Nullable
    private fx u;
    private fx.u.InterfaceC0874u x;
    private Handler pn = new Handler(Looper.getMainLooper());
    private nr iz = null;
    private Runnable n = new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.iz.1
        @Override // java.lang.Runnable
        public void run() {
            if (iz.nr || iz.this.x == null) {
                return;
            }
            iz.this.x.u();
        }
    };
    private CountDownLatch jk = new CountDownLatch(1);

    public iz() {
        SqlDownloadCacheService.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo a(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.a(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo jk(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.jk(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public Map<Long, a> l(int i) {
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        nr = true;
        this.pn.removeCallbacks(this.n);
        try {
            this.u = fx.u.u(iBinder);
        } catch (Throwable unused) {
        }
        this.f10625a = com.ss.android.socialbase.downloader.downloader.fx.l().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.iz.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (iz.this.iz != null && iz.this.u != null) {
                                iz.this.u.u(iz.this.iz);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.nr.iz.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = iz.nr = false;
                                    if (iz.this.x() || iz.this.x == null) {
                                        return;
                                    }
                                    iz.this.pn.postDelayed(iz.this.n, 2000L);
                                }
                            };
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable th) {
                        try {
                            com.ss.android.socialbase.downloader.fx.u.nr("SqlDownloadCacheAidlWra", "onServiceConnected fail", th);
                            if (iz.this.x != null) {
                                iz.this.x.u();
                            }
                            iz.this.jk.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.nr.iz.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused22 = iz.nr = false;
                                    if (iz.this.x() || iz.this.x == null) {
                                        return;
                                    }
                                    iz.this.pn.postDelayed(iz.this.n, 2000L);
                                }
                            };
                        } finally {
                            iz.this.jk.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.nr.iz.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused22 = iz.nr = false;
                                        if (iz.this.x() || iz.this.x == null) {
                                            return;
                                        }
                                        iz.this.pn.postDelayed(iz.this.n, 2000L);
                                    }
                                }, 0);
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                    iBinder2.linkToDeath(deathRecipient, 0);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.u = null;
        nr = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList<a> s(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (Build.VERSION.SDK_INT >= 26 || nr) {
            return false;
        }
        if (fx > 5) {
            com.ss.android.socialbase.downloader.fx.u.b("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - b < C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) {
            com.ss.android.socialbase.downloader.fx.u.b("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        fx++;
        b = jCurrentTimeMillis;
        this.pn.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.iz.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), iz.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> b(String str) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.b(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> fx(String str) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.fx(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo n(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.n(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo nr(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.nr(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean pn(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.pn(i);
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean u(int i, Map<Long, a> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean iz(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.iz(i);
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void b(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.b(i);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<com.ss.android.socialbase.downloader.model.nr> fx(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.fx(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> nr(String str) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.nr(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean pn() {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.pn();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public void u(fx.u.InterfaceC0874u interfaceC0874u) {
        this.x = interfaceC0874u;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo b(int i, long j) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.b(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void fx() {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.fx();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> nr() {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.nr();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bq
    public void u(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArray2, final b bVar) {
        com.ss.android.socialbase.downloader.downloader.fx.l().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.iz.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                b bVar2;
                Future future;
                iz.this.u(new nr.u() { // from class: com.ss.android.socialbase.downloader.nr.iz.4.1
                    @Override // com.ss.android.socialbase.downloader.nr.nr
                    public void u(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.jk.iz.u(sparseArray, map);
                        com.ss.android.socialbase.downloader.jk.iz.u(sparseArray2, map2);
                        bVar.u();
                        iz.this.u((nr) null);
                    }
                });
                try {
                    z = !iz.this.jk.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable unused) {
                    z = false;
                }
                if (z && (future = iz.this.f10625a) != null) {
                    future.cancel(true);
                }
                iz.this.u();
                if (!z || (bVar2 = bVar) == null) {
                    return;
                }
                bVar2.u();
            }
        });
    }

    public void u(nr nrVar) {
        synchronized (this) {
            fx fxVar = this.u;
            if (fxVar != null) {
                try {
                    fxVar.u(nrVar);
                } catch (RemoteException unused) {
                }
            } else {
                this.iz = nrVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean b() {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.b();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo fx(int i, long j) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.fx(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(com.ss.android.socialbase.downloader.model.nr nrVar) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.nr(nrVar);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo nr(int i, long j) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.nr(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(DownloadInfo downloadInfo) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.nr(downloadInfo);
            }
        } catch (RemoteException unused) {
        }
    }

    public void u() {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.u();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo x(int i) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.x(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.nr(i, list);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> u(String str) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.u(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.u(nrVar);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, long j) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.u(i, i2, j);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, int i3, long j) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.u(i, i2, i3, j);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, int i3, int i4) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.u(i, i2, i3, i4);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, int i2) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.u(i, i2);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void mv(int i) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean u(DownloadInfo downloadInfo) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.u(downloadInfo);
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, long j, String str, String str2) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.u(i, j, str, str2);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, long j) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                return fxVar.u(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        try {
            fx fxVar = this.u;
            if (fxVar != null) {
                fxVar.u(i, list);
            }
        } catch (RemoteException unused) {
        }
    }
}
