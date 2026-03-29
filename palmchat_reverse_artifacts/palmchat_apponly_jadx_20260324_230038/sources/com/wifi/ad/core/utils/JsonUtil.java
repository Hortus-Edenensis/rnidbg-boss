package com.wifi.ad.core.utils;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\u0010\rJ#\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J)\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\u0010\u0014J#\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0017\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fJ$\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0017\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u001c\u0018\u00010\u001b\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\b2\u0006\u0010\u001e\u001a\u0002H\b¢\u0006\u0002\u0010\u001fJ\u001a\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\b0\u0017J\u0018\u0010\u001d\u001a\u00020\u00042\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/wifi/ad/core/utils/JsonUtil;", "", "()V", "ISO_DATETIME_FORMAT_SORT", "", "gson", "Lcom/google/gson/Gson;", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "jsonObject", "Lcom/google/gson/JsonObject;", "classOfT", "Ljava/lang/Class;", "(Lcom/google/gson/JsonObject;Ljava/lang/Class;)Ljava/lang/Object;", BodyData.TYPE_JSON, "Lcom/google/gson/stream/JsonReader;", "type", "Ljava/lang/reflect/Type;", "(Lcom/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "jsonString", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "fromJsonToList", "", "jsonArray", "Lcom/google/gson/JsonArray;", "fromJsonToMap", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "toJson", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "(Ljava/lang/Object;)Ljava/lang/String;", "list", "map", "core_release"}, k = 1, mv = {1, 1, 16})
public final class JsonUtil {
    public static final JsonUtil INSTANCE = new JsonUtil();
    private static final String ISO_DATETIME_FORMAT_SORT = "yyyy-MM-dd HH:mm:ss";
    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat(ISO_DATETIME_FORMAT_SORT).create();

    private JsonUtil() {
    }

    public final <T> T fromJson(String jsonString, Class<T> classOfT) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return (T) gson2.fromJson(jsonString, (Class) classOfT);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T> List<T> fromJsonToList(JsonArray jsonArray, Class<T> classOfT) {
        ArrayList arrayList = new ArrayList();
        try {
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                Gson gson2 = gson;
                if (gson2 == null) {
                    Intrinsics.throwNpe();
                }
                arrayList.add(gson2.fromJson(jsonArray.get(i), (Class) classOfT));
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T, V> Map<T, V> fromJsonToMap(String jsonString, Type type) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return (Map) gson2.fromJson(jsonString, type);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String toJson(Map<String, ?> map) {
        Gson gson2 = gson;
        if (gson2 == null) {
            Intrinsics.throwNpe();
        }
        String json = gson2.toJson(map);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson!!.toJson(map)");
        return json;
    }

    public final <T> T fromJson(String jsonString, Type type) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return (T) gson2.fromJson(jsonString, type);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T> String toJson(List<? extends T> list) {
        Gson gson2 = gson;
        if (gson2 == null) {
            Intrinsics.throwNpe();
        }
        String json = gson2.toJson(list);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson!!.toJson(list)");
        return json;
    }

    public final <T> T fromJson(JsonObject jsonObject, Class<T> classOfT) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return (T) gson2.fromJson((JsonElement) jsonObject, (Class) classOfT);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T> String toJson(T obj) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return gson2.toJson(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T> T fromJson(JsonReader json, Type type) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return (T) gson2.fromJson(json, type);
        } catch (Exception unused) {
            return null;
        }
    }

    public final <T> List<T> fromJsonToList(String jsonString, Type type) {
        try {
            Gson gson2 = gson;
            if (gson2 == null) {
                Intrinsics.throwNpe();
            }
            return (List) gson2.fromJson(jsonString, type);
        } catch (Exception unused) {
            return null;
        }
    }
}
