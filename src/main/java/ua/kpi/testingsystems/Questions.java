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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "questions")
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "q_id")
    private Long qId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "q_text")
    private Object qText;
    @Size(max = 2147483647)
    @Column(name = "additional_info")
    private String additionalInfo;
    @JoinTable(name = "test_questions", joinColumns = {
        @JoinColumn(name = "q_id", referencedColumnName = "q_id")}, inverseJoinColumns = {
        @JoinColumn(name = "test_id", referencedColumnName = "test_id")})
    @ManyToMany
    private Collection<Test> testCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questions")
    private Collection<SetQuestAnsw> setQuestAnswCollection;

    public Questions() {
    }

    public Questions(Long qId) {
        this.qId = qId;
    }

    public Questions(Long qId, Object qText) {
        this.qId = qId;
        this.qText = qText;
    }

    public Long getQId() {
        return qId;
    }

    public void setQId(Long qId) {
        this.qId = qId;
    }

    public Object getQText() {
        return qText;
    }

    public void setQText(Object qText) {
        this.qText = qText;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
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
        hash += (qId != null ? qId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.qId == null && other.qId != null) || (this.qId != null && !this.qId.equals(other.qId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testing_sys.Questions[ qId=" + qId + " ]";
    }
    
}
