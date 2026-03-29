package com.baidu.b.f;

import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static String a(File file) throws Throwable {
        FileReader fileReader;
        char[] cArr;
        CharArrayWriter charArrayWriter;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    cArr = new char[8192];
                    charArrayWriter = new CharArrayWriter();
                } catch (Exception e) {
                    e = e;
                    a(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e2) {
                            a(e2);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
            }
        } catch (Exception e3) {
            e = e3;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            int i = fileReader.read(cArr);
            if (i <= 0) {
                break;
            }
            charArrayWriter.write(cArr, 0, i);
            th = th;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Exception e4) {
                    a(e4);
                }
            }
            throw th;
        }
        String string = charArrayWriter.toString();
        try {
            fileReader.close();
        } catch (Exception e5) {
            a(e5);
        }
        return string;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                a(e);
            }
        }
    }

    public static void a(Throwable th) {
    }
}
