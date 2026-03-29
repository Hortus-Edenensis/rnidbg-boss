package com.qiniu.android.http.dns;

import com.qiniu.android.storage.Recorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DnsCacheFile implements Recorder {
    public String directory;
    public File f;

    public DnsCacheFile(String str) throws IOException {
        if (str == null) {
            throw new IOException("directory invalid");
        }
        this.directory = str;
        File file = new File(str);
        this.f = file;
        if (!file.exists() && !this.f.mkdirs()) {
            throw new IOException("mkdir failed");
        }
        if (!this.f.isDirectory()) {
            throw new IOException("does not mkdir");
        }
    }

    public synchronized void clearCache() throws IOException {
        File file = this.f;
        if (file == null) {
            throw new IOException("directory invalid");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }

    @Override // com.qiniu.android.storage.Recorder
    public synchronized void del(String str) {
        if (str != null) {
            new File(this.directory, str).delete();
        }
    }

    @Override // com.qiniu.android.storage.Recorder
    public synchronized byte[] get(String str) {
        byte[] bArr;
        FileInputStream fileInputStream;
        int i;
        File file = new File(this.directory, str);
        if (!file.exists()) {
            return null;
        }
        try {
            bArr = new byte[(int) file.length()];
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
            bArr = null;
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
        return "dnsCache";
    }

    @Override // com.qiniu.android.storage.Recorder
    public synchronized void set(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        IOException e;
        File file = new File(this.directory, str);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
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
