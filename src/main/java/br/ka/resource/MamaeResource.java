package br.ka.resource;

import br.ka.dto.*;
import br.ka.model.EntityClass;
import br.ka.model.Mamae;
import br.ka.service.MamaeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/mamae")
public class MamaeResource {
    @Inject
    private MamaeService service;



    @GET
    public List<MamaeResponseDTO> getAll(){
        return service.findAll().stream().filter(EntityClass::getAtivo).map(mamae -> new MamaeResponseDTO(mamae)).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public MamaeResponseDTO getById(@PathParam("id") Long id) {

        return new MamaeResponseDTO(service.findById(id));
    }

    @GET
    @Path("/usuariologado")
    public Response getUsuarioLogado() {
        return service.getUsuarioLogado();

    }
    @GET
    @Path("/consultas")
    public Response getConsultas() {
        return service.getConsultas();

    }
    @GET
    @Path("/exames")
    public Response getExames() {
        return service.getExames();

    }

    @GET
    @Path("/nutricao")
    public Response getNutricao() {
        return service.getNutricao();

    }

    @GET
    @Path("/medico")
    public Response getMedico() {
        return service.getMedico();

    }

    @POST
    public Response create(UsuarioDTO usuarioDTO) {

        return service.insert(usuarioDTO);
    }

    @PATCH
    @Path("/mudarsenha")
    public Response mudarSenha(MudarSenhaDTO mudarSenhaDTO){
        return service.mudarSenha(mudarSenhaDTO);
    }

    @PATCH
    @Path("/convenio")
    public Response setConvenio(String convenio){
        return service.setConvenio(convenio);
    }

    @PATCH
    @Path("/mudardados")
    public Response mudarDadosMamae(MudarDadosMamaeDTO mudarDadosMamaeDTO){
        return service.mudarDadosMamae(mudarDadosMamaeDTO);
    }

    @POST
    @Path("/vacina")
    public Response insertVacina(VacinaDTO entity) {
        return service.insertVacina(entity);
    }


    @PUT
    @Path("/{id}")
    public Mamae update(@PathParam("id") Long id, Mamae entity) {
        return service.update(entity);
    }

    @PATCH
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteById(id);
    }
}
