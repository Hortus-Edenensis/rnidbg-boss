package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.hu;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ih {
    public static void a(String str, byte[] bArr, ig igVar) throws Throwable {
        hu huVarA;
        OutputStream outputStreamA = null;
        try {
            if (a(igVar.f2905a, str)) {
                return;
            }
            File file = new File(igVar.f2905a);
            if (!file.exists()) {
                file.mkdirs();
            }
            huVarA = hu.a(file, igVar.b);
            try {
                huVarA.a(igVar.d);
                byte[] bArrB = igVar.e.b(bArr);
                hu.a aVarB = huVarA.b(str);
                outputStreamA = aVarB.a();
                outputStreamA.write(bArrB);
                aVarB.b();
                huVarA.c();
                try {
                    outputStreamA.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    huVarA.close();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            huVarA = null;
        }
        if (outputStreamA != null) {
            try {
                outputStreamA.close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (huVarA == null) {
            throw th;
        }
        try {
            huVarA.close();
            throw th;
        } catch (Throwable th6) {
            th6.printStackTrace();
            throw th;
        }
    }

    public static int a(ig igVar) {
        ArrayList arrayList;
        byte[] bArrA;
        hu huVar = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (igVar.f.c()) {
            igVar.f.a(true);
            hu huVarA = hu.a(new File(igVar.f2905a), igVar.b);
            try {
                arrayList = new ArrayList();
                bArrA = a(huVarA, igVar, arrayList);
            } catch (Throwable th3) {
                th = th3;
                huVar = huVarA;
                try {
                    hd.c(th, "leg", "uts");
                    if (huVar != null) {
                        huVar.close();
                    }
                    return -1;
                } catch (Throwable th4) {
                    if (huVar != null) {
                        try {
                            huVar.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    throw th4;
                }
            }
            if (bArrA != null && bArrA.length != 0) {
                hc hcVar = new hc(bArrA, igVar.c);
                hx.a();
                JSONObject jSONObject = new JSONObject(new String(hx.c(hcVar).f2902a));
                if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                    iz izVar = igVar.f;
                    if (izVar != null) {
                        izVar.a(bArrA.length);
                    }
                    if (igVar.f.b() < Integer.MAX_VALUE) {
                        a(huVarA, arrayList);
                    } else {
                        try {
                            huVarA.d();
                        } catch (Throwable th6) {
                            hd.c(th6, "ofm", "dlo");
                        }
                    }
                    return bArrA.length;
                }
                huVar = huVarA;
                return -1;
            }
            try {
                huVarA.close();
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
            return -1;
        }
        if (huVar != null) {
            huVar.close();
        }
        return -1;
    }

    private static byte[] a(hu huVar, ig igVar, List<String> list) {
        try {
            File fileB = huVar.b();
            if (fileB != null && fileB.exists()) {
                int length = 0;
                for (String str : fileB.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] bArrA = im.a(huVar, str2);
                        length += bArrA.length;
                        list.add(str2);
                        if (length > igVar.f.b()) {
                            break;
                        }
                        igVar.g.b(bArrA);
                    }
                }
                if (length <= 0) {
                    return null;
                }
                return igVar.g.a();
            }
        } catch (Throwable th) {
            hd.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(hu huVar, List<String> list) {
        if (huVar != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    huVar.c(it.next());
                }
                huVar.close();
            } catch (Throwable th) {
                hd.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            hd.c(th, "leg", "fet");
            return false;
        }
    }
}
