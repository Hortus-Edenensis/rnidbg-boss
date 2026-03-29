package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aYJ;
    private final int aYK;
    private byte[] aYL;
    private int aYM;
    protected boolean aYN;
    protected boolean aYO;
    private int aYP;
    private long aYQ;
    private DeflatedChunksSet aYR;
    private ChunkReader aYS;
    private long aYT;
    private ErrorBehaviour aYU;
    protected boolean closed;

    public b() {
        this(n.Qi());
    }

    private static String PJ() {
        return "IHDR";
    }

    private static String PK() {
        return "IEND";
    }

    private static void g(byte[] bArr) {
        if (Arrays.equals(bArr, n.Qi())) {
            return;
        }
        new PngjException("Bad signature:" + Arrays.toString(bArr));
    }

    public boolean B(int i, String str) {
        return false;
    }

    public boolean PG() {
        return true;
    }

    public final long PH() {
        return this.aYQ;
    }

    public final DeflatedChunksSet PI() {
        return this.aYR;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("This should not happen. Bad length: " + i2);
        }
        if (!this.aYN) {
            int i3 = this.aYK;
            int i4 = this.aYM;
            int i5 = i3 - i4;
            if (i5 <= i2) {
                i2 = i5;
            }
            System.arraycopy(bArr, i, this.aYL, i4, i2);
            int i6 = this.aYM + i2;
            this.aYM = i6;
            if (i6 == this.aYK) {
                g(this.aYL);
                this.aYM = 0;
                this.aYN = true;
            }
            int i7 = i2 + 0;
            this.aYQ += (long) i2;
            return i7;
        }
        ChunkReader chunkReader = this.aYS;
        if (chunkReader != null && !chunkReader.isDone()) {
            int iA = this.aYS.a(bArr, i, i2);
            if (iA < 0) {
                return -1;
            }
            int i8 = iA + 0;
            this.aYQ += (long) iA;
            return i8;
        }
        int i9 = this.aYM;
        int i10 = 8 - i9;
        if (i10 <= i2) {
            i2 = i10;
        }
        System.arraycopy(bArr, i, this.aYL, i9, i2);
        int i11 = this.aYM + i2;
        this.aYM = i11;
        int i12 = i2 + 0;
        this.aYQ += (long) i2;
        if (i11 != 8) {
            return i12;
        }
        this.aYP++;
        c(n.g(this.aYL, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aYL, 4), this.aYQ - 8);
        this.aYM = 0;
        return i12;
    }

    public void c(int i, String str, long j) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.baK.matcher(str).matches()) {
            new PngjException("Bad chunk id: " + str);
        }
        if (i < 0) {
            new PngjException("Bad chunk len: " + i);
        }
        if (str.equals("IDAT")) {
            this.aYT += (long) i;
        }
        boolean zPG = PG();
        boolean zB = B(i, str);
        boolean zGK = gK(str);
        DeflatedChunksSet deflatedChunksSet = this.aYR;
        boolean zGN = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aYR.gN(str);
        if (!zGK || zB) {
            this.aYS = a(str, i, j, zB);
        } else {
            if (!zGN) {
                DeflatedChunksSet deflatedChunksSet2 = this.aYR;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    new PngjException("new IDAT-like chunk when previous was not done");
                }
                this.aYR = gJ(str);
            }
            this.aYS = new d(i, str, zPG, j, this.aYR) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void PF() {
                    super.PF();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.aYS;
        if (chunkReader == null || zPG) {
            return;
        }
        chunkReader.bU(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aYR;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet gJ(String str);

    public boolean gK(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aYO;
    }

    private b(byte[] bArr) {
        this.aYL = new byte[8];
        this.aYM = 0;
        this.aYN = false;
        this.aYO = false;
        this.closed = false;
        this.aYP = 0;
        this.aYQ = 0L;
        this.aYU = ErrorBehaviour.STRICT;
        this.aYJ = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aYK = length;
        this.aYN = length <= 0;
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void PF() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i2, byte[] bArr, int i3, int i4) {
                new PngjException("should never happen");
            }
        };
    }

    public void a(ChunkReader chunkReader) {
        if (this.aYP == 1 && !PJ().equals(chunkReader.PE().asJ)) {
            String str = "Bad first chunk: " + chunkReader.PE().asJ + " expected: " + PJ();
            if (this.aYU.c < ErrorBehaviour.SUPER_LENIENT.c) {
                new PngjException(str);
            }
        }
        PK();
        if (chunkReader.PE().asJ.equals(PK())) {
            this.aYO = true;
            close();
        }
    }
}
