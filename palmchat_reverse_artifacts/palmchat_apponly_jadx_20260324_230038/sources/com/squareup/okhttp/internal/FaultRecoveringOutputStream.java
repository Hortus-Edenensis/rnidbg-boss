package com.squareup.okhttp.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class FaultRecoveringOutputStream extends AbstractOutputStream {
    private final int maxReplayBufferLength;
    private OutputStream out;
    private ByteArrayOutputStream replayBuffer;

    public FaultRecoveringOutputStream(int i, OutputStream outputStream) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.maxReplayBufferLength = i;
        this.replayBuffer = new ByteArrayOutputStream(i);
        this.out = outputStream;
    }

    private boolean recover(IOException e) {
        OutputStream outputStream;
        if (this.replayBuffer == null) {
            return false;
        }
        while (true) {
            try {
                OutputStream outputStreamReplacementStream = replacementStream(e);
                if (outputStreamReplacementStream == null) {
                    return false;
                }
                try {
                    replaceStream(outputStreamReplacementStream);
                    return true;
                } catch (IOException e2) {
                    outputStream = outputStreamReplacementStream;
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                outputStream = null;
            }
            Util.closeQuietly(outputStream);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        do {
            try {
                this.out.close();
                this.closed = true;
                return;
            } catch (IOException e) {
            }
        } while (recover(e));
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        if (this.closed) {
            return;
        }
        do {
            try {
                this.out.flush();
                return;
            } catch (IOException e) {
            }
        } while (recover(e));
        throw e;
    }

    public boolean isRecoverable() {
        return this.replayBuffer != null;
    }

    public final void replaceStream(OutputStream outputStream) throws IOException {
        if (!isRecoverable()) {
            throw new IllegalStateException();
        }
        if (this.out == outputStream) {
            return;
        }
        this.replayBuffer.writeTo(outputStream);
        Util.closeQuietly(this.out);
        this.out = outputStream;
    }

    public abstract OutputStream replacementStream(IOException iOException) throws IOException;

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("stream closed");
        }
        Util.checkOffsetAndCount(bArr.length, i, i2);
        do {
            try {
                this.out.write(bArr, i, i2);
                ByteArrayOutputStream byteArrayOutputStream = this.replayBuffer;
                if (byteArrayOutputStream != null) {
                    if (byteArrayOutputStream.size() + i2 > this.maxReplayBufferLength) {
                        this.replayBuffer = null;
                        return;
                    } else {
                        this.replayBuffer.write(bArr, i, i2);
                        return;
                    }
                }
                return;
            } catch (IOException e) {
            }
        } while (recover(e));
        throw e;
    }
}
