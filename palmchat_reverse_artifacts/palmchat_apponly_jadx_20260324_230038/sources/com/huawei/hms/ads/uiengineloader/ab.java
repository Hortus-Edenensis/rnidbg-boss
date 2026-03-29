package com.huawei.hms.ads.uiengineloader;

import com.wifi.adsdk.utils.LxAdEmuiDevice;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6610a = "EmuiUtil";
    private static final String b = "EMUI_SDK_INT";
    private static final String c = "com.huawei.android.os.BuildEx$VERSION";
    private static final int d = -1;
    private static final int e = 7;
    private static final int f = 8;
    private static final int g = 9;
    private static final int h = 10;
    private static final int i = 11;
    private static final int j = 14;
    private static final int k = 15;
    private static final int l = 17;
    private static final int m = 30;
    private static final int n = 31;
    private static final int o = 40;
    private static final int p = 41;
    private static final int q = 50;
    private static final int r = 60;
    private static final int s = 81;
    private static final int t = 90;
    private static int u = -1;
    private static int v = d();

    /* JADX WARN: Removed duplicated region for block: B:61:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    static {
        int i2;
        af.b(f6610a, "getEmuiType emuiVersionCode=" + v);
        int i3 = v;
        if (i3 >= 17) {
            i2 = 90;
        } else {
            if (i3 < 15) {
                if (i3 >= 14) {
                    u = 60;
                } else if (i3 >= 11) {
                    u = 50;
                } else if (i3 >= 10) {
                    u = 41;
                } else if (i3 >= 9) {
                    u = 40;
                } else if (i3 >= 8) {
                    u = 31;
                } else if (i3 >= 7) {
                    u = 30;
                } else {
                    u = -1;
                }
                if (u != -1) {
                    try {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION);
                        af.a(f6610a, "isNeed2UseHwEmui :");
                        if (str != null) {
                            if (str.contains("EmotionUI_3.0")) {
                                u = 30;
                                return;
                            }
                            if (str.contains("EmotionUI_3.1")) {
                                u = 31;
                                return;
                            }
                            if (str.contains("EmotionUI_4.0")) {
                                u = 40;
                                return;
                            }
                            if (str.contains("EmotionUI_4.1")) {
                                u = 41;
                                return;
                            }
                            if (str.contains("EmotionUI_5.0")) {
                                u = 50;
                                return;
                            } else if (str.contains("EmotionUI_6.0")) {
                                u = 60;
                                return;
                            } else {
                                u = -1;
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        af.d(f6610a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
                        return;
                    }
                }
                return;
            }
            i2 = 81;
        }
        u = i2;
        if (u != -1) {
        }
    }

    public static boolean a() {
        return u == 50;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b() {
        int i2;
        v = d();
        af.b(f6610a, "getEmuiType emuiVersionCode=" + v);
        int i3 = v;
        if (i3 >= 17) {
            i2 = 90;
        } else {
            if (i3 < 15) {
                if (i3 >= 14) {
                    u = 60;
                } else if (i3 >= 11) {
                    u = 50;
                } else if (i3 >= 10) {
                    u = 41;
                } else if (i3 >= 9) {
                    u = 40;
                } else if (i3 >= 8) {
                    u = 31;
                } else if (i3 >= 7) {
                    u = 30;
                } else {
                    u = -1;
                }
                if (u != -1) {
                    try {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION);
                        af.a(f6610a, "isNeed2UseHwEmui :");
                        if (str != null) {
                            if (str.contains("EmotionUI_3.0")) {
                                u = 30;
                                return;
                            }
                            if (str.contains("EmotionUI_3.1")) {
                                u = 31;
                                return;
                            }
                            if (str.contains("EmotionUI_4.0")) {
                                u = 40;
                                return;
                            }
                            if (str.contains("EmotionUI_4.1")) {
                                u = 41;
                                return;
                            }
                            if (str.contains("EmotionUI_5.0")) {
                                u = 50;
                                return;
                            } else if (str.contains("EmotionUI_6.0")) {
                                u = 60;
                                return;
                            } else {
                                u = -1;
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        af.d(f6610a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
                        return;
                    }
                }
                return;
            }
            i2 = 81;
        }
        u = i2;
        if (u != -1) {
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION);
            af.a(f6610a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    u = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    u = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    u = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    u = 41;
                    return;
                }
                if (str.contains("EmotionUI_5.0")) {
                    u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    u = 60;
                } else {
                    u = -1;
                }
            }
        } catch (Throwable th) {
            af.d(f6610a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
        }
    }

    private static int d() {
        String str;
        Object obj;
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.BuildEx$VERSION");
            Field declaredField = cls.getDeclaredField("EMUI_SDK_INT");
            AccessibleObject.setAccessible(new Field[]{declaredField}, true);
            obj = declaredField.get(cls);
        } catch (ClassNotFoundException unused) {
            str = "getEMUIVersionCode ClassNotFoundException";
            af.c(f6610a, str);
            obj = null;
        } catch (IllegalAccessException unused2) {
            str = "getEMUIVersionCode IllegalAccessException";
            af.c(f6610a, str);
            obj = null;
        } catch (NoSuchFieldException unused3) {
            str = "getEMUIVersionCode NoSuchFieldException";
            af.c(f6610a, str);
            obj = null;
        } catch (SecurityException unused4) {
            str = "getEMUIVersionCode SecurityException";
            af.c(f6610a, str);
            obj = null;
        } catch (Exception unused5) {
            str = "getEMUIVersionCode exception ";
            af.c(f6610a, str);
            obj = null;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }
}
