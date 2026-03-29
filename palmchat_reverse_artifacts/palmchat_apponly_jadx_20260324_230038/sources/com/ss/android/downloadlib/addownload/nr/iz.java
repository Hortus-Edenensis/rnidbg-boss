package com.ss.android.downloadlib.addownload.nr;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private final ConcurrentHashMap<Long, DownloadController> b;
    private final ConcurrentHashMap<Long, DownloadEventConfig> fx;
    private final ConcurrentHashMap<Long, DownloadModel> nr;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.u.nr> pn;
    private volatile boolean u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static iz u = new iz();
    }

    public com.ss.android.downloadad.api.u.nr b(long j) {
        return this.pn.get(Long.valueOf(j));
    }

    public DownloadController fx(long j) {
        return this.b.get(Long.valueOf(j));
    }

    public void iz(long j) {
        this.nr.remove(Long.valueOf(j));
        this.fx.remove(Long.valueOf(j));
        this.b.remove(Long.valueOf(j));
    }

    @NonNull
    public pn pn(long j) {
        pn pnVar = new pn();
        pnVar.u = j;
        pnVar.nr = u(j);
        DownloadEventConfig downloadEventConfigNr = nr(j);
        pnVar.fx = downloadEventConfigNr;
        if (downloadEventConfigNr == null) {
            pnVar.fx = new com.ss.android.download.api.download.fx();
        }
        DownloadController downloadControllerFx = fx(j);
        pnVar.b = downloadControllerFx;
        if (downloadControllerFx == null) {
            pnVar.b = new com.ss.android.download.api.download.nr();
        }
        return pnVar;
    }

    private iz() {
        this.u = false;
        this.nr = new ConcurrentHashMap<>();
        this.fx = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.pn = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.u.nr> fx() {
        return this.pn;
    }

    public void nr() {
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.addownload.nr.iz.1
            @Override // java.lang.Runnable
            public void run() {
                if (iz.this.u) {
                    return;
                }
                synchronized (iz.class) {
                    if (!iz.this.u) {
                        iz.this.pn.putAll(a.u().nr());
                        iz.this.u = true;
                    }
                }
            }
        }, true);
    }

    public static iz u() {
        return u.u;
    }

    public DownloadEventConfig nr(long j) {
        return this.fx.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.u.nr nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.u.nr nrVar : this.pn.values()) {
            if (nrVar != null && str.equals(nrVar.u())) {
                return nrVar;
            }
        }
        return null;
    }

    public void u(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.nr.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void nr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.nr.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void u(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.fx.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void u(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.b.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void u(com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        this.pn.put(Long.valueOf(nrVar.nr()), nrVar);
        a.u().u(nrVar);
    }

    public DownloadModel u(long j) {
        return this.nr.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.u.nr u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.u.nr nrVar : this.pn.values()) {
            if (nrVar != null && str.equals(nrVar.pn())) {
                return nrVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.u.nr u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.u.nr nrVar : this.pn.values()) {
            if (nrVar != null && nrVar.bg() == downloadInfo.getId()) {
                return nrVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jU = mv.u(new JSONObject(downloadInfo.getExtra()), BaseConstants.EVENT_LABEL_EXTRA);
                if (jU != 0) {
                    for (com.ss.android.downloadad.api.u.nr nrVar2 : this.pn.values()) {
                        if (nrVar2 != null && nrVar2.nr() == jU) {
                            return nrVar2;
                        }
                    }
                    com.ss.android.downloadlib.pn.fx.u().u("getNativeModelByInfo");
                }
            } catch (Exception unused) {
            }
        }
        for (com.ss.android.downloadad.api.u.nr nrVar3 : this.pn.values()) {
            if (nrVar3 != null && TextUtils.equals(nrVar3.u(), downloadInfo.getUrl())) {
                return nrVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.u.nr u(int i) {
        for (com.ss.android.downloadad.api.u.nr nrVar : this.pn.values()) {
            if (nrVar != null && nrVar.bg() == i) {
                return nrVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.u.nr> u(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.u.nr nrVar : this.pn.values()) {
                if (nrVar != null && TextUtils.equals(nrVar.u(), str)) {
                    nrVar.nr(str2);
                    map.put(Long.valueOf(nrVar.nr()), nrVar);
                }
            }
        }
        return map;
    }

    public synchronized void u(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.pn.remove(Long.valueOf(jLongValue));
        }
        a.u().u((List<String>) arrayList);
    }
}
