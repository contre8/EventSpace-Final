package com.mycompany.entities;

import com.mycompany.entities.Propietario;
import com.mycompany.entities.ReservarEspacio;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-22T18:58:46")
@StaticMetamodel(Espacio.class)
public class Espacio_ { 

    public static volatile SingularAttribute<Espacio, String> horariofin;
    public static volatile SingularAttribute<Espacio, BigDecimal> precio;
    public static volatile SingularAttribute<Espacio, String> ciudad;
    public static volatile SingularAttribute<Espacio, Propietario> propietario;
    public static volatile SingularAttribute<Espacio, String> direccion;
    public static volatile CollectionAttribute<Espacio, ReservarEspacio> reservarEspacioCollection;
    public static volatile SingularAttribute<Espacio, String> nombreespacio;
    public static volatile SingularAttribute<Espacio, String> horarioini;
    public static volatile SingularAttribute<Espacio, Integer> id;
    public static volatile SingularAttribute<Espacio, Integer> numsalones;

}