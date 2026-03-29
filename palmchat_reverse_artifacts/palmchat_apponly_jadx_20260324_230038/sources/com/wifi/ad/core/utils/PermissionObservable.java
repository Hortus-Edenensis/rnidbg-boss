package com.wifi.ad.core.utils;

import java.util.Observable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PermissionObservable extends Observable {

    /* JADX INFO: compiled from: SearchBox */
    public static class Holder {
        private static PermissionObservable manager = new PermissionObservable();

        private Holder() {
        }
    }

    public static PermissionObservable getInstance() {
        return Holder.manager;
    }

    public void notifyPermission(PermissionMsg permissionMsg) {
        setChanged();
        notifyObservers(permissionMsg);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PermissionMsg {
        public boolean granted;
        public int type;

        public PermissionMsg(int i) {
            this.granted = false;
            this.type = i;
        }

        public PermissionMsg(int i, boolean z) {
            this.type = i;
            this.granted = z;
        }
    }
}
