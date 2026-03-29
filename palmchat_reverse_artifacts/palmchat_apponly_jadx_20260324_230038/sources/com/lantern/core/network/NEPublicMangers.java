package com.lantern.core.network;

import com.lantern.core.business.IPubParams;
import com.lantern.core.business.ParamHelper;
import com.lantern.core.protobuf.ProtobufRequestBeanOuterClass;
import com.lantern.core.protobuf.SecurityParameterOuterClass;
import defpackage.wn1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NEPublicMangers {
    private static NEPublicMangers sInstance;
    public IPubParams mPubParams;

    public static NEPublicMangers getInstance() {
        if (sInstance == null) {
            sInstance = new NEPublicMangers();
        }
        return sInstance;
    }

    public byte[] getPublicParams() {
        if (this.mPubParams == null) {
            return null;
        }
        ProtobufRequestBeanOuterClass.ProtobufRequestBean.Builder builderNewBuilder = ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder();
        builderNewBuilder.setPid(wn1.a(this.mPubParams.getPid()));
        builderNewBuilder.setAppId(wn1.a(this.mPubParams.getAppId()));
        builderNewBuilder.setChanId(wn1.a(this.mPubParams.getChanId()));
        builderNewBuilder.setOrigChanId(wn1.a(this.mPubParams.getOrigChanId()));
        builderNewBuilder.setDhid(wn1.a(this.mPubParams.getDHID()));
        builderNewBuilder.setUhid(wn1.a(this.mPubParams.getUHID()));
        builderNewBuilder.setUserToken(wn1.a(this.mPubParams.getUserToken()));
        builderNewBuilder.setMapSP(wn1.a(this.mPubParams.getMapSp()));
        builderNewBuilder.setLongi(wn1.a(this.mPubParams.getLongi()));
        builderNewBuilder.setLati(wn1.a(this.mPubParams.getLati()));
        builderNewBuilder.setSn(wn1.a(this.mPubParams.getSN()));
        builderNewBuilder.setSr(wn1.a(this.mPubParams.getSR()));
        builderNewBuilder.setOid(wn1.a(this.mPubParams.getOid()));
        builderNewBuilder.setVerCode(String.valueOf(this.mPubParams.getVerCode()));
        builderNewBuilder.setVerName(wn1.a(this.mPubParams.getVerName()));
        builderNewBuilder.setImei(wn1.a(this.mPubParams.getIMEI()));
        builderNewBuilder.setLang(wn1.a(this.mPubParams.getLanguage()));
        builderNewBuilder.setTs(String.valueOf(this.mPubParams.getTs()));
        builderNewBuilder.setNetModel(wn1.a(this.mPubParams.getNetModel()));
        builderNewBuilder.setCapBssid(wn1.a(this.mPubParams.getBssid()));
        builderNewBuilder.setCapSsid(wn1.a(this.mPubParams.getSsid()));
        builderNewBuilder.setMac(wn1.a(this.mPubParams.getMac()));
        builderNewBuilder.setAndroidId(wn1.a(this.mPubParams.getAndroidId()));
        return builderNewBuilder.build().toByteArray();
    }

    public byte[] getSecurityParamsPBNew(String str) {
        SecurityParameterOuterClass.SecurityParameter.Builder builderNewBuilder = SecurityParameterOuterClass.SecurityParameter.newBuilder();
        IPubParams iPubParams = this.mPubParams;
        if (iPubParams != null) {
            builderNewBuilder.setAppId(wn1.a(iPubParams.getAppId()));
            builderNewBuilder.setDhid(wn1.a(this.mPubParams.getDHID()));
            builderNewBuilder.setChanId(wn1.a(this.mPubParams.getChanId()));
            builderNewBuilder.setLang(wn1.a(this.mPubParams.getLanguage()));
            builderNewBuilder.setImei("");
            builderNewBuilder.setVerCode(String.valueOf(this.mPubParams.getVerCode()));
        }
        builderNewBuilder.setKt(0);
        builderNewBuilder.setEt(str);
        builderNewBuilder.setKv(ParamHelper.getKv());
        return builderNewBuilder.build().toByteArray();
    }

    public void setPubParams(IPubParams iPubParams) {
        this.mPubParams = iPubParams;
    }
}
