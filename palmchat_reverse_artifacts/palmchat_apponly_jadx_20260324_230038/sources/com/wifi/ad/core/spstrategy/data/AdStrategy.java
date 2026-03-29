package com.wifi.ad.core.spstrategy.data;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Keep
public class AdStrategy {
    public String strategy_id = "";
    public String strategy_ver = "";
    public int update_interval = 0;
    public int timeout = 0;

    @SerializedName("switch")
    public Switch switchKey = null;
    public List<PkCfg> pk_cfg = null;
    public List<SdkCfg> sdk_cfg = null;
    public CacheCfg cache_cfg = null;
    public List<GroupCfg> group_cfg = null;
    public MaterialControl material_control = null;
    public int user_type = 0;
}
