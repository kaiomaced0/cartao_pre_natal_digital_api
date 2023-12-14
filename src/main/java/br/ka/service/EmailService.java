package br.ka.service;

import br.ka.model.Usuario;
import br.ka.repository.UsuarioRepository;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.Mail;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class EmailService {

    @Inject
    Mailer mailer;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    HashService hashService;

    @Inject
    TokenJwtService tokenJwtService;


    public Boolean sendEmailWithCode(String emailAddress) {
        Usuario u = new Usuario();
        u = usuarioRepository.findByEmail(emailAddress);
        if(u != null){
            mailer.send(
                    Mail.withText(emailAddress,
                            "Seu Código de Acesso",
                            "Ola,\n\nAqui esta o seu codigo de acesso: " + hashService.getHashEmail(u.getId().toString()) + "\n\nAtenciosamente,\nEquipe Kaio Macedo")
            );
            return true;
        }

        return false;

    }

    public Response verifyCodigo(String emailAddress, String codigo) {
        Usuario u = new Usuario();
        u = usuarioRepository.findByEmail(emailAddress);
        if(u != null){
            String teste = hashService.getHashEmail(u.getId().toString());
            if(teste == codigo){
                return Response.ok()
                    .header("Authorization", tokenJwtService.generateJwt(u))
                    .build();
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();

    }
}
