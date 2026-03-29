package com.qiniu.android.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class FileRecorder implements Recorder {
    public String directory;

    public FileRecorder(String str) throws IOException {
        this.directory = str;
        File file = new File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("does not mkdir");
            }
        } else if (!file.mkdirs()) {
            throw new IOException("mkdir failed");
        }
    }

    private static String hash(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toString((b & UByte.MAX_VALUE) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean outOfDate(File file) {
        return file.lastModified() + 172800000 < new Date().getTime();
    }

    @Override // com.qiniu.android.storage.Recorder
    public void del(String str) {
        new File(this.directory, hash(str)).delete();
    }

    @Override // com.qiniu.android.storage.Recorder
    public byte[] get(String str) {
        byte[] bArr;
        FileInputStream fileInputStream;
        int i;
        File file = new File(this.directory, hash(str));
        try {
        } catch (IOException e) {
            e = e;
            bArr = null;
            fileInputStream = null;
        }
        if (outOfDate(file)) {
            file.delete();
            return null;
        }
        bArr = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        }
        try {
            i = fileInputStream.read(bArr);
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            i = 0;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (i == 0) {
            return null;
        }
        return bArr;
    }

    @Override // com.qiniu.android.storage.Recorder
    public String getFileName() {
        return null;
    }

    @Override // com.qiniu.android.storage.Recorder
    public void set(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        IOException e;
        if (str == null) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(this.directory, hash(str)));
        } catch (IOException e2) {
            fileOutputStream = null;
            e = e2;
        }
        try {
            fileOutputStream.write(bArr);
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }
}
