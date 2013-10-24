/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.persistence;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author <a href="mailto:andreas.ruppen@gmail.com">Andreas Ruppen</a>
 */
@Entity
@Table(name = "Analysis")
@NamedQueries({
    @NamedQuery(name = "AnalysisEntity.findAll", query = "SELECT a FROM AnalysisEntity a"),
    @NamedQuery(name = "AnalysisEntity.findByIdAnalysis", query = "SELECT a FROM AnalysisEntity a WHERE a.idAnalysis = :idAnalysis"),
    @NamedQuery(name = "AnalysisEntity.findByPatientid", query = "SELECT a FROM AnalysisEntity a WHERE a.patientid = :patientid"),
    @NamedQuery(name = "AnalysisEntity.findByCaregiverid", query = "SELECT a FROM AnalysisEntity a WHERE a.caregiverid = :caregiverid"),
    @NamedQuery(name = "AnalysisEntity.findByStartdate", query = "SELECT a FROM AnalysisEntity a WHERE a.startdate = :startdate"),
    @NamedQuery(name = "AnalysisEntity.findByEnddate", query = "SELECT a FROM AnalysisEntity a WHERE a.enddate = :enddate")})
public class AnalysisEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAnalysis")
    private Integer idAnalysis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patientid")
    private int patientid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caregiverid")
    private int caregiverid;
    @Lob
    @Column(name = "input")
    private byte[] input;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar enddate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analysisidAnalysis")
    private Collection<ResultsEntity> resultsEntityCollection;

    public AnalysisEntity() {
    }

    public AnalysisEntity(Integer idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public AnalysisEntity(Integer idAnalysis, int patientid, int caregiverid) {
        this.idAnalysis = idAnalysis;
        this.patientid = patientid;
        this.caregiverid = caregiverid;
    }

    public Integer getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(Integer idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getCaregiverid() {
        return caregiverid;
    }

    public void setCaregiverid(int caregiverid) {
        this.caregiverid = caregiverid;
    }

    public byte[] getInput() {
        return input;
    }

    public void setInput(byte[] input) {
        this.input = input;
    }

    public Calendar getStartdate() {
        return startdate;
    }

    public void setStartdate(Calendar startdate) {
        this.startdate = startdate;
    }

    public Calendar getEnddate() {
        return enddate;
    }

    public void setEnddate(Calendar enddate) {
        this.enddate = enddate;
    }

    public Collection<ResultsEntity> getResultsEntityCollection() {
        return resultsEntityCollection;
    }

    public void setResultsEntityCollection(Collection<ResultsEntity> resultsEntityCollection) {
        this.resultsEntityCollection = resultsEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnalysis != null ? idAnalysis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnalysisEntity)) {
            return false;
        }
        AnalysisEntity other = (AnalysisEntity) object;
        if ((this.idAnalysis == null && other.idAnalysis != null) || (this.idAnalysis != null && !this.idAnalysis.equals(other.idAnalysis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.homelinux.digsim.ehealth.persistence.AnalysisEntity[ idAnalysis=" + idAnalysis + " ]";
    }

}
