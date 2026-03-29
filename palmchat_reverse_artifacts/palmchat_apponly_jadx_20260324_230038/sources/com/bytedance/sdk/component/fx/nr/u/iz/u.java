package com.bytedance.sdk.component.fx.nr.u.iz;

import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.l;
import com.bytedance.sdk.component.fx.u.sx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface u {
    public static final u u = new u() { // from class: com.bytedance.sdk.component.fx.nr.u.iz.u.1
        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public boolean b(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public sx fx(File file) throws FileNotFoundException {
            try {
                return l.fx(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.fx(file);
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public void iz(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    iz(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public sx nr(File file) throws FileNotFoundException {
            try {
                return l.nr(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.nr(file);
            }
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public long pn(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public bg u(File file) throws FileNotFoundException {
            return l.u(file);
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.iz.u
        public void u(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    boolean b(File file);

    void delete(File file) throws IOException;

    sx fx(File file) throws FileNotFoundException;

    void iz(File file) throws IOException;

    sx nr(File file) throws FileNotFoundException;

    long pn(File file);

    bg u(File file) throws FileNotFoundException;

    void u(File file, File file2) throws IOException;
}
