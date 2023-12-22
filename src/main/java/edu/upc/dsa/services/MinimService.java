package edu.upc.dsa.services;

import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.models.Mensaje;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/minim2", description = "Endpoint to Minim Service")
@Path("/")
public class MinimService {
    private JuegoManager jm;

    public MinimService() {
        this.jm = JuegoManagerImpl.getInstance();
        /////////////////////////////////////////////MINIM 2 22/12/2023//////////////////////////////////////////
        List<Mensaje> mensajesPredeterminados = new LinkedList<>();
        mensajesPredeterminados.add(new Mensaje("Bienvenido a Pollopeta"));
        mensajesPredeterminados.add(new Mensaje("Espero que le guste el juego, que se divierta!"));
        jm.addMensajesGenerales(mensajesPredeterminados);
    }

    @GET
    @ApiOperation(value = "get all system messages", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Mensaje.class, responseContainer="List"),
    })
    //en el swagger se ve la ruta /usuario/posts get all system messages porque está en el UsuarioService

    @Path("/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMensajesGenerales() {
        List<Mensaje> mensajes = this.jm.getMensajesGenerales();

        GenericEntity<List<Mensaje>> entity = new GenericEntity<List<Mensaje>>(mensajes) {};
        return Response.status(201).entity(entity).build();
    }
}
