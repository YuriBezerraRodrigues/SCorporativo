package entidades;

import entidades.Estande;
import entidades.Palco;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T12:16:00")
@StaticMetamodel(Categoria.class)
public class Categoria_ extends Entidade_ {

    public static volatile CollectionAttribute<Categoria, Estande> estandeCollection;
    public static volatile CollectionAttribute<Categoria, Palco> palcoCollection;
    public static volatile SingularAttribute<Categoria, String> nome;

}