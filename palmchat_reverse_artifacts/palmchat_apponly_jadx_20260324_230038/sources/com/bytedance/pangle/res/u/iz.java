package com.bytedance.pangle.res.u;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class iz implements DataInput {
    public final a u;

    public iz(a aVar) {
        this.u = aVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.u.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.u.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.u.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.u.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.u.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.u.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.u.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.u.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.u.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.u.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.u.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.u.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.u.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.u.skipBytes(i);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.u.readFully(bArr);
    }
}
