package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s extends com.ss.android.socialbase.downloader.downloader.u implements ServiceConnection {
    private static final String pn = "s";
    private com.ss.android.socialbase.downloader.downloader.a iz;
    private int n = -1;
    private com.ss.android.socialbase.downloader.downloader.s x;

    private void x() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.u) {
                sparseArrayClone = this.u.clone();
                this.u.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.fx.rh() == null) {
                return;
            }
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.iz.u(com.ss.android.socialbase.downloader.jk.x.u(it.next()));
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.fx.u.nr(pn, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void fx(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.u().u(downloadTask.getDownloadId(), true);
        u uVarRh = com.ss.android.socialbase.downloader.downloader.fx.rh();
        if (uVarRh != null) {
            uVarRh.u(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void nr(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = pn;
        StringBuilder sb = new StringBuilder("tryDownload aidlService == null:");
        sb.append(this.iz == null);
        com.ss.android.socialbase.downloader.fx.u.nr(str, sb.toString());
        if (this.iz == null) {
            u(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.fx.oa(), this);
        } else {
            x();
            try {
                this.iz.u(com.ss.android.socialbase.downloader.jk.x.u(downloadTask));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.iz = null;
        com.ss.android.socialbase.downloader.downloader.s sVar = this.x;
        if (sVar != null) {
            sVar.n();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = pn;
        com.ss.android.socialbase.downloader.fx.u.nr(str, "onServiceConnected ");
        this.iz = a.u.u(iBinder);
        com.ss.android.socialbase.downloader.downloader.s sVar = this.x;
        if (sVar != null) {
            sVar.u(iBinder);
        }
        StringBuilder sb = new StringBuilder("onServiceConnected aidlService!=null");
        sb.append(this.iz != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.u.size());
        com.ss.android.socialbase.downloader.fx.u.nr(str, sb.toString());
        if (this.iz != null) {
            com.ss.android.socialbase.downloader.downloader.b.u().nr();
            this.nr = true;
            this.b = false;
            int i = this.n;
            if (i != -1) {
                try {
                    this.iz.l(i);
                } catch (RemoteException unused) {
                }
            }
            if (this.iz != null) {
                x();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.fx.u.nr(pn, "onServiceDisconnected ");
        this.iz = null;
        this.nr = false;
        com.ss.android.socialbase.downloader.downloader.s sVar = this.x;
        if (sVar != null) {
            sVar.n();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.fx.u.nr(pn, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.jk.iz.u()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.n.u.fx().u("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.fx.u.nr(pn, "stopService");
        this.nr = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public IBinder u(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.ss.android.socialbase.downloader.n.u.u("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.fx.u.nr(pn, "onBind IndependentDownloadBinder");
        return new mv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void u(com.ss.android.socialbase.downloader.downloader.s sVar) {
        this.x = sVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void u(int i) {
        com.ss.android.socialbase.downloader.downloader.a aVar = this.iz;
        if (aVar == null) {
            this.n = i;
        } else {
            try {
                aVar.l(i);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void startService() {
        if (this.iz == null) {
            startService(com.ss.android.socialbase.downloader.downloader.fx.oa(), this);
        }
    }
}
