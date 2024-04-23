/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json;

import com.mycompany.entities.Propietario;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author adria
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class PropReader implements MessageBodyReader<Propietario> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Propietario.class.isAssignableFrom(type);
    }

    @Override
    public Propietario readFrom(Class<Propietario> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream)
            throws IOException, WebApplicationException {
        Propietario propietario = new Propietario();
        JsonParser parser = Json.createParser(entityStream);
        while (parser.hasNext()) {
            switch (parser.next()) {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                        case "nombreEspacio":
                            propietario.setNombreespacio(parser.getString());
                            break;
                        case "email":
                            propietario.setEmail(parser.getString());
                            break;
                        case "password":
                            propietario.setPassword(parser.getString());
                            break;
                        case "cif":
                            propietario.setCif(parser.getString());
                            break;
                        case "domicilioSocial":
                            propietario.setDomiciliosocial(parser.getString());
                            break;
                        case "telefono":
                            propietario.setTelefono(parser.getInt());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        return propietario;
    }

}
