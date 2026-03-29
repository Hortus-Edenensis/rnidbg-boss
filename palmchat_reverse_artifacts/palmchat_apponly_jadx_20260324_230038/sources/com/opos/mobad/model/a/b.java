package com.opos.mobad.model.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.u;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f9042a = ac.f.APP_INSTALLED.a();
    private static final int b = ac.f.APP_UNINSTALLED.a();

    private static com.opos.mobad.model.c.e a(Context context, ab abVar) {
        if (com.opos.cmn.d.b.a(com.opos.cmn.d.c.a(context, abVar.f), abVar.g)) {
            return null;
        }
        com.opos.mobad.model.c.e eVar = new com.opos.mobad.model.c.e();
        eVar.a(abVar.f);
        eVar.b(abVar.g);
        eVar.c(com.opos.cmn.d.c.a(context, abVar.f));
        return eVar;
    }

    public static boolean b(Context context, ac acVar, i iVar, int i) {
        Integer num = acVar.aN;
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        int i2 = f9042a;
        if (i2 == (i2 & iIntValue) && !TextUtils.isEmpty(acVar.Z) && com.opos.cmn.an.h.d.a.d(context, acVar.Z)) {
            if (com.opos.mobad.model.utils.d.a(i)) {
                com.opos.cmn.an.f.a.b("AdLoader", "isFilterAd() doesn't filter because installedExempt=1");
                return false;
            }
            com.opos.cmn.an.f.a.b("AdLoader", "isFilterAd() filter because install");
            if (iVar != null) {
                iVar.a(acVar);
            }
            return true;
        }
        int i3 = b;
        if (i3 != (iIntValue & i3) || TextUtils.isEmpty(acVar.Z) || com.opos.cmn.an.h.d.a.d(context, acVar.Z)) {
            return false;
        }
        com.opos.cmn.an.f.a.b("AdLoader", "isFilterAd() filter because uninstall");
        if (iVar != null) {
            iVar.g(acVar);
        }
        return true;
    }

    private static MaterialFileData a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        MaterialFileData materialFileData = new MaterialFileData();
        materialFileData.a(abVar.f);
        materialFileData.b(abVar.g);
        Integer num = abVar.h;
        materialFileData.a(num != null ? num.intValue() : 0);
        Integer num2 = abVar.i;
        materialFileData.b(num2 != null ? num2.intValue() : 0);
        return materialFileData;
    }

    public static boolean b(ac acVar) {
        if (acVar == null) {
            return false;
        }
        ac.i iVar = acVar.T;
        ac.i iVar2 = ac.i.OPEN_MINI_PROGRAM;
        return iVar == iVar2 || acVar.aK == iVar2 || acVar.aL == iVar2 || acVar.aw == iVar2 || acVar.ax == iVar2;
    }

    public static MaterialFileData a(com.opos.mobad.b bVar, ab abVar, Set<com.opos.mobad.model.c.e> set, boolean z, com.opos.mobad.model.e.m mVar) {
        if (z) {
            set = null;
        }
        return a(bVar, abVar, true, set, mVar);
    }

    private static MaterialFileData a(com.opos.mobad.b bVar, ab abVar, boolean z, Set<com.opos.mobad.model.c.e> set, com.opos.mobad.model.e.m mVar) {
        if (abVar == null || com.opos.cmn.an.d.b.a(abVar.f)) {
            return null;
        }
        if (set == null) {
            return a(abVar);
        }
        com.opos.mobad.model.c.e eVarA = a(bVar.b(), abVar);
        if (eVarA != null) {
            set.add(eVarA);
            if (!z) {
                bVar.p().b(false);
            }
        } else {
            if (!z) {
                bVar.p().b(true);
            }
            if (mVar != null) {
                mVar.a(abVar.f, 2);
            }
            com.opos.cmn.an.f.a.b("AdLoader", "material File " + abVar.toString() + " exists,don't need download again!!!");
        }
        return a(abVar);
    }

    public static MaterialFileData a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, Set<com.opos.mobad.model.c.e> set, boolean z, com.opos.mobad.model.e.m mVar) {
        ab abVar = bVar2.I;
        if (z) {
            set = null;
        }
        return a(bVar, abVar, true, set, mVar);
    }

    public static List<MaterialData> a(com.opos.mobad.b bVar, ac acVar, Set<com.opos.mobad.model.c.e> set, Set<com.opos.mobad.model.c.e> set2, boolean z, com.opos.mobad.model.e.m mVar) {
        List<MaterialFileData> listA;
        List<MaterialFileData> listA2;
        List<MaterialFileData> listA3;
        if (z) {
            listA = a(bVar, acVar.X, (Set<com.opos.mobad.model.c.e>) null, mVar);
            listA2 = a(bVar, acVar.bc, (Set<com.opos.mobad.model.c.e>) null, mVar);
            listA3 = acVar.S == ac.c.RAW_VIDEO ? a(bVar, acVar.U, set2, mVar) : a(bVar, acVar.U, (Set<com.opos.mobad.model.c.e>) null, mVar);
        } else {
            listA = a(bVar, acVar.X, set, mVar);
            listA2 = a(bVar, acVar.bc, set2, mVar);
            listA3 = a(bVar, acVar.U, set, mVar);
        }
        List<MaterialFileData> list = listA;
        List<MaterialFileData> list2 = listA2;
        List<MaterialFileData> list3 = listA3;
        List<MaterialFileData> listA4 = a(bVar, acVar.as, (Set<com.opos.mobad.model.c.e>) null, mVar);
        u uVar = acVar.aJ;
        MaterialData materialData = new MaterialData(acVar, list3, list, listA4, list2, uVar != null ? new FloatLayerData(acVar.aJ, a(bVar, uVar.d, false, set, mVar), a(bVar, acVar.aJ.g, set2, mVar), a(bVar, acVar.aJ.h, set2, mVar)) : null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return arrayList;
    }

    private static List<MaterialFileData> a(com.opos.mobad.b bVar, List<ab> list, Set<com.opos.mobad.model.c.e> set, com.opos.mobad.model.e.m mVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<ab> it = list.iterator();
            while (it.hasNext()) {
                MaterialFileData materialFileDataA = a(bVar, it.next(), false, set, mVar);
                if (materialFileDataA != null) {
                    arrayList.add(materialFileDataA);
                }
            }
        }
        return arrayList;
    }

    public static boolean a(Context context, ac acVar, i iVar, int i) {
        boolean z = acVar != null ? !b(context, acVar, iVar, i) : true;
        com.opos.cmn.an.f.a.b("AdLoader", "isValidMaterialEntity() reuslt=", Boolean.valueOf(z), "installedExempt=", Integer.valueOf(i), "materialEntity=", acVar);
        return z;
    }

    public static boolean a(ac acVar) {
        ac.c cVar = acVar.S;
        return cVar == ac.c.VIDEO || cVar == ac.c.FULL_VIDEO || cVar == ac.c.POP_WINDOW_VIDEO || cVar == ac.c.RAW_VIDEO || cVar == ac.c.VIDEO_HTML || cVar == ac.c.VIDEO_TIP_BAR;
    }

    public static boolean a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, List<ab> list) {
        if (bVar2.R == b.d.PLAY_CACHE) {
            ab abVar = list.get(0);
            boolean zIsEmpty = TextUtils.isEmpty(com.opos.cmn.d.d.a(bVar.b(), abVar.f, abVar.g));
            s sVarP = bVar.p();
            if (zIsEmpty) {
                sVarP.a(false);
                com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial but not cache video");
                return false;
            }
            sVarP.a(true);
        }
        com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial");
        return true;
    }
}
