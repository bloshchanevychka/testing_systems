/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_sys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Katya
 */
@Embeddable
public class SetQuestAnswPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "q_id")
    private long qId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a_id")
    private long aId;

    public SetQuestAnswPK() {
    }

    public SetQuestAnswPK(long qId, long aId) {
        this.qId = qId;
        this.aId = aId;
    }

    public long getQId() {
        return qId;
    }

    public void setQId(long qId) {
        this.qId = qId;
    }

    public long getAId() {
        return aId;
    }

    public void setAId(long aId) {
        this.aId = aId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) qId;
        hash += (int) aId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetQuestAnswPK)) {
            return false;
        }
        SetQuestAnswPK other = (SetQuestAnswPK) object;
        if (this.qId != other.qId) {
            return false;
        }
        if (this.aId != other.aId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testing_sys.SetQuestAnswPK[ qId=" + qId + ", aId=" + aId + " ]";
    }
    
}
