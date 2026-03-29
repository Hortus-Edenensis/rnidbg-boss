package org.jsoup.select;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends org.jsoup.select.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.jsoup.select.b f19852a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends d {
        public a(org.jsoup.select.b bVar) {
            this.f19852a = bVar;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            for (org.jsoup.nodes.f fVar3 : fVar2.n0()) {
                if (fVar3 != fVar2 && this.f19852a.a(fVar, fVar3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.f19852a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends d {
        public b(org.jsoup.select.b bVar) {
            this.f19852a = bVar;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarD;
            return (fVar == fVar2 || (fVarD = fVar2.D()) == null || !this.f19852a.a(fVar, fVarD)) ? false : true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.f19852a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends d {
        public c(org.jsoup.select.b bVar) {
            this.f19852a = bVar;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            org.jsoup.nodes.f fVarF0;
            return (fVar == fVar2 || (fVarF0 = fVar2.F0()) == null || !this.f19852a.a(fVar, fVarF0)) ? false : true;
        }

        public String toString() {
            return String.format(":prev%s", this.f19852a);
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1260d extends d {
        public C1260d(org.jsoup.select.b bVar) {
            this.f19852a = bVar;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return !this.f19852a.a(fVar, fVar2);
        }

        public String toString() {
            return String.format(":not%s", this.f19852a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends d {
        public e(org.jsoup.select.b bVar) {
            this.f19852a = bVar;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            if (fVar == fVar2) {
                return false;
            }
            for (org.jsoup.nodes.f fVarD = fVar2.D(); !this.f19852a.a(fVar, fVarD); fVarD = fVarD.D()) {
                if (fVarD == fVar) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", this.f19852a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends d {
        public f(org.jsoup.select.b bVar) {
            this.f19852a = bVar;
        }

        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            if (fVar == fVar2) {
                return false;
            }
            for (org.jsoup.nodes.f fVarF0 = fVar2.F0(); fVarF0 != null; fVarF0 = fVarF0.F0()) {
                if (this.f19852a.a(fVar, fVarF0)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", this.f19852a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends org.jsoup.select.b {
        @Override // org.jsoup.select.b
        public boolean a(org.jsoup.nodes.f fVar, org.jsoup.nodes.f fVar2) {
            return fVar == fVar2;
        }
    }
}
