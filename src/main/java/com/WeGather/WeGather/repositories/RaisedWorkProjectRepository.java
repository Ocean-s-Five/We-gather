package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.CharityWorkContributors;
import com.WeGather.WeGather.models.Comments;
import com.WeGather.WeGather.models.RaisedWorkProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RaisedWorkProjectRepository extends JpaRepository<RaisedWorkProject, Long> {
    @Query(value = "SELECT users_id FROM  raised_work_project where id =?1", nativeQuery = true)
    public Long finUserName(Long id);

}
