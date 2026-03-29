package com.bytedance.sdk.component.a.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.iz;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.utils.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends b {
    public u(l lVar) {
        super(lVar);
    }

    public void u(final com.bytedance.sdk.component.a.u.u uVar) {
        try {
            s.u uVar2 = new s.u();
            uVar2.u((Object) nr());
            nr(HttpHeaders.RANGE, "bytes=0-");
            if (TextUtils.isEmpty(this.iz)) {
                uVar.u(this, new IOException("Url is Empty"));
                return;
            }
            uVar2.u(this.iz);
            u(uVar2);
            this.fx.u(uVar2.u().nr()).u(new com.bytedance.sdk.component.nr.u.fx() { // from class: com.bytedance.sdk.component.a.nr.u.1
                @Override // com.bytedance.sdk.component.nr.u.fx
                public void onFailure(com.bytedance.sdk.component.nr.u.nr nrVar, IOException iOException) {
                    com.bytedance.sdk.component.a.u.u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.u(u.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.nr.u.fx
                public void onResponse(com.bytedance.sdk.component.nr.u.nr nrVar, my myVar) throws IOException {
                    int iIntValue;
                    byte[] bArr;
                    InputStream inputStreamFx;
                    if (uVar != null) {
                        HashMap map = new HashMap();
                        if (myVar != null) {
                            com.bytedance.sdk.component.a.nr nrVar2 = new com.bytedance.sdk.component.a.nr(myVar.b(), myVar.fx(), myVar.pn(), map, null, myVar.nr(), myVar.u());
                            if (!myVar.b()) {
                                uVar.u(u.this, nrVar2);
                                return;
                            }
                            InputStream inputStream = null;
                            try {
                                iz izVarX = myVar.x();
                                if (izVarX != null) {
                                    for (int i = 0; i < izVarX.u(); i++) {
                                        map.put(izVarX.u(i), izVarX.nr(i));
                                    }
                                }
                                iIntValue = Long.valueOf(myVar.iz().u()).intValue();
                                bArr = new byte[iIntValue];
                                inputStreamFx = myVar.iz().fx();
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                if (inputStreamFx.read(bArr) == iIntValue) {
                                    nrVar2.u(bArr);
                                } else {
                                    nrVar2 = new com.bytedance.sdk.component.a.nr(false, myVar.fx(), "Byte opt fail", map, null, myVar.nr(), myVar.u());
                                }
                                uVar.u(u.this, nrVar2);
                                try {
                                    inputStreamFx.close();
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStreamFx;
                                try {
                                    uVar.u(u.this, new IOException(th.getMessage()));
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                } catch (Throwable th3) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    throw th3;
                                }
                            }
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.a.nr.b
    public com.bytedance.sdk.component.a.nr u() {
        InputStream inputStreamFx;
        try {
            s.u uVar = new s.u();
            uVar.u((Object) nr());
            nr(HttpHeaders.RANGE, "bytes=0-");
            if (TextUtils.isEmpty(this.iz)) {
                k.nr("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            uVar.u(this.iz);
            u(uVar);
            my myVarNr = this.fx.u(uVar.u().nr()).nr();
            if (myVarNr == null || !myVarNr.b()) {
                return null;
            }
            HashMap map = new HashMap();
            iz izVarX = myVarNr.x();
            if (izVarX != null) {
                for (int i = 0; i < izVarX.u(); i++) {
                    map.put(izVarX.u(i), izVarX.nr(i));
                }
            }
            long jU = myVarNr.iz().u();
            byte[] bArr = new byte[Long.valueOf(jU).intValue()];
            inputStreamFx = myVarNr.iz().fx();
            try {
                if (inputStreamFx.read(bArr) == jU) {
                    com.bytedance.sdk.component.a.nr nrVar = new com.bytedance.sdk.component.a.nr(myVarNr.b(), myVarNr.fx(), myVarNr.pn(), map, null, myVarNr.nr(), myVarNr.u());
                    nrVar.u(bArr);
                    try {
                        inputStreamFx.close();
                    } catch (Throwable unused) {
                    }
                    return nrVar;
                }
                com.bytedance.sdk.component.a.nr nrVar2 = new com.bytedance.sdk.component.a.nr(false, myVarNr.fx(), "Byte opt fail", map, null, myVarNr.nr(), myVarNr.u());
                try {
                    inputStreamFx.close();
                } catch (Throwable unused2) {
                }
                return nrVar2;
            } catch (Throwable unused3) {
                if (inputStreamFx != null) {
                    try {
                        inputStreamFx.close();
                    } catch (Throwable unused4) {
                    }
                }
                return null;
            }
        } catch (Throwable unused5) {
            inputStreamFx = null;
        }
    }
}
