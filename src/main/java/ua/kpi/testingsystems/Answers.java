/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_sys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Katya
 */
@Entity
@Table(name = "answers")
@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a")})
public class Answers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "answ_id")
    private Long answId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "answ_text")
    private String answText;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answers")
    private Collection<SetQuestAnsw> setQuestAnswCollection;

    public Answers() {
    }

    public Answers(Long answId) {
        this.answId = answId;
    }

    public Answers(Long answId, String answText) {
        this.answId = answId;
        this.answText = answText;
    }

    public Long getAnswId() {
        return answId;
    }

    public void setAnswId(Long answId) {
        this.answId = answId;
    }

    public String getAnswText() {
        return answText;
    }

    public void setAnswText(String answText) {
        this.answText = answText;
    }

    public Collection<SetQuestAnsw> getSetQuestAnswCollection() {
        return setQuestAnswCollection;
    }

    public void setSetQuestAnswCollection(Collection<SetQuestAnsw> setQuestAnswCollection) {
        this.setQuestAnswCollection = setQuestAnswCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answId != null ? answId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answers)) {
            return false;
        }
        Answers other = (Answers) object;
        if ((this.answId == null && other.answId != null) || (this.answId != null && !this.answId.equals(other.answId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testing_sys.Answers[ answId=" + answId + " ]";
    }
    
}
