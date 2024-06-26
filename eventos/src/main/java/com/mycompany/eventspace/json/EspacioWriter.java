/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.json;

import com.mycompany.eventspace.entities.Espacio;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
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
public class EspacioWriter implements MessageBodyWriter<Espacio> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Espacio.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Espacio t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(Espacio t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException, WebApplicationException {
        JsonGenerator gen = Json.createGenerator(entityStream);
        gen.writeStartObject()
                .write("nombre", t.getNombre())
                .write("ciudad", t.getCiudad())
                .write("direccion", t.getDireccion())
                .write("horarioini", t.getHorarioini())
                .write("horariofin", t.getHorariofin())
                .write("precio", t.getPrecio())
                .write("salones", t.getSalones())
                .writeEnd();
        gen.flush();
    }

}
