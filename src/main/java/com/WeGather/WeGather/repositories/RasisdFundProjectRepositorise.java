package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.RaisedFundProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RasisdFundProjectRepositorise extends CrudRepository<RaisedFundProject,Long> {


    @Query("SELECT p FROM RaisedFundProject p WHERE search(:topic) = true")
    List<RaisedFundProject> search(@Param("topic")String s);

}
