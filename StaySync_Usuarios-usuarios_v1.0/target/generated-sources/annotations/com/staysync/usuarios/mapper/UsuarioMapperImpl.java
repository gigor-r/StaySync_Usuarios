package com.staysync.usuarios.mapper;

import com.staysync.usuarios.dto.request.ActualizarUsuarioRequest;
import com.staysync.usuarios.dto.request.RegistroRequest;
import com.staysync.usuarios.dto.response.UsuarioResponse;
import com.staysync.usuarios.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-15T14:54:25-0400",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(RegistroRequest request) {
        if ( request == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.apellido( request.getApellido() );
        usuario.email( request.getEmail() );
        usuario.nombre( request.getNombre() );
        usuario.rol( request.getRol() );
        usuario.telefono( request.getTelefono() );

        usuario.activo( true );

        return usuario.build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioResponse.UsuarioResponseBuilder usuarioResponse = UsuarioResponse.builder();

        usuarioResponse.activo( usuario.getActivo() );
        usuarioResponse.apellido( usuario.getApellido() );
        usuarioResponse.createdAt( usuario.getCreatedAt() );
        usuarioResponse.email( usuario.getEmail() );
        usuarioResponse.id( usuario.getId() );
        usuarioResponse.nombre( usuario.getNombre() );
        usuarioResponse.rol( usuario.getRol() );
        usuarioResponse.telefono( usuario.getTelefono() );
        usuarioResponse.updatedAt( usuario.getUpdatedAt() );

        return usuarioResponse.build();
    }

    @Override
    public void updateEntityFromRequest(Usuario usuario, ActualizarUsuarioRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getApellido() != null ) {
            usuario.setApellido( request.getApellido() );
        }
        if ( request.getNombre() != null ) {
            usuario.setNombre( request.getNombre() );
        }
        if ( request.getTelefono() != null ) {
            usuario.setTelefono( request.getTelefono() );
        }
    }
}
