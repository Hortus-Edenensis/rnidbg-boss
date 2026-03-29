package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.u.nr.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class s {
    final com.bytedance.sdk.component.widget.recycler.u.nr.u<RecyclerView.q, u> u = new com.bytedance.sdk.component.widget.recycler.u.nr.u<>();
    final com.bytedance.sdk.component.widget.recycler.u.nr.fx<RecyclerView.q> nr = new com.bytedance.sdk.component.widget.recycler.u.nr.fx<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void fx(RecyclerView.q qVar, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2);

        void nr(RecyclerView.q qVar, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2);

        void u(RecyclerView.q qVar);

        void u(RecyclerView.q qVar, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2);
    }

    public boolean b(RecyclerView.q qVar) {
        u uVar = this.u.get(qVar);
        return (uVar == null || (uVar.u & 4) == 0) ? false : true;
    }

    public RecyclerView.iz.nr fx(RecyclerView.q qVar) {
        return u(qVar, 8);
    }

    public void iz(RecyclerView.q qVar) {
        u uVar = this.u.get(qVar);
        if (uVar != null) {
            uVar.u &= -2;
        }
    }

    public void n(RecyclerView.q qVar) {
        iz(qVar);
    }

    public RecyclerView.iz.nr nr(RecyclerView.q qVar) {
        return u(qVar, 4);
    }

    public void pn(RecyclerView.q qVar) {
        u uVarU = this.u.get(qVar);
        if (uVarU == null) {
            uVarU = u.u();
            this.u.put(qVar, uVarU);
        }
        uVarU.u |= 1;
    }

    public void u() {
        this.u.clear();
        this.nr.fx();
    }

    public void x(RecyclerView.q qVar) {
        int iNr = this.nr.nr() - 1;
        while (true) {
            if (iNr < 0) {
                break;
            }
            if (qVar == this.nr.fx(iNr)) {
                this.nr.u(iNr);
                break;
            }
            iNr--;
        }
        u uVarRemove = this.u.remove(qVar);
        if (uVarRemove != null) {
            u.u(uVarRemove);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        static b.u<u> b = new b.nr(20);
        RecyclerView.iz.nr fx;
        RecyclerView.iz.nr nr;
        int u;

        private u() {
        }

        public static void nr() {
            while (b.u() != null) {
            }
        }

        public static u u() {
            u uVarU = b.u();
            return uVarU == null ? new u() : uVarU;
        }

        public static void u(u uVar) {
            uVar.u = 0;
            uVar.nr = null;
            uVar.fx = null;
            b.u(uVar);
        }
    }

    public void fx(RecyclerView.q qVar, RecyclerView.iz.nr nrVar) {
        u uVarU = this.u.get(qVar);
        if (uVarU == null) {
            uVarU = u.u();
            this.u.put(qVar, uVarU);
        }
        uVarU.fx = nrVar;
        uVarU.u |= 8;
    }

    public void nr(RecyclerView.q qVar, RecyclerView.iz.nr nrVar) {
        u uVarU = this.u.get(qVar);
        if (uVarU == null) {
            uVarU = u.u();
            this.u.put(qVar, uVarU);
        }
        uVarU.u |= 2;
        uVarU.nr = nrVar;
    }

    public void u(RecyclerView.q qVar, RecyclerView.iz.nr nrVar) {
        u uVarU = this.u.get(qVar);
        if (uVarU == null) {
            uVarU = u.u();
            this.u.put(qVar, uVarU);
        }
        uVarU.nr = nrVar;
        uVarU.u |= 4;
    }

    public void nr() {
        u.nr();
    }

    public boolean u(RecyclerView.q qVar) {
        u uVar = this.u.get(qVar);
        return (uVar == null || (uVar.u & 1) == 0) ? false : true;
    }

    private RecyclerView.iz.nr u(RecyclerView.q qVar, int i) {
        u uVarNr;
        RecyclerView.iz.nr nrVar;
        int iU = this.u.u(qVar);
        if (iU >= 0 && (uVarNr = this.u.nr(iU)) != null) {
            int i2 = uVarNr.u;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                uVarNr.u = i3;
                if (i == 4) {
                    nrVar = uVarNr.nr;
                } else if (i == 8) {
                    nrVar = uVarNr.fx;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.u.fx(iU);
                    u.u(uVarNr);
                }
                return nrVar;
            }
        }
        return null;
    }

    public void u(long j, RecyclerView.q qVar) {
        this.nr.nr(j, qVar);
    }

    public RecyclerView.q u(long j) {
        return this.nr.u(j);
    }

    public void u(nr nrVar) {
        for (int size = this.u.size() - 1; size >= 0; size--) {
            RecyclerView.q qVarU = this.u.u(size);
            u uVarFx = this.u.fx(size);
            int i = uVarFx.u;
            if ((i & 3) == 3) {
                nrVar.u(qVarU);
            } else if ((i & 1) != 0) {
                RecyclerView.iz.nr nrVar2 = uVarFx.nr;
                if (nrVar2 == null) {
                    nrVar.u(qVarU);
                } else {
                    nrVar.u(qVarU, nrVar2, uVarFx.fx);
                }
            } else if ((i & 14) == 14) {
                nrVar.nr(qVarU, uVarFx.nr, uVarFx.fx);
            } else if ((i & 12) == 12) {
                nrVar.fx(qVarU, uVarFx.nr, uVarFx.fx);
            } else if ((i & 4) != 0) {
                nrVar.u(qVarU, uVarFx.nr, null);
            } else if ((i & 8) != 0) {
                nrVar.nr(qVarU, uVarFx.nr, uVarFx.fx);
            }
            u.u(uVarFx);
        }
    }
}
