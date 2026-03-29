package com.amap.api.services.geocoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class GeocodeQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3153a;
    private String b;
    private String c;

    public GeocodeQuery(String str, String str2) {
        this.f3153a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.b;
        if (str == null) {
            if (geocodeQuery.b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.b)) {
            return false;
        }
        String str2 = this.f3153a;
        if (str2 == null) {
            if (geocodeQuery.f3153a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f3153a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.b;
    }

    public String getCountry() {
        return this.c;
    }

    public String getLocationName() {
        return this.f3153a;
    }

    public int hashCode() {
        String str = this.b;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f3153a;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setCountry(String str) {
        this.c = str;
    }

    public void setLocationName(String str) {
        this.f3153a = str;
    }
}
