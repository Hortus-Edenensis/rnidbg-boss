package com.zenmen.palmchat.dating.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class DatingGroupToolBeans implements Serializable {
    private List<DatingGroupToolBean> addedList;
    private List<DatingGroupToolBean> customList;
    private List<DatingGroupToolBean> notAddedList;
    private List<DatingGroupToolBean> toolBeans;

    public void addToolsBean(DatingGroupToolBean datingGroupToolBean) {
        if (datingGroupToolBean == null) {
            return;
        }
        if (this.toolBeans == null) {
            this.toolBeans = new ArrayList();
        }
        this.toolBeans.add(datingGroupToolBean);
    }

    public List<DatingGroupToolBean> getAddedList() {
        return this.addedList;
    }

    public List<DatingGroupToolBean> getCustomList() {
        return this.customList;
    }

    public List<DatingGroupToolBean> getNotAddedList() {
        return this.notAddedList;
    }

    public List<DatingGroupToolBean> getToolBeans() {
        return this.toolBeans;
    }

    public void setAddedList(List<DatingGroupToolBean> list) {
        this.addedList = list;
    }

    public void setCustomList(List<DatingGroupToolBean> list) {
        this.customList = list;
    }

    public void setNotAddedList(List<DatingGroupToolBean> list) {
        this.notAddedList = list;
    }

    public void setToolBeans(List<DatingGroupToolBean> list) {
        this.toolBeans = list;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class DatingGroupToolBean implements Serializable {
        private String description;
        private String icon;
        private String id;
        private int isSystem;
        private int isUsed;
        private int state;
        private int systemToolClass;
        private String toolName;
        private String toolPage;

        public DatingGroupToolBean(int i) {
            this.isUsed = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DatingGroupToolBean datingGroupToolBean = (DatingGroupToolBean) obj;
            String str = this.id;
            return str != null && str.equals(datingGroupToolBean.id);
        }

        public String getDescription() {
            return this.description;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getId() {
            return this.id;
        }

        public int getIsSystem() {
            return this.isSystem;
        }

        public int getIsUsed() {
            return this.isUsed;
        }

        public int getState() {
            return this.state;
        }

        public int getSystemToolClass() {
            return this.systemToolClass;
        }

        public String getToolName() {
            return this.toolName;
        }

        public String getToolPage() {
            if (TextUtils.isEmpty(this.toolPage) || this.toolPage.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                return this.toolPage;
            }
            return "http://" + this.toolPage;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsSystem(int i) {
            this.isSystem = i;
        }

        public void setIsUsed(int i) {
            this.isUsed = i;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setSystemToolClass(int i) {
            this.systemToolClass = i;
        }

        public void setToolName(String str) {
            this.toolName = str;
        }

        public void setToolPage(String str) {
            this.toolPage = str;
        }

        public DatingGroupToolBean() {
        }
    }
}
