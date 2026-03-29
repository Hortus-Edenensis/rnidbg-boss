package com.opos.mobad.model.e;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f9105a;
    private Integer[] b;
    private String c;
    private Map<String, Integer> d;
    private Integer[] e;
    private String f;
    private Map<String, Integer> g;
    private Integer[] h;
    private HashMap<String, Integer> i;
    private Integer[] j;
    private HashMap<String, Integer> k;
    private Integer[] l;
    private JSONObject m;

    public n(j jVar) {
        c(jVar.a());
        d(jVar.b());
        a(jVar.c());
        a(jVar.d());
        b(jVar.e());
        e(jVar.f());
        b(jVar.g());
        this.m = new JSONObject();
    }

    private void b(MaterialFileData materialFileData) {
        if (materialFileData == null || TextUtils.isEmpty(materialFileData.a())) {
            return;
        }
        this.f = materialFileData.a();
    }

    private void c(List<MaterialFileData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f9105a = new HashMap();
        this.b = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            MaterialFileData materialFileData = list.get(i);
            if (materialFileData != null && !TextUtils.isEmpty(materialFileData.a())) {
                this.f9105a.put(materialFileData.a(), Integer.valueOf(i));
            }
        }
    }

    private void d(List<MaterialFileData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d = new HashMap();
        this.e = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            MaterialFileData materialFileData = list.get(i);
            if (materialFileData != null && !TextUtils.isEmpty(materialFileData.a())) {
                this.d.put(materialFileData.a(), Integer.valueOf(i));
            }
        }
    }

    private void e(List<MaterialFileData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g = new HashMap();
        this.h = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            MaterialFileData materialFileData = list.get(i);
            if (materialFileData != null && !TextUtils.isEmpty(materialFileData.a())) {
                this.g.put(materialFileData.a(), Integer.valueOf(i));
            }
        }
    }

    public String a() {
        StringBuilder sbA = a(this.b);
        if (sbA.length() > 0) {
            a("icL", sbA.toString());
        }
        StringBuilder sbA2 = a(this.e);
        if (sbA2.length() > 0) {
            a("iL", sbA2.toString());
        }
        StringBuilder sbA3 = a(this.h);
        if (sbA3.length() > 0) {
            a("fiL", sbA3.toString());
        }
        StringBuilder sbA4 = a(this.j);
        if (sbA4.length() > 0) {
            a("itrL", sbA4.toString());
        }
        StringBuilder sbA5 = a(this.l);
        if (sbA5.length() > 0) {
            a("fitrL", sbA5.toString());
        }
        return this.m.toString();
    }

    private static final StringBuilder a(Integer[] numArr) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null && numArr.length > 0) {
            for (Integer num : numArr) {
                if (num == null) {
                    sb.append(0);
                } else {
                    sb.append(num);
                }
            }
        }
        return sb;
    }

    private void b(String str, int i) {
        try {
            this.m.put(str, i);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "append fail", e);
        }
    }

    private void a(MaterialFileData materialFileData) {
        if (materialFileData == null || TextUtils.isEmpty(materialFileData.a())) {
            return;
        }
        this.c = materialFileData.a();
    }

    private void b(List<MaterialFileData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k = new HashMap<>();
        this.l = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            MaterialFileData materialFileData = list.get(i);
            if (materialFileData != null && !TextUtils.isEmpty(materialFileData.a())) {
                this.k.put(materialFileData.a(), Integer.valueOf(i));
            }
        }
    }

    public void a(String str, int i) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        try {
            if (str.equals(this.c)) {
                b("l", i);
                return;
            }
            if (str.equals(this.f)) {
                b("fi", i);
            }
            Map<String, Integer> map = this.d;
            if (map != null && (num5 = map.get(str)) != null) {
                int iIntValue = num5.intValue();
                Integer[] numArr = this.e;
                if (iIntValue < numArr.length) {
                    numArr[num5.intValue()] = Integer.valueOf(i);
                }
            }
            Map<String, Integer> map2 = this.f9105a;
            if (map2 != null && (num4 = map2.get(str)) != null) {
                int iIntValue2 = num4.intValue();
                Integer[] numArr2 = this.b;
                if (iIntValue2 < numArr2.length) {
                    numArr2[num4.intValue()] = Integer.valueOf(i);
                }
            }
            HashMap<String, Integer> map3 = this.i;
            if (map3 != null && (num3 = map3.get(str)) != null) {
                int iIntValue3 = num3.intValue();
                Integer[] numArr3 = this.j;
                if (iIntValue3 < numArr3.length) {
                    numArr3[num3.intValue()] = Integer.valueOf(i);
                }
            }
            HashMap<String, Integer> map4 = this.k;
            if (map4 != null && (num2 = map4.get(str)) != null) {
                int iIntValue4 = num2.intValue();
                Integer[] numArr4 = this.l;
                if (iIntValue4 < numArr4.length) {
                    numArr4[num2.intValue()] = Integer.valueOf(i);
                }
            }
            Map<String, Integer> map5 = this.g;
            if (map5 == null || (num = map5.get(str)) == null) {
                return;
            }
            int iIntValue5 = num.intValue();
            Integer[] numArr5 = this.h;
            if (iIntValue5 < numArr5.length) {
                numArr5[num.intValue()] = Integer.valueOf(i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "mark url fail", e);
        }
    }

    private void a(String str, String str2) {
        try {
            this.m.put(str, str2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "append fail", e);
        }
    }

    private void a(List<MaterialFileData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.i = new HashMap<>();
        this.j = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            MaterialFileData materialFileData = list.get(i);
            if (materialFileData != null && !TextUtils.isEmpty(materialFileData.a())) {
                this.i.put(materialFileData.a(), Integer.valueOf(i));
            }
        }
    }
}
