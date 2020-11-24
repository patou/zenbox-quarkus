package fr.zenika;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/evenements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementController {

    @GET
    public List<Evenement> getEvenements(){
        return Evenement.listAll();
    }

    @GET
    @Path("nom/{nom}")
    public Evenement getEvenementsByNom(@PathParam("nom") String nom){
        return Evenement.findByNom(nom);
    }

    @GET
    @Path("/{id}")
    public Evenement getEvenement(@PathParam("id") Long id){
        return Evenement.findById(id);
    }


    @DELETE
    @Transactional
    @Path("{id}")
    public boolean deleteEvenement(@PathParam("id") Long id){
        return Evenement.deleteById(id);
    }

    @POST
    @Transactional
    public Evenement add(Evenement evenement){
        evenement.persist();
        return evenement;
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Evenement putEvenement(@PathParam("id") Long id, Evenement evenement){
        evenement.persist();
        return evenement;
    }
}
