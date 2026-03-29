package com.bytedance.sdk.component.iz.fx.u.u;

import com.bytedance.sdk.component.iz.fx.u.u.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.component.iz.b {
    private u nr;
    private long u;

    public nr(File file, long j, ExecutorService executorService) {
        this.u = j;
        try {
            this.nr = u.u(file, 20210302, 1, j, executorService);
        } catch (IOException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.iz.u
    /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
    public boolean nr(String str) {
        try {
            try {
                u.fx fxVarU = this.nr.u(str);
                boolean z = fxVarU != null;
                com.bytedance.sdk.component.iz.fx.fx.nr.u(fxVarU);
                return z;
            } catch (IOException e) {
                e.getMessage();
                com.bytedance.sdk.component.iz.fx.fx.nr.u(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.iz.fx.fx.nr.u(null);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.iz.u
    /* JADX INFO: renamed from: nr, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] u(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamU;
        u uVar = this.nr;
        InputStream inputStream = null;
        if (uVar != null && str != null) {
            try {
                u.fx fxVarU = uVar.u(str);
                if (fxVarU == null) {
                    com.bytedance.sdk.component.iz.fx.fx.nr.u(null);
                    com.bytedance.sdk.component.iz.fx.fx.nr.u(null);
                    return null;
                }
                inputStreamU = fxVarU.u(0);
                if (inputStreamU != null) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException unused) {
                        byteArrayOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = null;
                        inputStream = inputStreamU;
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(byteArrayOutputStream);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamU.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamU;
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(byteArrayOutputStream);
                        throw th;
                    }
                } else {
                    byteArrayOutputStream = null;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStreamU);
                com.bytedance.sdk.component.iz.fx.fx.nr.u(byteArrayOutputStream);
                return byteArray;
            } catch (IOException unused3) {
                inputStreamU = null;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
            com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStreamU);
            com.bytedance.sdk.component.iz.fx.fx.nr.u(byteArrayOutputStream);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.iz.b
    public InputStream u(String str) {
        u uVar = this.nr;
        if (uVar == null) {
            return null;
        }
        try {
            u.fx fxVarU = uVar.u(str);
            if (fxVarU != null) {
                return fxVarU.u(0);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean u(String str, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        u uVar = this.nr;
        if (uVar != null && bArr != null && str != null) {
            OutputStream outputStreamU = null;
            outputStreamU = null;
            u.C0219u c0219u = null;
            try {
                try {
                    u.C0219u c0219uNr = uVar.nr(str);
                    if (c0219uNr == null) {
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(null);
                        return false;
                    }
                    try {
                        outputStreamU = c0219uNr.u(0);
                        if (outputStreamU == u.fx) {
                            com.bytedance.sdk.component.iz.fx.fx.nr.u(outputStreamU);
                            return false;
                        }
                        outputStreamU.write(bArr);
                        c0219uNr.u();
                        this.nr.u();
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(outputStreamU);
                        return true;
                    } catch (IOException unused) {
                        OutputStream outputStream2 = outputStreamU;
                        c0219u = c0219uNr;
                        outputStream = outputStream2;
                        if (c0219u != null) {
                            try {
                                c0219u.nr();
                            } catch (IOException unused2) {
                            } catch (Throwable th) {
                                outputStreamU = outputStream;
                                th = th;
                            }
                        }
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(outputStream);
                        return false;
                    }
                } catch (IOException unused3) {
                    outputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            com.bytedance.sdk.component.iz.fx.fx.nr.u(outputStreamU);
            throw th;
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public void u(double d) {
        this.nr.u((long) (this.u * d));
    }
}
