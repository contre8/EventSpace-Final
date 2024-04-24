/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json;

import com.mycompany.entities.Cliente;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.JsonValue;
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
public class CliWriter implements MessageBodyWriter<Cliente> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Cliente.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Cliente t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(Cliente cliente, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException, WebApplicationException {
        JsonGenerator gen = Json.createGenerator(entityStream);
        gen.writeStartObject()
                .write("nombre", cliente.getNombre())
                .write("apellido", cliente.getApellidos())
                .write("email", cliente.getEmail())
                .write("password", cliente.getPassword())
                .write("dni", cliente.getDni())
                .write("fechanacimiento", cliente.getFechanacimiento())
                .write("telefono", cliente.getTelefono())
                .writeEnd();
        gen.flush();
    }

}
