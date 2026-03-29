package com.wifi.ad.core.spstrategy;

import com.wifi.ad.core.config.EventParams;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\"\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\u001c\u0010;\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001aR\u001c\u0010>\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010\u001aR\u001c\u0010A\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010\u001aR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010\u001aR\u001a\u0010M\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR\u001a\u0010P\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\b¨\u0006S"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPModel;", "", "()V", "allNewSP", "", "getAllNewSP", "()I", "setAllNewSP", "(I)V", "allTimeOut", "getAllTimeOut", "setAllTimeOut", "allowRequestAd", "getAllowRequestAd", "setAllowRequestAd", "cachecfgModel", "Lcom/wifi/ad/core/spstrategy/SPCachecfgModel;", "getCachecfgModel", "()Lcom/wifi/ad/core/spstrategy/SPCachecfgModel;", "setCachecfgModel", "(Lcom/wifi/ad/core/spstrategy/SPCachecfgModel;)V", "exPids", "", "getExPids", "()Ljava/lang/String;", "setExPids", "(Ljava/lang/String;)V", "groupcfgModels", "", "Lcom/wifi/ad/core/spstrategy/SPGroupcfgModel;", "getGroupcfgModels", "()Ljava/util/List;", "setGroupcfgModels", "(Ljava/util/List;)V", "materialModel", "Lcom/wifi/ad/core/spstrategy/SPMaterialModel;", "getMaterialModel", "()Lcom/wifi/ad/core/spstrategy/SPMaterialModel;", "setMaterialModel", "(Lcom/wifi/ad/core/spstrategy/SPMaterialModel;)V", "mdaLogType", "getMdaLogType", "setMdaLogType", "parError", "getParError", "setParError", "pkCfgObject", "Lorg/json/JSONArray;", "getPkCfgObject", "()Lorg/json/JSONArray;", "setPkCfgObject", "(Lorg/json/JSONArray;)V", "requestId", "getRequestId", "setRequestId", "sdkCfgModels", "Lcom/wifi/ad/core/spstrategy/SPSdkcfgModel;", "getSdkCfgModels", "setSdkCfgModels", "sourceId", "getSourceId", "setSourceId", EventParams.KEY_STRATEGY_ID, "getStrategy_id", "setStrategy_id", EventParams.KEY_STRATEGY_VER, "getStrategy_ver", "setStrategy_ver", "switchModel", "Lcom/wifi/ad/core/spstrategy/SPSwitchModel;", "getSwitchModel", "()Lcom/wifi/ad/core/spstrategy/SPSwitchModel;", "setSwitchModel", "(Lcom/wifi/ad/core/spstrategy/SPSwitchModel;)V", "taiChiId", "getTaiChiId", "setTaiChiId", "updateTime", "getUpdateTime", "setUpdateTime", "userType", "getUserType", "setUserType", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPModel {
    private int allNewSP;
    private int allowRequestAd;
    private SPCachecfgModel cachecfgModel;
    private String exPids;
    private List<SPGroupcfgModel> groupcfgModels;
    private SPMaterialModel materialModel;
    private int mdaLogType;
    private String parError;
    private JSONArray pkCfgObject;
    private String requestId;
    private List<SPSdkcfgModel> sdkCfgModels;
    private String sourceId;
    private String strategy_id;
    private String strategy_ver;
    private SPSwitchModel switchModel;
    private String taiChiId;
    private int userType;
    private int updateTime = 60;
    private int allTimeOut = 4000;

    public final int getAllNewSP() {
        return this.allNewSP;
    }

    public final int getAllTimeOut() {
        return this.allTimeOut;
    }

    public final int getAllowRequestAd() {
        return this.allowRequestAd;
    }

    public final SPCachecfgModel getCachecfgModel() {
        return this.cachecfgModel;
    }

    public final String getExPids() {
        return this.exPids;
    }

    public final List<SPGroupcfgModel> getGroupcfgModels() {
        return this.groupcfgModels;
    }

    public final SPMaterialModel getMaterialModel() {
        return this.materialModel;
    }

    public final int getMdaLogType() {
        return this.mdaLogType;
    }

    public final String getParError() {
        return this.parError;
    }

    public final JSONArray getPkCfgObject() {
        return this.pkCfgObject;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final List<SPSdkcfgModel> getSdkCfgModels() {
        return this.sdkCfgModels;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getStrategy_id() {
        return this.strategy_id;
    }

    public final String getStrategy_ver() {
        return this.strategy_ver;
    }

    public final SPSwitchModel getSwitchModel() {
        return this.switchModel;
    }

    public final String getTaiChiId() {
        return this.taiChiId;
    }

    public final int getUpdateTime() {
        return this.updateTime;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final void setAllNewSP(int i) {
        this.allNewSP = i;
    }

    public final void setAllTimeOut(int i) {
        this.allTimeOut = i;
    }

    public final void setAllowRequestAd(int i) {
        this.allowRequestAd = i;
    }

    public final void setCachecfgModel(SPCachecfgModel sPCachecfgModel) {
        this.cachecfgModel = sPCachecfgModel;
    }

    public final void setExPids(String str) {
        this.exPids = str;
    }

    public final void setGroupcfgModels(List<SPGroupcfgModel> list) {
        this.groupcfgModels = list;
    }

    public final void setMaterialModel(SPMaterialModel sPMaterialModel) {
        this.materialModel = sPMaterialModel;
    }

    public final void setMdaLogType(int i) {
        this.mdaLogType = i;
    }

    public final void setParError(String str) {
        this.parError = str;
    }

    public final void setPkCfgObject(JSONArray jSONArray) {
        this.pkCfgObject = jSONArray;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setSdkCfgModels(List<SPSdkcfgModel> list) {
        this.sdkCfgModels = list;
    }

    public final void setSourceId(String str) {
        this.sourceId = str;
    }

    public final void setStrategy_id(String str) {
        this.strategy_id = str;
    }

    public final void setStrategy_ver(String str) {
        this.strategy_ver = str;
    }

    public final void setSwitchModel(SPSwitchModel sPSwitchModel) {
        this.switchModel = sPSwitchModel;
    }

    public final void setTaiChiId(String str) {
        this.taiChiId = str;
    }

    public final void setUpdateTime(int i) {
        this.updateTime = i;
    }

    public final void setUserType(int i) {
        this.userType = i;
    }
}
