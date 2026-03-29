package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jf {
    private static final String Code = "CCP";
    private static jf Z;
    private Class<?> c;
    private final eh d;
    private final int e;
    private static final byte[] V = new byte[0];
    private static final byte[] I = new byte[0];
    private static Map<String, String[]> B = new ConcurrentHashMap();
    private int C = 0;
    private int S = 0;
    private int F = 0;
    private int D = 0;
    private int L = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6584a = 0;
    private int b = 100;

    private jf(Context context) {
        eh ehVarCode = eh.Code(context);
        this.d = ehVarCode;
        this.e = ehVarCode.Q();
        try {
            int i = PPSNativeView.e0;
            this.c = PPSNativeView.class;
        } catch (Throwable unused) {
            fh.I(Code, "init unClctViewClass error");
        }
    }

    private static jf I(Context context) {
        jf jfVar;
        synchronized (V) {
            if (Z == null) {
                Z = new jf(context);
            }
            jfVar = Z;
        }
        return jfVar;
    }

    public static jf Code(Context context) {
        return I(context);
    }

    public void V(final Context context) {
        com.huawei.openalliance.ad.utils.i.B(new Runnable() { // from class: com.huawei.hms.ads.jf.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!jf.this.d.ag()) {
                        jf.B.clear();
                        fh.V(jf.Code, "disabled");
                        return;
                    }
                    int iP = jf.this.d.P() * 1000;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - jf.this.d.ah() <= iP && iP != 0) {
                        fh.V(jf.Code, "check failed in %s", Integer.valueOf(iP));
                        return;
                    }
                    fh.V(jf.Code, "check pass");
                    jf.this.d.I(jCurrentTimeMillis);
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        jf.this.Code((Activity) context2);
                    } else {
                        fh.V(jf.Code, "not target");
                    }
                } catch (Throwable th) {
                    fh.Z(jf.Code, "process error: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    private String[] V(Activity activity) {
        this.C = 0;
        String[] strArr = new String[0];
        List<String> listCode = Code(activity.getWindow().getDecorView(), this.f6584a);
        if (!com.huawei.openalliance.ad.utils.ag.Code(listCode)) {
            return (String[]) listCode.toArray(new String[listCode.size()]);
        }
        fh.Code(Code, "get contentAuto is null");
        return strArr;
    }

    public String Code() {
        if (this.d.ag()) {
            fh.Code(Code, "get AutoContentBundle");
            return com.huawei.openalliance.ad.utils.ad.V(B);
        }
        fh.Code(Code, "get AutoContentBundle off");
        B.clear();
        return null;
    }

    private List<String> Code(View view, int i) {
        if (view == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            int i2 = i + 1;
            if (i2 >= this.b) {
                fh.Code(Code, "autoContentRur outer round %s ", Integer.valueOf(i2));
                return arrayList;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (!Code(childAt)) {
                    if ((childAt instanceof TextView) && childAt.isShown()) {
                        synchronized (I) {
                            String string = ((TextView) childAt).getText().toString();
                            int i4 = this.C;
                            if (i4 >= this.e || i4 + string.length() <= this.e) {
                                int i5 = this.C;
                                if (i5 < this.e) {
                                    this.C = i5 + string.length();
                                    if (!TextUtils.isEmpty(string)) {
                                        arrayList.add(string);
                                    }
                                }
                            } else {
                                this.C += string.length();
                                int length = (string.length() - this.C) + this.e;
                                if (length > string.length()) {
                                    length = string.length();
                                }
                                string = string.substring(0, length);
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            }
                        }
                    }
                    int i6 = this.C;
                    int i7 = this.e;
                    if (i6 >= i7) {
                        fh.Code(Code, "autoContentSize maxSize %s", Integer.valueOf(i7));
                        return arrayList;
                    }
                    arrayList.addAll(Code(childAt, i2));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        fh.Code(Code, "getActivityInfo-name: %s", activity.getClass().getSimpleName());
        if (!com.huawei.openalliance.ad.utils.bc.Code(simpleName)) {
            B.clear();
            B.put("activityName", new String[]{simpleName});
        }
        Map<Integer, String> mapCode = com.huawei.openalliance.ad.utils.m.Code(activity, this.d.R());
        if (!com.huawei.openalliance.ad.utils.al.Code(mapCode)) {
            Code(activity, mapCode);
            return;
        }
        fh.V(Code, "auto process");
        String[] strArrV = V(activity);
        if (strArrV == null || strArrV.length <= 0) {
            return;
        }
        B.put(com.huawei.openalliance.ad.constant.x.cs, strArrV);
    }

    private void Code(Activity activity, Map<Integer, String> map) {
        HashMap map2 = new HashMap();
        this.S = 0;
        this.D = 0;
        this.L = 0;
        this.F = 0;
        Code(activity.getWindow().getDecorView(), map, map2, this.f6584a);
        if (com.huawei.openalliance.ad.utils.al.Code(map2)) {
            fh.Code(Code, "no get cfg, getAutoContent");
            String[] strArrV = V(activity);
            if (strArrV == null || strArrV.length <= 0) {
                return;
            }
            B.put(com.huawei.openalliance.ad.constant.x.cs, strArrV);
            return;
        }
        Code(map2, "title", B);
        if (!Code(map2, "content", B)) {
            fh.Code(Code, "no get cfg content, getAutoContent");
            String[] strArrV2 = V(activity);
            if (strArrV2 != null && strArrV2.length > 0) {
                B.put(com.huawei.openalliance.ad.constant.x.cs, strArrV2);
            }
        }
        Code(map2, com.huawei.openalliance.ad.constant.x.cw, B);
        Code(map2, com.huawei.openalliance.ad.constant.x.cx, B);
    }

    private void Code(View view, Map<Integer, String> map, Map<String, List<String>> map2, int i) {
        if (view instanceof ViewGroup) {
            int i2 = i + 1;
            if (i2 >= this.b) {
                fh.Code(Code, "clctCfgContentDepth outer round " + this.b);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof TextView) {
                    Code(map, map2, childAt);
                }
                Code(childAt, map, map2, i2);
            }
        }
    }

    private void Code(Map<Integer, String> map, Map<String, List<String>> map2, View view) {
        int length;
        int i;
        int i2;
        int id = view.getId();
        if (!map.containsKey(Integer.valueOf(id))) {
            fh.V(Code, "invalid id");
            return;
        }
        TextView textView = (TextView) view;
        String string = textView.getText() != null ? textView.getText().toString() : "";
        length = string.length();
        String str = map.get(Integer.valueOf(id));
        List<String> arrayList = new ArrayList<>();
        if (map2.containsKey(str)) {
            arrayList = map2.get(str);
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        String str2 = str != null ? str : "";
        switch (str2) {
            case "category":
                i = this.D;
                i2 = length + i;
                this.D = i2;
                break;
            case "title":
                i = this.F;
                i2 = length + i;
                this.F = i2;
                break;
            case "content":
                i = this.S;
                i2 = length + i;
                this.S = i2;
                break;
            case "subcategory":
                i = this.L;
                i2 = length + i;
                this.L = i2;
                break;
            default:
                i = 0;
                i2 = 0;
                break;
        }
        int i3 = this.e;
        if (i < i3) {
            if (i2 >= i3) {
                int length2 = (string.length() + this.e) - i2;
                if (!TextUtils.isEmpty(string.substring(0, length2))) {
                    arrayList.add(string.substring(0, length2));
                }
            } else if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
        }
        map2.put(str2, arrayList);
    }

    private boolean Code(View view) {
        Class<?> cls = this.c;
        return cls != null && cls.isInstance(view);
    }

    private boolean Code(Map<String, List<String>> map, String str, Map<String, String[]> map2) {
        if (!map.containsKey(str)) {
            return false;
        }
        List<String> list = map.get(str);
        if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
            map2.put(str, (String[]) list.toArray(new String[list.size()]));
            return true;
        }
        fh.Code(Code, "get %s is null " + str);
        return false;
    }
}
