package com.bytedance.pangle.util.nr.u;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private final byte[] u = new byte[2];
    private final byte[] nr = new byte[4];

    public int nr(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.u);
        return u(this.u);
    }

    public int u(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.nr);
        return nr(this.nr);
    }

    private int nr(byte[] bArr) {
        return ((((bArr[3] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE)) << 16) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] & UByte.MAX_VALUE) << 8);
    }

    public void u(RandomAccessFile randomAccessFile, int i) throws IOException {
        u(this.u, i);
        randomAccessFile.write(this.u);
    }

    private void nr(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    public void u(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        u(this.u, i);
        byteArrayOutputStream.write(this.u);
    }

    public void u(OutputStream outputStream, int i) throws IOException {
        nr(this.nr, i);
        outputStream.write(this.nr);
    }

    private int u(byte[] bArr) {
        return ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE);
    }

    private void u(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
