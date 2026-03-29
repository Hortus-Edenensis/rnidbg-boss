package com.zenmen.find.bean;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.amap.api.maps2d.model.LatLng;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.palmchat.location.LocationEx;
import defpackage.bj5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class LoadCountBean implements BaseBean {
    public float clearAvatarMi;
    public float clearAvatarMiMySelf;
    public List<MarkerBean> nearbyAvatar;
    public int nearbyCount;
    public List<MarkerBean> nearbyList;
    public List<MarkerBean> nearbySchedule;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class MarkerBean {
        public static final int TYPE_AVATAR = 1;
        public static final int TYPE_GENDER = 0;
        public static final int TYPE_TRIP = 2;
        public int age;
        public String avatar;
        public Bitmap avatarBitmap;
        public Bitmap avatarOldBitmap;
        public int beanType;
        private String createShow;
        public long createTime;
        public String distanceMi;
        private LocationEx ex;
        public int gender;
        public boolean isBlur;
        public int jobCode;
        private LatLng latLng;
        public double latitude;
        public double longitude;
        public String nickname;
        public String ornamentUrl;
        public String scheduleAddress;
        public long scheduleMomentTs;
        public long scheduleMomentTsV2;
        public String scheduleOrderId;
        public int scheduleTag;
        private String tripTag;
        private String tripTime;
        public long tripUnlockTime;
        public long uid;
        public int userKind;

        public String getCreateShow() {
            if (TextUtils.isEmpty(this.createShow)) {
                this.createShow = bj5.b().a().y(this.createTime);
            }
            return this.createShow;
        }

        public String getKey() {
            return this.uid + "" + this.isBlur;
        }

        public LatLng getLatLng() {
            if (this.latLng == null) {
                this.latLng = new LatLng(this.latitude, this.longitude);
            }
            return this.latLng;
        }

        public LocationEx getLocationEx() {
            if (this.ex == null) {
                LocationEx locationEx = new LocationEx();
                this.ex = locationEx;
                locationEx.setLatitude(this.latitude);
                this.ex.setLongitude(this.longitude);
            }
            return this.ex;
        }

        public String getTripTag() {
            if (this.tripTag == null) {
                this.tripTag = bj5.b().a().U(this.scheduleTag);
            }
            return this.tripTag;
        }

        public String getTripTime() {
            if (TextUtils.isEmpty(this.tripTime)) {
                this.tripTime = bj5.b().a().h(this.scheduleMomentTs);
            }
            return this.tripTime;
        }

        public String toString() {
            return "uid:" + this.uid + " gender:" + this.gender;
        }
    }
}
