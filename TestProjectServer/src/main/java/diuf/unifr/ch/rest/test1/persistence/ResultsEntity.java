/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.persistence;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author <a href="mailto:andreas.ruppen@gmail.com">Andreas Ruppen</a>
 */
@Entity
@Table(name = "Results")
@NamedQueries({
    @NamedQuery(name = "ResultsEntity.findAll", query = "SELECT r FROM ResultsEntity r"),
    @NamedQuery(name = "ResultsEntity.findByIdResults", query = "SELECT r FROM ResultsEntity r WHERE r.idResults = :idResults"),
    @NamedQuery(name = "ResultsEntity.findByValueKey", query = "SELECT r FROM ResultsEntity r WHERE r.valueKey = :valueKey"),
    @NamedQuery(name = "ResultsEntity.findByValue", query = "SELECT r FROM ResultsEntity r WHERE r.value = :value"),
    @NamedQuery(name = "ResultsEntity.findByUnits", query = "SELECT r FROM ResultsEntity r WHERE r.units = :units")})
public class ResultsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idResults")
    @GeneratedValue
    private Integer idResults;
    @Size(max = 45)
    @Column(name = "value_key")
    private String valueKey;
    @Size(max = 45)
    @Column(name = "value")
    private String value;
    @Size(max = 45)
    @Column(name = "units")
    private String units;
    
    @Size(max = 45)
    @Column(name = "timestamp")
    private Long timestamp;
    
    @JoinColumn(name = "Analysis_idAnalysis", referencedColumnName = "idAnalysis")
    @ManyToOne(optional = false)
    private AnalysisEntity analysisidAnalysis;

    public ResultsEntity() {
    }

    public ResultsEntity(Integer idResults) {
        this.idResults = idResults;
    }

    public Integer getIdResults() {
        return idResults;
    }

    public void setIdResults(Integer idResults) {
        this.idResults = idResults;
    }

    public String getValueKey() {
        return valueKey;
    }

    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public AnalysisEntity getAnalysisidAnalysis() {
        return analysisidAnalysis;
    }

    public void setAnalysisidAnalysis(AnalysisEntity analysisidAnalysis) {
        this.analysisidAnalysis = analysisidAnalysis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResults != null ? idResults.hashCode() : 0);
        return hash;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultsEntity)) {
            return false;
        }
        ResultsEntity other = (ResultsEntity) object;
        if ((this.idResults == null && other.idResults != null) || (this.idResults != null && !this.idResults.equals(other.idResults))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.homelinux.digsim.ehealth.persistence.ResultsEntity[ idResults=" + idResults + " ]";
    }

}
