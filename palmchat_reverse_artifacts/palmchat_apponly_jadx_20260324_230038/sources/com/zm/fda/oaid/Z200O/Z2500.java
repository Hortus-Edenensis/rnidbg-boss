package com.zm.fda.oaid.Z200O;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z2500 extends com.zm.fda.oaid.ZZ00Z {
    public static final String b = "FDA_OAID_Nubia";

    public Z2500(Context context) {
        this.f16722a = context;
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        if (this.f16722a == null) {
            z25o0.a("");
        } else {
            d(new com.zm.fda.oaid.Z25O0() { // from class: vp6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    this.f21505a.a(z25o0, str);
                }
            });
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            super.a(new com.zm.fda.oaid.Z25O0() { // from class: wp6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str2) {
                    z25o0.a(str2);
                }
            });
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[PHI: r2 r3
      0x007c: PHI (r2v10 java.lang.String) = (r2v8 java.lang.String), (r2v16 java.lang.String) binds: [B:30:0x007a, B:23:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x007c: PHI (r3v3 android.content.ContentProviderClient) = (r3v2 android.content.ContentProviderClient), (r3v8 android.content.ContentProviderClient) binds: [B:30:0x007a, B:23:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(com.zm.fda.oaid.Z25O0 z25o0) {
        String str;
        ContentProviderClient contentProviderClientAcquireContentProviderClient;
        if (z25o0 == null) {
            return;
        }
        if (!isSupport() || this.f16722a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(!isSupport() ? "系统不支持内部获取oaid" : "context=null");
            sb.append("getOaidBySelf返回空");
            com.zm.fda.oaid.Z2500.Z25O0.a(b, sb.toString());
            z25o0.a("");
            return;
        }
        ContentProviderClient contentProviderClient = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            contentProviderClientAcquireContentProviderClient = this.f16722a.getContentResolver().acquireContentProviderClient(Uri.parse(com.zm.fda.oaid.Z2500.OO22Z.a("Y29udGVudDovL2NuLm51YmlhLmlkZW50aXR5L2lkZW50aXR5")));
            if (contentProviderClientAcquireContentProviderClient != null) {
                try {
                    Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call(com.zm.fda.oaid.Z2500.OO22Z.a("Z2V0T0FJRA=="), null, null);
                    if (bundleCall == null) {
                        Log.e(b, "OAID query failed: bundle is null");
                    } else if (bundleCall.getInt("code", -1) == 0) {
                        string = bundleCall.getString("id");
                        com.zm.fda.oaid.Z2500.Z25O0.a(b, "getOaidBySelf oaid from bundle:" + string);
                    }
                } catch (Throwable th) {
                    th = th;
                    str = string;
                    contentProviderClient = contentProviderClientAcquireContentProviderClient;
                    try {
                        Log.e(b, "getOaidBySelf err", th);
                        if (contentProviderClient == null) {
                            string = str;
                            z25o0.a(string);
                        }
                        String str2 = str;
                        contentProviderClientAcquireContentProviderClient = contentProviderClient;
                        string = str2;
                        if (Build.VERSION.SDK_INT >= 24) {
                        }
                        z25o0.a(string);
                    } catch (Throwable th2) {
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                contentProviderClient.release();
                            } else {
                                contentProviderClient.release();
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
        if (contentProviderClientAcquireContentProviderClient != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.release();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
        }
        z25o0.a(string);
    }
}
