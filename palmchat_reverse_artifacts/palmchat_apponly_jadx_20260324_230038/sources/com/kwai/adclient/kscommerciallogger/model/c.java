package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private final d aAe;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private final String bjT;
        private BusinessType bjU;
        private SubBusinessType bjV;
        private d bjW;
        private JSONObject bjX;
        private String bjY;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.bjT = str;
        }

        public static a Vf() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Vg() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a B(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c Vh() {
            if (com.kwai.adclient.kscommerciallogger.a.UW().isDebug()) {
                if (TextUtils.isEmpty(this.bjT) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bjY)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.UW().UY() && !com.kwai.adclient.kscommerciallogger.b.id(this.bjY)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.bjT) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bjY)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.UW().UY() && !com.kwai.adclient.kscommerciallogger.b.id(this.bjY)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.UW().UX() != null) {
                this.bjX = com.kwai.adclient.kscommerciallogger.a.UW().UX();
            }
            return new c(this, (byte) 0);
        }

        public final a ie(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        /* JADX INFO: renamed from: if, reason: not valid java name */
        public final a m69if(@NonNull String str) {
            this.bjY = str;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.bjV = subBusinessType;
            return this;
        }

        public final a c(BusinessType businessType) {
            this.bjU = businessType;
            return this;
        }

        public final a b(d dVar) {
            this.bjW = dVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String UZ() {
        return this.category;
    }

    public final SubBusinessType Va() {
        return this.subBiz;
    }

    public final d Vb() {
        return this.aAe;
    }

    public final JSONObject Vc() {
        return this.msg;
    }

    public final JSONObject Vd() {
        return this.extraParam;
    }

    public final String Ve() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put("biz", businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.aAe;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private c(a aVar) {
        this.category = aVar.bjT;
        this.biz = aVar.bjU;
        this.subBiz = aVar.bjV;
        this.tag = aVar.mTag;
        this.aAe = aVar.bjW;
        this.extraParam = aVar.bjX;
        this.eventId = aVar.bjY;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }
}
