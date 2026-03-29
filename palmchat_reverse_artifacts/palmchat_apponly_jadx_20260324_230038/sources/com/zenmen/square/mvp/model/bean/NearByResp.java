package com.zenmen.square.mvp.model.bean;

import com.zenmen.listui.list.BaseBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByResp implements BaseBean {
    public Boolean driftExpire;
    public String driftExpireText;
    public List<NearByBean> nearbyList;
    public boolean needVip = false;
    public int remainFreeCount;
    public int unlockBy;

    /* JADX INFO: compiled from: SearchBox */
    public static class DriftBean {
        public boolean drift;
        public Boolean driftExpire;
        public String driftExpireText;
        public int remainFreeCount;
        public int unlockBy;

        public DriftBean(boolean z, Boolean bool, String str) {
            this.drift = z;
            this.driftExpire = bool;
            this.driftExpireText = str;
        }

        private boolean containsDrift() {
            return this.driftExpire != null;
        }

        private boolean isDriftExpire() {
            Boolean bool = this.driftExpire;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public String getShowDialogMsg() {
            if (this.drift && containsDrift() && isDriftExpire()) {
                return this.driftExpireText;
            }
            return null;
        }
    }

    public DriftBean getDriftBean(boolean z) {
        DriftBean driftBean = new DriftBean(z, this.driftExpire, this.driftExpireText);
        driftBean.unlockBy = this.unlockBy;
        driftBean.remainFreeCount = this.remainFreeCount;
        return driftBean;
    }
}
