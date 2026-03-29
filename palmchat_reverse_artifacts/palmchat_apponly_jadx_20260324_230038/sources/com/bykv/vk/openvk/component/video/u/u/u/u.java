package com.bykv.vk.openvk.component.video.u.u.u;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u implements com.bykv.vk.openvk.component.video.api.u.nr {
    private String u = "video_reward_full";
    private String nr = "video_brand";
    private String fx = "video_splash";
    private String b = "video_default";
    private String pn = null;
    private String iz = null;
    private String x = null;
    private String n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4976a = null;

    private List<com.bykv.vk.openvk.component.video.api.u.u> iz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.u.u(new File(u()).listFiles(), com.bykv.vk.openvk.component.video.u.u.fx()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.u.u(new File(fx()).listFiles(), com.bykv.vk.openvk.component.video.u.u.nr()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.u.u(new File(nr()).listFiles(), com.bykv.vk.openvk.component.video.u.u.b()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.u.u(new File(b()).listFiles(), com.bykv.vk.openvk.component.video.u.u.pn()));
        return arrayList;
    }

    private Set<String> x() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.u.u.u uVar : com.bykv.vk.openvk.component.video.u.u.u.u.values()) {
            if (uVar != null && uVar.u() != null) {
                iz izVarU = uVar.u();
                hashSet.add(com.bykv.vk.openvk.component.video.u.pn.fx.nr(izVarU.pn(), izVarU.o()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.u.pn.fx.fx(izVarU.pn(), izVarU.o()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.u.u.nr.nr nrVar : com.bykv.vk.openvk.component.video.u.u.nr.fx.u.values()) {
            if (nrVar != null && nrVar.u() != null) {
                iz izVarU2 = nrVar.u();
                hashSet.add(com.bykv.vk.openvk.component.video.u.pn.fx.nr(izVarU2.pn(), izVarU2.o()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.u.pn.fx.fx(izVarU2.pn(), izVarU2.o()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String b() {
        if (this.f4976a == null) {
            this.f4976a = this.pn + File.separator + this.b;
            File file = new File(this.f4976a);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f4976a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String fx() {
        if (this.n == null) {
            this.n = this.pn + File.separator + this.fx;
            File file = new File(this.n);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.n;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String nr() {
        if (this.x == null) {
            this.x = this.pn + File.separator + this.nr;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public synchronized void pn() {
        List<com.bykv.vk.openvk.component.video.api.u.u> listIz = iz();
        if (Build.VERSION.SDK_INT >= 23) {
            Set<String> setX = null;
            for (com.bykv.vk.openvk.component.video.api.u.u uVar : listIz) {
                File[] fileArrU = uVar.u();
                if (fileArrU != null && fileArrU.length >= uVar.nr()) {
                    if (setX == null) {
                        setX = x();
                    }
                    int iNr = uVar.nr() - 2;
                    if (iNr < 0) {
                        iNr = 0;
                    }
                    u(uVar.u(), iNr, setX);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public void u(String str) {
        this.pn = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String u() {
        if (this.iz == null) {
            this.iz = this.pn + File.separator + this.u;
            File file = new File(this.iz);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.iz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public long nr(iz izVar) {
        if (TextUtils.isEmpty(izVar.pn()) || TextUtils.isEmpty(izVar.o())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.u.pn.fx.u(izVar.pn(), izVar.o());
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public boolean u(iz izVar) {
        if (TextUtils.isEmpty(izVar.pn()) || TextUtils.isEmpty(izVar.o())) {
            return false;
        }
        return new File(izVar.pn(), izVar.o()).exists();
    }

    private static void u(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.u.u.u.u.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
