package com.qiniu.android.http.serverRegion;

import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.dns.DnsPrefetcher;
import com.qiniu.android.http.dns.IDnsNetworkAddress;
import com.qiniu.android.http.networkStatus.UploadServerNetworkStatus;
import com.qiniu.android.http.request.IUploadRegion;
import com.qiniu.android.http.request.IUploadServer;
import com.qiniu.android.http.request.UploadRequestState;
import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadDomainRegion implements IUploadRegion {
    private static int Http3FrozenTime = 86400;
    private HashMap<String, UploadServerDomain> domainHashMap;
    private ArrayList<String> domainHostList;
    private boolean hasFreezeHost;
    private boolean http3Enabled;
    private boolean ipv6Enabled;
    private boolean isAllFrozen;
    private HashMap<String, UploadServerDomain> oldDomainHashMap;
    private ArrayList<String> oldDomainHostList;
    private UploadServerFreezeManager partialHttp2Freezer = new UploadServerFreezeManager();
    private UploadServerFreezeManager partialHttp3Freezer = new UploadServerFreezeManager();
    private ZoneInfo zoneInfo;

    /* JADX INFO: compiled from: SearchBox */
    public static class UploadIpGroup {
        private int addressIndex = -1;
        private final ArrayList<IDnsNetworkAddress> addressList;
        private final String groupType;

        public UploadIpGroup(String str, ArrayList<IDnsNetworkAddress> arrayList) {
            this.groupType = str;
            this.addressList = arrayList;
        }

        public IDnsNetworkAddress getNetworkAddress() {
            ArrayList<IDnsNetworkAddress> arrayList = this.addressList;
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            int i = this.addressIndex;
            if (i < 0 || i > this.addressList.size() - 1) {
                this.addressIndex = (int) (Math.random() * ((double) this.addressList.size()));
            }
            return this.addressList.get(this.addressIndex);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class UploadServerDomain {
        protected final String host;
        protected ArrayList<UploadIpGroup> ipGroupList = new ArrayList<>();

        /* JADX INFO: compiled from: SearchBox */
        public interface GetServerCondition {
            boolean condition(String str, UploadServer uploadServer, UploadServer uploadServer2);
        }

        public UploadServerDomain(String str) {
            this.host = str;
        }

        private void createIpGroupList() {
            List<IDnsNetworkAddress> inetAddressByHost;
            String ipType;
            ArrayList<UploadIpGroup> arrayList = this.ipGroupList;
            if ((arrayList != null && arrayList.size() > 0) || (inetAddressByHost = DnsPrefetcher.getInstance().getInetAddressByHost(this.host)) == null || inetAddressByHost.size() == 0) {
                return;
            }
            HashMap map = new HashMap();
            for (IDnsNetworkAddress iDnsNetworkAddress : inetAddressByHost) {
                String ipValue = iDnsNetworkAddress.getIpValue();
                if (ipValue != null && (ipType = Utils.getIpType(ipValue, this.host)) != null) {
                    ArrayList arrayList2 = (ArrayList) map.get(ipType);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(iDnsNetworkAddress);
                    map.put(ipType, arrayList2);
                }
            }
            ArrayList<UploadIpGroup> arrayList3 = new ArrayList<>();
            for (String str : map.keySet()) {
                arrayList3.add(new UploadIpGroup(str, (ArrayList) map.get(str)));
            }
            this.ipGroupList = arrayList3;
        }

        public synchronized void clearIpGroupList() {
            this.ipGroupList = null;
        }

        public UploadServer getOneServer() {
            ArrayList<UploadIpGroup> arrayList;
            String str = this.host;
            if (str == null || str.length() == 0) {
                return null;
            }
            synchronized (this) {
                arrayList = this.ipGroupList;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                String str2 = this.host;
                return new UploadServer(str2, str2, null, null, null);
            }
            IDnsNetworkAddress networkAddress = arrayList.get((int) (Math.random() * ((double) arrayList.size()))).getNetworkAddress();
            String str3 = this.host;
            return new UploadServer(str3, str3, networkAddress.getIpValue(), networkAddress.getSourceValue(), networkAddress.getTimestampValue());
        }

        public UploadServer getServer(GetServerCondition getServerCondition) {
            ArrayList<UploadIpGroup> arrayList;
            String str = this.host;
            UploadServer uploadServer = null;
            if (str == null || str.length() == 0) {
                return null;
            }
            synchronized (this) {
                ArrayList<UploadIpGroup> arrayList2 = this.ipGroupList;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    createIpGroupList();
                }
                arrayList = this.ipGroupList;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                String str2 = this.host;
                UploadServer uploadServer2 = new UploadServer(str2, str2, null, null, null);
                if (getServerCondition == null || getServerCondition.condition(this.host, null, uploadServer2)) {
                    return uploadServer2;
                }
                return null;
            }
            Iterator<UploadIpGroup> it = arrayList.iterator();
            while (it.hasNext()) {
                IDnsNetworkAddress networkAddress = it.next().getNetworkAddress();
                String str3 = this.host;
                UploadServer uploadServer3 = new UploadServer(str3, str3, networkAddress.getIpValue(), networkAddress.getSourceValue(), networkAddress.getTimestampValue());
                if (getServerCondition == null || getServerCondition.condition(this.host, uploadServer, uploadServer3)) {
                    uploadServer = uploadServer3;
                }
                if (getServerCondition == null) {
                    break;
                }
            }
            return uploadServer;
        }
    }

    private HashMap<String, UploadServerDomain> createDomainDictionary(List<String> list) {
        HashMap<String, UploadServerDomain> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            map.put(str, new UploadServerDomain(str));
        }
        return map;
    }

    private void freezeServerIfNeed(ResponseInfo responseInfo, IUploadServer iUploadServer) {
        if (responseInfo == null || iUploadServer == null || iUploadServer.getServerId() == null) {
            return;
        }
        String frozenType = UploadServerFreezeUtil.getFrozenType(iUploadServer.getHost(), iUploadServer.getIp());
        if (iUploadServer.isHttp3()) {
            if (responseInfo.isNotQiniu()) {
                this.hasFreezeHost = true;
                this.partialHttp3Freezer.freezeType(frozenType, GlobalConfiguration.getInstance().partialHostFrozenTime);
            }
            if (!responseInfo.canConnectToHost() || responseInfo.isHostUnavailable()) {
                this.hasFreezeHost = true;
                UploadServerFreezeUtil.globalHttp3Freezer().freezeType(frozenType, Http3FrozenTime);
                return;
            }
            return;
        }
        if (responseInfo.isNotQiniu() || !responseInfo.canConnectToHost() || responseInfo.isHostUnavailable()) {
            this.hasFreezeHost = true;
            LogUtil.i("partial freeze server host:" + StringUtils.toNonnullString(iUploadServer.getHost()) + " ip:" + StringUtils.toNonnullString(iUploadServer.getIp()));
            this.partialHttp2Freezer.freezeType(frozenType, GlobalConfiguration.getInstance().partialHostFrozenTime);
        }
        if (responseInfo.isHostUnavailable()) {
            this.hasFreezeHost = true;
            LogUtil.i("global freeze server host:" + StringUtils.toNonnullString(iUploadServer.getHost()) + " ip:" + StringUtils.toNonnullString(iUploadServer.getIp()));
            UploadServerFreezeUtil.globalHttp2Freezer().freezeType(frozenType, GlobalConfiguration.getInstance().globalHostFrozenTime);
        }
    }

    private void unfreezeServer(IUploadServer iUploadServer) {
        if (iUploadServer == null || iUploadServer.getServerId() == null) {
            return;
        }
        this.partialHttp2Freezer.unfreezeType(UploadServerFreezeUtil.getFrozenType(iUploadServer.getHost(), iUploadServer.getIp()));
    }

    @Override // com.qiniu.android.http.request.IUploadRegion
    public IUploadServer getNextServer(UploadRequestState uploadRequestState, ResponseInfo responseInfo, IUploadServer iUploadServer) {
        UploadServerDomain uploadServerDomain;
        UploadServerDomain uploadServerDomain2;
        ArrayList<String> arrayList;
        HashMap<String, UploadServerDomain> map;
        UploadServer oneServer = null;
        if (!this.isAllFrozen && uploadRequestState != null) {
            freezeServerIfNeed(responseInfo, iUploadServer);
            ArrayList<String> arrayList2 = this.domainHostList;
            HashMap<String, UploadServerDomain> map2 = this.domainHashMap;
            if (uploadRequestState.isUseOldServer() && (arrayList = this.oldDomainHostList) != null && arrayList.size() > 0 && (map = this.oldDomainHashMap) != null && map.size() > 0) {
                arrayList2 = this.oldDomainHostList;
                map2 = this.oldDomainHashMap;
            }
            if (this.http3Enabled && iUploadServer != null && iUploadServer.isHttp3()) {
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext() && ((uploadServerDomain2 = map2.get(it.next())) == null || (oneServer = (UploadServer) UploadServerNetworkStatus.getBetterNetworkServer(uploadServerDomain2.getServer(new UploadServerDomain.GetServerCondition() { // from class: com.qiniu.android.http.serverRegion.UploadDomainRegion.1
                    @Override // com.qiniu.android.http.serverRegion.UploadDomainRegion.UploadServerDomain.GetServerCondition
                    public boolean condition(String str, UploadServer uploadServer, UploadServer uploadServer2) {
                        String ip = uploadServer2 == null ? null : uploadServer2.getIp();
                        if ((UploadDomainRegion.this.ipv6Enabled || !Utils.isIpv6(ip)) && !UploadServerFreezeUtil.isTypeFrozenByFreezeManagers(UploadServerFreezeUtil.getFrozenType(str, ip), new UploadServerFreezeManager[]{UploadDomainRegion.this.partialHttp3Freezer, UploadServerFreezeUtil.globalHttp3Freezer()})) {
                            return UploadServerNetworkStatus.isServerNetworkBetter(uploadServer2, uploadServer);
                        }
                        return false;
                    }
                }), oneServer)) == null)) {
                }
                if (oneServer != null) {
                    oneServer.setHttpVersion(IUploadServer.HttpVersion3);
                    return oneServer;
                }
            }
            Iterator<String> it2 = arrayList2.iterator();
            while (it2.hasNext() && ((uploadServerDomain = map2.get(it2.next())) == null || (oneServer = (UploadServer) UploadServerNetworkStatus.getBetterNetworkServer(uploadServerDomain.getServer(new UploadServerDomain.GetServerCondition() { // from class: com.qiniu.android.http.serverRegion.UploadDomainRegion.2
                @Override // com.qiniu.android.http.serverRegion.UploadDomainRegion.UploadServerDomain.GetServerCondition
                public boolean condition(String str, UploadServer uploadServer, UploadServer uploadServer2) {
                    String ip = uploadServer2 == null ? null : uploadServer2.getIp();
                    if ((UploadDomainRegion.this.ipv6Enabled || !Utils.isIpv6(ip)) && !UploadServerFreezeUtil.isTypeFrozenByFreezeManagers(UploadServerFreezeUtil.getFrozenType(str, ip), new UploadServerFreezeManager[]{UploadDomainRegion.this.partialHttp2Freezer, UploadServerFreezeUtil.globalHttp2Freezer()})) {
                        return UploadServerNetworkStatus.isServerNetworkBetter(uploadServer2, uploadServer);
                    }
                    return false;
                }
            }), oneServer)) == null)) {
            }
            if (oneServer == null && !this.hasFreezeHost && arrayList2.size() > 0) {
                UploadServerDomain uploadServerDomain3 = map2.get(arrayList2.get((int) (Math.random() * ((double) arrayList2.size()))));
                if (uploadServerDomain3 != null) {
                    oneServer = uploadServerDomain3.getOneServer();
                }
                unfreezeServer(oneServer);
            }
            if (oneServer != null) {
                oneServer.setHttpVersion(IUploadServer.HttpVersion2);
                LogUtil.i("get server host:" + StringUtils.toNonnullString(oneServer.getHost()) + " ip:" + StringUtils.toNonnullString(oneServer.getIp()));
            } else {
                this.isAllFrozen = true;
                LogUtil.i("get server host:null ip:null");
            }
        }
        return oneServer;
    }

    @Override // com.qiniu.android.http.request.IUploadRegion
    public ZoneInfo getZoneInfo() {
        return this.zoneInfo;
    }

    @Override // com.qiniu.android.http.request.IUploadRegion
    public boolean isEqual(IUploadRegion iUploadRegion) {
        if (iUploadRegion == null) {
            return false;
        }
        if (iUploadRegion.getZoneInfo() == null && getZoneInfo() == null) {
            return true;
        }
        if (iUploadRegion.getZoneInfo() != null && getZoneInfo() != null) {
            if (iUploadRegion.getZoneInfo().getRegionId() == null && getZoneInfo().getRegionId() == null) {
                return true;
            }
            if (iUploadRegion.getZoneInfo().getRegionId() != null && getZoneInfo().getRegionId() != null && iUploadRegion.getZoneInfo().getRegionId().equals(getZoneInfo().getRegionId())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qiniu.android.http.request.IUploadRegion
    public boolean isValid() {
        return !this.isAllFrozen && (this.domainHostList.size() > 0 || this.oldDomainHostList.size() > 0);
    }

    @Override // com.qiniu.android.http.request.IUploadRegion
    public void setupRegionData(ZoneInfo zoneInfo) {
        if (zoneInfo == null) {
            return;
        }
        this.zoneInfo = zoneInfo;
        this.isAllFrozen = false;
        this.http3Enabled = false;
        this.ipv6Enabled = zoneInfo.ipv6;
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = zoneInfo.domains;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.domainHostList = arrayList;
        this.domainHashMap = createDomainDictionary(arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        List<String> list2 = zoneInfo.old_domains;
        if (list2 != null) {
            arrayList2.addAll(list2);
        }
        this.oldDomainHostList = arrayList2;
        this.oldDomainHashMap = createDomainDictionary(arrayList2);
        LogUtil.i("region :" + StringUtils.toNonnullString(arrayList));
        LogUtil.i("region old:" + StringUtils.toNonnullString(arrayList2));
    }

    @Override // com.qiniu.android.http.request.IUploadRegion
    public void updateIpListFormHost(String str) {
        UploadServerDomain uploadServerDomain;
        UploadServerDomain uploadServerDomain2;
        if (str == null) {
            return;
        }
        HashMap<String, UploadServerDomain> map = this.domainHashMap;
        if (map != null && map.get(str) != null && (uploadServerDomain2 = this.domainHashMap.get(str)) != null) {
            uploadServerDomain2.clearIpGroupList();
        }
        HashMap<String, UploadServerDomain> map2 = this.oldDomainHashMap;
        if (map2 == null || map2.get(str) == null || (uploadServerDomain = this.oldDomainHashMap.get(str)) == null) {
            return;
        }
        uploadServerDomain.clearIpGroupList();
    }
}
