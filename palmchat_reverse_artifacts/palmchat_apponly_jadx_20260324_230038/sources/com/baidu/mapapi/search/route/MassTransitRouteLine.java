package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MassTransitRouteLine extends RouteLine<TransitStep> {
    public static final Parcelable.Creator<MassTransitRouteLine> CREATOR = new a();
    private String i;
    private double j;
    private List<PriceInfo> k;
    private List<List<TransitStep>> l;

    /* JADX INFO: compiled from: SearchBox */
    public static class TransitStep extends RouteStep {
        public static final Parcelable.Creator<TransitStep> CREATOR = new a();
        private List<TrafficCondition> e;
        private LatLng f;
        private LatLng g;
        private TrainInfo h;
        private PlaneInfo i;
        private CoachInfo j;
        private BusInfo k;
        private StepVehicleInfoType l;
        private String m;
        private String n;

        /* JADX INFO: compiled from: SearchBox */
        public enum StepVehicleInfoType {
            ESTEP_TRAIN(1),
            ESTEP_PLANE(2),
            ESTEP_BUS(3),
            ESTEP_DRIVING(4),
            ESTEP_WALK(5),
            ESTEP_COACH(6);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f3805a;

            StepVehicleInfoType(int i) {
                this.f3805a = i;
            }

            public int getInt() {
                return this.f3805a;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class TrafficCondition implements Parcelable {
            public static final Parcelable.Creator<TrafficCondition> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f3806a;
            private int b;

            /* JADX INFO: compiled from: SearchBox */
            public static class a implements Parcelable.Creator<TrafficCondition> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public TrafficCondition createFromParcel(Parcel parcel) {
                    return new TrafficCondition(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public TrafficCondition[] newArray(int i) {
                    return new TrafficCondition[i];
                }
            }

            public TrafficCondition() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getTrafficGeoCnt() {
                return this.b;
            }

            public int getTrafficStatus() {
                return this.f3806a;
            }

            public void setTrafficGeoCnt(int i) {
                this.b = i;
            }

            public void setTrafficStatus(int i) {
                this.f3806a = i;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3806a);
                parcel.writeInt(this.b);
            }

            public TrafficCondition(Parcel parcel) {
                this.f3806a = parcel.readInt();
                this.b = parcel.readInt();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements Parcelable.Creator<TransitStep> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep createFromParcel(Parcel parcel) {
                return new TransitStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep[] newArray(int i) {
                return new TransitStep[i];
            }
        }

        public TransitStep() {
        }

        private List<LatLng> a(String str) {
            String[] strArrSplit;
            ArrayList arrayList = new ArrayList();
            String[] strArrSplit2 = str.split(x.aQ);
            if (strArrSplit2 != null) {
                for (String str2 : strArrSplit2) {
                    if (str2 != null && str2 != "" && (strArrSplit = str2.split(",")) != null && strArrSplit[1] != "" && strArrSplit[0] != "") {
                        LatLng latLng = new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            latLng = CoordTrans.baiduToGcj(latLng);
                        }
                        arrayList.add(latLng);
                    }
                }
            }
            return arrayList;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public BusInfo getBusInfo() {
            return this.k;
        }

        public CoachInfo getCoachInfo() {
            return this.j;
        }

        public LatLng getEndLocation() {
            return this.g;
        }

        public String getInstructions() {
            return this.m;
        }

        public PlaneInfo getPlaneInfo() {
            return this.i;
        }

        public LatLng getStartLocation() {
            return this.f;
        }

        public List<TrafficCondition> getTrafficConditions() {
            return this.e;
        }

        public TrainInfo getTrainInfo() {
            return this.h;
        }

        public StepVehicleInfoType getVehileType() {
            return this.l;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.n);
            }
            return this.mWayPoints;
        }

        public void setBusInfo(BusInfo busInfo) {
            this.k = busInfo;
        }

        public void setCoachInfo(CoachInfo coachInfo) {
            this.j = coachInfo;
        }

        public void setEndLocation(LatLng latLng) {
            this.g = latLng;
        }

        public void setInstructions(String str) {
            this.m = str;
        }

        public void setPathString(String str) {
            this.n = str;
        }

        public void setPlaneInfo(PlaneInfo planeInfo) {
            this.i = planeInfo;
        }

        public void setStartLocation(LatLng latLng) {
            this.f = latLng;
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            this.e = list;
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            this.h = trainInfo;
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            this.l = stepVehicleInfoType;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeTypedList(this.e);
            parcel.writeParcelable(this.f, i);
            parcel.writeParcelable(this.g, i);
            parcel.writeParcelable(this.h, i);
            parcel.writeParcelable(this.i, i);
            parcel.writeParcelable(this.j, i);
            parcel.writeParcelable(this.k, i);
            parcel.writeInt(this.l.getInt());
            parcel.writeString(this.m);
            parcel.writeString(this.n);
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            this.e = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.g = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.h = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.i = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.j = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
            this.k = (BusInfo) parcel.readParcelable(BusInfo.class.getClassLoader());
            switch (parcel.readInt()) {
                case 1:
                    this.l = StepVehicleInfoType.ESTEP_TRAIN;
                    break;
                case 2:
                    this.l = StepVehicleInfoType.ESTEP_PLANE;
                    break;
                case 3:
                    this.l = StepVehicleInfoType.ESTEP_BUS;
                    break;
                case 4:
                    this.l = StepVehicleInfoType.ESTEP_DRIVING;
                    break;
                case 5:
                    this.l = StepVehicleInfoType.ESTEP_WALK;
                    break;
                case 6:
                    this.l = StepVehicleInfoType.ESTEP_COACH;
                    break;
            }
            this.m = parcel.readString();
            this.n = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<MassTransitRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MassTransitRouteLine createFromParcel(Parcel parcel) {
            return new MassTransitRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MassTransitRouteLine[] newArray(int i) {
            return new MassTransitRouteLine[i];
        }
    }

    public MassTransitRouteLine() {
        this.l = null;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveTime() {
        return this.i;
    }

    public List<List<TransitStep>> getNewSteps() {
        return this.l;
    }

    public double getPrice() {
        return this.j;
    }

    public List<PriceInfo> getPriceInfo() {
        return this.k;
    }

    public void setArriveTime(String str) {
        this.i = str;
    }

    public void setNewSteps(List<List<TransitStep>> list) {
        this.l = list;
    }

    public void setPrice(double d) {
        this.j = d;
    }

    public void setPriceInfo(List<PriceInfo> list) {
        this.k = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        List<List<TransitStep>> list = this.l;
        parcel.writeInt(list == null ? 0 : list.size());
        parcel.writeString(this.i);
        parcel.writeDouble(this.j);
        parcel.writeTypedList(this.k);
        Iterator<List<TransitStep>> it = this.l.iterator();
        while (it.hasNext()) {
            parcel.writeTypedList(it.next());
        }
    }

    public MassTransitRouteLine(Parcel parcel) {
        super(parcel);
        this.l = null;
        int i = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readDouble();
        this.k = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (i > 0) {
            this.l = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                this.l.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
    }
}
