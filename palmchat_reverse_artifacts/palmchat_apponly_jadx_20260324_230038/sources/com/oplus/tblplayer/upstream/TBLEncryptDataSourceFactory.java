package com.oplus.tblplayer.upstream;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.utils.LogUtil;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLEncryptDataSourceFactory implements DataSource.Factory {
    private static final int DEFAULT_MAX_ENCRYPT_FILE_SIZE = 52428800;
    private static final String TAG = "TBLEncryptDataSourceFactory";
    private final byte[] encryptionIv;
    private final byte[] encryptionKey;
    private final String transformation;
    private final Uri uri;

    /* JADX INFO: compiled from: SearchBox */
    public static class EncryptDataException extends IOException {
        public EncryptDataException(Exception exc) {
            super(exc);
        }

        public EncryptDataException(String str) {
            super(str);
        }

        public EncryptDataException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public TBLEncryptDataSourceFactory(@NonNull Uri uri, String str, byte[] bArr, byte[] bArr2) {
        this.uri = uri;
        this.transformation = str;
        this.encryptionKey = bArr;
        this.encryptionIv = bArr2;
    }

    private int checkAndGetFileSize(@NonNull RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() <= 52428800) {
            return (int) randomAccessFile.length();
        }
        throw new EncryptDataException("Encrypted file size exceeds 50M limit.");
    }

    private byte[] decryptData(@NonNull byte[] bArr, String str, @NonNull byte[] bArr2, @NonNull byte[] bArr3) throws Exception {
        try {
            Cipher cipherInstance = getCipherInstance(str);
            try {
                cipherInstance.init(2, new SecretKeySpec((byte[]) Assertions.checkNotNull(bArr2), EncryptUtils.AES_ENCRYPT_ALGORITHM), new IvParameterSpec((byte[]) Assertions.checkNotNull(bArr3)));
                nonFlushingUpdate(cipherInstance, bArr, 0, bArr.length, bArr, 0);
                return bArr;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private byte[] decryptFile(@NonNull Uri uri, String str, @NonNull byte[] bArr, @NonNull byte[] bArr2) throws Exception {
        RandomAccessFile randomAccessFileOpenLocalFile = openLocalFile(uri);
        int iCheckAndGetFileSize = checkAndGetFileSize(randomAccessFileOpenLocalFile);
        byte[] bArr3 = new byte[iCheckAndGetFileSize];
        randomAccessFileOpenLocalFile.read(bArr3, 0, iCheckAndGetFileSize);
        randomAccessFileOpenLocalFile.close();
        return decryptData(bArr3, str, bArr, bArr2);
    }

    private Cipher getCipherInstance(String str) throws EncryptDataException, NoSuchPaddingException, NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            throw new EncryptDataException("Cipher transformation has not been initialized.");
        }
        return Cipher.getInstance(str);
    }

    private int nonFlushingUpdate(Cipher cipher, byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return cipher.update(bArr, i, i2, bArr2, i3);
        } catch (ShortBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static RandomAccessFile openLocalFile(@NonNull Uri uri) throws FileDataSource.FileDataSourceException {
        try {
            return new RandomAccessFile((String) Assertions.checkNotNull(uri.getPath()), t.k);
        } catch (FileNotFoundException e) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSource.FileDataSourceException(e);
            }
            throw new FileDataSource.FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
    @NonNull
    public DataSource createDataSource() {
        EncryptDataException encryptDataException;
        byte[] bArrDecryptFile = new byte[0];
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            bArrDecryptFile = decryptFile((Uri) Assertions.checkNotNull(this.uri), this.transformation, this.encryptionKey, this.encryptionIv);
            LogUtil.d(TAG, "Decrypt data source cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            encryptDataException = null;
        } catch (Exception e) {
            LogUtil.e(TAG, "Create data source caught a exception. " + e.getMessage());
            encryptDataException = e instanceof EncryptDataException ? (EncryptDataException) e : new EncryptDataException(e);
        }
        return new TBLEncryptDataSource(bArrDecryptFile, encryptDataException);
    }

    @SuppressLint({"LongLogTag"})
    public void finalize() throws Throwable {
        Log.d(TAG, "finalize: ");
        super.finalize();
    }
}
