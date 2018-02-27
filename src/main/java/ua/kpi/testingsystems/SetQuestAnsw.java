/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_sys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Katya
 */
@Entity
@Table(name = "set_quest_answ")
@NamedQueries({
    @NamedQuery(name = "SetQuestAnsw.findAll", query = "SELECT s FROM SetQuestAnsw s")})
public class SetQuestAnsw implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SetQuestAnswPK setQuestAnswPK;
    @Column(name = "a_status")
    private Boolean aStatus;
    @JoinColumn(name = "a_id", referencedColumnName = "answ_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Answers answers;
    @JoinColumn(name = "q_id", referencedColumnName = "q_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Questions questions;

    public SetQuestAnsw() {
    }

    public SetQuestAnsw(SetQuestAnswPK setQuestAnswPK) {
        this.setQuestAnswPK = setQuestAnswPK;
    }

    public SetQuestAnsw(long qId, long aId) {
        this.setQuestAnswPK = new SetQuestAnswPK(qId, aId);
    }

    public SetQuestAnswPK getSetQuestAnswPK() {
        return setQuestAnswPK;
    }

    public void setSetQuestAnswPK(SetQuestAnswPK setQuestAnswPK) {
        this.setQuestAnswPK = setQuestAnswPK;
    }

    public Boolean getAStatus() {
        return aStatus;
    }

    public void setAStatus(Boolean aStatus) {
        this.aStatus = aStatus;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setQuestAnswPK != null ? setQuestAnswPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetQuestAnsw)) {
            return false;
        }
        SetQuestAnsw other = (SetQuestAnsw) object;
        if ((this.setQuestAnswPK == null && other.setQuestAnswPK != null) || (this.setQuestAnswPK != null && !this.setQuestAnswPK.equals(other.setQuestAnswPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testing_sys.SetQuestAnsw[ setQuestAnswPK=" + setQuestAnswPK + " ]";
    }
    
}
