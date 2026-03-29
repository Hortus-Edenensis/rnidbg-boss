package com.kwad.sdk.a.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    private static volatile b axk;
    private Stack<AdTemplate> axi = new Stack<>();
    private File axj;
    private boolean mHasInit;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void EF();

        void hz();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File EB() {
        File file = this.axj;
        if (file != null) {
            return file;
        }
        String strDU = be.dU(ServiceProvider.getContext());
        File file2 = new File(strDU);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(strDU + File.separator + "uninstall_ad");
        this.axj = file3;
        if (file3.exists()) {
            return this.axj;
        }
        try {
            this.axj.createNewFile();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
        }
        return this.axj;
    }

    private static boolean EC() {
        return com.kwad.sdk.core.config.e.GZ() == 0;
    }

    public static b ED() {
        if (axk == null) {
            synchronized (b.class) {
                if (axk == null) {
                    axk = new b();
                }
            }
        }
        return axk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aV(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        Iterator<AdTemplate> it = this.axi.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.eB(it.next()) == com.kwad.sdk.core.response.b.e.eB(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (!z) {
            return;
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.axj));
            try {
                try {
                    objectOutputStream.writeObject(this.axi);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aW(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        this.axi.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(EB()));
            try {
                try {
                    objectOutputStream.writeObject(this.axi);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File aZ(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.I(com.kwad.sdk.core.response.b.e.er(adTemplate)));
        if (w.O(file)) {
            return file;
        }
        return null;
    }

    public final synchronized AdTemplate EE() {
        AdTemplate adTemplate;
        Stack stack = (Stack) this.axi.clone();
        while (true) {
            if (stack.isEmpty()) {
                adTemplate = null;
                break;
            }
            adTemplate = (AdTemplate) stack.pop();
            if (adTemplate != null) {
                String str = com.kwad.sdk.core.response.b.e.er(adTemplate).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File fileAZ = aZ(adTemplate);
                if (fileAZ != null && fileAZ.exists() && fileAZ.lastModified() + com.igexin.push.f.b.d.b > System.currentTimeMillis() && !as.as(context, str)) {
                    break;
                }
            }
        }
        return adTemplate;
    }

    public final void aX(final AdTemplate adTemplate) {
        if (EC() || adTemplate == null) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.aW(adTemplate);
            }
        });
    }

    public final void aY(final AdTemplate adTemplate) {
        if (EC() || adTemplate == null) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.aV(adTemplate);
            }
        });
    }

    public static /* synthetic */ boolean a(b bVar) {
        return EC();
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Not initialized variable reg: 4, insn: 0x0123: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:292), block:B:71:0x0123 */
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ObjectInputStream objectInputStream;
                ObjectOutputStream objectOutputStream;
                ObjectOutputStream objectOutputStream2;
                try {
                    if (!b.a(b.this) && com.kwad.sdk.a.a.a.b.dP() <= 0) {
                        HashMap map = new HashMap();
                        File fileEB = b.this.EB();
                        ObjectOutputStream objectOutputStream3 = null;
                        try {
                            try {
                                if (!fileEB.exists()) {
                                    com.kwad.sdk.core.d.c.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                                }
                                b.this.axi.clear();
                                objectInputStream = new ObjectInputStream(new FileInputStream(fileEB));
                                try {
                                    b.this.axi = (Stack) objectInputStream.readObject();
                                    if (!b.this.axi.isEmpty()) {
                                        Stack stack = new Stack();
                                        while (!b.this.axi.isEmpty()) {
                                            AdTemplate adTemplate = (AdTemplate) b.this.axi.pop();
                                            if (adTemplate != null) {
                                                String strValueOf = String.valueOf(com.kwad.sdk.core.response.b.e.eB(adTemplate));
                                                File fileAZ = b.aZ(adTemplate);
                                                if (fileAZ == null || !fileAZ.exists() || fileAZ.lastModified() + com.igexin.push.f.b.d.b <= System.currentTimeMillis()) {
                                                    map.put(strValueOf, Boolean.TRUE);
                                                } else {
                                                    stack.push(adTemplate);
                                                }
                                            }
                                        }
                                        while (!stack.isEmpty()) {
                                            b.this.axi.push((AdTemplate) stack.pop());
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " getCanShowDownloadBannerData e" + e);
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.EF();
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream3 = objectOutputStream;
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            objectInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            throw th;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                        try {
                            try {
                                objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(fileEB));
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            objectOutputStream2.writeObject(b.this.axi);
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                        } catch (Exception e4) {
                            e = e4;
                            objectOutputStream3 = objectOutputStream2;
                            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            com.kwad.components.core.d.a.reportSdkCaughtException(e);
                            a aVar3 = aVar;
                            if (aVar3 != null) {
                                aVar3.EF();
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                                return;
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            objectOutputStream3 = objectOutputStream2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            throw th;
                        }
                        a aVar4 = aVar;
                        if (aVar4 != null) {
                            aVar4.hz();
                        }
                    }
                } catch (Throwable th5) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th5);
                }
            }
        });
    }
}
