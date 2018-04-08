/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facets;

import encje.Album;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tomi
 */
@Stateless
public class AlbumFacade extends AbstractFacade<Album> {

    @PersistenceContext(unitName = "AlbumsJPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlbumFacade() {
        super(Album.class);
    }
    
}
