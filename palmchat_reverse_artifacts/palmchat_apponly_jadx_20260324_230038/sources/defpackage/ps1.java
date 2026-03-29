package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface ps1 extends ru0 {
    void advancePeekPosition(int i) throws IOException;

    boolean advancePeekPosition(int i, boolean z) throws IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] bArr, int i, int i2) throws IOException;

    void peekFully(byte[] bArr, int i, int i2) throws IOException;

    boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException;

    @Override // defpackage.ru0
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;

    boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException;

    void resetPeekPosition();

    int skip(int i) throws IOException;

    void skipFully(int i) throws IOException;
}
