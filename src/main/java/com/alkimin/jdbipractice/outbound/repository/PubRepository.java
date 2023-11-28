package com.alkimin.jdbipractice.outbound.repository;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RegisterBeanMapper(Pub.class)
public interface PubRepository {

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO public.pubs (id, name, state, city, county, address) VALUES (:id, :name, :state, :city, :county, :address);")
    UUID insert(@BindBean Pub pub);

    @SqlQuery("select * from public.pubs where id = :id;")
    Pub getById(@Bind("id") UUID id);
}
