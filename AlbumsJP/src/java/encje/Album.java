/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tomi
 */
@Entity
@Table(name = "ALBUMY")
public class Album {
    
    private String title;
    
    @ManyToOne
    private Performer performer;
    
    private int albumYear;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Album[ id=" + getId() + " ]";
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the performer
     */
    public Performer getPerformer() {
        return performer;
    }

    /**
     * @param performer the performer to set
     */
    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    /**
     * @return the albumYear
     */
    public int getAlbumYear() {
        return albumYear;
    }

    /**
     * @param albumYear the albumYear to set
     */
    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }
    
}
