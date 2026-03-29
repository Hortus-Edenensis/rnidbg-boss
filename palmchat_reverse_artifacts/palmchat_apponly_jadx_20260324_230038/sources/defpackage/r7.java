package defpackage;

import android.content.Context;
import com.opos.acs.st.STManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.settings.AddressInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class r7 {
    public static r7 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, ArrayList<AddressInfo>> f20405a;

    public r7() {
        try {
            this.f20405a = m(AppContext.getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static r7 j(Context context) {
        if (b == null) {
            synchronized (r7.class) {
                if (b == null) {
                    b = new r7();
                }
            }
        }
        return b;
    }

    public ArrayList<AddressInfo> a(String str, String str2, String str3) {
        ArrayList<AddressInfo> arrayList = new ArrayList<>();
        AddressInfo addressInfoE = e(str, "zh_CN");
        if (addressInfoE == null) {
            addressInfoE = e(str, "en");
        }
        AddressInfo addressInfoC = c(addressInfoE != null ? addressInfoE.childList : null, str2);
        AddressInfo addressInfoC2 = c(addressInfoC != null ? addressInfoC.childList : null, str3);
        arrayList.add(addressInfoE);
        arrayList.add(addressInfoC);
        arrayList.add(addressInfoC2);
        return arrayList;
    }

    public final AddressInfo b(ArrayList<AddressInfo> arrayList, String str) {
        AddressInfo addressInfo = null;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).key.equals(str)) {
                    addressInfo = arrayList.get(i);
                }
            }
        }
        return addressInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AddressInfo c(ArrayList<AddressInfo> arrayList, String str) {
        AddressInfo addressInfo = null;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                String str2 = arrayList.get(i).name;
                if (str2 != null && str != null) {
                    if (!str2.equals(str)) {
                        if (!str2.equals(str + "市")) {
                            if (!(str2 + "市").equals(str)) {
                                if (!str2.equals(str + "区")) {
                                    if ((str2 + "区").equals(str)) {
                                        addressInfo = arrayList.get(i);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return addressInfo;
    }

    public ArrayList<AddressInfo> d(Context context, String str, String str2) {
        ArrayList<AddressInfo> arrayListL = l(context, str);
        if (arrayListL == null) {
            return null;
        }
        for (int i = 0; i < arrayListL.size(); i++) {
            if (arrayListL.get(i).key.equals(str2)) {
                return arrayListL.get(i).childList;
            }
        }
        return null;
    }

    public AddressInfo e(String str, String str2) {
        ArrayList<AddressInfo> arrayList;
        if (str != null && (arrayList = this.f20405a.get(str2)) != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).name.equals(str)) {
                    return arrayList.get(i);
                }
            }
        }
        return null;
    }

    public String f(String str) {
        AddressInfo addressInfoE = e(str, "zh_CN");
        if (addressInfoE == null) {
            addressInfoE = e(str, "en");
        }
        return addressInfoE != null ? addressInfoE.key : "CN";
    }

    public ArrayList<AddressInfo> g(Context context) {
        String strK = k(context);
        return this.f20405a == null ? new ArrayList<>() : (strK.equals("CN") || strK.equals(STManager.REGION_OF_TW)) ? this.f20405a.get("zh_CN") : this.f20405a.get("en");
    }

    public String h(Context context, String str) {
        AddressInfo addressInfoB = b(g(context), str);
        return addressInfoB == null ? "" : addressInfoB.name;
    }

    public final String[] i(String str) {
        return str.split("_");
    }

    public final String k(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public ArrayList<AddressInfo> l(Context context, String str) {
        ArrayList<AddressInfo> arrayListG = g(context);
        if (arrayListG == null) {
            return null;
        }
        for (int i = 0; i < arrayListG.size(); i++) {
            if (arrayListG.get(i).key.equals(str)) {
                return arrayListG.get(i).childList;
            }
        }
        return null;
    }

    public final HashMap<String, ArrayList<AddressInfo>> m(Context context) throws Throwable {
        InputStreamReader inputStreamReader;
        HashMap<String, ArrayList<AddressInfo>> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        Object obj = null;
        bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(context.getResources().getAssets().open("addressassets.txt"), "utf-8");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                ArrayList<AddressInfo> arrayList = null;
                ArrayList<AddressInfo> arrayList2 = null;
                ArrayList<AddressInfo> arrayList3 = null;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            pu1.u(bufferedReader2);
                            pu1.u(inputStreamReader);
                            return map;
                        }
                        String[] strArrSplit = line.split("\\|");
                        if (strArrSplit.length == 3) {
                            String str = strArrSplit[0];
                            String str2 = strArrSplit[1];
                            String str3 = strArrSplit[2];
                            if (!str.equals("zh_TW")) {
                                boolean zEquals = str.equals(obj);
                                obj = obj;
                                if (!zEquals) {
                                    arrayList2 = new ArrayList<>();
                                    map.put(str, arrayList2);
                                    obj = str;
                                }
                                String[] strArrI = i(str2);
                                if (strArrI.length == 1) {
                                    AddressInfo addressInfo = new AddressInfo();
                                    addressInfo.type = 0;
                                    addressInfo.key = strArrI[0];
                                    addressInfo.name = str3;
                                    ArrayList<AddressInfo> arrayList4 = new ArrayList<>();
                                    addressInfo.childList = arrayList4;
                                    arrayList2.add(addressInfo);
                                    arrayList3 = arrayList4;
                                } else if (strArrI.length == 2) {
                                    AddressInfo addressInfo2 = new AddressInfo();
                                    addressInfo2.type = 1;
                                    addressInfo2.key = strArrI[1];
                                    addressInfo2.name = str3;
                                    ArrayList<AddressInfo> arrayList5 = new ArrayList<>();
                                    addressInfo2.childList = arrayList5;
                                    arrayList3.add(addressInfo2);
                                    arrayList = arrayList5;
                                } else if (strArrI.length == 3) {
                                    AddressInfo addressInfo3 = new AddressInfo();
                                    addressInfo3.type = 2;
                                    addressInfo3.key = strArrI[2];
                                    addressInfo3.name = str3;
                                    arrayList.add(addressInfo3);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        pu1.u(bufferedReader);
                        pu1.u(inputStreamReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    public ArrayList<String> n(Context context, String str, String str2, String str3) {
        ArrayList<String> arrayList = new ArrayList<>(3);
        AddressInfo addressInfoB = b(g(context), str);
        AddressInfo addressInfoB2 = b(addressInfoB != null ? addressInfoB.childList : null, str2);
        AddressInfo addressInfoB3 = b(addressInfoB2 != null ? addressInfoB2.childList : null, str3);
        arrayList.add(addressInfoB == null ? "" : addressInfoB.name);
        arrayList.add(addressInfoB2 == null ? "" : addressInfoB2.name);
        arrayList.add(addressInfoB3 != null ? addressInfoB3.name : "");
        return arrayList;
    }
}
