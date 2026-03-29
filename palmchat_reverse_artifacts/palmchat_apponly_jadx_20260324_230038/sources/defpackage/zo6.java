package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zo6 extends nb4 {
    public xo6 e;
    public DataOutputStream f;

    public zo6(xo6 xo6Var) {
        super(xo6Var);
        this.e = xo6Var;
        this.f = new DataOutputStream(xo6Var.u);
    }

    @Override // defpackage.nb4
    public void b() throws IOException {
        this.f.flush();
    }

    @Override // defpackage.nb4
    public void d() throws IOException {
        try {
            this.f.flush();
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                this.f.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            this.f.close();
        } catch (Exception unused3) {
        }
    }

    @Override // defpackage.nb4
    public void j(GeneratedMessageLite generatedMessageLite) throws IOException {
        byte[] byteArray = generatedMessageLite.toByteArray();
        byte b = kb4.b(generatedMessageLite);
        if (b != 17) {
            this.f.writeInt(byteArray.length + 6);
            this.f.writeByte(b);
            this.f.writeByte(1);
            this.f.write(byteArray);
            return;
        }
        if (om1.f().o()) {
            try {
                byte[] bArrQ = om1.f().q(byteArray, true);
                if (bArrQ == null) {
                    return;
                }
                this.f.writeInt(bArrQ.length + 6);
                this.f.writeByte(b);
                this.f.writeByte(1);
                this.f.write(bArrQ);
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
    }

    @Override // defpackage.nb4
    public void c() {
    }
}
