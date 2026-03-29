package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d44 extends ih5 {
    public d44(File file, boolean z, int i) throws FileNotFoundException {
        super(file, z, i);
    }

    @Override // defpackage.ih5
    public File b(int i) throws IOException {
        String canonicalPath = this.b.getCanonicalPath();
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + jv1.i(i));
    }
}
