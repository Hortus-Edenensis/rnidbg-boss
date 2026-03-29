package cn.fly.verify;

import android.app.ActivityManager;
import android.app.Application;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import cn.fly.verify.fq;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.matrix.plugin.PluginShareConstants;
import defpackage.x43;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eq {
    private static eq b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2252a;

    private eq(Context context) {
        this.f2252a = context.getApplicationContext();
    }

    public static synchronized eq a(Context context) {
        if (b == null && context != null) {
            b = new eq(context);
        }
        return b;
    }

    private boolean aA() {
        try {
            return ((Boolean) fy.a(fy.a(ed.a("016de2dcdjeddidcfdedfhfdfkBfPfedgee")), ed.a("019^difhfk7f6fedgeeee7f<djgkedZeefcifKdc"), new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private String as() {
        try {
            return fr.b(fr.a(((Object) null) + ":" + ((Object) null) + ":" + er.a(this.f2252a).d().l()));
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    private String at() {
        HashMap map;
        HashMap<String, Object> mapAu = au();
        if (mapAu == null || (map = (HashMap) mapAu.get(ed.a("010Ldc4fEdddiPcf!ei$eSefed"))) == null) {
            return null;
        }
        try {
            return fr.b(fr.a(((Object) null) + ":" + ((Object) null) + ":" + ((String) map.get(ed.a("005(dfeddc6fg")))));
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    private HashMap<String, Object> au() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        HashMap<String, Object> mapA;
        File fileA = fz.a(this.f2252a, ed.a("014cAeddfdfOl dcfefh4l'fddcdgdidc"), true);
        if (fileA.exists() && fileA.length() > 0) {
            try {
                fileInputStream = new FileInputStream(fileA);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (Throwable unused) {
                    objectInputStream = null;
                }
            } catch (Throwable unused2) {
                fileInputStream = null;
                objectInputStream = null;
            }
            try {
                mapA = (HashMap) objectInputStream.readObject();
                eg.a(objectInputStream, fileInputStream);
            } catch (Throwable unused3) {
                eg.a(objectInputStream, fileInputStream);
                mapA = null;
            }
            if (mapA == null || mapA.isEmpty()) {
                mapA = a(fileA);
            }
            if (!mapA.isEmpty()) {
                return (HashMap) mapA.get(ed.a("010WdcIf<dddiLcf3eiBeHefed"));
            }
        }
        return null;
    }

    private String av() {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        File fileA;
        File file = new File(t(), ed.a("008Mej!hdNdjJf(ejfkic"));
        if (file.exists()) {
            File file2 = new File(file, ed.a("003@fddcdl"));
            if (file2.exists() && (fileA = fz.a(this.f2252a, ed.a("003Xfddcdl"))) != null && file2.renameTo(fileA)) {
                file2.delete();
            }
        }
        File fileA2 = fz.a(this.f2252a, ed.a("003_fddcdl"));
        String strValueOf = null;
        if (fileA2 != null && !fileA2.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileA2);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    if (object != null && (object instanceof char[])) {
                        strValueOf = String.valueOf((char[]) object);
                    }
                    eg.a(objectInputStream, fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    try {
                        en.a().a(th);
                        eg.a(objectInputStream, fileInputStream);
                    } catch (Throwable th2) {
                        eg.a(objectInputStream, fileInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            fileInputStream = null;
        }
        return strValueOf;
    }

    private HashMap<String, String> aw() {
        try {
            return (HashMap) fz.a(fz.b(this.f2252a, ed.a("004AfdEdeWfh")).getAbsolutePath());
        } catch (Throwable th) {
            en.a().b(th);
            fz.b(this.f2252a, ed.a("004=fdRde4fh")).delete();
            return null;
        }
    }

    private Set<String> ax() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Object objC;
        HashSet hashSet = new HashSet();
        if (Cdo.b() && !ed.a("0052df?f;digcdg").equalsIgnoreCase(c()) && ez.a()) {
            try {
                try {
                    objC = eg.c(ed.a("016j]dfifSgPdifhUiLifOjdc8dl^d@ee+f@fh"));
                    try {
                        inputStream = (InputStream) fy.a(objC, ed.a("014-eeXfi!ei!ejEdgFi%ej>iZdj1fdNdf"), new Object[0]);
                        try {
                            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        String strTrim = line.trim();
                                        if (strTrim.length() > 8 && strTrim.substring(0, 8).equalsIgnoreCase(ed.a("008jdcBdlRd[ee)fk"))) {
                                            String strTrim2 = strTrim.substring(8).trim();
                                            if (!TextUtils.isEmpty(strTrim2)) {
                                                hashSet.add(strTrim2);
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            en.a().b(th);
                                            eg.a(bufferedReader, inputStreamReader, inputStream);
                                            if (objC != null) {
                                                fy.a(objC, ed.a("007*dc<f]fh<iTdjeddk"), new Object[0]);
                                            }
                                            return hashSet;
                                        } catch (Throwable th3) {
                                            eg.a(bufferedReader, inputStreamReader, inputStream);
                                            if (objC != null) {
                                                try {
                                                    fy.a(objC, ed.a("007*dc<f]fh<iTdjeddk"), new Object[0]);
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            throw th3;
                                        }
                                    }
                                }
                                eg.a(bufferedReader, inputStreamReader, inputStream);
                            } catch (Throwable th4) {
                                bufferedReader = null;
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            bufferedReader = null;
                            th = th5;
                            inputStreamReader = null;
                        }
                    } catch (Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th = th6;
                        inputStream = null;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th7) {
                inputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                th = th7;
                objC = null;
            }
            if (objC != null) {
                fy.a(objC, ed.a("007*dc<f]fh<iTdjeddk"), new Object[0]);
            }
        }
        return hashSet;
    }

    private Set<String> ay() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Object objC;
        HashSet hashSet = new HashSet();
        if (Cdo.b()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    objC = eg.c(ed.a("032cGdfdcifXjdcQdl%d.ee?fIifdedgEf!djdkhk)dci^didddi+iSdi3f4fhifhk.d9if") + ed.a("026de[dcdjeddidcfddi9eifei'fd)dciVdied'e@fdhceleieh") + " " + ed.a("0083hkhkdgfh'fAdjiffg"));
                    try {
                        inputStream = (InputStream) fy.a(objC, ed.a("014Ree8fi=ei9ejXdg!i1ej=i-djNfd=df"), new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader);
                                    try {
                                        String strA = ed.a("012jdc+dl<d2ee$f7eh]d[df(fWii");
                                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                            String strTrim = line.trim();
                                            if (strTrim.length() > strA.length() && strTrim.substring(0, strA.length()).equalsIgnoreCase(strA)) {
                                                String strTrim2 = strTrim.substring(strA.length()).trim();
                                                if (!TextUtils.isEmpty(strTrim2)) {
                                                    hashSet.add(strTrim2);
                                                }
                                            }
                                        }
                                        bufferedReader2 = bufferedReader;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            en.a().b(th);
                                            eg.a(bufferedReader, inputStreamReader, inputStream);
                                            if (objC != null) {
                                                fy.a(objC, ed.a("007Ldc f=fhJiAdjeddk"), new Object[0]);
                                            }
                                            return hashSet;
                                        } catch (Throwable th3) {
                                            eg.a(bufferedReader, inputStreamReader, inputStream);
                                            if (objC != null) {
                                                try {
                                                    fy.a(objC, ed.a("007Ldc f=fhJiAdjeddk"), new Object[0]);
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    bufferedReader = null;
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                bufferedReader = null;
                                th = th5;
                                inputStreamReader = null;
                            }
                        } else {
                            inputStreamReader = null;
                        }
                        eg.a(bufferedReader2, inputStreamReader, inputStream);
                    } catch (Throwable th6) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th = th6;
                        inputStream = null;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th7) {
                inputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                th = th7;
                objC = null;
            }
            if (objC != null) {
                fy.a(objC, ed.a("007Ldc f=fhJiAdjeddk"), new Object[0]);
            }
        }
        return hashSet;
    }

    private Set<String> az() {
        HashSet hashSet = new HashSet();
        if (Cdo.b()) {
            for (int i = 10000; i <= 13000; i++) {
                String[] strArr = (String[]) fy.a(this.f2252a.getPackageManager(), "getPackagesForUid", new Object[]{Integer.valueOf(i)}, (Class<?>[]) new Class[]{Integer.TYPE}, (Object) null);
                if (strArr != null && !TextUtils.isEmpty(strArr[0]) && !strArr[0].startsWith(ed.a("035cSeddffdeeededee4gf%fdBde)dcdjeddidcfdRi0djdi chNdjeddf)fg[difedjDd djdk"))) {
                    hashSet.add(strArr[0]);
                }
            }
        }
        return hashSet;
    }

    private int b(Context context) {
        String strY = Y();
        if (TextUtils.isEmpty(strY)) {
            return -1;
        }
        return strY.equals(fd.f(er.a(context).d().a(o(), 0), o())) ? 1 : 0;
    }

    public static Context x() {
        return eg.a();
    }

    public boolean A() {
        Object objA;
        if (Cdo.d() && az.a().e() && fq.d.b(ed.a("036deJdcdjeddidcfdQjfDdjdfdifhfhdied;e+fdgkfjelehidghdhgeeifleidhejekelekgh")) && (objA = fq.d.a(ed.a("004;ffdiefdi"))) != null) {
            return ((Boolean) fy.a(objA, ed.a("009$fh;idAdjUi!ejMcde"), Boolean.FALSE, new Object[0])).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        r3.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if (r5 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, Object> B() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList arrayList;
        HashMap<String, Object> map = new HashMap<>();
        try {
            fileReader = new FileReader(ed.a("013ljNdjedHclcjBdgdiMe:efed"));
            bufferedReader = new BufferedReader(fileReader);
            arrayList = new ArrayList();
            map.put(ed.a("010j7djedCcfSfhfheddjfh"), arrayList);
        } catch (Throwable th) {
            en.a().a(th);
        }
        loop0: while (true) {
            HashMap map2 = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break loop0;
                }
                if (TextUtils.isEmpty(line)) {
                    break;
                }
                String strTrim = line.trim();
                if (strTrim.startsWith(ed.a("009j+djed>cf_fhfheddj"))) {
                    if (map2 != null) {
                        arrayList.add(map2);
                    }
                    map2 = new HashMap();
                }
                String[] strArrSplit = strTrim.split(":");
                if (strArrSplit.length > 1) {
                    if (map2 == null) {
                        map.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                    } else {
                        map2.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                    }
                }
            }
            return map;
        }
        bufferedReader.close();
        fileReader.close();
        return map;
    }

    public ArrayList<ArrayList<String>> C() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                FileReader fileReader = new FileReader(ed.a("017lj'djed.cliiAdk_lMdcdjdiddHfRdjfh"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(line)) {
                        String[] strArrSplit = line.trim().split(" ");
                        if (strArrSplit.length > 1) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (String str : strArrSplit) {
                                if (!TextUtils.isEmpty(str)) {
                                    arrayList2.add(str.trim());
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                en.a().a(th.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    public String D() {
        String strA = et.a(this.f2252a).a(ed.a("014Idjedfddl^f1djZefgQfddeQf@dfdg"), "0");
        return strA == null ? "0" : strA;
    }

    public HashMap<String, HashMap<String, Long>> E() {
        HashMap<String, HashMap<String, Long>> map = new HashMap<>();
        String[] strArr = {ed.a("0069fhdc%cdPdjdc"), ed.a("004*dc^did")};
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            HashMap<String, Long> map2 = new HashMap<>();
            map2.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, -1L);
            map2.put(ed.a("004Jefdj+ff"), -1L);
            map2.put(ed.a("005iPedZidg"), -1L);
            map.put(str, map2);
        }
        HashMap map3 = new HashMap();
        String strT = t();
        if (strT != null) {
            map3.put(ed.a("006Lfhdc>cdIdjdc"), new StatFs(strT));
        }
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory != null) {
            map3.put(ed.a("004Wdc<did"), new StatFs(dataDirectory.getPath()));
        }
        for (Map.Entry entry : map3.entrySet()) {
            StatFs statFs = (StatFs) entry.getValue();
            long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            long freeBlocksLong = statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
            HashMap<String, Long> map4 = map.get(entry.getKey());
            map4.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, Long.valueOf(availableBlocksLong));
            map4.put(ed.a("004Sefdj=ff"), Long.valueOf(freeBlocksLong));
            map4.put(ed.a("005iYed^idg"), Long.valueOf(blockCountLong));
        }
        return map;
    }

    public HashMap<String, Long> F() {
        HashMap<String, Long> map = new HashMap<>();
        map.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, -1L);
        map.put(ed.a("005iDedWidg"), -1L);
        map.put(ed.a("005!difhfcedff"), -1L);
        map.put(ed.a("009ih dj=fSfh)h5ed<gQdc"), -1L);
        Object objA = fq.d.a(ed.a("008dciUdidddi_i^dk"));
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        fy.a(objA, ed.a("013?ee!fi0hcNfHdfeddjdkei,e8efed"), (Object) null, memoryInfo);
        map.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, Long.valueOf(memoryInfo.availMem));
        map.put(ed.a("005iGedYidg"), Long.valueOf(memoryInfo.totalMem));
        map.put(ed.a("005Ddifhfcedff"), Long.valueOf(memoryInfo.lowMemory ? 1L : 0L));
        map.put(ed.a("009ih6dj fRfhLhUed4gFdc"), Long.valueOf(memoryInfo.threshold));
        return map;
    }

    public String G() {
        return gg.a().b();
    }

    public boolean H() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArr = {ed.a("020c)eddffd0i8edLjYhged6he:ffdgfddf;d_eedifhdl"), ed.a("024Ndiedfdeedi(ihTdgfefd5hKdgfhdldkdceefddfXd(eedifhdl"), ed.a("032^dc,fFfddjedfeddfd+de7dcdjeddidcfdecDj8edfh[f4dcfddiKeCfhGidggf!dj"), ed.a("028IeddjeefddfYf!edff-cdiOfdPf7dcecKj!edfh*fNdcfddf1ded7eeBfBdj"), ed.a("0273dfedUf-fdfhLhJdigcdgdldgfddjSfWdcdidjAfciNfh<iYeddjOd=eeYf"), ed.a("018;df)f0fdff2fGdifhJhUdgfddl4fJdj*efg>fhdg"), ed.a("027>diedfdeediSih9dgfefdddddfehefghhfgfddf=dhTedfhZh=edhged"), ed.a("0132fjededdlfdgddidggedgfdgfTj"), "club.youppgd.adhook", ed.a("027^diXc%dgfd%e7dg:ggji=djfdHdjjg)difh[i-dc fifciEeddj"), ed.a("0326diedfdeedi0ih)dgfefdVh<dgfhdldkdceefddf]fVdfeddjdkdc+fifci1eddj"), ed.a("034cOeddffdeedi.ih=dgfefd:cdjei3djdi8j7fhfddl0f=djHefg1efVgdIfhNhf<dj")};
        for (int i = 0; i < 12; i++) {
            if (er.a(this.f2252a).d().a(strArr[i], 0) != null) {
                return true;
            }
        }
        try {
            throw new Exception("msk");
        } catch (Throwable th2) {
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(ed.a("035<dc;fWfddjedfeddfd<de>dcdjeddidcfdecPj edfhZf*dcfdgf jKedfh!fXdcfidjdidcee?f"))) {
                    return true;
                }
            }
            try {
                try {
                    ClassLoader.getSystemClassLoader().loadClass(ed.a("036Ndc f2fddjedfeddfd=deAdcdjeddidcfdecTj7edfh3fCdcfdgf1j[edfh5f8dcfj9fgjf,djfh")).newInstance();
                    try {
                        ClassLoader.getSystemClassLoader().loadClass(ed.a("0355dc@f;fddjedfeddfdDde^dcdjeddidcfdec=j'edfh!f*dcfdgfVj>edfh;fEdcfidjdidceeHf")).newInstance();
                    } catch (IllegalAccessException | InstantiationException unused) {
                    }
                    return true;
                } catch (IllegalAccessException | InstantiationException unused2) {
                    return true;
                }
            } catch (Throwable unused3) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(ed.a("006lj6djed4cl") + Process.myPid() + ed.a("005l dfSdj9fh")));
                    boolean zContains = false;
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null || zContains) {
                                break;
                            }
                            zContains = line.toLowerCase().contains(ed.a("006!ec3j1edfhGf*dc"));
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                en.a().a(th);
                                eg.a(bufferedReader);
                                return false;
                            } catch (Throwable th4) {
                                eg.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    eg.a(bufferedReader);
                    return zContains;
                } catch (Throwable th5) {
                    bufferedReader = null;
                    th = th5;
                }
            }
        }
    }

    public boolean I() {
        return (this.f2252a.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean J() {
        try {
            return Settings.Secure.getInt(this.f2252a.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean K() {
        try {
            return Settings.Secure.getInt(this.f2252a.getContentResolver(), "development_settings_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean L() {
        Intent intentA = eg.a((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentA != null && intentA.getIntExtra("plugged", -1) == 2;
    }

    public boolean M() {
        return false;
    }

    public boolean N() {
        ApplicationInfo applicationInfoA = er.a(this.f2252a).d().a(false, fq.d.c(), 1);
        return (applicationInfoA == null || (applicationInfoA.flags & 2) == 0) ? false : true;
    }

    public boolean O() {
        int i;
        try {
            String property = System.getProperty(ed.a("014hiijCfd2j<djedecdkfjedfh=i"));
            String property2 = System.getProperty(ed.a("014hiij9fdUj4djedecdkgleddjQi"));
            if (property2 == null) {
                property2 = "-1";
            }
            try {
                i = Integer.parseInt(property2);
            } catch (Throwable unused) {
                i = -1;
            }
            return (TextUtils.isEmpty(property) || i == -1) ? false : true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public boolean P() {
        return (Build.VERSION.SDK_INT >= 29) && (er.a(this.f2252a).d().ak().targetSdkVersion >= 29);
    }

    public String Q() {
        try {
            String id = TimeZone.getDefault().getID();
            if (!TextUtils.isEmpty(id)) {
                return id;
            }
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(this.f2252a.getContentResolver(), configuration);
            Locale locale = configuration.locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            return Calendar.getInstance(locale).getTimeZone().getID();
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    public String R() {
        return er.a(this.f2252a).d().a(ed.a("015$djedfdfedgdi3g;dcfdef.gdNddeddj"));
    }

    public String S() {
        return er.a(this.f2252a).d().a(ed.a("020Xeefhdffddd[f'djfhdiedBe?fdfeLdLfhKf^fe;de)dc"));
    }

    public String T() {
        return er.a(this.f2252a).d().a(ed.a("016Xdjedfd[jOdjeddcdgMci+fdfeedOd$djdc"));
    }

    public String U() {
        return er.a(this.f2252a).d().a(ed.a("017'djedfdfeed3dAdjdcfd4jgdiEefeddjdf"));
    }

    public int V() {
        if (Cdo.h()) {
            return fx.a(this.f2252a).b();
        }
        return -1;
    }

    public String W() {
        return Build.BRAND;
    }

    public boolean X() {
        return b(this.f2252a) != 0;
    }

    public String Y() {
        String processName = "";
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
            } else {
                Method declaredMethod = Class.forName(ed.a("026de4dcdjeddidcfd6djjLfdel.ci]didddiMi<dkekZhBdjGfd*dc"), false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                if (objInvoke instanceof String) {
                    processName = (String) objInvoke;
                }
            }
        } catch (Throwable th) {
            en.a().a("getProcessName: " + th, new Object[0]);
        }
        return processName;
    }

    public long Z() {
        Object objB = er.a(this.f2252a).d().b(false, 0, o(), 0);
        if (objB != null) {
            return fd.e(objB, fq.d.c());
        }
        return 0L;
    }

    public String aa() {
        return Build.DEVICE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ab() {
        Object objC;
        InputStream inputStream;
        ?? bufferedReader;
        String line;
        ?? r7;
        try {
            objC = eg.c(ed.a("021cdi1if(lj,djedDcl1fhOfg7ef4lc3eedjeddg[j"));
            try {
                inputStream = (InputStream) fy.a(objC, ed.a("014=ee=fiIeiFej?dg8iSejViKdj]fd=df"), (Object) null, new Object[0]);
                if (inputStream != null) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = 0;
                    }
                    try {
                        line = bufferedReader.readLine();
                        r7 = bufferedReader;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            en.a().a(th);
                            eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                            if (objC != null) {
                            }
                        } catch (Throwable th3) {
                            eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                            if (objC != null) {
                                fy.a(objC, ed.a("0073dc!f7fhGiPdjeddk"), (Object) null, new Object[0]);
                            }
                            throw th3;
                        }
                    }
                } else {
                    r7 = 0;
                    line = null;
                }
                eg.a((Closeable[]) new Closeable[]{r7, inputStream});
                if (objC != null) {
                    fy.a(objC, ed.a("0073dc!f7fhGiPdjeddk"), (Object) null, new Object[0]);
                }
                return line;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = inputStream;
                en.a().a(th);
                eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    return null;
                }
                fy.a(objC, ed.a("0073dc!f7fhGiPdjeddk"), (Object) null, new Object[0]);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            objC = null;
            inputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ac() {
        Object objC;
        InputStream inputStream;
        ?? bufferedReader;
        try {
            objC = eg.c(ed.a("017cdiGif'lj7djed<clcjCdgdi7eLefed"));
            try {
                inputStream = (InputStream) fy.a(objC, ed.a("014Gee^fi!ei%ejQdg;i>ej i@dj[fdWdf"), (Object) null, new Object[0]);
                if (inputStream == null) {
                    eg.a(null, inputStream);
                    if (objC == null) {
                        return "";
                    }
                    fy.a(objC, ed.a("007)dcNf1fh:iWdjeddk"), (Object) null, new Object[0]);
                    return "";
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                en.a().a(th);
                                eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                if (objC != null) {
                                }
                            } catch (Throwable th2) {
                                eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                if (objC != null) {
                                    fy.a(objC, ed.a("007)dcNf1fh:iWdjeddk"), (Object) null, new Object[0]);
                                }
                                throw th2;
                            }
                        }
                    }
                    bufferedReader.close();
                    String lowerCase = stringBuffer.toString().toLowerCase();
                    eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                    if (objC != null) {
                        fy.a(objC, ed.a("007)dcNf1fh:iWdjeddk"), (Object) null, new Object[0]);
                    }
                    return lowerCase;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = inputStream;
                en.a().a(th);
                eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    return "";
                }
                fy.a(objC, ed.a("007)dcNf1fh:iWdjeddk"), (Object) null, new Object[0]);
                return "";
            }
        } catch (Throwable th5) {
            th = th5;
            objC = null;
            inputStream = null;
        }
    }

    public String ad() {
        return ca.c(this.f2252a);
    }

    public HashMap<String, Object> ae() {
        return ca.a(this.f2252a);
    }

    public long af() {
        return Build.TIME;
    }

    public double ag() {
        return fz.e(this.f2252a);
    }

    public int ah() {
        return fz.f(this.f2252a);
    }

    public boolean ai() {
        return ed.a("0078fj-dPdjdfed.eQdk").equalsIgnoreCase((String) fy.a(fy.a(ed.a("025c8eddffdKhBdg1dNffRfFdifdfhdkfh,if*dffdfidgdi.g3dcghec"), (String) null), ed.a("010BeeFfiCggfhfidj5de!dc"), (Object) null, new Object[0]));
    }

    public String aj() {
        return er.a(this.f2252a).d().a(ed.a("028hHffdhfh5cVfdfedgdi)gBdcfd-jgdi0efeddjdffdddIfGdjfhdiedYe"));
    }

    public String ak() {
        String strGroup = null;
        try {
            String strAq = er.a(this.f2252a).d().aq();
            String strA = er.a(this.f2252a).d().a("ro.build.ver.physical");
            if (!TextUtils.isEmpty(strA) && strA.contains(strAq)) {
                Matcher matcher = Pattern.compile(strAq + "(\\.\\d+)?").matcher(strA);
                while (matcher.find()) {
                    strGroup = matcher.group();
                }
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
        return strGroup;
    }

    public int al() {
        try {
            return Settings.Secure.getInt(this.f2252a.getContentResolver(), ed.a("015j(dgdj(f-dhdfeddc>fQdhfhXidif"));
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public int am() {
        try {
            return Settings.Secure.getInt(this.f2252a.getContentResolver(), ed.a("024jMdgdjYf5dhGfehdecf$dcdhdfeddc)fFdhfh2idif"));
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public Object an() {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int i;
        int iIntValue4;
        int iIntValue5;
        int i2;
        Object objA;
        HashMap map = null;
        if (Cdo.g()) {
            Object objA2 = az.a().f() ? (!fq.d.b(ed.a("041de>dcdjeddidcfd@jfQdjdfdifhfhdied_e8fdelgkgkghejejdhgkggelgiejghdhfcgggkelekeiggeh")) || (objA = fq.d.a(ed.a("005jhYed1ef"))) == null) ? null : fy.a(objA, ed.a("015Dee@fiQgkTfggKfced?cdiSdiedBe"), (Object) null, new Object[0]) : az.a().n();
            if (objA2 != null) {
                map = new HashMap();
                int i3 = -1;
                if (ed.a("0163gkdcdf;dZgkYfgg(fcedDcdi7died1e").equals(objA2.getClass().getSimpleName())) {
                    map.put(ed.a("016Ggkdcdf(d'gkJfgg+fced=cdi$died<e"), 1);
                    int iIntValue6 = ((Integer) fz.a(fy.a(objA2, ed.a("022Tee3fi;fi.dGfh[f:ej-idi[diedDe(fcAdi<di>i*dgdc8f"), -1, new Object[0]), -1)).intValue();
                    int iIntValue7 = ((Integer) fz.a(fy.a(objA2, ed.a("023LeeAfiXfiBdTfh2fBej(idiBdiedOe;fcedUe2eedi*iPdgdc6f"), -1, new Object[0]), -1)).intValue();
                    iIntValue4 = ((Integer) fz.a(fy.a(objA2, ed.a("016Aee>fiEfiHd;fh$fCej)idiJdied,e;eidc"), -1, new Object[0]), -1)).intValue();
                    iIntValue5 = ((Integer) fz.a(fy.a(objA2, ed.a("011]eeHfi,ejdkfh]if-dfeidc"), -1, new Object[0]), -1)).intValue();
                    iIntValue3 = ((Integer) fz.a(fy.a(objA2, ed.a("012)eeLfiAehKfiBffeddjdleidc"), -1, new Object[0]), -1)).intValue();
                    i2 = iIntValue7;
                    iIntValue2 = -1;
                    i = iIntValue6;
                    iIntValue = -1;
                } else {
                    map.put(ed.a("016>gkdcdf]dRgkAfgg:fcedKcdiUdiedXe"), -1);
                    iIntValue = ((Integer) fz.a(fy.a(objA2, ed.a("006Ree>fiSglfh[c"), -1, new Object[0]), -1)).intValue();
                    int iIntValue8 = ((Integer) fz.a(fy.a(objA2, ed.a("006Eee=fiEfcZdc"), -1, new Object[0]), -1)).intValue();
                    iIntValue2 = ((Integer) fz.a(fy.a(objA2, ed.a("006!ee2fiLgkdidc"), -1, new Object[0]), -1)).intValue();
                    i3 = iIntValue8;
                    iIntValue3 = -1;
                    i = -1;
                    iIntValue4 = -1;
                    iIntValue5 = -1;
                    i2 = -1;
                }
                map.put(ed.a("003gdc"), Integer.valueOf(i3));
                map.put(ed.a("004cfgg"), Integer.valueOf(iIntValue2));
                map.put(ed.a("003jNfhSc"), Integer.valueOf(iIntValue));
                map.put(ed.a("003Sfedidc"), Integer.valueOf(iIntValue4));
                map.put(ed.a("003Xfhdidc"), Integer.valueOf(iIntValue5));
                map.put(ed.a("003e8didc"), Integer.valueOf(iIntValue3));
                map.put(ed.a("003gdi"), Integer.valueOf(i));
                map.put(ed.a("003gFed.e"), Integer.valueOf(i2));
            }
        }
        return map;
    }

    public String ao() {
        LocaleList localeListA;
        Locale locale;
        if (Build.VERSION.SDK_INT < 33 || (localeListA = x43.a(fy.a(fq.d.a("locale"), "getApplicationLocales", (Object) null, new Object[0]))) == null || localeListA.isEmpty() || (locale = localeListA.get(0)) == null) {
            return null;
        }
        return locale.getLanguage();
    }

    public int ap() {
        if (Build.VERSION.SDK_INT < 34) {
            return 0;
        }
        try {
            return ((Integer) fy.a(this.f2252a.getSystemService(Class.forName("android.app.GrammaticalInflectionManager")), "getApplicationGrammaticalGender", new Object[0])).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean aq() {
        String strSubstring;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(ed.a("006ljIdjed-cl") + Process.myPid() + ed.a("007l_fhVidi:dgfh"), com.kuaishou.weapon.p0.t.k);
            strSubstring = "0";
            while (true) {
                try {
                    String line = randomAccessFile2.readLine();
                    if (line == null) {
                        break;
                    }
                    String strReplace = line.trim().replace("\t", "").trim().replace(" ", "");
                    if (strReplace.contains(ed.a("010QekdjLdcfHdjgldidcGk"))) {
                        strSubstring = strReplace.substring(10);
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    try {
                        en.a().a(th);
                        eg.a(randomAccessFile);
                    } catch (Throwable th2) {
                        eg.a(randomAccessFile);
                        throw th2;
                    }
                }
            }
            eg.a(randomAccessFile2);
        } catch (Throwable th3) {
            th = th3;
            strSubstring = "0";
        }
        if (TextUtils.isEmpty(strSubstring) || TextUtils.equals("0", strSubstring)) {
            return false;
        }
        return g(strSubstring);
    }

    public boolean ar() {
        return aA() || aq();
    }

    public String c() {
        return Build.MANUFACTURER;
    }

    public String d() {
        try {
            String str = er.a(this.f2252a).d().l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + f() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + c() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + k();
            String strA = a(false);
            if (strA == null) {
                strA = "";
            } else if (strA.length() > 16) {
                strA = strA.substring(0, 16);
            }
            return fr.d(str, strA);
        } catch (Throwable th) {
            en.a().b(th);
            return "";
        }
    }

    public String e() {
        return er.a(this.f2252a).d().l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + f() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + c() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + k();
    }

    public int f() {
        return Build.VERSION.SDK_INT;
    }

    public String g() {
        return Build.VERSION.RELEASE;
    }

    public String h() {
        return Locale.getDefault().getLanguage();
    }

    public String i() {
        return this.f2252a.getResources().getConfiguration().locale.getLanguage();
    }

    public String j() {
        return Locale.getDefault().getCountry();
    }

    public String k() {
        StringBuilder sb;
        int i;
        int[] iArrB = fz.b(this.f2252a);
        if (this.f2252a.getResources().getConfiguration().orientation == 1) {
            sb = new StringBuilder();
            sb.append(iArrB[0]);
            sb.append("x");
            i = iArrB[1];
        } else {
            sb = new StringBuilder();
            sb.append(iArrB[1]);
            sb.append("x");
            i = iArrB[0];
        }
        sb.append(i);
        return sb.toString();
    }

    public String l() {
        Object objA = fq.d.a(ed.a("005jh2ed%ef"));
        if (objA == null || !Cdo.h()) {
            return "-1";
        }
        String strS = az.a().i() ? (String) fy.a(objA, ed.a("014(ee*fi-ejdidfgg1jf^dj$di5eddj"), (Object) null, new Object[0]) : az.a().s();
        return TextUtils.isEmpty(strS) ? "-1" : strS;
    }

    public String m() {
        Object objA = fq.d.a(ed.a("005jh'ed_ef"));
        if (objA == null || !Cdo.h()) {
            return null;
        }
        String strR = az.a().i() ? (String) fy.a(objA, ed.a("018YeeWfiYejdidfgg;jf djJdi*eddjehTd0df;f"), (Object) null, new Object[0]) : az.a().r();
        if (TextUtils.isEmpty(strR)) {
            return null;
        }
        return strR;
    }

    public String n() {
        return fx.a(this.f2252a).a();
    }

    public String o() {
        return this.f2252a.getPackageName();
    }

    public String p() {
        try {
            ApplicationInfo applicationInfoAk = er.a(this.f2252a).d().ak();
            String strC = fq.d.c();
            String strB = fd.b(applicationInfoAk, strC);
            if (strB != null) {
                if (Build.VERSION.SDK_INT < 25 || strB.endsWith(".*")) {
                    return strB;
                }
                fy.a(strB, (String) null);
            }
            int iC = fd.c(applicationInfoAk, strC);
            return iC > 0 ? this.f2252a.getString(iC) : String.valueOf(fd.d(applicationInfoAk, strC));
        } catch (Throwable th) {
            en.a().b(th);
            return "";
        }
    }

    public int q() {
        try {
            int iIntValue = ((Integer) bc.a(null, ed.a("011.ddIfOdjfhdiedDeZgkeddc7f"), Integer.class, 0)).intValue();
            if (iIntValue > 0) {
                return iIntValue;
            }
            Object objB = er.a(this.f2252a).d().b(false, 0, o(), 0);
            return Build.VERSION.SDK_INT >= 28 ? (int) fd.g(objB, fq.d.c()) : fd.f(objB, fq.d.c());
        } catch (Throwable th) {
            en.a().a(th);
            return 0;
        }
    }

    public String r() {
        try {
            String str = (String) bc.a(null, ed.a("011:ddYfNdjfhdied5e_eh9dOdfJf"), String.class, null);
            return !TextUtils.isEmpty(str) ? str : fd.c(er.a(this.f2252a).d().b(false, 0, o(), 0), fq.d.c());
        } catch (Throwable th) {
            en.a().a(th);
            return "1.0";
        }
    }

    public ArrayList<HashMap<String, String>> s() {
        if (!az.a().g()) {
            List<PackageInfo> listP = az.a().p();
            if (listP == null || listP.isEmpty()) {
                return new ArrayList<>();
            }
            HashMap<String, Object> map = new HashMap<>();
            for (PackageInfo packageInfo : listP) {
                map.put(packageInfo.packageName, packageInfo);
            }
            return a(map);
        }
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        try {
            if (Build.VERSION.SDK_INT <= 25) {
                return a(ax());
            }
            ArrayList arrayList2 = (ArrayList) by.a(ed.a("004dg>ed?g"), (Object) null);
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList2 = new ArrayList(Arrays.asList("1", "2"));
            }
            for (int i = 0; i < arrayList2.size(); i++) {
                arrayList = b(Integer.parseInt(String.valueOf(arrayList2.get(i))));
                if (arrayList != null && !arrayList.isEmpty() && arrayList.size() > 1) {
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            en.a().a(th);
            return new ArrayList<>();
        }
    }

    public String t() {
        return ((Build.VERSION.SDK_INT < 29 || er.a(this.f2252a).d().ak().targetSdkVersion < 29 || !"mounted".equals(Environment.getExternalStorageState())) ? this.f2252a.getFilesDir() : this.f2252a.getExternalFilesDir(null)).getAbsolutePath();
    }

    public String u() throws Throwable {
        return null;
    }

    public ArrayList<HashMap<String, Object>> v() {
        if (!Cdo.g()) {
            return null;
        }
        try {
            if (!d(ed.a("041deWdcdjeddidcfd4jf0djdfdifhfhdied%eGfdelgkgkghejejdhgkggelgiejghdhfcgggkelekeiggeh")) || P()) {
                return null;
            }
            List arrayList = new ArrayList();
            if (az.a().f()) {
                Object objA = fq.d.a(ed.a("005jh'ed.ef"));
                if (objA != null) {
                    arrayList = (List) fy.a(objA, ed.a("022+ee)fi2eh?f6diee%h;feeddjdi=eQeegk1fgg@ei*e]efed"), new Object[0]);
                }
            } else {
                List<NeighboringCellInfo> listO = az.a().o();
                if (listO != null && !listO.isEmpty()) {
                    arrayList.addAll(listO);
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
            for (Object obj : arrayList) {
                int iIntValue = ((Integer) fz.a(fy.a(obj, ed.a("006 ee@fiGgkdidc"), new Object[0]), -1)).intValue();
                int iIntValue2 = ((Integer) fz.a(fy.a(obj, ed.a("006Bee=fiUfcQdc"), new Object[0]), -1)).intValue();
                int iIntValue3 = ((Integer) fz.a(fy.a(obj, ed.a("007-eeTfi5gifhfhdi"), new Object[0]), -1)).intValue();
                int iIntValue4 = ((Integer) fz.a(fy.a(obj, ed.a("006ZeeJfiHglfh c"), new Object[0]), -1)).intValue();
                int iIntValue5 = ((Integer) fz.a(fy.a(obj, ed.a("014%eeAfi-eh+fi+ffeddjdlekdkGjf"), new Object[0]), -1)).intValue();
                if (iIntValue != -1 && iIntValue2 != -1) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(ed.a("004cfgg"), Integer.valueOf(iIntValue));
                    map.put(ed.a("003gdc"), Integer.valueOf(iIntValue2));
                    map.put(ed.a("004.djfhfhdi"), Integer.valueOf(iIntValue3));
                    map.put(ed.a("003jUfhVc"), Integer.valueOf(iIntValue4));
                    map.put(ed.a("011efi1ffeddjdlekdk<jf"), Integer.valueOf(iIntValue5));
                    arrayList2.add(map);
                }
            }
            if (arrayList2.size() > 0) {
                return arrayList2;
            }
            return null;
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    public String w() {
        String str;
        String strA = ed.a("0095egehfkghfleiehghfk");
        UiModeManager uiModeManager = (UiModeManager) fq.d.a("uimode");
        if (uiModeManager == null) {
            return strA;
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                str = "005*ehggdhegei";
                break;
            case 2:
                str = "004Zfkghejic";
                break;
            case 3:
                str = "003<gkelgi";
                break;
            case 4:
                str = "010'ekghfcghgjeiejeiggeh";
                break;
            case 5:
                str = "009Ielglglfceielehgkgh";
                break;
            case 6:
                str = "005Ygeelekgkfj";
                break;
            case 7:
                str = "009Ggjgifjghelfkejghek";
                break;
            default:
                str = "009Cegehfkghfleiehghfk";
                break;
        }
        return ed.a(str);
    }

    public HashMap<String, Object> y() {
        Object objL;
        if (Cdo.c()) {
            try {
                if (d(ed.a("036deYdcdjeddidcfd]jf-djdfdifhfhdiedHe6fdelgkgkghejejdhgeeifleidhejekelekgh"))) {
                    if (az.a().e()) {
                        Object objA = fq.d.a(ed.a("004Xffdiefdi"));
                        objL = objA != null ? fy.a(objA, ed.a("017@ee<fiRgked6eefci.died^eIeiUe>efed"), new Object[0]) : null;
                    } else {
                        objL = az.a().l();
                    }
                    if (objL != null) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("bsmt", (String) fy.a(objL, ed.a("008 ee+fi fiejejeifk"), (Object) null, new Object[0]));
                        String str = (String) fy.a(objL, ed.a("007<eeVfiIejejeifk"), (Object) null, new Object[0]);
                        map.put("ssmt", str == null ? null : str.replace("\"", ""));
                        try {
                            map.put(ed.a("006h3didcdc+fe"), Boolean.valueOf(((Boolean) fy.a(objL, ed.a("013'eeNfi^fjdidcdc0fe3ejejeifk"), new Object[0])).booleanValue()));
                        } catch (Throwable unused) {
                        }
                        try {
                            map.put("spmt", Integer.valueOf(((Integer) fy.a(objL, ed.a("012$ee4fi4fcdiZeEdlejZjffMdc"), new Object[0])).intValue()));
                        } catch (Throwable unused2) {
                        }
                        try {
                            map.put(ed.a("009efiFffeddjdleidc"), Integer.valueOf(((Integer) fy.a(objL, ed.a("012MeeGfi,eh(fiCffeddjdleidc"), new Object[0])).intValue()));
                        } catch (Throwable unused3) {
                        }
                        try {
                            map.put(ed.a("005gf>ddMfg"), Integer.valueOf(((Integer) fy.a(objL, ed.a("007Fee1fi%gifhfhdi"), new Object[0])).intValue()));
                        } catch (Throwable unused4) {
                        }
                        try {
                            map.put(ed.a("009,efdj3f dedg6fecVdk"), Integer.valueOf(((Integer) fy.a(objL, ed.a("012PeeBfi=fldjBfGdedgBfecPdk"), new Object[0])).intValue()));
                        } catch (Throwable unused5) {
                        }
                        return map;
                    }
                }
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return null;
    }

    public ArrayList<HashMap<String, Object>> z() {
        List list;
        String[] strArrSplit;
        String strA;
        Object objA;
        if (Cdo.d()) {
            try {
                if (d(ed.a("036de2dcdjeddidcfdUjfLdjdfdifhfhdied^e%fdelgkgkghejejdhgeeifleidhejekelekgh"))) {
                    if (az.a().e()) {
                        Object objA2 = fq.d.a(ed.a("004(ffdiefdi"));
                        if (objA2 == null) {
                            return null;
                        }
                        list = (List) fy.a(objA2, ed.a("014Dee!fi[ej2cde;giDf>fhdg$giVfh"), new Object[0]);
                    } else {
                        List<ScanResult> listM = az.a().m();
                        if (listM != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(listM);
                            list = arrayList;
                        } else {
                            list = null;
                        }
                    }
                    if (list == null) {
                        return null;
                    }
                    if (Build.VERSION.SDK_INT > 27) {
                        strArrSplit = ed.a("086Oejejeifkjhfiejejeifkjh9cdjd=fediVgHdiQi+diOfOfhjhEgfTdd5fgDjhefdjVf6dedg;fec2dkjh5chdeefg'gedidc<ihPjhWcfeif3djfldj.fCdefgjh]cfeifXdjfldj+f5dehfjhOiHdidfJf4fhIidBdf,j").split(",");
                        strA = ed.a("031RddDfeMdg@f1ehTd3dfTf(jhifedUjfJdj<diCeddjfldjdiUfeYdc<g!dkehQd!dfPf");
                    } else {
                        strArrSplit = "SSID,BSSID,hessid,anqpDomainId,capabilities,level,frequency,channelWidth,centerFreq0,centerFreq1,timestamp,seen,isAutoJoinCandidate,numIpConfigFailures,blackListTimestamp,untrusted,numConnection,numUsage,distanceCm,distanceSdCm,flags".split(",");
                        strA = ed.a("039$ffdiefdiejfhdidcjhdd^feBdgNfWeh8dVdfCf5jhed<jf2djJdiDeddjfldjdiCfeHdcKg,dkeh>d<dfJf");
                    }
                    String[] strArrSplit2 = strA.split(",");
                    ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
                    for (Object obj : list) {
                        HashMap<String, Object> map = new HashMap<>();
                        int length = strArrSplit.length;
                        String str = null;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            String strTrim = strArrSplit[i].trim();
                            if (ed.a("0046ejejeifk").equals(strTrim)) {
                                str = (String) fy.a(obj, strTrim, (Object) null);
                                if (TextUtils.isEmpty(str)) {
                                    break;
                                }
                                map.put(strTrim, str);
                                i++;
                            } else {
                                if (ed.a("012cdjdKfedi1g^di)iHdiYf;fh").equals(strTrim)) {
                                    String str2 = (String) fy.a(obj, strTrim, (Object) null);
                                    objA = str2;
                                    if (str2 != null) {
                                        boolean zContains = str2.contains("[IBSS]");
                                        objA = str2;
                                        if (zContains) {
                                            str = null;
                                            break;
                                        }
                                    }
                                } else {
                                    objA = fy.a(obj, strTrim, (Object) null);
                                }
                                map.put(strTrim, objA);
                                i++;
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            for (String str3 : strArrSplit2) {
                                try {
                                    String strTrim2 = str3.trim();
                                    Object objA3 = fy.a(obj, strTrim2);
                                    map.put(strTrim2, objA3 == null ? null : objA3.toString());
                                } catch (Throwable unused) {
                                }
                            }
                            try {
                                map.put(ed.a("021 difhhdfghehfhfhcHc:giekekgi<f@fhZj=edEe]dc3f3dj"), fy.a(obj, ed.a("018$difhhdfghehfhfdfZc$giQf_fhBj+ed?eWdc@f<dj"), new Object[0]));
                            } catch (Throwable unused2) {
                            }
                            try {
                                if (Build.VERSION.SDK_INT < 28) {
                                    List list2 = (List) fy.a(obj, ed.a("009deUde*jOfcdiWefHfh"));
                                    map.put(ed.a("009deKdeTjBfcdi_ef1fh"), list2 == null ? null : new ArrayList(list2));
                                }
                            } catch (Throwable unused3) {
                            }
                            arrayList2.add(map);
                        }
                    }
                    return arrayList2;
                }
            } catch (Throwable th) {
                en.a().b(th);
            }
        }
        return null;
    }

    private void f(String str) {
        FileOutputStream fileOutputStream;
        File fileA = fz.a(this.f2252a, ed.a("0030fddcdl"));
        if (fileA != null && fileA.exists()) {
            fileA.delete();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileA);
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream2.writeObject(str.toCharArray());
                    objectOutputStream2.flush();
                    eg.a(objectOutputStream2, fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    try {
                        en.a().a(th);
                        eg.a(objectOutputStream, fileOutputStream);
                    } catch (Throwable th2) {
                        eg.a(objectOutputStream, fileOutputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0 A[Catch: all -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00b9, blocks: (B:28:0x0086, B:40:0x00b0), top: B:52:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(String str) {
        Object objC;
        InputStream inputStream;
        Closeable closeable;
        boolean z;
        Closeable closeable2;
        BufferedReader bufferedReader = null;
        try {
            try {
                objC = eg.c(ed.a("002jTfh"));
            } catch (Throwable unused) {
            }
            try {
                inputStream = (InputStream) fy.a(objC, ed.a("014!ee5fi;ei@ejBdg?iJej%i%dj^fd.df"), new Object[0]);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            Pattern patternCompile = Pattern.compile("^\\s*(\\S+)\\s+(\\d+)\\s+(\\d+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+(\\d+)\\s+(\\w)\\s+(.+)$");
                            z = true;
                            while (true) {
                                try {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    Matcher matcher = patternCompile.matcher(line);
                                    if (matcher.matches()) {
                                        String strGroup = matcher.group(2);
                                        String strGroup2 = matcher.group(3);
                                        String strGroup3 = matcher.group(6);
                                        String strC = fq.d.c();
                                        if ((TextUtils.equals(strC, strGroup3) && (TextUtils.equals(strGroup, str) || TextUtils.equals(strGroup2, str))) || (strGroup3 != null && strGroup3.contains(strC) && TextUtils.equals(str, strGroup))) {
                                            z = false;
                                        }
                                    }
                                } catch (Throwable unused2) {
                                    bufferedReader = bufferedReader2;
                                    closeable2 = inputStreamReader;
                                    eg.a(bufferedReader, closeable2, inputStream);
                                    if (objC != null) {
                                        fy.a(objC, ed.a("007%dc fTfh@iTdjeddk"), new Object[0]);
                                    }
                                    return z;
                                }
                            }
                            eg.a(bufferedReader2, inputStreamReader, inputStream);
                        } catch (Throwable unused3) {
                            bufferedReader = bufferedReader2;
                            closeable = inputStreamReader;
                            z = true;
                            closeable2 = closeable;
                            eg.a(bufferedReader, closeable2, inputStream);
                            if (objC != null) {
                            }
                            return z;
                        }
                    } catch (Throwable unused4) {
                        closeable = inputStreamReader;
                    }
                } catch (Throwable unused5) {
                    closeable = null;
                }
            } catch (Throwable unused6) {
                inputStream = null;
                closeable = inputStream;
                z = true;
                closeable2 = closeable;
                eg.a(bufferedReader, closeable2, inputStream);
                if (objC != null) {
                }
                return z;
            }
        } catch (Throwable unused7) {
            objC = null;
            inputStream = null;
        }
        if (objC != null) {
            fy.a(objC, ed.a("007%dc fTfh@iTdjeddk"), new Object[0]);
        }
        return z;
    }

    public Object a(int i, int i2, boolean z, boolean z2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return gf.a().a(this.f2252a, i, i2, z, z2);
        }
        en.a().a("glctn can not be called from Main Thread", new Object[0]);
        return null;
    }

    public String b() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public String c(String str) {
        ApplicationInfo applicationInfoA;
        CharSequence charSequenceG;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (applicationInfoA = er.a(this.f2252a).d().a(str, 1)) == null || (charSequenceG = fd.g(applicationInfoA, str)) == null) {
                return null;
            }
            return charSequenceG.toString();
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    public boolean d(String str) throws Throwable {
        int iCheckPermission;
        if (Build.VERSION.SDK_INT >= 23) {
            fy.a(ed.a("023deTdcdjeddidcfd1cBed5eifei$fdgked3eif ecKi"), (String) null);
            iCheckPermission = -1;
            Integer num = (Integer) fy.a(this.f2252a, ed.a("019chfcNdlej0fg$efglBf@djdfdifhfhdiedXe"), -1, str);
            if (num != null) {
                iCheckPermission = num.intValue();
            }
        } else {
            iCheckPermission = this.f2252a.getPackageManager().checkPermission(str, o());
        }
        return iCheckPermission == 0;
    }

    public boolean e(String str) {
        return er.a(this.f2252a).d().a(true, str, 0) != null;
    }

    public String a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jCurrentTimeMillis);
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            if (ed.a("004chdRdj").equalsIgnoreCase(ed.a(secureRandom.nextInt(2) % 2 == 0 ? "004chd>dj" : "003eYdgdf"))) {
                stringBuffer.insert(i2 + 1, (char) (secureRandom.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), secureRandom.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public String b(String str) {
        Signature[] signatureArrB;
        try {
            Object objB = er.a(this.f2252a).d().b(false, 0, str, 64);
            if (objB == null || (signatureArrB = fd.b(objB, str)) == null || signatureArrB.length <= 0) {
                return null;
            }
            return fr.d(signatureArrB[0].toByteArray());
        } catch (Exception e) {
            en.a().b(e);
            return null;
        }
    }

    private ArrayList<HashMap<String, String>> b(int i) {
        Context context;
        Set<String> setA;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        int i2 = 1;
        try {
        } catch (Throwable th) {
            en.a().a(th);
        }
        if (i != 1) {
            if (i == 2) {
                setA = ay();
            } else if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    setA = i != 5 ? null : az();
                } else {
                    context = this.f2252a;
                }
            } else {
                setA = ax();
            }
            if (setA != null && !setA.isEmpty()) {
                arrayList = a(setA);
            }
            en.a().a("DH PD: ap " + arrayList.size() + " tpe " + i, new Object[0]);
            return arrayList;
        }
        context = this.f2252a;
        setA = ez.a(context, i2);
        if (setA != null) {
            arrayList = a(setA);
        }
        en.a().a("DH PD: ap " + arrayList.size() + " tpe " + i, new Object[0]);
        return arrayList;
    }

    public String a(String str) {
        return et.a(this.f2252a).a(str);
    }

    private void b(HashMap<String, String> map) {
        if (map != null) {
            fz.a(fz.b(this.f2252a, ed.a("0046fd2deTfh")).getAbsolutePath(), (Object) map);
        }
    }

    public String a(boolean z) {
        String strAt = at();
        if (!z && (TextUtils.isEmpty(strAt) || strAt.length() < 40)) {
            strAt = as();
        }
        if (!TextUtils.isEmpty(strAt) && strAt.length() >= 40) {
            return strAt.trim();
        }
        String strAv = av();
        if (!TextUtils.isEmpty(strAv) && strAv.length() >= 40) {
            return strAv.trim();
        }
        if (TextUtils.isEmpty(strAv) || strAv.length() < 40) {
            strAv = a(40);
        }
        if (strAv == null) {
            return strAv;
        }
        String strTrim = strAv.trim();
        f(strTrim);
        return strTrim;
    }

    public ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> arrayList, int i) {
        try {
            en.a().a("DH PD: fabt " + i, new Object[0]);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            ArrayList<HashMap<String, String>> arrayList2 = new ArrayList<>();
            for (HashMap<String, String> map : arrayList) {
                boolean zEquals = TextUtils.equals("1", map.get(ed.a("0050difhfhdkfh")));
                if (i != 1 || !zEquals) {
                    if (i != 2 || zEquals) {
                        HashMap<String, String> map2 = new HashMap<>(map);
                        map2.remove(ed.a("005Gdifhfhdkfh"));
                        arrayList2.add(map2);
                    }
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public ArrayList<HashMap<String, String>> a(HashMap<String, Object> map) {
        String string;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        if (Cdo.b()) {
            try {
                PackageManager packageManager = this.f2252a.getPackageManager();
                HashMap<String, String> mapAw = aw();
                if (map != null && !map.isEmpty()) {
                    boolean z = false;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != null) {
                            HashMap<String, String> map2 = new HashMap<>();
                            ApplicationInfo applicationInfoA = fd.a(value, key);
                            if (applicationInfoA != null) {
                                String str = "1";
                                if (a(applicationInfoA)) {
                                    map2.put(ed.a("005?difhfhdkfh"), "1");
                                } else {
                                    map2.put(ed.a("005Zdifhfhdkfh"), "0");
                                }
                                map2.put(ed.a("003jXdlee"), key);
                                CharSequence text = null;
                                if (mapAw != null) {
                                    string = mapAw.get(fr.b(key));
                                } else {
                                    mapAw = new HashMap<>();
                                    string = null;
                                }
                                if (TextUtils.isEmpty(string)) {
                                    try {
                                        try {
                                            text = fd.g(applicationInfoA, key);
                                        } catch (Throwable unused) {
                                        }
                                    } catch (Throwable unused2) {
                                        int iC = fd.c(applicationInfoA, key);
                                        if (iC > 0) {
                                            text = packageManager.getText(key, iC, applicationInfoA);
                                        }
                                    }
                                    string = text == null ? key : text.toString();
                                    mapAw.put(fr.b(key), string);
                                    z = true;
                                }
                                map2.put(ed.a("004ed0df:f"), string);
                                map2.put(ed.a("0077dd5fMdjfhdied>e"), fd.c(value, key));
                                String strA = ed.a("006fed@feQgf");
                                if (!fd.e(applicationInfoA, key)) {
                                    str = "0";
                                }
                                map2.put(strA, str);
                                map2.put(ed.a("016?efdidjfh2iTei(e]fhKidgg)ekdidfMf"), String.valueOf(fd.d(value, key)));
                                map2.put(ed.a("014gdXfh$i.egXjJdc4difLekdidf f"), String.valueOf(fd.e(value, key)));
                                arrayList.add(map2);
                            }
                        }
                    }
                    if (z) {
                        b(mapAw);
                    }
                }
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return arrayList;
    }

    private ArrayList<HashMap<String, String>> a(Set<String> set) {
        if (Cdo.b() && set != null && !set.isEmpty()) {
            HashMap<String, Object> map = new HashMap<>();
            for (String str : set) {
                map.put(str, er.a(this.f2252a).d().b(true, 0, str, 0));
            }
            if (!map.isEmpty()) {
                return a(map);
            }
        }
        return new ArrayList<>();
    }

    private HashMap<String, Object> a(File file) {
        return a(er.a(this.f2252a).d().l(), fz.b(file));
    }

    private HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return fv.a(fr.a(str, bArr));
        } catch (Throwable th) {
            en.a().a(th);
            return new HashMap<>();
        }
    }

    public void a(final BlockingQueue<Boolean> blockingQueue) {
        if (Cdo.d() && az.a().e()) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cn.fly.verify.eq.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    try {
                        eg.a(this);
                        if (ed.a("029deRdcdjeddidcfd[efiIfdffdiefdifdejgkelehdhgighejegfcekej").equals(intent.getAction())) {
                            blockingQueue.put(Boolean.TRUE);
                        }
                    } catch (Throwable th) {
                        en.a().a(th);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ed.a("029de@dcdjeddidcfd0efi1fdffdiefdifdejgkelehdhgighejegfcekej"));
            eg.a(broadcastReceiver, intentFilter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a() {
        boolean z;
        String strD = eg.d();
        if (strD == null || strD.length() != 5) {
            z = false;
        } else {
            if (strD.charAt(3) != '1') {
                if (strD.charAt(4) == '1') {
                }
            }
            z = true;
        }
        return z;
    }

    private boolean a(ApplicationInfo applicationInfo) {
        int i = applicationInfo.flags;
        return ((i & 1) == 1) || ((i & 128) != 0);
    }
}
