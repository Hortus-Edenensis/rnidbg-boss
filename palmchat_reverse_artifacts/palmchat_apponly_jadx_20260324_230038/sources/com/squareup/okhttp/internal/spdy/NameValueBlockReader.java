package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class NameValueBlockReader implements Closeable {
    private int compressedLimit;
    private final FillableInflaterInputStream fillableInflaterInputStream;
    private final DataInputStream nameValueBlockIn;

    /* JADX INFO: compiled from: SearchBox */
    public static class FillableInflaterInputStream extends InflaterInputStream {
        public FillableInflaterInputStream(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
        }

        @Override // java.util.zip.InflaterInputStream
        public void fill() throws IOException {
            super.fill();
        }
    }

    public NameValueBlockReader(final InputStream inputStream) {
        FillableInflaterInputStream fillableInflaterInputStream = new FillableInflaterInputStream(new InputStream() { // from class: com.squareup.okhttp.internal.spdy.NameValueBlockReader.1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                return Util.readSingleByte(this);
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = inputStream.read(bArr, i, Math.min(i2, NameValueBlockReader.this.compressedLimit));
                NameValueBlockReader.this.compressedLimit -= i3;
                return i3;
            }
        }, new Inflater() { // from class: com.squareup.okhttp.internal.spdy.NameValueBlockReader.2
            @Override // java.util.zip.Inflater
            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int iInflate = super.inflate(bArr, i, i2);
                if (iInflate != 0 || !needsDictionary()) {
                    return iInflate;
                }
                setDictionary(Spdy3.DICTIONARY);
                return super.inflate(bArr, i, i2);
            }
        });
        this.fillableInflaterInputStream = fillableInflaterInputStream;
        this.nameValueBlockIn = new DataInputStream(fillableInflaterInputStream);
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit == 0) {
            return;
        }
        this.fillableInflaterInputStream.fill();
        if (this.compressedLimit == 0) {
            return;
        }
        throw new IOException("compressedLimit > 0: " + this.compressedLimit);
    }

    private String readString() throws DataFormatException, IOException {
        int i = this.nameValueBlockIn.readInt();
        byte[] bArr = new byte[i];
        Util.readFully(this.nameValueBlockIn, bArr);
        return new String(bArr, 0, i, "UTF-8");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nameValueBlockIn.close();
    }

    public List<String> readNameValueBlock(int i) throws IOException {
        this.compressedLimit += i;
        try {
            int i2 = this.nameValueBlockIn.readInt();
            if (i2 < 0) {
                throw new IOException("numberOfPairs < 0: " + i2);
            }
            if (i2 > 1024) {
                throw new IOException("numberOfPairs > 1024: " + i2);
            }
            ArrayList arrayList = new ArrayList(i2 * 2);
            for (int i3 = 0; i3 < i2; i3++) {
                String string = readString();
                String string2 = readString();
                if (string.length() == 0) {
                    throw new IOException("name.length == 0");
                }
                arrayList.add(string);
                arrayList.add(string2);
            }
            doneReading();
            return arrayList;
        } catch (DataFormatException e) {
            throw new IOException(e.getMessage());
        }
    }
}
