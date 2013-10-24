/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "Todos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TodosEntity.findAll", query = "SELECT t FROM TodosEntity t"),
    @NamedQuery(name = "TodosEntity.findById", query = "SELECT t FROM TodosEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TodosEntity.findByName", query = "SELECT t FROM TodosEntity t WHERE t.name = :name")})
public class TodosEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    
    @JoinTable(name = "Todos_Users", joinColumns = {
        @JoinColumn(name = "TodosEntity_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "UserEntity_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<UsersEntity> usersEntityCollection;

    public TodosEntity() {
    }

    public TodosEntity(Integer id) {
        this.id = id;
    }

    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Collection<UsersEntity> getUsersEntityCollection() {
        return usersEntityCollection;
    }

    public void setUsersEntityCollection(Collection<UsersEntity> usersEntityCollection) {
        this.usersEntityCollection = usersEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TodosEntity)) {
            return false;
        }
        TodosEntity other = (TodosEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "diuf.unifr.ch.rest.test1.persistence.TodosEntity[ id=" + id + " ]";
    }
    
}
