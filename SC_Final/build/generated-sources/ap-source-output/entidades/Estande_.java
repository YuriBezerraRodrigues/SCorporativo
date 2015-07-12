package entidades;

import entidades.Categoria;
import entidades.Expositor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T12:16:00")
@StaticMetamodel(Estande.class)
public class Estande_ extends Entidade_ {

    public static volatile SingularAttribute<Estande, Categoria> estandecategoria;
    public static volatile CollectionAttribute<Estande, Expositor> expositorCollection;
    public static volatile SingularAttribute<Estande, String> nome;

}