/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json;

import com.mycompany.entities.Propietario;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author adria
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class PropWriter implements MessageBodyWriter<Propietario> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Propietario.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Propietario t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(Propietario propietario, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException, WebApplicationException {
        JsonGenerator gen = Json.createGenerator(entityStream);
        gen.writeStartObject()
                .write("nombreEspacio", propietario.getNombreespacio())
                .write("email", propietario.getEmail())
                .write("password", propietario.getPassword())
                .write("cif", propietario.getCif())
                .write("domicilioSocial", propietario.getDomiciliosocial())
                .write("telefono", propietario.getTelefono())
                .writeEnd();
        gen.flush();
    }

}
