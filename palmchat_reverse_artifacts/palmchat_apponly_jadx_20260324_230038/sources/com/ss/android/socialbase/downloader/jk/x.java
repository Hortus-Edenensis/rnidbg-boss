package com.ss.android.socialbase.downloader.jk;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.a;
import com.ss.android.socialbase.downloader.depend.bg;
import com.ss.android.socialbase.downloader.depend.bq;
import com.ss.android.socialbase.downloader.depend.c;
import com.ss.android.socialbase.downloader.depend.dw;
import com.ss.android.socialbase.downloader.depend.iz;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.jk;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.kj;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.mv;
import com.ss.android.socialbase.downloader.depend.my;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.pn;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.qq;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.sx;
import com.ss.android.socialbase.downloader.depend.wq;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.xg;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.u;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    private static Handler u = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.u u(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new u.AbstractBinderC0879u() { // from class: com.ss.android.socialbase.downloader.jk.x.1
            @Override // com.ss.android.socialbase.downloader.model.u
            public my a() throws RemoteException {
                return x.u(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public rh b() throws RemoteException {
                return x.u(downloadTask.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public kj fx() throws RemoteException {
                return x.u(downloadTask.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.iz iz() throws RemoteException {
                return x.u(downloadTask.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.jk jk() throws RemoteException {
                return x.u(downloadTask.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public int l() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public wq n() throws RemoteException {
                return x.u(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.pn nr() throws RemoteException {
                return x.u(downloadTask.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.n pn() throws RemoteException {
                return x.u(downloadTask.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.x t() throws RemoteException {
                return x.u(downloadTask.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public DownloadInfo u() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public dw x() throws RemoteException {
                return x.u(downloadTask.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public l fx(int i) throws RemoteException {
                return x.u(downloadTask.getDownloadCompleteHandlerByIndex(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.a nr(int i) throws RemoteException {
                return x.u(downloadTask.getSingleDownloadListener(iz.pn(i)), i != com.ss.android.socialbase.downloader.constants.iz.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public int u(int i) throws RemoteException {
                return downloadTask.getDownloadListenerSize(iz.pn(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.u
            public com.ss.android.socialbase.downloader.depend.a u(int i, int i2) throws RemoteException {
                return x.u(downloadTask.getDownloadListenerByIndex(iz.pn(i), i2), i != com.ss.android.socialbase.downloader.constants.iz.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.a u(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new a.u() { // from class: com.ss.android.socialbase.downloader.jk.x.12
            @Override // com.ss.android.socialbase.downloader.depend.a
            public void a(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof bg) {
                    if (z) {
                        x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((bg) iDownloadListener).u(downloadInfo);
                            }
                        });
                    } else {
                        ((bg) iDownloadListener2).u(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void b(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void fx(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void iz(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void n(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void nr(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void pn(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public int u() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void x(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void u(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void fx(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void nr(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.a
            public void u(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    x.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.jk.x.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static kj u(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new kj.u() { // from class: com.ss.android.socialbase.downloader.jk.x.23
            @Override // com.ss.android.socialbase.downloader.depend.kj
            public void u(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                zVar.u(i, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.kj
            public boolean u(boolean z) throws RemoteException {
                return zVar.u(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.kj
            public String u() throws RemoteException {
                return zVar.u();
            }
        };
    }

    public static rh u(final ja jaVar) {
        if (jaVar == null) {
            return null;
        }
        return new rh.u() { // from class: com.ss.android.socialbase.downloader.jk.x.26
            @Override // com.ss.android.socialbase.downloader.depend.rh
            public boolean fx(DownloadInfo downloadInfo) throws RemoteException {
                return jaVar.fx(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.rh
            public boolean nr(DownloadInfo downloadInfo) throws RemoteException {
                return jaVar.nr(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.rh
            public boolean u(DownloadInfo downloadInfo) throws RemoteException {
                return jaVar.u(downloadInfo);
            }
        };
    }

    public static wq u(final com.ss.android.socialbase.downloader.downloader.bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        return new wq.u() { // from class: com.ss.android.socialbase.downloader.jk.x.27
            @Override // com.ss.android.socialbase.downloader.depend.wq
            public long u(int i, int i2) throws RemoteException {
                return bgVar.u(i, i2);
            }
        };
    }

    public static dw u(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new dw.u() { // from class: com.ss.android.socialbase.downloader.jk.x.28
            @Override // com.ss.android.socialbase.downloader.depend.dw
            public boolean u(bq bqVar) throws RemoteException {
                return qVar.u(x.u(bqVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.x u(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new x.u() { // from class: com.ss.android.socialbase.downloader.jk.x.29
            @Override // com.ss.android.socialbase.downloader.depend.x
            public Uri u(String str, String str2) throws RemoteException {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static c u(final bq bqVar) {
        if (bqVar == null) {
            return null;
        }
        return new c() { // from class: com.ss.android.socialbase.downloader.jk.x.30
            @Override // com.ss.android.socialbase.downloader.depend.c
            public void u(List<String> list) {
                try {
                    bqVar.u(list);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.c
            public boolean u() {
                try {
                    return bqVar.u();
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static my u(final sx sxVar) {
        if (sxVar == null) {
            return null;
        }
        return new my.u() { // from class: com.ss.android.socialbase.downloader.jk.x.31
            @Override // com.ss.android.socialbase.downloader.depend.my
            public boolean u(long j, long j2, k kVar) throws RemoteException {
                return sxVar.u(j, j2, x.u(kVar));
            }
        };
    }

    public static o u(final k kVar) {
        if (kVar == null) {
            return null;
        }
        return new o() { // from class: com.ss.android.socialbase.downloader.jk.x.2
            @Override // com.ss.android.socialbase.downloader.depend.o
            public void u() {
                try {
                    kVar.u();
                } catch (RemoteException unused) {
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.iz u(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new iz.u() { // from class: com.ss.android.socialbase.downloader.jk.x.3
            @Override // com.ss.android.socialbase.downloader.depend.iz
            public void u(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                sVar.u(downloadInfo, baseException, i);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.jk u(final qq qqVar) {
        if (qqVar == null) {
            return null;
        }
        return new jk.u() { // from class: com.ss.android.socialbase.downloader.jk.x.4
            @Override // com.ss.android.socialbase.downloader.depend.jk
            public int[] nr() throws RemoteException {
                qq qqVar2 = qqVar;
                if (qqVar2 instanceof com.ss.android.socialbase.downloader.depend.fx) {
                    return ((com.ss.android.socialbase.downloader.depend.fx) qqVar2).u();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.jk
            public void u(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    qqVar.u(new JSONObject(str));
                } catch (JSONException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.jk
            public String u() throws RemoteException {
                return qqVar.nr();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.pn u(final com.ss.android.socialbase.downloader.downloader.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new pn.u() { // from class: com.ss.android.socialbase.downloader.jk.x.5
            @Override // com.ss.android.socialbase.downloader.depend.pn
            public int u(long j) throws RemoteException {
                return nVar.u(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.n u(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new n.u() { // from class: com.ss.android.socialbase.downloader.jk.x.6
            @Override // com.ss.android.socialbase.downloader.depend.n
            public boolean u() throws RemoteException {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask u(com.ss.android.socialbase.downloader.model.u uVar) {
        if (uVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(uVar.u());
            downloadTask.chunkStategy(u(uVar.nr())).notificationEventListener(u(uVar.fx())).interceptor(u(uVar.pn())).depend(u(uVar.iz())).monitorDepend(u(uVar.jk())).forbiddenHandler(u(uVar.x())).diskSpaceHandler(u(uVar.a())).fileUriProvider(u(uVar.t())).notificationClickCallback(u(uVar.b())).retryDelayTimeCalculator(u(uVar.n()));
            com.ss.android.socialbase.downloader.constants.iz izVar = com.ss.android.socialbase.downloader.constants.iz.MAIN;
            com.ss.android.socialbase.downloader.depend.a aVarNr = uVar.nr(izVar.ordinal());
            if (aVarNr != null) {
                downloadTask.mainThreadListenerWithHashCode(aVarNr.hashCode(), u(aVarNr));
            }
            com.ss.android.socialbase.downloader.constants.iz izVar2 = com.ss.android.socialbase.downloader.constants.iz.SUB;
            com.ss.android.socialbase.downloader.depend.a aVarNr2 = uVar.nr(izVar2.ordinal());
            if (aVarNr2 != null) {
                downloadTask.subThreadListenerWithHashCode(aVarNr2.hashCode(), u(aVarNr2));
            }
            com.ss.android.socialbase.downloader.constants.iz izVar3 = com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.a aVarNr3 = uVar.nr(izVar3.ordinal());
            if (aVarNr3 != null) {
                downloadTask.notificationListenerWithHashCode(aVarNr3.hashCode(), u(aVarNr3));
            }
            u(downloadTask, uVar, izVar);
            u(downloadTask, uVar, izVar2);
            u(downloadTask, uVar, izVar3);
            u(downloadTask, uVar);
            return downloadTask;
        } catch (RemoteException unused) {
            return null;
        }
    }

    private static void u(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.u uVar, com.ss.android.socialbase.downloader.constants.iz izVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < uVar.u(izVar.ordinal()); i++) {
            com.ss.android.socialbase.downloader.depend.a aVarU = uVar.u(izVar.ordinal(), i);
            if (aVarU != null) {
                sparseArray.put(aVarU.u(), u(aVarU));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, izVar);
    }

    private static void u(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.u uVar) throws RemoteException {
        for (int i = 0; i < uVar.l(); i++) {
            l lVarFx = uVar.fx(i);
            if (lVarFx != null) {
                downloadTask.addDownloadCompleteHandler(u(lVarFx));
            }
        }
    }

    public static z u(final kj kjVar) {
        if (kjVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.downloader.jk.x.7
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void u(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    kjVar.u(i, downloadInfo, str, str2);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean u(boolean z) {
                try {
                    return kjVar.u(z);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String u() {
                try {
                    return kjVar.u();
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public static mv u(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new mv() { // from class: com.ss.android.socialbase.downloader.jk.x.8
            @Override // com.ss.android.socialbase.downloader.depend.mv
            public boolean nr(DownloadInfo downloadInfo) {
                try {
                    return lVar.nr(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.mv
            public void u(DownloadInfo downloadInfo) throws BaseException {
                try {
                    lVar.u(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }
        };
    }

    public static l u(final mv mvVar) {
        if (mvVar == null) {
            return null;
        }
        return new l.u() { // from class: com.ss.android.socialbase.downloader.jk.x.9
            @Override // com.ss.android.socialbase.downloader.depend.l
            public boolean nr(DownloadInfo downloadInfo) throws RemoteException {
                return mvVar.nr(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.l
            public void u(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    mvVar.u(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        };
    }

    public static ja u(final rh rhVar) {
        if (rhVar == null) {
            return null;
        }
        return new ja() { // from class: com.ss.android.socialbase.downloader.jk.x.10
            @Override // com.ss.android.socialbase.downloader.depend.ja
            public boolean fx(DownloadInfo downloadInfo) {
                try {
                    return rhVar.fx(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ja
            public boolean nr(DownloadInfo downloadInfo) {
                try {
                    return rhVar.nr(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ja
            public boolean u(DownloadInfo downloadInfo) {
                try {
                    return rhVar.u(downloadInfo);
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.n u(final com.ss.android.socialbase.downloader.depend.pn pnVar) {
        if (pnVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.n() { // from class: com.ss.android.socialbase.downloader.jk.x.11
            @Override // com.ss.android.socialbase.downloader.downloader.n
            public int u(long j) {
                try {
                    return pnVar.u(j);
                } catch (RemoteException unused) {
                    return 0;
                }
            }
        };
    }

    public static s u(final com.ss.android.socialbase.downloader.depend.iz izVar) {
        if (izVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.jk.x.13
            @Override // com.ss.android.socialbase.downloader.depend.s
            public void u(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    izVar.u(downloadInfo, baseException, i);
                } catch (RemoteException unused) {
                }
            }
        };
    }

    public static qq u(final com.ss.android.socialbase.downloader.depend.jk jkVar) {
        if (jkVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.fx() { // from class: com.ss.android.socialbase.downloader.jk.x.14
            @Override // com.ss.android.socialbase.downloader.depend.qq
            public String nr() {
                try {
                    return jkVar.u();
                } catch (RemoteException unused) {
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.qq
            public void u(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    jkVar.u(jSONObject.toString());
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.fx
            public int[] u() {
                try {
                    return jkVar.nr();
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public static q u(final dw dwVar) {
        if (dwVar == null) {
            return null;
        }
        return new q() { // from class: com.ss.android.socialbase.downloader.jk.x.15
            @Override // com.ss.android.socialbase.downloader.depend.q
            public boolean u(c cVar) {
                try {
                    return dwVar.u(x.u(cVar));
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static bq u(final c cVar) {
        if (cVar == null) {
            return null;
        }
        return new bq.u() { // from class: com.ss.android.socialbase.downloader.jk.x.16
            @Override // com.ss.android.socialbase.downloader.depend.bq
            public void u(List<String> list) {
                cVar.u(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.bq
            public boolean u() {
                return cVar.u();
            }
        };
    }

    public static xg u(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new xg.u() { // from class: com.ss.android.socialbase.downloader.jk.x.17
            @Override // com.ss.android.socialbase.downloader.depend.xg
            public void u(int i, int i2) {
                mVar.u(i, i2);
            }
        };
    }

    public static m u(final xg xgVar) {
        if (xgVar == null) {
            return null;
        }
        return new m() { // from class: com.ss.android.socialbase.downloader.jk.x.18
            @Override // com.ss.android.socialbase.downloader.depend.m
            public void u(int i, int i2) {
                try {
                    xgVar.u(i, i2);
                } catch (RemoteException unused) {
                }
            }
        };
    }

    public static sx u(final my myVar) {
        if (myVar == null) {
            return null;
        }
        return new sx() { // from class: com.ss.android.socialbase.downloader.jk.x.19
            @Override // com.ss.android.socialbase.downloader.depend.sx
            public boolean u(long j, long j2, o oVar) {
                try {
                    return myVar.u(j, j2, x.u(oVar));
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static k u(final o oVar) {
        if (oVar == null) {
            return null;
        }
        return new k.u() { // from class: com.ss.android.socialbase.downloader.jk.x.20
            @Override // com.ss.android.socialbase.downloader.depend.k
            public void u() throws RemoteException {
                oVar.u();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.bg u(final wq wqVar) {
        if (wqVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.bg() { // from class: com.ss.android.socialbase.downloader.jk.x.21
            @Override // com.ss.android.socialbase.downloader.downloader.bg
            public long u(int i, int i2) {
                try {
                    return wqVar.u(i, i2);
                } catch (RemoteException unused) {
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor u(final com.ss.android.socialbase.downloader.depend.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.jk.x.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return nVar.u();
                } catch (RemoteException unused) {
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider u(final com.ss.android.socialbase.downloader.depend.x xVar) {
        if (xVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.jk.x.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return xVar.u(str, str2);
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public static IDownloadListener u(final com.ss.android.socialbase.downloader.depend.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new bg() { // from class: com.ss.android.socialbase.downloader.jk.x.25
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    aVar.iz(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    aVar.u(downloadInfo, baseException);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    aVar.x(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    aVar.n(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    aVar.b(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    aVar.u(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    aVar.fx(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    aVar.nr(downloadInfo, baseException);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    aVar.fx(downloadInfo, baseException);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    aVar.nr(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    aVar.pn(downloadInfo);
                } catch (RemoteException unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.bg
            public void u(DownloadInfo downloadInfo) {
                try {
                    aVar.a(downloadInfo);
                } catch (RemoteException unused) {
                }
            }
        };
    }
}
