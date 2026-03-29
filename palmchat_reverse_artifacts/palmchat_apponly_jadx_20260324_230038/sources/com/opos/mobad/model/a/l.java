package com.opos.mobad.model.a;

import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.b.a.u;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class l implements com.opos.mobad.model.e.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<MaterialFileData> f9056a;
    private List<MaterialFileData> b;
    private List<MaterialFileData> c;
    private MaterialFileData d;
    private MaterialFileData e;
    private List<MaterialFileData> f;
    private List<MaterialFileData> g;

    public l(ac acVar, ab abVar) {
        this.f9056a = a(acVar.X);
        this.b = a(acVar.U);
        this.c = a(acVar.bc);
        u uVar = acVar.aJ;
        if (uVar != null) {
            this.e = a(uVar.d);
            this.f = a(acVar.aJ.g);
            this.g = a(acVar.aJ.h);
        }
        this.d = a(abVar);
    }

    private static MaterialFileData a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        MaterialFileData materialFileData = new MaterialFileData();
        materialFileData.a(abVar.f);
        materialFileData.b(abVar.g);
        return materialFileData;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> b() {
        return this.b;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> c() {
        return this.c;
    }

    @Override // com.opos.mobad.model.e.j
    public MaterialFileData d() {
        return this.d;
    }

    @Override // com.opos.mobad.model.e.j
    public MaterialFileData e() {
        return this.e;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> f() {
        return this.f;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> g() {
        return this.g;
    }

    @Override // com.opos.mobad.model.e.j
    public List<MaterialFileData> a() {
        return this.f9056a;
    }

    private static List<MaterialFileData> a(List<ab> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ab> it = list.iterator();
        while (it.hasNext()) {
            MaterialFileData materialFileDataA = a(it.next());
            if (materialFileDataA != null) {
                arrayList.add(materialFileDataA);
            }
        }
        return arrayList;
    }
}
