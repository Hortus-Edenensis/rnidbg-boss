package com.heytap.msp.ipc.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static Bundle a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("resultCode", i);
        bundle.putString("resultMsg", str);
        return bundle;
    }

    private static Bundle b(String str, Parcelable parcelable, int i, Object... objArr) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(c.class.getClassLoader());
        bundle.putString("targetClass", str);
        if (parcelable != null) {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeParcelable(parcelable, 0);
            bundle.putByteArray("targetIdentify", parcelObtain.marshall());
            parcelObtain.recycle();
        }
        bundle.putInt("methodId", i);
        if (objArr != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < objArr.length; i3++) {
                if (objArr[i3] instanceof IBinder) {
                    arrayList.add(Integer.valueOf(i3));
                    arrayList.add(1);
                    String str2 = "args_i_binder" + i2;
                    arrayList.add(str2);
                    bundle.putBinder(str2, (IBinder) objArr[i3]);
                    i2++;
                } else {
                    arrayList.add(Integer.valueOf(i3));
                    arrayList.add(0);
                    arrayList.add(objArr[i3]);
                }
            }
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain2.writeArray(arrayList.toArray());
            bundle.putByteArray("args", parcelObtain2.marshall());
            parcelObtain2.recycle();
        }
        return bundle;
    }

    private static Bundle c(String str, Parcelable parcelable, int i, Object... objArr) {
        String str2;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.setClassLoader(c.class.getClassLoader());
        bundle2.putString("targetClass", str);
        if (parcelable != null) {
            bundle2.putParcelable("targetIdentifyV2", parcelable);
        }
        bundle2.putInt("methodId", i);
        if (objArr != null) {
            bundle2.putInt("paramsCount", objArr.length);
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    str2 = "params" + i2;
                    bundle = null;
                } else if (obj instanceof Bundle) {
                    str2 = "params" + i2;
                    bundle = (Bundle) objArr[i2];
                } else {
                    if (obj instanceof IBinder) {
                        bundle2.putBinder("params" + i2, (IBinder) objArr[i2]);
                    } else if (obj instanceof Boolean) {
                        bundle2.putBoolean("params" + i2, ((Boolean) objArr[i2]).booleanValue());
                    } else if (obj instanceof boolean[]) {
                        bundle2.putBooleanArray("params" + i2, (boolean[]) objArr[i2]);
                    } else if (obj instanceof Byte) {
                        bundle2.putByte("params" + i2, ((Byte) objArr[i2]).byteValue());
                    } else if (obj instanceof byte[]) {
                        bundle2.putByteArray("params" + i2, (byte[]) objArr[i2]);
                    } else if (obj instanceof Character) {
                        bundle2.putChar("params" + i2, ((Character) objArr[i2]).charValue());
                    } else if (obj instanceof char[]) {
                        bundle2.putCharArray("params" + i2, (char[]) objArr[i2]);
                    } else if (obj instanceof CharSequence) {
                        bundle2.putCharSequence("params" + i2, (CharSequence) objArr[i2]);
                    } else if (obj instanceof CharSequence[]) {
                        bundle2.putCharSequenceArray("params" + i2, (CharSequence[]) objArr[i2]);
                    } else if ((obj instanceof ArrayList) && (((ArrayList) obj).get(0) instanceof CharSequence)) {
                        bundle2.putCharSequenceArrayList("params" + i2, (ArrayList) objArr[i2]);
                    } else {
                        Object obj2 = objArr[i2];
                        if (obj2 instanceof Double) {
                            bundle2.putDouble("params" + i2, ((Double) objArr[i2]).doubleValue());
                        } else if (obj2 instanceof double[]) {
                            bundle2.putDoubleArray("params" + i2, (double[]) objArr[i2]);
                        } else if (obj2 instanceof Float) {
                            bundle2.putFloat("params" + i2, ((Float) objArr[i2]).floatValue());
                        } else if (obj2 instanceof float[]) {
                            bundle2.putFloatArray("params" + i2, (float[]) objArr[i2]);
                        } else if (obj2 instanceof Integer) {
                            bundle2.putInt("params" + i2, ((Integer) objArr[i2]).intValue());
                        } else if (obj2 instanceof int[]) {
                            bundle2.putIntArray("params" + i2, (int[]) objArr[i2]);
                        } else if ((obj2 instanceof ArrayList) && (((ArrayList) obj2).get(0) instanceof Integer)) {
                            bundle2.putIntegerArrayList("params" + i2, (ArrayList) objArr[i2]);
                        } else {
                            Object obj3 = objArr[i2];
                            if (obj3 instanceof Long) {
                                bundle2.putLong("params" + i2, ((Long) objArr[i2]).longValue());
                            } else if (obj3 instanceof long[]) {
                                bundle2.putLongArray("params" + i2, (long[]) objArr[i2]);
                            } else if (obj3 instanceof Short) {
                                bundle2.putShort("params" + i2, ((Short) objArr[i2]).shortValue());
                            } else if (obj3 instanceof short[]) {
                                bundle2.putShortArray("params" + i2, (short[]) objArr[i2]);
                            } else if (obj3 instanceof String) {
                                bundle2.putString("params" + i2, (String) objArr[i2]);
                            } else if (obj3 instanceof String[]) {
                                bundle2.putStringArray("params" + i2, (String[]) objArr[i2]);
                            } else if ((obj3 instanceof ArrayList) && (((ArrayList) obj3).get(0) instanceof String)) {
                                bundle2.putStringArrayList("params" + i2, (ArrayList) objArr[i2]);
                            } else {
                                Object obj4 = objArr[i2];
                                if (obj4 instanceof Size) {
                                    bundle2.putSize("params" + i2, (Size) objArr[i2]);
                                } else if (obj4 instanceof SizeF) {
                                    bundle2.putSizeF("params" + i2, (SizeF) objArr[i2]);
                                } else if (obj4 instanceof Parcelable) {
                                    bundle2.putParcelable("params" + i2, (Parcelable) objArr[i2]);
                                } else if (obj4 instanceof Parcelable[]) {
                                    bundle2.putParcelableArray("params" + i2, (Parcelable[]) objArr[i2]);
                                } else if ((obj4 instanceof ArrayList) && (((ArrayList) obj4).get(0) instanceof Parcelable)) {
                                    bundle2.putParcelableArrayList("params" + i2, (ArrayList) objArr[i2]);
                                } else {
                                    Object obj5 = objArr[i2];
                                    if ((obj5 instanceof SparseArray) && (((SparseArray) obj5).get(0) instanceof Parcelable)) {
                                        bundle2.putSparseParcelableArray("params" + i2, (SparseArray) objArr[i2]);
                                    } else if (objArr[i2] instanceof Serializable) {
                                        bundle2.putSerializable("params" + i2, (Serializable) objArr[i2]);
                                    } else {
                                        j.c("EncodeParams", "Encode error:" + objArr[i2]);
                                    }
                                }
                            }
                        }
                    }
                }
                bundle2.putBundle(str2, bundle);
            }
        } else {
            bundle2.putInt("paramsCount", 0);
        }
        return bundle2;
    }

    public static Bundle a(String str, Parcelable parcelable, int i, Object... objArr) {
        Bundle bundleB = b(str, parcelable, i, objArr);
        Bundle bundleC = c(str, parcelable, i, objArr);
        bundleC.putAll(bundleB);
        return bundleC;
    }

    public static boolean a(Object obj) {
        if (obj == null || (obj instanceof PersistableBundle) || (obj instanceof Size) || (obj instanceof SizeF) || (obj instanceof Integer) || (obj instanceof Map) || (obj instanceof Parcelable) || (obj instanceof Short) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof CharSequence) || (obj instanceof List) || (obj instanceof SparseArray) || (obj instanceof boolean[]) || (obj instanceof byte[]) || (obj instanceof CharSequence[]) || (obj instanceof IBinder) || (obj instanceof Parcelable[]) || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof Byte) || (obj instanceof double[])) {
            return true;
        }
        Class<?> cls = obj.getClass();
        return (cls.isArray() && cls.getComponentType() == Object.class) || (obj instanceof Serializable);
    }

    public static boolean a(Object... objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (!a(obj)) {
                return false;
            }
        }
        return true;
    }
}
