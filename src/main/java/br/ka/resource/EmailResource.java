package br.ka.resource;


import br.ka.service.EmailService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/email")
public class EmailResource {

    @Inject
    EmailService emailService;

    @GET
    @Path("/send")
    public Response sendEmail(@QueryParam("email") String email) {
        ;
        if(emailService.sendEmailWithCode(email)){

            return Response.ok("E-mail enviado com sucesso!").build();
        }
        return Response.status(Response.Status.BAD_GATEWAY).build();
    }

    @GET
    @Path("/verify")
    public Response verifyCodigo(@QueryParam("email") String email, @QueryParam("codigo") String codigo) {
        return emailService.verifyCodigo(email, codigo);
    }


}