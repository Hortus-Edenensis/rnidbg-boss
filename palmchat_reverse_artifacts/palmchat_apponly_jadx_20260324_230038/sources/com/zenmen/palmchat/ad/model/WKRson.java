package com.zenmen.palmchat.ad.model;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WKRson {
    private static final String TAG = "WKRson";

    private Object beanToJson(Object obj) throws IllegalAccessException, JSONException {
        if (obj.getClass().getSimpleName().equals("List") || obj.getClass().getSimpleName().equals("ArrayList")) {
            return listToJsonArray((List) obj);
        }
        List<Field> fields = getFields(obj.getClass());
        JSONObject jSONObject = new JSONObject();
        for (Field field : fields) {
            String name = field.getName();
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            if (field.getType().getSimpleName().equals("Integer") || field.getType().getSimpleName().equals("int") || field.getType().getSimpleName().equals("String") || field.getType().getSimpleName().equals("Boolean") || field.getType().getSimpleName().equals("boolean") || field.getType().getSimpleName().equals("Float") || field.getType().getSimpleName().equals("float") || field.getType().getSimpleName().equals("Long") || field.getType().getSimpleName().equals("long") || field.getType().getSimpleName().equals("Double") || field.getType().getSimpleName().equals("double")) {
                jSONObject.put(name, obj2);
            } else if (field.getType().getSimpleName().equals("List") || field.getType().getSimpleName().equals("ArrayList")) {
                if (obj2 == null) {
                    jSONObject.put(name, new JSONArray());
                } else {
                    jSONObject.put(name, listToJsonArray((List) obj2));
                }
            } else if (obj2 == null) {
                jSONObject.put(name, new JSONObject());
            } else {
                jSONObject.put(name, beanToJson(obj2));
            }
        }
        return jSONObject;
    }

    private List<Field> getFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && !"Object".equals(cls.getSimpleName())) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (!Modifier.isStatic(field.getModifiers()) && !field.getType().toString().contains("com.android.tools.ir.runtime") && !field.getType().toString().equals("class java.lang.Object")) {
                        arrayList.add(field);
                    } else if (field.getType().toString().equals("class java.lang.Object") && (field.getGenericType() instanceof TypeVariable)) {
                        arrayList.add(field);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private List<Object> jsonArrayToList(Type type, JSONArray jSONArray) throws JSONException, IllegalAccessException, InstantiationException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() >= 1) {
            String string = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType().toString() : type.toString();
            for (int i = 0; i < jSONArray.length(); i++) {
                if (string.equals("class java.lang.Integer")) {
                    arrayList.add(JSON.toInteger("", jSONArray.get(i)));
                } else if (string.equals("class java.lang.Boolean")) {
                    arrayList.add(JSON.toBoolean("", jSONArray.get(i)));
                } else if (string.equals("class java.lang.String")) {
                    arrayList.add(JSON.toString("", jSONArray.get(i)));
                } else if (string.equals("class java.lang.Long")) {
                    arrayList.add(JSON.toLong("", jSONArray.get(i)));
                } else if (string.equals("class java.lang.Float")) {
                    arrayList.add(JSON.toFloat("", jSONArray.get(i)));
                } else if (string.equals("class java.lang.Double")) {
                    arrayList.add(JSON.toDouble("", jSONArray.get(i)));
                } else if (string.equals("interface java.util.List") || string.equals("interface java.util.ArrayList")) {
                    arrayList.add(jsonArrayToList(((ParameterizedType) type).getActualTypeArguments()[0], jSONArray.getJSONArray(i)));
                } else {
                    arrayList.add(jsonToBean((Class) type, jSONArray.getJSONObject(i)));
                }
            }
        }
        return arrayList;
    }

    private Object jsonToBean(Class<?> cls, JSONObject jSONObject) throws IllegalAccessException, JSONException, InstantiationException {
        Class<?> type;
        Object objNewInstance = cls.newInstance();
        for (Field field : getFields(cls)) {
            String name = field.getName();
            if (jSONObject.has(name) && !jSONObject.isNull(name)) {
                String simpleName = field.getType().getSimpleName();
                Object obj = jSONObject.get(name);
                if (simpleName.equals("Integer") || simpleName.equals("int")) {
                    field.setAccessible(true);
                    field.set(objNewInstance, JSON.toInteger(name, obj));
                    field.setAccessible(false);
                } else if (simpleName.equals("Boolean") || simpleName.equals("boolean")) {
                    field.setAccessible(true);
                    field.set(objNewInstance, JSON.toBoolean(name, obj));
                    field.setAccessible(false);
                } else if (simpleName.equals("String")) {
                    field.setAccessible(true);
                    field.set(objNewInstance, JSON.toString(name, obj));
                    field.setAccessible(false);
                } else if (simpleName.equals("Float") || simpleName.equals("float")) {
                    field.setAccessible(true);
                    field.set(objNewInstance, JSON.toFloat(name, obj));
                    field.setAccessible(false);
                } else if (simpleName.equals("Double") || simpleName.equals("double")) {
                    field.setAccessible(true);
                    field.set(objNewInstance, JSON.toDouble(name, obj));
                    field.setAccessible(false);
                } else if (simpleName.equals("Long") || simpleName.equals("long")) {
                    field.setAccessible(true);
                    field.set(objNewInstance, JSON.toLong(name, obj));
                    field.setAccessible(false);
                } else if (simpleName.equals("List") || simpleName.equals("ArrayList")) {
                    List<Object> listJsonArrayToList = jsonArrayToList(((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0], jSONObject.getJSONArray(name));
                    field.setAccessible(true);
                    field.set(objNewInstance, listJsonArrayToList);
                    field.setAccessible(false);
                } else {
                    if (simpleName.equals("Object")) {
                        Type genericSuperclass = cls.getGenericSuperclass();
                        if (genericSuperclass instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                            if (type2 instanceof ParameterizedType) {
                                ParameterizedType parameterizedType = (ParameterizedType) type2;
                                String string = parameterizedType.getRawType().toString();
                                if (string.equals("interface java.util.List") || string.equals("interface java.util.ArrayList")) {
                                    List<Object> listJsonArrayToList2 = jsonArrayToList(parameterizedType.getActualTypeArguments()[0], jSONObject.getJSONArray(name));
                                    field.setAccessible(true);
                                    field.set(objNewInstance, listJsonArrayToList2);
                                    field.setAccessible(false);
                                } else {
                                    Log.e(TAG, "Not support " + string);
                                }
                            } else {
                                type = (Class) type2;
                            }
                        } else {
                            Log.e(TAG, "Not support " + genericSuperclass);
                        }
                    } else {
                        type = field.getType();
                    }
                    field.setAccessible(true);
                    field.set(objNewInstance, jsonToBean(type, jSONObject.getJSONObject(name)));
                    field.setAccessible(false);
                }
            }
        }
        return objNewInstance;
    }

    private JSONArray listToJsonArray(List<Object> list) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            Object obj = list.get(0);
            if (obj == null) {
                return jSONArray;
            }
            String simpleName = obj.getClass().getSimpleName();
            for (int i = 0; i < list.size(); i++) {
                if (simpleName.equals("Integer") || simpleName.equals("Boolean") || simpleName.equals("String") || simpleName.equals("Float") || simpleName.equals("Long") || simpleName.equals("Double")) {
                    jSONArray.put(list.get(i));
                } else if (simpleName.equals("List") || simpleName.equals("ArrayList")) {
                    jSONArray.put(listToJsonArray((List) list.get(i)));
                } else {
                    jSONArray.put(beanToJson(list.get(i)));
                }
            }
        }
        return jSONArray;
    }

    public synchronized <T> T fromJson(String str, Class<T> cls) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (T) jsonToBean(cls, new JSONObject(str));
        } catch (Exception e) {
            Log.e(TAG, "form json failed", e);
            return null;
        }
    }

    public synchronized <T> T fromJsonArray(String str, Class<T> cls) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (T) jsonArrayToList(cls, new JSONArray(str));
        } catch (Exception e) {
            Log.e(TAG, "form json failed", e);
            return null;
        }
    }

    public synchronized String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return beanToJson(obj).toString();
        } catch (Exception e) {
            Log.e(TAG, "to json failed", e);
            return "";
        }
    }
}
