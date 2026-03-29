package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.ad.beans.parameter.DecoupleStylePackageInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jh {
    private static final String B = "fc_flag";
    private static final String C = "style_decouple";
    private static final String Code = "DecoupleStyleProcessor";
    private static final String D = ".zip";
    private static final String F = "_";
    private static final String I = "styleVersion";
    private static final String L = "dsl";
    private static final String S = "style";
    private static final String V = "styleFilePath";
    private static final String Z = "pps";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6585a = "packageInfo.json";
    private static jh c;
    private static final byte[] d = new byte[0];
    private final Context b;
    private final String e;
    private String f;

    private jh(Context context) {
        this.b = context.getApplicationContext();
        String strV = com.huawei.openalliance.ad.utils.az.V(com.huawei.openalliance.ad.utils.q.L(context));
        StringBuilder sb = new StringBuilder();
        sb.append(strV);
        String str = File.separator;
        sb.append(str);
        sb.append(Z);
        sb.append(str);
        sb.append(C);
        this.e = sb.toString();
    }

    public static jh Code(Context context) {
        return V(context);
    }

    private Pair<File, File> Z() {
        File file;
        File file2 = new File(this.f);
        File file3 = null;
        if (!file2.isDirectory()) {
            fh.I(Code, "style not dir");
            return null;
        }
        File[] fileArrListFiles = file2.listFiles();
        if (com.huawei.openalliance.ad.utils.ag.Code(fileArrListFiles)) {
            file = null;
        } else {
            file = null;
            for (File file4 : fileArrListFiles) {
                if (file4 != null && !com.huawei.openalliance.ad.utils.bc.Code(file4.getName())) {
                    if (file4.getName().endsWith(f6585a)) {
                        file3 = file4;
                    } else if (file4.getName().endsWith(D)) {
                        file = file4;
                    }
                }
            }
        }
        return new Pair<>(file3, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ei eiVarCode = ei.Code(this.b);
        fh.Code(Code, "queryStyleConfigInner updateStyleFcFlag: %s", Integer.valueOf(eiVarCode.Code()));
        boolean z = eiVarCode.Code() == 1;
        long jCode = com.huawei.openalliance.ad.utils.z.Code();
        fh.Code(Code, "requestNow: %s, cur time: %s", Boolean.valueOf(z), com.huawei.openalliance.ad.utils.z.Code("HH:mm:ss").format(Long.valueOf(jCode)));
        if (z) {
            Code(1);
            eiVarCode.Code(jCode);
            return;
        }
        long jV = eiVarCode.V();
        boolean z2 = jCode - jV > 600000;
        fh.Code(Code, "last query time: %s", com.huawei.openalliance.ad.utils.z.Code("HH:mm:ss").format(Long.valueOf(jV)));
        if (z2) {
            Code(0);
            eiVarCode.Code(jCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<File, File> V(String str) {
        try {
            if (com.huawei.openalliance.ad.utils.bc.Code(str)) {
                fh.V(Code, "file path empty");
                return null;
            }
            if (!str.endsWith(D)) {
                fh.V(Code, "not zip file");
                return null;
            }
            String strSubstring = str.substring(0, str.lastIndexOf(D));
            this.f = strSubstring;
            fh.Code(Code, "unzip dir path: %s", com.huawei.openalliance.ad.utils.bl.Code(strSubstring));
            boolean zCode = com.huawei.openalliance.ad.utils.bn.Code(str, this.f, true);
            fh.V(Code, "unzip result: %s", Boolean.valueOf(zCode));
            if (zCode) {
                return Z();
            }
            fh.V(Code, "unzip failed");
            return null;
        } catch (Throwable th) {
            fh.I(Code, "get unzipped file error: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public void Code() {
        I();
    }

    private void Code(int i) {
        try {
            if (TextUtils.isEmpty(h.Code())) {
                fh.I(Code, "ui EngineVer is Empty");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(B, i);
            com.huawei.openalliance.ad.ipc.h.Code(this.b, true).Code(com.huawei.openalliance.ad.constant.s.Q, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jh.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult == null) {
                        return;
                    }
                    try {
                        String data = callResult.getData();
                        if (com.huawei.openalliance.ad.utils.bc.Code(data)) {
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject(data);
                        final String strOptString = jSONObject2.optString(jh.V);
                        final String strOptString2 = jSONObject2.optString(jh.I);
                        final String strCode = h.Code();
                        fh.Code(jh.Code, "file path: %s, style ver: %s", com.huawei.openalliance.ad.utils.bl.Code(strOptString), strOptString2);
                        if (jh.this.Code(strOptString2)) {
                            fh.V(jh.Code, "no need update");
                        } else {
                            fh.V(jh.Code, "need update");
                            com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(jh.this.e);
                                    String str2 = File.separator;
                                    sb.append(str2);
                                    sb.append("style");
                                    sb.append(jh.F);
                                    sb.append(strOptString2);
                                    sb.append(jh.D);
                                    String string = sb.toString();
                                    if (!com.huawei.openalliance.ad.utils.u.Code(jh.this.b, strOptString, string)) {
                                        fh.V(jh.Code, "copy failed");
                                        return;
                                    }
                                    Pair pairV = jh.this.V(string);
                                    if (pairV == null) {
                                        fh.V(jh.Code, "style file pair null");
                                        return;
                                    }
                                    boolean zCode = jh.this.Code((Pair<File, File>) pairV, strOptString2);
                                    fh.V(jh.Code, "check result: %s", Boolean.valueOf(zCode));
                                    if (zCode) {
                                        File file = (File) pairV.second;
                                        if (!file.exists()) {
                                            fh.V(jh.Code, "dsl zip not exist");
                                            return;
                                        }
                                        String str3 = jh.this.f + str2 + jh.L;
                                        if (!jh.this.Code(file, str3)) {
                                            fh.V(jh.Code, "unzip dsl fail");
                                            return;
                                        }
                                        fh.Code(jh.Code, "unzip dsl dir path: %s", com.huawei.openalliance.ad.utils.bl.Code(str3));
                                        boolean zCode2 = com.huawei.openalliance.ad.utils.c.Code(str3, strOptString2);
                                        fh.Code(jh.Code, "updateResult: %s", Boolean.valueOf(zCode2));
                                        if (zCode2) {
                                            com.huawei.openalliance.ad.utils.at.Code(jh.this.b).Z(strOptString2);
                                            com.huawei.openalliance.ad.utils.at.Code(jh.this.b).B(strCode);
                                        }
                                        jh.this.I(string);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        fh.I(jh.Code, "query style config error: %s", th.getClass().getSimpleName());
                    }
                }
            }, String.class);
        } catch (Throwable th) {
            fh.I(Code, "query style config error: %s", th.getClass().getSimpleName());
        }
    }

    private static jh V(Context context) {
        jh jhVar;
        synchronized (d) {
            if (c == null) {
                c = new jh(context);
            }
            jhVar = c;
        }
        return jhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final String str) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.4
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.utils.u.Code(jh.this.f);
                com.huawei.openalliance.ad.utils.u.I(new File(str));
            }
        });
    }

    private void Code(final String str, final String str2, final String str3) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.3
            @Override // java.lang.Runnable
            public void run() {
                db.Code(jh.this.b, str, str2, str3);
            }
        });
    }

    public void V() {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.jh.1
            @Override // java.lang.Runnable
            public void run() {
                jh.this.I();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(Pair<File, File> pair, String str) {
        File file = (File) pair.first;
        File file2 = (File) pair.second;
        if (file == null || file2 == null) {
            fh.I(Code, "package info or dsl file null");
            return false;
        }
        DecoupleStylePackageInfo decoupleStylePackageInfo = (DecoupleStylePackageInfo) com.huawei.openalliance.ad.utils.ad.V(com.huawei.openalliance.ad.utils.u.Z(file), DecoupleStylePackageInfo.class, new Class[0]);
        if (decoupleStylePackageInfo == null) {
            fh.V(Code, "package info empty");
            return false;
        }
        String strV = decoupleStylePackageInfo.V();
        if (com.huawei.openalliance.ad.utils.bc.Code(strV)) {
            fh.V(Code, "check sha256 failed: %s", com.huawei.openalliance.ad.constant.ag.Z);
            Code("1", str, com.huawei.openalliance.ad.constant.ag.Z);
            return false;
        }
        if (strV.equalsIgnoreCase(com.huawei.openalliance.ad.utils.ay.Code(file2))) {
            fh.V(Code, com.huawei.openalliance.ad.constant.ag.B);
            Code("0", str, com.huawei.openalliance.ad.constant.ag.B);
            return true;
        }
        fh.V(Code, "check sha256 failed: %s", com.huawei.openalliance.ad.constant.ag.I);
        Code("1", str, com.huawei.openalliance.ad.constant.ag.I);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(File file, String str) {
        try {
            return com.huawei.openalliance.ad.utils.bn.Code(com.huawei.openalliance.ad.utils.u.V(file), str, true);
        } catch (Throwable th) {
            fh.I(Code, "unzip dsl zip failed: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(String str) {
        String str2;
        String strE = com.huawei.openalliance.ad.utils.at.Code(this.b).e();
        String strCode = h.Code();
        if (TextUtils.isEmpty(strCode)) {
            str2 = "new UiEngineVer is Empty";
        } else {
            fh.Code(Code, "new uiEngineVer:%s, old uiengineVersion:%s", strCode, strE);
            if (!strCode.equals(strE)) {
                fh.V(Code, "uiEngineVer is not same");
                return false;
            }
            if (!com.huawei.openalliance.ad.utils.bc.Code(str)) {
                String strD = com.huawei.openalliance.ad.utils.at.Code(this.b).d();
                fh.Code(Code, "cachedStylePkgVer:%s, updateStyleVer:%s", strD, str);
                return str.equals(strD);
            }
            str2 = "update style ver empty";
        }
        fh.I(Code, str2);
        return true;
    }
}
