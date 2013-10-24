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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.ReturnInsert;

/**
 *
 * @author <a href="mailto:andreas.ruppen@gmail.com">Andreas Ruppen</a>
 */
@Entity
@Table(name = "GuestBooks")
@NamedQueries({
    @NamedQuery(name = "GuestBook.all", query = "SELECT a FROM GuestBooksEntity a"),
    @NamedQuery(name = "GuestBook.find", query = "SELECT a FROM GuestBooksEntity a WHERE a.id = :id")
})

@XmlRootElement
public class GuestBooksEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public GuestBooksEntity() {
    }

    public GuestBooksEntity(Integer idGuestBooks) {
        this.id = idGuestBooks;
    }
    
    @XmlAttribute
    @ReturnInsert(returnOnly=true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer idGuestBooks) {
        this.id = idGuestBooks;
    }
    
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String patientid) {
        this.name = patientid;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuestBooksEntity)) {
            return false;
        }
        GuestBooksEntity other = (GuestBooksEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GuestBooksEntity[ id=" + id + ", name="+name+" ]";
    }

}
