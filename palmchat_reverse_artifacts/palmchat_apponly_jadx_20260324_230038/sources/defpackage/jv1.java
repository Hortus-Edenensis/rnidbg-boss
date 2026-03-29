package defpackage;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class jv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f18514a = {0, 0, -92, -127};
    public static final byte[] b = {0, 0, -19, 65};

    public static void b(byte b2, int i, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (nt.a(b2, i)) {
            set.add(posixFilePermission);
        }
    }

    public static void c(Path path, byte[] bArr) {
        if (bArr[2] == 0 && bArr[3] == 0) {
            return;
        }
        try {
            HashSet hashSet = new HashSet();
            b(bArr[3], 0, hashSet, PosixFilePermission.OWNER_READ);
            b(bArr[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
            b(bArr[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
            b(bArr[2], 5, hashSet, PosixFilePermission.GROUP_READ);
            b(bArr[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
            b(bArr[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
            b(bArr[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
            b(bArr[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
            b(bArr[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions(path, hashSet);
        } catch (IOException unused) {
        }
    }

    public static void d(Path path, byte[] bArr) {
        if (bArr[0] == 0) {
            return;
        }
        DosFileAttributeView dosFileAttributeViewA = yu1.a(Files.getFileAttributeView(path, xu1.a(), LinkOption.NOFOLLOW_LINKS));
        try {
            dosFileAttributeViewA.setReadOnly(nt.a(bArr[0], 0));
            dosFileAttributeViewA.setHidden(nt.a(bArr[0], 1));
            dosFileAttributeViewA.setSystem(nt.a(bArr[0], 2));
            dosFileAttributeViewA.setArchive(nt.a(bArr[0], 5));
        } catch (IOException unused) {
        }
    }

    public static File[] e(File file) {
        final String strH = h(file.getName());
        File[] fileArrListFiles = file.getParentFile().listFiles(new FilenameFilter() { // from class: gv1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                return jv1.o(strH, file2, str);
            }
        });
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles);
        return fileArrListFiles;
    }

    public static String f(int i) {
        return i < 9 ? "00" : i < 99 ? "0" : "";
    }

    public static String g(File file) {
        String name = file.getName();
        return !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
    }

    public static String h(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public static String i(int i) {
        return "." + f(i) + (i + 1);
    }

    public static List<File> j(fr6 fr6Var) throws ZipException {
        if (fr6Var == null) {
            throw new ZipException("cannot get split zip files: zipmodel is null");
        }
        if (fr6Var.c() == null) {
            return null;
        }
        if (!fr6Var.f().exists()) {
            throw new ZipException("zip file does not exist");
        }
        ArrayList arrayList = new ArrayList();
        File fileF = fr6Var.f();
        if (!fr6Var.g()) {
            arrayList.add(fileF);
            return arrayList;
        }
        int iB = fr6Var.c().b();
        if (iB == 0) {
            arrayList.add(fileF);
            return arrayList;
        }
        int i = 0;
        while (i <= iB) {
            if (i == iB) {
                arrayList.add(fr6Var.f());
            } else {
                String str = i >= 9 ? ".z" : ".z0";
                arrayList.add(new File((fileF.getName().contains(".") ? fileF.getPath().substring(0, fileF.getPath().lastIndexOf(".")) : fileF.getPath()) + str + (i + 1)));
            }
            i++;
        }
        return arrayList;
    }

    public static boolean k() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean l(File file) {
        return file.getName().endsWith(".zip.001");
    }

    public static boolean m() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    public static boolean n() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static /* synthetic */ boolean o(String str, File file, String str2) {
        return str2.startsWith(str + ".");
    }

    public static void p(Path path, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (n()) {
            d(path, bArr);
        } else if (k() || m()) {
            c(path, bArr);
        }
    }

    public static void q(Path path, long j) {
        if (j <= 0 || !Files.exists(path, new LinkOption[0])) {
            return;
        }
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(wq6.d(j)));
        } catch (Exception unused) {
        }
    }

    public static void r(File file, long j) {
        file.setLastModified(wq6.d(j));
    }
}
