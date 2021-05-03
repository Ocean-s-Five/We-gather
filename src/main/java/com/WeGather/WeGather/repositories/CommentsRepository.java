package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {

}
