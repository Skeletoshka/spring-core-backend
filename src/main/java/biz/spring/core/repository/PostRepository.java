package biz.spring.core.repository;

import biz.spring.core.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements TableRepository<Post> {
}
