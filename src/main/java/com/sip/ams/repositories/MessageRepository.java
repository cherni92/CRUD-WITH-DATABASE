package com.sip.ams.repositories;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
