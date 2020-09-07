package com.integrateur.fesevent.dao;

import org.springframework.data.repository.CrudRepository;
import com.integrateur.fesevent.modules.Client;

public interface ClientRep extends CrudRepository<Client, Integer> {

}
