package com.alkimin.jdbipractice.outbound.repository;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.AllowUnusedBindings;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;
import org.jdbi.v3.stringtemplate4.UseStringTemplateSqlLocator;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RegisterBeanMapper(Pub.class)
public interface    PubRepository {

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO public.pubs (id, name, state, city, county, address) VALUES (:id, :name, :state, :city, :county, :address);")
    UUID insert(@BindBean Pub pub);

    @SqlQuery("select * from public.pubs where id = :id;")
    Pub getById(@Bind("id") UUID id);

    /*    @SqlQuery("getByParameter")
     @RegisterBeanMapper(Pub.class)
     @UseStringTemplateSqlLocator*/
    /*@SqlQuery("SELECT id, name, state, city, county, address FROM public.pubs WHERE 1 = 1 "
            + "<if(state)> and state = :state <endif>"
            + "<if(city)> and city = :city <endif>"
            + "<if(county)> and county = :county <endif>"
    )*/
    @SqlQuery("select * from public.pubs <where>")
    @UseStringTemplateEngine
    @AllowUnusedBindings
    List<Pub> getByParameters(@Define("where") String where);
}
