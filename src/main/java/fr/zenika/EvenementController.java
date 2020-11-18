package fr.zenika;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.Month;
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
    @Path("/init")
    @Transactional
    public void init(){
        var evenement = new Evenement("Devfest Nantes", LocalDate.of(2021, Month.OCTOBER, 21), 2);
        evenement.persist();
        new Evenement("Devoxx", LocalDate.of(2021, Month.APRIL, 15), 3).persist();
    }
}
