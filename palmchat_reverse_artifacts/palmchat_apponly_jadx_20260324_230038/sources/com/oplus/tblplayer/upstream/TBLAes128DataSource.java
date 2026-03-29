package com.oplus.tblplayer.upstream;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.utils.LogUtil;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLAes128DataSource implements DataSource {
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private static final String TAG = "TBLAes128DataSource";

    @Nullable
    private CipherInputStream cipherInputStream;
    private final byte[] encryptionIv;
    private final byte[] encryptionKey;
    private final DataSource upstream;
    private final byte[] scratchSpace = new byte[4096];
    private long nextLoadPosition = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements DataSource.Factory {
        private final byte[] encryptionIv;
        private final byte[] encryptionKey;
        private final DataSource.Factory upstreamFactory;

        public Factory(DataSource.Factory factory, byte[] bArr, byte[] bArr2) {
            this.upstreamFactory = factory;
            this.encryptionKey = bArr;
            this.encryptionIv = bArr2;
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
        public TBLAes128DataSource createDataSource() {
            return new TBLAes128DataSource(this.upstreamFactory.createDataSource(), this.encryptionKey, this.encryptionIv);
        }
    }

    public TBLAes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.upstream = dataSource;
        this.encryptionKey = bArr;
        this.encryptionIv = bArr2;
    }

    private int readInternal(@NonNull byte[] bArr, int i, int i2) throws IOException {
        Assertions.checkNotNull(this.cipherInputStream);
        int i3 = this.cipherInputStream.read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    private long skipFully(long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            int internal = readInternal(this.scratchSpace, 0, (int) Math.min(j - j2, this.scratchSpace.length));
            if (internal == -1) {
                return -1L;
            }
            j2 += (long) internal;
        }
        return j2;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    public final void addTransferListener(@NonNull TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() throws IOException {
        this.nextLoadPosition = 0L;
        if (this.cipherInputStream != null) {
            this.cipherInputStream = null;
            this.upstream.close();
        }
    }

    public Cipher getCipherInstance() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public final Map<String, List<String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    @Nullable
    public final Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public final long open(@NonNull DataSpec dataSpec) throws IOException {
        if (dataSpec.position != 0) {
            LogUtil.w(TAG, "The starting location is specified when opening the file.");
            this.nextLoadPosition = dataSpec.position;
            dataSpec = dataSpec.buildUpon().setPosition(0L).build();
        }
        try {
            Cipher cipherInstance = getCipherInstance();
            try {
                cipherInstance.init(2, new SecretKeySpec(this.encryptionKey, EncryptUtils.AES_ENCRYPT_ALGORITHM), new IvParameterSpec(this.encryptionIv));
                DataSourceInputStream2 dataSourceInputStream2 = new DataSourceInputStream2(this.upstream, dataSpec);
                this.cipherInputStream = new CipherInputStream(dataSourceInputStream2, cipherInstance);
                long jOpen = dataSourceInputStream2.open();
                if (jOpen <= 0) {
                    return -1L;
                }
                return jOpen;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public final int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        if (this.nextLoadPosition > 0) {
            LogUtil.w(TAG, "Skip to the specified position before reading the data.");
            if (skipFully(this.nextLoadPosition) < 0) {
                return -1;
            }
            this.nextLoadPosition = 0L;
        }
        return readInternal(bArr, i, i2);
    }
}
