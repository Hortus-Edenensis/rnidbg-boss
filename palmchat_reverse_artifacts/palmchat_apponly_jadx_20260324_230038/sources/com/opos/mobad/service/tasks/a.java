package com.opos.mobad.service.tasks;

import android.app.ActivityManager;
import android.content.Context;
import android.os.StatFs;
import android.provider.Settings;
import com.omes.scorpion.OmasStub;
import com.opos.mobad.provider.record.CookieData;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CookieData f9247a = null;
    private static String b = "";
    private static final FileFilter c = new FileFilter() { // from class: com.opos.mobad.service.tasks.a.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return OmasStub.omasBoolean(4, new Object[]{this, file});
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.service.tasks.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0774a {
        boolean a();

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        String f();
    }

    public static final ActivityManager.MemoryInfo a(Context context) {
        return (ActivityManager.MemoryInfo) OmasStub.omasObject(19, new Object[]{context});
    }

    public static final int b(Context context) {
        return OmasStub.omasInt(27, new Object[]{context});
    }

    public static final int c() {
        return OmasStub.omasInt(30, new Object[0]);
    }

    private static final boolean d() throws IOException {
        return OmasStub.omasBoolean(33, new Object[0]);
    }

    private static final boolean e(Context context) {
        return OmasStub.omasBoolean(35, new Object[]{context});
    }

    private static final boolean f(Context context) {
        return OmasStub.omasBoolean(36, new Object[]{context});
    }

    private static String g(Context context) {
        return (String) OmasStub.omasObject(37, new Object[]{context});
    }

    private static String h(Context context) {
        return (String) OmasStub.omasObject(38, new Object[]{context});
    }

    private static String i(Context context) {
        return (String) OmasStub.omasObject(39, new Object[]{context});
    }

    private static final int j(Context context) throws Settings.SettingNotFoundException {
        return OmasStub.omasInt(40, new Object[]{context});
    }

    public static final StatFs a() {
        return (StatFs) OmasStub.omasObject(20, new Object[0]);
    }

    public static final long b() {
        return OmasStub.omasLong(28, new Object[0]);
    }

    public static final String c(Context context) {
        return (String) OmasStub.omasObject(31, new Object[]{context});
    }

    private static final boolean d(Context context) {
        return OmasStub.omasBoolean(34, new Object[]{context});
    }

    private static CookieData a(Context context, InterfaceC0774a interfaceC0774a) {
        return (CookieData) OmasStub.omasObject(21, new Object[]{context, interfaceC0774a});
    }

    private static CookieData b(Context context, InterfaceC0774a interfaceC0774a) throws NoSuchAlgorithmException {
        return (CookieData) OmasStub.omasObject(29, new Object[]{context, interfaceC0774a});
    }

    private static String c(Context context, InterfaceC0774a interfaceC0774a) {
        return (String) OmasStub.omasObject(32, new Object[]{context, interfaceC0774a});
    }

    public static final String a(float[][] fArr) {
        return (String) OmasStub.omasObject(22, new Object[]{fArr});
    }

    public static HashMap<String, String> a(Context context, boolean z, int i, InterfaceC0774a interfaceC0774a) {
        return (HashMap) OmasStub.omasObject(23, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), interfaceC0774a});
    }

    public static final void a(Context context, HashMap<String, String> map) {
        OmasStub.omasVoid(24, new Object[]{context, map});
    }

    public static final void a(Context context, Map<String, String> map, InterfaceC0774a interfaceC0774a) {
        OmasStub.omasVoid(25, new Object[]{context, map, interfaceC0774a});
    }

    private static final boolean a(String str) {
        return OmasStub.omasBoolean(26, new Object[]{str});
    }
}
