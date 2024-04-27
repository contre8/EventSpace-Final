package com.mycompany.eventspace.entities;

import com.mycompany.eventspace.entities.ReservarEspacio;
import com.mycompany.eventspace.entities.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-28T01:38:09")
@StaticMetamodel(Espacio.class)
public class Espacio_ { 

    public static volatile SingularAttribute<Espacio, Date> fecha;
    public static volatile SingularAttribute<Espacio, String> horariofin;
    public static volatile SingularAttribute<Espacio, BigDecimal> precio;
    public static volatile SingularAttribute<Espacio, Integer> salones;
    public static volatile SingularAttribute<Espacio, String> ciudad;
    public static volatile SingularAttribute<Espacio, Users> propietario;
    public static volatile SingularAttribute<Espacio, String> direccion;
    public static volatile CollectionAttribute<Espacio, ReservarEspacio> reservarEspacioCollection;
    public static volatile SingularAttribute<Espacio, String> horarioini;
    public static volatile SingularAttribute<Espacio, Integer> id;
    public static volatile SingularAttribute<Espacio, String> nombre;

}