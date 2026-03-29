package com.ss.android.socialbase.downloader.iz;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.a.pn;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.fx;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t implements iz, fx.u {
    private final com.ss.android.socialbase.downloader.a.iz b;
    private final com.ss.android.socialbase.downloader.jk.pn bq;
    private final boolean d;
    private final com.ss.android.socialbase.downloader.a.pn dw;
    private final nr fx;
    private int gi;
    private com.ss.android.socialbase.downloader.model.b jk;
    private long kj;
    private long mv;
    private int my;
    private final s nr;
    private BaseException o;
    private final x pn;
    private long q;
    private long qq;
    private volatile boolean sx;
    private com.ss.android.socialbase.downloader.model.b t;
    private final DownloadInfo u;
    private float z;
    private volatile boolean iz = false;
    private volatile boolean x = false;
    private final List<mv> n = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o> f10615a = new ArrayList();
    private volatile boolean l = true;
    private final LinkedList<a> s = new LinkedList<>();
    private final List<a> k = new ArrayList();
    private final Object bg = new Object();
    private volatile boolean c = false;
    private final pn.nr h = new pn.nr() { // from class: com.ss.android.socialbase.downloader.iz.t.1
        private int nr;

        @Override // com.ss.android.socialbase.downloader.a.pn.nr
        public long u() {
            if (t.this.iz || t.this.x) {
                return -1L;
            }
            synchronized (t.this) {
                if (t.this.jk == null && t.this.t == null) {
                    long j = t.this.q;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.nr++;
                    mv mvVarU = t.this.u(false, System.currentTimeMillis(), j);
                    if (mvVarU == null) {
                        return j;
                    }
                    t.this.fx(mvVarU);
                    mvVarU.iz();
                    return ((long) ((this.nr / t.this.f10615a.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    private final pn.nr rh = new pn.nr() { // from class: com.ss.android.socialbase.downloader.iz.t.2
        @Override // com.ss.android.socialbase.downloader.a.pn.nr
        public long u() {
            return t.this.sx();
        }
    };

    public t(@NonNull DownloadInfo downloadInfo, @NonNull s sVar, com.ss.android.socialbase.downloader.a.iz izVar) {
        this.u = downloadInfo;
        this.nr = sVar;
        nr nrVar = new nr(sVar.b(), sVar.pn());
        this.fx = nrVar;
        this.b = izVar;
        this.pn = new x(downloadInfo, izVar, nrVar);
        this.dw = new com.ss.android.socialbase.downloader.a.pn();
        this.bq = new com.ss.android.socialbase.downloader.jk.pn();
        this.d = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).nr("debug") == 1;
    }

    private void a() {
        List<String> backUpUrls;
        int iL = this.nr.l();
        if (iL <= 0) {
            this.l = false;
            pn();
            return;
        }
        com.ss.android.socialbase.downloader.network.fx fxVarU = com.ss.android.socialbase.downloader.network.fx.u();
        fxVarU.u(this.u.getUrl(), this, 2000L);
        if (iL <= 2 || (backUpUrls = this.u.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                fxVarU.u(str, this, 2000L);
            }
        }
    }

    private o jk() {
        o oVar;
        synchronized (this) {
            int size = this.my % this.f10615a.size();
            if (this.nr.nr()) {
                this.my++;
            }
            oVar = this.f10615a.get(size);
        }
        return oVar;
    }

    private long k() {
        Iterator<mv> it = this.n.iterator();
        long jNr = 0;
        while (it.hasNext()) {
            jNr += it.next().nr();
        }
        return jNr;
    }

    private boolean l() {
        Iterator<mv> it = this.n.iterator();
        while (it.hasNext()) {
            if (!it.next().x()) {
                return false;
            }
        }
        return true;
    }

    private void mv() {
        int size;
        if (this.mv > 0 && (size = this.k.size()) > 1) {
            ArrayList<a> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                a aVar = this.k.get(i);
                a aVar2 = this.k.get(i2);
                if (aVar.pn() > aVar2.fx() && aVar2.u() <= 0 && aVar2.u == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(aVar2);
                } else if (aVar2.pn() > aVar.pn()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (a aVar3 : arrayList) {
                    this.k.remove(aVar3);
                    for (mv mvVar : this.n) {
                        if (mvVar.u == aVar3) {
                            mvVar.u(true);
                        }
                    }
                }
            }
        }
    }

    private a my() {
        int i = 0;
        while (true) {
            a aVarO = o();
            if (aVarO == null) {
                return null;
            }
            mv mvVar = aVarO.u;
            if (mvVar == null) {
                return aVarO;
            }
            if (aVarO.jk() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            nr(jCurrentTimeMillis);
            if (jCurrentTimeMillis - mvVar.iz > 2000 && u(mvVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                return aVarO;
            }
            int i2 = i + 1;
            if (i > 2) {
                return aVarO;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private void n() {
        if (this.qq > 0) {
            this.kj = System.currentTimeMillis();
            this.dw.u(this.rh, 0L);
        }
    }

    private a o() {
        int iJk;
        a aVar = null;
        int i = Integer.MAX_VALUE;
        for (a aVar2 : this.k) {
            if (u(aVar2) > 0 && (iJk = aVar2.jk()) < i) {
                aVar = aVar2;
                i = iJk;
            }
        }
        return aVar;
    }

    private boolean s() {
        long j = this.mv;
        if (j <= 0) {
            this.sx = false;
            return false;
        }
        synchronized (this) {
            long jU = k.u(this.k);
            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jU)));
            if (jU >= j) {
                this.sx = true;
                return true;
            }
            this.sx = false;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long sx() {
        if (this.iz || this.x) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            nr(jCurrentTimeMillis);
            long jT = this.nr.t();
            if (jT > 0) {
                long j = this.kj;
                if (j > 0 && jCurrentTimeMillis - j > jT && u(jCurrentTimeMillis, jT)) {
                    this.kj = jCurrentTimeMillis;
                    this.gi++;
                }
            }
        }
        return 2000L;
    }

    private void t() {
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "onComplete");
        this.fx.fx();
        synchronized (this.bg) {
            this.bg.notify();
        }
    }

    private void b() throws BaseException {
        try {
            this.pn.u((b) this.fx);
        } catch (my unused) {
        } catch (BaseException e) {
            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            u(e);
            throw e;
        }
        if (this.x || this.iz) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.s.isEmpty()) {
                    a aVarPoll = this.s.poll();
                    if (aVarPoll != null) {
                        u(this.k, aVarPoll, true);
                    }
                }
                fx(this.k);
            }
        } catch (Throwable unused2) {
        }
        if (!this.c || this.o == null) {
            if (this.u.getCurBytes() != this.u.getTotalBytes()) {
                com.ss.android.socialbase.downloader.b.u.u(this.u, this.k);
            }
            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "dispatchSegments::download finished");
        } else {
            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.o);
            throw this.o;
        }
    }

    private void fx() throws InterruptedException, BaseException {
        BaseException baseException;
        synchronized (this.bg) {
            if (this.jk == null && this.t == null) {
                this.bg.wait();
            }
        }
        if (this.jk == null && this.t == null && (baseException = this.o) != null) {
            throw baseException;
        }
    }

    private void iz() {
        this.f10615a.add(new o(this.u.getUrl(), true));
        List<String> backUpUrls = this.u.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f10615a.add(new o(str, false));
                }
            }
        }
        this.nr.u(this.f10615a.size());
    }

    private void nr(List<a> list) {
        long totalBytes = this.u.getTotalBytes();
        this.mv = totalBytes;
        if (totalBytes <= 0) {
            this.mv = this.u.getExpectFileLength();
            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.mv);
        }
        synchronized (this) {
            this.s.clear();
            if (list == null || list.isEmpty()) {
                u((List<a>) this.s, new a(0L, -1L), false);
            } else {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    u((List<a>) this.s, new a(it.next()), false);
                }
                b(this.s);
                fx(this.s);
            }
            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "initSegments: totalLength = " + this.mv);
        }
    }

    private void pn() {
        int iU;
        if (this.mv <= 0 || this.l) {
            iU = 1;
        } else {
            iU = this.nr.u();
            int iN = (int) (this.mv / this.nr.n());
            if (iU > iN) {
                iU = iN;
            }
        }
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.mv + ", threadCount = " + iU);
        int i = iU > 0 ? iU : 1;
        synchronized (this) {
            while (this.n.size() < i) {
                if (!this.x && !this.iz) {
                    u(jk());
                    if (this.nr.iz()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void x() {
        s sVar = this.nr;
        this.q = sVar.jk();
        this.qq = sVar.t();
        this.z = sVar.k();
        int i = this.gi;
        if (i > 0) {
            this.dw.u(this.h, i);
        }
    }

    public boolean u(List<a> list) throws InterruptedException, BaseException {
        try {
            iz();
            nr(list);
            pn();
            x();
            a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                fx();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.u.increaseAllConnectTime(jCurrentTimeMillis2);
                this.u.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.x && !this.iz) {
                    this.b.u(this.mv);
                    n();
                    b();
                    return true;
                }
                if (!this.x && !this.iz) {
                    com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "finally pause");
                    nr();
                }
                this.dw.nr();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.u.increaseAllConnectTime(jCurrentTimeMillis3);
                this.u.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.x && !this.iz) {
                com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "finally pause");
                nr();
            }
            this.dw.nr();
        }
    }

    private void fx(List<a> list) {
        long jNr = k.nr(list);
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.u.getCurBytes() + ", totalBytes = " + this.u.getTotalBytes() + ", downloadedBytes = " + jNr);
        if (jNr > this.u.getTotalBytes() && this.u.getTotalBytes() > 0) {
            jNr = this.u.getTotalBytes();
        }
        if (this.u.getCurBytes() == this.u.getTotalBytes() || this.u.getCurBytes() == jNr) {
            return;
        }
        this.u.setCurBytes(jNr);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pn(mv mvVar, a aVar) throws jk {
        a aVar2;
        long j;
        long jIz;
        boolean z;
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: start ".concat(String.valueOf(aVar)));
        if (aVar.u == mvVar) {
            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: " + mvVar + " is already the owner of " + aVar);
            return;
        }
        if (aVar.u != null) {
            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "applySegment: " + aVar + " is already has an owner:" + aVar.u);
            throw new jk(1, "segment already has an owner");
        }
        if (mvVar.n() == aVar.pn()) {
            long jFx = aVar.fx();
            int iU = u(jFx);
            if (iU != -1 && (aVar2 = this.k.get(iU)) != null) {
                if (aVar2 == aVar) {
                    j = jFx;
                } else if (aVar2.fx() == aVar.fx()) {
                    long jU = u(aVar2);
                    if (jU <= 0) {
                        j = jFx;
                        z = false;
                        if (!z) {
                            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "applySegment: " + aVar + " not exist! but has another same segment, segmentInList = " + aVar2);
                            throw new jk(2, "segment not exist, but has another same segment");
                        }
                    } else {
                        mv mvVar2 = aVar2.u;
                        if (mvVar2 != null) {
                            if (jU < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                j = jFx;
                                if (mvVar.iz - mvVar2.iz <= 1000 || aVar2.pn() - aVar.pn() >= jU / 2) {
                                }
                                if (!z) {
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                        } else {
                            j = jFx;
                        }
                        if (mvVar2 != null) {
                            mvVar2.u(true);
                        }
                        aVar.fx(aVar2.iz());
                        aVar.nr(aVar2.jk());
                        this.k.set(iU, aVar);
                        z = true;
                        if (!z) {
                        }
                    }
                }
                long jU2 = aVar.u();
                int i = iU - 1;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    a aVar3 = this.k.get(i);
                    long jIz2 = aVar3.iz();
                    if (jIz2 <= 0 || jIz2 >= j) {
                        if (jU2 <= 0 && aVar3.pn() > j) {
                            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + aVar3 + ", segment = " + aVar);
                            this.k.remove(aVar);
                            throw new jk(3, "prev overstep");
                        }
                        if (aVar3.u == null) {
                            aVar3.fx(j - 1);
                            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: prev set end, prev = ".concat(String.valueOf(aVar3)));
                            if (aVar3.u() > 0) {
                                break;
                            }
                        } else {
                            long j2 = j - 1;
                            if (aVar3.u.u(j2)) {
                                aVar3.fx(j2);
                                com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = ".concat(String.valueOf(aVar3)));
                            } else {
                                com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = ".concat(String.valueOf(aVar3)));
                                throw new jk(4, "prev end adjust fail");
                            }
                        }
                    }
                    i--;
                }
                int size = this.k.size();
                for (int i2 = iU + 1; i2 < size; i2++) {
                    a aVar4 = this.k.get(i2);
                    if (aVar4.u() > 0 || aVar4.u != null) {
                        long jIz3 = aVar.iz();
                        long jFx2 = aVar4.fx();
                        if (jIz3 <= 0 || jIz3 >= jFx2) {
                            long j3 = jFx2 - 1;
                            aVar.fx(j3);
                            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: segment set end:" + j3 + ", later = " + aVar4);
                        }
                        jIz = aVar.iz();
                        if (jIz <= 0 && (j > jIz || aVar.pn() > jIz)) {
                            throw new jk(6, "applySegment: ".concat(String.valueOf(aVar)));
                        }
                        aVar.u = mvVar;
                        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: OK ".concat(String.valueOf(aVar)));
                        return;
                    }
                }
                jIz = aVar.iz();
                if (jIz <= 0) {
                }
                aVar.u = mvVar;
                com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "applySegment: OK ".concat(String.valueOf(aVar)));
                return;
            }
            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "applySegment: " + aVar + " not exist! segmentIndex = " + iU);
            throw new jk(2, "segment not exist");
        }
        throw new jk(5, "applySegment");
    }

    private void nr(String str, List<o> list) {
        int iU;
        if (this.d) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        int iL = this.nr.l();
        if ((iL == 1 || iL == 3) && (iU = u(str)) >= 0 && iU < this.f10615a.size()) {
            this.f10615a.addAll(iU + 1, list);
        } else {
            this.f10615a.addAll(list);
        }
    }

    private List<o> fx(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        o oVar = new o(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(oVar.fx);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(oVar.fx, linkedList);
                        }
                        linkedList.add(oVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((o) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void b(List<a> list) {
        long jFx = list.get(0).fx();
        if (jFx > 0) {
            u(list, new a(0L, jFx - 1), true);
        }
        Iterator<a> it = list.iterator();
        if (it.hasNext()) {
            a next = it.next();
            while (it.hasNext()) {
                a next2 = it.next();
                if (next.iz() < next2.fx() - 1) {
                    com.ss.android.socialbase.downloader.fx.u.b("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.fx() - 1));
                    next.fx(next2.fx() - 1);
                }
                next = next2;
            }
        }
        a aVar = list.get(list.size() - 1);
        long totalBytes = this.u.getTotalBytes();
        if (totalBytes <= 0 || (aVar.iz() != -1 && aVar.iz() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.fx.u.b("SegmentDispatcher", "fixSegment: last segment = " + aVar + ", new end=-1");
            aVar.fx(-1L);
        }
    }

    private a nr(mv mvVar, o oVar) {
        while (!this.s.isEmpty()) {
            a aVarPoll = this.s.poll();
            if (aVarPoll != null) {
                u(this.k, aVarPoll, true);
                if (u(aVarPoll) > 0 || this.mv <= 0) {
                    return aVarPoll;
                }
            }
        }
        mv();
        a aVarFx = fx(mvVar, oVar);
        if (aVarFx != null && u(aVarFx) > 0) {
            u(this.k, aVarFx, true);
            return aVarFx;
        }
        a aVarMy = my();
        if (aVarMy != null) {
            return aVarMy;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void nr(mv mvVar, a aVar) throws BaseException {
        synchronized (this) {
            pn(mvVar, aVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.fx.u
    public void u(String str, List<InetAddress> list) {
        List<o> listFx;
        if (this.x || this.iz) {
            return;
        }
        try {
            listFx = fx(str, list);
        } catch (Throwable unused) {
            listFx = null;
        }
        synchronized (this) {
            if (listFx != null) {
                nr(str, listFx);
                this.l = false;
                this.nr.u(this.f10615a.size());
                pn();
            } else {
                this.l = false;
                this.nr.u(this.f10615a.size());
                pn();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void fx(mv mvVar, a aVar) {
        synchronized (this) {
            if (aVar.u == mvVar) {
                com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(aVar)));
                aVar.b(mvVar.b());
                aVar.u = null;
                mvVar.u();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void nr(mv mvVar) {
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "onReaderExit: threadIndex = " + mvVar.fx);
        synchronized (this) {
            mvVar.fx(true);
            this.n.remove(mvVar);
            mv();
            if (!this.n.isEmpty()) {
                if (s()) {
                    Iterator<mv> it = this.n.iterator();
                    while (it.hasNext()) {
                        it.next().pn();
                    }
                    t();
                }
            } else {
                t();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public pn b(mv mvVar, a aVar) throws BaseException {
        pn pnVarU;
        synchronized (this) {
            l lVar = new l(this.u, this.fx, aVar);
            this.pn.u(lVar);
            pnVarU = lVar.u();
        }
        return pnVarU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fx(mv mvVar) {
        synchronized (this) {
            o oVarB = b(mvVar);
            if (oVarB == null) {
                return false;
            }
            return mvVar.u(oVarB);
        }
    }

    private int u(String str) {
        int size = this.f10615a.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.f10615a.get(i).u, str)) {
                return i;
            }
        }
        return -1;
    }

    private o b(mv mvVar) {
        o next;
        Iterator<o> it = this.f10615a.iterator();
        o oVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != mvVar.nr && !next.b()) {
                if (oVar == null) {
                    oVar = next;
                }
                if (next.u() <= 0) {
                    break;
                }
            }
        }
        if (this.nr.nr()) {
            if (next != null) {
                return next;
            }
            if (this.nr.fx()) {
                return null;
            }
        }
        return oVar;
    }

    private void u(List<a> list, a aVar, boolean z) {
        long jFx = aVar.fx();
        int size = list.size();
        int i = 0;
        while (i < size && jFx >= list.get(i).fx()) {
            i++;
        }
        list.add(i, aVar);
        if (z) {
            aVar.u(size);
        }
    }

    private void nr(mv mvVar, a aVar, o oVar, com.ss.android.socialbase.downloader.model.b bVar) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        mv mvVar2 = aVar.u;
        if (mvVar2 != null && mvVar2 != mvVar) {
            throw new jk(1, "segment already has an owner");
        }
        if (mvVar.n() == aVar.pn()) {
            if (!bVar.nr()) {
                if (aVar.pn() <= 0) {
                    com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + aVar.pn());
                    if (!bVar.u()) {
                        throw new com.ss.android.socialbase.downloader.exception.nr(1004, bVar.fx, "2: response code error : " + bVar.fx + " segment=" + aVar);
                    }
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.nr(1004, bVar.fx, "1: response code error : " + bVar.fx + " segment=" + aVar);
                }
            }
            if (oVar.b) {
                if (this.jk == null) {
                    this.jk = bVar;
                    synchronized (this.bg) {
                        this.bg.notify();
                    }
                    com.ss.android.socialbase.downloader.a.iz izVar = this.b;
                    if (izVar != null) {
                        izVar.u(oVar.u, bVar.nr, aVar.pn());
                    }
                    long jJk = bVar.jk();
                    if (jJk > 0) {
                        for (a aVar2 : this.k) {
                            if (aVar2.iz() <= 0 || aVar2.iz() > jJk - 1) {
                                aVar2.fx(jJk - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            u(bVar);
            if (this.t == null) {
                this.t = bVar;
                if (this.u.getTotalBytes() <= 0) {
                    long jJk2 = bVar.jk();
                    com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jJk2 + ",url=" + oVar.u);
                    this.u.setTotalBytes(jJk2);
                }
                synchronized (this.bg) {
                    this.bg.notify();
                }
                return;
            }
            return;
        }
        throw new jk(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a fx(mv mvVar, o oVar) {
        String str;
        float f;
        float f2;
        int size = this.k.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jU = u(i2, size);
            if (jU > j) {
                i = i2;
                j = jU;
            }
        }
        long jX = this.nr.x();
        long jA = this.nr.a();
        if (i < 0 || j <= jX) {
            return null;
        }
        a aVar = this.k.get(i);
        int iS = this.k.size() < this.n.size() ? 2 : this.nr.s();
        if (iS == 1) {
            mv mvVar2 = aVar.u;
            if (mvVar2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - 4000;
                long jU2 = mvVar2.u(j2, jCurrentTimeMillis);
                long jU3 = mvVar.u(j2, jCurrentTimeMillis);
                float f3 = (jU2 <= 0 || jU3 <= 0) ? -1.0f : jU3 / (jU2 + jU3);
                if (f3 == -1.0f) {
                    long jNr = mvVar2.nr();
                    f = f3;
                    long jNr2 = mvVar.nr();
                    if (jNr > 0 && jNr2 > 0) {
                        f2 = jNr2 / (jNr + jNr2);
                    }
                    if (f2 > 0.0f) {
                        float f4 = f2 * 0.9f;
                        long j3 = (long) (j * f4);
                        if (j3 < jX) {
                            j3 = jX;
                        }
                        if (jA <= 0 || j3 <= jA) {
                            jA = j3;
                        }
                        long j4 = jX / 2;
                        long j5 = j - j4;
                        if (jA > j5) {
                            jA = j5;
                        } else if (jA < j4) {
                            jA = j4;
                        }
                        a aVar2 = new a(aVar.pn() + (j - jA), aVar.iz());
                        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "obtainSegment: parent = " + aVar + ", child = " + aVar2 + ", maxRemainBytes = " + j + ", childLength = " + jA + ", ratio = " + f4 + ", threadIndex = " + mvVar.fx);
                        return aVar2;
                    }
                } else {
                    f = f3;
                }
                f2 = f;
                if (f2 > 0.0f) {
                }
            }
            str = "SegmentDispatcher";
        } else {
            if (iS == 2) {
                long curBytes = this.mv - this.u.getCurBytes();
                float fB = b(mvVar, oVar);
                long j6 = (long) (curBytes * fB);
                if (j6 < jX) {
                    j6 = jX;
                }
                if (jA <= 0 || j6 <= jA) {
                    jA = j6;
                }
                long j7 = jX / 2;
                long j8 = j - j7;
                if (jA > j8) {
                    jA = j8;
                } else if (jA < j7) {
                    jA = j7;
                }
                a aVar3 = new a(aVar.pn() + (j - jA), aVar.iz());
                com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "obtainSegment: parent = " + aVar + ", child = " + aVar3 + ", maxRemainBytes = " + j + ", childLength = " + jA + ", ratio = " + fB + ", threadIndex = " + mvVar.fx);
                return aVar3;
            }
            str = "SegmentDispatcher";
        }
        a aVar4 = new a(aVar.pn() + (j / 2), aVar.iz());
        com.ss.android.socialbase.downloader.fx.u.fx(str, "obtainSegment: parent = " + aVar + ",child = " + aVar4);
        return aVar4;
    }

    private float b(mv mvVar, o oVar) {
        long jNr = mvVar.nr();
        int size = this.n.size();
        if (size <= 1) {
            size = this.nr.u();
        }
        float f = 1.0f;
        if (jNr <= 0) {
            float fMv = this.nr.mv();
            if (fMv <= 0.0f || fMv >= 1.0f) {
                fMv = 1.0f / size;
            }
            if (mvVar.fx == 0) {
                return fMv;
            }
            if (size > 1) {
                f = 1.0f - fMv;
                size--;
            }
        } else {
            long jK = k();
            if (jK > jNr) {
                return jNr / jK;
            }
        }
        return f / size;
    }

    private void u(o oVar) {
        mv mvVar = new mv(this.u, this, this.fx, oVar, this.n.size());
        this.n.add(mvVar);
        mvVar.u(com.ss.android.socialbase.downloader.downloader.fx.o().submit(mvVar));
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void u(mv mvVar) {
        if (this.d) {
            com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "onReaderRun, threadIndex = " + mvVar.fx);
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public a u(mv mvVar, o oVar) {
        if (this.iz || this.x) {
            return null;
        }
        synchronized (this) {
            a aVarNr = nr(mvVar, oVar);
            if (aVarNr != null) {
                aVarNr.n();
                if (aVarNr.jk() > 1) {
                    return new a(aVarNr);
                }
            }
            return aVarNr;
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void u(mv mvVar, a aVar) {
        synchronized (this) {
            aVar.a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void u(mv mvVar, a aVar, o oVar, com.ss.android.socialbase.downloader.model.b bVar) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        synchronized (this) {
            if (!this.iz && !this.x) {
                nr(mvVar, aVar, oVar, bVar);
                mvVar.nr(false);
                if (this.mv <= 0) {
                    long totalBytes = this.u.getTotalBytes();
                    this.mv = totalBytes;
                    if (totalBytes <= 0) {
                        this.mv = bVar.jk();
                    }
                    pn();
                } else if (this.nr.iz()) {
                    pn();
                }
            } else {
                throw new my(com.huawei.openalliance.ad.constant.x.bq);
            }
        }
    }

    public void nr() {
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "pause1");
        this.x = true;
        synchronized (this) {
            Iterator<mv> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().pn();
            }
        }
        this.pn.nr();
        this.fx.fx();
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void u(mv mvVar, o oVar, a aVar, BaseException baseException, int i, int i2) {
        boolean zNr = com.ss.android.socialbase.downloader.jk.iz.nr(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zNr = true;
        }
        if (zNr || i >= i2) {
            fx(mvVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.iz.iz
    public void u(mv mvVar, o oVar, a aVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "onSegmentFailed: segment = " + aVar + ", e = " + baseException);
            mvVar.nr(true);
            if (mvVar.fx == 0) {
                this.o = baseException;
            }
            if (l()) {
                if (this.o == null) {
                    this.o = baseException;
                }
                this.c = true;
                u(this.o);
            }
        }
    }

    private void nr(long j) {
        this.bq.u(this.u.getCurBytes(), j);
        Iterator<mv> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().nr(j);
        }
    }

    private void u(BaseException baseException) {
        com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.o = baseException;
        this.fx.fx();
        synchronized (this) {
            Iterator<mv> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().pn();
            }
        }
    }

    private void u(com.ss.android.socialbase.downloader.model.b bVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.b bVar2 = this.jk;
        if (bVar2 == null && (bVar2 = this.t) == null) {
            return;
        }
        long jJk = bVar.jk();
        long jJk2 = bVar2.jk();
        if (jJk != jJk2) {
            String str = "total len not equals,len=" + jJk + ",sLen=" + jJk2 + ",code=" + bVar.fx + ",sCode=" + bVar2.fx + ",range=" + bVar.pn() + ",sRange = " + bVar2.pn() + ",url = " + bVar.u + ",sUrl=" + bVar2.u;
            com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", str);
            if (jJk > 0 && jJk2 > 0) {
                throw new BaseException(FunDC.ID_AUTH_1074, str);
            }
        }
        String strFx = bVar.fx();
        String strFx2 = bVar2.fx();
        if (TextUtils.equals(strFx, strFx2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strFx + ", mainEtag = " + strFx2;
        com.ss.android.socialbase.downloader.fx.u.pn("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strFx) && !TextUtils.isEmpty(strFx2) && !strFx.equalsIgnoreCase(strFx2)) {
            throw new BaseException(FunDC.ID_AUTH_1074, str2);
        }
    }

    public void u() {
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "cancel");
        this.iz = true;
        synchronized (this) {
            Iterator<mv> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().pn();
            }
        }
        this.pn.u();
        this.fx.fx();
    }

    private int u(long j) {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.k.get(i);
            if (aVar.fx() == j) {
                return i;
            }
            if (aVar.fx() > j) {
                return -1;
            }
        }
        return -1;
    }

    private long u(int i, int i2) {
        a aVar = this.k.get(i);
        long jU = u(aVar);
        int i3 = i + 1;
        a aVar2 = i3 < i2 ? this.k.get(i3) : null;
        if (aVar2 == null) {
            return jU;
        }
        long jFx = aVar2.fx() - aVar.pn();
        return jU == -1 ? jFx : Math.min(jU, jFx);
    }

    private long u(a aVar) {
        long jNr = aVar.nr();
        if (jNr != -1) {
            return jNr;
        }
        long j = this.mv;
        return j > 0 ? j - aVar.pn() : jNr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public mv u(boolean z, long j, long j2) {
        mv mvVar = null;
        for (mv mvVar2 : this.n) {
            if (mvVar2.fx != 0 || z) {
                if (mvVar2.b > 0 && mvVar2.pn <= 0 && j - mvVar2.b > j2 && (mvVar == null || mvVar2.b < mvVar.b)) {
                    mvVar = mvVar2;
                }
            }
        }
        return mvVar;
    }

    private boolean u(mv mvVar, long j, long j2, long j3, double d) {
        if (mvVar.iz <= 0) {
            return false;
        }
        long jNr = this.bq.nr(j, j2);
        int size = this.n.size();
        if (size > 0) {
            jNr /= (long) size;
        }
        long jU = mvVar.u(j, j2);
        return jU < j3 || ((double) jU) < ((double) jNr) * d;
    }

    private boolean u(long j, long j2) {
        long j3 = j - j2;
        long jNr = this.bq.nr(j3, j);
        int size = this.n.size();
        if (size > 0) {
            jNr /= (long) size;
        }
        mv mvVarU = u(j3, j, (long) Math.max(10.0f, jNr * this.z), size / 2);
        if (mvVarU != null) {
            fx(mvVarU);
            com.ss.android.socialbase.downloader.fx.u.b("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + mvVarU.fx);
            mvVarU.iz();
            return true;
        }
        mv mvVarU2 = u(true, j, j2);
        if (mvVarU2 == null) {
            return false;
        }
        fx(mvVarU2);
        com.ss.android.socialbase.downloader.fx.u.b("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + mvVarU2.fx);
        mvVarU2.iz();
        return true;
    }

    private mv u(long j, long j2, long j3, int i) {
        long j4 = Long.MAX_VALUE;
        int i2 = 0;
        mv mvVar = null;
        for (mv mvVar2 : this.n) {
            if (mvVar2.iz > 0) {
                i2++;
                if (mvVar2.iz < j) {
                    long jU = mvVar2.u(j, j2);
                    if (jU >= 0 && jU < j4) {
                        mvVar = mvVar2;
                        j4 = jU;
                    }
                }
            }
        }
        if (mvVar == null || i2 < i || j4 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + mvVar.fx);
        return mvVar;
    }
}
