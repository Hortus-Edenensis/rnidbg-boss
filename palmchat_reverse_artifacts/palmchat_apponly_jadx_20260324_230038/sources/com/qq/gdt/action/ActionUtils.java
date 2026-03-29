package com.qq.gdt.action;

import com.qq.gdt.action.j.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ActionUtils {
    public static final String CONTENT_ID = "content_id";
    public static final String CONTENT_NAME = "content_name";
    public static final String CONTENT_NUMBER = "content_number";
    public static final String CONTENT_TYPE = "content_type";
    public static final String IS_SUCCESS = "is_success";
    public static final String IS_VIRTUAL_CURRENT = "is_virtual_currency";
    public static final String LEVEL = "level";
    public static final String METHOD = "method";
    public static final String PAYMENT_AMOUNT = "value";
    public static final String PAYMENT_CHANNEL = "payment_channel";
    public static final String QUEST_DESC = "quest_desc";
    public static final String QUEST_ID = "quest_id";
    public static final String QUEST_NAME = "quest_name";
    public static final String QUEST_NUMBER = "quest_number";
    public static final String QUEST_TYPE = "quest_type";
    public static final String RATE_VALUE = "rate_value";
    public static final String REAL_CURRENCY_TYPE = "real_currency_type";
    public static final String ROLE = "role";
    public static final String SHARE_CHANNEL = "share_channel";
    public static final String VIRTUAL_CURRENCY_TYPE = "virtual_currency_type";

    public static void onAddPaymentChannel(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(PAYMENT_CHANNEL, str);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction("ADD_PAYMENT", jSONObject);
    }

    public static void onAddToCart(String str, String str2, String str3, int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt("content_id", str3);
            jSONObject.putOpt(CONTENT_NUMBER, Integer.valueOf(i));
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.ADD_TO_CART, jSONObject);
    }

    public static void onBindAccount(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(METHOD, str);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction("BIND_ACCOUNT", jSONObject);
    }

    public static void onCheckout(String str, String str2, String str3, int i, boolean z, String str4, String str5, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt("content_id", str3);
            jSONObject.putOpt(CONTENT_NUMBER, Integer.valueOf(i));
            jSONObject.putOpt(IS_VIRTUAL_CURRENT, Boolean.valueOf(z));
            jSONObject.putOpt(VIRTUAL_CURRENCY_TYPE, str4);
            jSONObject.putOpt(REAL_CURRENCY_TYPE, str5);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z2));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.INITIATE_CHECKOUT, jSONObject);
    }

    public static void onCreateRole(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ROLE, str);
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction("CREATE_ROLE", jSONObject);
    }

    public static void onLogin(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(METHOD, str);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction("LOGIN", jSONObject);
    }

    public static void onPurchase(String str, String str2, String str3, int i, String str4, String str5, int i2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt("content_id", str3);
            jSONObject.putOpt(CONTENT_NUMBER, Integer.valueOf(i));
            jSONObject.putOpt(PAYMENT_CHANNEL, str4);
            jSONObject.putOpt(REAL_CURRENCY_TYPE, str5);
            jSONObject.putOpt(REAL_CURRENCY_TYPE, str5);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            jSONObject.putOpt(PAYMENT_AMOUNT, Integer.valueOf(i2));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.PURCHASE, jSONObject);
    }

    public static void onQuestFinish(String str, String str2, String str3, int i, String str4, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(QUEST_ID, str);
            jSONObject.putOpt(QUEST_TYPE, str2);
            jSONObject.putOpt(QUEST_NAME, str3);
            jSONObject.putOpt(QUEST_NUMBER, Integer.valueOf(i));
            jSONObject.putOpt(QUEST_DESC, str4);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction("QUEST", jSONObject);
    }

    public static void onRateApp(float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(RATE_VALUE, Float.valueOf(f));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.RATE, jSONObject);
    }

    public static void onRegister(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(METHOD, str);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.REGISTER, jSONObject);
    }

    public static void onShare(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(SHARE_CHANNEL, str);
            jSONObject.putOpt(IS_SUCCESS, Boolean.valueOf(z));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.SHARE, jSONObject);
    }

    public static void onUpdateLevel(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("level", Integer.valueOf(i));
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction("UPDATE_LEVEL", jSONObject);
    }

    public static void onViewContent(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt("content_id", str3);
            o.a(jSONObject.toString(), new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GDTAction.logAction(ActionType.VIEW_CONTENT, jSONObject);
    }
}
