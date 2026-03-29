package com.bykv.vk.openvk.component.video.u.nr.u;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.u.nr.b;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends com.bykv.vk.openvk.component.video.u.nr.u.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nr f4974a;
    private final ReentrantReadWriteLock.ReadLock b;
    private final ReentrantReadWriteLock fx;
    private final Set<u> iz;
    private final Runnable jk;
    private volatile float n;
    private final LinkedHashMap<String, File> nr = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock.WriteLock pn;
    private final Handler t;
    public final File u;
    private volatile long x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {
        private final Map<String, Integer> u;

        private nr() {
            this.u = new HashMap();
        }

        public synchronized boolean fx(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.u.containsKey(str);
        }

        public synchronized void nr(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.u.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.u.remove(str);
                    return;
                }
                this.u.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        public synchronized void u(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.u.get(str);
                if (num == null) {
                    this.u.put(str, 1);
                    return;
                }
                this.u.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(String str);

        void u(Set<String> set);
    }

    public fx(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.fx = reentrantReadWriteLock;
        this.b = reentrantReadWriteLock.readLock();
        this.pn = reentrantReadWriteLock.writeLock();
        this.iz = Collections.newSetFromMap(new ConcurrentHashMap());
        this.x = 104857600L;
        this.n = 0.5f;
        this.f4974a = new nr();
        this.jk = new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.nr.u.fx.1
            @Override // java.lang.Runnable
            public void run() {
                x.nr(new a("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.u.nr.u.fx.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fx fxVar = fx.this;
                        fxVar.nr(fxVar.x);
                    }
                });
            }
        };
        this.t = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.u = file;
            x.nr(new a("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.u.nr.u.fx.2
                @Override // java.lang.Runnable
                public void run() {
                    fx.this.nr();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  ".concat(String.valueOf(str)));
    }

    private void fx() {
        this.t.removeCallbacks(this.jk);
        this.t.postDelayed(this.jk, 10000L);
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.u.u
    public File b(String str) {
        if (!this.b.tryLock()) {
            return null;
        }
        File file = this.nr.get(str);
        this.b.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        this.pn.lock();
        try {
            File[] fileArrListFiles = this.u.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.u.nr.u.fx.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.nr.put(u(file2), file2);
                }
            }
            this.pn.unlock();
            fx();
        } catch (Throwable th) {
            this.pn.unlock();
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.u.u
    public File fx(String str) {
        this.b.lock();
        File file = this.nr.get(str);
        this.b.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.u, str);
        this.pn.lock();
        this.nr.put(str, file2);
        this.pn.unlock();
        Iterator<u> it = this.iz.iterator();
        while (it.hasNext()) {
            it.next().u(str);
        }
        fx();
        return file2;
    }

    public void u(u uVar) {
        if (uVar != null) {
            this.iz.add(uVar);
        }
    }

    public void u(long j) {
        this.x = j;
        fx();
    }

    public void u() {
        com.bykv.vk.openvk.component.video.u.nr.fx.u().nr();
        Context context = b.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.u.nr.nr.fx.u(context).u(0);
        }
        this.t.removeCallbacks(this.jk);
        x.nr(new a("clear", 1) { // from class: com.bykv.vk.openvk.component.video.u.nr.u.fx.4
            @Override // java.lang.Runnable
            public void run() {
                fx.this.nr(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.u.u
    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4974a.u(str);
    }

    private String u(File file) {
        return file.getName();
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.u.u
    public void nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4974a.nr(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(long j) {
        HashSet hashSet;
        final HashSet hashSet2 = new HashSet();
        this.pn.lock();
        try {
            Iterator<Map.Entry<String, File>> it = this.nr.entrySet().iterator();
            long length = 0;
            while (it.hasNext()) {
                length += it.next().getValue().length();
            }
            if (length <= j) {
                this.pn.unlock();
                return;
            }
            long j2 = (long) (j * this.n);
            hashSet = new HashSet();
            try {
                for (Map.Entry<String, File> entry : this.nr.entrySet()) {
                    File value = entry.getValue();
                    if (value != null && value.exists()) {
                        if (!this.f4974a.fx(u(value))) {
                            long length2 = value.length();
                            File file = new File(value.getAbsolutePath() + "-tmp");
                            if (value.renameTo(file)) {
                                hashSet2.add(file);
                                length -= length2;
                                hashSet.add(entry.getKey());
                            }
                        }
                    } else {
                        hashSet.add(entry.getKey());
                    }
                    if (length <= j2) {
                        break;
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    this.nr.remove((String) it2.next());
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            hashSet = null;
        }
        this.pn.unlock();
        Iterator<u> it3 = this.iz.iterator();
        while (it3.hasNext()) {
            it3.next().u(hashSet);
        }
        x.nr(new a("trimSize", 1) { // from class: com.bykv.vk.openvk.component.video.u.nr.u.fx.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    try {
                        ((File) it4.next()).delete();
                    } catch (Throwable unused3) {
                    }
                }
            }
        });
    }
}
