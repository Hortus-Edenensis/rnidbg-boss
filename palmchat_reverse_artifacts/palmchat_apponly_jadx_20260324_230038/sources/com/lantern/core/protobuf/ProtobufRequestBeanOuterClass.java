package com.lantern.core.protobuf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ProtobufRequestBeanOuterClass {

    /* JADX INFO: renamed from: com.lantern.core.protobuf.ProtobufRequestBeanOuterClass$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ProtobufRequestBean extends GeneratedMessageLite<ProtobufRequestBean, Builder> implements ProtobufRequestBeanOrBuilder {
        public static final int ANDROIDID_FIELD_NUMBER = 23;
        public static final int APPID_FIELD_NUMBER = 5;
        public static final int CAPBSSID_FIELD_NUMBER = 13;
        public static final int CAPSSID_FIELD_NUMBER = 12;
        public static final int CHANID_FIELD_NUMBER = 8;
        private static final ProtobufRequestBean DEFAULT_INSTANCE;
        public static final int DHID_FIELD_NUMBER = 1;
        public static final int IMEI_FIELD_NUMBER = 10;
        public static final int LANG_FIELD_NUMBER = 4;
        public static final int LATI_FIELD_NUMBER = 17;
        public static final int LONGI_FIELD_NUMBER = 16;
        public static final int MAC_FIELD_NUMBER = 6;
        public static final int MAPSP_FIELD_NUMBER = 18;
        public static final int NETMODEL_FIELD_NUMBER = 14;
        public static final int OID_FIELD_NUMBER = 20;
        public static final int ORIGCHANID_FIELD_NUMBER = 9;
        private static volatile Parser<ProtobufRequestBean> PARSER = null;
        public static final int PID_FIELD_NUMBER = 3;
        public static final int SN_FIELD_NUMBER = 21;
        public static final int SR_FIELD_NUMBER = 22;
        public static final int TS_FIELD_NUMBER = 15;
        public static final int UHID_FIELD_NUMBER = 2;
        public static final int USERTOKEN_FIELD_NUMBER = 19;
        public static final int VERCODE_FIELD_NUMBER = 7;
        public static final int VERNAME_FIELD_NUMBER = 11;
        private String dhid_ = "";
        private String uhid_ = "";
        private String pid_ = "";
        private String lang_ = "";
        private String appId_ = "";
        private String mac_ = "";
        private String verCode_ = "";
        private String chanId_ = "";
        private String origChanId_ = "";
        private String imei_ = "";
        private String verName_ = "";
        private String capSsid_ = "";
        private String capBssid_ = "";
        private String netModel_ = "";
        private String ts_ = "";
        private String longi_ = "";
        private String lati_ = "";
        private String mapSP_ = "";
        private String userToken_ = "";
        private String oid_ = "";
        private String sn_ = "";
        private String sr_ = "";
        private String androidId_ = "";

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder extends GeneratedMessageLite.Builder<ProtobufRequestBean, Builder> implements ProtobufRequestBeanOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAndroidId() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearAndroidId();
                return this;
            }

            public Builder clearAppId() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearAppId();
                return this;
            }

            public Builder clearCapBssid() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearCapBssid();
                return this;
            }

            public Builder clearCapSsid() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearCapSsid();
                return this;
            }

            public Builder clearChanId() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearChanId();
                return this;
            }

            public Builder clearDhid() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearDhid();
                return this;
            }

            public Builder clearImei() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearImei();
                return this;
            }

            public Builder clearLang() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearLang();
                return this;
            }

            public Builder clearLati() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearLati();
                return this;
            }

            public Builder clearLongi() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearLongi();
                return this;
            }

            public Builder clearMac() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearMac();
                return this;
            }

            public Builder clearMapSP() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearMapSP();
                return this;
            }

            public Builder clearNetModel() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearNetModel();
                return this;
            }

            public Builder clearOid() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearOid();
                return this;
            }

            public Builder clearOrigChanId() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearOrigChanId();
                return this;
            }

            public Builder clearPid() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearPid();
                return this;
            }

            public Builder clearSn() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearSn();
                return this;
            }

            public Builder clearSr() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearSr();
                return this;
            }

            public Builder clearTs() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearTs();
                return this;
            }

            public Builder clearUhid() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearUhid();
                return this;
            }

            public Builder clearUserToken() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearUserToken();
                return this;
            }

            public Builder clearVerCode() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearVerCode();
                return this;
            }

            public Builder clearVerName() {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).clearVerName();
                return this;
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getAndroidId() {
                return ((ProtobufRequestBean) this.instance).getAndroidId();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getAndroidIdBytes() {
                return ((ProtobufRequestBean) this.instance).getAndroidIdBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getAppId() {
                return ((ProtobufRequestBean) this.instance).getAppId();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getAppIdBytes() {
                return ((ProtobufRequestBean) this.instance).getAppIdBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getCapBssid() {
                return ((ProtobufRequestBean) this.instance).getCapBssid();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getCapBssidBytes() {
                return ((ProtobufRequestBean) this.instance).getCapBssidBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getCapSsid() {
                return ((ProtobufRequestBean) this.instance).getCapSsid();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getCapSsidBytes() {
                return ((ProtobufRequestBean) this.instance).getCapSsidBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getChanId() {
                return ((ProtobufRequestBean) this.instance).getChanId();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getChanIdBytes() {
                return ((ProtobufRequestBean) this.instance).getChanIdBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getDhid() {
                return ((ProtobufRequestBean) this.instance).getDhid();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getDhidBytes() {
                return ((ProtobufRequestBean) this.instance).getDhidBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getImei() {
                return ((ProtobufRequestBean) this.instance).getImei();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getImeiBytes() {
                return ((ProtobufRequestBean) this.instance).getImeiBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getLang() {
                return ((ProtobufRequestBean) this.instance).getLang();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getLangBytes() {
                return ((ProtobufRequestBean) this.instance).getLangBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getLati() {
                return ((ProtobufRequestBean) this.instance).getLati();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getLatiBytes() {
                return ((ProtobufRequestBean) this.instance).getLatiBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getLongi() {
                return ((ProtobufRequestBean) this.instance).getLongi();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getLongiBytes() {
                return ((ProtobufRequestBean) this.instance).getLongiBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getMac() {
                return ((ProtobufRequestBean) this.instance).getMac();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getMacBytes() {
                return ((ProtobufRequestBean) this.instance).getMacBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getMapSP() {
                return ((ProtobufRequestBean) this.instance).getMapSP();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getMapSPBytes() {
                return ((ProtobufRequestBean) this.instance).getMapSPBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getNetModel() {
                return ((ProtobufRequestBean) this.instance).getNetModel();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getNetModelBytes() {
                return ((ProtobufRequestBean) this.instance).getNetModelBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getOid() {
                return ((ProtobufRequestBean) this.instance).getOid();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getOidBytes() {
                return ((ProtobufRequestBean) this.instance).getOidBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getOrigChanId() {
                return ((ProtobufRequestBean) this.instance).getOrigChanId();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getOrigChanIdBytes() {
                return ((ProtobufRequestBean) this.instance).getOrigChanIdBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getPid() {
                return ((ProtobufRequestBean) this.instance).getPid();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getPidBytes() {
                return ((ProtobufRequestBean) this.instance).getPidBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getSn() {
                return ((ProtobufRequestBean) this.instance).getSn();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getSnBytes() {
                return ((ProtobufRequestBean) this.instance).getSnBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getSr() {
                return ((ProtobufRequestBean) this.instance).getSr();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getSrBytes() {
                return ((ProtobufRequestBean) this.instance).getSrBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getTs() {
                return ((ProtobufRequestBean) this.instance).getTs();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getTsBytes() {
                return ((ProtobufRequestBean) this.instance).getTsBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getUhid() {
                return ((ProtobufRequestBean) this.instance).getUhid();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getUhidBytes() {
                return ((ProtobufRequestBean) this.instance).getUhidBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getUserToken() {
                return ((ProtobufRequestBean) this.instance).getUserToken();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getUserTokenBytes() {
                return ((ProtobufRequestBean) this.instance).getUserTokenBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getVerCode() {
                return ((ProtobufRequestBean) this.instance).getVerCode();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getVerCodeBytes() {
                return ((ProtobufRequestBean) this.instance).getVerCodeBytes();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public String getVerName() {
                return ((ProtobufRequestBean) this.instance).getVerName();
            }

            @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
            public ByteString getVerNameBytes() {
                return ((ProtobufRequestBean) this.instance).getVerNameBytes();
            }

            public Builder setAndroidId(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setAndroidId(str);
                return this;
            }

            public Builder setAndroidIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setAndroidIdBytes(byteString);
                return this;
            }

            public Builder setAppId(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setAppId(str);
                return this;
            }

            public Builder setAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setAppIdBytes(byteString);
                return this;
            }

            public Builder setCapBssid(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setCapBssid(str);
                return this;
            }

            public Builder setCapBssidBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setCapBssidBytes(byteString);
                return this;
            }

            public Builder setCapSsid(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setCapSsid(str);
                return this;
            }

            public Builder setCapSsidBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setCapSsidBytes(byteString);
                return this;
            }

            public Builder setChanId(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setChanId(str);
                return this;
            }

            public Builder setChanIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setChanIdBytes(byteString);
                return this;
            }

            public Builder setDhid(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setDhid(str);
                return this;
            }

            public Builder setDhidBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setDhidBytes(byteString);
                return this;
            }

            public Builder setImei(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setImei(str);
                return this;
            }

            public Builder setImeiBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setImeiBytes(byteString);
                return this;
            }

            public Builder setLang(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setLang(str);
                return this;
            }

            public Builder setLangBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setLangBytes(byteString);
                return this;
            }

            public Builder setLati(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setLati(str);
                return this;
            }

            public Builder setLatiBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setLatiBytes(byteString);
                return this;
            }

            public Builder setLongi(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setLongi(str);
                return this;
            }

            public Builder setLongiBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setLongiBytes(byteString);
                return this;
            }

            public Builder setMac(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setMac(str);
                return this;
            }

            public Builder setMacBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setMacBytes(byteString);
                return this;
            }

            public Builder setMapSP(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setMapSP(str);
                return this;
            }

            public Builder setMapSPBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setMapSPBytes(byteString);
                return this;
            }

            public Builder setNetModel(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setNetModel(str);
                return this;
            }

            public Builder setNetModelBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setNetModelBytes(byteString);
                return this;
            }

            public Builder setOid(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setOid(str);
                return this;
            }

            public Builder setOidBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setOidBytes(byteString);
                return this;
            }

            public Builder setOrigChanId(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setOrigChanId(str);
                return this;
            }

            public Builder setOrigChanIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setOrigChanIdBytes(byteString);
                return this;
            }

            public Builder setPid(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setPid(str);
                return this;
            }

            public Builder setPidBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setPidBytes(byteString);
                return this;
            }

            public Builder setSn(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setSn(str);
                return this;
            }

            public Builder setSnBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setSnBytes(byteString);
                return this;
            }

            public Builder setSr(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setSr(str);
                return this;
            }

            public Builder setSrBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setSrBytes(byteString);
                return this;
            }

            public Builder setTs(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setTs(str);
                return this;
            }

            public Builder setTsBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setTsBytes(byteString);
                return this;
            }

            public Builder setUhid(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setUhid(str);
                return this;
            }

            public Builder setUhidBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setUhidBytes(byteString);
                return this;
            }

            public Builder setUserToken(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setUserToken(str);
                return this;
            }

            public Builder setUserTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setUserTokenBytes(byteString);
                return this;
            }

            public Builder setVerCode(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setVerCode(str);
                return this;
            }

            public Builder setVerCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setVerCodeBytes(byteString);
                return this;
            }

            public Builder setVerName(String str) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setVerName(str);
                return this;
            }

            public Builder setVerNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ProtobufRequestBean) this.instance).setVerNameBytes(byteString);
                return this;
            }

            private Builder() {
                super(ProtobufRequestBean.DEFAULT_INSTANCE);
            }
        }

        static {
            ProtobufRequestBean protobufRequestBean = new ProtobufRequestBean();
            DEFAULT_INSTANCE = protobufRequestBean;
            protobufRequestBean.makeImmutable();
        }

        private ProtobufRequestBean() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAndroidId() {
            this.androidId_ = getDefaultInstance().getAndroidId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppId() {
            this.appId_ = getDefaultInstance().getAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCapBssid() {
            this.capBssid_ = getDefaultInstance().getCapBssid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCapSsid() {
            this.capSsid_ = getDefaultInstance().getCapSsid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChanId() {
            this.chanId_ = getDefaultInstance().getChanId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDhid() {
            this.dhid_ = getDefaultInstance().getDhid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImei() {
            this.imei_ = getDefaultInstance().getImei();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLang() {
            this.lang_ = getDefaultInstance().getLang();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLati() {
            this.lati_ = getDefaultInstance().getLati();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLongi() {
            this.longi_ = getDefaultInstance().getLongi();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMac() {
            this.mac_ = getDefaultInstance().getMac();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMapSP() {
            this.mapSP_ = getDefaultInstance().getMapSP();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetModel() {
            this.netModel_ = getDefaultInstance().getNetModel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOid() {
            this.oid_ = getDefaultInstance().getOid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOrigChanId() {
            this.origChanId_ = getDefaultInstance().getOrigChanId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPid() {
            this.pid_ = getDefaultInstance().getPid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSn() {
            this.sn_ = getDefaultInstance().getSn();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSr() {
            this.sr_ = getDefaultInstance().getSr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTs() {
            this.ts_ = getDefaultInstance().getTs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUhid() {
            this.uhid_ = getDefaultInstance().getUhid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserToken() {
            this.userToken_ = getDefaultInstance().getUserToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVerCode() {
            this.verCode_ = getDefaultInstance().getVerCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVerName() {
            this.verName_ = getDefaultInstance().getVerName();
        }

        public static ProtobufRequestBean getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ProtobufRequestBean parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtobufRequestBean parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ProtobufRequestBean> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAndroidId(String str) {
            str.getClass();
            this.androidId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAndroidIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.androidId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppId(String str) {
            str.getClass();
            this.appId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.appId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapBssid(String str) {
            str.getClass();
            this.capBssid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapBssidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.capBssid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapSsid(String str) {
            str.getClass();
            this.capSsid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapSsidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.capSsid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanId(String str) {
            str.getClass();
            this.chanId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.chanId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDhid(String str) {
            str.getClass();
            this.dhid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDhidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.dhid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImei(String str) {
            str.getClass();
            this.imei_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImeiBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.imei_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLang(String str) {
            str.getClass();
            this.lang_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLangBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.lang_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLati(String str) {
            str.getClass();
            this.lati_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLatiBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.lati_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongi(String str) {
            str.getClass();
            this.longi_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongiBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.longi_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMac(String str) {
            str.getClass();
            this.mac_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMacBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mac_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMapSP(String str) {
            str.getClass();
            this.mapSP_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMapSPBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mapSP_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetModel(String str) {
            str.getClass();
            this.netModel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetModelBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.netModel_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOid(String str) {
            str.getClass();
            this.oid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.oid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOrigChanId(String str) {
            str.getClass();
            this.origChanId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOrigChanIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.origChanId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPid(String str) {
            str.getClass();
            this.pid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.pid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSn(String str) {
            str.getClass();
            this.sn_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSnBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sn_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSr(String str) {
            str.getClass();
            this.sr_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSrBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sr_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTs(String str) {
            str.getClass();
            this.ts_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTsBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.ts_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUhid(String str) {
            str.getClass();
            this.uhid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUhidBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.uhid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserToken(String str) {
            str.getClass();
            this.userToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserTokenBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerCode(String str) {
            str.getClass();
            this.verCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerCodeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.verCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerName(String str) {
            str.getClass();
            this.verName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerNameBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.verName_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtobufRequestBean();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ProtobufRequestBean protobufRequestBean = (ProtobufRequestBean) obj2;
                    this.dhid_ = visitor.visitString(!this.dhid_.isEmpty(), this.dhid_, !protobufRequestBean.dhid_.isEmpty(), protobufRequestBean.dhid_);
                    this.uhid_ = visitor.visitString(!this.uhid_.isEmpty(), this.uhid_, !protobufRequestBean.uhid_.isEmpty(), protobufRequestBean.uhid_);
                    this.pid_ = visitor.visitString(!this.pid_.isEmpty(), this.pid_, !protobufRequestBean.pid_.isEmpty(), protobufRequestBean.pid_);
                    this.lang_ = visitor.visitString(!this.lang_.isEmpty(), this.lang_, !protobufRequestBean.lang_.isEmpty(), protobufRequestBean.lang_);
                    this.appId_ = visitor.visitString(!this.appId_.isEmpty(), this.appId_, !protobufRequestBean.appId_.isEmpty(), protobufRequestBean.appId_);
                    this.mac_ = visitor.visitString(!this.mac_.isEmpty(), this.mac_, !protobufRequestBean.mac_.isEmpty(), protobufRequestBean.mac_);
                    this.verCode_ = visitor.visitString(!this.verCode_.isEmpty(), this.verCode_, !protobufRequestBean.verCode_.isEmpty(), protobufRequestBean.verCode_);
                    this.chanId_ = visitor.visitString(!this.chanId_.isEmpty(), this.chanId_, !protobufRequestBean.chanId_.isEmpty(), protobufRequestBean.chanId_);
                    this.origChanId_ = visitor.visitString(!this.origChanId_.isEmpty(), this.origChanId_, !protobufRequestBean.origChanId_.isEmpty(), protobufRequestBean.origChanId_);
                    this.imei_ = visitor.visitString(!this.imei_.isEmpty(), this.imei_, !protobufRequestBean.imei_.isEmpty(), protobufRequestBean.imei_);
                    this.verName_ = visitor.visitString(!this.verName_.isEmpty(), this.verName_, !protobufRequestBean.verName_.isEmpty(), protobufRequestBean.verName_);
                    this.capSsid_ = visitor.visitString(!this.capSsid_.isEmpty(), this.capSsid_, !protobufRequestBean.capSsid_.isEmpty(), protobufRequestBean.capSsid_);
                    this.capBssid_ = visitor.visitString(!this.capBssid_.isEmpty(), this.capBssid_, !protobufRequestBean.capBssid_.isEmpty(), protobufRequestBean.capBssid_);
                    this.netModel_ = visitor.visitString(!this.netModel_.isEmpty(), this.netModel_, !protobufRequestBean.netModel_.isEmpty(), protobufRequestBean.netModel_);
                    this.ts_ = visitor.visitString(!this.ts_.isEmpty(), this.ts_, !protobufRequestBean.ts_.isEmpty(), protobufRequestBean.ts_);
                    this.longi_ = visitor.visitString(!this.longi_.isEmpty(), this.longi_, !protobufRequestBean.longi_.isEmpty(), protobufRequestBean.longi_);
                    this.lati_ = visitor.visitString(!this.lati_.isEmpty(), this.lati_, !protobufRequestBean.lati_.isEmpty(), protobufRequestBean.lati_);
                    this.mapSP_ = visitor.visitString(!this.mapSP_.isEmpty(), this.mapSP_, !protobufRequestBean.mapSP_.isEmpty(), protobufRequestBean.mapSP_);
                    this.userToken_ = visitor.visitString(!this.userToken_.isEmpty(), this.userToken_, !protobufRequestBean.userToken_.isEmpty(), protobufRequestBean.userToken_);
                    this.oid_ = visitor.visitString(!this.oid_.isEmpty(), this.oid_, !protobufRequestBean.oid_.isEmpty(), protobufRequestBean.oid_);
                    this.sn_ = visitor.visitString(!this.sn_.isEmpty(), this.sn_, !protobufRequestBean.sn_.isEmpty(), protobufRequestBean.sn_);
                    this.sr_ = visitor.visitString(!this.sr_.isEmpty(), this.sr_, !protobufRequestBean.sr_.isEmpty(), protobufRequestBean.sr_);
                    this.androidId_ = visitor.visitString(!this.androidId_.isEmpty(), this.androidId_, true ^ protobufRequestBean.androidId_.isEmpty(), protobufRequestBean.androidId_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    this.dhid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 18:
                                    this.uhid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.pid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.lang_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 42:
                                    this.appId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.mac_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 58:
                                    this.verCode_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 66:
                                    this.chanId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 74:
                                    this.origChanId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 82:
                                    this.imei_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 90:
                                    this.verName_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 98:
                                    this.capSsid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 106:
                                    this.capBssid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 114:
                                    this.netModel_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 122:
                                    this.ts_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 130:
                                    this.longi_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 138:
                                    this.lati_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                                    this.mapSP_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 154:
                                    this.userToken_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 162:
                                    this.oid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 170:
                                    this.sn_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD /* 178 */:
                                    this.sr_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                                    this.androidId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                default:
                                    if (!codedInputStream.skipField(tag)) {
                                        z = true;
                                    }
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (ProtobufRequestBean.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                            break;
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getAndroidId() {
            return this.androidId_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getAndroidIdBytes() {
            return ByteString.copyFromUtf8(this.androidId_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getAppId() {
            return this.appId_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getCapBssid() {
            return this.capBssid_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getCapBssidBytes() {
            return ByteString.copyFromUtf8(this.capBssid_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getCapSsid() {
            return this.capSsid_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getCapSsidBytes() {
            return ByteString.copyFromUtf8(this.capSsid_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getChanId() {
            return this.chanId_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getChanIdBytes() {
            return ByteString.copyFromUtf8(this.chanId_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getDhid() {
            return this.dhid_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getDhidBytes() {
            return ByteString.copyFromUtf8(this.dhid_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getImei() {
            return this.imei_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getImeiBytes() {
            return ByteString.copyFromUtf8(this.imei_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getLang() {
            return this.lang_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getLangBytes() {
            return ByteString.copyFromUtf8(this.lang_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getLati() {
            return this.lati_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getLatiBytes() {
            return ByteString.copyFromUtf8(this.lati_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getLongi() {
            return this.longi_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getLongiBytes() {
            return ByteString.copyFromUtf8(this.longi_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getMac() {
            return this.mac_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getMacBytes() {
            return ByteString.copyFromUtf8(this.mac_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getMapSP() {
            return this.mapSP_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getMapSPBytes() {
            return ByteString.copyFromUtf8(this.mapSP_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getNetModel() {
            return this.netModel_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getNetModelBytes() {
            return ByteString.copyFromUtf8(this.netModel_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getOid() {
            return this.oid_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getOidBytes() {
            return ByteString.copyFromUtf8(this.oid_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getOrigChanId() {
            return this.origChanId_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getOrigChanIdBytes() {
            return ByteString.copyFromUtf8(this.origChanId_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getPid() {
            return this.pid_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getPidBytes() {
            return ByteString.copyFromUtf8(this.pid_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.dhid_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getDhid());
            if (!this.uhid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getUhid());
            }
            if (!this.pid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getPid());
            }
            if (!this.lang_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, getLang());
            }
            if (!this.appId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, getAppId());
            }
            if (!this.mac_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, getMac());
            }
            if (!this.verCode_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, getVerCode());
            }
            if (!this.chanId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, getChanId());
            }
            if (!this.origChanId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(9, getOrigChanId());
            }
            if (!this.imei_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(10, getImei());
            }
            if (!this.verName_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(11, getVerName());
            }
            if (!this.capSsid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(12, getCapSsid());
            }
            if (!this.capBssid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(13, getCapBssid());
            }
            if (!this.netModel_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(14, getNetModel());
            }
            if (!this.ts_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(15, getTs());
            }
            if (!this.longi_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(16, getLongi());
            }
            if (!this.lati_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(17, getLati());
            }
            if (!this.mapSP_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(18, getMapSP());
            }
            if (!this.userToken_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(19, getUserToken());
            }
            if (!this.oid_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(20, getOid());
            }
            if (!this.sn_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(21, getSn());
            }
            if (!this.sr_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(22, getSr());
            }
            if (!this.androidId_.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(23, getAndroidId());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getSn() {
            return this.sn_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getSnBytes() {
            return ByteString.copyFromUtf8(this.sn_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getSr() {
            return this.sr_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getSrBytes() {
            return ByteString.copyFromUtf8(this.sr_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getTs() {
            return this.ts_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getTsBytes() {
            return ByteString.copyFromUtf8(this.ts_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getUhid() {
            return this.uhid_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getUhidBytes() {
            return ByteString.copyFromUtf8(this.uhid_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getUserToken() {
            return this.userToken_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getUserTokenBytes() {
            return ByteString.copyFromUtf8(this.userToken_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getVerCode() {
            return this.verCode_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getVerCodeBytes() {
            return ByteString.copyFromUtf8(this.verCode_);
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public String getVerName() {
            return this.verName_;
        }

        @Override // com.lantern.core.protobuf.ProtobufRequestBeanOuterClass.ProtobufRequestBeanOrBuilder
        public ByteString getVerNameBytes() {
            return ByteString.copyFromUtf8(this.verName_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.dhid_.isEmpty()) {
                codedOutputStream.writeString(1, getDhid());
            }
            if (!this.uhid_.isEmpty()) {
                codedOutputStream.writeString(2, getUhid());
            }
            if (!this.pid_.isEmpty()) {
                codedOutputStream.writeString(3, getPid());
            }
            if (!this.lang_.isEmpty()) {
                codedOutputStream.writeString(4, getLang());
            }
            if (!this.appId_.isEmpty()) {
                codedOutputStream.writeString(5, getAppId());
            }
            if (!this.mac_.isEmpty()) {
                codedOutputStream.writeString(6, getMac());
            }
            if (!this.verCode_.isEmpty()) {
                codedOutputStream.writeString(7, getVerCode());
            }
            if (!this.chanId_.isEmpty()) {
                codedOutputStream.writeString(8, getChanId());
            }
            if (!this.origChanId_.isEmpty()) {
                codedOutputStream.writeString(9, getOrigChanId());
            }
            if (!this.imei_.isEmpty()) {
                codedOutputStream.writeString(10, getImei());
            }
            if (!this.verName_.isEmpty()) {
                codedOutputStream.writeString(11, getVerName());
            }
            if (!this.capSsid_.isEmpty()) {
                codedOutputStream.writeString(12, getCapSsid());
            }
            if (!this.capBssid_.isEmpty()) {
                codedOutputStream.writeString(13, getCapBssid());
            }
            if (!this.netModel_.isEmpty()) {
                codedOutputStream.writeString(14, getNetModel());
            }
            if (!this.ts_.isEmpty()) {
                codedOutputStream.writeString(15, getTs());
            }
            if (!this.longi_.isEmpty()) {
                codedOutputStream.writeString(16, getLongi());
            }
            if (!this.lati_.isEmpty()) {
                codedOutputStream.writeString(17, getLati());
            }
            if (!this.mapSP_.isEmpty()) {
                codedOutputStream.writeString(18, getMapSP());
            }
            if (!this.userToken_.isEmpty()) {
                codedOutputStream.writeString(19, getUserToken());
            }
            if (!this.oid_.isEmpty()) {
                codedOutputStream.writeString(20, getOid());
            }
            if (!this.sn_.isEmpty()) {
                codedOutputStream.writeString(21, getSn());
            }
            if (!this.sr_.isEmpty()) {
                codedOutputStream.writeString(22, getSr());
            }
            if (this.androidId_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(23, getAndroidId());
        }

        public static Builder newBuilder(ProtobufRequestBean protobufRequestBean) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(protobufRequestBean);
        }

        public static ProtobufRequestBean parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtobufRequestBean parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtobufRequestBean parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtobufRequestBean parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtobufRequestBean parseFrom(InputStream inputStream) throws IOException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtobufRequestBean parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtobufRequestBean parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtobufRequestBean parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ProtobufRequestBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ProtobufRequestBeanOrBuilder extends MessageLiteOrBuilder {
        String getAndroidId();

        ByteString getAndroidIdBytes();

        String getAppId();

        ByteString getAppIdBytes();

        String getCapBssid();

        ByteString getCapBssidBytes();

        String getCapSsid();

        ByteString getCapSsidBytes();

        String getChanId();

        ByteString getChanIdBytes();

        String getDhid();

        ByteString getDhidBytes();

        String getImei();

        ByteString getImeiBytes();

        String getLang();

        ByteString getLangBytes();

        String getLati();

        ByteString getLatiBytes();

        String getLongi();

        ByteString getLongiBytes();

        String getMac();

        ByteString getMacBytes();

        String getMapSP();

        ByteString getMapSPBytes();

        String getNetModel();

        ByteString getNetModelBytes();

        String getOid();

        ByteString getOidBytes();

        String getOrigChanId();

        ByteString getOrigChanIdBytes();

        String getPid();

        ByteString getPidBytes();

        String getSn();

        ByteString getSnBytes();

        String getSr();

        ByteString getSrBytes();

        String getTs();

        ByteString getTsBytes();

        String getUhid();

        ByteString getUhidBytes();

        String getUserToken();

        ByteString getUserTokenBytes();

        String getVerCode();

        ByteString getVerCodeBytes();

        String getVerName();

        ByteString getVerNameBytes();
    }

    private ProtobufRequestBeanOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
