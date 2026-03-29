package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class j12 implements ps1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ps1 f18302a;

    public j12(ps1 ps1Var) {
        this.f18302a = ps1Var;
    }

    @Override // defpackage.ps1
    public boolean advancePeekPosition(int i, boolean z) throws IOException {
        return this.f18302a.advancePeekPosition(i, z);
    }

    @Override // defpackage.ps1
    public long getLength() {
        return this.f18302a.getLength();
    }

    @Override // defpackage.ps1
    public long getPeekPosition() {
        return this.f18302a.getPeekPosition();
    }

    @Override // defpackage.ps1
    public long getPosition() {
        return this.f18302a.getPosition();
    }

    @Override // defpackage.ps1
    public int peek(byte[] bArr, int i, int i2) throws IOException {
        return this.f18302a.peek(bArr, i, i2);
    }

    @Override // defpackage.ps1
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        return this.f18302a.peekFully(bArr, i, i2, z);
    }

    @Override // defpackage.ps1, defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f18302a.read(bArr, i, i2);
    }

    @Override // defpackage.ps1
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        return this.f18302a.readFully(bArr, i, i2, z);
    }

    @Override // defpackage.ps1
    public void resetPeekPosition() {
        this.f18302a.resetPeekPosition();
    }

    @Override // defpackage.ps1
    public int skip(int i) throws IOException {
        return this.f18302a.skip(i);
    }

    @Override // defpackage.ps1
    public void skipFully(int i) throws IOException {
        this.f18302a.skipFully(i);
    }

    @Override // defpackage.ps1
    public void advancePeekPosition(int i) throws IOException {
        this.f18302a.advancePeekPosition(i);
    }

    @Override // defpackage.ps1
    public void peekFully(byte[] bArr, int i, int i2) throws IOException {
        this.f18302a.peekFully(bArr, i, i2);
    }

    @Override // defpackage.ps1
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f18302a.readFully(bArr, i, i2);
    }
}
