package com.example.task_app_lab5.reposiory;
import com.example.task_app_lab5.model.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, Long> {
    List<Tasks> findByUserId(long id);
    List<Tasks> findByUserIdAndStatus(Long userId, String status);
    List<Tasks> findByUserIdAndCategoryId(Long userId, Long categoryId);

    List<Tasks> findByUserIdOrderByDueDateAsc(long id);
    Page<Tasks> findByTitleContainingIgnoreCase(@Param("title") String title, Pageable pageable);
    Page<Tasks> findByUserId(Long userId, Pageable pageable);
    Page<Tasks> findByUserIdAndCategoryId(Long userId, Long categoryId, Pageable pageable);
    Page<Tasks> findByUserIdAndStatus(Long userId, String status, Pageable pageable);

    Page<Tasks> findByUserIdAndTitleContainingIgnoreCase(Long userId, String search, Pageable pageable);
}
